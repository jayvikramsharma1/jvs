package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.WatchDog;


public class SaveStory extends BaseWindow {
	
	public static void saveFileAs(String filename, String testName, String stepName) throws Exception{
		fileName(filename);
		saveasBtn(testName, stepName);
	}

	public static void videoSaveFileAs(String filename, String testName, String stepName) throws Exception{
		fileName(filename);
		saveasBtn(testName, stepName);
	}
	
	public static void fileName(String filename) throws Exception {
		Window window = getWindowProperty(SAVE_AS);
		Property filenameProperty = window.getPropertyByName(SAVE_AS_NAME);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, filenameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, filenameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, filenameProperty.getX(), filenameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.ControlSetText(window.getTitle(), NONE, filenameProperty.getId(), filename);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void saveasBtn(String testName, String stepName) throws Exception {
		Window window = getWindowProperty(SAVE_AS);
		Property saveAsBtnProperty = window.getPropertyByName(SAVE_AS_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, saveAsBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, saveAsBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, saveAsBtnProperty.getX(), saveAsBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(OVERRIDE_OPTION);
		WatchDog.wait(window);
		if(AutoIt.methode.winExists(window.getTitle())){
			captureScreen(testName, stepName);
			AutoIt.methode.winClose(window.getTitle());
			cancelBtn();
			NewStory.CancelBtn();
			TemplatePlan.close_window();
			Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
			AutoIt.methode.sleep(INTERVAL);
		}else{
			System.out.println("StoryCreatedSucessfully");
		}
		window = getWindowProperty(DWP_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void cancelBtn() throws Exception {
		Window window = getWindowProperty(SAVE_AS);
		Property saveAsCancelBtnProperty = window.getPropertyByName(SAVE_AS_CANCEL_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, saveAsCancelBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, saveAsCancelBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, saveAsCancelBtnProperty.getX(), saveAsCancelBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(DWP_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void videoSaveasBtn() throws Exception {
		Window window = getWindowProperty(SAVE_AS);
		Property saveAsBtnProperty = window.getPropertyByName(SAVE_AS_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, saveAsBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, saveAsBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, saveAsBtnProperty.getX(), saveAsBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(STORY_PREPARATION_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}
	
}
