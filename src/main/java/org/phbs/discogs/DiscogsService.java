package org.phbs.discogs;

import org.phbs.discogs.pojo.*;
import org.phbs.discogs.exceptions.*;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

import com.google.gson.reflect.TypeToken;

public class DiscogsService extends DiscogsCoreService
{
    public DiscogsService()
    {
	super();
    }
    
    public DiscogsArtist getArtist(int id) throws DiscogsApiException
    {
	return getEntity(id+"", DiscogsArtist.class);
    }

    public DiscogsRelease getRelease(int id) throws DiscogsApiException
    {
	return getEntity(id+"", DiscogsRelease.class);
    }
    
    public DiscogsMasterRelease getMaster(int id) throws DiscogsApiException
    {
	return getEntity(id+"", DiscogsMasterRelease.class);
    }

    public DiscogsLabel getLabel(int id) throws DiscogsApiException
    {
	return getEntity(id+"", DiscogsLabel.class);
    }

    public DiscogsUser getUser(String name) throws DiscogsApiException
    {
	return getEntity(name, DiscogsUser.class);	
    }
    
    public DiscogsImage getImage(String name) throws DiscogsApiException
    {
	return null;
    }

    public DiscogsImage getImage(DiscogsImage image) throws DiscogsApiException
    {
	return image;
    }

    public List<DiscogsArtist> findArtists(String name) throws DiscogsApiException
    {
	Map<String, String> params = new HashMap<>();
	params.put("type", "artist");
	params.put("title", name);
	TypeToken typeToken = new TypeToken<DiscogsSearchResult<DiscogsArtist>>(){};
	return findEntity(params, DiscogsArtist.class, typeToken.getType());
    }
}
