package uk.co.news.methode.automation.window;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;


public class QuickMetadataTablet extends BaseWindow {
	
	public static void selectingTablet() throws Exception{
		Window window = getWindowProperty(QUICK_METADATA);
		Property selectingTabletProperty = window.getPropertyByName(SELECTING_TABLET);
		//AutoIt.methode.winActivate(window.getTitle());
		//AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, selectingTabletProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlClick(window.getTitle(), NONE, selectingTabletProperty.getId(), Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, selectingTabletProperty.getX(), selectingTabletProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void hideHeadline(String testName, String stepName) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property hideHeadlineProperty = window.getPropertyByName(HIDE_HEADLINE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(5000);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, hideHeadlineProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, hideHeadlineProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, hideHeadlineProperty.getX(), hideHeadlineProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void twoColumnImage() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property twoColumnImageProperty = window.getPropertyByName(TWO_COLUMN_IMAGE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, twoColumnImageProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, twoColumnImageProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, twoColumnImageProperty.getX(), twoColumnImageProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void fullBleed() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property fullBleedProperty = window.getPropertyByName(FULL_BLEED);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, fullBleedProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, fullBleedProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, fullBleedProperty.getX(), fullBleedProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void disableCopyFit() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property disableCopyFitProperty = window.getPropertyByName(DISABLE_COPY_FIT);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, disableCopyFitProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, disableCopyFitProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, disableCopyFitProperty.getX(), disableCopyFitProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void headlineSpanDropDownnumber(int up, String testName, String stepName) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property headlineSpanDropDownnumberProperty = window.getPropertyByName(HEADLINE_SPAN_DROPDOWN_NUMBER);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, headlineSpanDropDownnumberProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, headlineSpanDropDownnumberProperty.getId(),
				Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, headlineSpanDropDownnumberProperty.getX(),
				headlineSpanDropDownnumberProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getUp(up));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlClick(window.getTitle(), NONE, headlineSpanDropDownnumberProperty.getId(),
				Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, headlineSpanDropDownnumberProperty.getX(),
				headlineSpanDropDownnumberProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void headlineSpanDropDownPosition(int down,String testName, String stepName) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property headlineSpanDropDownPositionProperty = window.getPropertyByName(HEADLINE_SPAN_DROPDOWN_POSITION);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, headlineSpanDropDownPositionProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, headlineSpanDropDownPositionProperty.getId(),
				Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, headlineSpanDropDownPositionProperty.getX(),
				headlineSpanDropDownPositionProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlClick(window.getTitle(), NONE, headlineSpanDropDownPositionProperty.getId(),
				Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, headlineSpanDropDownPositionProperty.getX(),
				headlineSpanDropDownPositionProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void headlineSpanDropDownPositionUp(int up,String testName, String stepName) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property headlineSpanDropDownPositionProperty = window.getPropertyByName(HEADLINE_SPAN_DROPDOWN_POSITION);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, headlineSpanDropDownPositionProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, headlineSpanDropDownPositionProperty.getId(),
				Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, headlineSpanDropDownPositionProperty.getX(),
				headlineSpanDropDownPositionProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getUp(up));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlClick(window.getTitle(), NONE, headlineSpanDropDownPositionProperty.getId(),
				Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, headlineSpanDropDownPositionProperty.getX(),
				headlineSpanDropDownPositionProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void sharingUrlLinkBox() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property sharingUrlLinkBoxProperty = window.getPropertyByName(SHARING_URL_LINK_BOX);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, sharingUrlLinkBoxProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, sharingUrlLinkBoxProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, sharingUrlLinkBoxProperty.getX(), sharingUrlLinkBoxProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void disableSocialSharing() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property disableSocialSharingProperty = window.getPropertyByName(DISABLE_SOCIAL_SHARING);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, disableSocialSharingProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, disableSocialSharingProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, disableSocialSharingProperty.getX(), disableSocialSharingProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void disableSavingArticle() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property disableSocialSharingProperty = window.getPropertyByName(DISABLE_SAVING_ARTICLE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, disableSocialSharingProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, disableSocialSharingProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, disableSocialSharingProperty.getX(), disableSocialSharingProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void disableSavingArticleFalse() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property disablesaveArticleProperty = window.getPropertyByName(DISABLE_SAVING_ARTICLE_FALSE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, disablesaveArticleProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, disablesaveArticleProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, disablesaveArticleProperty.getX(), disablesaveArticleProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void panelSettings(int down, String testName, String stepName) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property panelSettingsProperty = window.getPropertyByName(PANEL_SETTINGS);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, panelSettingsProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, panelSettingsProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, panelSettingsProperty.getX(), panelSettingsProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(3000);
		AutoIt.methode.controlClick(window.getTitle(), NONE, panelSettingsProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, panelSettingsProperty.getX(), panelSettingsProperty.getY());
		AutoIt.methode.sleep(3000);
	}

	public static void hexcode(String panelcode,String testName, String stepName) throws Exception{
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property panelColorsSettingsProperty = window.getPropertyByName(PANEL_COLORS_SETTINGS);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, panelColorsSettingsProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, panelColorsSettingsProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, panelColorsSettingsProperty.getX(), panelColorsSettingsProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, panelcode,true);
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(3000);
	}
	
	public static void showChildArticleInNavigation() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property showChildArticleInNavigationProperty = window.getPropertyByName(SHOW_CHILD_ARTICLE_NAVIGATION);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, showChildArticleInNavigationProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, showChildArticleInNavigationProperty.getId(),
				Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, showChildArticleInNavigationProperty.getX(),
				showChildArticleInNavigationProperty.getY());
	}

	public static void disableAutomaticFloorline(String testName, String stepName) throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property disableAutomaticFloorlineProperty = window.getPropertyByName(DISABLE_AUTOMATIC_FLOORLINE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, disableAutomaticFloorlineProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, disableAutomaticFloorlineProperty.getId(),
				Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, disableAutomaticFloorlineProperty.getX(),
				disableAutomaticFloorlineProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		captureScreen(testName, stepName);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void saveBtnDefault() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property saveBtnDefaultProperty = window.getPropertyByName(QUICK_METADATA_SAVE_BTN_DEFAULT);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, saveBtnDefaultProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, saveBtnDefaultProperty.getId(),
				Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, saveBtnDefaultProperty.getX(),
				saveBtnDefaultProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void saveBtnPosition() throws Exception {
		Window window = getWindowProperty(STORY_PREPARATION_PAGE);
		Property saveBtnPositionProperty = window.getPropertyByName(QUICK_METADATA_SAVE_BTN_WITH_POSITION);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		/*AutoIt.methode.controlFocus(window.getTitle(), NONE, saveBtnPositionProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, saveBtnPositionProperty.getId(),
				Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, saveBtnPositionProperty.getX(),
				saveBtnPositionProperty.getY());*/
		AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1716, 1060, Mouse.SINGLE_CLICK, 1000);
		AutoIt.methode.sleep(INTERVAL);
	}
}
