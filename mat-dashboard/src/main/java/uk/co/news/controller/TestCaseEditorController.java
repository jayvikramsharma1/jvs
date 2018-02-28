package uk.co.news.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;

public class TestCaseEditorController implements Initializable{
	
	@FXML
	private Hyperlink EditorAccordionTTPrint;
	@FXML
	private Hyperlink EditorAccordionTTTablet;
	@FXML
	private Hyperlink EditorAccordionTTDigital;
	@FXML
	private Hyperlink EditorAccordionSTPrint;
	@FXML
	private Hyperlink EditorAccordionSTTablet;
	@FXML
	private Hyperlink EditorAccordionSTDigital;
	@FXML
	private Hyperlink EditorAccordionSunPrint;
	@FXML
	private TextArea EditorTextArea;
	@FXML
	private TitledPane EditorTitledPaneNational;
	@FXML
	private TitledPane EditorTitledPaneIreland;
	@FXML
	private Button EditorBtnCreate;
	@FXML
	private Button EditorBtnDelete;
	@FXML
	private Button EditorBtnCancel;
	@FXML
	private Button EditorBtnSave;
	
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
