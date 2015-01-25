package org.phbs.discogs.pojo;

public class DiscogsUser extends DiscogsEntity
{
    private String profile;
    private String wantlist_url;
    private String rank;
    private int num_pending;
    private int id;
    private int num_for_sale;
    private String home_page;
    private String location;
    private String collection_folders_url;
    private String username;
    private String collection_fields_url;
    private int releases_contributed;
    private String registered;
    private String rating_avg;
    private int num_collection;
    private int releases_rated;
    private int num_lists;
    private String name;
    private int num_wantlist;
    private String inventory_url;
    private String uri;
    private String resource_url;

    public DiscogsUser()
    {}

    public String getID()
    {
	StringBuilder builder = new StringBuilder(getUsername());
	return  builder.append(getId()).toString();
    }

    public String getProfile()
    {
	return this.profile;
    }

    public String getWantlistUrl()
    {
	return this.wantlist_url;
    }

    public String getRank()
    {
	return this.rank;
    }

    public int getNumPending()
    {
	return this.num_pending;
    }

    public int getId()
    {
	return this.id;
    }

    public int getNumForSale()
    {
	return this.num_for_sale;
    }

    public String getHomePage()
    {
	return this.home_page;
    }

    public String getLocation()
    {
	return this.location;
    }

    public String getCollectionFoldersUrl()
    {
	return this.collection_folders_url;
    }

    public String getUsername()
    {
	return this.username;
    }

    public String getCollectionFieldsUrl()
    {
	return this.collection_fields_url;
    }

    public int getReleasesContributed()
    {
	return this.releases_contributed;
    }

    public String getRegistered()
    {
	return this.registered;
    }

    public String getRatingAvg()
    {
	return this.rating_avg;
    }

    public int getNumCollection()
    {
	return this.num_collection;
    }

    public int getReleasesRated()
    {
	return this.releases_rated;
    }

    public int getNumLists()
    {
	return this.num_lists;
    }

    public String getName()
    {
	return this.name;
    }

    public int getNumWantlist()
    {
	return this.num_wantlist;
    }

    public String getInventoryUrl()
    {
	return this.inventory_url;
    }

    public String getUri()
    {
	return this.uri;
    }

    public String getResourceUrl()
    {
	return this.resource_url;
    }

    public void setProfile(String profile)
    {
	this.profile = profile;
    }

    public void setWantlistUrl(String wantlist_url)
    {
	this.wantlist_url = wantlist_url;
    }

    public void setRank(String rank)
    {
	this.rank = rank;
    }

    public void setNumPending(int num_pending)
    {
	this.num_pending = num_pending;
    }

    public void setId(int id)
    {
	this.id = id;
    }

    public void setNumForSale(int num_for_sale)
    {
	this.num_for_sale = num_for_sale;
    }

    public void setHomePage(String home_page)
    {
	this.home_page = home_page;
    }

    public void setLocation(String location)
    {
	this.location = location;
    }

    public void setCollectionFoldersUrl(String collection_folders_url)
    {
	this.collection_folders_url = collection_folders_url;
    }

    public void setUsername(String username)
    {
	this.username = username;
    }

    public void setCollectionFieldsUrl(String collection_fields_url)
    {
	this.collection_fields_url = collection_fields_url;
    }

    public void setReleasesContributed(int releases_contributed)
    {
	this.releases_contributed = releases_contributed;
    }

    public void setRegistered(String registered)
    {
	this.registered = registered;
    }

    public void setRatingAvg(String rating_avg)
    {
	this.rating_avg = rating_avg;
    }

    public void setNumCollection(int num_collection)
    {
	this.num_collection = num_collection;
    }

    public void setReleasesRated(int releases_rated)
    {
	this.releases_rated = releases_rated;
    }

    public void setNumLists(int num_lists)
    {
	this.num_lists = num_lists;
    }

    public void setName(String name)
    {
	this.name = name;
    }

    public void setNumWantlist(int num_wantlist)
    {
	this.num_wantlist = num_wantlist;
    }

    public void setInventoryUrl(String inventory_url)
    {
	this.inventory_url = inventory_url;
    }

    public void setUri(String uri)
    {
	this.uri = uri;
    }

    public void setResourceUrl(String resource_url)
    {
	this.resource_url = resource_url;
    }

    public String toString()
    {
	StringBuilder builder = new StringBuilder("#############Discogs User#############\n");
	builder.append("ID:").append(getID()).append("\n").
            append("Profile:").append(getProfile()).append("\n").
	    append("WantlistUrl:").append(getWantlistUrl()).append("\n").
	    append("Rank:").append(getRank()).append("\n").
	    append("NumPending:").append(getNumPending()).append("\n").
	    append("id:").append(getId()).append("\n").
	    append("NumForSale:").append(getNumForSale()).append("\n").
	    append("HomePage:").append(getHomePage()).append("\n").
	    append("Location:").append(getLocation()).append("\n").
	    append("CollectionFoldersUrl:").append(getCollectionFoldersUrl()).append("\n").
	    append("Username:").append(getUsername()).append("\n").
	    append("CollectionFieldsUrl:").append(getCollectionFieldsUrl()).append("\n").
	    append("ReleasesContributed:").append(getReleasesContributed()).append("\n").
	    append("Registered:").append(getRegistered()).append("\n").
	    append("RatingAvg:").append(getRatingAvg()).append("\n").
	    append("NumCollection:").append(getNumCollection()).append("\n").
	    append("ReleasesRated:").append(getReleasesRated()).append("\n").
	    append("NumLists:").append(getNumLists()).append("\n").
	    append("getName:").append(getName()).append("\n").
	    append("NumWantList:").append(getNumWantlist()).append("\n").
	    append("InventoryUrl:").append(getInventoryUrl()).append("\n").
	    append("Uri:").append(getUri()).append("\n").
	    append("ResourceUrl:").append(getResourceUrl()).append("\n").
	    append("################################");

	return builder.toString();
    }
}
