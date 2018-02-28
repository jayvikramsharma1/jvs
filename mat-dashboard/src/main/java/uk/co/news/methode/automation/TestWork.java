package uk.co.news.methode.automation;

import java.util.GregorianCalendar;

import uk.co.news.methode.automation.utils.Environment;

public class TestWork {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		Environment.loadConfiguration();
		
		System.out.println(Environment.getS3Bucket());
		System.out.println(Environment.getS3ApiKey());
		System.out.println(Environment.getS3ApiSecret());
		System.out.println(Environment.getS3MediaPath());
	}*/
	
	  public static void main(String[] argv) {
	        GregorianCalendar gc = new GregorianCalendar();
	        gc.set(GregorianCalendar.DAY_OF_MONTH, 8);
	        gc.set(GregorianCalendar.MONTH, GregorianCalendar.JUNE);
	        gc.set(GregorianCalendar.YEAR, 2010);
	        System.out.println(gc.get(GregorianCalendar.DAY_OF_YEAR));
	  }
}
