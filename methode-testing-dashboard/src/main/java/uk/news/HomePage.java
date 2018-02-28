package uk.news;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import uk.news.ui.component.TopMenuBar;

public class HomePage extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Pane root = new Pane();
		root.prefHeight(600);
		root.prefWidth(600);
		Pane parentPane = new Pane();
		parentPane.prefHeight(600);
		parentPane.prefWidth(600);
		parentPane.getChildren().add(TopMenuBar.menuPane());
		root.getChildren().add(parentPane);
		Scene scene = new Scene(root, 600, 600);
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
		String imageSrc = "";
	}
	
	 
}
