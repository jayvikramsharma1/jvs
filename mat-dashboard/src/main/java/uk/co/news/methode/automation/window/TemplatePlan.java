package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.WatchDog;



public class TemplatePlan extends BaseWindow {

	public static void openarticle(String article) throws Exception {
		outsideFrame();
		open_article(article);
	}
	
	public static void openchildarticle() throws Exception {
		outsideFrame();
		openChildArticle();
	}

	public static void methodeQuery() throws Exception {
		getQuickAccessBar();
		searchQuery();
	}

	public static void create_article(String article) throws Exception {
		Window window = getWindowProperty(DWP_PAGE);
		Property createOptionProperty = window.getPropertyByName(article);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, createOptionProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, createOptionProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, createOptionProperty.getX(), createOptionProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(3));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(NEW_STORY);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void open_article(String article) throws Exception {
		Window window = getWindowProperty(DWP_PAGE);
		Property OpenarticleProperty = window.getPropertyByName(article);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, OpenarticleProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, OpenarticleProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, OpenarticleProperty.getX(), OpenarticleProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(1));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(STORY_PREPARATION_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void outsideFrame() throws Exception {
		Window window = getWindowProperty(DWP_PAGE);
		Property outsideFrameProperty = window.getPropertyByName(OUTSIDE_FRAME);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, outsideFrameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, outsideFrameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, outsideFrameProperty.getX(), outsideFrameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void close_window() throws Exception {
		Window window = getWindowProperty(DWP_PAGE);
		Property closeTemplateWindowProperty = window.getMenu(DWP_FILE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		// AutoIt.methode.controlFocus(window.getTitle(), NONE,
		// closeTemplateWindowProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, closeTemplateWindowProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, closeTemplateWindowProperty.getX(), closeTemplateWindowProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(5));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.winClose(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(PAGE_PLANNER_MENU);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void candidateBrowser() throws Exception {
		Window window = getWindowProperty(DWP_PAGE);
		Property candidateBrowserProperty = window.getMenu(DWP_VIEW);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, candidateBrowserProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, candidateBrowserProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, candidateBrowserProperty.getX(), candidateBrowserProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(1));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void candidateBrowserImage(int down) throws Exception {
		Window window = getWindowProperty(DWP_PAGE);
		Property candidateBrowserImage = window.getPropertyByName(NEW_IMAGE_CANDIDATE_BROWSER_DWP);
		// Default articleImageProperty =
		// getDefaultPropertyByName(DEFAULT_ARTICLE_MAIN_IMAGE);
		// Default candidateImageProperty =
		// getDefaultPropertyByName(imagePosition);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, candidateBrowserImage.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(1));
		// AutoIt.methode.sleep(INTERVAL);
		// AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1364, 382, 400, 700,
		// INTERVAL);
		// AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK,
		// candidateImageProperty.getX(),
		// candidateImageProperty.getY(),articleImageProperty.getX(),
		// articleImageProperty.getY(),INTERVAL);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void mediaGalleryStory() throws Exception {
		Window window = getWindowProperty(DWP_PAGE);
		Property newsMediaProperty = window.getPropertyByName(NEW_IMAGE_CANDIDATE_BROWSER_DWP);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, newsMediaProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, newsMediaProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, newsMediaProperty.getX(), newsMediaProperty.getY());
		// AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(5));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);

	}

	public static void dragMediaGallery() throws Exception {
		Window window = getWindowProperty(DWP_PAGE);
		Property mediaStoryPositionProperty = window.getPropertyByName(MEDIA_STORY_POSITION);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, mediaStoryPositionProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, mediaStoryPositionProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, mediaStoryPositionProperty.getX(), mediaStoryPositionProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1300, 150, 350, 100, INTERVAL);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void getQuickAccessBar() throws Exception {
		System.out.println("getting the access bar");
		Window window = getWindowProperty(DWP_PAGE);
		Property toGetQuickAccessBar = window.getPropertyByName(QUICK_ACCESS_BAR);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, toGetQuickAccessBar.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, toGetQuickAccessBar.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, toGetQuickAccessBar.getX(), toGetQuickAccessBar.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(4));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(DWP_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
		System.out.println("got the access bar");
	}

	public static void searchQuery() throws Exception {
		System.out.println("search query");
		Window window = getWindowProperty(DWP_PAGE);
		Property searchQueryIcon = window.getPropertyByName(SEARCH_QUERY_ICON);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, searchQueryIcon.getId());
		AutoIt.methode.sleep(INTERVAL);
		System.out.println("control clicking -->" + window.getTitle() + "--" + searchQueryIcon.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, searchQueryIcon.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, searchQueryIcon.getX(), searchQueryIcon.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(METHODE_SEARCH_QUERY);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);

	}

	public static void dragExistingStory() throws Exception {
		Window window = getWindowProperty(DWP_PAGE);
		Property candidateBrowseProperty = window.getPropertyByName(ACTIVATE_CANDIDATE_BROWSER);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, candidateBrowseProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, candidateBrowseProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, candidateBrowseProperty.getX(), candidateBrowseProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1663, 196, 331, 279, 3000);
		AutoIt.methode.sleep(INTERVAL);

	}

	public static void dragStory() throws Exception {
		Window window = getWindowProperty(DWP_PAGE);
		Property clickOnVideoStory = window.getPropertyByName(NEW_QUERY_STORY_DRAG);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickOnVideoStory.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickOnVideoStory.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, clickOnVideoStory.getX(), clickOnVideoStory.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1300, 150, 350, 100, 600);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void createChildArticle() throws Exception {
		Window window = getWindowProperty(DWP_PAGE);
		Property openChildArticleProperty = window.getPropertyByName(CHILD_ARTICLE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, openChildArticleProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, openChildArticleProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, openChildArticleProperty.getX(), openChildArticleProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(3));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(NEW_STORY);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void openChildArticle() throws Exception {
		Window window = getWindowProperty(DWP_PAGE);
		Property openChildArticleProperty = window.getPropertyByName(CHILD_ARTICLE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, openChildArticleProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, openChildArticleProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, openChildArticleProperty.getX(), openChildArticleProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(1));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(STORY_PREPARATION_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}
	

	public static void floorline() throws Exception {
		Window window = getWindowProperty(DWP_PAGE);
		Property floorlineProperty = window.getPropertyByName(ARTICLE_FLOORLINE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, floorlineProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, floorlineProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, floorlineProperty.getX(), floorlineProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1700, 158, 324, 276, 1000);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void businessBookFloorline() throws Exception {
		Window window = getWindowProperty(DWP_PAGE);
		Property floorlineProperty = window.getPropertyByName(ARTICLE_FLOORLINE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, floorlineProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, floorlineProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, floorlineProperty.getX(), floorlineProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1700, 158, 314, 276, 1000);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void removefloorLine() throws Exception{
		Window window = getWindowProperty(DWP_PAGE);
		AutoIt.methode.mouseClick(Mouse.RIGHT_CLICK, 324, 460, Mouse.SINGLE_CLICK, 1000);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(4));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	
	
	public static void screenshotCapture(String testName, String stepName ) throws Exception{
		captureScreen(testName, stepName);
	}
}
