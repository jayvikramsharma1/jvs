package uk.news.ui.component;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.Pane;

public class TopMenuBar {
	public static Pane menuPane() {
		Pane mPane = new Pane();
		MenuBar topMenuBar = new MenuBar();
		
		Menu fileMenu = new Menu("File");
		MenuItem runTestCasesFileMenuItem = new MenuItem("Run Testcases");
		MenuItem editTestCasesFileMenuItem = new MenuItem("Edit Testcases");
		MenuItem createTestCasesFileMenuItem = new MenuItem("Create Testcases");
		MenuItem closeApplicationFileMenuItem = new MenuItem("Close");
		
		fileMenu.getItems().addAll(runTestCasesFileMenuItem, new SeparatorMenuItem(), editTestCasesFileMenuItem, new SeparatorMenuItem(), createTestCasesFileMenuItem, new SeparatorMenuItem(), closeApplicationFileMenuItem);
		mPane.setLayoutX(100);
		mPane.setLayoutY(100);
		mPane.getChildren().add(topMenuBar);
		return mPane;
	}
}
