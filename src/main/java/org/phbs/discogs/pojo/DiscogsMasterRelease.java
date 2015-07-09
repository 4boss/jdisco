package org.phbs.discogs.pojo;

import org.apache.commons.lang.StringUtils;
import java.util.List;

public class DiscogsMasterRelease extends DiscogsEntity
{
    private long id;
    private String title;
    private String resource_url;
    private String versions_url;
    private String uri;
    private int main_release;
    private String main_release_url;
    private short year;
    private List<String> styles;
    private List<String> genres;
    private String data_quality;
    private List<DiscogsArtist> artists;
    private List<DiscogsImage> images;
    private List<DiscogsTrack> tracklist;
    private List<DiscogsVideo> videos;

    public DiscogsMasterRelease()
    {}

    public long getId()
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

    public List<String> getStyles()
    {
	return this.styles;
    }

    public List<String> getGenres()
    {
	return this.genres;
    }
    
    public String getDataQuality()
    {
	return this.data_quality;
    }
    
    public List<DiscogsArtist> getArtists()
    {
	return this.artists;
    }

    public List<DiscogsImage> getImages()
    {
	return this.images;
    }
    
    public List<DiscogsTrack> getTracklist()
    {
	return this.tracklist;
    }

    public List<DiscogsVideo> getVideos()
    {
	return this.videos;
    }

    public void setId(long id)
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

    public void setStyles(List<String> styles)
    {
	this.styles = styles;
    }

    public void setGenres(List<String> genres)
    {
	this.genres = genres;
    }

    public void setDataQuality(String data_quality)
    {
	this.data_quality = data_quality;
    }
    
    public void setArtists(List<DiscogsArtist> artists)
    {
	this.artists = artists;
    }

    public void setImages(List<DiscogsImage> images)
    {
	this.images = images;
    }
    
    public void setTracklist(List<DiscogsTrack> tracklist)
    {
	this.tracklist = tracklist;
    }

    public void setVideos(List<DiscogsVideo> videos)
    {
	this.videos = videos;
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
	    .append("Tracklist: \n").append(StringUtils.join(getTracklist(), "\n")).append("\n")
	    .append("Videos: \n").append(StringUtils.join(getVideos(), "\n")).append("\n")
	    .append("#############################");
	
	return builder.toString();
    }

    public class DiscogsTrack
    {
	private String duration;
	private String position;
	private String title;
	private String type_;

	public DiscogsTrack()
	{}

	public String getType_()
	{
	    return this.type_;
	}

	public void setType_(String type_)
	{
	    this.type_ = type_;
	}

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

	public void setPosition(String position)
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
