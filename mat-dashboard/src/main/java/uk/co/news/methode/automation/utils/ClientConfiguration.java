package uk.co.news.methode.automation.utils;

import java.io.File;
import java.util.HashMap;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import uk.co.news.methode.automation.container.Default;
import uk.co.news.methode.automation.container.Property;
import uk.co.news.methode.automation.container.Window;
import uk.co.news.methode.automation.exception.PropertyNotFound;
import uk.co.news.methode.automation.exception.WindowNotFound;

public class ClientConfiguration {

	private final static String directorySeparator = File.separator;
	private final static String configRoot = "config";
	private final static String clientConfig = "client.xml";

	private static HashMap<String, Window> windowsContainer = new HashMap<String, Window>();
	private static HashMap<String, Default> defaultSettingContainer = new HashMap<String, Default>();

	private static Document doc;

	public static Document getDoc() {
		return doc;
	}

	private static void setDoc(Document doc) {
		ClientConfiguration.doc = doc;
	}

	public static Document loadConfiguration() {
		String clientConfigurationFile = configRoot + directorySeparator + clientConfig;
		setDoc(XMLFileReader.getXMLFile(clientConfigurationFile));
		loadWindowSetting();
		loadDefaultSetting();
		return doc;

	}

	private static void loadWindowSetting() {

		NodeList windows = doc.getElementsByTagName("window");

		for (int i = 0; i < windows.getLength(); i++) {

			Window windowContainer = new Window();

			Node window = windows.item(i);

			if (window.hasAttributes()) {

				Attr id = (Attr) window.getAttributes().getNamedItem("id");
				Attr title = (Attr) window.getAttributes().getNamedItem("title");
				Attr name = (Attr) window.getAttributes().getNamedItem("name");

				windowContainer.setName(name.getValue());
				windowContainer.setTitle(title.getValue());
				windowContainer.setId(id.getValue());

				if (window.hasChildNodes()) {

					NodeList childNodes = window.getChildNodes();

					for (int ii = 0; ii < childNodes.getLength(); ii++) {

						Node childNode = childNodes.item(ii);

						String nodeName = childNode.getNodeName();

						if (nodeName.equals("properties")) {

							if (childNode.hasChildNodes()) {

								NodeList properties = childNode.getChildNodes();

								for (int p = 0; p < properties.getLength(); p++) {

									Node property = properties.item(p);

									if (property.hasAttributes()) {

										String propertyName = property.getNodeName();

										Property windowProperty = new Property();

										Attr propertyId = (Attr) property.getAttributes().getNamedItem("id");
										Attr propertyX = (Attr) property.getAttributes().getNamedItem("x");
										Attr propertyY = (Attr) property.getAttributes().getNamedItem("y");

										windowProperty.setId(propertyId.getValue());
										windowProperty.setX(Integer.parseInt(propertyX.getValue()));
										windowProperty.setY(Integer.parseInt(propertyY.getValue()));
										windowProperty.setName(propertyName);

										windowContainer.setProperty(propertyName, windowProperty);

									}
								}
							}
						}

						if (nodeName.equals("menus")) {

							if (childNode.hasChildNodes()) {

								NodeList menus = childNode.getChildNodes();

								for (int m = 0; m < menus.getLength(); m++) {

									Node menu = menus.item(m);

									if (menu.hasAttributes()) {

										Property menuProperty = new Property();

										Attr menuId = (Attr) menu.getAttributes().getNamedItem("id");
										Attr menuX = (Attr) menu.getAttributes().getNamedItem("x");
										Attr menuY = (Attr) menu.getAttributes().getNamedItem("y");
										Attr menuName = (Attr) menu.getAttributes().getNamedItem("name");
										Attr shortcuts = (Attr) menu.getAttributes().getNamedItem("shortcuts");

										menuProperty.setId(menuId.getValue());
										menuProperty.setX(Integer.parseInt(menuX.getValue()));
										menuProperty.setY(Integer.parseInt(menuY.getValue()));
										menuProperty.setName(menuName.getValue());
										menuProperty.setShortcuts(shortcuts.getValue());

										windowContainer.setMenu(menuName.getValue(), menuProperty);

									}
								}
							}
						}

					}
				}

				windowsContainer.put(id.getValue(), windowContainer);

			}

		}

	}

	private static void loadDefaultSetting() {

		NodeList defaults = doc.getElementsByTagName("default");

		for (int i = 0; i < defaults.getLength(); i++) {

			Default defaultContainer = new Default();
			

			Node defaultProperty = defaults.item(i);

			if (defaultProperty.hasChildNodes()) {

				NodeList childNodes = defaultProperty.getChildNodes();

				for (int ii = 0; ii < childNodes.getLength(); ii++) {

					Node childNode = childNodes.item(ii);

					if (childNode.hasAttributes()) {

						String propertyName = childNode.getNodeName();

						Attr propertyX = (Attr) childNode.getAttributes().getNamedItem("x");
						Attr propertyY = (Attr) childNode.getAttributes().getNamedItem("y");

						defaultContainer.setX(Integer.parseInt(propertyX.getValue()));
						defaultContainer.setY(Integer.parseInt(propertyY.getValue()));
						defaultContainer.setName(propertyName);

						defaultSettingContainer.put(propertyName, defaultContainer);
					}

				}
			}
		}

	}

	public static Window getWindowsByName(String windowName) throws WindowNotFound {
		if (windowsContainer.containsKey(windowName)) {
			return windowsContainer.get(windowName);
		} else {
			throw new WindowNotFound("Window not found.");
		}
	}

	public static Property getPropertyByName(String windowName, String propertyName)
			throws WindowNotFound, PropertyNotFound {
		if (windowsContainer.containsKey(windowName)) {
			Window window = windowsContainer.get(windowName);
			return window.getPropertyByName(propertyName);
		} else {
			throw new PropertyNotFound("Property not found.");
		}
	}
	
	public static Default getDefaultPropertyByName(String propertyName)
			throws PropertyNotFound {
		if (defaultSettingContainer.containsKey(propertyName)) {
			Default setting = defaultSettingContainer.get(propertyName);
			return setting;
		} else {
			throw new PropertyNotFound("Property not found.");
		}
	}

}
