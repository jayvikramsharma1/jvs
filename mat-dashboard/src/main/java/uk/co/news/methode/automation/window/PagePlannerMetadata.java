package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.WatchDog;


/**
 * Class contains all the AutoIt base functions to handle Page Planner Metadata
 * @author sbharathi
 *
 */
public class PagePlannerMetadata extends BaseWindow{
    /**
     * This function does Masthead Style Functionality
     * @param down        Count to down as Integer
     * @throws Exception  Property not found exception
     */
	public static void masthead_style(int down) throws Exception{
		clickingMetadataWindow();
		mastheadStyle(down);
		metaDataOkBtn();
	}
	/**
	 * This function does Hide Navigation Functionality
	 * @throws Exception Property not found exception
	 */
	public static void Hide_Navigation() throws Exception{
		clickingMetadataWindow();
		hideNavigation();
		metaDataOkBtn();
	}
	/**
	 * This function does Hide Headline Functionality
	 * @throws Exception Property not found exception
	 */
	public static void Hide_Headline() throws Exception{
		clickingMetadataWindow();
		hideHeadline();
		metaDataOkBtn();
	}
	/**
	 * This function does Alignment of Headline text
	 * @param down        Count to down as Integer
	 * @throws Exception  Property not found exception
	 */
	public static void Headline_Text_Alignment(int down) throws Exception{
		clickingMetadataWindow();
		headlineTextAlignment(down);
		metaDataOkBtn();
		
	}
	/**
	 * This function is to 
	 * @throws Exception
	 */
		public static void clickingMetadataWindow() throws Exception {
		Window window = getWindowProperty(PAGEPLANNER_META_DATA);
		Property metadataProperty = window.getPropertyByName(PAGEPLANNER_METADATA_WEB_PUBLICATION_CLICK);
		
		//Clicking on WebPublication_First Option
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.controlFocus(window.getTitle(), NONE, metadataProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, metadataProperty.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, metadataProperty.getX(), metadataProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		}
		
		
		//Selecting Masthead Style
		public static void mastheadStyle(int down) throws Exception{
		Window window = getWindowProperty(PAGEPLANNER_META_DATA);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(17));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(1));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
		}
		
		public static void hideNavigation() throws Exception{
			Window window = getWindowProperty(PAGEPLANNER_META_DATA);
			AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(22));
			AutoIt.methode.sleep(INTERVAL);
			AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(1));	
			AutoIt.methode.sleep(INTERVAL);
			AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(1));
			AutoIt.methode.sleep(INTERVAL);
		}
		
		public static void hideHeadline() throws Exception{
			Window window = getWindowProperty(PAGEPLANNER_META_DATA);	
			AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(13));
			AutoIt.methode.sleep(INTERVAL);
			AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(1));	
			AutoIt.methode.sleep(INTERVAL);
			AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(1));
			AutoIt.methode.sleep(INTERVAL);
		}
		
		public static void headlineTextAlignment(int down) throws Exception{
			Window window = getWindowProperty(PAGEPLANNER_META_DATA);	
			AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(15));
			AutoIt.methode.sleep(INTERVAL);
			AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(1));	
			AutoIt.methode.sleep(INTERVAL);
			AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
			AutoIt.methode.sleep(INTERVAL);
		}

		
		//Clicking on Ok Button in Metadata
		public static void metaDataOkBtn() throws Exception{
		Window window = getWindowProperty(PAGEPLANNER_META_DATA);
		Property metaDataOKBtnProperty = window.getPropertyByName(PAGEPLANNER_METADATA_OK_BTN);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, metaDataOKBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, metaDataOKBtnProperty.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, metaDataOKBtnProperty.getX(), metaDataOKBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(PAGE_PLANNER_MENU);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		}
		
		public static void metaDataCancelBtn() throws Exception{
		Window window = getWindowProperty(PAGEPLANNER_META_DATA);
		Property metaDataCancelBtnProperty = window.getPropertyByName(PAGEPLANNER_METADATA_CANCEL_BTN);
        AutoIt.methode.controlFocus(window.getTitle(), NONE, metaDataCancelBtnProperty.getId());
        AutoIt.methode.controlClick(window.getTitle(), NONE, metaDataCancelBtnProperty.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, metaDataCancelBtnProperty.getX(), metaDataCancelBtnProperty.getY());
        window = getWindowProperty(PAGE_PLANNER_MENU);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
	}
		
		public static void atomUrlBtn() throws Exception{
				Window window = getWindowProperty(PAGEPLANNER_META_DATA);
				AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(21));
				AutoIt.methode.sleep(INTERVAL);
				AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(1));	
				AutoIt.methode.sleep(INTERVAL);
		}
	
}
