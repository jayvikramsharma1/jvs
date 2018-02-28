package uk.co.news.methode.automation.container;

import java.util.HashMap;

import uk.co.news.methode.automation.exception.MenuNotFound;
import uk.co.news.methode.automation.exception.PropertyNotFound;

public class Window {

	private String name;
	private String id;
	private String title;
	
	HashMap<String, Property> properties = new HashMap<String, Property>();
	HashMap<String, Property> menus = new HashMap<String, Property>();

	public HashMap<String, Property> getMenus() {
		return menus;
	}

	public void setMenus(HashMap<String, Property> menus) {
		this.menus = menus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public HashMap<String, Property> getProperties() {
		return properties;
	}

	public void setProperties(HashMap<String, Property> properties) {
		this.properties = properties;
	}


	public void setProperty(String propertyName, Property property) {
		this.properties.put(propertyName,property);
	}

	public Property getPropertyByName(String propertyName) throws PropertyNotFound {
		if(properties.containsKey(propertyName)) {
			return properties.get(propertyName);
		} else {
			System.out.println(properties);
			throw new PropertyNotFound("Property: "+propertyName+ "does not exists.");
		}
	}
	
	public void setMenu(String menuName, Property property) {
		this.menus.put(menuName, property);
	}
	
	public Property getMenu(String menuName) throws MenuNotFound {
		if(menus.containsKey(menuName)) {
			return menus.get(menuName);
		} else {
			throw new MenuNotFound("Menu: "+menuName+ " does not exists.");
		}
	}
	
}
