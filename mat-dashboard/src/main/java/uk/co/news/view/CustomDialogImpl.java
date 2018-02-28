package uk.co.news.view;

import org.apache.log4j.Logger;

import com.sun.tools.extcheck.Main;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import uk.co.news.main.MainApp;
import uk.co.news.utils.ApplicationStage;

public class CustomDialogImpl {
	private static CustomDialogImpl customDialogImpl = new CustomDialogImpl(); 
	static final Logger logger = Logger.getLogger(CustomDialogImpl.class);
	
	private CustomDialogImpl() {}
	
	public void errorDialog(String errHeader, StackTraceElement[] message) {
		errorDialog(errHeader, getErrorMessageFromStackTrace(message));
	}
	public void errorDialog(Exception e) {
		errorDialog(e.getMessage(), e.getStackTrace());
	}
	
	public void errorDialog(String errHeader, String message) {
		logger.debug("Error Dialog Err header Message " + errHeader);
		logger.debug("Error Dialog Err body Message " + message);
		Dialog customDialog = new Dialog<>();
		
		DialogPane customErrorDialog = new DialogPane();
		AnchorPane anchorPane = new AnchorPane();
		
		Label img  = new Label();
		img.getStyleClass().addAll("alert", "error", "dialog-pane");
		anchorPane.setRightAnchor(img, 0.0d);
		anchorPane.setTopAnchor(img, 0.0);
		anchorPane.getChildren().add(img);
		
		Label erroMessge = new Label(errHeader);
		erroMessge.setTextFill(Color.RED);
		erroMessge.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		anchorPane.setLeftAnchor(erroMessge, 0.0d);
		anchorPane.setRightAnchor(erroMessge, 40.0d);
		anchorPane.setTopAnchor(erroMessge, 10.0);
		anchorPane.getChildren().add(erroMessge);
		
		TextArea txa = new TextArea(message);
		txa.setEditable(false);
		txa.setScrollLeft(Double.MIN_VALUE);
		txa.setScrollTop(Double.MIN_VALUE);
		anchorPane.setLeftAnchor(txa, 0.0);
		anchorPane.setRightAnchor(txa, 0.0);
		anchorPane.setTopAnchor(txa, 100.0);
		anchorPane.setBottomAnchor(txa, 40.0);
		anchorPane.getChildren().add(txa);
		
		Button closeOkButton = new Button("ok");
		closeOkButton.setMaxSize(20.0, 15.0);
		closeOkButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				customDialog.close();
			}
		});
		anchorPane.setBottomAnchor(closeOkButton, 5.0);
		anchorPane.setRightAnchor(closeOkButton, 5.0);
		anchorPane.getChildren().add(closeOkButton);
		
		customErrorDialog.setContent(anchorPane);
		customDialog.setDialogPane(customErrorDialog);
		
		customDialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		Node closeButton = customDialog.getDialogPane().lookupButton(ButtonType.CLOSE);
		closeButton.managedProperty().bind(closeButton.visibleProperty());
        closeButton.setVisible(false);
        customDialog.setTitle("Error");
        
        customDialog.setWidth(Math.floor(ApplicationStage.getInstance().getWidth()*80/100));
        customDialog.setHeight(Math.floor(ApplicationStage.getInstance().getHeight()*80 / 100));
        customDialog.setX(ApplicationStage.getInstance().getX() +  Math.floor(ApplicationStage.getInstance().getWidth()*80/100)/2);
        customDialog.setY(ApplicationStage.getInstance().getY() + Math.floor(ApplicationStage.getInstance().getHeight()*80 / 100)/2);
        
        
        ((Stage) customDialog.getDialogPane().getScene().getWindow()).getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("ic.png")));
        customDialog.show();
		
	}
	public static CustomDialogImpl getCustomDialogImpl() {
		return customDialogImpl;
	}
	
	public String getErrorMessageFromStackTrace(StackTraceElement[] stackTraceElements) {
		StringBuilder sb = new StringBuilder();
		for (StackTraceElement ste : stackTraceElements) {
	        sb.append("\n\tat ");
	        sb.append(ste);
	    }
		return sb.toString();
	}
}
