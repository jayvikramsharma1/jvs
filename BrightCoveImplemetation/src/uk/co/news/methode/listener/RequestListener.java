package uk.co.news.methode.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.apache.log4j.Logger;

import uk.co.news.methode.dto.BrightcoveApiResponse;
import uk.co.news.methode.dto.ClientCredentials;
import uk.co.news.methode.servlets.BrightcoveAPIServlet;
import uk.co.news.methode.util.BrightcoveService;

public class RequestListener implements ServletRequestListener {
	Logger logger = Logger.getLogger(RequestListener.class);

	public void requestInitialized(ServletRequestEvent event) {
		boolean _tokenExpired = (Boolean) event.getServletContext().getAttribute("_tokenExpired");
		logger.debug("########### Token Expired ##########   " + _tokenExpired);
		if (_tokenExpired) {
			event.getServletContext().setAttribute("_tokenExpired", false);
			event.getServletContext().setAttribute("credentials",
					prepareRespose(getCredentials(event.getServletContext())));
		}
		event.getServletRequest().setAttribute("credential", getCredentials(event.getServletContext()));
	}

	public void requestDestroyed(ServletRequestEvent event) {

	}

	private ClientCredentials getCredentials(ServletContext context) {
		logger.debug("brightcove_client_id : " + context.getInitParameter("brightcove_client_id").toString());
		logger.debug("brightcove_client_secret : " + context.getInitParameter("brightcove_client_secret").toString());
		logger.debug("brightcove_auth_url : " + context.getInitParameter("brightcove_auth_url").toString());
		logger.debug("brightcove_account_id : " + context.getInitParameter("brightcove_account_id").toString());
		logger.debug("brightcove_cms_video_url : " + context.getInitParameter("brightcove_cms_video_url").toString());
		logger.debug("brightcove_cms_video_count_url : "
				+ context.getInitParameter("brightcove_cms_video_count_url").toString());
		ClientCredentials clientCredentials = null;
		try {
			clientCredentials = new ClientCredentials();
			clientCredentials.setClientId(context.getInitParameter("brightcove_client_id").toString());
			clientCredentials.setClientSecret(context.getInitParameter("brightcove_client_secret").toString());
			clientCredentials.setUrl(context.getInitParameter("brightcove_auth_url").toString());
			clientCredentials.setAccountId(context.getInitParameter("brightcove_account_id").toString());
			clientCredentials.setCmsURl(context.getInitParameter("brightcove_cms_video_url").toString());
			clientCredentials
					.setCmsVideoCountURL(context.getInitParameter("brightcove_cms_video_count_url").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientCredentials;
	}

	private BrightcoveApiResponse prepareRespose(ClientCredentials credentials) {
		BrightcoveApiResponse apiResponse = null;
		try {
			logger.debug("Listener Access Token : " + BrightcoveService.getAuth(credentials));
			logger.debug("Listener CMS URL  : "
					+ credentials.getCmsURl().replace(":account-id", credentials.getAccountId()));
			logger.debug("Listener Video Count URL  : "
					+ credentials.getCmsVideoCountURL().replace(":account-id", credentials.getAccountId()));

			apiResponse = new BrightcoveApiResponse();
			apiResponse.setAccessToken(BrightcoveService.getAuth(credentials));
			apiResponse.setCmsURL(credentials.getCmsURl().replace(":account-id", credentials.getAccountId()));
			apiResponse.setCmsVideoCountURL(
					credentials.getCmsVideoCountURL().replace(":account-id", credentials.getAccountId()));
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return apiResponse;
	}
}
