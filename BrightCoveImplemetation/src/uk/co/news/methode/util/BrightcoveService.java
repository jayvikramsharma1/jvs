package uk.co.news.methode.util;

import uk.co.news.methode.dto.AccessTokenData;
import uk.co.news.methode.dto.ClientCredentials;

public class BrightcoveService {
	public static String getAuth(ClientCredentials credentials) {
		AccessTokenData accesTokenData = null;
		try {
		  accesTokenData = BrightcoveUtils.getApiToken(credentials.getUrl()+"?grant_type=client_credentials", credentials.getClientId(), credentials.getClientSecret());
		}
		catch (Exception e) {
			System.out.println("#### Oauth Client Key : " + credentials.getClientId());
			System.out.println("#### OAuth Client Secret : " + credentials.getClientSecret());
			System.out.println("#### Access Token : " + accesTokenData);
			e.printStackTrace();
		}
		return accesTokenData.access_token;
	}
}
