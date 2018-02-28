package uk.co.news.utils;

import java.io.InputStream;

import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import uk.co.news.main.MainApp;

public class SimpleDialogGenerator {
	private static SimpleDialogGenerator simpleDialogGenerator = new SimpleDialogGenerator();
	private SimpleDialogGenerator() {
		
	}
	public Dialog<Object> generateDialog(String title, DialogPane dp) {
		System.out.println(ApplicationStage.getInstance());
		double width = ApplicationStage.getInstance().getWidth()-((ApplicationStage.getInstance().getWidth()*20)/100);
		double height = ApplicationStage.getInstance().getHeight()-((ApplicationStage.getInstance().getHeight()*20)/100);
		Dialog<Object> dialog = new Dialog<>();
		dialog.setTitle(title);
		dialog.setDialogPane(dp);
		dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		Node closeButton = dialog.getDialogPane().lookupButton(ButtonType.CLOSE);
		closeButton.managedProperty().bind(closeButton.visibleProperty());
        closeButton.setVisible(false);
        dialog.setWidth(width);
		dialog.setHeight(height);
		dialog.setX(ApplicationStage.getInstance().getX());
		dialog.setY(ApplicationStage.getInstance().getY());
		Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("ic.png")));
		/*Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();*/
		
		dialog.show();
		return dialog;
	}
	public static SimpleDialogGenerator getSimpleDialogGenerator() {
		return simpleDialogGenerator;
	}
}
