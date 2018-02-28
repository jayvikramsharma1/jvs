package uk.co.news.methode.automation.utils;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.constant.WindowSettings;
import uk.co.news.methode.automation.container.Window;

public class WatchDog {
	public static void wait(Window window) {
		int attempt = 1;
		int interval = 2000;
		
		String windowName = window.getId();
		
		if(windowName.equals("LOGIN")) {
			interval = WindowSettings.LOGIN_INTERVAL;
		} else {
			interval = WindowSettings.INTERVAL;
		}
		
		while(true) {
			if(attempt == 1) {
				AutoIt.methode.sleep(interval);
				if(AutoIt.methode.winExists(window.getTitle())) {
					break;
				} 
			} else if(attempt == 2) {
				interval = (2 * WindowSettings.INTERVAL);
				AutoIt.methode.sleep(interval);
				if(AutoIt.methode.winExists(window.getTitle())) {
					break;
				}
			} else if(attempt == WindowSettings.MAX_TRY){
				interval = (3 * WindowSettings.INTERVAL);
				AutoIt.methode.sleep(interval);
				if(AutoIt.methode.winExists(window.getTitle())) {
					break;
				}
			} else {
				break;
			}
			attempt++;
		}
	}
}
