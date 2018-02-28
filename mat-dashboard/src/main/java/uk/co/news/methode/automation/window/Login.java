package uk.co.news.methode.automation.window;

import org.apache.log4j.Logger;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.exception.PropertyNotFound;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.Environment;
import uk.co.news.methode.automation.utils.Screenshot;

/**
 * Class contains all the AutoIt base functions to handle Login Window
 * @author sbharathi
 *
 */
public class Login extends BaseWindow {

	final static Logger logger = Logger.getLogger(Logger.class);
    
	/**
	 * This function is to Login
	 * @throws Exception Property not found exception
	 */
	public static void doLogin() throws Exception {

	//	Publication.selectTitle();

		/*Window window = getWindowProperty(LOGIN);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);*/
		// selectEnvironment(window);
		enterUsername();
		enterPassword();
		Screenshot.capture("login");
		clickOk();
	}
   /**
    * This function is to enter the username
    * @throws Exception Property not found exception
    */
	private static void enterUsername() throws Exception {
		Window window = getWindowProperty(LOGIN);
		Property usernameProperty = window.getPropertyByName(LOGIN_USERNAME);

		String username = Environment.getUserName();
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.controlFocus(window.getTitle(), NONE, usernameProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		// AutoIt.methode.controlClick(window.getTitle(), NONE,
		// usernameProperty.getId());
		//AutoIt.methode.controlSend(window.getTitle(), NONE, usernameProperty.getId(), username);
		AutoIt.methode.send(username);
		AutoIt.methode.sleep(INTERVAL);

	}
    /**
     * This function is to select Environment
     * @param window            Login Window
     * @throws PropertyNotFound Property not found exception
     * @throws Exception        Property not found exception
     */
	public static void selectEnvironment(Window window) throws PropertyNotFound, Exception {

		String enviroment = Environment.getEnvironment();
		String title = Environment.getTitle();
		Property expander = new Property();
		Property database = new Property();

		if (enviroment.equals(DEV) && title.equals(title.equals(TIMES))) {
			expander = window.getPropertyByName(LOGIN_DEV_EXPANDER);
			database = window.getPropertyByName(LOGIN_DEV_DB1);
		} else if (enviroment.equals(SI) && title.equals(title.equals(TIMES))) {
			expander = window.getPropertyByName(LOGIN_SI_EXPANDER);
			database = window.getPropertyByName(LOGIN_SI_DB1);
		}

		AutoIt.methode.controlFocus(window.getTitle(), NONE, expander.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, expander.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK,
				expander.getX(), expander.getY());
		AutoIt.methode.controlClick(window.getTitle(), NONE, expander.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK,
				expander.getX(), expander.getY());

		AutoIt.methode.controlClick(window.getTitle(), NONE, database.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK,
				database.getX(), database.getY());
		AutoIt.methode.winActivate(window.getTitle());

	}
	/**
	 * This function is to enter the password
	 * @throws Exception Property not found exception
	 */

	public static void enterPassword() throws Exception {
		Window window = getWindowProperty(LOGIN);
		Property passwordProperty = window.getPropertyByName(LOGIN_PASSWORD);
		String password = Environment.getPassword();
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.controlFocus(window.getTitle(), NONE, passwordProperty.getId());
		//AutoIt.methode.controlClick(window.getTitle(), NONE, passwordProperty.getId(),Mouse.LEFT_CLICK,Mouse.SINGLE_CLICK,passwordProperty.getX(),passwordProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		//AutoIt.methode.controlSend(window.getTitle(), NONE, passwordProperty.getId(), password);
		AutoIt.methode.send(password);
		AutoIt.methode.sleep(INTERVAL);
	}
    /**
     * Cancel Login window
     */
	public static void doCancel() {

	}
    /**
     * Close login window
     */
	public static void doClose() {

	}
   /**
   * This function is to click on Login Button
   * @throws Exception Property not found exception
   */
	public static void clickOk() throws Exception {
		Window window = getWindowProperty(LOGIN);
		Property loginBtnProperty = window.getPropertyByName(LOGIN_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.controlFocus(window.getTitle(), NONE, loginBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, loginBtnProperty.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, loginBtnProperty.getX(),loginBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		Window errorWindow = getWindowProperty(LOGIN_ERROR);
		// WatchDog.wait(errorWindow);
		if (AutoIt.methode.winExists(errorWindow.getTitle())) {
			Property loginErrorBtn = errorWindow.getPropertyByName(ERROR_OK_BTN);
			AutoIt.methode.winWaitActive(errorWindow.getTitle());
			AutoIt.methode.sleep(INTERVAL);
			AutoIt.methode.controlFocus(errorWindow.getTitle(), NONE, loginErrorBtn.getId());
			AutoIt.methode.controlClick(errorWindow.getTitle(), NONE, loginErrorBtn.getId(), Mouse.LEFT_CLICK,Mouse.SINGLE_CLICK, loginErrorBtn.getX(), loginErrorBtn.getY());
			AutoIt.methode.sleep(INTERVAL);
			AutoIt.methode.winActivate(window.getTitle());
			enterUsername();
			enterPassword();
			clickOk();
		}
	}

}
