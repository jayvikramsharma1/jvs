package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.WatchDog;


/**
 * Class contains all the AutoIt base functions to handle MOD window
 * @author sbharathi
 *
 */
public class MoD extends BaseWindow {
    /**
     * This function is to close the MOD window
     * @throws Exception Property not found exception
     */
	public static void close() throws Exception {
		
		Window window = getWindowProperty(MOD);
		Property modProperty = window.getPropertyByName(MOD_OK_BTN);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, modProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, modProperty.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, modProperty.getX(), modProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(MAIN);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}
	
}
