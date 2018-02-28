package uk.co.news.methode.automation.container;

import java.util.ArrayList;

public class AdvanceReport {

	private String title;

	private String channel;

	private String date;

	private String environment;

	private String startTime;

	private String endTime;

	private String userName;

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

	private ArrayList<Test> test = new ArrayList<Test>();

	public ArrayList<Test> getTest() {
		return test;
	}

	public void setTest(ArrayList<Test> test) {
		this.test = test;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setTest(String testName) {
		Test test = new Test();
		if (!isTestExists(testName)) {
			test.setName(testName);
			this.test.add(test);
		}
	}

	private boolean isTestExists(String testName) {

		for (int i = 0; i < this.test.size(); i++) {
			Test test = this.test.get(i);
			if (test.getName().equals(testName)) {
				return true;
			}
		}

		return false;
	}

	private Test getTestIfExists(String testName) {

		for (int i = 0; i < this.test.size(); i++) {
			Test test = this.test.get(i);
			if (test.getName().equals(testName)) {
				return test;
			}
		}

		return null;
	}

	public Test getTestByName(String testName) {
		return getTestIfExists(testName);
	}

}
