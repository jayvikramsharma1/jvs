package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.WatchDog;


/**
 * Class contains all the AutoIt base functions to handle New Story Window
 * 
 * @author sbharathi
 *
 */
public class NewStory extends BaseWindow {

	/**
	 * This function is to click on create Button
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void storyCreateBtn() throws Exception {
		Window window = getWindowProperty(NEW_STORY);
		Property createStoryBtnProperty = window.getPropertyByName(NEW_STORY_CREATE_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, createStoryBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, createStoryBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, createStoryBtnProperty.getX(), createStoryBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(SAVE_AS);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void createFractionalDeeplink() throws Exception {
		Window window = getWindowProperty(NEW_STORY);
		Property fractionalDeeplinkProperty = window.getPropertyByName(FRACTIONAL_DEEPLINKING);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, fractionalDeeplinkProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, fractionalDeeplinkProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, fractionalDeeplinkProperty.getX(), fractionalDeeplinkProperty.getY());
	}

	/**
	 * This function is to click on cancel Button
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void CancelBtn() throws Exception {
		Window window = getWindowProperty(NEW_STORY);
		Property cancelBtnProperty = window.getPropertyByName(NEW_STORY_CREATE_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, cancelBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, cancelBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, cancelBtnProperty.getX(), cancelBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(DWP_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	/**
	 * This function is to expand the National Edition
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */
	
	public static void stNationalExpand(int down) throws Exception{
		Window window = getWindowProperty(NEW_STORY);
		Property stNationalExpandProperty = window.getPropertyByName(ST_NATIONAL_EXPAND);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, stNationalExpandProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, stNationalExpandProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, stNationalExpandProperty.getX(), stNationalExpandProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
	}
	
	/**
	 * This function is to expand the Irish Edition
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */
	
	public static void stIrelandExpand(int down) throws Exception{
		Window window = getWindowProperty(NEW_STORY);
		Property stIrelandExpandProperty = window.getPropertyByName(ST_IRELAND_EXPAND);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, stIrelandExpandProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, stIrelandExpandProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, stIrelandExpandProperty.getX(), stIrelandExpandProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
	}
	
	/**
	 * This function is to select the Work Folder
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */
	
	public static void workFolder(int down) throws Exception{
		Window window = getWindowProperty(NEW_STORY);
		Property timesDeckProperty = window.getPropertyByName(TIMES_DECK);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, timesDeckProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, timesDeckProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, timesDeckProperty.getX(), timesDeckProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
	}
	
	
}
