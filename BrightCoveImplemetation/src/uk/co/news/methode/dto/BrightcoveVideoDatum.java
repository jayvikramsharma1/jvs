
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
    "id",
    "account_id",
    "ad_keys",
    "clip_source_video_id",
    "complete",
    "created_at",
    "cue_points",
    "custom_fields",
    "delivery_type",
    "description",
    "digital_master_id",
    "duration",
    "economics",
    "folder_id",
    "geo",
    "has_digital_master",
    "images",
    "link",
    "long_description",
    "name",
    "original_filename",
    "projection",
    "published_at",
    "reference_id",
    "schedule",
    "sharing",
    "state",
    "tags",
    "text_tracks",
    "updated_at"
})
public class BrightcoveVideoDatum {

    @JsonProperty("id")
    private String id;
    @JsonProperty("account_id")
    private String accountId;
    @JsonProperty("ad_keys")
    private Object adKeys;
    @JsonProperty("clip_source_video_id")
    private Object clipSourceVideoId;
    @JsonProperty("complete")
    private Boolean complete;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("cue_points")
    private List<Object> cuePoints = null;
    @JsonProperty("custom_fields")
    private CustomFields customFields;
    @JsonProperty("delivery_type")
    private String deliveryType;
    @JsonProperty("description")
    private String description;
    @JsonProperty("digital_master_id")
    private Object digitalMasterId;
    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("economics")
    private String economics;
    @JsonProperty("folder_id")
    private Object folderId;
    @JsonProperty("geo")
    private Object geo;
    @JsonProperty("has_digital_master")
    private Boolean hasDigitalMaster;
    @JsonProperty("images")
    private Images images;
    @JsonProperty("link")
    private Object link;
    @JsonProperty("long_description")
    private Object longDescription;
    @JsonProperty("name")
    private String name;
    @JsonProperty("original_filename")
    private String originalFilename;
    @JsonProperty("projection")
    private Object projection;
    @JsonProperty("published_at")
    private String publishedAt;
    @JsonProperty("reference_id")
    private Object referenceId;
    @JsonProperty("schedule")
    private Schedule schedule;
    @JsonProperty("sharing")
    private Object sharing;
    @JsonProperty("state")
    private String state;
    @JsonProperty("tags")
    private List<String> tags = null;
    @JsonProperty("text_tracks")
    private List<Object> textTracks = null;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("account_id")
    public String getAccountId() {
        return accountId;
    }

    @JsonProperty("account_id")
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @JsonProperty("ad_keys")
    public Object getAdKeys() {
        return adKeys;
    }

    @JsonProperty("ad_keys")
    public void setAdKeys(Object adKeys) {
        this.adKeys = adKeys;
    }

    @JsonProperty("clip_source_video_id")
    public Object getClipSourceVideoId() {
        return clipSourceVideoId;
    }

    @JsonProperty("clip_source_video_id")
    public void setClipSourceVideoId(Object clipSourceVideoId) {
        this.clipSourceVideoId = clipSourceVideoId;
    }

    @JsonProperty("complete")
    public Boolean getComplete() {
        return complete;
    }

    @JsonProperty("complete")
    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("cue_points")
    public List<Object> getCuePoints() {
        return cuePoints;
    }

    @JsonProperty("cue_points")
    public void setCuePoints(List<Object> cuePoints) {
        this.cuePoints = cuePoints;
    }

    @JsonProperty("custom_fields")
    public CustomFields getCustomFields() {
        return customFields;
    }

    @JsonProperty("custom_fields")
    public void setCustomFields(CustomFields customFields) {
        this.customFields = customFields;
    }

    @JsonProperty("delivery_type")
    public String getDeliveryType() {
        return deliveryType;
    }

    @JsonProperty("delivery_type")
    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("digital_master_id")
    public Object getDigitalMasterId() {
        return digitalMasterId;
    }

    @JsonProperty("digital_master_id")
    public void setDigitalMasterId(Object digitalMasterId) {
        this.digitalMasterId = digitalMasterId;
    }

    @JsonProperty("duration")
    public Integer getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @JsonProperty("economics")
    public String getEconomics() {
        return economics;
    }

    @JsonProperty("economics")
    public void setEconomics(String economics) {
        this.economics = economics;
    }

    @JsonProperty("folder_id")
    public Object getFolderId() {
        return folderId;
    }

    @JsonProperty("folder_id")
    public void setFolderId(Object folderId) {
        this.folderId = folderId;
    }

    @JsonProperty("geo")
    public Object getGeo() {
        return geo;
    }

    @JsonProperty("geo")
    public void setGeo(Object geo) {
        this.geo = geo;
    }

    @JsonProperty("has_digital_master")
    public Boolean getHasDigitalMaster() {
        return hasDigitalMaster;
    }

    @JsonProperty("has_digital_master")
    public void setHasDigitalMaster(Boolean hasDigitalMaster) {
        this.hasDigitalMaster = hasDigitalMaster;
    }

    @JsonProperty("images")
    public Images getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(Images images) {
        this.images = images;
    }

    @JsonProperty("link")
    public Object getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(Object link) {
        this.link = link;
    }

    @JsonProperty("long_description")
    public Object getLongDescription() {
        return longDescription;
    }

    @JsonProperty("long_description")
    public void setLongDescription(Object longDescription) {
        this.longDescription = longDescription;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("original_filename")
    public String getOriginalFilename() {
        return originalFilename;
    }

    @JsonProperty("original_filename")
    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    @JsonProperty("projection")
    public Object getProjection() {
        return projection;
    }

    @JsonProperty("projection")
    public void setProjection(Object projection) {
        this.projection = projection;
    }

    @JsonProperty("published_at")
    public String getPublishedAt() {
        return publishedAt;
    }

    @JsonProperty("published_at")
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @JsonProperty("reference_id")
    public Object getReferenceId() {
        return referenceId;
    }

    @JsonProperty("reference_id")
    public void setReferenceId(Object referenceId) {
        this.referenceId = referenceId;
    }

    @JsonProperty("schedule")
    public Schedule getSchedule() {
        return schedule;
    }

    @JsonProperty("schedule")
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @JsonProperty("sharing")
    public Object getSharing() {
        return sharing;
    }

    @JsonProperty("sharing")
    public void setSharing(Object sharing) {
        this.sharing = sharing;
    }
    
    @JsonProperty("state")
    public String getState() {
        return state == null ? "" : state ;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonProperty("text_tracks")
    public List<Object> getTextTracks() {
        return textTracks;
    }

    @JsonProperty("text_tracks")
    public void setTextTracks(List<Object> textTracks) {
        this.textTracks = textTracks;
    }

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
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
		return "BrightcoveVideoDatum [id=" + id + ", accountId=" + accountId + ", adKeys=" + adKeys
				+ ", clipSourceVideoId=" + clipSourceVideoId + ", complete=" + complete + ", createdAt=" + createdAt
				+ ", cuePoints=" + cuePoints + ", customFields=" + customFields + ", deliveryType=" + deliveryType
				+ ", description=" + description + ", digitalMasterId=" + digitalMasterId + ", duration=" + duration
				+ ", economics=" + economics + ", folderId=" + folderId + ", geo=" + geo + ", hasDigitalMaster="
				+ hasDigitalMaster + ", images=" + images + ", link=" + link + ", longDescription=" + longDescription
				+ ", name=" + name + ", originalFilename=" + originalFilename + ", projection=" + projection
				+ ", publishedAt=" + publishedAt + ", referenceId=" + referenceId + ", schedule=" + schedule
				+ ", sharing=" + sharing + ", state=" + state + ", tags=" + tags + ", textTracks=" + textTracks
				+ ", updatedAt=" + updatedAt + ", additionalProperties=" + additionalProperties + "]";
	}
    
    
}
