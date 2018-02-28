package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.WatchDog;


public class Confirmation extends BaseWindow{

	public static void yesBtn() throws Exception{
		Window window = getWindowProperty(CONFIRMATION);
		Property clickYesBtnProperty = window.getPropertyByName(YES_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickYesBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickYesBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, clickYesBtnProperty.getX(), clickYesBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(DWP_PAGE);
		AutoIt.methode.sleep(INTERVAL);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void noBtn() throws Exception{
		Window window = getWindowProperty(CONFIRMATION);
		Property clickNoBtnProperty = window.getPropertyByName(NO_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickNoBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickNoBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, clickNoBtnProperty.getX(), clickNoBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(DWP_PAGE);
		AutoIt.methode.sleep(INTERVAL);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	
}
