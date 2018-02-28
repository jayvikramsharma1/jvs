package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.WatchDog;

/**
 * This class has written for the actions being performed in article Image
 * Metadata
 * 
 * @author sbharathi
 *
 */
public class ArticleImageMetadata extends BaseWindow {
	public static void horizontalAllignment(int down,String testName, String stepName) throws Exception{
		positionalsHorizontalAligndown(down,testName, stepName);
		medataPanelSaveBtn();
	}
	
	public static void horizontalAllignmentup(int up,String testName, String stepName) throws Exception{
		positionalsHorizontalAlignup(up, testName, stepName);
		medataPanelSaveBtn();
	}

	/**
	 * This function will click on the do not crop field in the metadata panel
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */
	
	
	public static void doNotCropField(String testName, String stepName) throws Exception {
		Window window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		Property doNotCropFeildProperty = window.getPropertyByName(DO_NOT_CROP_FIELD);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, doNotCropFeildProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, doNotCropFeildProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, doNotCropFeildProperty.getX(), doNotCropFeildProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		Property outsideFrameProperty = window.getPropertyByName(IMAGE_OUTSIDE_FRAME);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, outsideFrameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, outsideFrameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, outsideFrameProperty.getX(), outsideFrameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will click on the doNotResize in the metadata panel
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */

	public static void doNotResize() throws Exception {
		Window window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		Property doNotCropResizeProperty = window.getPropertyByName(DO_NOT_RESIZE);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, doNotCropResizeProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, doNotCropResizeProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, doNotCropResizeProperty.getX(), doNotCropResizeProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		Property outsideFrameProperty = window.getPropertyByName(IMAGE_OUTSIDE_FRAME);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, outsideFrameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, outsideFrameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, outsideFrameProperty.getX(), outsideFrameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will click on the mandatoryClick in the metadata panel
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */

	public static void mandatoryClick() throws Exception {
		Window window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		Property mandatoryClick = window.getPropertyByName(MANDATORY_CLICK);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, mandatoryClick.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, mandatoryClick.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, mandatoryClick.getX(), mandatoryClick.getY());
		AutoIt.methode.sleep(INTERVAL);
		Property outsideFrameProperty = window.getPropertyByName(IMAGE_OUTSIDE_FRAME);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, outsideFrameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, outsideFrameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, outsideFrameProperty.getX(), outsideFrameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will click on the addToCarousel in the metadata panel
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */

	public static void addToCarousel(String testName, String stepName) throws Exception {
		Window window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		Property addToCarousel = window.getPropertyByName(ADD_TO_CAROUSEL);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, addToCarousel.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, addToCarousel.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, addToCarousel.getX(), addToCarousel.getY());
		AutoIt.methode.sleep(INTERVAL);
		Property outsideFrameProperty = window.getPropertyByName(IMAGE_OUTSIDE_FRAME);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, outsideFrameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, outsideFrameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, outsideFrameProperty.getX(), outsideFrameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will click on the disableTapBehaviour in the metadata panel
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */

	public static void disableTapBehaviour() throws Exception {
		Window window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		Property disableTapBehaviour = window.getPropertyByName(DISABLE_TAP_BEHAVIOUR);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, disableTapBehaviour.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, disableTapBehaviour.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, disableTapBehaviour.getX(), disableTapBehaviour.getY());
		AutoIt.methode.sleep(INTERVAL);
		Property outsideFrameProperty = window.getPropertyByName(IMAGE_OUTSIDE_FRAME);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, outsideFrameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, outsideFrameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, outsideFrameProperty.getX(), outsideFrameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will click on the disableImageEnhancement in the metadata
	 * panel
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */

	public static void disableImageEnhancement() throws Exception {
		Window window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		Property disableImageEnhancement = window.getPropertyByName(DISABLE_IMAGE_ENHANCEMENT);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, disableImageEnhancement.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, disableImageEnhancement.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, disableImageEnhancement.getX(), disableImageEnhancement.getY());
		AutoIt.methode.sleep(INTERVAL);
		Property outsideFrameProperty = window.getPropertyByName(IMAGE_OUTSIDE_FRAME);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, outsideFrameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, outsideFrameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, outsideFrameProperty.getX(), outsideFrameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will click on the positionalsPage and to selct the page
	 * 
	 * @param down
	 *            Down to get the page number selection
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */

	public static void positionalsPage(int down, String testName, String stepName) throws Exception {
		Window window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		Property positionalsPage = window.getPropertyByName(POSITIONAL_PAGE);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, positionalsPage.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, positionalsPage.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, positionalsPage.getX(), positionalsPage.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
		Property outsideFrameProperty = window.getPropertyByName(IMAGE_OUTSIDE_FRAME);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, outsideFrameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, outsideFrameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, outsideFrameProperty.getX(), outsideFrameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will click on the positionalsHorizontalAlign and to select
	 * the align position
	 * 
	 * @param down
	 *            Down to get the position of alignment
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */

	public static void positionalsHorizontalAligndown(int down, String testName, String stepName) throws Exception {
		Window window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		Property positionalsHorizontalAlign = window.getPropertyByName(POSITIONAL_HORIZONTAL_ALIGN);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, positionalsHorizontalAlign.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, positionalsHorizontalAlign.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, positionalsHorizontalAlign.getX(), positionalsHorizontalAlign.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
		Property outsideFrameProperty = window.getPropertyByName(IMAGE_OUTSIDE_FRAME);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, outsideFrameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, outsideFrameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, outsideFrameProperty.getX(), outsideFrameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void positionalsHorizontalAlignup(int up, String testName, String stepName) throws Exception {
		Window window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		Property positionalsHorizontalAlign = window.getPropertyByName(POSITIONAL_HORIZONTAL_ALIGN);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, positionalsHorizontalAlign.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, positionalsHorizontalAlign.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, positionalsHorizontalAlign.getX(), positionalsHorizontalAlign.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getUp(up));
		AutoIt.methode.sleep(INTERVAL);
		Property outsideFrameProperty = window.getPropertyByName(IMAGE_OUTSIDE_FRAME);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, outsideFrameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, outsideFrameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, outsideFrameProperty.getX(), outsideFrameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will click on the positionalsVerticalAlign and to select
	 * the align position
	 * 
	 * @param down
	 *            Down to get the position of vertical alignment
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */

	public static void positionalsVerticalAlign(int down, String testName, String stepName) throws Exception {
		Window window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		Property positionalsVerticalAlign = window.getPropertyByName(POSITIONAL_VERTICAL_ALIGN);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, positionalsVerticalAlign.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, positionalsVerticalAlign.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, positionalsVerticalAlign.getX(), positionalsVerticalAlign.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
		Property outsideFrameProperty = window.getPropertyByName(IMAGE_OUTSIDE_FRAME);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, outsideFrameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, outsideFrameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, outsideFrameProperty.getX(), outsideFrameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void positionalsVerticalAlignUp(int up, String testName, String stepName) throws Exception {
		Window window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		Property positionalsVerticalAlign = window.getPropertyByName(POSITIONAL_VERTICAL_ALIGN);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, positionalsVerticalAlign.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, positionalsVerticalAlign.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, positionalsVerticalAlign.getX(), positionalsVerticalAlign.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getUp(up));
		AutoIt.methode.sleep(INTERVAL);
		Property outsideFrameProperty = window.getPropertyByName(IMAGE_OUTSIDE_FRAME);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, outsideFrameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, outsideFrameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, outsideFrameProperty.getX(), outsideFrameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function is to set the positionalsColumnWidth of the image
	 * 
	 * @param down
	 *            Down to get the desired positional column width
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */

	public static void positionalsColumnWidth(int down, String testName, String stepName) throws Exception {
		Window window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		Property positionalsColumnWidth = window.getPropertyByName(POSITIONAL_COLUMN_WIDTH);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, positionalsColumnWidth.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, positionalsColumnWidth.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, positionalsColumnWidth.getX(), positionalsColumnWidth.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
		Property outsideFrameProperty = window.getPropertyByName(IMAGE_OUTSIDE_FRAME);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, outsideFrameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, outsideFrameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, outsideFrameProperty.getX(), outsideFrameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}
	public static void positionalsColumnWidthUp(int up, String testName, String stepName) throws Exception {
		Window window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		Property positionalsColumnWidth = window.getPropertyByName(POSITIONAL_COLUMN_WIDTH);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, positionalsColumnWidth.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, positionalsColumnWidth.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, positionalsColumnWidth.getX(), positionalsColumnWidth.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getUp(up));
		AutoIt.methode.sleep(INTERVAL);
		Property outsideFrameProperty = window.getPropertyByName(IMAGE_OUTSIDE_FRAME);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, outsideFrameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, outsideFrameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, outsideFrameProperty.getX(), outsideFrameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function is to click on save Button in the metadata panel
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */

	public static void medataPanelSaveBtn() throws Exception {
		Window window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		Property medataPanelSaveBtn = window.getPropertyByName(METADATA_PANEL_SAVE_BTN);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, medataPanelSaveBtn.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, medataPanelSaveBtn.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, medataPanelSaveBtn.getX(), medataPanelSaveBtn.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(STORY_PREPARATION_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function is to click on close Button in the metadata panel
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function 
	 *             throws Exception
	 */

	public static void medataPanelCloseBtn() throws Exception {
		Window window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		Property medataPanelCloseBtn = window.getPropertyByName(METADATA_PANEL_CLOSE_BTN);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, medataPanelCloseBtn.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, medataPanelCloseBtn.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, medataPanelCloseBtn.getX(), medataPanelCloseBtn.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(STORY_PREPARATION_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function is to set the inlineImageColumnpercentage as desired
	 * 
	 * @param percentageText
	 *            Sets the percentage value for the image metadata
	 * @throws Exception
	 *             When the properties are not found this respective function 
	 *             throws Exception
	 */

	public static void inlineImageColumnpercentage(String percentageText,String testName, String stepName) throws Exception {
		Window window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		Property inlineImageColumnpercentage = window.getPropertyByName(INLINE_METADATA_COLUMN_PERCENTAGE);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, inlineImageColumnpercentage.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, inlineImageColumnpercentage.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, inlineImageColumnpercentage.getX(), inlineImageColumnpercentage.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, "^a");
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, percentageText,true);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function is to click the option of inlineBaseline
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function it
	 *             throws Exception
	 */

	public static void inlineBaseline(String baseline, String testName, String stepName) throws Exception {
		Window window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		Property inlineBaseline = window.getPropertyByName(INLINE_METADATA_BASELINE);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, inlineBaseline.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, inlineBaseline.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, inlineBaseline.getX(), inlineBaseline.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, "^a");
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, baseline, true);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}

}
