package uk.co.news.utils;

public class TitleString {
	public static String getGeneralTitle(String mask) {
		String generalTitleString = null;
		if(mask.equalsIgnoreCase(Titles.THE_TIME.value))
			generalTitleString = "The Times";
			//manifestCodes.insert(0, "<!-- The Times Test Cases -->\n");
		if(mask.equalsIgnoreCase(Titles.SUNDAY_TIMES.value))
			generalTitleString = "Sunday Times";
			//manifestCodes.insert(0, "<!-- Sunday Times Test Cases -->\n");
		if(mask.equalsIgnoreCase(Titles.SUN.value))
			generalTitleString = "Sun";
			//manifestCodes.insert(0, "<!-- Sun Test Cases -->\n");
		return generalTitleString;
	}
	
	public static String getTestCaseTitleCommentString(String mask) {
		String testCaseComment = null;
		if(mask.equalsIgnoreCase(Titles.THE_TIME.value))
			testCaseComment = "<!-- The Times Test Cases -->\n";
		if(mask.equalsIgnoreCase(Titles.SUNDAY_TIMES.value))
			testCaseComment = "<!-- Sunday Times Test Cases -->\n";
		if(mask.equalsIgnoreCase(Titles.SUN.value))
			testCaseComment = "<!-- Sun Test Cases -->\n";
		return testCaseComment;
	}
}
