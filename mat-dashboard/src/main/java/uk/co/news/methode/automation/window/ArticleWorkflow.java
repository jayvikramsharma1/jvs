package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.WatchDog;

/**
 * This class has written for the actions being performed in ArticleWorkflow
 * 
 * @author sbharathi
 *
 */
public class ArticleWorkflow extends BaseWindow {

	/**
	 * This function will set the workflow to tabsent and clicks apply and ok
	 * button
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */
	public static void workflowTabSent() throws Exception {
		tabSent();
		applyBtn();
		okBtn();
	}

	/**
	 * This function will set the workflow to tabApprove and clicks apply and ok
	 * button
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */

	public static void workflowTabApprove() throws Exception {
		tabApprove();
		applyBtn();
		okBtn();
	}

	/**
	 * This function will set the workflow to tabWait and clicks apply and ok
	 * button
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */

	public static void workflowtabWait() throws Exception {
		tabWait();
		applyBtn();
		okBtn();
	}

	/**
	 * This function will set the check box workflowremoveFromWorkflowTick and
	 * clicks apply and ok button
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */

	public static void workflowremoveFromWorkflowTick() throws Exception {
		removeFromWorkflowTick();
		applyBtn();
		okBtn();
	}

	/**
	 * This function will select the option of tabSent in workflow window
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */

	public static void tabSent() throws Exception {
		Window window = getWindowProperty(ARTICLE_WORKFLOW);
		Property tabSentProperty = window.getPropertyByName(WORKFLOW_TAB_SENT);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, tabSentProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, tabSentProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, tabSentProperty.getX(), tabSentProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will select the option of tabApprove in workflow window
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */
	public static void tabApprove() throws Exception {
		Window window = getWindowProperty(ARTICLE_WORKFLOW);
		Property tabApproveProperty = window.getPropertyByName(WORKFLOW_TAB_APPROVE);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, tabApproveProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, tabApproveProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, tabApproveProperty.getX(), tabApproveProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will select the option of tabWait in workflow window
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */

	public static void tabWait() throws Exception {
		Window window = getWindowProperty(ARTICLE_WORKFLOW);
		Property tabWaitProperty = window.getPropertyByName(WORKFLOW_TAB_WAIT);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, tabWaitProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, tabWaitProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, tabWaitProperty.getX(), tabWaitProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will click on applyButton in workflow window
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */

	public static void applyBtn() throws Exception {
		Window window = getWindowProperty(ARTICLE_WORKFLOW);
		Property applyBtnProperty = window.getPropertyByName(WORKFLOW_APPLY_BTN);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, applyBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, applyBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, applyBtnProperty.getX(), applyBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will click on okButton in workflow window
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */

	public static void okBtn() throws Exception {
		Window window = getWindowProperty(ARTICLE_WORKFLOW);
		Property okBtnProperty = window.getPropertyByName(WORKFLOW_OK_BTN);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, okBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, okBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, okBtnProperty.getX(), okBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(STORY_PREPARATION_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will click on Cancel Button in workflow window
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */

	public static void cancelBtn() throws Exception {
		Window window = getWindowProperty(ARTICLE_WORKFLOW);
		Property cancelBtnProperty = window.getPropertyByName(WORKFLOW_CANCEL_BTN);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, cancelBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, cancelBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, cancelBtnProperty.getX(), cancelBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(STORY_PREPARATION_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function is to check mark on the option removeFromWorkflow in
	 * workflow window
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */

	public static void removeFromWorkflowTick() throws Exception {
		Window window = getWindowProperty(ARTICLE_WORKFLOW);
		Property removeFromWorkflowTickProperty = window.getPropertyByName(WORKFLOW_REMOVE_FROM_WORKFLOW);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, removeFromWorkflowTickProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, removeFromWorkflowTickProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, removeFromWorkflowTickProperty.getX(), removeFromWorkflowTickProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

}
