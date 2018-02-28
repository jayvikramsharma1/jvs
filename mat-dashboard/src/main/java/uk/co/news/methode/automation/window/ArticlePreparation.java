package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Default;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.UUID;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.S3Uploader;
import uk.co.news.methode.automation.utils.Screenshot;
import uk.co.news.methode.automation.utils.WatchDog;

/**
 * This class has written for the actions being performed at Story Preparation
 * Page
 * 
 * @author sallen
 *
 */
public class ArticlePreparation extends BaseWindow {
	/**
	 * This function will prepare the article Description
	 * 
	 * @param direction
	 *            Scrolling up or down(direction) to get the position of text
	 *            area
	 * @param heelcount
	 *            No. of scroll to get the position of text area
	 * @param articleText
	 *            Article description are being typed here
	 * @throws Exception
	 *             When the properties are not found this respective function,
	 *             It throws Exception
	 */
	public static void articleDescription(String direction, int wheelcount, String articleText) throws Exception {
		mousewheeler(direction, wheelcount);
		articleText(articleText);
	}

	/**
	 * This function will add an image to the Inline
	 * 
	 * @param direction
	 *            Scrolling up or down(direction) to get the position of text
	 *            area
	 * @param wheelcount
	 *            No. of scroll to get the position of text area
	 * @param articleText
	 *            Article description are being typed here
	 * @param down
	 *            To get the candidate browser Image field
	 * @throws Exception
	 *             When the properties are not found this respective function,
	 *             It throws Exception
	 */

	public static void inlineImage(String direction, int wheelcount, String articleText, int down) throws Exception {
		mousewheeler(direction, wheelcount);
		articleText(articleText);
		candidateBrowser();
		candidateBrowserImage(down);
		candidateBrowserImage1();
	}

	public static void quickAccess(String Storyname) throws Exception {
		searchQuery();
		NewSearchQuery.getQueryImage(Storyname);
	}

	public static void searchQuery() throws Exception {
		getQuickAccessBar();
		clickOnSearchIcon();
	}

	public static void openCandidateBrowser(int down) throws Exception {
		candidateBrowser();
		candidateBrowserImage(down);
	}

	/**
	 * This function will prepare the inline Story
	 * 
	 * @param direction
	 *            Scrolling up or down(direction) to get the position of text
	 *            area
	 * @param wheelcount
	 *            No. of scroll to get the position of text area
	 * @param headline
	 *            This is to add the Headline text in the article
	 * @param standfirst
	 *            This is to add the Standfirst text in the article
	 * @param onecolumnStandfirst
	 *            This is to add the onecolumnStandfirst text in the article
	 * @param floorlineHeadline
	 *            This is to add the floorlineHeadline text in the article
	 * @throws Exception
	 *             When the properties are not found this respective function,
	 *             It throws Exception
	 */

	public static void inlineStoryPreparation(String direction, int wheelcount, String headline) throws Exception {
		mousewheeler(direction, wheelcount);
		titleHeadline(headline);
	}

	/**
	 * This function will save the article Preparation page and close it
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function,
	 *             It throws Exception
	 */
	public static void saveAndCloseStoryPreparation() throws Exception {
		articleUUIDBtn();
		closeArticlePreparation();
	}

	public static void gettingImageUUID() throws Exception {
		publishArticle();
		imageUUIDBtn();
		closeArticlePreparation();
	}

	/**
	 * This function will insert the pull quote in story preparation page
	 * 
	 * @param direction
	 *            Scrolling up or down(direction) to get the position of pull
	 *            quote area
	 * @param wheelcount
	 *            No. of scroll to get the position of pull quote area
	 * @param pullQuoteText
	 *            This is the position, where we insert the pull quote text
	 * @throws Exception
	 *             When the properties are not found this respective function,
	 *             It throws Exception
	 */

	public static void insertPullQuote(String direction, int wheelcount, String pullQuoteText,String testName, String stepName) throws Exception {
		mousewheeler(direction, wheelcount);
		componentLibrary();
		pullQuote();
		pullQuoteSelect();
		getPullQuote();
		textPullQuote(pullQuoteText);
		pullquotesMandatory(testName, stepName);
	}

	/**
	 * This function is for preparing the normal story and to publish it
	 * 
	 * @param direction
	 *            Scrolling up or down(direction) to get the position of pull
	 *            quote area
	 * @param wheelcount
	 *            No. of scroll to get the position of pull quote area
	 * @param headline
	 *            This is to add the Headline text in the article
	 * @param standfirst
	 *            This is to add the standfirst text in the article
	 * @param onecolumnStandfirst
	 *            This is to add the onecolumnStandfirst text in the article
	 * @param floorlineHeadline
	 *            This is to add the floorlineHeadline text in the article
	 * @param down
	 *            To get the candidate browser Image field
	 * @throws Exception
	 *             When the properties are not found this respective function,
	 *             It throws Exception
	 */

	public static void storyPreparation(String direction, int wheelcount, String headline, int down) throws Exception {
		mousewheeler(direction, wheelcount);
		titleHeadline(headline);
		candidateBrowser();
		candidateBrowserImage(down);
	}

	public static void storyPreparationCHP(String standfirst, String onecolumnStandfirst, String floorlineHeadline)
			throws Exception {
		standfirst(standfirst);
		onecolumnStandfirst(onecolumnStandfirst);
		floorlineHeadline(floorlineHeadline);
	}
	/* getImage(imagePosition); */

	public static void articlePublish() throws Exception {
		publishArticle();
		articleUUIDBtn();
		closeArticlePreparation();
	}

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
		Property articleHeadlineProperty = window.getPropertyByName(ARTICLE_HEADLINE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, articleHeadlineProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, articleHeadlineProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.TRIPLE_CLICK, articleHeadlineProperty.getX(), articleHeadlineProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, headline, true);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function is to write the Standfirst of an article
	 * 
	 * @param standfirst
	 *            standfirst text for an article
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void standfirst(String standfirst) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property articleStandfirstProperty = window.getPropertyByName(ARTICLE_STANDFIRST);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, articleStandfirstProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, articleStandfirstProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.TRIPLE_CLICK, articleStandfirstProperty.getX(), articleStandfirstProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, standfirst, true);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function is to write the overrideHeadline of an article
	 * 
	 * @param overrideHeadline
	 *            overrideHeadline text for an article
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void overrideHeadline(String overrideHeadline) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property articleOverrideHeadlineProperty = window.getPropertyByName(ARTICLE_OVERRIDE_HEADLINE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, articleOverrideHeadlineProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, articleOverrideHeadlineProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.TRIPLE_CLICK, articleOverrideHeadlineProperty.getX(), articleOverrideHeadlineProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, overrideHeadline, true);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function is to write the overrideStandfirst of an article
	 * 
	 * @param overrideStandfirst
	 *            overrideStandfirst text for an article
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void overrideStandfirst(String overrideStandfirst) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property articleOverrideStandfirstProperty = window.getPropertyByName(ARTICLE_OVERRIDE_STANDFIRST);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, articleOverrideStandfirstProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, articleOverrideStandfirstProperty.getId(),
				Mouse.LEFT_CLICK, Mouse.TRIPLE_CLICK, articleOverrideStandfirstProperty.getX(),
				articleOverrideStandfirstProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, overrideStandfirst, true);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function is to write the onecolumnStandfirst of an article
	 * 
	 * @param onecolumnStandfirst
	 *            onecolumnStandfirst text for an article
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void onecolumnStandfirst(String onecolumnStandfirst) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property articleOnecolumnStandfirstProperty = window.getPropertyByName(ONECOLUMN_STANDFIRST);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, articleOnecolumnStandfirstProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, articleOnecolumnStandfirstProperty.getId(),
				Mouse.LEFT_CLICK, Mouse.TRIPLE_CLICK, articleOnecolumnStandfirstProperty.getX(),
				articleOnecolumnStandfirstProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, onecolumnStandfirst, false);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function is to write the floorlineHeadline of an article
	 * 
	 * @param floorlineHeadline
	 *            floorlineHeadline text for an article
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void floorlineHeadline(String floorlineHeadline) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property articleFloorlineHeadlinetProperty = window.getPropertyByName(FLOORLINE_HEADLINE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, articleFloorlineHeadlinetProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, articleFloorlineHeadlinetProperty.getId(),
				Mouse.LEFT_CLICK, Mouse.TRIPLE_CLICK, articleFloorlineHeadlinetProperty.getX(),
				articleFloorlineHeadlinetProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, floorlineHeadline, true);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void floorlineCopy(String floorlineCopy) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property floorLineCopyProperty = window.getPropertyByName(FLOORLINE_COPY);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, floorLineCopyProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, floorLineCopyProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.TRIPLE_CLICK, floorLineCopyProperty.getX(), floorLineCopyProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, floorlineCopy, true);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function is for wheeling the mouse, Count of scroll and its
	 * direction(Up or Down)
	 * 
	 * @param direction
	 *            Scrolling up or down(direction) to get the position of pull
	 *            quote area
	 * @param wheelCount
	 *            No. of scroll to get the position of pull quote area
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void mousewheeler(String direction, int wheelCount) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property articleHeadlineProperty = window.getPropertyByName(ARTICLE_HEADLINE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, articleHeadlineProperty.getId());
		AutoIt.methode.mouseWheel(direction, wheelCount);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function is for typing the article content in the text area
	 * 
	 * @param articleText
	 *            Article description are being typed here
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void articleText(String articleText) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property articleTextProperty = window.getPropertyByName(ARTICLE_TEXT);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, articleTextProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, articleTextProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, articleTextProperty.getX(), articleTextProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, articleText, true);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function is to launch Candidate Browser
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void candidateBrowser() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property candidateBrowserProperty = window.getMenu(DWP_VIEW);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		// AutoIt.methode.controlFocus(window.getTitle(), NONE,
		// candidateBrowserProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, candidateBrowserProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, candidateBrowserProperty.getX(), candidateBrowserProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(1));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function is to get the Quick Metadata
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

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

	/**
	 * This function is to close the Article preparation Window
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void closeArticlePreparation() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property saveArticleWindowProperty = window.getMenu(DWP_FILE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		// AutoIt.methode.controlFocus(window.getTitle(), NONE,
		// saveArticleWindowProperty.getId());
		/*
		 * AutoIt.methode.controlClick(window.getTitle(), NONE,
		 * saveArticleWindowProperty.getId(), Mouse.LEFT_CLICK,
		 * Mouse.SINGLE_CLICK, saveArticleWindowProperty.getX(),
		 * saveArticleWindowProperty.getY()); AutoIt.methode.sleep(INTERVAL);
		 * AutoIt.methode.controlSend(window.getTitle(), NONE, NONE,
		 * Mouse.getDown(6)); AutoIt.methode.sleep(INTERVAL);
		 * AutoIt.methode.controlSend(window.getTitle(), NONE, NONE,
		 * Mouse.ENTER); AutoIt.methode.sleep(INTERVAL);
		 */
		AutoIt.methode.winClose(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		/*
		 * window = getWindowProperty(DWP_PAGE); WatchDog.wait(window);
		 * Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()),
		 * true); AutoIt.methode.sleep(INTERVAL);
		 */
		Window methodeWindow = getWindowProperty(CONFIRMATION);
		String windowTitle = methodeWindow.getTitle();
		AutoIt.methode.sleep(INTERVAL);
		if (AutoIt.methode.winExists(windowTitle)) {
			AutoIt.methode.sleep(INTERVAL);
			Confirmation.yesBtn();
			AutoIt.methode.sleep(INTERVAL);
			window = getWindowProperty(DWP_PAGE);
			WatchDog.wait(window);
			Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
			AutoIt.methode.sleep(INTERVAL);
		} else {
			window = getWindowProperty(DWP_PAGE);
			WatchDog.wait(window);
			Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
			AutoIt.methode.sleep(INTERVAL);

		}
	}

	/**
	 * This function is to publish the article
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void publishArticle() throws Exception {
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
		Property articlePublishBtnProperty = window.getPropertyByName(ARTICLE_PUBLISH_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, articlePublishBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, articlePublishBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, articlePublishBtnProperty.getX(), articlePublishBtnProperty.getY());
		AutoIt.methode.sleep(5000);
	}

	public static void saveArticle() throws Exception {
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
	}

	/**
	 * This function is to get the article UUID
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void articleUUIDBtn() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property articleChpClipbaordBtnProperty = window.getPropertyByName(ARTICLE_CHP_UUID);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, articleChpClipbaordBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, articleChpClipbaordBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, articleChpClipbaordBtnProperty.getX(), articleChpClipbaordBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		String uuid = AutoIt.methode.clipGet();
		System.out.println(uuid);
		AutoIt.methode.sleep(INTERVAL);
		UUID.setArticleUUID(uuid.trim());
		AutoIt.methode.sleep(INTERVAL);
		// setUuid(uuid);
	}

	/**
	 * This function is to get the Candidate Browser Image field
	 * 
	 * @param down
	 *            To get the candidate browser Image field
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void candidateBrowserImage(int down) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property candidateBrowserImage = window.getPropertyByName(CANDIDATE_BROWSER_IMAGE);
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
		/*
		 * AutoIt.methode.controlSend(window.getTitle(), NONE, NONE,
		 * Mouse.getDown(1)); AutoIt.methode.sleep(INTERVAL);
		 */
	}

	public static void candidateBrowserImage1() throws Exception {
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1715, 370, 415, 745, 2000);
		AutoIt.methode.sleep(3000);
	}

	/**
	 * This function is to get the first image in Candidate Browser
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void candidateBrowserImage2() throws Exception {
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1715, 600, 415, 745, 2000);
		AutoIt.methode.sleep(3000);
	}

	/**
	 * This function is to get the second image in Candidate Browser
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void candidateBrowserImage3() throws Exception {
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1715, 880, 415, 745, 2000);
		AutoIt.methode.sleep(3000);
	}

	/**
	 * This function will add the image from candidate browser to the floorline
	 * 
	 * @param down
	 *            To get the candidate browser Image field
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void candidateBrowserImageFloorLine(int down) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property candidateBrowserImage = window.getPropertyByName(CANDIDATE_BROWSER_IMAGE);
		Default articleImageProperty = getDefaultPropertyByName(DEFAULT_ARTICLE_MAIN_IMAGE);
		// Default candidateImageProperty =
		// getDefaultPropertyByName(imagePosition);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, candidateBrowserImage.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(1));
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will get the image position either first or second
	 * 
	 * @param imagePosition
	 *            Points to the position of the image in candidate browser
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void getImage(String imagePosition) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property imageProperty = window.getPropertyByName(CANDIDATE_IMAGE);
		Default articleImageProperty = getDefaultPropertyByName(DEFAULT_ARTICLE_MAIN_IMAGE);
		Default candidateImageProperty = getDefaultPropertyByName(imagePosition);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, imageProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, candidateImageProperty.getX(), candidateImageProperty.getY(),
				articleImageProperty.getX(), articleImageProperty.getY(), INTERVAL);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will get the component Library in story preparation Page
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void componentLibrary() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property candidateBrowserProperty = window.getMenu(DWP_VIEW);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		// AutoIt.methode.controlFocus(window.getTitle(), NONE,
		// candidateBrowserProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, candidateBrowserProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, candidateBrowserProperty.getX(), candidateBrowserProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(3));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will just clicking on the pull quote area
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void pullQuote() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property pullQuoteProperty = window.getPropertyByName(PULL_QUOTES);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, pullQuoteProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, pullQuoteProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, pullQuoteProperty.getX(), pullQuoteProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will select the pullquote in the field area of Component
	 * Library
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void pullQuoteSelect() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property pullQuoteSelectProperty = window.getPropertyByName(PULL_QUOTE_TABLET_SELECT);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, pullQuoteSelectProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, pullQuoteSelectProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, pullQuoteSelectProperty.getX(), pullQuoteSelectProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(3));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will get the pull quote from component Library and drops
	 * into the pull quote text area
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void getPullQuote() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property getPullQuoteSelectProperty = window.getPropertyByName(PULL_QUOTE_SELECT);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, getPullQuoteSelectProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, getPullQuoteSelectProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, getPullQuoteSelectProperty.getX(), getPullQuoteSelectProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1665, 288, 157, 740, INTERVAL);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will put the pull quote text in the pullquote area
	 * 
	 * @param pullQuoteText
	 *            This is to quote(pull quote text) as per user's requirement
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void textPullQuote(String pullQuoteText) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property PullQuoteLineProperty = window.getPropertyByName(PULL_QUOTE_LINE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, PullQuoteLineProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, PullQuoteLineProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, PullQuoteLineProperty.getX(), PullQuoteLineProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, pullQuoteText, true);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void pullquotesMandatory(String testName, String stepName) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property PullQuoteLineProperty = window.getPropertyByName(PULL_QUOTE_LINE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, PullQuoteLineProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, PullQuoteLineProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, PullQuoteLineProperty.getX(), PullQuoteLineProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(17));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void capture(String testName, String stepName) throws Exception {
	captureScreen(testName, stepName);
	AutoIt.methode.sleep(INTERVAL);
	}
	/**
	 * This function will do right click on the main Image
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void clickingOnImage(String testName, String stepName) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnImageProperty = window.getPropertyByName(CLICKING_ON_IMAGE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickingOnImageProperty.getX(), clickingOnImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(17));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void clickoninlineimage(String testName, String stepName) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnImageProperty = window.getPropertyByName(CLICKING_ON_INLINE_IMAGE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickingOnImageProperty.getX(), clickingOnImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(17));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will get in to the image positional settings
	 * 
	 * @param down
	 *            This down is to get the options in the positionals
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void clickingOnImagePositionals(int down) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnImageProperty = window.getPropertyByName(CLICKING_ON_IMAGE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickingOnImageProperty.getX(), clickingOnImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
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

	/**
	 * This function is to right click on inline image
	 * 
	 * @param direction
	 *            Scrolling up or down(direction) to get the position of text
	 *            area
	 * @param wheelcount
	 *            No. of scroll to get the position of text area
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void clickOnInlineImage(String direction, int wheelcount, String testName, String stepName)
			throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnInlineImageProperty = window.getPropertyByName(CLICKING_ON_INLINE_IMAGE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseWheel(direction, wheelcount);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnInlineImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnInlineImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickingOnInlineImageProperty.getX(), clickingOnInlineImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(17));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void clickOnInlineImagePotrait(String direction, int wheelcount, String testName, String stepName)
			throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnInlineImageProperty = window.getPropertyByName(CLICKING_ON_INLINE_IMAGE_POTRAIT);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseWheel(direction, wheelcount);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnInlineImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnInlineImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickingOnInlineImageProperty.getX(), clickingOnInlineImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(17));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will click on the option of disable saving article in the
	 * metadata
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void disableSavingArticle() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property disableSavingArticleProperty = window.getPropertyByName(DISABLE_SAVING_ARTICLE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, disableSavingArticleProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, disableSavingArticleProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, disableSavingArticleProperty.getX(), disableSavingArticleProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will do right click on the headline
	 * 
	 * @throws Exception
	 *             When the properties are not found this respective function,It
	 *             throws Exception
	 */

	public static void clickOnTitleHeadline(String testName, String stepName) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property articleHeadlineProperty = window.getPropertyByName(ARTICLE_HEADLINE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, articleHeadlineProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, articleHeadlineProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, articleHeadlineProperty.getX(), articleHeadlineProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(14));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		window = getWindowProperty(FORMATTING_HEADLINE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function is to get the Quick Access tool bar
	 * 
	 * @throws Exception
	 *             Property not found throws Exception
	 */
	public static void getQuickAccessBar() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property getQuickAccessBarProperty = window.getPropertyByName(GET_QUICK_ACCESS_BAR);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, getQuickAccessBarProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, getQuickAccessBarProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, getQuickAccessBarProperty.getX(), getQuickAccessBarProperty.getY());
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(5));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void closeQuickAccessBar() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property closeQuickAccessBarProperty = window.getPropertyByName(GET_QUICK_ACCESS_BAR);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, closeQuickAccessBarProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, closeQuickAccessBarProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, closeQuickAccessBarProperty.getX(), closeQuickAccessBarProperty.getY());
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(5));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void clickOnSearchIcon() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickOnSearchIconProperty = window.getPropertyByName(CLICK_ON_SEARCH_ICON);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickOnSearchIconProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickOnSearchIconProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, clickOnSearchIconProperty.getX(), clickOnSearchIconProperty.getY());
		window = getWindowProperty(METHODE_SEARCH_QUERY);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void dragAndDropVideoStory() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1370, 257, 160, 595, INTERVAL);
		AutoIt.methode.sleep(INTERVAL);

	}

	public static void imageUUIDBtn() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnImageProperty = window.getPropertyByName(CLICKING_ON_IMAGE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickingOnImageProperty.getX(), clickingOnImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(19));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		String uuid = AutoIt.methode.clipGet();
		AutoIt.methode.sleep(INTERVAL);
		System.out.print(uuid);
		UUID.setImageUUID(uuid.trim());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void inlineImageUUID() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnInlineImageProperty = window.getPropertyByName(CLICKING_ON_INLINE_IMAGE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnInlineImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnInlineImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickingOnInlineImageProperty.getX(), clickingOnInlineImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(19));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		String uuid = AutoIt.methode.clipGet();
		AutoIt.methode.sleep(5000);
		System.out.print("Image:" + uuid);
		UUID.setImageUUID(uuid.trim());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void inlineImageUUID2() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnInlineImageProperty = window.getPropertyByName(CLICKING_ON_INLINE_IMAGE_2);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnInlineImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnInlineImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickingOnInlineImageProperty.getX(), clickingOnInlineImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(20));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		String uuid = AutoIt.methode.clipGet();
		AutoIt.methode.sleep(INTERVAL);
		System.out.print(uuid);
		UUID.setImageUUID(uuid.trim());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void inlineImageUUID3() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnInlineImageProperty = window.getPropertyByName(CLICKING_ON_INLINE_IMAGE_3);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnInlineImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnInlineImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickingOnInlineImageProperty.getX(), clickingOnInlineImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(20));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		String uuid = AutoIt.methode.clipGet();
		AutoIt.methode.sleep(INTERVAL);
		System.out.print(uuid);
		UUID.setImageUUID(uuid.trim());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void inlineImagePotraitUUID() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnInlineImagePotraitProperty = window.getPropertyByName(CLICKING_ON_INLINE_IMAGE_POTRAIT);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnInlineImagePotraitProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnInlineImagePotraitProperty.getId(),
				Mouse.RIGHT_CLICK, Mouse.SINGLE_CLICK, clickingOnInlineImagePotraitProperty.getX(),
				clickingOnInlineImagePotraitProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(19));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		String uuid = AutoIt.methode.clipGet();
		AutoIt.methode.sleep(INTERVAL);
		System.out.print(uuid);
		UUID.setImageUUID(uuid.trim());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void searchQueryWindowOkBtn() throws Exception {
		Window window = getWindowProperty(METHODE_SEARCH_QUERY);
		Property okBtnProperty = window.getPropertyByName(OK_BTN);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		/*
		 * AutoIt.methode.controlFocus(window.getTitle(), NONE,
		 * okBtnProperty.getId()); AutoIt.methode.sleep(INTERVAL);
		 * AutoIt.methode.controlClick(window.getTitle(), NONE,
		 * okBtnProperty.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK,
		 * okBtnProperty.getX(), okBtnProperty.getY());
		 */
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(6));
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		System.out.println(window.getTitle());
		window = getWindowProperty(STORY_PREPARATION_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void addingDeeplink() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property addingDeeplinkProperty = window.getPropertyByName(ADD_FRACTIONAL_DEEPLINK);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, addingDeeplinkProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, addingDeeplinkProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, addingDeeplinkProperty.getX(), addingDeeplinkProperty.getY());
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(5));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(HYPER_LINK);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void dragStory1() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1370, 257, 300, 500, INTERVAL);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void setFont(int down, String articleText) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property articleTextProperty = window.getPropertyByName(ARTICLE_TEXT);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, articleTextProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, articleTextProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, articleTextProperty.getX(), articleTextProperty.getY());
		AutoIt.methode.mouseClick(NONE, 429, 176, Mouse.SINGLE_CLICK, 2000);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClick(NONE, 147, 600, Mouse.SINGLE_CLICK, 2000);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.BACK_SPACE);
		/*
		 * AutoIt.methode.controlFocus(window.getTitle(), NONE,
		 * articleTextProperty.getId());
		 * AutoIt.methode.controlClick(window.getTitle(), NONE,
		 * articleTextProperty.getId(), Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK,
		 * articleTextProperty.getX(), articleTextProperty.getY());
		 */
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, articleText, true);
		AutoIt.methode.sleep(INTERVAL);

		// AutoIt.methode.sleep(INTERVAL);
		// AutoIt.methode.controlFocus(window.getTitle(), NONE,
		// setFontProperty.getId());
		// AutoIt.methode.controlClick(window.getTitle(), NONE,
		// setFontProperty.getId(), Mouse.LEFT_CLICK,
		// Mouse.SINGLE_CLICK, setFontProperty.getX(), setFontProperty.getY());
		/*
		 * AutoIt.methode.mouseClick(NONE, 405, 150, Mouse.SINGLE_CLICK, 2000);
		 * AutoIt.methode.controlSend(window.getTitle(), NONE, NONE,
		 * Mouse.getDown(down)); AutoIt.methode.controlSend(window.getTitle(),
		 * NONE, NONE, Mouse.ENTER); AutoIt.methode.sleep(INTERVAL);
		 */
		/*
		 * AutoIt.methode.controlSend(window.getTitle(), NONE, NONE,
		 * Mouse.ENTER); AutoIt.methode.sleep(INTERVAL);
		 */
	}

	public static void clickOnInsertInline01() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickOnInsertInline01Property = window.getPropertyByName(RIGHT_CLICK_INLINE_01);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickOnInsertInline01Property.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickOnInsertInline01Property.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickOnInsertInline01Property.getX(), clickOnInsertInline01Property.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(5));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		window = getWindowProperty(HYPER_LINK);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void clickOnInsertInline02() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickOnInsertInline02Property = window.getPropertyByName(RIGHT_CLICK_INLINE_02);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickOnInsertInline02Property.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickOnInsertInline02Property.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickOnInsertInline02Property.getX(), clickOnInsertInline02Property.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(5));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		window = getWindowProperty(HYPER_LINK);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void horizontalAlignment(int down, String testName, String stepName ) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnInlineImageProperty = window.getPropertyByName(CLICKING_ON_INLINE_IMAGE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnInlineImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnInlineImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickingOnInlineImageProperty.getX(), clickingOnInlineImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(14));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void captureHorizontalAlignmentChange(String testName, String stepName ) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnInlineImageProperty = window.getPropertyByName(CLICKING_ON_INLINE_IMAGE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnInlineImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnInlineImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickingOnInlineImageProperty.getX(), clickingOnInlineImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(14));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void horizontalAlignment2(int down) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnInlineImageProperty = window.getPropertyByName(CLICKING_ON_INLINE_IMAGE_2);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnInlineImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnInlineImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickingOnInlineImageProperty.getX(), clickingOnInlineImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(14));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void horizontalAlignment3(int down) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnInlineImageProperty = window.getPropertyByName(CLICKING_ON_INLINE_IMAGE_3);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnInlineImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnInlineImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickingOnInlineImageProperty.getX(), clickingOnInlineImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(14));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void horizontalAlignmentpotrait(int down) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnInlineImagePotraitProperty = window.getPropertyByName(CLICKING_ON_INLINE_IMAGE_POTRAIT);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnInlineImagePotraitProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnInlineImagePotraitProperty.getId(),
				Mouse.RIGHT_CLICK, Mouse.SINGLE_CLICK, clickingOnInlineImagePotraitProperty.getX(),
				clickingOnInlineImagePotraitProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(14));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void getvideo() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property closeSearchQueryProperty = window.getPropertyByName(SEARCH_QUERY_CLOSE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		/*
		 * AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1561, 0,
		 * Mouse.DOUBLE_CLICK, 1000); AutoIt.methode.sleep(INTERVAL);
		 */
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1700, 298, 160, 625, 1000);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1900, 232, Mouse.SINGLE_CLICK, 1000);
		AutoIt.methode.sleep(INTERVAL);
		// AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1904, 160,
		// Mouse.SINGLE_CLICK, 1000);
		// AutoIt.methode.sleep(INTERVAL);
	}

	public static void getadditionalImage() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property closeSearchQueryProperty = window.getPropertyByName(SEARCH_QUERY_CLOSE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		/*
		 * AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1561, 0,
		 * Mouse.DOUBLE_CLICK, 1000); AutoIt.methode.sleep(INTERVAL);
		 */
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1715, 600, 160, 645, 1000);
		AutoIt.methode.sleep(INTERVAL);
		// AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1904, 160,
		// Mouse.SINGLE_CLICK, 1000);
		// AutoIt.methode.sleep(INTERVAL);
	}

	public static void tabletAllField(String testName, String stepName) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property tabletAllFeildProperty = window.getPropertyByName(TABLET_ALL_FEILD);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 201, 178, Mouse.SINGLE_CLICK, 1000);
		/*
		 * AutoIt.methode.controlFocus(window.getTitle(), NONE,
		 * tabletAllFeildProperty.getId());
		 * AutoIt.methode.controlClick(window.getTitle(), NONE,
		 * tabletAllFeildProperty.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK,
		 * tabletAllFeildProperty.getX(), tabletAllFeildProperty.getY());
		 */
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(1));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 201, 178, Mouse.SINGLE_CLICK, 1000);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getUp(1));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void tabletFloorLineCopy(String floorlineCopy, String testName, String stepName) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property tabletAllFeildProperty = window.getPropertyByName(TABLET_ALL_FEILD);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 201, 178, Mouse.SINGLE_CLICK, 1000);
		/*
		 * AutoIt.methode.controlFocus(window.getTitle(), NONE,
		 * tabletAllFeildProperty.getId());
		 * AutoIt.methode.controlClick(window.getTitle(), NONE,
		 * tabletAllFeildProperty.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK,
		 * tabletAllFeildProperty.getX(), tabletAllFeildProperty.getY());
		 */
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(1));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		floorlineCopy(floorlineCopy);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 201, 178, Mouse.SINGLE_CLICK, 1000);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getUp(1));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void screenCapture(String testName, String stepName) throws Exception {
		captureScreen(testName, stepName);
	}

	/*
	 * public static void getImagePotrait() throws Exception{ Window window =
	 * getWindowProperty(STORY_PREPARATION_PAGE);
	 * AutoIt.methode.sleep(INTERVAL);
	 * AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1719, 260,400 ,900,1000);
	 * AutoIt.methode.sleep(INTERVAL); }
	 */

	public static void columwidth(int down, String testName, String stepName) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnImageProperty = window.getPropertyByName(CLICKING_ON_IMAGE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickingOnImageProperty.getX(), clickingOnImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(13));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void captureColumnWidthChange(String testName, String stepName ) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnInlineImageProperty = window.getPropertyByName(CLICKING_ON_IMAGE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnInlineImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnInlineImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickingOnInlineImageProperty.getX(), clickingOnInlineImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(13));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}


	public static void verticalAllignment(int down, String testName, String stepName) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnImageProperty = window.getPropertyByName(CLICKING_ON_IMAGE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickingOnImageProperty.getX(), clickingOnImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(15));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}
	public static void captureVerticalAlignmentChange(String testName, String stepName ) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnInlineImageProperty = window.getPropertyByName(CLICKING_ON_IMAGE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnInlineImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnInlineImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickingOnInlineImageProperty.getX(), clickingOnInlineImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(15));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void positionalpage(int down, String testName, String stepName) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnImageProperty = window.getPropertyByName(CLICKING_ON_IMAGE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickingOnImageProperty.getX(), clickingOnImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(16));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void capturepositionalpageChange(String testName, String stepName ) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnInlineImageProperty = window.getPropertyByName(CLICKING_ON_IMAGE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnInlineImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnInlineImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickingOnInlineImageProperty.getX(), clickingOnInlineImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(16));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void cropMainImage(String direction, int wheelcount, String testName, String stepName)
			throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnImageProperty = window.getPropertyByName(CLICKING_ON_IMAGE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnImageProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, clickingOnImageProperty.getX(), clickingOnImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		mousewheeler(direction, wheelcount);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnImageProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, clickingOnImageProperty.getX(), clickingOnImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void addcarosual1(String Storyname) throws Exception {
		searchQuery();
		NewSearchQuery.getQueryImage(Storyname);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1717, 300, 200, 675, 2000);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void addcarosual2(String Storyname) throws Exception {
		searchQuery();
		NewSearchQuery.getQueryImage(Storyname);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1717, 300, 200, 795, 2000);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void addcarosualchange1(String testName, String stepName) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnImageProperty = window.getPropertyByName(CLICKING_ON_INLINE_IMAGE_2);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickingOnImageProperty.getX(), clickingOnImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(18));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void addcarosualchange2(String testName, String stepName) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property clickingOnImageProperty = window.getPropertyByName(CLICKING_ON_INLINE_IMAGE_3);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickingOnImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickingOnImageProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, clickingOnImageProperty.getX(), clickingOnImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(18));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		window = getWindowProperty(ARTICLE_IMAGE_METADATA);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void addRelatedLink() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property add_Related_linkProperty = window.getPropertyByName(RELATED_LINKS);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, add_Related_linkProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, add_Related_linkProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, add_Related_linkProperty.getX(), add_Related_linkProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void insertRelatedLink() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property insert_Related_linkProperty = window.getPropertyByName(INSERT_RELATED_LINK);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, insert_Related_linkProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, insert_Related_linkProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, insert_Related_linkProperty.getX(), insert_Related_linkProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(5));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(HYPER_LINK);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

}
