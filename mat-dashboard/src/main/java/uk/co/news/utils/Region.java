package uk.co.news.utils;

public enum Region {
	NATIONAL("national"),
	IRELAND("ireland");
	
	public String value;

	private Region(String value) {
		this.value = value;
	}
}
