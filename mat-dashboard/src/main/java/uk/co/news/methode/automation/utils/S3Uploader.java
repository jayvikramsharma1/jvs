package uk.co.news.methode.automation.utils;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListVersionsRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.VersionListing;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.amazonaws.services.s3.model.S3VersionSummary;

import uk.co.news.methode.automation.container.ManifestEntry;
import uk.co.news.methode.automation.container.ManifestModel;

public class S3Uploader {
	
	private static String manifestFile = Environment.getS3ReportPath() + Environment.getTitle()+"/"+Environment.getChannel()+"/" + "manifest.json";
	private static String s3URL = Environment.getS3URL().replace("methode/", "");
	private static BasicAWSCredentials creds = new BasicAWSCredentials(Environment.getS3ApiKey(), Environment.getS3ApiSecret());
	private static AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.EU_WEST_1)
								.withCredentials(new AWSStaticCredentialsProvider(creds)).build();
	
	public static String capture() throws Exception {
		Robot robot = new Robot();
		UUID uniqueName = UUID.randomUUID();
		String name = Environment.getS3MediaPath() + uniqueName + ".png";
		BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ImageIO.write(screenShot, "png", os);
		byte[] buffer = os.toByteArray();
		uploadImage(Environment.getS3Bucket(), name, buffer);
		return s3URL + name;
	}
	
	public static PutObjectResult uploadImage(String bucket, String key, byte[] stringToWrite) {
		ObjectMetadata meta = new ObjectMetadata();
		InputStream stream = new ByteArrayInputStream(stringToWrite);
		meta.setContentMD5(new String(com.amazonaws.util.Base64.encode(DigestUtils.md5(stringToWrite))));
		meta.setContentLength(stringToWrite.length);
		meta.setContentType("image/png");
		return s3Client.putObject(bucket, key, stream, meta);
	}
	
//	public static String uploadFile(String stringToWrite) {
//		ObjectMetadata meta = new ObjectMetadata();
//		UUID uniqueName = UUID.randomUUID();
//		String name = Environment.getS3ReportPath() + Environment.getTitle()+"/"+Environment.getChannel()+"/"+ uniqueName + ".json";
//		InputStream stream = new ByteArrayInputStream(stringToWrite.getBytes(StandardCharsets.UTF_8));
//		meta.setContentMD5(new String(com.amazonaws.util.Base64.encode(DigestUtils.md5(stringToWrite))));
//		meta.setContentLength(stringToWrite.length());
//		meta.setContentType("application/json");
//		s3Client.putObject(Environment.getS3Bucket(), name, stream, meta);
//		return s3URL + name;
//	}
	
	public static String uploadFile(String stringToWrite, UUID uniqueName) {
		ObjectMetadata meta = new ObjectMetadata();
		File file = new File("reports"+File.separator+uniqueName+".json");
		System.out.println(file.toString());
		String name = Environment.getS3ReportPath() + Environment.getTitle()+"/"+Environment.getChannel()+"/"+ uniqueName + ".json";
		
		try {
            System.out.println("Uploading a new object to S3 from a file\n");
    		s3Client.putObject(new PutObjectRequest(Environment.getS3Bucket(), name, file));


         } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
            		"means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which " +
            		"means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }
		
		return s3URL + name;
	}
	
	public static void uploadManifestFile(String stringToWrite) {
		ObjectMetadata meta = new ObjectMetadata();
		InputStream stream = new ByteArrayInputStream(stringToWrite.getBytes(StandardCharsets.UTF_8));
		meta.setContentMD5(new String(com.amazonaws.util.Base64.encode(DigestUtils.md5(stringToWrite))));
		meta.setContentLength(stringToWrite.length());
		meta.setContentType("application/json");
		s3Client.putObject(Environment.getS3Bucket(), manifestFile, stream, meta);
	}

	public static void updateManifest(ManifestEntry manifestEntry) throws IOException {
		addNewReport(manifestEntry);
	}
	
	private static InputStream downloadManifestFile() throws IOException {
		S3Object s3object = s3Client.getObject(new GetObjectRequest(Environment.getS3Bucket(), manifestFile));
		return s3object.getObjectContent();
	}
	
	private static void addNewReport(ManifestEntry manifestEntry) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		InputStream content = downloadManifestFile();
		String result = IOUtils.toString(content, StandardCharsets.UTF_8);
		ManifestModel manifest = mapper.readValue(result, ManifestModel.class);
		manifest.addEntry(manifestEntry);
		try {

			String updatedConent = mapper.writeValueAsString(manifest);
			uploadManifestFile(updatedConent);
			System.out.println(updatedConent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getS3Object(String keyName, Boolean versionStatus) throws IOException {
		String fileContent = null;
		if(versionStatus == true) {
			List<S3VersionSummary> s3RevisonId = getVersionsForS3File(keyName);
			for(S3VersionSummary s3VersionSummary : s3RevisonId) {
				fileContent = getS3FileFromVersion(keyName, s3VersionSummary.getVersionId());
				break;
			}
		} else {
			fileContent = getS3FileFromVersion(keyName, null);
		}
		return fileContent;
		
	}
	
	private static String getS3FileFromVersion( String keyName, String versionId) throws IOException {
		
		S3Object s3Object;
		
		if(versionId != null) {
			 s3Object = s3Client.getObject(new GetObjectRequest(Environment.getS3Bucket(), keyName, versionId));
		} else {
			 s3Object = s3Client.getObject(new GetObjectRequest(Environment.getS3Bucket(), keyName));
		}
		System.out.println(s3Object.getObjectMetadata().getContentType());
		InputStream input = s3Object.getObjectContent();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		StringBuffer fileContent = new StringBuffer();
		while(true) {
			String line = reader.readLine();
			if(line == null) break;
			fileContent.append(" " + line);
		}
		
		return fileContent.toString();
	}
	
	private static List<S3VersionSummary> getVersionsForS3File(String fileWithPrefix) {
		ListVersionsRequest vRequest = new ListVersionsRequest().withBucketName(Environment.getS3Bucket()).withMaxResults(2).withPrefix(fileWithPrefix);
		VersionListing versionListing = s3Client.listVersions(vRequest);
		return versionListing.getVersionSummaries();
	}
}
