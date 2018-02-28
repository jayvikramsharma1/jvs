package uk.news.ui.test1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;

public class TestController implements Initializable{
	
	@FXML
	private MenuItem testRunner;
	
	@FXML
	private MenuItem editTestCases;
	
	@FXML
	private MenuItem createTestCases;
	
	@FXML
	private MenuItem closeApplication;
	
	@FXML
	private MenuItem fullScreen;
	
	@FXML
	private MenuItem aboutTestingDashboardApplication;
	
	@FXML
	private ListView<String> TheTimeChannnels;
	
	@FXML
	private ListView<String> TheSundayTimeChannnels;
	
	@FXML
	private ListView<String> TheSunChannels;
	
	@FXML
	private ListView<String> FilesPresenter;
	
	@FXML
	private TextArea TestCaseFileContentsTextArea;
	
	@FXML
	private Button runTestCases;
	
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> allChannelItems = FXCollections.observableArrayList ("Print", "Tablet", "Digital");
		ObservableList<String> printChannelItem = FXCollections.observableArrayList ("Print");
		TheTimeChannnels.setItems(allChannelItems);
		TheSundayTimeChannnels.setItems(allChannelItems);
		TheSunChannels.setItems(printChannelItem);
		
		runTestCases.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent arg0) {
				TestCaseFileContentsTextArea.setText("Hello Wow I am Working");
				
			}
		});
		
	}

}
