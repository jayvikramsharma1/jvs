package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Keyboard;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.WatchDog;


/**
 * Class contains all the AutoIt base functions to handle Page Planner Window
 * 
 * @author sbharathi
 *
 */
public class PagePlanner extends BaseWindow {
	/**
	 * This function is to provide date
	 * 
	 * @param date
	 *            Any date as String value
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void open(String date) throws Exception {

	}

	/**
	 * This function is to open existing page plan
	 * 
	 * @param date
	 *            Any date as String value
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void openExistingPagePlan(String date) throws Exception {
		Window window = getWindowProperty(MAIN);
		Property openPagePlanProperty = window.getMenu(FILE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.controlFocus(window.getTitle(), NONE, openPagePlanProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, openPagePlanProperty.getId(),
				openPagePlanProperty.getShortcuts(), true);
		AutoIt.methode.controlClick(window.getTitle(), NONE, openPagePlanProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, openPagePlanProperty.getX(), openPagePlanProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, openPagePlanProperty.getId(), Keyboard.u, true);
		window = getWindowProperty(QUICK_OPEN);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		QuickOpen.quickopen(date);
		AutoIt.methode.sleep(INTERVAL);
		//EditorialPlan.planExtendExisting();
	}

	/**
	 * This function is to create a new Page Plan
	 * 
	 * @param date
	 *            Any date as String value
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void createPagePlan(String newpageplan, String date) throws Exception {
		Window window = getWindowProperty(MAIN);
		Property openPagePlanProperty = window.getMenu(FILE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.controlFocus(window.getTitle(), NONE, openPagePlanProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, openPagePlanProperty.getId(),
				openPagePlanProperty.getShortcuts(), true);
		AutoIt.methode.controlClick(window.getTitle(), NONE, openPagePlanProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, openPagePlanProperty.getX(), openPagePlanProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, openPagePlanProperty.getId(), Keyboard.n, true);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, openPagePlanProperty.getId(), Keyboard.l, true);
		window = getWindowProperty(NEW_PAGEPLAN);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		NewPagePlan.newPagePlan(newpageplan, date);
		AutoIt.methode.sleep(INTERVAL);
		//EditorialPlan.planExtend();
	}
	
	public static void stCreatePagePlan(String newpageplan, String date, int down) throws Exception {
		Window window = getWindowProperty(MAIN);
		Property openPagePlanProperty = window.getMenu(FILE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.controlFocus(window.getTitle(), NONE, openPagePlanProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, openPagePlanProperty.getId(),
				openPagePlanProperty.getShortcuts(), true);
		AutoIt.methode.controlClick(window.getTitle(), NONE, openPagePlanProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, openPagePlanProperty.getX(), openPagePlanProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, openPagePlanProperty.getId(), Keyboard.n, true);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, openPagePlanProperty.getId(), Keyboard.l, true);
		window = getWindowProperty(NEW_PAGEPLAN);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		NewPagePlan.stNewPagePlan(newpageplan, date, down);
		AutoIt.methode.sleep(INTERVAL);
		//EditorialPlan.planExtend();
	}

	public static void chpQuery() throws Exception {
		Window window = getWindowProperty(MAIN);
		Property chpQueryProperty = window.getPropertyByName(SEARCH_CHP);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, chpQueryProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlClick(window.getTitle(), NONE, chpQueryProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, chpQueryProperty.getX(), chpQueryProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(NEW_CHP_QUERY);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void stChpQuery() throws Exception {
		Window window = getWindowProperty(MAIN);
		Property stChpQueryProperty = window.getPropertyByName(ST_SEARCH_CHP);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, stChpQueryProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlClick(window.getTitle(), NONE, stChpQueryProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, stChpQueryProperty.getX(), stChpQueryProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(NEW_CHP_QUERY);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

		 /**
		  * This function is to select content and do send to production
		  * 
		  * @throws Exception
		  *             Property not found exception
		  */
	public static void sendToProduction01() throws Exception {
		Window window = getWindowProperty(MAIN);
		Property sendToProductionProperty = window.getPropertyByName(CLICK_ON_CHP_STORY_01);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, sendToProductionProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlClick(window.getTitle(), NONE, sendToProductionProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, sendToProductionProperty.getX(), sendToProductionProperty.getY());
		//Laptop
		//AutoIt.methode.mouseClick(NONE, 1765, 415, Mouse.SINGLE_CLICK, 1000);
		//Normal 
		AutoIt.methode.mouseClick(NONE, 1765, 400, Mouse.SINGLE_CLICK, 1000);
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(SEND_TO_PRODUCTION);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
		/*
		 * AutoIt.methode.controlSend(window.getTitle(), NONE,
		 * sendToProductionProperty.getId(), Mouse.getDown(3));
		 * AutoIt.methode.sleep(INTERVAL);
		 */
	}
	
	public static void sendToProductionCHAdvanced01() throws Exception {
		Window window = getWindowProperty(MAIN);
		Property sendToProductionProperty = window.getPropertyByName(CLICK_ON_CHP_STORY_01);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, sendToProductionProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlClick(window.getTitle(), NONE, sendToProductionProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, sendToProductionProperty.getX(), sendToProductionProperty.getY());
		AutoIt.methode.mouseClick(NONE, 1765, 395, Mouse.SINGLE_CLICK, 1000);
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(SEND_TO_PRODUCTION);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
		/*
		 * AutoIt.methode.controlSend(window.getTitle(), NONE,
		 * sendToProductionProperty.getId(), Mouse.getDown(3));
		 * AutoIt.methode.sleep(INTERVAL);
		 */
	}

	
	/**
	 * This function is to select content and do send to production
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */
	/*public static void createTopic01() throws Exception {
		Window window = getWindowProperty(MAIN);
		Property createTopic01Property = window.getPropertyByName(CLICK_ON_CHP_STORY_03);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, createTopic01Property.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlClick(window.getTitle(), NONE, createTopic01Property.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, createTopic01Property.getX(), createTopic01Property.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClick(NONE, 1465,300 , Mouse.SINGLE_CLICK, 1000);
		AutoIt.methode.controlSend(window.getTitle(), NONE, sendToProductionProperty.getId(), Mouse.getDown(3));
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(NEW_TOPIC);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void createTopic02() throws Exception {
		Window window = getWindowProperty(MAIN);
		Property createTopic02Property = window.getPropertyByName(CLICK_ON_CHP_STORY_04);
		AutoIt.methode.winActivate(window.getTitle());s
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, createTopic02Property.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlClick(window.getTitle(), NONE, createTopic02Property.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, createTopic02Property.getX(), createTopic02Property.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClick(NONE, 1792, 269, Mouse.SINGLE_CLICK, 1000);
		AutoIt.methode.controlSend(window.getTitle(), NONE, sendToProductionProperty.getId(), Mouse.getDown(3));
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(NEW_TOPIC);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}*/
	
	public static void sendtoProduction02() throws Exception{
			Window window = getWindowProperty(MAIN);
			Property sendToProductionProperty = window.getPropertyByName(CLICK_ON_CHP_STORY_02);
			AutoIt.methode.winActivate(window.getTitle());
			AutoIt.methode.sleep(INTERVAL);
			AutoIt.methode.controlFocus(window.getTitle(), NONE, sendToProductionProperty.getId());
			AutoIt.methode.sleep(INTERVAL);
			AutoIt.methode.controlClick(window.getTitle(), NONE, sendToProductionProperty.getId(), Mouse.RIGHT_CLICK,
					Mouse.SINGLE_CLICK, sendToProductionProperty.getX(), sendToProductionProperty.getY());
			AutoIt.methode.sleep(INTERVAL);
			//laptop
			//AutoIt.methode.mouseClick(NONE, 1805, 770, Mouse.SINGLE_CLICK, 1000);
			//Normal
			AutoIt.methode.mouseClick(NONE, 1805, 755, Mouse.SINGLE_CLICK, 1000);
			/*AutoIt.methode.controlSend(window.getTitle(), NONE, sendToProductionProperty.getId(), Mouse.getDown(3));*/
			AutoIt.methode.sleep(INTERVAL);
			window = getWindowProperty(SEND_TO_PRODUCTION);
			WatchDog.wait(window);
			Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
			AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void createVideoStory() throws Exception {
		Window window = getWindowProperty(MAIN);
		Property openPagePlanProperty = window.getMenu(FILE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.controlFocus(window.getTitle(), NONE, openPagePlanProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, openPagePlanProperty.getId(),
				openPagePlanProperty.getShortcuts(), true);
		AutoIt.methode.controlClick(window.getTitle(), NONE, openPagePlanProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, openPagePlanProperty.getX(), openPagePlanProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, openPagePlanProperty.getId(), Keyboard.n, true);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, openPagePlanProperty.getId(), Keyboard.s, true);
		window = getWindowProperty(NEW_STORY);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(1));
		AutoIt.methode.sleep(INTERVAL);
		//EditorialPlan.planExtend();
	}
	
	public static void closeWindow() throws Exception{
		Window window = getWindowProperty(MAIN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.winClose(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
	}
}
