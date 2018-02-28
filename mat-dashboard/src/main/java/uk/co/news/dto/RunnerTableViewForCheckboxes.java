package uk.co.news.dto;

import javafx.scene.control.CheckBox;

public class RunnerTableViewForCheckboxes {
	private CheckBox checkbox;
	
	public RunnerTableViewForCheckboxes() {
		super();
	}

	public RunnerTableViewForCheckboxes(CheckBox checkbox) {
		super();
		this.checkbox = checkbox;
	}

	public CheckBox getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(CheckBox checkbox) {
		this.checkbox = checkbox;
	}
}
