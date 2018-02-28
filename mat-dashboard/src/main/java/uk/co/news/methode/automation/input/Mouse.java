package uk.co.news.methode.automation.input;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;

public class Mouse {
	
	public static String RIGHT_CLICK = "right";
	public static String LEFT_CLICK = "left";
	public static String TAB_ENTER = "{TAB}";
	public static int SINGLE_CLICK = 1;
	public static int DOUBLE_CLICK = 2;
	public static int TRIPLE_CLICK = 3;
	public static int CLICK_X = 4;
	public static int CLICK_LX = 35;
	public static String ENTER = "{ENTER}";
	public static String UP_DOWN = "{UP}{DOWN}";
	public static String DOWN_ENTER = "{DOWN}{DOWN}{ENTER}";
	public static String BACK_SPACE = "{BACKSPACE}";
	
	public static String getDown(int step) {
		StringBuilder name = new StringBuilder();
		int count = 0;
		for (;;) {
			if (count == step) {
				break;
			}
			name.append("{DOWN}");
			count++;
		}
		return name.toString();
	}
	
	public static String getUp(int step) {
		StringBuilder name = new StringBuilder();
		int count = 0;
		for (;;) {
			if (count == step) {
				break;
			}
			name.append("{UP}");
			count++;
		}
		return name.toString();
	}

	public static String getTab(int step) {
		StringBuilder name = new StringBuilder();
		int count = 0;
		for (;;) {
			if (count == step) {
				break;
			}
			name.append("{TAB}");
			count++;
		}
		return name.toString();
	}
	
	public static String getClick(int click) {
		StringBuilder name = new StringBuilder();
		int count = 0;
		for (;;) {
			if (count == click) {
				break;
			}
			name.append("{TAB}");
			count++;
		}
		return name.toString();
	}

	public static void onClick(int click, Window window, Property property, String mousePosition ) {
		int count = 0;
		for (;;) {
			if (count == click) {
				break;
			}
			AutoIt.methode.controlClick(window.getTitle(), "", property.getId(), mousePosition, 1, property.getX(), property.getY());
			AutoIt.methode.sleep(500);
			count++;
		}
	}
	
		/* Enter the down number in the test case based on your work folder
			news = 1
			foreign = 2
			business = 3
			sports = 4
			register = 5
			oped = 6
			leaders = 7
			t2 = 8
			theGame = 9
			bricks = 10
			weekend = 11
			review = 12
			money = 13
			specialReports = 14
			magazine = 15
			syndication = 16
			tablet Extras = 17
			yomiuri = 18
			specialSupplements = 19
			puzzles = 20
			commercialContent = 21
			timesPlus = 22*/
	
}
