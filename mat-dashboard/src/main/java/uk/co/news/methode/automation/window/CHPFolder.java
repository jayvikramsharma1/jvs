	package uk.co.news.methode.automation.window;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;

public class CHPFolder extends BaseWindow {

	public static void chpadvancedSearch(String textToSearch, String ValueOfHeight,String valueOfWidth) throws Exception {
		clickOnCHPFolder();
		CHP.storySearch(textToSearch);
		clickONCHPSearchIcon();
		clickOnAdvanced();
		textSelectArea01();
		textAreaField01(ValueOfHeight);
		clickOnAddBtn();
		textSelectArea02();
		textAreaField02(valueOfWidth);
		clickOnSearchIcon();
	}
	
	public static void chpadvancedsearchStory(String textSearch, int down, int manipulation, String wordcount) throws Exception{
		clickOnCHPFolder();
		CHP.textToSearch(textSearch);
		clickONCHPSearchIconStory();
		clickOnAdvanced();
		anyTextfield(down);
		equalto(manipulation);
		wordCounttextArea(wordcount);
		clickOnSearchIcon();
	}

	public static void clickOnCHPFolder() throws Exception {
		Window window = getWindowProperty(MAIN);
		Property clickOnCHPFolderProperty = window.getPropertyByName(CLICK_ON_CHP_FOLDER);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(4000);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickOnCHPFolderProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickOnCHPFolderProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, clickOnCHPFolderProperty.getX(), clickOnCHPFolderProperty.getY());
		AutoIt.methode.sleep(8000);
	}

	public static void clickONCHPSearchIcon() throws Exception {
		/*
		 * Window window = getWindowProperty(MAIN); Property
		 * clickONCHPSearchIconProperty =
		 * window.getPropertyByName(CLICK_ON_CHP_ADVANCED_SEARCH_ICON);
		 * AutoIt.methode.winActivate(window.getTitle());
		 * AutoIt.methode.sleep(INTERVAL);
		 * AutoIt.methode.controlFocus(window.getTitle(), NONE,
		 * clickONCHPSearchIconProperty.getId());
		 * AutoIt.methode.controlClick(window.getTitle(), NONE,
		 * clickONCHPSearchIconProperty.getId(), Mouse.LEFT_CLICK,
		 * Mouse.SINGLE_CLICK, clickONCHPSearchIconProperty.getX(),
		 * clickONCHPSearchIconProperty.getY()); AutoIt.methode.sleep(INTERVAL);
		 */
		Window window = getWindowProperty(MAIN);
		AutoIt.methode.sleep(4000);
		AutoIt.methode.mouseClick(NONE, 1890, 121, Mouse.SINGLE_CLICK, 1000);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClick(NONE, 1893, 152, Mouse.SINGLE_CLICK, 1000);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void clickONCHPSearchIconStory() throws Exception {
		/*
		 * Window window = getWindowProperty(MAIN); Property
		 * clickONCHPSearchIconProperty =
		 * window.getPropertyByName(CLICK_ON_CHP_ADVANCED_SEARCH_ICON);
		 * AutoIt.methode.winActivate(window.getTitle());
		 * AutoIt.methode.sleep(INTERVAL);
		 * AutoIt.methode.controlFocus(window.getTitle(), NONE,
		 * clickONCHPSearchIconProperty.getId());
		 * AutoIt.methode.controlClick(window.getTitle(), NONE,
		 * clickONCHPSearchIconProperty.getId(), Mouse.LEFT_CLICK,
		 * Mouse.SINGLE_CLICK, clickONCHPSearchIconProperty.getX(),
		 * clickONCHPSearchIconProperty.getY()); AutoIt.methode.sleep(INTERVAL);
		 */
		Window window = getWindowProperty(MAIN);
		AutoIt.methode.sleep(4000);
		AutoIt.methode.mouseClick(NONE, 1890, 121, Mouse.SINGLE_CLICK, 1000);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClick(NONE, 1893, 180, Mouse.SINGLE_CLICK, 1000);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void clickOnAdvanced() throws Exception {
		Window window = getWindowProperty(MAIN);
		Property clickOnAdvancedProperty = window.getPropertyByName(CLICK_ON_CHP_ADVANCED_SEARCH_IMAGES);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickOnAdvancedProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickOnAdvancedProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, clickOnAdvancedProperty.getX(), clickOnAdvancedProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void textSelectArea01() throws Exception {
		Window window = getWindowProperty(MAIN);
		Property textSelectArea01Property = window.getPropertyByName(CLICK_ON_SELECT_AREA_01);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, textSelectArea01Property.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, textSelectArea01Property.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, textSelectArea01Property.getX(), textSelectArea01Property.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(30));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(1));
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void textAreaField01(String valueOfHeight) throws Exception {
		Window window = getWindowProperty(MAIN);
		Property textFieldArea01Property = window.getPropertyByName(CLICK_ON_TEXT_AREA_01);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, textFieldArea01Property.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, textFieldArea01Property.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, textFieldArea01Property.getX(), textFieldArea01Property.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, valueOfHeight, true);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void clickOnAddBtn() throws Exception {
		Window window = getWindowProperty(MAIN);
		Property clickOnAddBtnProperty = window.getPropertyByName(CLICK_ON_ADD_BTN_01);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickOnAddBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickOnAddBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, clickOnAddBtnProperty.getX(), clickOnAddBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void textSelectArea02() throws Exception{
		Window window = getWindowProperty(MAIN);
		Property textSelectArea02Property = window.getPropertyByName(CLICK_ON_SELECT_AREA_02);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, textSelectArea02Property.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, textSelectArea02Property.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, textSelectArea02Property.getX(), textSelectArea02Property.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(31));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(1));
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void textAreaField02(String valueOfWidth) throws Exception {
		Window window = getWindowProperty(MAIN);
		Property textFieldArea02Property = window.getPropertyByName(CLICK_ON_TEXT_AREA_02);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, textFieldArea02Property.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, textFieldArea02Property.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, textFieldArea02Property.getX(), textFieldArea02Property.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, valueOfWidth, true);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void clickOnSearchIcon() throws Exception{
		Window window = getWindowProperty(MAIN);
		Property clickOnSearchIconProperty = window.getPropertyByName(CLICK_ON_SEARCH_OK_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickOnSearchIconProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickOnSearchIconProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, clickOnSearchIconProperty.getX(), clickOnSearchIconProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void anyTextfield(int down) throws Exception {
		Window window = getWindowProperty(MAIN);
		Property textSelectArea01Property = window.getPropertyByName(CLICK_ON_SELECT_AREA_01);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, textSelectArea01Property.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, textSelectArea01Property.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, textSelectArea01Property.getX(), textSelectArea01Property.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, textSelectArea01Property.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, textSelectArea01Property.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, textSelectArea01Property.getX(), textSelectArea01Property.getY());
		AutoIt.methode.sleep(INTERVAL);
	}
	public static void equalto(int manipulation) throws Exception {
		Window window = getWindowProperty(MAIN);
		Property equalstoProperty = window.getPropertyByName(CLICK_ON_EQUAL);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, equalstoProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, equalstoProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, equalstoProperty.getX(), equalstoProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(manipulation));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, equalstoProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, equalstoProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, equalstoProperty.getX(), equalstoProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void wordCounttextArea(String wordcount) throws Exception {
		Window window = getWindowProperty(MAIN);
		Property wordCountProperty = window.getPropertyByName(WORD_COUNT_NUMERIC);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, wordCountProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, wordCountProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, wordCountProperty.getX(), wordCountProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, wordcount,true);
		AutoIt.methode.sleep(INTERVAL);
	}
}
