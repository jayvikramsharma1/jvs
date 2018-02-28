package uk.co.news.methode.automation.container;

public class Property {

	private int x;

	private int y;

	private String id;

	private String name;
	
	private String shortcuts;

	public String getShortcuts() {
		return shortcuts;
	}

	public void setShortcuts(String shortcuts) {
		this.shortcuts = shortcuts;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
