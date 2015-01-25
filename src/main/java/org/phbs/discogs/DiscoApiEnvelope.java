package org.phbs.discogs;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

public class DiscoApiEnvelope extends DefaultApi10a
{

    private static String TOKEN_URL = "http://api.discogs.com/oauth/request_token";
    private static String ACCESS_URL = "http://api.discogs.com/oauth/access_token";
    private static String AUTH_URL = "http://www.discogs.com/oauth/authorize?oauth_token=%s";

    public String getRequestTokenEndpoint()
    {
	return TOKEN_URL;
    }
	
    public String getAccessTokenEndpoint()
    {
	return ACCESS_URL;
    }

    public String getAuthorizationUrl(Token requestToken)
    {
	return String.format(AUTH_URL, requestToken.getToken());
    }
}
