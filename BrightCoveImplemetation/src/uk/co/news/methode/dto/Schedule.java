package uk.co.news.methode.dto;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
    "ends_at",
    "starts_at"
})
public class Schedule {
	@JsonProperty("ends_at")
	private String ends_at;
	@JsonProperty("starts_at")
	private String starts_at;
	
	@JsonProperty("ends_at")
	public String getEnds_at() {
		return ends_at;
	}
	@JsonProperty("ends_at")
	public void setEnds_at(String ends_at) {
		this.ends_at = ends_at;
	}
	@JsonProperty("starts_at")
	public String getStarts_at() {
		return starts_at;
	}
	@JsonProperty("starts_at")
	public void setStarts_at(String starts_at) {
		this.starts_at = starts_at;
	}
	
	@Override
	public String toString() {
		return "Schedule [ends_at=" + ends_at + ", starts_at=" + starts_at + "]";
	}
	
}
