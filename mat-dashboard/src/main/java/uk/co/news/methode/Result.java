package uk.co.news.methode;

import org.w3c.dom.Attr;

public class Result {

	private String feedType = "";
	private String type = "";
	private String message = "";
	private String element = "";
	private String value = "";
	private boolean s3Content = false;

	public String getFeedType() {
		return feedType;
	}

	public void setFeedType(String feedType) {
		this.feedType = feedType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean getS3Content() {
		return s3Content;
	}

	public void setS3Content(boolean status) {
		this.s3Content = status;
	}
}