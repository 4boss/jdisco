package org.phbs.discogs;

import org.scribe.builder.*;
import org.scribe.builder.api.*;
import org.scribe.model.*;
import org.scribe.oauth.*;
import org.scribe.exceptions.*;
import java.util.*;

import org.phbs.discogs.exceptions.*;
import org.phbs.discogs.pojo.*;
import java.io.*;
import java.lang.reflect.Type;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.commons.lang.StringUtils;

import org.apache.log4j.Logger;

import com.google.gson.reflect.TypeToken;

public class DiscogsOAuthService extends DiscogsCoreService {

    private String auth_url;
    private Token access_token;
    private Token request_token;
    private OAuthService oa_service;
    private String oauth_init_error;
    private DiscogsKeysProxy keyProxy;

    private static final Logger log = Logger.getLogger(DiscogsOAuthService.class);

    public DiscogsOAuthService(DiscogsKeysProxy keyProxy) {
	super();
        this.keyProxy = keyProxy;
	initOAuth(keyProxy);
    }

    private void initOAuth(DiscogsKeysProxy keyProxy)
    {
	log.info("Preauthorization...");
	try
	{
	    if(this.oa_service == null)
	    {
		    this.oa_service = new ServiceBuilder().provider(DiscoApiEnvelope.class)
			                                  .apiKey(keyProxy.getConsumerKey())
			                                  .apiSecret(keyProxy.getSecretKey())
                                                          .build();

		    this.request_token = this.oa_service.getRequestToken();
		    this.auth_url = this.oa_service.getAuthorizationUrl(this.request_token);
	    }
	}
	catch(OAuthException e)
	{
	    log.error(e);
	    this.oauth_init_error = e.getMessage();
	}

	if(log.isInfoEnabled())
	    log.info("Auth URL:" + getAuthURL());
    }

    public String getOuathInitErrorMessage()
    {
	return this.oauth_init_error;
    }

    public void authorize(String sequence)
    {
	Verifier verifier = new Verifier(sequence);
	this.access_token = this.oa_service.getAccessToken(this.request_token, verifier);
    }

    public String getAuthURL()
    {
	return this.auth_url;
    }

    public boolean isAuthorized()
    {
	return access_token != null;
    }

    protected InputStream sendRequest(String destination, Map<String, String> parameters)
	throws DiscogsApiException 
    {
	log.info("send OAuth request.");
	
	OAuthRequest request = new OAuthRequest(Verb.GET, destination);
	request.addHeader(CoreProtocolPNames.USER_AGENT, DiscogsCommons.USER_AGENT);
	if(parameters != null && !parameters.isEmpty())
	{
	    for(String key : parameters.keySet())
	    {
		if(key == null) continue;
		if(parameters.get(key) == null) continue;
		request.addQuerystringParameter(key, parameters.get(key));
	    }
	}
	
	this.oa_service.signRequest(this.access_token, request);
	Response response = request.send();

	DiscogsCommons.validateResponse(response.getCode());

	return response.getStream();
    }

    private <T extends DiscogsEntity> List<T> findEntity(Map<String, String> parameters, Class<T> type, Type typeToken)
	throws DiscogsApiException
    {
	DiscogsSearchResult<T> result = null;
	try(InputStream stream = sendRequest(getEndpoint(DiscogsSearchResult.class), parameters);
	    Reader inReader = new BufferedReader(new InputStreamReader(stream));)
        {
	    result = this.gson.fromJson(inReader, typeToken);
	}
	catch(IOException e)
        {
	    throw new DiscogsApiException("Error during sending request. ",e);
	}
	
	List<T> resultList = Collections.emptyList();
	if(result.getResults() != null)
	    resultList = result.getResults();

	if(log.isDebugEnabled())
	{
	    StringBuilder logResults = new StringBuilder("Found ");
	    logResults.append(resultList.size())
		.append(" entities ")
		.append(type.getName())
		.append(" by params:\n")
		.append(StringUtils.join(parameters.entrySet(), "\n"))
		.append("Results: \n");
	    for(T entity : resultList)
	    {
		logResults.append(entity.toString()).append("\n");
	    }

	    log.debug(logResults.toString());
	}

	return resultList;
    }

    public List<DiscogsArtist> findArtists(String name) throws DiscogsApiException
    {
	Map<String, String> params = new HashMap<>();
	params.put("type", "artist");
	params.put("title", name);
	TypeToken typeToken = new TypeToken<DiscogsSearchResult<DiscogsArtist>>(){};
	return findEntity(params, DiscogsArtist.class, typeToken.getType());
    }

    public List<DiscogsRelease> findReleases(String name) throws DiscogsApiException
    {
	Map<String, String> params = new HashMap<>();
	params.put("type", "release");
	params.put("title", name);
	TypeToken typeToken = new TypeToken<DiscogsSearchResult<DiscogsRelease>>(){};
	return findEntity(params, DiscogsRelease.class, typeToken.getType());
    }

    public List<DiscogsLabel> findLabels(String name) throws DiscogsApiException
    {
	Map<String, String> params = new HashMap<>();
	params.put("type", "label");
	params.put("title", name);
	TypeToken typeToken = new TypeToken<DiscogsSearchResult<DiscogsLabel>>(){};
	return findEntity(params, DiscogsLabel.class, typeToken.getType());
    }

    public DiscogsImage getImage(String name) throws DiscogsApiException
    {
	//TODO impl
	return null;
    }

    public DiscogsImage getImage(DiscogsImage image) throws DiscogsApiException
    {
	//TODO IMPL
	return image;
    }
}
