package uk.co.news.methode.automation.utils;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.text.SimpleDateFormat;
import java.util.*;

public class Screenshot {

	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

	public static void capture(String fileName) throws Exception {
		
		String screenshotLocation = Environment.getScreenshotLocationPath();
		String path = screenshotLocation + fileName;
		Calendar now = Calendar.getInstance();
		Robot robot = new Robot();
		BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(screenShot, "JPG", new File(path +"-"+ formatter.format(now.getTime()) + ".jpg"));
		System.out.println(formatter.format(now.getTime()));
		
	}
}
