package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.WatchDog;


public class SendToProduction extends BaseWindow {

	public static void sendToProduction(String edittext) throws Exception {
		editText(edittext);
		sendToProductionOkBtn();
	}

	public static void editText(String edittext) throws Exception {
		Window window = getWindowProperty(SEND_TO_PRODUCTION);
		Property editTextProperty = window.getPropertyByName(EDIT_NAME);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, editTextProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, editTextProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, editTextProperty.getX(), editTextProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, edittext, true);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void sendToProductionOkBtn() throws Exception {
		Window window = getWindowProperty(SEND_TO_PRODUCTION);
		Property sendToProductionOkBtnProperty = window.getPropertyByName(SEND_TO_PRODUCTION_OK_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, sendToProductionOkBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, sendToProductionOkBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, sendToProductionOkBtnProperty.getX(), sendToProductionOkBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(MAIN);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

}
