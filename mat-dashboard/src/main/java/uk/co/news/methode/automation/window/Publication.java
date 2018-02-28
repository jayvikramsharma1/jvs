package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.Environment;
import uk.co.news.methode.automation.utils.WatchDog;


public class Publication extends BaseWindow {
	
	public static void selectTitle() throws Exception {
		
		String title = Environment.getTitle();
		
		Window window = new Window();
		Property titleProperty = new Property();
		Property okBtnProperty = new Property();

		if (title.equals(TIMES)) {
			window = getWindowProperty(TT_SELECTION);
			titleProperty = window.getPropertyByName(TT_TITLE_SELECTION);
			okBtnProperty = window.getPropertyByName(TT_OK_BTN);
		} else if (title.equals(ST_TIMES)) {
			window = getWindowProperty(ST_SELECTION);
			titleProperty = window.getPropertyByName(ST_TITLE_SELECTION);
			okBtnProperty = window.getPropertyByName(ST_OK_BTN);
		} else if (title.equals(SUN)) {
			window = getWindowProperty(SUN_SELECTION);
			titleProperty = window.getPropertyByName(SUN_TITLE_SELECTION);
			okBtnProperty = window.getPropertyByName(SUN_OK_BTN);
		}
		
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true, "Publication window status");
		AutoIt.methode.controlFocus(window.getTitle(), NONE, titleProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlClick(window.getTitle(), "", titleProperty.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, titleProperty.getX(),  titleProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlClick(window.getTitle(), "", okBtnProperty.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, okBtnProperty.getX(),  okBtnProperty.getY());
		window = getWindowProperty(LOGIN);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
	}
}
