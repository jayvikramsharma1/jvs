package uk.co.news.methode.dto;

public class ClientCredentials {
	private String url; 
	private String clientId;
	private String clientSecret;
	private String cmsURl;
	private String accountId;
	private String cmsVideoCountURL;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public String getCmsURl() {
		return cmsURl;
	}
	public void setCmsURl(String cmsURl) {
		this.cmsURl = cmsURl;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getCmsVideoCountURL() {
		return cmsVideoCountURL;
	}
	public void setCmsVideoCountURL(String cmsVideoCountURL) {
		this.cmsVideoCountURL = cmsVideoCountURL;
	}
}
