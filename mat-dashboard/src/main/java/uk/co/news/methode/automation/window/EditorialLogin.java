package uk.co.news.methode.automation.window;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;


public class EditorialLogin extends BaseWindow{
	
	public static void editorialLogin(String username, String password) throws Exception{
		openApp();
		enterUsername(username);
		enterPassword(password);
		clickOk();
	}
	
	public static void openApp() throws Exception{
		AutoIt.methode.run("C:\\Program Files\\EidosMedia\\Methode\\bin\\Methode.exe");
	}
	
	public static void enterUsername(String username) throws Exception {
		Window window = getWindowProperty(LOGIN);
		Property usernameProperty = window.getPropertyByName(LOGIN_USERNAME);

		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, usernameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, usernameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, usernameProperty.getX(), usernameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.ControlSetText(window.getTitle(), NONE, NONE, username);
		// AutoIt.methode.controlClick(window.getTitle(), NONE,
		// usernameProperty.getId());
		//AutoIt.methode.controlSend(window.getTitle(), NONE, usernameProperty.getId(), username);
		//AutoIt.methode.send(username);
		AutoIt.methode.sleep(INTERVAL);

	}
	
	public static void enterPassword(String password) throws Exception {
		Window window = getWindowProperty(LOGIN);
		Property passwordProperty = window.getPropertyByName(LOGIN_PASSWORD);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, passwordProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, passwordProperty.getId(),Mouse.LEFT_CLICK,Mouse.SINGLE_CLICK,passwordProperty.getX(),passwordProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, passwordProperty.getId(), password);
		//AutoIt.methode.send(password);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void clickOk() throws Exception {
		Window window = getWindowProperty(LOGIN);
		Property loginBtnProperty = window.getPropertyByName(LOGIN_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.controlFocus(window.getTitle(), NONE, loginBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, loginBtnProperty.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, loginBtnProperty.getX(),loginBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		Window mainWindow = getWindowProperty(MAIN);
		AutoIt.methode.winWaitActive(mainWindow.getTitle());
		System.out.println("Login into Editorial User");
		/*Window errorWindow = getWindowProperty(LOGIN_ERROR);
		// WatchDog.wait(errorWindow);
		if (AutoIt.methode.winExists(errorWindow.getTitle())) {
			Property loginErrorBtn = errorWindow.getPropertyByName(ERROR_OK_BTN);
			AutoIt.methode.winWaitActive(errorWindow.getTitle());
			AutoIt.methode.sleep(INTERVAL);
			AutoIt.methode.controlFocus(errorWindow.getTitle(), NONE, loginErrorBtn.getId());
			AutoIt.methode.controlClick(errorWindow.getTitle(), NONE, loginErrorBtn.getId(), Mouse.LEFT_CLICK,Mouse.SINGLE_CLICK, loginErrorBtn.getX(), loginErrorBtn.getY());
			AutoIt.methode.sleep(INTERVAL);
			AutoIt.methode.winActivate(window.getTitle());
			enterUsername(username);
			enterPassword(password);
			clickOk(username,password);
		}*/
	}

}
