package uk.co.news.methode.json.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class Tags {
	@JsonProperty("score")
	private Double score;
	@JsonProperty("type")
	private String type;
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("score")
	public Double getScore() {
		return score;
	}
	@JsonProperty("score")
	public void setScore(Double score) {
		this.score = score;
	}
	@JsonProperty("type")
	public String getType() {
		return type;
	}
	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Tags [score=" + score + ", type=" + type + ", name=" + name + "]";
	}
	
	
	
}