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
    
    public DiscogsArtist getArtist(long id) throws DiscogsApiException
    {
	return getEntity(id+"", DiscogsArtist.class);
    }

    public DiscogsRelease getRelease(long id) throws DiscogsApiException
    {
	return getEntity(id+"", DiscogsRelease.class);
    }
    
    public DiscogsMasterRelease getMaster(long id) throws DiscogsApiException
    {
	return getEntity(id+"", DiscogsMasterRelease.class);
    }

    public DiscogsLabel getLabel(long id) throws DiscogsApiException
    {
	return getEntity(id+"", DiscogsLabel.class);
    }

    public DiscogsUser getUser(String name) throws DiscogsApiException
    {
	return getEntity(name, DiscogsUser.class);	
    }
}
