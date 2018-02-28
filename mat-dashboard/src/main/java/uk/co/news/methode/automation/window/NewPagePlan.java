package uk.co.news.methode.automation.window;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.Environment;
import uk.co.news.methode.automation.utils.WatchDog;


/**
 * Class contains all the AutoIt base functions to handle New PagePlan window
 * @author sbharathi
 *
 */
public class NewPagePlan extends BaseWindow{
final static Logger logger = Logger.getLogger(Logger.class);
	/**
	 * This function is to create a page plan
	 * @param date       Date value as text
	 * @throws Exception Property not found exception
	 */
	public static void newPagePlan(String newpageplan, String date) throws Exception{
		selectChannel();
		pagePlanName(newpageplan);
		selectDate(date);
		clickOkBtn();
	}
	
	public static void stNewPagePlan(String newpageplan, String date, int down) throws Exception{
		selectChannel();
		pagePlanName(newpageplan);
		stSelectDate(date);
		stPagePlanDesign(down);
		clickOkBtn();
	}
	
	/**
	 * This function is to select channel
	 * @throws Exception Property not found exception
	 */
	private static void selectChannel() throws Exception {
		Window window = getWindowProperty(NEW_PAGEPLAN);
		Property selectChannelProperty = window.getPropertyByName(NEW_PAGEPLAN_CHANNEL_SELECT);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.controlFocus(window.getTitle(), NONE, selectChannelProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlCommandShowDropdown(window.getTitle(), NONE, selectChannelProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		//AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(2),false);
		String channel = Environment.getChannel();
		if(channel.equals(TABLET)){
			AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(1));
		}else if(channel.equals(DIGITAL)){
			AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(2));
		}
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER,false);
	}
	/**
	 * This function is to Select date and based on that day pageplan will be selected
	 * @param date        Date value as text
	 * @throws Exception  Property not found exception
	 */
	private static void selectDate(String date) throws Exception{
		Window window = getWindowProperty(NEW_PAGEPLAN);
		Property selectDateProperty = window.getPropertyByName(NEW_PAGEPLAN_DATE_SELECT);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, selectDateProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.ControlSetText(window.getTitle(), NONE, selectDateProperty.getId(), date);
		AutoIt.methode.sleep(INTERVAL);
		SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date myDate = newDateFormat.parse(date);
		newDateFormat.applyPattern("EEEE");
		String myDay = newDateFormat.format(myDate).toUpperCase();
		System.out.println(myDay);
		AutoIt.methode.sleep(INTERVAL);
		if(myDay.contains("MON")){
			Property mondayTemplate = window.getPropertyByName(MONDAY_TEMPLATE);
			AutoIt.methode.controlFocus(window.getTitle(), NONE, mondayTemplate.getId());
			AutoIt.methode.controlClick(window.getTitle(), NONE, mondayTemplate.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, mondayTemplate.getX(), mondayTemplate.getY());
		}else if (myDay.contains("TUE")){
			Property tuesdayTemplate = window.getPropertyByName(TUESDAY_TEMPLATE);
			AutoIt.methode.controlFocus(window.getTitle(), NONE, tuesdayTemplate.getId());
			AutoIt.methode.controlClick(window.getTitle(), NONE, tuesdayTemplate.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, tuesdayTemplate.getX(), tuesdayTemplate.getY());
		}else if (myDay.contains("WED")){
			Property wednesdayTemplate = window.getPropertyByName(WEDNESDAY_TEMPLATE);
			AutoIt.methode.controlFocus(window.getTitle(), NONE, wednesdayTemplate.getId());
			AutoIt.methode.controlClick(window.getTitle(), NONE, wednesdayTemplate.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, wednesdayTemplate.getX(), wednesdayTemplate.getY());
		}else if (myDay.contains("THU")){
			Property thursdayTemplate = window.getPropertyByName(THURSDAY_TEMPLATE);
			AutoIt.methode.controlFocus(window.getTitle(), NONE, thursdayTemplate.getId());
			AutoIt.methode.controlClick(window.getTitle(), NONE, thursdayTemplate.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, thursdayTemplate.getX(), thursdayTemplate.getY());
		}else if (myDay.contains("FRI")){
			Property fridayTemplate = window.getPropertyByName(FRIDAY_TEMPLATE);
			AutoIt.methode.controlFocus(window.getTitle(), NONE, fridayTemplate.getId());
			AutoIt.methode.controlClick(window.getTitle(), NONE, fridayTemplate.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, fridayTemplate.getX(), fridayTemplate.getY());
		}else if (myDay.contains("SAT")){
			Property saturdayTemplate = window.getPropertyByName(SATURDAY_TEMPLATE);
			AutoIt.methode.controlFocus(window.getTitle(), NONE, saturdayTemplate.getId());
			AutoIt.methode.controlClick(window.getTitle(), NONE, saturdayTemplate.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, saturdayTemplate.getX(), saturdayTemplate.getY());
		}
		AutoIt.methode.sleep(INTERVAL);
	}
	
	
	private static void stSelectDate(String date) throws Exception{
		Window window = getWindowProperty(NEW_PAGEPLAN);
		Property selectDateProperty = window.getPropertyByName(NEW_PAGEPLAN_DATE_SELECT);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, selectDateProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.ControlSetText(window.getTitle(), NONE, selectDateProperty.getId(), date);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void stPagePlanDesign(int down) throws Exception{
		Window window = getWindowProperty(NEW_PAGEPLAN);
		Property stPageTemplateProperty = window.getPropertyByName(NEWS_ST_PAGE_TEMPLATE);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, stPageTemplateProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, stPageTemplateProperty.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, stPageTemplateProperty.getX(), stPageTemplateProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
	}
	/**
	 * This function is to click on Ok Button
	 * @throws Exception Property not found exception
	 */
	private static void clickOkBtn() throws Exception{
		Window window = getWindowProperty(NEW_PAGEPLAN);
		Property okBtnProperty = window.getPropertyByName(NEW_PAGEPLAN_OK_BTN);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, okBtnProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlClick(window.getTitle(), NONE, okBtnProperty.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, okBtnProperty.getX(), okBtnProperty.getY());
		window = getWindowProperty(PAGE_PLANNER_MENU);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
	}
	
	
	public static void pagePlanName(String newpageplan) throws Exception{
		Window window = getWindowProperty(NEW_PAGEPLAN);
		Property pageplanNameProperty = window.getPropertyByName(NEW_PAGE_PLAN_NAME);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, pageplanNameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, pageplanNameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, pageplanNameProperty.getX(), pageplanNameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.ControlSetText(window.getTitle(), NONE, NONE, newpageplan);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	
}
