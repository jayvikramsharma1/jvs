package uk.co.news.methode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import uk.co.news.main.MainApp;

public class GenClasses {
	Logger logger = Logger.getLogger(GenClasses.class);
	/**
	 * @parameter default-value=
	 *            "${project.basedir}${file.separator}config${file.separator}manifest.xml"
	 */
	private String manifestDirectory = "manifests/manifest.xml";

	/**
	 * @parameter default-value="${project.basedir}${file.separator}testcases"
	 */
	private String testCaseSourceDirectory;

	/**
	 * @parameter default-value=
	 *            "${project.basedir}${file.separator}src${file.separator}main${file.separator}java"
	 */
	private String classDirectory;

	/**
	 * @parameter default-value="uk.co.news.Methode.Automation.Helper"
	 */
	private String packageName = "uk.co.news.methode.automation.Helper";

	/**
	 * @parameter default-value="tablet"
	 */
	private String channelName = "tablet";
	
	public void generate() {
		Properties appConfig = MainApp.configProperties;
		this.classDirectory = "src"+File.separator+"main"+File.separator+"java"; //appConfig.getProperty("base.autocam.dir")+"src"+File.separator+"main"+File.separator+"java";
		this.testCaseSourceDirectory = "testcases"; //appConfig.getProperty("base.autocam.dir")+File.separator+"testcases";
		
		logger.debug(manifestDirectory);
		logger.debug(testCaseSourceDirectory);
		logger.debug(classDirectory);
		logger.debug(packageName);
		logger.debug(channelName);
		
		
		String channel = channelName;
		String channelPackage = channel.substring(0, 1).toUpperCase() + channel.substring(1);
		String packagePath = replaceFilePath(packageName);
		String filePath = classDirectory.toString() + File.separator + packagePath + File.separator + channelPackage;
		HashMap<String, ArrayList<String>> runners = new HashMap<String, ArrayList<String>>();

		logger.info(channelPackage);

		File manifestFile = new File(manifestDirectory);
		File testCaseFile = new File(testCaseSourceDirectory);
		File packageFolder = new File(filePath);

		logger.info(testCaseSourceDirectory);
		logger.info(manifestFile.toString());
		logger.info(classDirectory);
		logger.info(packageName);

		logger.info(filePath);

		if (manifestFile.exists() && manifestFile.isFile()) {
			logger.info("Manifest File Found");
			logger.info(manifestFile.toString());
		} else {
			logger.error("Manifest file not found");
			//throw new MojoExecutionException("Manifest file not found");
		}

		if (testCaseFile.exists() && testCaseFile.isDirectory()) {
			logger.info("Testcase folder found");
			logger.info(testCaseFile.toString());
		} else {
			logger.error("Testcase folder not found");
			//throw new MojoExecutionException("Testcase folder not found");
		}

		logger.error("Deleting package folder");
		deleteFile(packageFolder);
		logger.error("Creating package folder");
		packageFolder.mkdirs();

		runners = ConfigurationReader.getManifestFile(manifestDirectory.toString(), channel);

		logger.info(runners.toString());

		for (Map.Entry runner : runners.entrySet()) {

			String editionName = (String) runner.getKey();

			System.out.println("Edition Name: " + editionName);

			ArrayList<String> testCaseFiles = (ArrayList<String>) runner.getValue();

			for (int i = 0; i < testCaseFiles.size(); i++) {

				String filename = testCaseSourceDirectory + File.separator + channel + File.separator
						+ testCaseFiles.get(i);

				HashMap<?, ?> configuration = ConfigurationReader.loadTestCases(filename);

				logger.info((i + 1) + ". Testcase File Details :" + configuration);

				String className = (String) configuration.get("TestCaseName");

				String testCaseComment = (String) configuration.get("comments");

				@SuppressWarnings("unchecked")
				ArrayList<String> steps = (ArrayList<String>) configuration.get("TestCaseStep");

				System.out.println(configuration.get("screenShot"));

				StringBuffer classContent = new StringBuffer(
						"package " + packageName.toString() + "." + channelPackage + ";\n\n\n");

				classContent.append("import uk.co.news.methode.automation.AutoIt;\n");
				classContent.append("import uk.co.news.methode.automation.window.*;\n");
				classContent.append("import uk.co.news.methode.automation.utils.*;\n");
				classContent.append("import org.testng.Assert;\n");
				classContent.append("import org.testng.annotations.Listeners;\n");
				classContent.append("import org.testng.annotations.Test;\n\n\n");
				classContent.append("@Listeners(uk.co.news.methode.automation.testng.Listener.class)\n");
				classContent.append("public class " + className + " extends AutoIt {\n\n");

				for (int s = 0; s < steps.size(); s++) {

					String testStep = steps.get(s);
					String stepName[] = testStep.split("\\s+");
					String methodName = (stepName.length > 0) ? stepName[1] : "";
					String testName = (stepName.length > 0) ? stepName[0] : "testCase" + s;
					String dependency = "";

					String expectedResult = "expected" + testName;

					try {
						if (s != 0) {
							int next = s - 1;
							String dependencyName = steps.get(next);
							dependency = dependencyName.split("\\s+")[0];
						}
					} catch (Exception e) {
						// TODO: handle exception
					}

					StringBuffer methodParam = new StringBuffer();

					ParameterContainer param = (ParameterContainer) configuration.get(steps.get(s));

					Object[] obj = param.getObject();

					if (dependency.equals("")) {
						classContent.append("\t\t@Test()\n");
					} else {
						classContent.append("\t\t@Test(dependsOnMethods= {\"" + dependency + "\"})\n");
					}

					classContent.append("\t\tpublic void " + testName + "() throws Exception {\n");

					if (s == 0) {
						classContent.append("\t\t\t advanceReport.getTestByName(\"" + className + "\").setEdition(\""
								+ editionName + "\");\n");
						classContent.append("\t\t\t advanceReport.getTestByName(\"" + className + "\").setComments(\""
								+ testCaseComment + "\");\n");
					}

					if (obj.length > 0) {

						int count = obj.length - 1;

						for (int o = 0; o < obj.length; o++) {
							if (obj[o] instanceof Integer) {
								logger.info("Integer");
								methodParam.append(obj[o].toString());
							} else if (obj[o] instanceof String) {
								logger.info("String");
								methodParam.append("\"" + obj[o].toString() + "\"");
							} else if (obj[o] instanceof Boolean) {
								logger.info("Boolean");
								methodParam.append(obj[o].toString());
							}

							if (count != o) {
								methodParam.append(",");
							}
						}

						if (methodName.isEmpty() == false) {

							classContent.append("\t\t\t " + methodName + "(" + methodParam.toString() + ");\n");

							@SuppressWarnings("unchecked")
							ArrayList<Result> testResult = (ArrayList<Result>) configuration.get(expectedResult);
							boolean feedStatus = false;
							for (int r = 0; r < testResult.size(); r++) {
								Result result = testResult.get(r);
								System.out.println("S3 Content:"+ result.getS3Content());
								if (result.getType().equals("S3") && result.getFeedType().equals("article")) {
									if (feedStatus == false) {
										classContent
												.append("\t\t\t String s3Content = S3Bucket.getXMLFeed(S3Bucket.getArticleURL(\""
														+ editionName + "\")); \n");
										if (result.getS3Content() == true) {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3Content(s3Content);\n");
										} else {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3URL(S3Bucket.getArticleURL(\"" + editionName
													+ "\"));\n");
										}

										feedStatus = true;
									}
									classContent.append("\t\t\t Assert.assertEquals(S3Bucket.getElementByName(\""
											+ result.getElement() + "\"),\"" + result.getValue() + "\",\""
											+ result.getMessage() + "\");\n");
								} else if (result.getType().equals("S3")
										&& result.getFeedType().equals("articleMetadata")) {
									if (feedStatus == false) {
										classContent
												.append("\t\t\t String s3Content  = S3Bucket.getXMLFeed(S3Bucket.getArticleMetadataURL(\""
														+ editionName + "\")); \n");
										if (result.getS3Content() == true) {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3Content(s3Content);\n");
										} else {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3URL(S3Bucket.getArticleMetadataURL(\"" + editionName
													+ "\"));\n");
										}
										feedStatus = true;
									}
									classContent.append("\t\t\t Assert.assertEquals(S3Bucket.getElementByName(\""
											+ result.getElement() + "\"),\"" + result.getValue() + "\",\""
											+ result.getMessage() + "\");\n");
								} else if (result.getType().equals("S3") && result.getFeedType().equals("image")) {
									if (feedStatus == false) {
										classContent
												.append("\t\t\t String s3Content = S3Bucket.getXMLFeed(S3Bucket.getImageURL(\""
														+ editionName + "\")); \n");
										if (result.getS3Content() == true) {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3Content(s3Content);\n");

										} else {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3URL(S3Bucket.getImageURL(\"" + editionName + "\"));\n");
										}
										feedStatus = true;
									}
									classContent.append("\t\t\t Assert.assertEquals(S3Bucket.getElementByName(\""
											+ result.getElement() + "\"),\"" + result.getValue() + "\",\""
											+ result.getMessage() + "\");\n");
								} else if (result.getType().equals("S3")
										&& result.getFeedType().equals("imageMetadata")) {
									if (feedStatus == false) {
										classContent
												.append("\t\t\t String s3Content = S3Bucket.getXMLFeed(S3Bucket.getImageMetadataURL(\""
														+ editionName + "\")); \n");
										if (result.getS3Content() == true) {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName + "\").setS3Content(s3Content);\n");
										} else {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3URL(S3Bucket.getImageMetadataURL(\"" + editionName
													+ "\"));\n");
										}
										
										feedStatus = true;
									}
									classContent.append("\t\t\t Assert.assertEquals(S3Bucket.getElementByName(\""
											+ result.getElement() + "\"),\"" + result.getValue() + "\",\""
											+ result.getMessage() + "\");\n");
								} else if (result.getType().equals("S3")
										&& result.getFeedType().equals("imagePositional")) {
									if (feedStatus == false) {
										classContent
												.append("\t\t\t String s3Content = S3Bucket.getXMLFeed(S3Bucket.getImagePositionalURL(\""
														+ editionName + "\")); \n");
										if (result.getS3Content() == true) {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName + "\").setS3Content(s3Content);\n");
										} else {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3URL(S3Bucket.getImagePositionalURL(\"" + editionName
													+ "\"));\n");
										}
										
										feedStatus = true;
									}
									classContent.append("\t\t\t Assert.assertEquals(S3Bucket.getElementByName(\""
											+ result.getElement() + "\"),\"" + result.getValue() + "\",\""
											+ result.getMessage() + "\");\n");
								} else if (result.getType().equals("S3") && result.getFeedType().equals("slot")) {
									if (feedStatus == false) {
										classContent
												.append("\t\t\t String s3Content = S3Bucket.getXMLFeed(S3Bucket.getSlotURL(\""
														+ editionName + "\")); \n");
										if (result.getS3Content() == true) {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName + "\").setS3Content(s3Content);\n");
										} else {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3URL(S3Bucket.getSlotURL(\"" + editionName + "\"));\n");
										}
										
										feedStatus = true;
									}
									classContent.append("\t\t\t Assert.assertEquals(S3Bucket.getElementByName(\""
											+ result.getElement() + "\"),\"" + result.getValue() + "\",\""
											+ result.getMessage() + "\");\n");
								} else if (result.getType().equals("S3")
										&& result.getFeedType().equals("slotMetadata")) {
									if (feedStatus == false) {
										classContent
												.append("\t\t\t String s3Content = S3Bucket.getXMLFeed(S3Bucket.getSlotMetadataURL(\""
														+ editionName + "\")); \n");
										if (result.getS3Content() == true) {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName + "\").setS3Content(s3Content);\n");
										} else {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3URL(S3Bucket.getSlotMetadataURL(\"" + editionName
													+ "\"));\n");
										}
										feedStatus = true;
									}
									classContent.append("\t\t\t Assert.assertEquals(S3Bucket.getElementByName(\""
											+ result.getElement() + "\"),\"" + result.getValue() + "\",\""
											+ result.getMessage() + "\");\n");
								} else if (result.getType().equals("S3") && result.getFeedType().equals("section")) {
									if (feedStatus == false) {
										classContent
												.append("\t\t\t String s3Content = S3Bucket.getXMLFeed(S3Bucket.getSectionURL(\""
														+ editionName + "\")); \n");
										if (result.getS3Content() == true) {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName + "\").setS3Content(s3Content);\n");
										} else {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3URL(S3Bucket.getSectionURL(\"" + editionName + "\"));\n");
										}
										feedStatus = true;
									}
									classContent.append("\t\t\t Assert.assertEquals(S3Bucket.getElementByName(\""
											+ result.getElement() + "\"),\"" + result.getValue() + "\",\""
											+ result.getMessage() + "\");\n");
								} else if (result.getType().equals("S3") && result.getFeedType().equals("book")) {
									if (feedStatus == false) {
										classContent
												.append("\t\t\t String s3Content = S3Bucket.getXMLFeed(S3Bucket.getBookURL(\""
														+ editionName + "\")); \n");
										if (result.getS3Content() == true) {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName + "\").setS3Content(s3Content);\n");
										} else {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3URL(S3Bucket.getBookURL(\"" + editionName + "\"));\n");
										}
										feedStatus = true;
									}
									classContent.append("\t\t\t Assert.assertEquals(S3Bucket.getElementByName(\""
											+ result.getElement() + "\"),\"" + result.getValue() + "\",\""
											+ result.getMessage() + "\");\n");
								} else if (result.getType().equals("S3") && result.getFeedType().equals("edition")) {
									if (feedStatus == false) {
										classContent
												.append("\t\t\t String s3Content = S3Bucket.getXMLFeed(S3Bucket.getEditionURL(\""
														+ editionName + "\")); \n");
										if (result.getS3Content() == true) {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName + "\").setS3Content(s3Content);\n");
										} else {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3URL(S3Bucket.getEditionURL(\"" + editionName + "\"));\n");
										}
										
										feedStatus = true;
									}
									classContent.append("\t\t\t Assert.assertEquals(S3Bucket.getElementByName(\""
											+ result.getElement() + "\"),\"" + result.getValue() + "\",\""
											+ result.getMessage() + "\");\n");
								}
							}

						}

					} else {
						if (methodName.isEmpty() == false) {

							classContent.append("\t\t\t " + methodName + "();\n");

							@SuppressWarnings("unchecked")
							ArrayList<Result> testResult = (ArrayList<Result>) configuration.get(expectedResult);
							boolean feedStatus = false;
							for (int r = 0; r < testResult.size(); r++) {
								Result result = testResult.get(r);
								System.out.println("S3 Content:"+result.getS3Content());
								if (result.getType().equals("S3") && result.getFeedType().equals("article")) {
									if (feedStatus == false) {
										classContent
												.append("\t\t\t String s3Content = S3Bucket.getXMLFeed(S3Bucket.getArticleURL(\""
														+ editionName + "\")); \n");
										if (result.getS3Content() == true) {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName + "\").setS3Content(s3Content);\n");
										} else {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3URL(S3Bucket.getArticleURL(\"" + editionName + "\"));\n");
										}
										feedStatus = true;
									}

									classContent.append("\t\t\t Assert.assertEquals(S3Bucket.getElementByName(\""
											+ result.getElement() + "\"),\"" + result.getValue() + "\",\""
											+ result.getMessage() + "\");\n");

								} else if (result.getType().equals("S3")
										&& result.getFeedType().equals("articleMetadata")) {
									if (feedStatus == false) {
										classContent
												.append("\t\t\t String s3Content = S3Bucket.getXMLFeed(S3Bucket.getArticleMetadataURL(\""
														+ editionName + "\")); \n");
										if (result.getS3Content() == true) {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName + "\").setS3Content(s3Content);\n");
										} else {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3URL(S3Bucket.getArticleMetadataURL(\"" + editionName
													+ "\"));\n");
										}
										feedStatus = true;
									}
									classContent.append("\t\t\t Assert.assertEquals(S3Bucket.getElementByName(\""
											+ result.getElement() + "\"),\"" + result.getValue() + "\",\""
											+ result.getMessage() + "\");\n");
								} else if (result.getType().equals("S3") && result.getFeedType().equals("image")) {
									if (feedStatus == false) {
										classContent
												.append("\t\t\t String s3Content = S3Bucket.getXMLFeed(S3Bucket.getImageURL(\""
														+ editionName + "\")); \n");
										if (result.getS3Content() == true) {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName + "\").setS3Content(s3Content);\n");
										} else {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3URL(S3Bucket.getImageURL(\"" + editionName + "\"));\n");
										}
										feedStatus = true;
									}
									classContent.append("\t\t\t Assert.assertEquals(S3Bucket.getElementByName(\""
											+ result.getElement() + "\"),\"" + result.getValue() + "\",\""
											+ result.getMessage() + "\");\n");
								} else if (result.getType().equals("S3")
										&& result.getFeedType().equals("imageMetadata")) {
									if (feedStatus == false) {
										classContent
												.append("\t\t\t String s3Content = S3Bucket.getXMLFeed(S3Bucket.getImageMetadataURL(\""
														+ editionName + "\")); \n");
										if (result.getS3Content() == true) {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName + "\").setS3Content(s3Content);\n");
										} else {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3URL(S3Bucket.getImageMetadataURL(\"" + editionName
													+ "\"));\n");
										}
										feedStatus = true;
									}
									classContent.append("\t\t\t Assert.assertEquals(S3Bucket.getElementByName(\""
											+ result.getElement() + "\"),\"" + result.getValue() + "\",\""
											+ result.getMessage() + "\");\n");
								} else if (result.getType().equals("S3")
										&& result.getFeedType().equals("imagePositional")) {
									if (feedStatus == false) {
										classContent
												.append("\t\t\t String s3Content = S3Bucket.getXMLFeed(S3Bucket.getImagePositionalURL(\""
														+ editionName + "\")); \n");
										if (result.getS3Content() == true) {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName + "\").setS3Content(s3Content);\n");
										} else {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3URL(S3Bucket.getImagePositionalURL(\"" + editionName
													+ "\"));\n");
										}
										feedStatus = true;
									}
									classContent.append("\t\t\t Assert.assertEquals(S3Bucket.getElementByName(\""
											+ result.getElement() + "\"),\"" + result.getValue() + "\",\""
											+ result.getMessage() + "\");\n");
								} else if (result.getType().equals("S3") && result.getFeedType().equals("slot")) {
									if (feedStatus == false) {
										classContent
												.append("\t\t\t String s3Content = S3Bucket.getXMLFeed(S3Bucket.getSlotURL(\""
														+ editionName + "\")); \n");
										if (result.getS3Content() == true) {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName + "\").setS3Content(s3Content);\n");
										} else {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3URL(S3Bucket.getSlotURL(\"" + editionName + "\"));\n");
										}
										feedStatus = true;
									}
									classContent.append("\t\t\t Assert.assertEquals(S3Bucket.getElementByName(\""
											+ result.getElement() + "\"),\"" + result.getValue() + "\",\""
											+ result.getMessage() + "\");\n");
								} else if (result.getType().equals("S3")
										&& result.getFeedType().equals("slotMetadata")) {
									if (feedStatus == false) {
										classContent
												.append("\t\t\t String s3Content = S3Bucket.getXMLFeed(S3Bucket.getSlotMetadataURL(\""
														+ editionName + "\")); \n");
										if (result.getS3Content() == true) {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName + "\").setS3Content(s3Content);\n");
										} else {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3URL(S3Bucket.getSlotMetadataURL(\"" + editionName
													+ "\"));\n");
										}
										feedStatus = true;
									}
									classContent.append("\t\t\t Assert.assertEquals(S3Bucket.getElementByName(\""
											+ result.getElement() + "\"),\"" + result.getValue() + "\",\""
											+ result.getMessage() + "\");\n");
								} else if (result.getType().equals("S3") && result.getFeedType().equals("section")) {
									if (feedStatus == false) {
										classContent
												.append("\t\t\t String s3Content = S3Bucket.getXMLFeed(S3Bucket.getSectionURL(\""
														+ editionName + "\")); \n");
										if (result.getS3Content() == true) {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName + "\").setS3Content(s3Content);\n");
										} else {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3URL(S3Bucket.getSectionURL(\"" + editionName + "\"));\n");
										}
										feedStatus = true;
									}
									classContent.append("\t\t\t Assert.assertEquals(S3Bucket.getElementByName(\""
											+ result.getElement() + "\"),\"" + result.getValue() + "\",\""
											+ result.getMessage() + "\");\n");
								} else if (result.getType().equals("S3") && result.getFeedType().equals("book")) {
									if (feedStatus == false) {
										classContent
												.append("\t\t\t String s3Content = S3Bucket.getXMLFeed(S3Bucket.getBookURL(\""
														+ editionName + "\")); \n");
										if (result.getS3Content() == true) {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName + "\").setS3Content(s3Content);\n");
										} else {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3URL(S3Bucket.getBookURL(\"" + editionName + "\"));\n");
										}
										feedStatus = true;
									}
									classContent.append("\t\t\t Assert.assertEquals(S3Bucket.getElementByName(\""
											+ result.getElement() + "\"),\"" + result.getValue() + "\",\""
											+ result.getMessage() + "\");\n");
								} else if (result.getType().equals("S3") && result.getFeedType().equals("edition")) {
									if (feedStatus == false) {
										classContent
												.append("\t\t\t String s3Content = S3Bucket.getXMLFeed(S3Bucket.getEditionURL(\""
														+ editionName + "\")); \n");
										if (result.getS3Content() == true) {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName + "\").setS3Content(s3Content);\n");
										} else {
											classContent.append("\t\t\t advanceReport.getTestByName(\"" + className
													+ "\").getStepByName(\"" + testName
													+ "\").setS3URL(S3Bucket.getEditionURL(\"" + editionName + "\"));\n");
										}
										feedStatus = true;
									}
									classContent.append("\t\t\t Assert.assertEquals(S3Bucket.getElementByName(\""
											+ result.getElement() + "\"),\"" + result.getValue() + "\",\""
											+ result.getMessage() + "\");\n");
								}
							}

						}
					}

					classContent.append("\t\t}\n\n");
				}

				classContent.append("}\n");

				logger.info(classContent.toString());

				createClassFile(filePath + File.separator + className, classContent);
			}
		}
	}
	
	
	public void createClassFile(String fileName, StringBuffer fileContent) {

		Writer writer = null;

		String className = fileName + ".java";

		File file = new File(className);

		try {
			if (file.createNewFile()) {
				logger.info(className);
				logger.info("Class has been created.");
			} else {
				logger.info("Class File already exists.");
			}
		} catch (IOException e) {
			logger.error(e.toString());
		}

		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
			writer.write(fileContent.toString());
			writer.close();

		} catch (IOException ex) {
			logger.error(ex.toString());
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				logger.error(ex.toString());
			}
		}
	}
	
	public static void deleteFile(File element) {
		if (element.isDirectory()) {
			for (File sub : element.listFiles()) {
				deleteFile(sub);
			}
		}
		element.delete();
	}
	
	private String replaceFilePath(String packageName) {

		String packagePath = packageName.replace(".", File.separator);

		return packagePath;

	}
}
