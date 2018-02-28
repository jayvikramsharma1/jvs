package uk.co.news.methode.dto;

public class BrightcoveVideoSourceData {
	private String accountId;
	private String id;
	private String name;
	private String imageSrc;
	private String description;
	private Long duration;
	private String videoSrc;
	private String emoFileName;
	private String paidOnly;
	private String codec;
	private Schedule schedules;
	private String container;
	private String width;
	private String height;
	private Boolean embargoedFlag;
	private String competitionId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageSrc() {
		return imageSrc;
	}
	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public String getVideoSrc() {
		return videoSrc;
	}
	public void setVideoSrc(String videoSrc) {
		this.videoSrc = videoSrc;
	}
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public String getEmoFileName() {
		return emoFileName;
	}
	public void setEmoFileName(String emoFileName) {
		this.emoFileName = emoFileName;
	}

	public String getPaidOnly() {
		return paidOnly;
	}
	public void setPaidOnly(String paidOnly) {
		this.paidOnly = paidOnly;
	}
	public String getCodec() {
		return codec;
	}
	public void setCodec(String codec) {
		this.codec = codec;
	}
	public String getContainer() {
		return container;
	}
	public void setContainer(String container) {
		this.container = container;
	}
	
	
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	
	public Schedule getSchedules() {
		return schedules;
	}
	public void setSchedules(Schedule schedules) {
		this.schedules = schedules;
	}
	
	
	public Boolean getEmbargoedFlag() {
		return embargoedFlag;
	}
	public void setEmbargoedFlag(Boolean embargoedFlag) {
		this.embargoedFlag = embargoedFlag;
	}
	public String getCompetitionId() {
		return competitionId;
	}
	public void setCompetitionId(String competitionId) {
		this.competitionId = competitionId;
	}
	@Override
	public String toString() {
		return "BrightcoveVideoSourceData [accountId=" + accountId + ", id=" + id + ", name=" + name + ", imageSrc="
				+ imageSrc + ", description=" + description + ", duration=" + duration + ", videoSrc=" + videoSrc
				+ ", emoFileName=" + emoFileName + ", paidOnly=" + paidOnly + ", codec=" + codec + ", schedules="
				+ schedules + ", container=" + container + ", width=" + width + ", height=" + height
				+ ", embargoedFlag=" + embargoedFlag + ", competitionId=" + competitionId + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
