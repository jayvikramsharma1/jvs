package uk.co.news.methode.automation.testng;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Step;

public class Listener extends TestListenerAdapter {
	
	
	private String getSuiteName(ITestResult result) {
		return (String) result.getTestClass().getName().substring(result.getTestClass().getName().lastIndexOf(".") + 1).trim();
	}
		
	@Override
	public void onTestStart(ITestResult result) {
		((Step) AutoIt.advanceReport.getTestByName(getSuiteName(result))
				.getStepByName(result.getName()))
				.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date()).toString());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		((Step) AutoIt.advanceReport.getTestByName(getSuiteName(result))
				.getStepByName(result.getName()))
				.setStatus(true);
		
		((Step) AutoIt.advanceReport.getTestByName(getSuiteName(result))
				.getStepByName(result.getName()))
				.setEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date()).toString());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		((Step) AutoIt.advanceReport.getTestByName(getSuiteName(result))
				.getStepByName(result.getName()))
				.setFailureStatus(true);
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		result.getThrowable().printStackTrace(pw);
		((Step) AutoIt.advanceReport.getTestByName(getSuiteName(result))
				.getStepByName(result.getName()))
				.setErrorMessage(sw.toString());
		//System.out.println(result.getThrowable().getMessage());
		//System.out.println(sw.toString());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		AutoIt.advanceReport.getTestByName(getSuiteName(result))
				.setStep(result.getName());
		
		((Step) AutoIt.advanceReport.getTestByName(getSuiteName(result))
				.getStepByName(result.getName()))
				.setSkipStatus(true);
		
//		((Step) AutoIt.advanceReport.getTestByName(getSuiteName(result))
//				.getStepByName(result.getName())).setErrorMessage(result.getThrowable().getMessage());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		((Step) AutoIt.advanceReport.getTestByName(getSuiteName(result))
				.getStepByName(result.getName()))
				.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(new Date()).toString());

	}
	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

}
