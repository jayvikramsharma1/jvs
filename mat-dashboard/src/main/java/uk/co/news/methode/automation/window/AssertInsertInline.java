package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.WatchDog;

/**
 * Class contains all the AutoIt base functions to handle Assert Insert Inline
 * window
 * 
 * @author sbharathi
 */
public class AssertInsertInline extends BaseWindow {

	/**
	 * This function selects drop down present in the Assert Inline window
	 * 
	 * @param down
	 *            Image ratio to be selected
	 * @throws Exception
	 *            Property not found exception
	 */
	public static void dropDownBtn(int down) throws Exception {
		Window window = getWindowProperty(INLINE_ASSET_INSERT);
		Property dropdownproperty = window.getPropertyByName(INLINE_DROP_DOWN_RATION_SELECT);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, dropdownproperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, dropdownproperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, dropdownproperty.getX(), dropdownproperty.getY());
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function is to click ok Button
	 * 
	 * @throws Exception  Property not found exception
	 */
	public static void assetInsertOkBtn() throws Exception {
		Window window = getWindowProperty(INLINE_ASSET_INSERT);
		Property assetInsertOkBtnproperty = window.getPropertyByName(INLINE_WINDOW_OK_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, assetInsertOkBtnproperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, assetInsertOkBtnproperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, assetInsertOkBtnproperty.getX(), assetInsertOkBtnproperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(STORY_PREPARATION_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
		ArticlePreparation.getQuickAccessBar();
		AutoIt.methode.sleep(INTERVAL);
	}
	/**
	 * This function is to Cancel ok Button
	 * @throws Exception Property not found exception
	 */

	public static void assetInsertCancelBtn() throws Exception {
		Window window = getWindowProperty(INLINE_ASSET_INSERT);
		Property assetInsertCancelBtnproperty = window.getPropertyByName(INLINE_WINDOW_CANCEL_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, assetInsertCancelBtnproperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, assetInsertCancelBtnproperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, assetInsertCancelBtnproperty.getX(), assetInsertCancelBtnproperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(STORY_PREPARATION_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

}
