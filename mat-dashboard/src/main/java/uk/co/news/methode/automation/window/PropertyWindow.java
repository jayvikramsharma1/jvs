package uk.co.news.methode.automation.window;

import uk.co.news.methode.automation.AutoIt;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.UUID;
import uk.co.news.methode.automation.container.Window;


public class PropertyWindow extends BaseWindow{
	
	public static void gettingEditionPropertyUuid() throws Exception{
		Window window = getWindowProperty(PROPERTY_WINDOW);
		Property uuidProperty = window.getPropertyByName(UUID_PROPERTIES);
		AutoIt.methode.winActivate(window.getTitle());
		AutoIt.methode.sleep(INTERVAL);
		AutoIt.methode.controlFocus(window.getTitle(), NONE, uuidProperty.getId());
		String uuid = AutoIt.methode.controlGetText(window.getTitle(), NONE, uuidProperty.getId());
		System.out.println(uuid);
		AutoIt.methode.sleep(INTERVAL);
		UUID.setEditionUUID(uuid);
		AutoIt.methode.winClose(window.getTitle());
		/*AutoIt.methode.mouseClickDrag(Mouse.LEFT_CLICK, 861, 673, 1057, 673);
		AutoIt.methode.sleep(INTERVAL);*/
	}

}
