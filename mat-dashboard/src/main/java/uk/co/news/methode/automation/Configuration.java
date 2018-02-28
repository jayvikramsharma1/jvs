package uk.co.news.methode.automation;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import uk.co.news.methode.automation.utils.XMLFileReader;

public class Configuration {

	private final static String directorySeparator = File.separator;
	private final static String configRoot = "config";
	private final static String testcaseRoot = "testcases";
	private final static String MANIFEST_ROOT = "manifests";

	public static ArrayList<String> getManifestFile(String channalName) {
		String manifestXML = MANIFEST_ROOT + directorySeparator + "manifest.xml";
		Document doc = XMLFileReader.getXMLFile(manifestXML);
		NodeList testCase = doc.getElementsByTagName("runner");
		return getTestCases(testCase, channalName);
	}

	public static HashMap<?, ?> loadTestCases(String testCaseName, String channelName) {
		String fileName = testcaseRoot + directorySeparator + channelName + directorySeparator + testCaseName;
		String testCaseFile = addXMLSuffix(fileName);
		return getTestCasesByFile(XMLFileReader.getXMLFile(testCaseFile));
	}

	public static ArrayList<String> getTestCases(NodeList runner, String channelName) {

		ArrayList<String> manifestFile = new ArrayList<String>();

		for (int i = 0; i < runner.getLength(); i++) {

			Node channel = runner.item(i);

			if (channel.hasAttributes()) {

				Attr attr = (Attr) channel.getAttributes().getNamedItem("channel");

				if (attr != null) {

					if (channelName.equals(attr.getValue())) {

						if (channel instanceof Element) {
							Element testCases = (Element) channel;

							NodeList testcases = testCases.getElementsByTagName("testcase");

							for (int ii = 0; ii < testcases.getLength(); ii++) {

								Node testcase = testcases.item(ii);
								manifestFile.add(testcase.getTextContent());

							}

						}

					}
				}
			}
		}

		return manifestFile;
	}

	private static HashMap<String, Object> getTestCasesByFile(Document doc) {

		NodeList testCase = doc.getElementsByTagName("testCase");
		NodeList steps = doc.getElementsByTagName("step");
		String testCaseFiles = "";
		ArrayList<String> testCaseStep = new ArrayList<String>();

		HashMap<String, Object> testCaseObject = new HashMap<String, Object>();

		for (int i = 0; i < testCase.getLength(); i++) {
			Node node = testCase.item(i);
			if (node.hasAttributes()) {
				Attr attr = (Attr) node.getAttributes().getNamedItem("name");
				if (attr != null) {
					String testCaseName = attr.getValue();
					testCaseFiles = testCaseName;
				}
			}
		}

		for (int i = 0; i < steps.getLength(); i++) {

			Node step = steps.item(i);

			if (step.hasAttributes()) {

				Attr attr = (Attr) step.getAttributes().getNamedItem("name");
			
				if (attr != null) {

					String testCaseName = attr.getValue();

					testCaseStep.add(testCaseName);

					if (step instanceof Element) {

						Element childElement = (Element) step;

						NodeList inputs = childElement.getElementsByTagName("input");

						Object[] dvalue = new Object[inputs.getLength()];

						for (int ii = 0; ii < inputs.getLength(); ii++) {

							Node input = inputs.item(ii);

							if (input.hasAttributes()) {

								Attr value = (Attr) input.getAttributes().getNamedItem("value");
								Attr type = (Attr) input.getAttributes().getNamedItem("type");
								Attr methodName = (Attr) input.getAttributes().getNamedItem("method");

								if (type.getValue().equals("INTEGER")) {
									dvalue[ii] = Integer.parseInt(value.getValue());

								} else if (type.getValue().equals("STRING")) {
									dvalue[ii] = (String) value.getValue();
								}
							}
						}

						testCaseObject.put(testCaseName, ParameterFactory.getParameter(dvalue));

					}
				}
			}

		}

		testCaseObject.put("TestCaseName", testCaseFiles);
		testCaseObject.put("TestCaseStep", testCaseStep);

		return testCaseObject;
	}

	private static String addXMLSuffix(String fileName) {
		String fileNameWithExtention = fileName + ".xml";
		return fileNameWithExtention;
	}

}
