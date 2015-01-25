package org.phbs.discogs.pojo;

import org.apache.commons.lang.StringUtils;

public class DiscogsArtist extends DiscogsEntity
{
    private int id;
    private String name;
    private String resource_url;
    private String releases_url;
    private String uri;
    private String realname;
    private String profile;
    private String data_quality;
    private String[] namevariations;
    private String[] urls;
    private DiscogsImage[] images;

    public DiscogsArtist()
    {
    }

    public int getId()
    {
	return this.id;
    }

    protected String getID()
    {
	return getId() + "";
    }

    public String getName()
    {
	return this.name;
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

    public String getRealName()
    {
	return this.realname;
    }

    public String getProfile()
    {
	return this.profile;
    }

    public String getDataQuality()
    {
	return this.data_quality;
    }

    public String[] getNameVariations()
    {
	return this.namevariations;
    }

    public String[] getUrls()
    {
	return this.urls;
    }

    public DiscogsImage[] getImages()
    {
	return this.images;
    }

    public void setId(int id)
    {
	this.id = id;
    }

    public void setName(String name)
    {
	this.name = name;
    }

    public void setResourceUrl(String resource_url)
    {
	this.resource_url = resource_url;
    }

    public void  setReleasesUrl(String releases_url)
    {
	this.releases_url = releases_url;
    }

    public void setUri(String uri)
    {
	this.uri = uri;
    }

    public void setRealName(String realname)
    {
	this.realname = realname;
    }

    public void setProfile(String profile)
    {
	this.profile = profile;
    }

    public void setDataQuality(String data_qaulity)
    {
	this.data_quality = data_quality;
    }

    public void setNameVariations(String[] namevariations)
    {
	this.namevariations = namevariations;
    }

    public void setUrls(String[] urls)
    {
	this.urls = urls;
    }

    public void setImages(DiscogsImage[] images)
    {
	this.images = images;
    }

    public String toString()
    {
	StringBuilder builder = new StringBuilder("###########Discogs Artist###########\n");
	builder.append("Id: ").append(getId()).append("\n")
	    .append("Name: ").append(getName()).append("\n")
	    .append("ResourceUrl: ").append(getResourceUrl()).append("\n")
	    .append("ReleaseUrl: ").append(getReleasesUrl()).append("\n")
	    .append("Uri: ").append(getUri()).append("\n")
	    .append("RealName: ").append(getRealName()).append("\n")
	    .append("Profile: ").append(getProfile()).append("\n")
	    .append("DataQuality: ").append(getDataQuality()).append("\n")
	    .append("NameVariations: ").append(StringUtils.join(getNameVariations(),',')).append("\n")
	    .append("Urls: ").append(StringUtils.join(getUrls(),',')).append("\n")
	    .append("Images: ").append(StringUtils.join(getImages(),"\n")).append("\n")
	    .append("###########################");

	return builder.toString();

    }
}
