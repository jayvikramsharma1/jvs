package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.WatchDog;


/**
 * Class contains all the AutoIt base functions to handle Editorial workflow Window
 * @author sbharathi
 *
 */
public class EditorialWorkFlow extends BaseWindow {
    /**
     * This function clicks on Done 
     * @throws Exception Property not found exception
     */
	
	public static void editorialPlanInProgress() throws Exception{
		inProgressClick();
		saveBtn();
	}
	
	public static void doneStatus() throws Exception{
		doneClick();
		saveBtn();
	}
	
	public static void editorialPlanDoneStatus() throws Exception{
		doneClick2();
		saveBtn();
	}
	
	public static void doneClick() throws Exception {
		Window window = getWindowProperty(EDITORIAL_WORK_FLOW);
		Property inProgressClickProperty = window.getPropertyByName(INPROGRESS_CLICK);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, inProgressClickProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, inProgressClickProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, inProgressClickProperty.getX(), inProgressClickProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(3));
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void doneClick2() throws Exception {
		Window window = getWindowProperty(EDITORIAL_WORK_FLOW);
		Property doneBtnProperty = window.getPropertyByName(DONE_CLICK_2);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, doneBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, doneBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, doneBtnProperty.getX(), doneBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}
	/**
	 * This function clicks on In progress
	 * @throws Exception Property not found exception
	 */
	public static void inProgressClick() throws Exception{
		Window window = getWindowProperty(EDITORIAL_WORK_FLOW);
		Property inProgressClickProperty = window.getPropertyByName(INPROGRESS_CLICK);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, inProgressClickProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, inProgressClickProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, inProgressClickProperty.getX(), inProgressClickProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.sleep(10000);
	}
	/**
	 * This function clicks on Save Button
	 * @throws Exception Property not found exception
	 */
	public static void saveBtn() throws Exception{
		Window window = getWindowProperty(EDITORIAL_WORK_FLOW);
		Property saveBtnProperty = window.getPropertyByName(EDITORIAL_WORKFLOW_OK_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, saveBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, saveBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, saveBtnProperty.getX(), saveBtnProperty.getY());
		AutoIt.methode.sleep(15000);
		window = getWindowProperty(PAGE_PLANNER_MENU);
		AutoIt.methode.winWaitActive(window.getTitle());
		/*WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);*/
		
		
	}
	/**
	 * This function clicks on cancel Button
	 * @throws Exception Property not found exception
	 */
	public static void cancelBtn() throws Exception{
		Window window = getWindowProperty(EDITORIAL_WORK_FLOW);
		Property cancelBtnProperty = window.getPropertyByName(EDITORIAL_WORKFLOW_CANCEL_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, cancelBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, cancelBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, cancelBtnProperty.getX(), cancelBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(PAGE_PLANNER_MENU);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}
}
