package org.phbs.discogs.pojo;

import org.apache.commons.lang.StringUtils;

public class DiscogsMasterRelease extends DiscogsEntity
{
    private int id;
    private String title;
    private String resource_url;
    private String versions_url;
    private String uri;
    private int main_release;
    private String main_release_url;
    private short year;
    private String[] styles;
    private String[] genres;
    private String data_quality;
    private DiscogsVideo[] videos;
    private DiscogsArtist[] artists;
    private DiscogsImage[] images;
    private DiscogsTrack[] tracklist;

    public DiscogsMasterRelease()
    {}

    public int getId()
    {
	return this.id;
    }

    protected String getID()
    {
	return getId() + "";
    }

    public String getTitle()
    {
	return this.title;
    }

    public String getResourceUrl()
    {
	return this.resource_url;
    }
    
    public String getVersionsUrl()
    {
	return this.versions_url;
    }

    public String getUri()
    {
	return this.uri;
    }

    public int getMainRelease()
    {
	return this.main_release;
    }

    public String getMainReleaseUrl()
    {
	return this.main_release_url;
    }

    public short getYear()
    {
	return this.year;
    }

    public String[] getStyles()
    {
	return this.styles;
    }

    public String[] getGenres()
    {
	return this.genres;
    }
    
    public String getDataQuality()
    {
	return this.data_quality;
    }

    public DiscogsVideo[] getVideos()
    {
	return this.videos;
    }
    
    public DiscogsArtist[] getArtists()
    {
	return this.artists;
    }

    public DiscogsImage[] getImages()
    {
	return this.images;
    }
    
    public DiscogsTrack[] getTracklist()
    {
	return this.tracklist;
    }

    public void setId(int id)
    {
	this.id = id;
    }

    public void setTitle(String title)
    {
	this.title = title;
    }

    public void setResourceUrl(String resource_url)
    {
	this.resource_url = resource_url;
    }
    
    public void setVersionsUrl(String versions_url)
    {
	this.versions_url = versions_url;
    }
    
    public void setUri(String uri)
    {
	this.uri = uri;
    }
    
    public void setMainRelease(int main_release)
    {
	this.main_release = main_release;
    }

    public void setMainReleaseUrl(String main_release_url)
    {
	this.main_release_url = main_release_url;
    }

    public void setYear(short year)
    {
	this.year = year;
    }

    public void setStyles(String[] styles)
    {
	this.styles = styles;
    }

    public void setGenres(String[] genres)
    {
	this.genres = genres;
    }

    public void setDataQuality(String data_quality)
    {
	this.data_quality = data_quality;
    }

    public void setDiscogsVideos(DiscogsVideo[] videos)
    {
	this.videos = videos;
    }
    
    public void setArtists(DiscogsArtist[] artists)
    {
	this.artists = artists;
    }

    public void setImages(DiscogsImage[] images)
    {
	this.images = images;
    }
    
    public void setTracklist(DiscogsTrack[] tracklist)
    {
	this.tracklist = tracklist;
    }

    public String toString()
    {
	StringBuilder builder = new StringBuilder("############Discogs Master Release############");
	builder.append("Id: ").append(getId()).append("\n")
	    .append("Title: ").append(getTitle()).append("\n")
	    .append("ResourceUrl: ").append(getResourceUrl()).append("\n")
	    .append("VersionsUrl: ").append(getVersionsUrl()).append("\n")
	    .append("Uri: ").append(getUri()).append("\n")
	    .append("MainRelease: ").append(getMainRelease()).append("\n")
	    .append("MainReleaseUrl: ").append(getMainReleaseUrl()).append("\n")
	    .append("DataQuality: ").append(getDataQuality()).append("\n")
	    .append("Year: ").append(getYear()).append("\n")
	    .append("Styles: ").append(StringUtils.join(getStyles(),',')).append("\n")
	    .append("Genres: ").append(StringUtils.join(getGenres(),',')).append("\n")
	    .append("Artists: \n").append(StringUtils.join(getArtists(), "\n")).append("\n")
	    .append("Images: \n").append(StringUtils.join(getImages(), "\n")).append("\n")
	    .append("Videos: \n").append(StringUtils.join(getVideos(), "\n")).append("\n")
	    .append("Tracklist: \n").append(StringUtils.join(getTracklist(), "\n")).append("\n")
	    .append("#############################");
	
	return builder.toString();
    }

    public class DiscogsTrack
    {
	private String duration;
	private String position;
	private String title;

	public DiscogsTrack()
	{}

	public String getDuration()
	{
	    return this.duration;
	}

	public String getPosition()
	{
	    return this.position;
	}

	public String getTitle()
	{
	    return this.title;
	}

	public void setDuration(String duration)
	{
	    this.duration = duration;
	}

	public void setPosistion(String position)
	{
	    this.position = position;
	}

	public void setTitle()
	{
	    this.title = title;
	}

	public String toString()
	{
	    StringBuilder sb = new StringBuilder(getPosition());
	    return sb.append(". ").append(getTitle()).append(" - ").append(getDuration()).toString();
	}

    }

    public class DiscogsVideo
    {
	private String duration;
	private boolean embed;
	private String title;
	private String description;
	private String uri;
	
	public DiscogsVideo()
	{}

	public String getDuration()
	{
	    return this.duration;
	}

	public boolean getEmbed()
	{
	    return this.embed;
	}

	public String getTitle()
	{
	    return this.title;
	}

	public String getDescription()
	{
	    return this.description;
	}

	public String getUri()
	{
	    return this.uri;
	}

	public void setDuration(String duration)
	{
	    this.duration = duration;
	}

	public void setEmbed(boolean embed)
	{
	    this.embed = embed;
	}

	public void setTitle(String title)
	{
	    this.title = title;
	}

	public void setDescription(String description)
	{
	    this.description = description;
	}

	public void setUri(String uri)
	{
	    this.uri = uri;
	}

	public String toString()
	{
	    StringBuilder builder = new StringBuilder("##########Discogs Video##########\n");
	    builder.append("Duration: ").append(getDuration()).append("\n")
		.append("Is Embed? ").append(getEmbed()).append("\n")
		.append("Title: ").append(getTitle()).append("\n")
		.append("Description: ").append(getDescription()).append("\n")
		.append("URI: ").append(getUri()).append("\n")
		.append("###########################");

	    return builder.toString();
	}
    }
}
