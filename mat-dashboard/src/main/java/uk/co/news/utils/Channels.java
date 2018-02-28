package uk.co.news.utils;

public enum Channels {
	TABLET("tablet"),
	PRINT("print"),
	DIGITAL("digital");
	
	public String value;
	private Channels(String value) {
		this.value = value;
	}

}
