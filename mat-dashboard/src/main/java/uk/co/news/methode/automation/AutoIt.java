package uk.co.news.methode.automation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacob.com.LibraryLoader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import autoitx4java.AutoItX;
import uk.co.news.methode.automation.container.AdvanceReport;
import uk.co.news.methode.automation.container.ManifestEntry;
import uk.co.news.methode.automation.utils.Environment;
import uk.co.news.methode.automation.utils.S3Uploader;
import uk.co.news.view.CustomDialogImpl;

public class AutoIt {

	public static AdvanceReport advanceReport;

	public static AutoItX methode;

	protected ExtentReports extent;

	final static Logger logger = Logger.getLogger(AutoIt.class);

	static String jvmBitVersion() {
		return System.getProperty("sun.arch.data.model");
	}

	@BeforeSuite
	public void beforeSuite() throws URISyntaxException {

		logger.info("in beforeSuite");

		String jacobDllVersionToUse;

		if (jvmBitVersion().contains("32")) {
			jacobDllVersionToUse = "jacob-1.18-x86.dll";
		} else {
			jacobDllVersionToUse = "jacob-1.18-x64.dll";
		}
		
		File file = new File("app-libs", jacobDllVersionToUse);
		logger.debug("UUUUUUUUUUUUUUUUUUUUUUUU " + file.getAbsolutePath());
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		
		logger.debug("AutoITx AutoITx AutoITx AutoITx AutoITx AutoITx AutoITx AutoITx " +Environment.getMethodePath());
		if(!Files.exists(Paths.get(Environment.getMethodePath()))) {
			logger.debug("Auto IT x --- Methode Instalation not found !! going to exit current exection");
			CustomDialogImpl.getCustomDialogImpl().errorDialog("Methode not found ", "Methode Instalation not found !! Terminating current exection \n" + Environment.getMethodePath());
			return;
		}
		methode = new AutoItX();
		methode.setOption(AutoItX.OPT_CARET_COORD_MODE, "2");
		methode.setOption(AutoItX.OPT_MOUSE_COORD_MODE, "2");
		methode.setOption(AutoItX.OPT_WIN_TITLE_MATCH_MODE, "4");
		methode.run(Environment.getMethodePath(), "", AutoItX.SW_SHOW);

		extent = ExtendReportManager.getReporter();
		advanceReport = new AdvanceReport();
		advanceReport.setUserName(Environment.getUserName());
		advanceReport.setTitle(Environment.getTitle());
		advanceReport.setChannel(Environment.getChannel());
		advanceReport.setEnvironment(Environment.getEnvironment());
		advanceReport.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString());
		advanceReport.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString());

	}

	@SuppressWarnings("rawtypes")
	@BeforeClass
	public void beforeClass() {
		String testName = this.getClass().getSimpleName().toString();
		advanceReport.setTest(testName);
	}

	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void beforeMethod(Method method) {
		String testName = this.getClass().getSimpleName();

		ExtendTestManager.startTest(method.getName()).assignCategory(method.getDeclaringClass().getSimpleName());
		advanceReport.getTestByName(testName).setStep(method.getName());
	}

	@AfterMethod
	protected void afterMethod(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			ExtendTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			ExtendTestManager.getTest().log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
		} else {
			ExtendTestManager.getTest().log(LogStatus.PASS, "Test passed");
		}

		ExtendReportManager.getReporter().endTest(ExtendTestManager.getTest());
		ExtendReportManager.getReporter().flush();

	}

	@AfterSuite
	public void afterSuite() {
		logger.info("After beforeSuite");

		advanceReport.setEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString());
		methode.sleep(3000);
		/** Closing the extent report after writing the report */
		extent.close();
		ObjectMapper mapperObj = new ObjectMapper();
	
		try {
			UUID uniqueName = UUID.randomUUID();
			String jsonStr = mapperObj.writeValueAsString(advanceReport);
			System.out.println(jsonStr);
			File reportName = new File("reports" + File.separator + uniqueName + ".json");

			FileOutputStream file = new FileOutputStream(reportName);
			OutputStreamWriter osw = new OutputStreamWriter(file);
			Writer w = new BufferedWriter(osw);
			w.write(jsonStr);
			w.close();

			String url = S3Uploader.uploadFile(jsonStr, uniqueName);
			ManifestEntry entry = new ManifestEntry();
			entry.setUrl(url);
			entry.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString());
			S3Uploader.updateManifest(entry);
			System.out.println(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
