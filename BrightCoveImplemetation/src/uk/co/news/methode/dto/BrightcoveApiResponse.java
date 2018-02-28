package uk.co.news.methode.dto;

public class BrightcoveApiResponse {
	private String accessToken;
	private String cmsURL;
	private String cmsVideoCountURL;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getCmsURL() {
		return cmsURL;
	}
	public void setCmsURL(String cmsURL) {
		this.cmsURL = cmsURL;
	}
	public String getCmsVideoCountURL() {
		return cmsVideoCountURL;
	}
	public void setCmsVideoCountURL(String cmsVideoCountURL) {
		this.cmsVideoCountURL = cmsVideoCountURL;
	}	
}
