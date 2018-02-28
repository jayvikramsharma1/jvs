package uk.co.news.dto;

import javafx.scene.control.Button;

public class RunnerTableViewDataObject {
	private Integer sno;
	private String region;
	private String testCase;
	private Button toolButton;
	private Button addParameters;
	
	public RunnerTableViewDataObject() {
		super();
	}

	public RunnerTableViewDataObject(Integer sno, String region, String testCase, Button toolButton, Button addParameters) {
		super();
		this.sno = sno;
		this.region = region;
		this.testCase = testCase;
		this.toolButton = toolButton;
		this.addParameters = addParameters;
	}

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTestCase() {
		return testCase;
	}

	public void setTestCase(String testCase) {
		this.testCase = testCase;
	}
	public Button getToolButton() {
		return toolButton;
	}

	public void setToolButton(Button toolButton) {
		this.toolButton = toolButton;
	}
	
	public Button getAddParameters() {
		return addParameters;
	}

	public void setAddParameters(Button addParameters) {
		this.addParameters = addParameters;
	}

	@Override
	public String toString() {
		return "RunnerTableViewDataObject [sno=" + sno + ", region=" + region + ", testCase=" + testCase
				+ ", toolButton=" + toolButton.getId() + ", addParametrs=" + addParameters.getId() + "]";
	}

	

	
	
	
	
	
}
