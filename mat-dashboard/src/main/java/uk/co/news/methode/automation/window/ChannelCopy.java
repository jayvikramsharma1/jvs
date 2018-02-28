package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.WatchDog;


/**
 * Class contains all the AutoIt base functions to handle Channel Copy Window
 * 
 * @author sbharathi
 *
 */
public class ChannelCopy extends BaseWindow {

	/**
	 * This function clicks on inherit and Ok Button
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void createChannelCopy() throws Exception {
		inherit();
		OkBtn();
	}

	/**
	 * This function clicks on inherit property Button
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void inherit() throws Exception {
		Window window = getWindowProperty(CREATE_CHANNEL_COPY);
		Property inheritBtnProperty = window.getPropertyByName(CHANNEL_COPY_INHERIT_BTN);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, inheritBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, inheritBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, inheritBtnProperty.getX(), inheritBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function clicks on Ok Button
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void OkBtn() throws Exception {
		Window window = getWindowProperty(CREATE_CHANNEL_COPY);
		Property okBtnProperty = window.getPropertyByName(CHANNEL_COPY_OK_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, okBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, okBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, okBtnProperty.getX(), okBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(STORY_PREPARATION_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function clicks on Cancel Button
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */

	public static void cancelBtn() throws Exception {
		Window window = getWindowProperty(CREATE_CHANNEL_COPY);
		Property cancelBtnProperty = window.getPropertyByName(CHANNEL_COPY_CANCEL_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, cancelBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, cancelBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, cancelBtnProperty.getX(), cancelBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(STORY_PREPARATION_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

}
