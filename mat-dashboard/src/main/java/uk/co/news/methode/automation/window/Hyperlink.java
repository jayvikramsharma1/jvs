package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.UUID;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.WatchDog;


public class Hyperlink extends BaseWindow {

	private String uuid;
	
	
	public static void insertHyperlink(String hyper_text) throws Exception {
		clickOnTextArea(hyper_text);
		//clickOnWebPageTextArea(UUID);
		clickOKBtn();
	}

	public static void clickOnTextArea(String hyper_text) throws Exception {
		Window window = getWindowProperty(HYPER_LINK);
		Property clickOnTextAreaProperty = window.getPropertyByName(CLICK_ON_TEXT);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickOnTextAreaProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickOnTextAreaProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, clickOnTextAreaProperty.getX(), clickOnTextAreaProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, hyper_text, true);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE,  Mouse.getTab(1));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE,  UUID.getArticleUUID());
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void clickOnTextAreawebUrl(String hyper_text,String url) throws Exception {
		Window window = getWindowProperty(HYPER_LINK);
		Property clickOnTextAreaProperty = window.getPropertyByName(CLICK_ON_TEXT);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickOnTextAreaProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickOnTextAreaProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, clickOnTextAreaProperty.getX(), clickOnTextAreaProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, hyper_text, true);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE,  Mouse.getTab(1));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, url, true);
	}

	

	public static void clickOKBtn() throws Exception {
		Window window = getWindowProperty(HYPER_LINK);
		Property clickOKBtnProperty = window.getPropertyByName(OK_BTN_HYPERLINK);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickOKBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickOKBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, clickOKBtnProperty.getX(), clickOKBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(STORY_PREPARATION_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}
}
