package uk.co.news.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class ALLViews {
	//FXMLLoader homeDashboard;
	//FXMLLoader RunnerWindow;
	//FXMLLoader TestCaseEditorWindow;
	//FXMLLoader RunnerWindowNew;
	//FXMLLoader GeneralSettingsWindow;
	
	public FXMLLoader getHomeDashboard() {
		//homeDashboard = new FXMLLoader(getClass().getClassLoader().getResource("home_dashboard.fxml"));
		return getView("home_dashboard.fxml");
	}

	public FXMLLoader getRunnerWindow() {
		//RunnerWindow = new FXMLLoader(getClass().getClassLoader().getResource("runner_window.fxml"));
		//return RunnerWindow;
		return getView("runner_window.fxml");
	}
	
	public FXMLLoader getRunnerWindowNew() {
		//RunnerWindowNew = new FXMLLoader(getClass().getClassLoader().getResource("runner_window_new.fxml"));
		//return RunnerWindowNew;
		return getView("runner_window_new.fxml");
	}

	public FXMLLoader getTestCaseEditorWindow() {
		//TestCaseEditorWindow = new FXMLLoader(getClass().getClassLoader().getResource("testcase_editor.fxml"));
		//return TestCaseEditorWindow;
		return getView("testcase_editor.fxml");
	}
	
	public FXMLLoader getTestCaseEditorWindowNew() {
		//TestCaseEditorWindow = new FXMLLoader(getClass().getClassLoader().getResource("testcase_editor.fxml"));
		//return TestCaseEditorWindow;
		return getView("testcase_editor_new.fxml");
	}
	
	public FXMLLoader getGeneralSettingsWindow() {
		//GeneralSettingsWindow = new FXMLLoader(getClass().getClassLoader().getResource("general_setting_editors.fxml"));
		//return GeneralSettingsWindow;
		return getView("general_setting_editors.fxml");
	}
	
	
	private FXMLLoader getView(String viewName) {
		return new FXMLLoader(getClass().getClassLoader().getResource(viewName));
	}
	
	
	
	
}