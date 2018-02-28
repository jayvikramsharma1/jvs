package uk.co.news.methode.automation.window;


import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.constant.WindowSettings;
import uk.co.news.methode.automation.container.Default;
import uk.co.news.methode.automation.container.Step;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.exception.PropertyNotFound;
import uk.co.news.methode.automation.utils.ClientConfiguration;
import uk.co.news.methode.automation.utils.S3Uploader;

public class BaseWindow  extends WindowSettings {

	
	public static uk.co.news.methode.automation.container.Property getProperty(String windowName, String propertyName) throws Exception {
		return ClientConfiguration.getPropertyByName(windowName, propertyName);
	}
	
	public static Window getWindowProperty(String windowName) throws Exception {
		return ClientConfiguration.getWindowsByName(windowName);
	}
	
	public static Default getDefaultPropertyByName(String propertyName) throws PropertyNotFound {
		return ClientConfiguration.getDefaultPropertyByName(propertyName);
	}
	
	public static void captureScreen(String testName, String stepName) throws Exception {
		String s3URL = S3Uploader.capture(); 
		((Step) AutoIt.advanceReport.getTestByName(testName)
				.getStepByName(stepName))
				.setScreenshotURL(s3URL);
				System.out.println(s3URL);
	}
}
