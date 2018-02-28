package uk.co.news.methode.automation.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AdditionalFunction {
	
	
	public static void dateOfDay(String date) throws Exception{
		SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date MyDate = newDateFormat.parse(date);
		newDateFormat.applyPattern("EEEE");
		String MyDay = newDateFormat.format(MyDate).toUpperCase();
		System.out.println(MyDay);
	}

}
