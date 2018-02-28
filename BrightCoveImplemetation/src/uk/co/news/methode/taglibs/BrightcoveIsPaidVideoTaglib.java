package uk.co.news.methode.taglibs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

import uk.co.news.methode.dto.BrightcoveVideoDatum;
import uk.co.news.methode.util.BrightcoveUtils;

public class BrightcoveIsPaidVideoTaglib extends SimpleTagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String brightcoveId;
	private String resultVar;
	private String webpanelPortNumber;
	Logger logger = Logger.getLogger(BrightcoveIsPaidVideoTaglib.class);
	@Override
	public void doTag() {
		String isPaid;
		try {
			logger.debug(webpanelPortNumber);
			isPaid = isBrightcoveVideoPaid(brightcoveId, "localhost", webpanelPortNumber);
			getJspContext().setAttribute(resultVar, isPaid);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getIsBrightcoveVideoPaid(String brightCoveId, String apiUrl) throws MalformedURLException, IOException {
		HttpURLConnection connection = null;
		try {
			URL url = new URL(apiUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			logger.debug("Response Message "+connection.getResponseMessage());
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			return response.toString();

		} catch (Exception e) {
			logger.debug(e.getMessage());
			return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
	public String getUrl(String brightCoveId, String serverName, String serverPort) {
		String apiUrl = "http://"+serverName+":"+serverPort+"/webpanels/brightcove/api?q="+ brightCoveId +"&videoSource=false";
		logger.debug(apiUrl);
		return apiUrl;
	}
	
	public String isBrightcoveVideoPaid(String brightCoveId, String serverName, String serverPort) throws MalformedURLException, IOException {
		String isPaidChannel = "false";
		BrightcoveIsPaidVideoTaglib tlb = new BrightcoveIsPaidVideoTaglib();
		String res = tlb.getIsBrightcoveVideoPaid(brightCoveId, tlb.getUrl(brightCoveId, serverName, serverPort));
		logger.debug("Response from Brightcove is "+res);
		if(res == null || res.equals("")) {
			logger.debug("IS Brightcove Paid Response is null or blank " + res);
			return isPaidChannel;
		}
		List<BrightcoveVideoDatum> datam = (List<BrightcoveVideoDatum>) BrightcoveUtils.getVideosDataListFromJson(res, "uk.co.news.methode.dto.BrightcoveVideoDatum");
		logger.debug("Data Size is "+datam.size());
		
		if((datam != null && datam.size() > 0) && datam.get(0) != null && datam.get(0).getCustomFields() != null && datam.get(0).getCustomFields().getAdditionalProperties() != null) {
			isPaidChannel = datam.get(0).getCustomFields().getAdditionalProperties().get("paidonly") == null ? "false" : datam.get(0).getCustomFields().getAdditionalProperties().get("paidonly").toString();
		}
		logger.debug(isPaidChannel);
		return isPaidChannel;
	}
	
	public String getBrightcoveId() {
		return brightcoveId;
	}
	public void setBrightcoveId(String brightcoveId) {
		this.brightcoveId = brightcoveId;
	}

	public String getResultVar() {
		return resultVar;
	}

	public void setResultVar(String resultVar) {
		this.resultVar = resultVar;
	}

	public String getWebpanelPortNumber() {
		return webpanelPortNumber;
	}

	public void setWebpanelPortNumber(String webpanelPortNumber) {
		this.webpanelPortNumber = webpanelPortNumber;
	}
	
	
	
	
	
	
	
	
}
