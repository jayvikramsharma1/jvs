package uk.co.news.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import uk.co.news.main.MainApp;

public class HomeDashboardController implements Initializable {
	Logger logger = Logger.getLogger(HomeDashboardController.class);
	
	@FXML
	private AnchorPane homeDashboardAnchorPane;
	@FXML
	private WebView homeDashboardWebView;
	
	public void initialize(URL location, ResourceBundle resources) {
		logger.debug("Loading application web based home dashboard page");
		WebEngine webEngine = homeDashboardWebView.getEngine();
		logger.debug("Web engine " + "Chrome/41.0.2228.0");
		webEngine.setUserAgent("Chrome/41.0.2228.0");
		logger.debug("dashboard url " + MainApp.configProperties.getProperty("home.dashboard.url"));
		webEngine.load(MainApp.configProperties.getProperty("home.dashboard.url"));
	}

}
