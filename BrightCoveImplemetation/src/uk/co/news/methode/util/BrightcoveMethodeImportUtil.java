package uk.co.news.methode.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eidosmedia.wa.util.EomDb;

import EOM.File;
import EOM.PermissionDenied;
import EOM.RepositoryError;
import web.SessionData;

public class BrightcoveMethodeImportUtil {
	public static EomDb getEmoDb(HttpServletRequest request, HttpServletResponse response) {
		 String skey = request.getParameter("skey");
		 //String objLoid = request.getParameter("eomid");
		 SessionData sdata = SessionData.getSessionData(skey);
		 SessionData.refresh(request.getSession(), sdata);
		 return sdata.getEomDb();
	}
	
	@SuppressWarnings("deprecation")
	public static StringBuilder getBrightcoveMetadataXml(HttpServletRequest request, HttpServletResponse response) {
		 BufferedReader xmlMetadataBr = null;
		 String sCurrentLine = null;
		 StringBuilder content = new StringBuilder();
		 String servletFilePath = request.getRealPath(request.getServletPath());
		 String xmlFilePath = null;
		 if(servletFilePath.contains("/"))
			 xmlFilePath = servletFilePath.substring(0, (servletFilePath.lastIndexOf('/') - ("brightcove".length() + 1))) + "/WEB-INF/config/brightcove-metadata.xml";
		 else
			 xmlFilePath = servletFilePath.substring(0, (servletFilePath.lastIndexOf('\\') + 1)) + "/WEB-INF/config/brightcove-metadata.xml";
		  try {
		 	xmlMetadataBr = new BufferedReader(new FileReader(xmlFilePath));
		 	while ((sCurrentLine = xmlMetadataBr.readLine()) != null) {
		 		content.append(sCurrentLine);
		 	}
		 } catch(Exception e) {
		 	e.printStackTrace();
		 } finally {
		 	if(xmlMetadataBr != null)
				try {
					xmlMetadataBr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		 }
		return content;
	}
	
	public static String getVideoMetadata(String brightcoveId, String embargoedFlag, String flightTimeString, String competitionId) {
		String metadata = "";
		if(competitionId.equals("8")) {
			metadata="<!DOCTYPE metadata SYSTEM \"/SysConfig/Common/Classify/General/videostory.dtd\"><metadata><chp><brightcoveId>"+brightcoveId+"</brightcoveId><embargoedFlag>"+embargoedFlag+"</embargoedFlag><flightTimeString>"+flightTimeString+"</flightTimeString><COMPETITION_ID>"+competitionId+"</COMPETITION_ID><isSkySports>true</isSkySports><ACCOUNT_KEY>EPL2</ACCOUNT_KEY><PLAYER_ID>63f267a0aae8493e9a2393eb94951149</PLAYER_ID></chp></metadata>";
		} else {
			metadata="<!DOCTYPE metadata SYSTEM \"/SysConfig/Common/Classify/General/videostory.dtd\"><metadata><chp><brightcoveId>"+brightcoveId+"</brightcoveId><embargoedFlag>"+embargoedFlag+"</embargoedFlag><flightTimeString>"+flightTimeString+"</flightTimeString><COMPETITION_ID>"+competitionId+"</COMPETITION_ID><isSkySports>false</isSkySports></chp></metadata>";
		}
		return metadata;
	}
	
	public static String getImageMetadata(String brightcoveId) {
		return "<!DOCTYPE metadata SYSTEM \"/SysConfig/Common/Classify/General/image.dtd\"><metadata><chp></chp></metadata>";
	}
	
	public static String getFormatedBrightcoveMetadataXml(HttpServletRequest request, HttpServletResponse response, File imageFile) throws UnsupportedEncodingException, RepositoryError, PermissionDenied {
		 String enc  = getEncoding(request);
		 String videoName = URLDecoder.decode(request.getParameter("videoName"),enc);
		 String description = URLDecoder.decode(request.getParameter("description"), enc);
		 String fileref = "/" + String.join("/", imageFile.get_path()) + "?uuid=" + imageFile.get_uuid_string();
		 String groupheadUUID = UUID.randomUUID().toString();
		 String videoGroupUUID = UUID.randomUUID().toString();
		 String headlineUUID = UUID.randomUUID().toString();
		 String standfirstUUID = UUID.randomUUID().toString();
		 if(System.getenv("TITLE").equals("tim"))
			 return String.format(getBrightcoveMetadataXml(request, response).toString(), groupheadUUID, videoName, "", videoGroupUUID, UUID.randomUUID().toString(), fileref.replace(" ", "%20"), description, "");
		 else
			 return String.format(getBrightcoveMetadataXml(request, response).toString(), headlineUUID, videoName, standfirstUUID, "", videoGroupUUID, UUID.randomUUID().toString(), fileref.replace(" ", "%20"), description, "");
	}
	public static String getImagePath(File file) throws RepositoryError, PermissionDenied {
		String imagePath = String.join("/", file.get_path());
		 if(imagePath.contains("Media/Live")) {
			imagePath = imagePath.replace("Media/Live", "Images/Cropped");
		}
		 imagePath = "/" + imagePath.substring(0, imagePath.lastIndexOf('/')+1);
		 return imagePath;
	}
	
	public static byte[] getImageByteArray(HttpServletRequest request) throws MalformedURLException, IOException {
		ByteArrayOutputStream baosImageFile = null;
		baosImageFile = new ByteArrayOutputStream();
		String imageSrc = URLDecoder.decode(request.getParameter("imageSrc"), getEncoding(request));
		ImageIO.write(ImageIO.read(new URL(imageSrc)), "jpg", baosImageFile);
		return baosImageFile.toByteArray();
	}
	
	public static String getEncoding(HttpServletRequest request) {
		return request.getCharacterEncoding() != null ? request.getCharacterEncoding() : "UTF-8";
	}
	

}
