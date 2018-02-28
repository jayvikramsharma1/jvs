package uk.co.news.controller;

import java.io.File;
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

import javax.tools.DiagnosticCollector;
import javax.tools.FileObject;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.log4j.Logger;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import uk.co.news.dto.RunnerTableViewDataObject;
import uk.co.news.dto.RunnerTableViewForCheckboxes;
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
import uk.co.news.view.XMLEditorPane;

public class RunnerWindowController implements Initializable{
	static Logger logger = Logger.getLogger(RunnerWindowController.class);
	private Stage applicationStage;
	
	@FXML
	private Hyperlink RunnerAccordionTTPrint;
	@FXML
	private Hyperlink RunnerAccordionTTTablet;
	@FXML
	private Hyperlink RunnerAccordionTTDigital;
	@FXML
	private Hyperlink RunnerAccordionSTPrint;
	@FXML
	private Hyperlink RunnerAccordionSTTablet;
	@FXML
	private Hyperlink RunnerAccordionSTDigital;
	@FXML
	private Hyperlink RunnerAccordionSunPrint;
	@FXML
	private TitledPane RunnerTitledPaneNational;
	@FXML
	private TitledPane RunnerTitledPaneIreland;
	@FXML
	private Button RunnerBtnGenerate;
	@FXML
	private Accordion RunnerCountryAccordion;
	@FXML
	private TitledPane RunnerAccordionTT;
	@FXML
	private TitledPane RunnerAccordionST;
	@FXML
	private TitledPane RunnerAccordionSun;
	
	@FXML
	private TableColumn<RunnerTableViewDataObject, String> runnerTableViewColumnSno;
	@FXML
	private TableColumn<RunnerTableViewDataObject, String> runnerTableViewColumnRegion;
	@FXML
	private TableColumn<RunnerTableViewDataObject, String> runnerTableViewColumnTestCases;
	@FXML
	private TableView<RunnerTableViewDataObject> runnerTableView;
	
	private TableView<RunnerTableViewForCheckboxes> runnerTableViewForCheckboxes = new TableView<>();
	
	private String mask;
	private Map<String, List<String>> storedValuesForData;
	static final String PATH = MainApp.configProperties.getProperty("base.autocam.dir");
	final Map<String, List<CheckBox>> allTabletTestCaseFiles = TestFileExplorer.getTabletFiles(PATH+MainApp.configProperties.getProperty("base.autocam.testcases.tablet"));
	final Map<String, List<CheckBox>> allDigitalTestCaseFiles = TestFileExplorer.getTabletFiles(PATH+MainApp.configProperties.getProperty("base.autocam.testcases.digital"));
	final Map<String, List<CheckBox>> allPrintTestCaseFiles = TestFileExplorer.getTabletFiles(PATH+MainApp.configProperties.getProperty("base.autocam.testcases.print"));
	
	public void initialize(URL location, ResourceBundle resources) {
		logger.debug("Resource Path :  " + PATH);
		storedValuesForData = new LinkedHashMap<>();
		storedValuesForData.put(Channels.TABLET.value+Region.NATIONAL.value, new ArrayList<String>());
		storedValuesForData.put(Channels.TABLET.value+Region.IRELAND.value, new ArrayList<String>());
		storedValuesForData.put(Channels.DIGITAL.value+Region.NATIONAL.value, new ArrayList<String>());
		storedValuesForData.put(Channels.DIGITAL.value+Region.IRELAND.value, new ArrayList<String>());
		storedValuesForData.put(Channels.PRINT.value+Region.NATIONAL.value, new ArrayList<String>());
		storedValuesForData.put(Channels.PRINT.value+Region.IRELAND.value, new ArrayList<String>());
		TableColumn<RunnerTableViewForCheckboxes, CheckBox> TestCaseColumns = new TableColumn("Test Cases");
		TestCaseColumns.setCellValueFactory(new PropertyValueFactory<RunnerTableViewForCheckboxes, CheckBox>("checkbox"));
		runnerTableViewForCheckboxes.getColumns().addAll(TestCaseColumns);
		
		runnerTableViewColumnSno.setCellValueFactory(new PropertyValueFactory<RunnerTableViewDataObject, String>("sno"));
		runnerTableViewColumnRegion.setCellValueFactory(new PropertyValueFactory<RunnerTableViewDataObject, String>("region"));
		runnerTableViewColumnTestCases.setCellValueFactory(new PropertyValueFactory<RunnerTableViewDataObject, String>("testCase"));
		runnerTableViewColumnTestCases.setCellValueFactory(new PropertyValueFactory<RunnerTableViewDataObject, String>("toolButton"));
		setDataToTTTablet();
		setDataToSTTablet();
		setDataToTTPrint();
		setDataToSTPrint();
		setDataToSunPrint();
		setDataToTTDigital();
		setDataToSTDigital();
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
		//ScrollPane scrollPane = new ScrollPane();
		//GridPane gridPane = new GridPane();
		//gridPane.setVgap(4);
		//gridPane.setPadding(new Insets(5, 5, 5, 5));
		//int count = 0;
		
		//////////////////
		ObservableList<RunnerTableViewForCheckboxes> tableData = FXCollections.observableArrayList();
		//int count = 0;
		if(TestFileLinks.size() > 0) {
			for(CheckBox testFiles : TestFileLinks) {
				if(!testFiles.getText().equals("") && testFiles != null) {
					testFiles.setOnAction(new EventHandler<ActionEvent>() {
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
							setDataToOrderedTableView(storedValuesForData.get(channel+region), channel, region);
						}
					});
					tableData.add(new RunnerTableViewForCheckboxes(testFiles));
				}
			}
			runnerTableViewForCheckboxes.setItems(tableData);
		}
		else {
			runnerTableViewForCheckboxes.setItems(null);
		}
		titledPane.setContent(runnerTableViewForCheckboxes);
		///////////////////////
		
		/*for(CheckBox testFile : TestFileLinks) {
			gridPane.add(testFile, 0, count++);
			scrollPane.setContent(gridPane);
			titledPane.setContent(scrollPane);
			//testFile.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
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
					setDataToOrderedTableView(storedValuesForData.get(channel+region), channel, region);
				}
			});
		}*/
	}
	
	public void setBlankPanes(TitledPane titledPaneNational, TitledPane titledPaneIreland) {
		titledPaneNational.setContent(null);
		titledPaneIreland.setContent(null);
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
	
	public void setDataToOrderedTableView(List<String> testFileList, String channel, String region){
		ObservableList<RunnerTableViewDataObject> tableData = FXCollections.observableArrayList();
		int count = 0;
		if(testFileList.size() > 0) {
			for(String testFiles : testFileList) {
				if(!testFiles.equals("") && testFiles != null) {
					Button toolBtn = new Button();
					toolBtn.setFont(MainApp.fontAwesome);
					toolBtn.setText(AwesomeIcons.ICON_CLOSE);
					toolBtn.setId(testFiles);
					tableData.add(new RunnerTableViewDataObject(++count, region, testFiles, toolBtn, new Button("Add Parameters")));
				}
			}
			runnerTableView.setItems(tableData);
		}
		else {
			runnerTableView.setItems(null);
		}
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
		if(this.mask.equalsIgnoreCase(Titles.THE_TIME.value)) {
			RunnerAccordionTT.setDisable(false);
			RunnerAccordionST.setDisable(true);
			RunnerAccordionSun.setDisable(true);
		}
		else if(this.mask.equalsIgnoreCase(Titles.SUN.value)) {
			RunnerAccordionTT.setDisable(true);
			RunnerAccordionST.setDisable(true);
			RunnerAccordionSun.setDisable(false);
		}
		else if(this.mask.equalsIgnoreCase(Titles.SUNDAY_TIMES.value)) {
			RunnerAccordionTT.setDisable(true);
			RunnerAccordionST.setDisable(false);
			RunnerAccordionSun.setDisable(true);
		}
	}

	public Stage getApplicationStage() {
		return applicationStage;
	}

	public void setApplicationStage(Stage applicationStage) {
		this.applicationStage = applicationStage;
	}
	
	public void setDataToTTTablet() {
		RunnerAccordionTTTablet.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				List<CheckBox> ttNationalTabletRelatedTests = allTabletTestCaseFiles.get("ttNationalTablet");
				
				setDataToRunnerScene(ttNationalTabletRelatedTests, RunnerTitledPaneNational, Channels.TABLET.value, Region.NATIONAL.value);
				//System.out.println(ttNationalTabletSelectedFileList);
				
				
				RunnerCountryAccordion.getPanes().get(0).setExpanded(true);
				
				List<CheckBox> ttIrishTabletRelatedTests = allTabletTestCaseFiles.get("ttIrishTablet");
				setDataToRunnerScene(ttIrishTabletRelatedTests, RunnerTitledPaneIreland, Channels.TABLET.value, Region.IRELAND.value);
				//System.out.println(ttIrishTabletSelectedFileList);
			
			}
		});	
	}
	
	public void setDataToSTTablet() {
		RunnerAccordionSTTablet.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				List<CheckBox> stNationalTabletRelatedTests = allTabletTestCaseFiles.get("stNationalTablet");
				setDataToRunnerScene(stNationalTabletRelatedTests, RunnerTitledPaneNational, Channels.TABLET.value, Region.NATIONAL.value);
				//System.out.println(stNationalTabletSelectedFileList);
				RunnerCountryAccordion.getPanes().get(0).setExpanded(true);
				
				List<CheckBox> stIrishTabletRelatedTests = allTabletTestCaseFiles.get("stIrishTablet");
				setDataToRunnerScene(stIrishTabletRelatedTests, RunnerTitledPaneIreland, Channels.TABLET.value, Region.IRELAND.value);
				//System.out.println(stIrishTabletSelectedFileList);
			}
		});
	}
	
	public void setDataToTTPrint() {
		RunnerAccordionTTPrint.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				setBlankPanes(RunnerTitledPaneNational, RunnerTitledPaneIreland);
			}
		});
	}
	
	public void setDataToSTPrint() {
		RunnerAccordionSTPrint.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				setBlankPanes(RunnerTitledPaneNational, RunnerTitledPaneIreland);
			}
		});
	}
	
	public void setDataToSunPrint() {
		RunnerAccordionSunPrint.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				setBlankPanes(RunnerTitledPaneNational, RunnerTitledPaneIreland);
			}
		});
	}
	
	public void setDataToTTDigital() {
		RunnerAccordionTTDigital.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				setBlankPanes(RunnerTitledPaneNational, RunnerTitledPaneIreland);
			}
		});
	}
	
	public void setDataToSTDigital() {
		RunnerAccordionSTDigital.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				setBlankPanes(RunnerTitledPaneNational, RunnerTitledPaneIreland);
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
				        	logger.debug("Compiler :  " + compiler);
				        	
				        	StandardJavaFileManager sjfm = compiler.getStandardFileManager(null, null, null);
				        	Iterable fileObjects = sjfm.getJavaFileObjectsFromStrings(filesList);
				        	List<String> classpathList = new ArrayList<>();
				        	classpathList.addAll(Arrays.asList("-classpath", System.getProperty("java.class.path")));
				        	logger.debug("ClasspathLists ::  " + classpathList);
				        	JavaCompiler.CompilationTask task = compiler.getTask(null, null, null, classpathList, null, fileObjects);
				        	
				        	task.call();
				        	sjfm.close();
				        	System.out.println(System.getProperty("java.class.path"));
				        	Application.main(null);
						} catch (Exception e) {
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
	
	
	public void addJavaFilesToJavaClassPath(String javaSourceDirectory) {
		try {
			DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(javaSourceDirectory));
			for(Path path : directoryStream) {
				if(path.toString().endsWith(".java")) {
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
