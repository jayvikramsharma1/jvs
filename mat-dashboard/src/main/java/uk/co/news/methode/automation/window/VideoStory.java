package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.WatchDog;


public class VideoStory extends BaseWindow{
	
	public static final String EMBEDDED = "FuOTlxNTE62im-35QQXMiNtd0JrThP0o";

	/**
	 * This function is to write the headline of an article
	 * 
	 * @param headline
	 *            Headline text for an article
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void titleHeadline(String headline) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property videoArticleHeadlineProperty = window.getPropertyByName(VIDEO_ARTICLE_HEADLINE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, videoArticleHeadlineProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, videoArticleHeadlineProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.TRIPLE_CLICK, videoArticleHeadlineProperty.getX(), videoArticleHeadlineProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, headline, true);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void quickmetadata() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property quickMetadataProperty = window.getMenu(DWP_FILE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		// AutoIt.methode.controlFocus(window.getTitle(), NONE,
		// quickMetadataProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, quickMetadataProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, quickMetadataProperty.getX(), quickMetadataProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(15));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void embeddeCode() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property embeddedCodeProperty = window.getPropertyByName(EMBEDDED_CODE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, embeddedCodeProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, embeddedCodeProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.TRIPLE_CLICK, embeddedCodeProperty.getX(), embeddedCodeProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, EMBEDDED, true);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void candidateBrowserImage1() throws Exception {
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1715, 370, 415, 575, 2000);
		AutoIt.methode.sleep(3000);
	}
	
	public static void closevideoArticlePreparation() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property saveArticleWindowProperty = window.getMenu(DWP_FILE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		// AutoIt.methode.controlFocus(window.getTitle(), NONE,
		// saveArticleWindowProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, saveArticleWindowProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, saveArticleWindowProperty.getX(), saveArticleWindowProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(6));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.winClose(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(MAIN);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}
	
}
