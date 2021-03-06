package org.phbs.discogs.pojo;

import org.apache.commons.lang.StringUtils;
import java.util.List;

public class DiscogsLabel extends DiscogsEntity
{
    private long id;
    private String name;
    private String profile;
    private String resource_url;
    private String releases_url;
    private String uri;
    private String data_quality;
    private String contact_info;
    private List<DiscogsLabel> sublabels;
    private List<String> urls;
    private List<DiscogsImage> images;

    public DiscogsLabel()
    {}
    
    public long getId()
    {
	return this.id;
    }

    protected String getID()
    {
	return getId()+"";
    }

    public String getName()
    {
	return this.name;
    }

    public String getProfile()
    {
	return this.profile;
    }

    public String getResourceUrl()
    {
	return this.resource_url;
    }

    public String getReleasesUrl()
    {
	return this.releases_url;
    }

    public String getUri()
    {
	return this.uri;
    }

    public String getDataQuality()
    {
	return this.data_quality;
    }

    public String getContactInfo()
    {
	return this.contact_info;
    }

    public List<DiscogsLabel> getSublabels()
    {
	return this.sublabels;
    }
    
    public List<String> getUrls()
    {
	return this.urls;
    }

    public List<DiscogsImage> getImages()
    {
	return this.images;
    }
    
    public void setId(long id)
    {
	this.id = id;
    }

    public void setName(String name)
    {
	this.name = name;
    }

    public void setProfile(String profile)
    {
	this.profile = profile;
    }

    public void setResourceUrl(String resource_url)
    {
	this.resource_url = resource_url;
    }

    public void setReleasesUrl(String releases_url)
    {
	this.releases_url = releases_url;
    }

    public void setUri(String uri)
    {
	this.uri = uri;
    }

    public void setDataQuality(String data_quality)
    {
	this.data_quality = data_quality;
    }

    public void setContactInfo(String contact_info)
    {
	this.contact_info = contact_info;
    }

    public void setSublabels(List<DiscogsLabel> sublabels)
    {
	this.sublabels = sublabels;
    }
    
    public void setUrls(List<String> urls)
    {
	this.urls = urls;
    }

    public void setImages(List<DiscogsImage> images)
    {
	this.images = images;
    }

    public String toString()
    {
	StringBuilder builder = new StringBuilder("############Discogs Label############");
	builder.append("Id: ").append(getId()).append("\n")
	    .append("Name: ").append(getName()).append("\n")
	    .append("Profile: ").append(getProfile()).append("\n")
	    .append("ResourceUrl: ").append(getResourceUrl()).append("\n")
	    .append("ReleasesUrl: ").append(getReleasesUrl()).append("\n")
	    .append("Uri: ").append(getUri()).append("\n")
	    .append("DataQuality: ").append(getDataQuality()).append("\n")
	    .append("ContactInfo: ").append(getContactInfo()).append("\n")
	    .append("Sublabels: ").append(StringUtils.join(getSublabels(), "\n")).append("\n")
	    .append("Urls: ").append(StringUtils.join(getUrls(),"\n")).append("\n")
	    .append("Images: ").append(StringUtils.join(getImages(), "\n")).append("\n")
	    .append("#############################");
	
	return builder.toString();
    }
}
