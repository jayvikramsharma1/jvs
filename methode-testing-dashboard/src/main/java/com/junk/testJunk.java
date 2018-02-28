package com.junk;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class testJunk {
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		ByteArrayOutputStream baosImageFile = new ByteArrayOutputStream();
		ImageIO.write(ImageIO.read(new URL("http://brightcove04.o.brightcove.com/5436121857001/5436121857001_5465750755001_5465733626001-th.jpg?pubId=5436121857001&videoId=5465733626001")), "jpg", baosImageFile);
		//System.out.println(baosImageFile.toByteArray());
		InputStream in = new ByteArrayInputStream(baosImageFile.toByteArray());
		BufferedImage bImageFromConvert = ImageIO.read(in);

		ImageIO.write(bImageFromConvert, "jpg", new File("C:\\Users\\JSharma1\\Documents\\new-darksouls.jpg"));
	}

}
