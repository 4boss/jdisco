package org.phbs.discogs;

import org.phbs.discogs.pojo.*;
import org.phbs.discogs.exceptions.*;

import org.apache.commons.lang.StringUtils;

public class DiscogsCommons
{
    public static final String CONSUMER_KEY = "ConsumerKey";
    public static final String SECRET_KEY = "SecretKey";
    public static final String SEARCH_URL = "SearchURL";
    public static final String ARTIST_URL = "ArtistURL";
    public static final String RELEASE_URL = "ReleaseURL";
    public static final String MASTER_URL = "MasterURL";
    public static final String LABEL_URL = "LabelURL";
    public static final String IMAGE_URL = "ImageURL";
    public static final String USER_URL = "UserURL";
    public static final String PROP_FILE_NAME = "disco.properties";
    public static final String USER_AGENT = "metag/1.0 +http://google.com";

    public static final String HEADER_LIMIT_TYPE = "X-RateLimit-Type";
    public static final String HEADER_LIMIT_LIMIT = "X-RateLimit-Limit";
    public static final String HEADER_LIMIT_REMAINING = "X-RateLimit-Remaining";
    public static final String HEADER_LIMIT_RESET = "X-RateLimit-Reset";

    public static final int CODE_OK = 200;
    public static final int CODE_CREATED = 201;
    public static final int CODE_NO_CONTENT = 204;
    public static final int CODE_UNAUTH = 401;
    public static final int CODE_FORBIDDEN = 403;
    public static final int CODE_NOT_FOUND = 404;
    public static final int CODE_METH_IS_NOT_ALLOWED = 405;
    public static final int CODE_UNPROCESSABLE = 422;
    public static final int CODE_INTERNAL_ERR = 500;

    public static <T extends DiscogsEntity> String getDiscogsSearchType(Class<T> type)
    {
	switch(type.getSimpleName())
	{
	    case "DiscogsArtist":
		return "artist";
	    case "DiscogsRelease":
		return "release";
	    case "DiscogsMasterRelease":
		return "master";
	    case "DiscogsLabel":
		return "label";
	}

	return StringUtils.EMPTY;
    }

    //TODO rewrite, add detailed description to Exception from resp body 
    public static void validateResponse(int code) throws DiscogsApiException
    {
	if(code == CODE_OK) return;

	switch(code)
	{
	    case CODE_UNAUTH:
		throw new DiscogsUnauthorizedException("Code:" + CODE_UNAUTH + 
                                  ". Requested resource requires authorization.");

	    case CODE_FORBIDDEN:
		throw new DiscogsInternalException("Code:" + CODE_FORBIDDEN + 
                                  ". Trying to operate with protected resources.");
	    
            case CODE_NOT_FOUND:
		throw new DiscogsInternalException("Code:" + CODE_NOT_FOUND + 
                                  ". The resource you requested doesn’t exist."); 
	    
	    case CODE_METH_IS_NOT_ALLOWED:
		throw new DiscogsInternalException("Code:" + CODE_METH_IS_NOT_ALLOWED +
						   ". Operation is not allowed.");
	    
	    case CODE_UNPROCESSABLE:
		throw new DiscogsInternalException("Code:" + CODE_UNPROCESSABLE +
						   ". Request validation failed.");
	   
	    case CODE_INTERNAL_ERR:
		throw new DiscogsInternalException("Code:" + CODE_INTERNAL_ERR +
						   ". Internal discogs error.");
	}
    }
}
