package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.WatchDog;


public class InsertPages extends BaseWindow {
	
	public static void InsertPageEating() throws Exception{
		clickOnMagazineTree();
		selectEating();
		insertPageOkBtn();
	}

	public static void clickOnMagazineTree() throws Exception {
		Window window = getWindowProperty(PP_INSERT_PAGE);
		Property clickOnMagazineTreeProperty = window.getPropertyByName(CLICK_ON_MAGAZINE_TREE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickOnMagazineTreeProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickOnMagazineTreeProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, clickOnMagazineTreeProperty.getX(), clickOnMagazineTreeProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void selectEating() throws Exception{
		Window window = getWindowProperty(PP_INSERT_PAGE);
		Property selectEatingProperty = window.getPropertyByName(SELECT_EATING);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, selectEatingProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, selectEatingProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, selectEatingProperty.getX(), selectEatingProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void insertPageOkBtn() throws Exception{
		Window window = getWindowProperty(PP_INSERT_PAGE);
		Property insertPageOkBtnProperty = window.getPropertyByName(INSERT_PAGE_OK_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, insertPageOkBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, insertPageOkBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, insertPageOkBtnProperty.getX(), insertPageOkBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(PAGE_PLANNER_MENU);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}
}
