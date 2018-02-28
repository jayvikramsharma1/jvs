package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.WatchDog;



public class SelectImageLocal extends BaseWindow {
	public static void selectImage01() throws Exception {
		Window window = getWindowProperty(SELECT_IMAGE);
		Property selectImageProperty = window.getPropertyByName(IMAGE_SELECT_01);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, selectImageProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlClick(window.getTitle(), NONE, selectImageProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, selectImageProperty.getX(), selectImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void selectImageBtn() throws Exception {
		Window window = getWindowProperty(SELECT_IMAGE);
		Property selectImageBtnProperty = window.getPropertyByName(IMAGE_SELECT_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, selectImageBtnProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlClick(window.getTitle(), NONE, selectImageBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, selectImageBtnProperty.getX(), selectImageBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(STORY_PREPARATION_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void cancelSelectBtn() throws Exception {
		Window window = getWindowProperty(SELECT_IMAGE);
		Property selectCancelBtnProperty = window.getPropertyByName(IMAGE_CANCEL_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, selectCancelBtnProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlClick(window.getTitle(), NONE, selectCancelBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, selectCancelBtnProperty.getX(), selectCancelBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(STORY_PREPARATION_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}
}
