package org.phbs.discogs;

import org.phbs.discogs.pojo.*;
import org.phbs.discogs.exceptions.*;

import java.util.*;


import com.google.gson.Gson;

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

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class DiscogsCoreService {

    //TODO: support discogs API limit properties
    private Map<String, String> apiLimits;
    private CloseableHttpClient defaultClient;
    private Properties properties;
    protected Gson gson;

    private static final Logger LOG = LogManager.getLogger(DiscogsCoreService.class);

    public DiscogsCoreService() {
	this(null);
    }

    public DiscogsCoreService(Properties properties) {
	this.gson = new Gson();
	loadProperties(properties);
	this.defaultClient =  HttpClients.createDefault();
    }

    private void loadProperties(Properties properties) {
	if(properties != null) {
	    
	    LOG.info("Use custom properties.");
	    this.properties = properties;

	} else {

	    this.properties = new Properties();

	    try(FileReader reader = new FileReader(DiscogsCommons.PROP_FILE_NAME);
		Reader buffReader = new BufferedReader(reader);) {

		    properties.load(buffReader);

	    } catch(IOException e) {

		LOG.info("Unable to load properties from {}. Set defaults.", 
			 DiscogsCommons.PROP_FILE_NAME);

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
    }

    protected <T extends DiscogsEntity> T getEntity(String id, Class<T> type)
	    throws DiscogsApiException {

	T entity = null;

	LOG.debug("Try to send request to {}", getEndpoint(type));

	try(InputStream stream = sendGetRequest(getEndpoint(type) + id, null);
	    Reader inReader = new BufferedReader(new InputStreamReader(stream));) {

	    entity = this.gson.fromJson(inReader, type);

	} catch(IOException e) {
	    throw new DiscogsApiException("Error during sending request. ",e);
	}

	LOG.debug("Get entity: {}\n{}", entity.getClass().getName(), entity);

	return entity;
    }

    protected InputStream sendGetRequest(String destination, Map<String, String> parameters)
	    throws DiscogsApiException {

	LOG.info("Send Default request.");
		
	URIBuilder builder = null;
	HttpGet httpget = null;
	
	try {
	    builder = new URIBuilder(destination);
	    
	    if(parameters != null)
		for(String key : parameters.keySet()) {
		    if(key == null) continue;
		    if(parameters.get(key) == null) continue;
		    builder.addParameter(key, parameters.get(key));
		}

	    URI uri = builder.build();
	    httpget = new HttpGet(uri);
	    httpget.setHeader("User-Agent", DiscogsCommons.USER_AGENT);

	    CloseableHttpResponse response = this.defaultClient.execute(httpget);

    	    DiscogsCommons.validateResponse(response.getStatusLine().getStatusCode());
	    
	    return response.getEntity().getContent();


	} catch (URISyntaxException e) {
	    throw new DiscogsApiException("Bad API urls", e);
	} catch(IOException e) {
	    throw new DiscogsApiException("Error occured while sending request", e);
	}
    }

    protected <T> String getEndpoint(Class<T> type) {

	LOG.debug("Find endpoint by type {}", type.getSimpleName());

	switch(type.getSimpleName()) {
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

    public Map<String, String> getAPILimits() {
	return this.apiLimits;
    }
}