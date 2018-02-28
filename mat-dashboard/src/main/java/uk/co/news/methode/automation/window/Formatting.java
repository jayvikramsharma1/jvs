package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.WatchDog;


/**
 * Class contains all the AutoIt base functions to handle Formatting Window
 * @author sbharathi
 *
 */
public class Formatting extends BaseWindow {
    /**
     * This function to set the line height
     * @param heightremtext Text value
     * @throws Exception    Property not found exception
     */
	public static void lineHeight(String heightremtext, String testName, String stepName) throws Exception {

		Window window = getWindowProperty(FORMATTING_HEADLINE);
		Property formattingLineHeightProperty = window.getPropertyByName(LINE_HEIGHT);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, formattingLineHeightProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, formattingLineHeightProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, formattingLineHeightProperty.getX(), formattingLineHeightProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, formattingLineHeightProperty.getId());
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, heightremtext, true);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(3));
		AutoIt.methode.sleep(INTERVAL);
	}
    /**
     * This function is to set the Letter space 
     * @param letterSpacingValue Text Value
     * @throws Exception         Property not found exception
     */
	public static void letterSpacing(String letterSpacingValue, String testName, String stepName) throws Exception {
		Window window = getWindowProperty(FORMATTING_HEADLINE);
		Property formattingLineHeightProperty = window.getPropertyByName(LINE_HEIGHT);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, formattingLineHeightProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, formattingLineHeightProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, formattingLineHeightProperty.getX(), formattingLineHeightProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(1));
		AutoIt.methode.sleep(INTERVAL);
		/*Property letterSpacingProperty = window.getPropertyByName(LETTER_SPACING);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, letterSpacingProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, letterSpacingProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, letterSpacingProperty.getX(), letterSpacingProperty.getY());
		AutoIt.methode.sleep(INTERVAL);*/
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, letterSpacingValue,true);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(2));
		AutoIt.methode.sleep(INTERVAL);
	}
    /**
     * This function is to set the font size
     * @param fontSize   Text Value
     * @throws Exception Property not found exception
     */
	public static void fontSize(String fontSize, String testName, String stepName) throws Exception {
		Window window = getWindowProperty(FORMATTING_HEADLINE);
		Property formattingLineHeightProperty = window.getPropertyByName(LINE_HEIGHT);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, formattingLineHeightProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, formattingLineHeightProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, formattingLineHeightProperty.getX(), formattingLineHeightProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(2));
		AutoIt.methode.sleep(INTERVAL);
		/*Property fontSizeProperty = window.getPropertyByName(FONT_SIZE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(2));
		AutoIt.methode.controlFocus(window.getTitle(), NONE, fontSizeProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, fontSizeProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, fontSizeProperty.getX(), fontSizeProperty.getY());*/
		//AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1015, 570, Mouse.DOUBLE_CLICK, 2000);
		//AutoIt.methode.sleep(INTERVAL);
		//AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(2));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, fontSize,true);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(1));
		AutoIt.methode.sleep(INTERVAL);
	}
    /**
     * This function is to click on Save Button
     * @throws Exception Property not found exception
     */
	public static void formattingSaveBtn() throws Exception {
		Window window = getWindowProperty(FORMATTING_HEADLINE);
		Property formattingSaveBtnProperty = window.getPropertyByName(FORMATTING_SAVE_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		/*AutoIt.methode.controlFocus(window.getTitle(), NONE, formattingSaveBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, formattingSaveBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, formattingSaveBtnProperty.getX(), formattingSaveBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(1));
		AutoIt.methode.sleep(INTERVAL);*/
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		window = getWindowProperty(STORY_PREPARATION_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}
    /**
     * This function is to click on Close Button
     * @throws Exception Property not found exception
     */
	public static void formattingCloseBtn() throws Exception {
		Window window = getWindowProperty(FORMATTING_HEADLINE);
		Property formattingCloseBtnProperty = window.getPropertyByName(FORMATTING_CLOSE_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, formattingCloseBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, formattingCloseBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, formattingCloseBtnProperty.getX(), formattingCloseBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(STORY_PREPARATION_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void selectAllSlot() throws Exception {
		Window window = getWindowProperty(FORMATTING_HEADLINE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, "^a");
		// AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, "a",false);
		// AutoIt.methode.send("{RCTRL}A");
	}

}
