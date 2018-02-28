package uk.co.news.methode.automation;

import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import uk.co.news.methode.automation.utils.ClientConfiguration;
import uk.co.news.methode.automation.utils.Environment;
import uk.co.news.methode.automation.utils.S3Bucket;
import uk.co.news.methode.automation.window.Login;
import uk.co.news.view.CustomDialogImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

@Test
public class Application {

	final static Logger logger = Logger.getLogger(Application.class);

	private static String packageName = "uk.co.news.methode.automation.Helper.";

	public static void main(String args[]) throws Exception {
		
		try {
		Environment.loadConfiguration();
		ClientConfiguration.loadConfiguration();

		String channel = Environment.getChannel();

		String channelPackage = channel.substring(0, 1).toUpperCase()
				+ channel.substring(1);

		ArrayList<String> manifestFile = Configuration
				.getManifestFile(Environment.getChannel());

		//System.out.println(S3Bucket.getBookURL());
		initTestSuiteRunner(manifestFile, channel, channelPackage);
		} catch (Exception e) {
			logger.debug(e.getStackTrace());
			CustomDialogImpl.getCustomDialogImpl().errorDialog(e);
		}

	}

	public static void initTestSuiteRunner(ArrayList<String> manifestFile,
			String channelName, String channelPackage) {

		logger.info("#############################################");
		logger.info("Loading manifest files.....");
		logger.info("#############################################");
		logger.info(manifestFile);
		logger.info("#############################################");
		logger.info("Manifest file have been loaded");
		logger.info("#############################################");

		logger.info("#############################################");
		logger.info("Loading testcase files");
		logger.info("#############################################");

		TestNG testng = new TestNG();

		XmlSuite testSuite = new XmlSuite();
		testSuite.setName("Methode " + channelPackage + " Suite");
		testSuite.setVerbose(2);
		testSuite.setThreadCount(1);
		testSuite.setParallel("none");

		List<XmlTest> testCase = new ArrayList<XmlTest>();
		for (int i = 0; i < manifestFile.size(); i++) {

			List<XmlClass> testClassName = new ArrayList<XmlClass>();

			XmlTest testPlan = new XmlTest(testSuite);

			HashMap<?, ?> configuration = Configuration.loadTestCases(
					manifestFile.get(i), channelName);

			testPlan.setName((String) configuration.get("TestCaseName"));
			testPlan.setPreserveOrder("true");

			logger.info((i + 1) + ". Testcase File Details :" + configuration);

			String className = (String) packageName + channelPackage + "."
					+ configuration.get("TestCaseName");
			logger.debug(className);
			testClassName.add(new XmlClass(className));

			testPlan.setXmlClasses(testClassName);

			testCase.add(testPlan);

		}

		testSuite.setTests(testCase);

		List<XmlSuite> testSuites = new ArrayList<XmlSuite>();
		testSuites.add(testSuite);

		testng.setXmlSuites(testSuites);
		testng.run();
	}
}