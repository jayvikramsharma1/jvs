package uk.co.news.controller;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Separator;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import net.sourceforge.htmlunit.corejs.javascript.ast.SwitchCase;
import uk.co.news.main.MainApp;
import uk.co.news.model.TestFileExplorer;

public class TestCaseEditorControllerNew implements Initializable {
	private static boolean generalSliderFlag = false;
	
	@FXML
	private AnchorPane EditorRootPane;
	@FXML
	private TabPane EditorRootTabPane;
	@FXML
	private Tab TheTimesTab;
	@FXML
	private AnchorPane TheTimesTabPane;
	@FXML
	private Tab SundayTimesTab;
	@FXML
	private AnchorPane SundayTimesTabPane;
	@FXML
	private Tab TheSunTab;
	@FXML
	private AnchorPane TheSunTabPane;
	@FXML
	private ToolBar EditorGeneralToolBar;
	@FXML
	private AnchorPane GeneralSliderPane;
	@FXML
	private TableView FilesListTable;
	@FXML
	private TableColumn FilesListTableColumnSno;
	@FXML
	private TableColumn FileListTableColumnFiles;
	@FXML
	private VBox ClickableVbox;
	
	
	static final String PATH = MainApp.configProperties.getProperty("base.autocam.dir");
	final Map<String, List<CheckBox>> allTabletTestCaseFiles = TestFileExplorer.getTabletFiles(PATH+MainApp.configProperties.getProperty("base.autocam.testcases.tablet"));
	final Map<String, List<CheckBox>> allDigitalTestCaseFiles = TestFileExplorer.getTabletFiles(PATH+MainApp.configProperties.getProperty("base.autocam.testcases.digital"));
	final Map<String, List<CheckBox>> allPrintTestCaseFiles = TestFileExplorer.getTabletFiles(PATH+MainApp.configProperties.getProperty("base.autocam.testcases.print"));
	
	private Button printButton = new Button("Print");
	private Button tabletButton = new Button("Tablet");
	private Button webButton = new Button("Web");
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		generalSliderViewImpl();
		setButtonsToToolBar("TT");
		EditorRootTabPane.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
			//EventTarget eventTarget = e.getTarget();
			//System.out.println(EditorRootTabPane.getSelectionModel().getSelectedItem().getText());
			System.out.println(EditorRootTabPane.getSelectionModel().getSelectedIndex());
			toolBarImpl(EditorRootTabPane.getSelectionModel().getSelectedIndex());
		});
	}
	
	public void generalSliderViewImpl() {
		ClickableVbox.setOnMouseClicked((e) -> {
			if(generalSliderFlag == false) {
				GeneralSliderPane.setTopAnchor(GeneralSliderPane, 40.0);
				GeneralSliderPane.setRightAnchor(GeneralSliderPane, 180.0);
				GeneralSliderPane.setBottomAnchor(GeneralSliderPane, 0.0);
				generalSliderFlag = true;
			} else {
				GeneralSliderPane.setTopAnchor(GeneralSliderPane, 40.0);
				GeneralSliderPane.setRightAnchor(GeneralSliderPane, -180.0);
				GeneralSliderPane.setBottomAnchor(GeneralSliderPane, 0.0);
				generalSliderFlag = false;
			}
			
			
		});
	}
	
	public void toolBarImpl(int index) {
		switch (index) {
		case 0:
			setButtonsToToolBar("TT");
			break;				
		case 1:
			setButtonsToToolBar("ST");
			break;	
		case 2:
			setButtonsToToolBar("SN");
			break;
		default:
			
			break;
		}
	}
	
	private void tagButtonsForTitle(String title) {
		printButton.setId(title);
		tabletButton.setId(title);
		webButton.setId(title);
	}
	
	private void setButtonsToToolBar(String title) {
		EditorGeneralToolBar.getItems().clear();
		tagButtonsForTitle(title);
		EditorGeneralToolBar.getItems().addAll(
				new Separator(),
				printButton,
				tabletButton,
				webButton
				);
	}
	
	private void printButtonImpl() {
		String buttonId = printButton.getId();
		switch (buttonId) {
		case "TT":
			
			break;
		case "ST":
			break;
		case "SN":
			break;
		default:
			break;
		}
	}
}
