package uk.co.news.methode.automation.window;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.input.Mouse;


public class STEditionCreation extends BaseWindow{
	
	public static void stNewsNational() throws Exception{
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property stNewsNationalProperty = window.getPropertyByName(ST_NEWS_NATIONAL);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, stNewsNationalProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, stNewsNationalProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, stNewsNationalProperty.getX(), stNewsNationalProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void stSportsNational() throws Exception{
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property stSportsNationalProperty = window.getPropertyByName(ST_SPORTS_NATIONAL);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, stSportsNationalProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, stSportsNationalProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, stSportsNationalProperty.getX(), stSportsNationalProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void stOtherNationalBooks() throws Exception{
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property stOthernationalBooksProperty = window.getPropertyByName(ST_OTHER_NATIONAL_BOOKS);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, stOthernationalBooksProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, stOthernationalBooksProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, stOthernationalBooksProperty.getX(), stOthernationalBooksProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void stTravelNationalBooks() throws Exception{
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property stTravelnationalBooksProperty = window.getPropertyByName(ST_NATIONAL_TRAVEL_BOOK);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, stTravelnationalBooksProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, stTravelnationalBooksProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, stTravelnationalBooksProperty.getX(), stTravelnationalBooksProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void rightNavigation() throws Exception{
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property rightnavigationProperty = window.getPropertyByName(RIGHT_NAVIGATION);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		/*AutoIt.methode.controlFocus(window.getTitle(), NONE, rightnavigationProperty.getId());
		
		AutoIt.methode.controlClick(window.getTitle(), NONE, rightnavigationProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.CLICK_X, rightnavigationProperty.getX(), rightnavigationProperty.getY());
		Mouse.onClick(4, window, rightnavigationProperty, Mouse.LEFT_CLICK);*/
		AutoIt.methode.mouseClick(Mouse.LEFT_CLICK,330, 1065, Mouse.CLICK_X, 1000);
		//AutoIt.methode.mouseClick(Mouse.LEFT_CLICK, 328, 693, Mouse.CLICK_X, 1000);
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void leftNavigation() throws Exception{
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property leftnavigationProperty = window.getPropertyByName(LEFT_NAVIGATION);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.mouseClick(Mouse.LEFT_CLICK,47, 1065, Mouse.CLICK_LX, 1000);
		/*AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 94, 945, 60, 945);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, leftnavigationProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, leftnavigationProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.CLICK_X, leftnavigationProperty.getX(), leftnavigationProperty.getY());*/
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void stNewsIreland() throws Exception{
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property stNewsIrelandProperty = window.getPropertyByName(ST_NEWS_IRELAND);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, stNewsIrelandProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, stNewsIrelandProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, stNewsIrelandProperty.getX(), stNewsIrelandProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void stSportsIreland() throws Exception{
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property stSportsIrelandProperty = window.getPropertyByName(ST_SPORTS_IRELAND);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, stSportsIrelandProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, stSportsIrelandProperty.getId(), Mouse.LEFT_CLICK,Mouse.DOUBLE_CLICK, stSportsIrelandProperty.getX(), stSportsIrelandProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}
	
	public static void stOtherIrelandBooks() throws Exception{
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property stOtherIrelandBooksProperty = window.getPropertyByName(ST_OTHER_IRELAND_BOOKS);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, stOtherIrelandBooksProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, stOtherIrelandBooksProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, stOtherIrelandBooksProperty.getX(), stOtherIrelandBooksProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}
	public static void stTravelIrelandBooks() throws Exception{
		Window window = getWindowProperty(PAGE_PLANNER_MENU);
		Property stTravelIrealndBooksProperty = window.getPropertyByName(ST_IRELAND_TRAVEL_BOOK);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, stTravelIrealndBooksProperty.getId());
		AutoIt.methode.controlClick(window.getTitle(), NONE, stTravelIrealndBooksProperty.getId(), Mouse.LEFT_CLICK,
				Mouse.DOUBLE_CLICK, stTravelIrealndBooksProperty.getX(), stTravelIrealndBooksProperty.getY());
		AutoIt.methode.sleep(INTERVAL);
	}

}
