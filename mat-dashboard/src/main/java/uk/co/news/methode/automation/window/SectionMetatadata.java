package uk.co.news.methode.automation.window;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.Screenshot;



public class SectionMetatadata extends BaseWindow{
	
	public static void hideNavigationSlot(String testName, String stepName) throws Exception{
		hideNavigation();
		saveSectionMetadata(testName, stepName);
	}

	public static void closeBtn() throws Exception{
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property closeSectionMetadataProperty = window.getPropertyByName(CLOSE_SECTION_METADATA);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		Screenshot.capture("Book Section Slot");
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1900, 93, Mouse.SINGLE_CLICK, INTERVAL);
		AutoIt.methode.sleep(INTERVAL);
		/*AutoIt.methode.controlFocus(window.getTitle(), NONE, closeSectionMetadataProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, closeSectionMetadataProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, closeSectionMetadataProperty.getX(), closeSectionMetadataProperty.getY());*/
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void hideNavigation() throws Exception{
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property hideNavigationMetadataProperty = window.getPropertyByName(HIDE_NAVIGATION);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, hideNavigationMetadataProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, hideNavigationMetadataProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, hideNavigationMetadataProperty.getX(), hideNavigationMetadataProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void saveSectionMetadata(String testName, String stepName) throws Exception{
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property saveSectionMetadataProperty = window.getPropertyByName(SAVE_SECTION_METADATA);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		/*AutoIt.methode.controlFocus(window.getTitle(), NONE, saveSectionMetadataProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, saveSectionMetadataProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, saveSectionMetadataProperty.getX(), saveSectionMetadataProperty.getY());*/
		AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1710, 1065, Mouse.SINGLE_CLICK, 2000);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}
}
