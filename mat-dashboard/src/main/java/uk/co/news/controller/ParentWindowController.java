package uk.co.news.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.sun.tools.extcheck.Main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uk.co.news.main.MainApp;
import uk.co.news.utils.SqlLiteDBImpls;
import uk.co.news.utils.Titles;
import uk.co.news.view.ALLViews;

public class ParentWindowController implements Initializable{
	Logger logger = Logger.getLogger(ParentWindowController.class);
	private Stage applicationStage;
	
	@FXML
	private MenuBar  menuBar;
	@FXML
	private MenuItem menuFileHome;
	@FXML
	private MenuItem parentMenuNewRunnerTT;
	@FXML
	private MenuItem parentMenuNewRunnerST;
	@FXML
	private MenuItem parentMenuNewRunnerSun;
	@FXML
	private MenuItem menuFileNewTestCase;
	@FXML
	private Menu menuFileRecentHistory;
	@FXML
	private MenuItem menuFileClose;
	@FXML
	private MenuItem menuEditTestCase;
	@FXML
	private MenuItem menuEditManifest;
	@FXML
	private Menu menuSettings;
	@FXML
	private MenuItem menuHelpUserManual;
	@FXML
	private MenuItem menuHelpAboutTool;
	@FXML
	private MenuItem menuHelpVersion;
	@FXML
	private AnchorPane parentContainerPane;
	@FXML
	private MenuItem menuItemSettings;
	
	
	
	public void initialize(URL location, ResourceBundle resource) {
		String applicationTitle = MainApp.configProperties.getProperty("application.title");
		logger.debug("initializing parent window...");
		final ALLViews allViews = MainApp.allViews;
		homePage(applicationTitle, allViews);
		menuFileHome.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				homePage(applicationTitle, allViews);
			}
		});
		parentMenuNewRunnerTT.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				runnerWindowTT(applicationTitle, allViews);
			}
		});
		
		parentMenuNewRunnerST.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				runnerWindowST(applicationTitle, allViews);
			}
		});
		
		parentMenuNewRunnerSun.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				runnerWindowSun(applicationTitle, allViews);
			}
		});
		
		menuEditTestCase.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				editTestCase(applicationTitle, allViews);
			}
		});
		
		menuItemSettings.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				editSettings(applicationTitle, allViews);
			}
		});
		
	}
	
	public void setSceneToParentWindow(AnchorPane parentAnchorPane, Parent childAnchorPane) {
		parentAnchorPane.setTopAnchor(childAnchorPane, 0.0);
		parentAnchorPane.setLeftAnchor(childAnchorPane, 0.0);
		parentAnchorPane.setRightAnchor(childAnchorPane, 0.0);
		parentAnchorPane.setBottomAnchor(childAnchorPane, 0.0);
		parentAnchorPane.getChildren().add(childAnchorPane);
	}

	public Stage getApplicationStage() {
		return applicationStage;
	}

	public void setApplicationStage(Stage applicationStage) {
		this.applicationStage = applicationStage;
	}
	
	
	public void getManifestHistory() {
		List<MenuItem> manifestHistoryItems = new ArrayList<MenuItem>();
		try {
			Statement stmt = SqlLiteDBImpls.getStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM MANIFESTS ORDER BY TIMESTAMP DESC LIMIT 5;" );
			while (rs.next()) {
				Date time = new Date(Long.parseLong(rs.getString("timestamp")));
				MenuItem menuItem = new MenuItem(time.toString());
				menuItem.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						
					}
					
				});
				manifestHistoryItems.add(menuItem);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void homePage(String applicationTitle, ALLViews allViews) {
		try {
			logger.debug("initializing home dashboard page window...");
			setSceneToParentWindow(parentContainerPane, allViews.getHomeDashboard().load());
			MainApp.applicationStage.setTitle(applicationTitle+" | Home");
			logger.debug("done");
		} catch (IOException e1) {
			logger.debug(e1.getMessage());
		}
	}
	
	public void runnerWindowTT(String applicationTitle, ALLViews allViews) {
		parentContainerPane.getChildren().clear();
		try {
			logger.debug("initializing runner window...");
			FXMLLoader runnerWindowNew = allViews.getRunnerWindowNew();
			setSceneToParentWindow(parentContainerPane, runnerWindowNew.load());
			logger.debug("getting runner window controller..");
			RunnerWindowControllerNew controller = runnerWindowNew.<RunnerWindowControllerNew>getController();
			logger.debug(controller);
			//System.out.println(Titles.THE_TIME.value + "   "+ Titles.SUNDAY_TIMES.value  + "  " + Titles.SUN.value);
			logger.debug("Setting title mask to runner window " + Titles.THE_TIME.value);
			controller.setMask(Titles.THE_TIME.value);
			MainApp.applicationStage.setTitle(applicationTitle+" | The Times | Runner");
		} catch (IOException e) {
			logger.debug(e.getStackTrace());
		}
	}
	
	public void runnerWindowST(String applicationTitle, ALLViews allViews) {
		parentContainerPane.getChildren().clear();
		try {
			FXMLLoader runnerWindowNew = allViews.getRunnerWindowNew();
			setSceneToParentWindow(parentContainerPane, runnerWindowNew.load());
			RunnerWindowControllerNew controller = runnerWindowNew.<RunnerWindowControllerNew>getController();
			System.out.println(controller);
			controller.setMask(Titles.SUNDAY_TIMES.value);
			MainApp.applicationStage.setTitle(applicationTitle+" | Sunday Times | Runner");
		} catch (IOException e) {
			logger.debug(e.getStackTrace());
		}
	}
	
	public void runnerWindowSun(String applicationTitle, ALLViews allViews) {
		parentContainerPane.getChildren().clear();
		try {
			FXMLLoader runnerWindowNew = allViews.getRunnerWindowNew();
			setSceneToParentWindow(parentContainerPane, runnerWindowNew.load());
			RunnerWindowControllerNew controller = runnerWindowNew.<RunnerWindowControllerNew>getController();
			System.out.println(controller);
			controller.setMask(Titles.SUN.value);
			MainApp.applicationStage.setTitle(applicationTitle+" | The Sun | Runner");
		} catch (IOException e) {
			logger.debug(e.getStackTrace());
		}
	}
	
	public void editTestCase(String applicationTitle, ALLViews allViews) {
		parentContainerPane.getChildren().clear();
		try {
			setSceneToParentWindow(parentContainerPane, allViews.getTestCaseEditorWindowNew().load());
		} catch (IOException e) {
			logger.debug(e.getStackTrace());
		}
	}
	
	public void editSettings(String applicationTitle, ALLViews allViews) {
		FXMLLoader settingsWindow = allViews.getGeneralSettingsWindow();
		try {
			setSceneToParentWindow(parentContainerPane, settingsWindow.load());
		} catch (IOException e) {
			logger.debug(e.getStackTrace());
			e.printStackTrace();
		}
	}
	
	

}
