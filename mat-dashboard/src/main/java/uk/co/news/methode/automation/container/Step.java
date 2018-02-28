package uk.co.news.methode.automation.container;

public class Step {
		
	private String name;
	
	private String startTime = "0";
	
	private String endTime = "0";
	
	private boolean skipStatus = false;
	
	private boolean failureStatus = false;
	
	private String errorMessage = "";
	
	private boolean status = false;
	
	private String comments = "";
	
	private String s3URL = "";
	
	private String s3Content = "";
	
	private String screenshotURL = "";
	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getS3URL() {
		return s3URL;
	}

	public void setS3URL(String s3url) {
		s3URL = s3url;
	}

	public String getScreenshotURL() {
		return screenshotURL;
	}

	public void setScreenshotURL(String screenshotName) {
		this.screenshotURL = screenshotName;
	}

	public boolean getSkipStatus() {
		return skipStatus;
	}

	public void setSkipStatus(boolean skipStatus) {
		this.skipStatus = skipStatus;
	}

	public boolean getFailureStatus() {
		return failureStatus;
	}

	public void setFailureStatus(boolean failureStatus) {
		this.failureStatus = failureStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String getS3Content() {
		return s3Content;
	}

	public void setS3Content(String s3Content) {
		this.s3Content = s3Content;
	}
}
