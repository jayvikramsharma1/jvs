package uk.news.ui.test1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TestMain extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		//stage.initStyle(StageStyle.TRANSPARENT);
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ShowFiles.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
