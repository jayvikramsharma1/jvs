package uk.co.news.methode.dto;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class AccessTokenData {
	    public final String access_token;
	    public final String token_type;
	    public final long expires_in;

	    @JsonCreator
	    public AccessTokenData(@JsonProperty("access_token") String access_token, @JsonProperty("token_type") String token_type, @JsonProperty("expires_in") long expires_in){
	        this.access_token = access_token;
	        this.token_type = token_type;
	        this.expires_in = expires_in;
	    }

		@Override
		public String toString() {
			return "AccessTokenData [access_token=" + access_token + ", token_type=" + token_type + ", expires_in="
					+ expires_in + "]";
		}
	    
	    
}
