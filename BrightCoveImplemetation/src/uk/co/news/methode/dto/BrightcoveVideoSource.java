package uk.co.news.methode.dto;

import java.util.HashMap;
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
"app_name",
"stream_name",
"codec",
"container",
"encoding_rate",
"duration",
"height",
"width",
"size",
"uploaded_at",
"src",
"type"
})
public class BrightcoveVideoSource {

@JsonProperty("asset_id")
private String assetId;
@JsonProperty("remote")
private Boolean remote;
@JsonProperty("app_name")
private String appName;
@JsonProperty("stream_name")
private String streamName;
@JsonProperty("codec")
private String codec;
@JsonProperty("container")
private String container;
@JsonProperty("encoding_rate")
private Integer encodingRate;
@JsonProperty("duration")
private Integer duration;
@JsonProperty("height")
private Integer height;
@JsonProperty("width")
private Integer width;
@JsonProperty("size")
private Integer size;
@JsonProperty("uploaded_at")
private String uploadedAt;
@JsonProperty("src")
private String src;
@JsonProperty("type")
private String type;
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

@JsonProperty("app_name")
public String getAppName() {
return appName;
}

@JsonProperty("app_name")
public void setAppName(String appName) {
this.appName = appName;
}

@JsonProperty("stream_name")
public String getStreamName() {
return streamName;
}

@JsonProperty("stream_name")
public void setStreamName(String streamName) {
this.streamName = streamName;
}

@JsonProperty("codec")
public String getCodec() {
return codec;
}

@JsonProperty("codec")
public void setCodec(String codec) {
this.codec = codec;
}

@JsonProperty("container")
public String getContainer() {
return container;
}

@JsonProperty("container")
public void setContainer(String container) {
this.container = container;
}

@JsonProperty("encoding_rate")
public Integer getEncodingRate() {
return encodingRate;
}

@JsonProperty("encoding_rate")
public void setEncodingRate(Integer encodingRate) {
this.encodingRate = encodingRate;
}

@JsonProperty("duration")
public Integer getDuration() {
return duration;
}

@JsonProperty("duration")
public void setDuration(Integer duration) {
this.duration = duration;
}

@JsonProperty("height")
public Integer getHeight() {
return height;
}

@JsonProperty("height")
public void setHeight(Integer height) {
this.height = height;
}

@JsonProperty("width")
public Integer getWidth() {
return width;
}

@JsonProperty("width")
public void setWidth(Integer width) {
this.width = width;
}

@JsonProperty("size")
public Integer getSize() {
return size;
}

@JsonProperty("size")
public void setSize(Integer size) {
this.size = size;
}

@JsonProperty("uploaded_at")
public String getUploadedAt() {
return uploadedAt;
}

@JsonProperty("uploaded_at")
public void setUploadedAt(String uploadedAt) {
this.uploadedAt = uploadedAt;
}

@JsonProperty("src")
public String getSrc() {
return src;
}

@JsonProperty("src")
public void setSrc(String src) {
this.src = src;
}

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
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
	return "BrightcoveVideoSource [assetId=" + assetId + ", remote=" + remote + ", appName=" + appName + ", streamName="
			+ streamName + ", codec=" + codec + ", container=" + container + ", encodingRate=" + encodingRate
			+ ", duration=" + duration + ", height=" + height + ", width=" + width + ", size=" + size + ", uploadedAt="
			+ uploadedAt + ", src=" + src + ", type=" + type + ", additionalProperties=" + additionalProperties + "]";
}



}
