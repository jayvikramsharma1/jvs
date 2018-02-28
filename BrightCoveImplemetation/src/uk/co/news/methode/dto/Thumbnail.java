
package uk.co.news.methode.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
    "asset_id",
    "remote",
    "src",
    "sources"
})
public class Thumbnail {

    @JsonProperty("asset_id")
    private String assetId;
    @JsonProperty("remote")
    private Boolean remote;
    @JsonProperty("src")
    private String src;
    @JsonProperty("sources")
    private List<Source> sources = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("asset_id")
    public String getAssetId() {
        return assetId;
    }

    @JsonProperty("asset_id")
    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    @JsonProperty("remote")
    public Boolean getRemote() {
        return remote;
    }

    @JsonProperty("remote")
    public void setRemote(Boolean remote) {
        this.remote = remote;
    }

    @JsonProperty("src")
    public String getSrc() {
        return src;
    }

    @JsonProperty("src")
    public void setSrc(String src) {
        this.src = src;
    }

    @JsonProperty("sources")
    public List<Source> getSources() {
        return sources;
    }

    @JsonProperty("sources")
    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public String toString() {
		return "Thumbnail [assetId=" + assetId + ", remote=" + remote + ", src=" + src + ", sources=" + sources
				+ ", additionalProperties=" + additionalProperties + "]";
	}
    
    
}
