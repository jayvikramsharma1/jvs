package uk.co.news.methode.automation.window;

import org.apache.log4j.Logger;
import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.Environment;
import uk.co.news.methode.automation.utils.WatchDog;


public class QuickOpen extends BaseWindow{
	
	final static Logger logger = Logger.getLogger(Logger.class);
	
	public static void quickopen(String date) throws Exception{
		selectChannel();
		selectDate(date);
		selectPagePlan();
		clickOkBtn();
	}
	private static void selectChannel() throws Exception {
		Window window = getWindowProperty(QUICK_OPEN);
		Property selectChannelProperty = window.getPropertyByName(QUICK_OPEN_CHANNEL_SELECT);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.controlFocus(window.getTitle(), NONE, selectChannelProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlCommandShowDropdown(window.getTitle(), NONE, selectChannelProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		//AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(2),false);
		String channel = Environment.getChannel();
		if(channel.equals(TABLET)){
			AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(1));
		}else if(channel.equals(DIGITAL)){
			AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(3));
		}
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER,false);
		
	}
	
	private static void selectDate(String date) throws Exception {
		Window window = getWindowProperty(QUICK_OPEN);
		Property selectDateProperty = window.getPropertyByName(QUICK_OPEN_DATE_SELECT);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, selectDateProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.ControlSetText(window.getTitle(), NONE, selectDateProperty.getId(), date);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.UP_DOWN);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	private static void selectPagePlan() throws Exception {
		Window window = getWindowProperty(QUICK_OPEN);
		Property selectPagePlanProperty = window.getPropertyByName(QUICK_PAGE_PLAN);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, selectPagePlanProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, selectPagePlanProperty.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, selectPagePlanProperty.getX(), selectPagePlanProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(1));
		AutoIt.methode.sleep(INTERVAL);
	}
	
	private static void clickOkBtn() throws Exception {
		Window window = getWindowProperty(QUICK_OPEN);
		Property okBtnProperty = window.getPropertyByName(QUICK_OPEN_OK_BTN);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, okBtnProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlClick(window.getTitle(), NONE, okBtnProperty.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, okBtnProperty.getX(), okBtnProperty.getY());
		window = getWindowProperty(PAGE_PLANNER_MENU);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
	}
}
