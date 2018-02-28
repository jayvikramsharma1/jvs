package uk.co.news.methode.automation.window;

import org.testng.Assert;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.UUID;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;
import uk.co.news.methode.automation.utils.WatchDog;


/**
 * Class contains all the AutoIt base functions to handle Editorial Plan window
 * 
 * @author sbharathi
 *
 */
public class EditorialPlan extends BaseWindow {

	/**
	 * This function selects the slots
	 * 
	 * @param Slotselection
	 *            To select the slot
	 * @throws Exception
	 *             Property not found exception
	 */

	public static void sectionDwp(String direction, int wheelCount, String slotSelection) throws Exception {
		editorialPageDown(direction, wheelCount);
		slotSelection(slotSelection);
	}

	public static void planExtendExisting() throws Exception {
		nationalPlanExtend();
		irishPlanExtend();
	}

	public static void planExtend() throws Exception {
		nationalPlanExtend();
		workflowNational();
		EditorialWorkFlow.editorialPlanInProgress();
		irishPlanExtend();
		workflowIrish();
		EditorialWorkFlow.editorialPlanInProgress();
	}

	public static void slot(String Slotselection) throws Exception {
		slotSelection(Slotselection);
		openSlotSelection(Slotselection);
	}

	/**
	 * This function selects the news slots
	 * 
	 * @param Slotselection
	 *            To select the slot
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void newsSlot(String Slotselection) throws Exception {
		newsSlotSelection(Slotselection);
		openSlotSelection(Slotselection);
	}

	/**
	 * This function clicks on publish button and copies UUID
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void publishSlotUUID(String testName, String stepName) throws Exception {
		publish(testName, stepName);
		chpClipbaordBtn();
	}
	
	public static void stPublishSlotUUID(String testName, String stepName) throws Exception {
		stPublish(testName, stepName);
		stChpClipbaordBtn();
	}

	/**
	 * This function extends the pageplan - National
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */

	public static void nationalPlanExtend() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property editorialPlanExtendProperty = window.getPropertyByName(NATIONAL_PAGEPLANNER_EXPANDER);
		AutoIt.methode.winWaitActive(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, editorialPlanExtendProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, editorialPlanExtendProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, editorialPlanExtendProperty.getX(), editorialPlanExtendProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		Property nationalMainbookProperty = window.getPropertyByName(NATIONAL_MAINBOOK_BTN);
		AutoIt.methode.controlClick(window.getTitle(), NONE, nationalMainbookProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, nationalMainbookProperty.getX(), nationalMainbookProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function extends the pageplan - Ireland
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void irishPlanExtend() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property editorialPlanExtendProperty = window.getPropertyByName(IRISH_PAGEPLANNER_EXPANDER);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, editorialPlanExtendProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, editorialPlanExtendProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, editorialPlanExtendProperty.getX(), editorialPlanExtendProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		/*
		 * Property nationalMainbookProperty =
		 * window.getPropertyByName(NATIONAL_MAINBOOK_BTN);
		 * AutoIt.methode.controlClick(window.getTitle(), NONE,
		 * nationalMainbookProperty.getId(), Mouse.LEFT_CLICK,
		 * Mouse.DOUBLE_CLICK, nationalMainbookProperty.getX(),
		 * nationalMainbookProperty.getY()); AutoIt.methode.sleep(INTERVAL);
		 */
	}

	public static void selectAllSlot() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, "^a");
		// AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, "a",false);
		// AutoIt.methode.send("{RCTRL}A");
	}

	/**
	 * This function gets the national Workflow window
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void workflowNational() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property editorialPlanExtendProperty = window.getPropertyByName(NATIONAL_PAGEPLANNER_EXPANDER);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, editorialPlanExtendProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, editorialPlanExtendProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, editorialPlanExtendProperty.getX(), editorialPlanExtendProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, editorialPlanExtendProperty.getId(), Mouse.getDown(12));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, editorialPlanExtendProperty.getId(), Mouse.ENTER);
		window = getWindowProperty(EDITORIAL_WORK_FLOW);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function gets the Irish Workflow window
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void workflowIrish() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property editorialPlanExtendProperty = window.getPropertyByName(IRISH_PAGEPLANNER_EXPANDER);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, editorialPlanExtendProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, editorialPlanExtendProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, editorialPlanExtendProperty.getX(), editorialPlanExtendProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, editorialPlanExtendProperty.getId(), Mouse.getDown(12));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, editorialPlanExtendProperty.getId(), Mouse.ENTER);
		window = getWindowProperty(EDITORIAL_WORK_FLOW);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function publishes the slot
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void publish(String testName, String stepName) throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property publishBtnProperty = window.getPropertyByName(PUBLISH_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, publishBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, publishBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, publishBtnProperty.getX(), publishBtnProperty.getY());
		AutoIt.methode.sleep(7000);
		window = getWindowProperty(ACTION_RESULT);
		WatchDog.wait(window);
		if(AutoIt.methode.winExists(window.getTitle())){
			captureScreen(testName, stepName);
			AutoIt.methode.winClose(window.getTitle());
			Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true, "Unable to Publish");
			AutoIt.methode.sleep(INTERVAL);
		}else{
			System.out.println("Slot published");
		}
	}

	/**
	 * This function previews the slot
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void preview() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property previewBtnProperty = window.getPropertyByName(PREVIEW_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, previewBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, previewBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, previewBtnProperty.getX(), previewBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function writes the UUID
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void chpClipbaordBtn() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property chpClipbaordBtnProperty = window.getPropertyByName(CHP_CLIPBOARD_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, chpClipbaordBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, chpClipbaordBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, chpClipbaordBtnProperty.getX(), chpClipbaordBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		String uuid = AutoIt.methode.clipGet();
		System.out.println(uuid);
		UUID.setSlotUUID(uuid);
		// AppLauncher.s3_validation = s3link+uuid;
		// System.out.println(AppLauncher.s3_validation);
	}

	/**
	 * This function gets the Edition Metadata
	 * 
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void editionMetadata() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property editionMetadataProperty = window.getPropertyByName(EDITION_METADA);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, editionMetadataProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, editionMetadataProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, editionMetadataProperty.getX(), editionMetadataProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function scrolls the editorial page up and down
	 * 
	 * @param direction
	 *            Refers the direction of scroll
	 * @param wheelCount
	 *            Refers the count of scroll
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void editorialPageUpDown(String direction, int wheelCount) throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property slotMoveProperty = window.getPropertyByName(SLOT_MOVE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, slotMoveProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseWheel(direction, wheelCount);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function scrolls the editorial page up and down
	 * 
	 * @param direction
	 *            Refers the direction of scroll
	 * @param wheelCount
	 *            Refers the count of scroll
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void editorialPageDown(String direction, int wheelCount) throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property slotMoveProperty = window.getPropertyByName(SLOT_MOVE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, slotMoveProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseWheel(direction, wheelCount);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function will highlight the slot
	 * 
	 * @param slotSelection
	 *            Slot to be highlighted
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void hightlightSlot(String slotSelection) throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property slotSelectionProperty = window.getPropertyByName(slotSelection);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, slotSelectionProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, slotSelectionProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, slotSelectionProperty.getX(), slotSelectionProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(6));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * This function selects the slot
	 * 
	 * @param slotSelection
	 *            Slot to be selected
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void slotSelection(String slotSelection) throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property slotSelectionProperty = window.getPropertyByName(slotSelection);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, slotSelectionProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, slotSelectionProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, slotSelectionProperty.getX(), slotSelectionProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(2));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(35000);
		AutoIt.methode.winWaitActive(window.getTitle());
	}

	/**
	 * This function selects the news slot
	 * 
	 * @param newsSlotSelection
	 *            Slot to be selected
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void newsSlotSelection(String newsSlotSelection) throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property newsSlotSelectProperty = window.getPropertyByName(newsSlotSelection);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, newsSlotSelectProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, newsSlotSelectProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, newsSlotSelectProperty.getX(), newsSlotSelectProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(2));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void openSlotSelection(String slotSelection) throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property slotSelectionProperty = window.getPropertyByName(slotSelection);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, slotSelectionProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, slotSelectionProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, slotSelectionProperty.getX(), slotSelectionProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(DWP_PAGE);
		AutoIt.methode.sleep(INTERVAL);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	/**
	 * The function helps to reorder the slot
	 * 
	 * @param slotSelection
	 *            Slot to be selected
	 * @throws Exception
	 *             Property not found exception
	 */
	public static void reorderingPages(String slotSelection) throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property slotSelectionProperty = window.getPropertyByName(slotSelection);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, slotSelectionProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, slotSelectionProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, slotSelectionProperty.getX(), slotSelectionProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 840, 360, 1150, 360, 2000);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseMove(1700, 400);
		AutoIt.methode.sleep(INTERVAL);
		// AutoIt.methode.controlSend(window.getTitle(), NONE,
		// slotSelectionProperty.getId(), Mouse.getDown(1));
		// AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, slotSelectionProperty.getId(), Mouse.getDown(1));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, slotSelectionProperty.getId(), Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void reorderingPages2(String slotSelection) throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property slotSelectionProperty = window.getPropertyByName(slotSelection);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, slotSelectionProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, slotSelectionProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, slotSelectionProperty.getX(), slotSelectionProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 840, 360, 821, 700, 2000);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseMove(1700, 400);
		AutoIt.methode.sleep(INTERVAL);
		// AutoIt.methode.controlSend(window.getTitle(), NONE,
		// slotSelectionProperty.getId(), Mouse.getDown(1));
		// AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, slotSelectionProperty.getId(), Mouse.getDown(1));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, slotSelectionProperty.getId(), Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void reorderingPages3(String slotSelection) throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property slotSelectionProperty = window.getPropertyByName(slotSelection);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, slotSelectionProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, slotSelectionProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, slotSelectionProperty.getX(), slotSelectionProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1150, 360, 1164, 700, 2000);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseMove(1700, 400);
		AutoIt.methode.sleep(INTERVAL);
		// AutoIt.methode.controlSend(window.getTitle(), NONE,
		// slotSelectionProperty.getId(), Mouse.getDown(1));
		// AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, slotSelectionProperty.getId(), Mouse.getDown(1));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, slotSelectionProperty.getId(), Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void shapeLibrary() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property templateDesignProperty = window.getMenu(VIEW);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, templateDesignProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, templateDesignProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, templateDesignProperty.getX(), templateDesignProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(1));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(1));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(1));
		AutoIt.methode.sleep(1000);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getTab(1));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void searchTemplateDesign(String designName) throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property templateSearchBoxProperty = window.getPropertyByName(TEMPLATE_SEARCH_BOX);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, templateSearchBoxProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, templateSearchBoxProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, templateSearchBoxProperty.getX(), templateSearchBoxProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.ControlSetText(window.getTitle(), NONE, NONE, designName);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		Property templateSearchBoxDropDownProperty = window.getPropertyByName(TEMPLATE_SEARCH_BOX_DROP_DOWN);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, templateSearchBoxDropDownProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, templateSearchBoxDropDownProperty.getId(),
				Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, templateSearchBoxDropDownProperty.getX(),
				templateSearchBoxDropDownProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlClick(window.getTitle(), NONE, templateSearchBoxDropDownProperty.getId(),
				Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, templateSearchBoxDropDownProperty.getX(),
				templateSearchBoxDropDownProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void templatePattern(int down) throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property templateDesignProperty = window.getPropertyByName(DESIGN_TEMPLATE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, templateDesignProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlCommandShowDropdown(window.getTitle(), NONE, templateDesignProperty.getId());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(down));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void releasePage(String slotSelection) throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property slotSelectionProperty = window.getPropertyByName(slotSelection);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, slotSelectionProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, slotSelectionProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, slotSelectionProperty.getX(), slotSelectionProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(4));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(TAB_PAGE_FLOW);
		AutoIt.methode.sleep(INTERVAL);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(15000);
	}

	public static void mainBookNational() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property nationalMainbookProperty = window.getPropertyByName(NATIONAL_MAINBOOK_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.controlFocus(window.getTitle(), NONE, nationalMainbookProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, nationalMainbookProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, nationalMainbookProperty.getX(), nationalMainbookProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void timesNational() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property selectingNationalTimesSectionProperty = window.getPropertyByName(NATIONAL_TIMES);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, selectingNationalTimesSectionProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, selectingNationalTimesSectionProperty.getId(),
				Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, selectingNationalTimesSectionProperty.getX(),
				selectingNationalTimesSectionProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void irishMainbookBtn() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property irishMainbookProperty = window.getPropertyByName(IRISH_MAINBOOK_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, irishMainbookProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, irishMainbookProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, irishMainbookProperty.getX(), irishMainbookProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void timesIrish() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property selectingIrishTimesSectionProperty = window.getPropertyByName(IRISH_TIMES);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, selectingIrishTimesSectionProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, selectingIrishTimesSectionProperty.getId(),
				Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, selectingIrishTimesSectionProperty.getX(),
				selectingIrishTimesSectionProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void tdSlot1() throws Exception {
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1730, 195, 490, 290, 3000);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void tdSlot2() throws Exception {
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1730, 195, 840, 290, 3000);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void tdSlot3() throws Exception {
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 1730, 195, 1160, 290, 3000);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void selectSlot(String slotSelection) throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property slotSelectionProperty = window.getPropertyByName(slotSelection);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, slotSelectionProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, slotSelectionProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, slotSelectionProperty.getX(), slotSelectionProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void closeShapeLibrary() throws Exception {
		/*
		 * Window window = getWindowProperty(PAGE_PLANNER_MENU); Property
		 * closeShapeLibraryProperty =
		 * window.getPropertyByName(CLOSE_SHAPE_LIBRARY);
		 * AutoIt.methode.winActivate(window.getTitle());
		 * AutoIt.methode.sleep(INTERVAL);
		 * AutoIt.methode.controlFocus(window.getTitle(), NONE,
		 * closeShapeLibraryProperty.getId());
		 * AutoIt.methode.controlClick(window.getTitle(), NONE,
		 * closeShapeLibraryProperty.getId(), Mouse.LEFT_CLICK,
		 * Mouse.SINGLE_CLICK, closeShapeLibraryProperty.getX(),
		 * closeShapeLibraryProperty.getY());
		 */
		AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1900, 93, Mouse.SINGLE_CLICK, INTERVAL);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void dragFrame() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 333, 172, 832, 294, 1000);
	}

	public static void clickOnMagazine() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property clickOnMagazineProperty = window.getPropertyByName(CLICK_ON_MAGAZINE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickOnMagazineProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickOnMagazineProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, clickOnMagazineProperty.getX(), clickOnMagazineProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1340, 585, Mouse.SINGLE_CLICK, 1000);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void clickOnInsert() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property clickOnInsertProperty = window.getMenu(PP_INSERT);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, clickOnInsertProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, clickOnInsertProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, clickOnInsertProperty.getX(), clickOnInsertProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(1));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		window = getWindowProperty(PP_INSERT_PAGE);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void eatingSlot() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property eatingSlotProperty = window.getPropertyByName(EATING_SLOT);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, eatingSlotProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, eatingSlotProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.DOUBLE_CLICK, eatingSlotProperty.getX(), eatingSlotProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(2));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void clickOnIrishEdition() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property editorialPlanExtendProperty = window.getPropertyByName(IRISH_PAGEPLANNER_EXPANDER);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, editorialPlanExtendProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, editorialPlanExtendProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, editorialPlanExtendProperty.getX(), editorialPlanExtendProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void propertyWindow() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property editorialPlanExtendProperty = window.getPropertyByName(NATIONAL_PAGEPLANNER_EXPANDER);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, editorialPlanExtendProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, editorialPlanExtendProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, editorialPlanExtendProperty.getX(), editorialPlanExtendProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, editorialPlanExtendProperty.getId(), Mouse.getDown(8));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, editorialPlanExtendProperty.getId(), Mouse.ENTER);
		window = getWindowProperty(PROPERTY_WINDOW);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void propertyWindowIrish() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property editorialPlanExtendProperty = window.getPropertyByName(IRISH_PAGEPLANNER_EXPANDER);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, editorialPlanExtendProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, editorialPlanExtendProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, editorialPlanExtendProperty.getX(), editorialPlanExtendProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, editorialPlanExtendProperty.getId(), Mouse.getDown(8));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, editorialPlanExtendProperty.getId(), Mouse.ENTER);
		window = getWindowProperty(PROPERTY_WINDOW);
		WatchDog.wait(window);
		Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true);
		AutoIt.methode.sleep(INTERVAL);
	}

	public static void test() throws Exception {
		System.out.println("Validation s3 validation");
	}

	public static void slotPreview(String testName, String stepName) throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property previewBtnProperty = window.getPropertyByName(PREVIEW_BTN);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, previewBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, previewBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, previewBtnProperty.getX(), previewBtnProperty.getY());
		AutoIt.methode.sleep(10000);
		window = getWindowProperty(ACTION_RESULT);
		WatchDog.wait(window);
		if(AutoIt.methode.winExists(window.getTitle())){
			captureScreen(testName, stepName);
			AutoIt.methode.winClose(window.getTitle());
			Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true, "Unable to Publish");
			AutoIt.methode.sleep(INTERVAL);
		}else{
			AutoIt.methode.sleep(10000);
			//System.out.println("Slot published");
			captureScreen(testName, stepName);
			AutoIt.methode.sleep(INTERVAL);
		}
		
	}

	public static void bookSectionMetadata() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property bookSectionMetadataBtnProperty = window.getPropertyByName(BOOKE_SECTION_METADATA);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, bookSectionMetadataBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, bookSectionMetadataBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, bookSectionMetadataBtnProperty.getX(), bookSectionMetadataBtnProperty.getY());
		AutoIt.methode.sleep(8000);
	}
	
	public static void screenCapture(String testName, String stepName) throws Exception{
		captureScreen(testName, stepName);
	}

	public static void closeWindow() throws Exception{
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.winClose(window.getTitle());
	}
	
	public static void removingArticle(String slotSelection) throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property slotSelectionProperty = window.getPropertyByName(slotSelection);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, slotSelectionProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, slotSelectionProperty.getId(), Mouse.RIGHT_CLICK,
				Mouse.SINGLE_CLICK, slotSelectionProperty.getX(), slotSelectionProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(8));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void saveArticle() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property saveArticleWindowProperty = window.getMenu(FILE);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		// AutoIt.methode.controlFocus(window.getTitle(), NONE,
		// saveArticleWindowProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, saveArticleWindowProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, saveArticleWindowProperty.getX(), saveArticleWindowProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(5));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void allContent() throws Exception{
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		//Property allContentWindowProperty = window.getMenu(ALL_CONTENT);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
	/*	AutoIt.methode.controlFocus(window.getTitle(), NONE, allContentWindowProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, allContentWindowProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, allContentWindowProperty.getX(), allContentWindowProperty.getY());*/
		AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 300, 42, Mouse.SINGLE_CLICK, 1000);
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.getDown(2));
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlSend(window.getTitle(), NONE, NONE, Mouse.ENTER);
		AutoIt.methode.sleep(5000);
		
	}
	public static void stPublish(String testName, String stepName) throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property publishBtnProperty = window.getPropertyByName(ST_PUBLISH);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, publishBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, publishBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, publishBtnProperty.getX(), publishBtnProperty.getY());
		AutoIt.methode.sleep(7000);
		window = getWindowProperty(ACTION_RESULT);
		WatchDog.wait(window);
		if(AutoIt.methode.winExists(window.getTitle())){
			captureScreen(testName, stepName);
			AutoIt.methode.winClose(window.getTitle());
			Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true, "Unable to Publish");
			AutoIt.methode.sleep(INTERVAL);
		}else{
			System.out.println("Slot published");
		}
	}
	
	public static void stSlotPreview(String testName, String stepName) throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property previewBtnProperty = window.getPropertyByName(ST_PREVIEW);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, previewBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, previewBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, previewBtnProperty.getX(), previewBtnProperty.getY());
		AutoIt.methode.sleep(10000);
		window = getWindowProperty(ACTION_RESULT);
		WatchDog.wait(window);
		if(AutoIt.methode.winExists(window.getTitle())){
			captureScreen(testName, stepName);
			AutoIt.methode.winClose(window.getTitle());
			Assert.assertEquals(AutoIt.methode.winExists(window.getTitle()), true, "Unable to Publish");
			AutoIt.methode.sleep(INTERVAL);
		}else{
			AutoIt.methode.sleep(10000);
			//System.out.println("Slot published");
			captureScreen(testName, stepName);
			AutoIt.methode.sleep(INTERVAL);
		}
		
	}

	public static void stChpClipbaordBtn() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property chpClipbaordBtnProperty = window.getPropertyByName(ST_SLOT_UUID);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, chpClipbaordBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, chpClipbaordBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, chpClipbaordBtnProperty.getX(), chpClipbaordBtnProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
		String uuid = AutoIt.methode.clipGet();
		System.out.println(uuid);
		UUID.setSlotUUID(uuid);
		// AppLauncher.s3_validation = s3link+uuid;
		// System.out.println(AppLauncher.s3_validation);
	}
	
	public static void stBookSectionMetadata() throws Exception {
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property bookSectionMetadataBtnProperty = window.getPropertyByName(ST_BOOKE_SECTION_METADATA);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, bookSectionMetadataBtnProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, bookSectionMetadataBtnProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.SINGLE_CLICK, bookSectionMetadataBtnProperty.getX(), bookSectionMetadataBtnProperty.getY());
		AutoIt.methode.sleep(8000);
	}
	public static void unslot() throws Exception{
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property bookSectionMetadataBtnProperty = window.getPropertyByName(ST_BOOKE_SECTION_METADATA);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(2000);
		AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 1487, 292, Mouse.SINGLE_CLICK, 1000);
		AutoIt.methode.sleep(2000);
		allContent();
		AutoIt.methode.sleep(2000);
	}

}
