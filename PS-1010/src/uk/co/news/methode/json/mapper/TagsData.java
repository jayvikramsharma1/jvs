package uk.co.news.methode.json.mapper;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TagsData {
	@JsonProperty("metadata")
	private Metadata metadata;
	@JsonProperty("tags")
	private List<Tags> tags;
	
	@JsonProperty("metadata")
	public Metadata getMetadata() {
		return metadata;
	}
	@JsonProperty("metadata")
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
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
		return "TagsData [metadata=" + metadata + ", tags=" + tags + "]";
	}
	
	
}
