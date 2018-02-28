package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.WatchDog;


public class CHP extends BaseWindow{
	
	public static void quickCHPQuery(String searchfortext) throws Exception {
		chpSearchFor(searchfortext);
		chpOkBtn();
	}
	
	public static void storySearch(String textToSearch) throws Exception{
		textToSearch(textToSearch);
		clickOnAllAssets();
		chpStories();	
		clickOnSearchIcon();
	}
	
	public static void pictureSearch() throws Exception{
		//textToSearch(textToSearch);
		clickOnAllAssets();
		chpPictures();
		clickOnSearchIcon();
	}
	
	public static void getImageCandidateBrowser(int down) throws Exception{
		checkChannelCopyWindow();
		addImageCandidateBrowser(down);
	}
	
	public static void inlineImageCHP(String Storyname) throws Exception{
		ArticlePreparation.searchQuery();
		NewSearchQuery.getQueryImage(Storyname);
		getInlineImage();
	}

	public static void queryCHPName(String querytext) throws Exception {
		Window window = getWindowProperty(NEW_CHP_QUERY);
		Property queryCHPNameProperty = window.getPropertyByName(CHP_QUERY_NAME);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, queryCHPNameProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, queryCHPNameProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, queryCHPNameProperty.getX(), queryCHPNameProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, querytext, true);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void chpSearchFor(String searchfortext) throws Exception {
		Window window = getWindowProperty(NEW_CHP_QUERY);
		Property chpSearchForProperty = window.getPropertyByName(CHP_SEARCH_FOR);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, chpSearchForProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, chpSearchForProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, chpSearchForProperty.getX(), chpSearchForProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, searchfortext, true);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void chpOkBtn() throws Exception {
		Window window = getWindowProperty(NEW_CHP_QUERY);
		Property chpOkBtnrProperty = window.getPropertyByName(CHP_OK_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, chpOkBtnrProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, chpOkBtnrProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, chpOkBtnrProperty.getX(), chpOkBtnrProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(MAIN);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void checkChannelCopyWindow() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		AutoIt.methode.sleep(5000);
		Window childWindow = getWindowProperty(CREATE_CHANNEL_COPY);
		String windowTitle = childWindow.getTitle();
		System.out.println("window is active");
		if (AutoIt.methode.winExists(windowTitle)) {
			System.out.println("inside if");
			AutoIt.methode.sleep(INTERVAL);
			AutoIt.methode.winActivate(windowTitle);
			AutoIt.methode.sleep(INTERVAL);
			System.out.println("window is active");
			ChannelCopy.createChannelCopy();

		} else {
			AutoIt.methode.winActivate(windowTitle);
		}
	}
	
	public static void addImageCHPWithoutCondition(String Storyname) throws Exception{
		ArticlePreparation.clickOnSearchIcon();;
		NewSearchQuery.getQueryImage(Storyname);
		getImage();
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void addImageCHP(String Storyname) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property addImageProperty = window.getPropertyByName(CLICKING_ON_IMAGE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, addImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, addImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, addImageProperty.getX(), addImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE,Mouse.getDown(6));
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE,  Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		Window childWindow = getWindowProperty(SELECT_IMAGE);
		String windowTitle = childWindow.getTitle();
		AutoIt.methode.sleep(INTERVAL);
		if (AutoIt.methode.winExists(windowTitle)) {
			AutoIt.methode.sleep(INTERVAL);
		SelectImageLocal.cancelSelectBtn();
		ArticlePreparation.searchQuery();
		NewSearchQuery.getQueryImage(Storyname);
		//ArticlePreparation.closeQuickAccessBar();
		getImage();
		AutoIt.methode.sleep(INTERVAL);
		}
		else{
			AutoIt.methode.winActivate(window.getTitle());
			ArticlePreparation.getQuickAccessBar();
		}
	}
	
	public static void addImageCHPWithoutClosingQueryWindow(String Storyname) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property addImageProperty = window.getPropertyByName(CLICKING_ON_IMAGE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, addImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, addImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, addImageProperty.getX(), addImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE,Mouse.getDown(6));
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE,  Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		Window childWindow = getWindowProperty(SELECT_IMAGE);
		String windowTitle = childWindow.getTitle();
		AutoIt.methode.sleep(INTERVAL);
		if (AutoIt.methode.winExists(windowTitle)) {
			AutoIt.methode.sleep(INTERVAL);
		SelectImageLocal.cancelSelectBtn();
		ArticlePreparation.searchQuery();
		NewSearchQuery.getQueryImage(Storyname);
		//ArticlePreparation.closeQuickAccessBar();
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		/*AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1561, 0, Mouse.DOUBLE_CLICK, 1000);
		AutoIt.methode.sleep(INTERVAL);*/
		//Normal machine
		//AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1700, 216,400 ,900,1000);
		//laptop machine
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1700, 298,400 ,900,1000);
		AutoIt.methode.sleep(3000);
		AutoIt.methode.sleep(INTERVAL);
		}
		else{
			AutoIt.methode.winActivate(window.getTitle());
			ArticlePreparation.getQuickAccessBar();
		}
	}
	
	public static void getInlineImage() throws Exception{
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property closeSearchQueryProperty = window.getPropertyByName(SEARCH_QUERY_CLOSE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		/*AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1561, 0, Mouse.DOUBLE_CLICK, 1000);
		AutoIt.methode.sleep(INTERVAL);*/
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1700, 298, 200, 600, 2000);
		AutoIt.methode.sleep(INTERVAL);
		/*AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1900, 232, Mouse.SINGLE_CLICK, 2000);
		AutoIt.methode.sleep(INTERVAL);*/
	}
	
	public static void getImage() throws Exception{
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property closeSearchQueryProperty = window.getPropertyByName(SEARCH_QUERY_CLOSE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		/*AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1561, 0, Mouse.DOUBLE_CLICK, 1000);
		AutoIt.methode.sleep(INTERVAL);*/
		//Normal machine
		//AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1700, 216,400 ,900,1000);
		//laptop machine
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1700, 298,400 ,900,1000);
		AutoIt.methode.sleep(3000);
		//***Allen*****AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1900, 232, Mouse.SINGLE_CLICK, 1000);
		AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1890, 229, Mouse.SINGLE_CLICK, 1000);
		AutoIt.methode.sleep(3000);
		//AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1904, 160, Mouse.SINGLE_CLICK, 1000);
		//AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void clickOnAllAssets() throws Exception{
		Window window = getWindowProperty(MAIN);
		Property clickOnAllAssetsProperty = window.getPropertyByName(CLICK_ON_ALL_ASSETS);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickOnAllAssetsProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickOnAllAssetsProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, clickOnAllAssetsProperty.getX(), clickOnAllAssetsProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		
	}
	
	public static void chpStories() throws Exception{
		Window window = getWindowProperty(MAIN);
		Property chpStoriesProperty = window.getPropertyByName(CHP_WINDOW_STORY);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, chpStoriesProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, chpStoriesProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, chpStoriesProperty.getX(), chpStoriesProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void chpPictures() throws Exception{
		Window window = getWindowProperty(MAIN);
		Property chpPicturesProperty = window.getPropertyByName(CHP_WINDOW_PICTURES);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, chpPicturesProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, chpPicturesProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, chpPicturesProperty.getX(), chpPicturesProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void textToSearch(String textSearch) throws Exception{
		Window window = getWindowProperty(MAIN);
		Property textToSearchProperty = window.getPropertyByName(CHP_SEARCH_TEXT_AREA);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, textToSearchProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, textToSearchProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, textToSearchProperty.getX(), textToSearchProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, textToSearchProperty.getId());
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE,  textSearch);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void clickOnSearchIcon() throws Exception{
		Window window = getWindowProperty(MAIN);
		Property clickOnSearchIconProperty = window.getPropertyByName(SEARCH_CLICK_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickOnSearchIconProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickOnSearchIconProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, clickOnSearchIconProperty.getX(), clickOnSearchIconProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void closeChp() throws Exception{
		Window window = getWindowProperty(MAIN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1906, 82, Mouse.SINGLE_CLICK, 1000);
	}
	
	public static void addImageCandidateBrowser(int down) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property addImageProperty = window.getPropertyByName(CLICKING_ON_IMAGE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, addImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, addImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, addImageProperty.getX(), addImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE,Mouse.getDown(6));
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE,  Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		Window childWindow = getWindowProperty(SELECT_IMAGE);
		String windowTitle = childWindow.getTitle();
		AutoIt.methode.sleep(INTERVAL);
		if (AutoIt.methode.winExists(windowTitle)) {
			AutoIt.methode.sleep(INTERVAL);
		SelectImageLocal.cancelSelectBtn();
		ArticlePreparation.candidateBrowser();
		ArticlePreparation.candidateBrowserImage(down);
		ArticlePreparation.candidateBrowserImage1();
		}
		else{
			AutoIt.methode.winActivate(window.getTitle());
		}
	}
	public static void getInlineArtilce() throws Exception{
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property closeSearchQueryProperty = window.getPropertyByName(SEARCH_QUERY_CLOSE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		/*AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1561, 0, Mouse.DOUBLE_CLICK, 1000);
		AutoIt.methode.sleep(INTERVAL);*/
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1700, 545, 240, 745, 2000);
		AutoIt.methode.sleep(INTERVAL);
		/*AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1900, 232, Mouse.SINGLE_CLICK, 2000);
		AutoIt.methode.sleep(INTERVAL);*/
	}
	
}
