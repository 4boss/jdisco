package org.phbs.discogs;

import org.phbs.discogs.pojo.*;
import org.phbs.discogs.exceptions.*;

import java.util.*;


import com.google.gson.Gson;

import org.scribe.builder.*;
import org.scribe.builder.api.*;
import org.scribe.model.*;
import org.scribe.oauth.*;
import org.scribe.exceptions.*;

import java.net.URL;
import java.net.URI;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.io.*;
import java.nio.charset.Charset;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.HttpResponse;
import org.apache.http.HttpEntity;

import org.apache.log4j.Logger;


public class DiscogsCoreService
{
    private Map<String, List<Integer>> api_properties;
    private OAuthService oa_service;
    private DefaultHttpClient default_client;
    private Properties properties;
    private String auth_url;
    private Token access_token;
    private Token request_token;
    private Gson gson;
    private String oauth_init_error;

    private static final Logger log = Logger.getLogger(DiscogsCoreService.class);


    public DiscogsCoreService()
    {
	this.gson = new Gson();
	
	log.info("Loading properties...");
	loadProperties();
	
	log.info("Preauthorization...");
	preAuthorize();
	
	if(log.isInfoEnabled())
	    log.info("Auth URL:" + getAuthURL());
    }

    private void loadProperties()
    {
	this.properties = new Properties();
	try(FileReader reader = new FileReader(DiscogsCommons.PROP_FILE_NAME);
	    Reader buffReader = new BufferedReader(reader);)
        {
	    properties.load(buffReader);
        }
        catch(IOException e)
       {
	   if(log.isInfoEnabled())
	       log.info("Unable to load properties from " + 
			DiscogsCommons.PROP_FILE_NAME + ". Set defaults.");

	   this.properties.setProperty(DiscogsCommons.SEARCH_URL, 
                               "http://api.discogs.com/database/search");
	   this.properties.setProperty(DiscogsCommons.ARTIST_URL, 
                               "http://api.discogs.com/artists/");
	   this.properties.setProperty(DiscogsCommons.RELEASE_URL, 
                               "http://api.discogs.com/releases/");
	   this.properties.setProperty(DiscogsCommons.MASTER_URL, 
                               "http://api.discogs.com/masters/");
	   this.properties.setProperty(DiscogsCommons.LABEL_URL,
                                "http://api.discogs.com/labels/");
	   this.properties.setProperty(DiscogsCommons.IMAGE_URL,
                                "http://api.discogs.com/images/");
   	   this.properties.setProperty(DiscogsCommons.USER_URL, 
                                "http://api.discogs.com/users/");
       }
    }

    private void preAuthorize()
    {
	try
	{
	    initOAuth();
	}
	catch(OAuthException e)
	{
	    log.error(e);
	    this.oauth_init_error = e.getMessage();
	}
	finally
	{
	    initDefaultClient();
	}
    }

    private void initOAuth()
    {
	if(this.oa_service == null
	   && !StringUtils.isEmpty(this.properties.getProperty(DiscogsCommons.CONSUMER_KEY))
	   && !StringUtils.isEmpty(this.properties.getProperty(DiscogsCommons.SECRET_KEY)))
	{
	    this.oa_service = new ServiceBuilder().provider(DiscoApiEnvelope.class)
		                  .apiKey(this.properties.getProperty(DiscogsCommons.CONSUMER_KEY))
                                  .apiSecret(this.properties.getProperty(DiscogsCommons.SECRET_KEY))
                                  .build();

	    this.request_token = this.oa_service.getRequestToken();
	    this.auth_url = this.oa_service.getAuthorizationUrl(this.request_token);
	}
    }

    private void initDefaultClient()
    {
	if(this.default_client == null)
	{
	    this.default_client = new DefaultHttpClient();
	    this.default_client.getParams().setParameter(CoreProtocolPNames.USER_AGENT, DiscogsCommons.USER_AGENT);
	}
    }

    public String getOuathInitErrorMessage()
    {
	return this.oauth_init_error;
    }

    public void authorize(String sequence)
    {
	Verifier verifier = new Verifier(sequence);
	if(this.oa_service != null)
	    this.access_token = this.oa_service.getAccessToken(this.request_token, verifier);
    }

    public String getAuthURL()
    {
	initOAuth();
	return this.auth_url;
    }

    public boolean isAuthorized()
    {
	return access_token != null;
    }

    protected <T extends DiscogsEntity> T getEntity(String id, Class<T> type)
	    throws DiscogsApiException
    {
	T entity = null;

	if(log.isDebugEnabled())
	    log.debug("Try to send request to " + getEndpoint(type));

	try(InputStream stream = sendRequest(getEndpoint(type) + id, null);
	    Reader inReader = new BufferedReader(new InputStreamReader(stream));)
        {
	    entity = this.gson.fromJson(inReader, type);
	}
	catch(IOException e)
        {
	    throw new DiscogsApiException("Error during sending request. ",e);
	}

	if(log.isDebugEnabled())
	    log.debug("get entity: " + entity.getClass().getName() + " \n" + entity);

	return entity;
    }

    protected <T extends DiscogsEntity> List<T> findEntity(Map<String, String> parameters, Class<T> type, Type typeToken)
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
	    resultList = Arrays.asList(result.getResults());

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

    private InputStream sendRequest(String destination, Map<String, String> parameters)
	    throws DiscogsApiException
    {
	return isAuthorized() ? sendOAuthRequest(destination, parameters)
	                      : sendDefaultRequest(destination, parameters);
    }

    private InputStream sendOAuthRequest(String destination, Map<String, String> parameters)
	   throws DiscogsApiException
    {
	
	log.info("send OAuth request.");
	
	OAuthRequest request = new OAuthRequest(Verb.GET, destination);
	//	    request.setConnectionKeepAlive(true);
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

    private InputStream sendDefaultRequest(String destination, Map<String, String> parameters) 
	    throws DiscogsApiException
    {	
	try
	{
	    log.info("Send Default request.");
	    URIBuilder builder = new URIBuilder(destination);
	    
	    if(parameters != null && !parameters.isEmpty())
	    {
		for(String key : parameters.keySet())
		{
		    if(key == null) continue;
		    if(parameters.get(key) == null) continue;
		    builder.setParameter(key, parameters.get(key));
		}
	    }
	    URI uri = builder.build();
	    HttpGet httpget = new HttpGet(uri);
	    HttpResponse response = this.default_client.execute(httpget);

	    DiscogsCommons.validateResponse(response.getStatusLine().getStatusCode());

	    HttpEntity entity = response.getEntity();
	    
	    return entity.getContent();
	}
	catch(IOException | URISyntaxException e)
	{
	    throw new DiscogsApiException("Error occured while sending request", e);
	}
    }

    private <T> String getEndpoint(Class<T> type)
    {
	if(log.isDebugEnabled())
	    log.debug("Find endpoint by type " + type.getSimpleName());

	switch(type.getSimpleName())
	{
	    case "DiscogsArtist":
		return this.properties.getProperty(DiscogsCommons.ARTIST_URL);
	    case "DiscogsRelease":
		return this.properties.getProperty(DiscogsCommons.RELEASE_URL);
	    case "DiscogsMasterRelease":
		return this.properties.getProperty(DiscogsCommons.MASTER_URL);
            case "DiscogsImage":
		return this.properties.getProperty(DiscogsCommons.IMAGE_URL);
	    case "DiscogsLabel":
		return this.properties.getProperty(DiscogsCommons.LABEL_URL);
	    case "DiscogsUser":
		return this.properties.getProperty(DiscogsCommons.USER_URL);
	    case "DiscogsSearchResult":
	        return this.properties.getProperty(DiscogsCommons.SEARCH_URL);
	}
	
	return StringUtils.EMPTY;
    }
}
