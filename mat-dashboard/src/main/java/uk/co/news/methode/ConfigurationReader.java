package uk.co.news.methode;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import uk.co.news.view.CustomDialogImpl;
import uk.co.news.view.CustomDialogs;

public class ConfigurationReader {
	final static Logger logger = Logger.getLogger(ConfigurationReader.class);

	public static HashMap<String, ArrayList<String>> getManifestFile(String fileLocation, String channelName) {
		Document doc = getXMLFile(fileLocation);
		NodeList testCase = doc.getElementsByTagName("runner");
		return getTestCases(testCase, channelName);
	}

	public static HashMap<?, ?> loadTestCases(String testCaseName) {
		String testCaseFile = addXMLSuffix(testCaseName);
		return getTestCasesByFile(getXMLFile(testCaseFile));
	}

	public static void getTestCases() {

	}

	public static void getClientSetting() {

	}

	private static Document getXMLFile(String fileName) {
		try {
			File configFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			dbFactory.setValidating(true);
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(configFile);
			doc.getDocumentElement().normalize();
			return doc;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	private static HashMap<String, ArrayList<String>> getTestCases(NodeList runner, String channelName) {

		
		System.out.println("Total Runner is" + runner.getLength());
		
		HashMap<String,ArrayList<String>> test = new HashMap<String,ArrayList<String>>();

		for (int i = 0; i < runner.getLength(); i++) {

			Node channel = runner.item(i);

			if (channel.hasAttributes()) {

				Attr attr = (Attr) channel.getAttributes().getNamedItem("channel");
				Attr edition = (Attr) channel.getAttributes().getNamedItem("edition");
				

				if (attr != null) {

					if (channelName.equals(attr.getValue())) {
						
						ArrayList<String> manifestFile = new ArrayList<String>();
						
						if (channel instanceof Element) {
							Element testCases = (Element) channel;

							NodeList testcases = testCases.getElementsByTagName("testcase");

							for (int ii = 0; ii < testcases.getLength(); ii++) {

								Node testcase = testcases.item(ii);
								manifestFile.add(testcase.getTextContent());

							}
							
							test.put(edition.getValue(), manifestFile);

						}

					}
				}
			}

		}

		return test;
	}

	private static HashMap<String, Object> getTestCasesByFile(Document doc) {
		HashMap<String, Object> testCaseObject = null;
		try {
			NodeList testCase = doc.getElementsByTagName("testCase");
			NodeList steps = doc.getElementsByTagName("step");
			String testCaseFiles = "";
			String testComments = "";
			ArrayList<String> testCaseStep = new ArrayList<String>();

			testCaseObject = new HashMap<String, Object>();
			//HashMap<String, Object> expectedResult = new HashMap<String, Object>();

			for (int i = 0; i < testCase.getLength(); i++) {
				Node node = testCase.item(i);
				if (node.hasAttributes()) {
					Attr attr = (Attr) node.getAttributes().getNamedItem("name");
					Attr comments = (Attr) node.getAttributes().getNamedItem("comments");
					if (attr != null) {
						String testCaseName = attr.getValue();
						testCaseFiles = testCaseName;
						testComments = comments.getValue();
					}
				}
			}

			for (int i = 0; i < steps.getLength(); i++) {

				Node step = steps.item(i);

				if (step.hasAttributes()) {

					Attr attr = (Attr) step.getAttributes().getNamedItem("name");
					Attr methodName = (Attr) step.getAttributes().getNamedItem("method");
					Attr requireClass = (Attr) step.getAttributes().getNamedItem("require");
					Attr screenShot = (Attr) step.getAttributes().getNamedItem("screenshot");

					if (attr != null) {

						String testCaseName = attr.getValue() + " " + requireClass.getValue() + "." + methodName.getValue();

						System.out.println(testCaseName);

						testCaseStep.add(testCaseName);

						if (step instanceof Element) {

							Element childElement = (Element) step;

							NodeList inputs = childElement.getElementsByTagName("input");
							
							Object[] dvalue;
							
							if( screenShot != null && (screenShot.getValue().equals("true") == true) ) {
								dvalue = new Object[inputs.getLength() + 2];
								dvalue[dvalue.length - 2] = testCaseFiles;
								dvalue[dvalue.length - 1] = attr.getValue();
							} else {
								dvalue = new Object[inputs.getLength()];
							}
							
							for (int ii = 0; ii < inputs.getLength(); ii++) {

								Node input = inputs.item(ii);
								
								if (input.hasAttributes()) {

									Attr value = (Attr) input.getAttributes().getNamedItem("value");
									Attr type = (Attr) input.getAttributes().getNamedItem("type");

									if (type.getValue().equals("INTEGER")) {
										dvalue[ii] = Integer.parseInt(value.getValue());

									} else if (type.getValue().equals("STRING")) {
										dvalue[ii] = (String) value.getValue();
									}
								}
							}
							
							NodeList results = childElement.getElementsByTagName("result");
							ArrayList<Result> expectedResult = new ArrayList<Result>();
							String testResultName = "expected"+ attr.getValue();
							
							
							
						for (int r = 0; r < results.getLength(); r++) {

							
								Node result = results.item(r);
								Result testResult = new Result();

								if (result.hasAttributes()) {

									Attr value = (Attr) result.getAttributes().getNamedItem("value");
									Attr type = (Attr) result.getAttributes().getNamedItem("type");
									Attr feedType = (Attr) result.getAttributes().getNamedItem("feedType");
									Attr element = (Attr) result.getAttributes().getNamedItem("element");
									Attr message = (Attr) result.getAttributes().getNamedItem("message");
									Attr s3Content = (Attr) result.getAttributes().getNamedItem("s3Content");
									
									testResult.setFeedType(feedType.getValue());
									testResult.setType(type.getValue());
									testResult.setValue(value.getValue());
									testResult.setMessage(message.getValue());
									testResult.setElement(element.getValue());
									
									if( s3Content != null && (s3Content.getValue().equals("true") == true) ) {
										testResult.setS3Content(true);
									} else {
										testResult.setS3Content(false);
									}
									
									expectedResult.add(testResult);
								}
						}
							
							testCaseObject.put(testCaseName, ParameterFactory.getParameter(dvalue));
							testCaseObject.put(testResultName, expectedResult);
							testCaseObject.put("comments",testComments);

						}
					}
				}

			}

			testCaseObject.put("TestCaseName", testCaseFiles);
			testCaseObject.put("TestCaseStep", testCaseStep);

			return testCaseObject;
		} catch (Exception e) {
			CustomDialogImpl.getCustomDialogImpl().errorDialog(e);
			logger.debug(e.getStackTrace());
			
		}
		return testCaseObject;
		
	}

	private static String addXMLSuffix(String fileName) {
		String fileNameWithExtention = fileName + ".xml";
		return fileNameWithExtention;
	}

}
