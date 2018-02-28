package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.WatchDog;


/**
 * Class contains all the AutoIt base functions to handle New Search Query
 * Window
 * 
 * @author sbharathi
 *
 */
public class NewSearchQuery extends BaseWindow {
	/**
	 * This function is to click on Query Name field
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void queryName() throws Exception {
		Window window = getWindowProperty(METHODE_SEARCH_QUERY);
		Property queryNameProperty = window.getPropertyByName(QUERY_NAME);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, queryNameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, queryNameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, queryNameProperty.getX(), queryNameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void getQueryImage(String Storyname) throws Exception {
		fileName(Storyname);
		okBtn();
	}

	/**
	 * This function is to give the filename
	 * 
	 * @param Storyname
	 *            File name as text value
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void fileName(String Storyname) throws Exception {
		Window window = getWindowProperty(METHODE_SEARCH_QUERY);
		Property fileNameProperty = window.getPropertyByName(FILE_NAME);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, fileNameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, fileNameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, fileNameProperty.getX(), fileNameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.ControlSetText(window.getTitle(), NONE, NONE, Storyname);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function is to click on clear button
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void clearBtn() throws Exception {
		Window window = getWindowProperty(METHODE_SEARCH_QUERY);
		Property clearBtnProperty = window.getPropertyByName(CLEAR_BTN);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clearBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clearBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, clearBtnProperty.getX(), clearBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function is to click on Load from Button
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void loadFromBtn() throws Exception {
		Window window = getWindowProperty(METHODE_SEARCH_QUERY);
		Property loadFromBtnProperty = window.getPropertyByName(LOAD_FROM_BTN);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, loadFromBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, loadFromBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, loadFromBtnProperty.getX(), loadFromBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function is to click on try Button
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void tryBtn() throws Exception {
		Window window = getWindowProperty(METHODE_SEARCH_QUERY);
		Property tryBtnProperty = window.getPropertyByName(TRY_BTN);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, tryBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, tryBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, tryBtnProperty.getX(), tryBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function is to click on Ok Button * @throws Exception Property not
	 * found exception
	 */
	public static void okBtn() throws Exception {
		Window window = getWindowProperty(METHODE_SEARCH_QUERY);
		Property okBtnProperty = window.getPropertyByName(OK_BTN);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		/*
		 * AutoIt.methode.controlFocus(window.getTitle(), NONE,
		 * okBtnProperty.getId()); AutoIt.methode.sleep(INTERVAL);
		 * AutoIt.methode.controlClick(window.getTitle(), NONE,
		 * okBtnProperty.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK,
		 * okBtnProperty.getX(), okBtnProperty.getY());
		 */
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(6));
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		System.out.println(window.getTitle());
		window = getWindowProperty(STORY_PREPARATION_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function is to click on Cancel button
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void cancelBtn() throws Exception {
		Window window = getWindowProperty(METHODE_SEARCH_QUERY);
		Property cancelBtnProperty = window.getPropertyByName(CANCEL_BTN);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, cancelBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, cancelBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, cancelBtnProperty.getX(), cancelBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void dwpMethodeQuery(String filename, String article) throws Exception {
		Window window = getWindowProperty(METHODE_SEARCH_QUERY);
		Property fileNameProperty = window.getPropertyByName(FILE_NAME);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, fileNameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, fileNameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, fileNameProperty.getX(), fileNameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.ControlSetText(window.getTitle(), NONE, NONE, filename);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(2));
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		window = getWindowProperty(DWP_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1700, 158, 180, 137, 1000);
		AutoIt.methode.sleep(INTERVAL);
		///***Allen**AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1901, 87, Mouse.SINGLE_CLICK, 1000);
		AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1890, 85, Mouse.SINGLE_CLICK, 1000);
		//Property closeSearchStoriesProperty = window.getPropertyByName(CLOSE_QUERY_STORIES);
		//AutoIt.methode.sleep(INTERVAL);
		/*
		 * AutoIt.methode.controlFocus(window.getTitle(), NONE,
		 * closeSearchStoriesProperty.getId());
		 * AutoIt.methode.controlClick(window.getTitle(), NONE,
		 * closeSearchStoriesProperty.getId(), Mouse.LEFT_CLICK,
		 * Mouse.SINGLE_CLICK, closeSearchStoriesProperty.getX(),
		 * closeSearchStoriesProperty.getY());
		 */
		AutoIt.methode.sleep(INTERVAL);
		TemplatePlan.openarticle(article);
	}

	public static void bookcover(String filename,String testName, String stepName) throws Exception {
		Window window = getWindowProperty(METHODE_SEARCH_QUERY);
		Property fileNameProperty = window.getPropertyByName(FILE_NAME);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, fileNameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, fileNameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, fileNameProperty.getX(), fileNameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.ControlSetText(window.getTitle(), NONE, NONE, filename);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(2));
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		window = getWindowProperty(DWP_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1700, 158, 300, 400, 1000);
		/*AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1901, 87, Mouse.SINGLE_CLICK, 1000);
		Property closeSearchStoriesProperty = window.getPropertyByName(CLOSE_QUERY_STORIES);
		AutoIt.methode.sleep(INTERVAL);
*/		/*
		 * AutoIt.methode.controlFocus(window.getTitle(), NONE,
		 * closeSearchStoriesProperty.getId());
		 * AutoIt.methode.controlClick(window.getTitle(), NONE,
		 * closeSearchStoriesProperty.getId(), Mouse.LEFT_CLICK,
		 * Mouse.SINGLE_CLICK, closeSearchStoriesProperty.getX(),
		 * closeSearchStoriesProperty.getY());
		 */
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void dwpMethodeQueryChildArticle(String filename) throws Exception {
		Window window = getWindowProperty(METHODE_SEARCH_QUERY);
		Property fileNameProperty = window.getPropertyByName(FILE_NAME);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, fileNameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, fileNameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, fileNameProperty.getX(), fileNameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.ControlSetText(window.getTitle(), NONE, NONE, filename);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(2));
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		window = getWindowProperty(DWP_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1700, 158, 358, 182, 1000);
		AutoIt.methode.sleep(INTERVAL);
		/*AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1901, 87, Mouse.SINGLE_CLICK, 1000);
		Property closeSearchStoriesProperty = window.getPropertyByName(CLOSE_QUERY_STORIES);
		AutoIt.methode.sleep(INTERVAL);*/
		/*
		 * AutoIt.methode.controlFocus(window.getTitle(), NONE,
		 * closeSearchStoriesProperty.getId());
		 * AutoIt.methode.controlClick(window.getTitle(), NONE,
		 * closeSearchStoriesProperty.getId(), Mouse.LEFT_CLICK,
		 * Mouse.SINGLE_CLICK, closeSearchStoriesProperty.getX(),
		 * closeSearchStoriesProperty.getY());
		 */
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void floorLineImage(String filename) throws Exception {
		Window window = getWindowProperty(METHODE_SEARCH_QUERY);
		Property fileNameProperty = window.getPropertyByName(FILE_NAME);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, fileNameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, fileNameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, fileNameProperty.getX(), fileNameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.ControlSetText(window.getTitle(), NONE, NONE, filename);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(2));
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		window = getWindowProperty(DWP_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1700, 158, 324, 377, 1000);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void businessFloorLineImage(String filename) throws Exception {
		Window window = getWindowProperty(METHODE_SEARCH_QUERY);
		Property fileNameProperty = window.getPropertyByName(FILE_NAME);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, fileNameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, fileNameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, fileNameProperty.getX(), fileNameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.ControlSetText(window.getTitle(), NONE, NONE, filename);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(2));
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		window = getWindowProperty(DWP_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1700, 158, 314, 377, 1000);
		AutoIt.methode.sleep(INTERVAL);
	}
}
