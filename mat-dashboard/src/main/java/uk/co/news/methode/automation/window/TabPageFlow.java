package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.Screenshot;
import uk.co.news.methode.automation.utils.WatchDog;


public class TabPageFlow extends BaseWindow{
	
	
	
	public static void tabPageFlow(int down) throws Exception{
		Window window = getWindowProperty(TAB_PAGE_FLOW);
		Property tabCurrentStatusProperty = window.getPropertyByName(TAB_CURRENT_STATUS);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, tabCurrentStatusProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, tabCurrentStatusProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, tabCurrentStatusProperty.getX(), tabCurrentStatusProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(PAGE_PLANNER_MENU);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void mashtheadStyle() throws Exception{
		Window window = getWindowProperty(TAB_PAGE_FLOW);
		Property tabMashtheadStyleProperty = window.getPropertyByName(MASHTHEAD_STYLE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, tabMashtheadStyleProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, tabMashtheadStyleProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, tabMashtheadStyleProperty.getX(), tabMashtheadStyleProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void hideNavigation() throws Exception{
		Window window = getWindowProperty(TAB_PAGE_FLOW);
		Property tabHideNavigationProperty = window.getPropertyByName(HIDE_NAVIGATION);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, tabHideNavigationProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, tabHideNavigationProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, tabHideNavigationProperty.getX(), tabHideNavigationProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void okBTN() throws Exception{
		Window window = getWindowProperty(TAB_PAGE_FLOW);
		Property tabCurrentStatusOkBtnProperty = window.getPropertyByName(TAB_CURRENT_STATUS_OK_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		Screenshot.capture("Section Metadata");
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, tabCurrentStatusOkBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, tabCurrentStatusOkBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, tabCurrentStatusOkBtnProperty.getX(), tabCurrentStatusOkBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void screenCapture(String testName, String stepName) throws Exception{
		//System.out.println(S3Uploader.capture());
		captureScreen(testName, stepName);
	}
	
	public static void closeWindow() throws Exception{
		Window window = getWindowProperty(TAB_PAGE_FLOW);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.winClose(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
	}
	
}
