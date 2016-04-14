package org.phbs.discogs;

import org.phbs.discogs.pojo.*;
import org.phbs.discogs.exceptions.*;
import java.util.*;

public class DiscogsReadOnlyService extends DiscogsCoreService {

    public DiscogsReadOnlyService() {
	super();
    }

    public DiscogsReadOnlyService(Properties properties) {
	super(properties);
    }
    
    public DiscogsArtist getArtist(long id) throws DiscogsApiException {
	return getEntity(String.valueOf(id), DiscogsArtist.class);
    }

    public DiscogsRelease getRelease(long id) throws DiscogsApiException {
	return getEntity(String.valueOf(id), DiscogsRelease.class);
    }
    
    public DiscogsMasterRelease getMaster(long id) throws DiscogsApiException {
	return getEntity(String.valueOf(id), DiscogsMasterRelease.class);
    }

    public DiscogsLabel getLabel(long id) throws DiscogsApiException {
	return getEntity(String.valueOf(id), DiscogsLabel.class);
    }

    public DiscogsUser getUser(String name) throws DiscogsApiException {
	return getEntity(name, DiscogsUser.class);	
    }
}
