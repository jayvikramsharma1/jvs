package uk.co.news.controller;

import java.io.IOException;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javax.tools.Diagnostic;
import javax.tools.Diagnostic.Kind;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;

import autoitx4java.AutoItX;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import uk.co.news.dto.RunnerTableViewDataObject;
import uk.co.news.main.MainApp;
import uk.co.news.methode.GenClasses;
import uk.co.news.methode.automation.Application;
import uk.co.news.methode.automation.utils.AwesomeIcons;
import uk.co.news.model.TestFileExplorer;
import uk.co.news.utils.ApplicationStage;
import uk.co.news.utils.Channels;
import uk.co.news.utils.Region;
import uk.co.news.utils.SimpleDialogGenerator;
import uk.co.news.utils.SqlLiteDBImpls;
import uk.co.news.utils.TitleString;
import uk.co.news.utils.Titles;
import uk.co.news.view.CustomDialogImpl;
import uk.co.news.view.XMLEditorPane;

public class RunnerWindowControllerNew implements Initializable{
	static Logger logger = Logger.getLogger(RunnerWindowControllerNew.class);
	private Stage applicationStage;
	
	@FXML
	private Button printImage;
	@FXML
	private Button tabletImage;
	@FXML
	private Button digitalImage;
	@FXML
	private Label runnerTitle;
	@FXML
	private TextField testSearch;
	
	@FXML
	private TitledPane RunnerTitledPaneNational;
	@FXML
	private TitledPane RunnerTitledPaneIreland;
	@FXML
	private Button RunnerBtnGenerate;
	@FXML
	private Accordion RunnerCountryAccordion;
	
	@FXML
	private TableColumn<RunnerTableViewDataObject, String> runnerTableViewColumnSno;
	@FXML
	private TableColumn<RunnerTableViewDataObject, String> runnerTableViewColumnRegion;
	@FXML
	private TableColumn<RunnerTableViewDataObject, String> runnerTableViewColumnTestCases;
	@FXML
	private TableColumn<RunnerTableViewDataObject, Button> runnerTableViewColumnTools;
	@FXML
	private TableColumn<RunnerTableViewDataObject, Button> runnerTableViewColumnParameters;
	@FXML
	private TableView<RunnerTableViewDataObject> runnerTableView;
	@FXML
	private SplitPane runnerSplitPane;
	@FXML
	private AnchorPane runnerSplitPaneLeft;
	
	private double defaultIconSplitPaneDividerPositionPercentage = 0.081;
	private double defaultIconSize = 40;
	private double mouseEnterIconSize = defaultIconSize -5;
	private double mouseClickedIconSize = defaultIconSize - 15;
	private double mouseEnterAlphaValue = 0.5;
	private double mouseExitAlphaValue = 1.0;
	private double mouseClickedAlphaValue = 0.3;
	
	private String mask;
	private Map<String, List<String>> storedValuesForData;
	static final String PATH = MainApp.configProperties.getProperty("base.autocam.dir");
	final Map<String, List<CheckBox>> allTabletTestCaseFiles = TestFileExplorer.getTabletFiles(PATH+MainApp.configProperties.getProperty("base.autocam.testcases.tablet"));
	final Map<String, List<CheckBox>> allDigitalTestCaseFiles = TestFileExplorer.getTabletFiles(PATH+MainApp.configProperties.getProperty("base.autocam.testcases.digital"));
	final Map<String, List<CheckBox>> allPrintTestCaseFiles = TestFileExplorer.getTabletFiles(PATH+MainApp.configProperties.getProperty("base.autocam.testcases.print"));
	
	public void initialize(URL location, ResourceBundle resources) {
		runnerTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		testSearch.setDisable(true);
		runnerSplitPane.setDividerPositions((defaultIconSplitPaneDividerPositionPercentage * defaultIconSize)/100);
		runnerSplitPaneLeft.maxWidthProperty().bind(runnerSplitPane.widthProperty().multiply((defaultIconSplitPaneDividerPositionPercentage * defaultIconSize)/100));
		runnerSplitPaneLeft.minWidthProperty().bind(runnerSplitPane.widthProperty().multiply((defaultIconSplitPaneDividerPositionPercentage * defaultIconSize)/100));
        
		//setButtonsLooks();
		
		printImage.setFont(MainApp.getFontAwesome(20));
		printImage.setText(AwesomeIcons.ICON_PRINT);
		tabletImage.setFont(MainApp.getFontAwesome(20));
		tabletImage.setText(AwesomeIcons.ICON_TABLET);
		digitalImage.setFont(MainApp.getFontAwesome(20));
		digitalImage.setText(AwesomeIcons.ICON_GLOBE);
		printImage.setPrefWidth(defaultIconSize);
		printImage.setPrefHeight(defaultIconSize);
		
		tabletImage.setPrefWidth(defaultIconSize);
		tabletImage.setPrefHeight(defaultIconSize);
		
		digitalImage.setPrefWidth(defaultIconSize);
		digitalImage.setPrefHeight(defaultIconSize);
		
		// Button looks
		
		
		RunnerTitledPaneNational.setDisable(true);
		RunnerTitledPaneIreland.setDisable(true);
		logger.debug("Application Test :  " + PATH);
		storedValuesForData = new LinkedHashMap<>();
		storedValuesForData.put(Channels.TABLET.value+Region.NATIONAL.value, new ArrayList<String>());
		storedValuesForData.put(Channels.TABLET.value+Region.IRELAND.value, new ArrayList<String>());
		storedValuesForData.put(Channels.DIGITAL.value+Region.NATIONAL.value, new ArrayList<String>());
		storedValuesForData.put(Channels.DIGITAL.value+Region.IRELAND.value, new ArrayList<String>());
		storedValuesForData.put(Channels.PRINT.value+Region.NATIONAL.value, new ArrayList<String>());
		storedValuesForData.put(Channels.PRINT.value+Region.IRELAND.value, new ArrayList<String>());
		
		
		runnerTableViewColumnSno.setCellValueFactory(new PropertyValueFactory<RunnerTableViewDataObject, String>("sno"));
		runnerTableViewColumnSno.setId("center-table-column");
		runnerTableViewColumnRegion.setCellValueFactory(new PropertyValueFactory<RunnerTableViewDataObject, String>("region"));
		runnerTableViewColumnRegion.setId("center-table-column");
		runnerTableViewColumnTestCases.setCellValueFactory(new PropertyValueFactory<RunnerTableViewDataObject, String>("testCase"));
		
		runnerTableViewColumnTools.setCellValueFactory(new PropertyValueFactory<RunnerTableViewDataObject, Button>("toolButton"));
		runnerTableViewColumnTools.setId("center-table-column");
		
		runnerTableViewColumnParameters.setCellValueFactory(new PropertyValueFactory<RunnerTableViewDataObject, Button>("addParameters"));
		runnerTableViewColumnParameters.setId("center-table-column");
		
		testSearch.setText("Search");
		
		testSearch.focusedProperty().addListener(new ChangeListener<Boolean>()
		{
		    @Override
		    public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
		    {
		        if (newPropertyValue){
		        	if(testSearch.getText().equals("Search"))
		        		testSearch.setText("");
		        }
		        else
		        {
		        	testSearch.setText("Search");
		        }
		    }
		});
		
		setDataToPrint();
		setDataToDigital();
		setDataToTablet();
		generateButtonImpl();
	}
	
	public String getFileContent(String filePath) {
		String fileContent = null;
		try {
			fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileContent;
	}
	
	public void setDataToRunnerScene(List<CheckBox> TestFileLinks, TitledPane titledPane, String channel, String region) {
		testSearch.setDisable(false);
		RunnerTitledPaneNational.setDisable(false);
		RunnerTitledPaneIreland.setDisable(false);
		ScrollPane scrollPane = new ScrollPane();
		GridPane gridPane = new GridPane();
		gridPane.setVgap(4);
		gridPane.setPadding(new Insets(5, 5, 5, 5));
		scrollPane.setContent(gridPane);
		titledPane.setContent(scrollPane);
		int count = 0;
		for(CheckBox testFile : TestFileLinks) {
			gridPane.add(testFile, 0, count++);
			testFile.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					CheckBox hpr = (CheckBox) e.getSource();
					if(hpr.isSelected() == true && storedValuesForData.get(channel+region).indexOf(hpr.getText()) <= -1) {
						storedValuesForData.get(channel+region).add(hpr.getText());
					}
					else {
						if(storedValuesForData.get(channel+region).indexOf(hpr.getText()) > -1) {
							storedValuesForData.get(channel+region).remove(hpr.getText());
						}
					}
					setDataToOrderedTableView(storedValuesForData.get(channel+region), channel, region, TestFileLinks);
				}
			});
		}
		
		testSearch.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				logger.debug(testSearch.getText());
				int count = 0;
				gridPane.getChildren().clear();
				for(CheckBox testFile : TestFileLinks) {
					if(testFile.getText().contains(testSearch.getText())) {
						gridPane.add(testFile, 0, count++);
						testFile.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent e) {
								CheckBox hpr = (CheckBox) e.getSource();
								if(hpr.isSelected() == true && storedValuesForData.get(channel+region).indexOf(hpr.getText()) <= -1) {
									storedValuesForData.get(channel+region).add(hpr.getText());
								}
								else {
									if(storedValuesForData.get(channel+region).indexOf(hpr.getText()) > -1) {
										storedValuesForData.get(channel+region).remove(hpr.getText());
									}
								}
								setDataToOrderedTableView(storedValuesForData.get(channel+region), channel, region, TestFileLinks);
							}
						});
					}
				}
			}
		});
	}
	
	public void setBlankPanes(TitledPane titledPaneNational, TitledPane titledPaneIreland) {
		titledPaneNational.setContent(null);
		titledPaneIreland.setContent(null);
		titledPaneNational.setDisable(true);
		titledPaneIreland.setDisable(true);
		RunnerCountryAccordion.getPanes().get(0).setExpanded(false);
		testSearch.setDisable(true);
	}
	
	public String generateManifestFile(List<String> testFileList, String channel, String region) {
		StringBuilder testcaseFiles = new StringBuilder();
		if(testFileList.size() > 0) {
			for(String testFiles : testFileList) {
				if(!testFiles.equals("") && testFiles != null) {
					testcaseFiles.append("\t<testcase>"+testFiles+"</testcase>"+"\n");
				}
			}
		}
		testcaseFiles.insert(0, "<runner channel=\""+channel+"\" edition=\""+region+"\">\n");
		testcaseFiles.insert(testcaseFiles.length(), "</runner>\n");
		System.out.println(testcaseFiles.toString());
		return testcaseFiles.toString();
	}
	
	public void setDataToOrderedTableView(List<String> testFileList, String channel, String region, List<CheckBox> TestFileLinks){
		ObservableList<RunnerTableViewDataObject> tableData = FXCollections.observableArrayList();
		int count = 0;
		if(testFileList.size() > 0) {
			for(String testFiles : testFileList) {
				if(!testFiles.equals("") && testFiles != null) {
					Button toolBtn = new Button();
					toolBtn.setFont(MainApp.fontAwesome);
					toolBtn.setText(AwesomeIcons.ICON_CLOSE);
					toolBtn.setId(testFiles);
					toolBtn.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							testFileList.remove(toolBtn.getId());
							CheckBox cbox = getCheckbox(toolBtn.getId(), TestFileLinks);
							cbox.setSelected(false);
							setDataToOrderedTableView(testFileList, channel, region, TestFileLinks);
						}
					});
					Button addParameters = new Button("Add Parameters");
					addParameters.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							double width = ApplicationStage.getInstance().getWidth()-((ApplicationStage.getInstance().getWidth()*20)/100);
							double height = ApplicationStage.getInstance().getHeight()-((ApplicationStage.getInstance().getHeight()*20)/100);
							Dialog<Object> parameterDialog = getParameterModal();
							Stage parameterStage = (Stage) parameterDialog.getDialogPane().getScene().getWindow();
							parameterStage.setHeight(height);
							parameterStage.setWidth(width);
							parameterStage.setResizable(true);
							parameterStage.sizeToScene();
							parameterDialog.show();
						}
					});
					tableData.add(new RunnerTableViewDataObject(++count, StringUtils.capitalize(region), StringUtils.capitalize(testFiles), toolBtn, addParameters));
				}
			}
			runnerTableView.setItems(tableData);
		}
		else {
			runnerTableView.setItems(null);
		}
	}
	
	public Dialog<Object> getParameterModal() {
		Dialog<Object> dialog = new Dialog<Object>();
		//dialog.initModality(Modality.APPLICATION_MODAL);
		dialog.setTitle("Parameters");
		DialogPane dp = new DialogPane();
		AnchorPane anchorPane= new AnchorPane();
		Button btn = new Button("Add..");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				anchorPane.setTopAnchor(btn,anchorPane.getTopAnchor(btn) + 30.0);
			}
		});
		ScrollPane scrollPane = new ScrollPane();
		anchorPane.setTopAnchor(btn, 10.0);
		anchorPane.setLeftAnchor(btn, 10.0);
		anchorPane.getChildren().add(btn);
		scrollPane.setContent(anchorPane);
		dp.setContent(scrollPane);
		dialog.setDialogPane(dp);
		dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		Node closeButton = dialog.getDialogPane().lookupButton(ButtonType.CLOSE);
		closeButton.managedProperty().bind(closeButton.visibleProperty());
        closeButton.setVisible(false);
        dialog.setHeight(300);
		return dialog;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
		logger.debug(this.mask);
	}

	public Stage getApplicationStage() {
		return applicationStage;
	}

	public void setApplicationStage(Stage applicationStage) {
		this.applicationStage = applicationStage;
	}
	
	public CheckBox getCheckbox(String checkBoxText, List<CheckBox>TestFileLinks) {
		for(CheckBox cbox : TestFileLinks) {
			if(cbox.getText().equalsIgnoreCase(checkBoxText))
				return cbox;
		}
		return null;
	}
	
	
	public void setDataToPrint() {
		printImage.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(mask.equalsIgnoreCase(Titles.THE_TIME.value)) {
					runnerTitle.setText("The Times Print");
					setBlankPanes(RunnerTitledPaneNational, RunnerTitledPaneIreland);
				}
				else if(mask.equalsIgnoreCase(Titles.SUN.value)) {
					runnerTitle.setText("The Sun Print");
					setBlankPanes(RunnerTitledPaneNational, RunnerTitledPaneIreland);
				}
				else if(mask.equalsIgnoreCase(Titles.SUNDAY_TIMES.value)) {
					runnerTitle.setText("Sunday Times Print");
					setBlankPanes(RunnerTitledPaneNational, RunnerTitledPaneIreland);
				}
				
			}
		});
	}
	
	public void setDataToTablet() {
		
		tabletImage.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(mask.equalsIgnoreCase(Titles.THE_TIME.value)) {
					runnerTitle.setText("The Times Tablet");
					List<CheckBox> ttNationalTabletRelatedTests = allTabletTestCaseFiles.get("ttNationalTablet");
					
					setDataToRunnerScene(ttNationalTabletRelatedTests, RunnerTitledPaneNational, Channels.TABLET.value, Region.NATIONAL.value);
					RunnerCountryAccordion.getPanes().get(0).setExpanded(true);
					
					List<CheckBox> ttIrishTabletRelatedTests = allTabletTestCaseFiles.get("ttIrishTablet");
					setDataToRunnerScene(ttIrishTabletRelatedTests, RunnerTitledPaneIreland, Channels.TABLET.value, Region.IRELAND.value);
				}
				else if(mask.equalsIgnoreCase(Titles.SUN.value)) {
					runnerTitle.setText("The Sun Tablet");
					setBlankPanes(RunnerTitledPaneNational, RunnerTitledPaneIreland);
				}
				else if(mask.equalsIgnoreCase(Titles.SUNDAY_TIMES.value)) {
					runnerTitle.setText("Sunday Times Tablet");
					List<CheckBox> stNationalTabletRelatedTests = allTabletTestCaseFiles.get("stNationalTablet");
					setDataToRunnerScene(stNationalTabletRelatedTests, RunnerTitledPaneNational, Channels.TABLET.value, Region.NATIONAL.value);
					RunnerCountryAccordion.getPanes().get(0).setExpanded(true);
					
					List<CheckBox> stIrishTabletRelatedTests = allTabletTestCaseFiles.get("stIrishTablet");
					setDataToRunnerScene(stIrishTabletRelatedTests, RunnerTitledPaneIreland, Channels.TABLET.value, Region.IRELAND.value);
				}
			}
		});
	}
	
	public void setDataToDigital() {
		digitalImage.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(mask.equalsIgnoreCase(Titles.THE_TIME.value)) {
					runnerTitle.setText("The Times Digital");
					setBlankPanes(RunnerTitledPaneNational, RunnerTitledPaneIreland);
				}
				else if(mask.equalsIgnoreCase(Titles.SUN.value)) {
					runnerTitle.setText("The Sun Digital");
					setBlankPanes(RunnerTitledPaneNational, RunnerTitledPaneIreland);
				}
				else if(mask.equalsIgnoreCase(Titles.SUNDAY_TIMES.value)) {
					runnerTitle.setText("Sunday Times Digital");
					setBlankPanes(RunnerTitledPaneNational, RunnerTitledPaneIreland);
				}
			}
		});
	}
	
	public void generateButtonImpl() {
		RunnerBtnGenerate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				StringBuilder manifestCodes = new StringBuilder();
				for (Map.Entry<String, List<String>> entry : storedValuesForData.entrySet()) {
					if (entry.getValue().size() > 0) {
						String[] channelsRegion = getChannelsRegion(entry);
						for(String str : channelsRegion)
							System.out.println(str);
						if(channelsRegion != null && channelsRegion[0] != null && channelsRegion[1] != null) {
							manifestCodes.append(generateManifestFile(entry.getValue(), channelsRegion[0], channelsRegion[1]));
						}
						
					}
				}
				if(manifestCodes.length() <= 0) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Empty Selection");
					alert.setContentText("Please choose some testcase files");
					Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
					stage.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("ic.png")));
					alert.showAndWait();
					return;
				}
				
				manifestCodes.insert(0, TitleString.getTestCaseTitleCommentString(mask));
				manifestCodes.insert(0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				+"<!DOCTYPE manifest SYSTEM \"../schema/manifest.dtd\">\n"
				+"<manifest>\n");
				manifestCodes.insert(manifestCodes.length(), "</manifest>");
////////////////////////////Dialog populating logics //////////////////////////////////////////////////
				DialogPane dp =  new DialogPane();
				System.err.println(ApplicationStage.getInstance());
				AnchorPane dialogAnchorPane = new AnchorPane();
				StackPane dialogStackPane = new StackPane();
				dialogStackPane.setMinWidth(ApplicationStage.getInstance().getWidth()-((ApplicationStage.getInstance().getWidth()*20)/100));
				dialogStackPane.setMinHeight((ApplicationStage.getInstance().getHeight()-((ApplicationStage.getInstance().getHeight()*20)/100)) - 30);
				VirtualizedScrollPane vpan = XMLEditorPane.getXmlEditorPane(manifestCodes.toString());
				dialogStackPane.getChildren().add(vpan);
				dialogAnchorPane.setTopAnchor(dialogStackPane, 33.0);
				dialogAnchorPane.setBottomAnchor(dialogStackPane, 0.0);
				dialogAnchorPane.setLeftAnchor(dialogStackPane, 0.0);
				dialogAnchorPane.setRightAnchor(dialogStackPane, 0.0);
				Button runButton = new Button("Run");
				dialogAnchorPane.setTopAnchor(runButton, 0.0);
				dialogAnchorPane.setRightAnchor(runButton, 0.0);
				dialogAnchorPane.getChildren().add(runButton);
				
				Button cancelButton = new Button("Cancel");
				dialogAnchorPane.setTopAnchor(cancelButton, 0.0);
				dialogAnchorPane.setRightAnchor(cancelButton, 50.0);
				dialogAnchorPane.getChildren().add(cancelButton);
				
				dialogAnchorPane.getChildren().add(dialogStackPane);
				dp.setContent(dialogAnchorPane);
				dp.getStylesheets().add(getClass().getClassLoader().getResource("xml-highlighting.css").toExternalForm());
				SimpleDialogGenerator.getSimpleDialogGenerator().generateDialog("Run Selected TestCases", dp);
				
				runButton.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						CodeArea cArea = (CodeArea)vpan.getChildrenUnmodifiable().get(0);
						
				        try {
				        	Statement stmt = SqlLiteDBImpls.getStatement();
							String sql = "INSERT INTO MANIFESTS (TIMESTAMP, TITLE, MANIFEST_TEXT) VALUES ('"+new Date().getTime()+"', '"+TitleString.getGeneralTitle(mask)+"', '"+cArea.getText()+"')";
							stmt.executeUpdate(sql);
							runButton.setDisable(true);
							vpan.setDisable(true);
				        	stmt.close();
				        	Files.write(Paths.get("manifests/manifest.xml"), cArea.getText().getBytes());
				        	GenClasses genClassz = new GenClasses();
				        	genClassz.generate();
				        	String testcasesBaseDir = MainApp.configProperties.getProperty("base.autocam.gen.testcases.base.dir");
				        	DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(testcasesBaseDir+"/Tablet/"));
				        	logger.debug("=================================== " + System.getProperty("java.home"));
				        	System.setProperty("java.home", MainApp.configProperties.getProperty("java.home.dir"));
				        	logger.debug("=================================== " + System.getProperty("java.home"));
				        	JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
				        	DiagnosticCollector<JavaFileObject> diagnosticCollector = new DiagnosticCollector<JavaFileObject>();
				        	List<String> filesList = new ArrayList<String>();
				        	for(Path entry: stream) {
				        		filesList.add(entry.toAbsolutePath().toString());				        	
				        	}
				        	stream.close();
				        	logger.debug("+++++++++++++++++++++++++++++++++++ " + compiler);
				        	
				        	DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
				        	StandardJavaFileManager sjfm = compiler.getStandardFileManager(diagnostics, null, null);
				        	Iterable fileObjects = sjfm.getJavaFileObjectsFromStrings(filesList);
				        	List<String> classpathList = new ArrayList<>();
				        	classpathList.addAll(Arrays.asList("-classpath", System.getProperty("java.class.path")));
				        	logger.debug("*********************************** " + classpathList);
				        	
				        	//StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
				        	JavaCompiler.CompilationTask task = compiler.getTask(null, sjfm, diagnostics, classpathList, null, fileObjects);
				        	
				        	task.call();
				        	
				        	for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
				        	      logger.debug(" Diagnostic getCode " +diagnostic.getCode());
				        	      logger.debug(" Diagnostic get Kind" +diagnostic.getKind());
				        	      logger.debug(" Diagnostic get Position " + diagnostic.getPosition());
				        	      logger.debug(" Diagnostic get start Postion " + diagnostic.getStartPosition());
				        	      logger.debug(" Diagnostic get end Position " + diagnostic.getEndPosition());
				        	      logger.debug(" Diagnostic get Source " + diagnostic.getSource());
				        	      logger.debug(" Diagnostic get Message " +diagnostic.getMessage(null));
				        	      
				        	      if(diagnostic.getKind().toString().equalsIgnoreCase(Kind.ERROR.toString())) {
				        	    	  CustomDialogImpl.getCustomDialogImpl().errorDialog(Kind.ERROR.toString()+ " " + diagnostic.getCode(), diagnostic.getMessage(null)+"\n"+diagnostic.getCode() +"\n" + diagnostic.getSource());
				        	    	  return;
				        	      }
				        	    }
				        	
				        	sjfm.close();
				        	logger.debug(System.getProperty("java.class.path"));
				        	//Executing Methode Application with different thread
				        	Runnable runnableTask = new Runnable() {
				                public void run() {
				                	Platform.runLater(new Runnable() {
					                    @Override
					                    public void run() {
					                    	try {
												Application.main(null);
											} catch (Exception e) {
												e.printStackTrace();
											}
					                    }
					                });
				                }
				            };
				            // Run the task in a background thread
				            Thread backgroundThread = new Thread(runnableTask);
				            // Terminate the running thread if the application exits
				            backgroundThread.setDaemon(true);
				            // Start the thread
				            backgroundThread.start();
				            cancelButton.setOnAction(new EventHandler<ActionEvent>() {	
								@Override
								public void handle(ActionEvent ae) {
									logger.debug("Command to kill Methode Testinf is fired");
									AutoItX methode = new AutoItX();
									methode.winClose("[CLASS:Methode]");
									backgroundThread.destroy();
								}
							});
				            
				            
				            /*Task concurrentyTask = new Task<Void>() {
				                @Override public Void call() {
				                	try {
										Application.main(null);
									} catch (Exception e) {
										e.printStackTrace();
									}
									return null;
				                }
				            };
				            Thread methodeApplication = new Thread(concurrentyTask);
				            methodeApplication.start();
				            cancelButton.setOnAction(new EventHandler<ActionEvent>() {	
								@Override
								public void handle(ActionEvent ae) {
									logger.debug("Command to kill Methode Testinf is fired");
									AutoItX methode = new AutoItX();
									methode.winClose("[CLASS:Methode]");
									methodeApplication.destroy();
								}
							});*/
						} catch (Throwable e) {
							logger.debug("---------------------------------------------------------------------------------------------------------------------------------");
							e.printStackTrace();
						}
					}
				});
			}
		});
	}
	
	public String[] getChannelsRegion(Entry entry) {
		String[] titleChanels = new String[2];
		if (entry.getKey().equals(Channels.TABLET.value + Region.NATIONAL.value)) {
			titleChanels[0] = Channels.TABLET.value;
			titleChanels[1] = Region.NATIONAL.value;
		}
		else if (entry.getKey().equals(Channels.TABLET.value + Region.IRELAND.value)) {
			titleChanels[0] = Channels.TABLET.value;
			titleChanels[1] = Region.IRELAND.value;
		}
		else if (entry.getKey().equals(Channels.DIGITAL.value + Region.NATIONAL.value)) {
			titleChanels[0] = Channels.DIGITAL.value;
			titleChanels[1] = Region.NATIONAL.value;
		}
		else if (entry.getKey().equals(Channels.DIGITAL.value + Region.IRELAND.value)) {
			titleChanels[0] = Channels.DIGITAL.value;
			titleChanels[1] = Region.IRELAND.value;
		}
		else if (entry.getKey().equals(Channels.PRINT.value + Region.NATIONAL.value)) {
			titleChanels[0] = Channels.PRINT.value;
			titleChanels[1] = Region.NATIONAL.value;
		}
		else if (entry.getKey().equals(Channels.PRINT.value + Region.IRELAND.value)) {
			titleChanels[0] = Channels.PRINT.value;
			titleChanels[1] = Region.IRELAND.value;
		}
		else {
			titleChanels = null;
		}
		return titleChanels;
	}
		
	public void setButtonsLooks() {
		printImage.setPrefWidth(defaultIconSize);
		printImage.setPrefHeight(defaultIconSize);
		
		tabletImage.setPrefWidth(defaultIconSize);
		tabletImage.setPrefHeight(defaultIconSize);
		
		digitalImage.setPrefWidth(defaultIconSize);
		digitalImage.setPrefHeight(defaultIconSize);
		

		BackgroundSize backgroundSize = new BackgroundSize(defaultIconSize, defaultIconSize, true, true, true, true);
		printImage.setBackground(new Background(new BackgroundImage(new Image(getClass().getClassLoader().getResourceAsStream("print.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize)));
		tabletImage.setBackground(new Background(new BackgroundImage(new Image(getClass().getClassLoader().getResourceAsStream("tablet.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize)));
		digitalImage.setBackground(new Background(new BackgroundImage(new Image(getClass().getClassLoader().getResourceAsStream("digital.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize)));
		
		printImage.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				printImage.setPrefWidth(mouseEnterIconSize);
				printImage.setPrefHeight(mouseEnterIconSize);
				printImage.setOpacity(mouseEnterAlphaValue);
			}
		});
		
		printImage.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				printImage.setPrefWidth(defaultIconSize);
				printImage.setPrefHeight(defaultIconSize);
				printImage.setOpacity(mouseExitAlphaValue);
			}
		});
		printImage.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				printImage.setPrefWidth(mouseClickedIconSize);
				printImage.setPrefHeight(mouseClickedIconSize);
				printImage.setOpacity(mouseClickedAlphaValue);
			}
		});
		
		
		
		
		tabletImage.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				tabletImage.setPrefWidth(mouseEnterIconSize);
				tabletImage.setPrefHeight(mouseEnterIconSize);
				tabletImage.setOpacity(mouseEnterAlphaValue);
			}
		});
		
		tabletImage.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				tabletImage.setPrefWidth(defaultIconSize);
				tabletImage.setPrefHeight(defaultIconSize);
				tabletImage.setOpacity(mouseExitAlphaValue);
			}
		});
		
		tabletImage.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				tabletImage.setPrefWidth(mouseClickedIconSize);
				tabletImage.setPrefHeight(mouseClickedIconSize);
				tabletImage.setOpacity(mouseClickedAlphaValue);
			}
		});
		
		
		digitalImage.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				digitalImage.setPrefWidth(mouseEnterIconSize);
				digitalImage.setPrefHeight(mouseEnterIconSize);
				digitalImage.setOpacity(mouseEnterAlphaValue);
			}
		});
		
		digitalImage.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				digitalImage.setPrefWidth(defaultIconSize);
				digitalImage.setPrefHeight(defaultIconSize);
				digitalImage.setOpacity(mouseExitAlphaValue);
			}
		});
		
		digitalImage.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				digitalImage.setPrefWidth(mouseClickedIconSize);
				digitalImage.setPrefHeight(mouseClickedIconSize);
				digitalImage.setOpacity(mouseClickedAlphaValue);
			}
		});
	}
}
