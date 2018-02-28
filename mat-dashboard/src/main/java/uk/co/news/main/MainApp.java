package uk.co.news.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.BindException;
import java.net.ServerSocket;
import java.util.Properties;

import org.apache.log4j.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import uk.co.news.controller.ParentWindowController;
import uk.co.news.view.ALLViews;

public class MainApp extends Application{
	Logger logger = Logger.getLogger(MainApp.class);
	public static Stage applicationStage;
	public static Properties configProperties = new Properties();
	public static final ALLViews allViews = new ALLViews();
	private ServerSocket applicationSocket;
	public static ParentWindowController parentWindowController;
	
	public static Font fontAwesome = null;
	
	@Override
	public void start(Stage stage) throws Exception {
		logger.debug("Loading Application...");
		this.applicationStage = stage;
		logger.debug("Application stage loaded");
		//getClass().getClassLoader().getResourceAsStream("appconfig.properties");
		configProperties.load(new FileInputStream("config/appconfig.properties"));
		logger.debug("Application configuration file loaded");	
		Rectangle2D primaryScreenBound = Screen.getPrimary().getVisualBounds();
		FXMLLoader parentWindow = new FXMLLoader(getClass().getClassLoader().getResource("parent_window.fxml"));
		Scene scene = new Scene(parentWindow.load());
		parentWindowController = parentWindow.<ParentWindowController>getController();
		parentWindowController.setApplicationStage(stage);
		logger.debug("parent window loaded");
		
		
		logger.debug("Adding Font Awesome to Application");
		getFontAwesome(12);
		
		
		scene.getStylesheets().add(this.getClass().getClassLoader().getResource("xml-highlighting.css").toExternalForm());
		stage.setScene(scene);
		stage.setX(primaryScreenBound.getMinX());
		stage.setY(primaryScreenBound.getMinY());
		stage.setWidth(primaryScreenBound.getWidth());
		stage.setHeight(primaryScreenBound.getHeight());
		logger.debug("application loaded showing stage...");
		stage.setTitle(MainApp.configProperties.getProperty("application.title"));
		stage.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("ic.png")));
		try {
			applicationSocket = new ServerSocket(Integer.parseInt(configProperties.getProperty("application.port")));
		} catch (BindException e) {
		   Alert alert = new Alert(AlertType.ERROR, "Instance is already running", ButtonType.OK);
		   alert.showAndWait();
		   System.exit(0);
		}
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Font getFontAwesome(double size) {
		try {
			fontAwesome = Font.loadFont(new FileInputStream("fonts/fontawesome-webfont.ttf"), size);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fontAwesome;
	}
	
	

}
