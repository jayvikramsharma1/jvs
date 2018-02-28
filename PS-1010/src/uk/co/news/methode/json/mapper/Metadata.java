package uk.co.news.methode.json.mapper;

import org.codehaus.jackson.annotate.JsonProperty;

public class Metadata {
	@JsonProperty("timestamp")
	private String timestamp;
	
	@JsonProperty("timestamp")
	public String getTimestamp() {
		return timestamp;
	}
	
	@JsonProperty("timestamp")
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Metadata [timestamp=" + timestamp + "]";
	}
	
}
