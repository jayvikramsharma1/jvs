package uk.co.news.methode.json.dto;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TagsData {
	
	/*@JsonProperty("metadata")
	private Metadata metadata;*/
	
	@JsonProperty("code")
	private Integer responseCode;
	@JsonProperty("message")
	private String responseMessage;
	
	@JsonProperty("tags")
	private List<Tags> tags;
	
	@JsonProperty("code")
	public Integer getResponseCode() {
		return responseCode;
	}
	@JsonProperty("code")
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	@JsonProperty("message")
	public String getResponseMessage() {
		return responseMessage;
	}
	@JsonProperty("message")
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	@JsonProperty("tags")
	public List<Tags> getTags() {
		return tags;
	}
	@JsonProperty("tags")
	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}
	
	@Override
	public String toString() {
		return "TagsData [responseCode=" + responseCode + ", responseMessage=" + responseMessage + ", tags=" + tags
				+ "]";
	}
	
	
	
	
}
