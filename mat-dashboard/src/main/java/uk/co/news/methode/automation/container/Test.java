package uk.co.news.methode.automation.container;

import java.util.ArrayList;

public class Test {
	
	private String name;
	
	private String startTime = "0";

	private String endTime = "0";

	private boolean skipStatus = false;

	private boolean failureStatus = false;

	private String errorMessage = "";

	private boolean status = false;
	
	private String edition = "";
	
	private String comments = "";
	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	private ArrayList<Step> steps = new ArrayList<Step>();
	
	public ArrayList<Step> getSteps() {
		return steps;
	}

	public void setSteps(ArrayList<Step> steps) {
		this.steps = steps;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public void setStep(String stepName) {
		Step step = new Step();
		if (!isStepExists(stepName)) {
			step.setName(stepName);
			this.steps.add(step);
		}
	}
	
	private boolean isStepExists(String testName) {

		for (int i = 0; i < this.steps.size(); i++) {
			Step step = this.steps.get(i);
			if (step.getName().equals(testName)) {
				return true;
			}
		}
		return false;
	}

	private Step getStepIfExists(String testName) {

		for (int i = 0; i < this.steps.size(); i++) {
			Step step = this.steps.get(i);
			if (step.getName().equals(testName)) {
				return step;
			}
		}
		
		return null;
	}
	
	public Step getStepByName(String testName) {
		return getStepIfExists(testName);
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}
	
	public String getEdition() {
		return edition;
	}

}
