package uk.co.news.utils;

import javafx.stage.Stage;
import uk.co.news.main.MainApp;

public class ApplicationStage {
	private Stage stage;
	private double width;
	private double height;
	private double x;
	private double y;
	
	public static final ApplicationStage appStage = new ApplicationStage();
	
	private ApplicationStage() {
		this.stage = MainApp.applicationStage;
		this.width = this.stage.getWidth();
		this.height = this.stage.getHeight();
		this.x = this.stage.getX();
		this.y = this.stage.getY();
	}
	
	public static ApplicationStage getInstance() {
		return appStage;
	}

	public Stage getStage() {
		return stage;
	}



	public void setStage(Stage stage) {
		this.stage = stage;
	}



	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "ApplicationStage [stage=" + stage + ", width=" + width + ", height=" + height + ", x=" + x + ", y=" + y
				+ "]";
	}
	
	
	

}
