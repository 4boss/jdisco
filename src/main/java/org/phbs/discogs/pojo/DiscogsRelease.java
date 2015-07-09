package org.phbs.discogs.pojo;

import org.apache.commons.lang.StringUtils;
import java.util.List;
import org.phbs.discogs.pojo.DiscogsMasterRelease.DiscogsTrack;
import org.phbs.discogs.pojo.DiscogsMasterRelease.DiscogsVideo;

public class DiscogsRelease extends DiscogsEntity
{
    private long id;
    private short year;
    private List<String> styles;
    private List<String> genres;
    private List<DiscogsArtist> artists;
    private List<DiscogsImage> images;
    private List<DiscogsTrack> tracklist;
    private short format_quantity;
    private String title;
    private String date_added;
    private String data_quality;
    private short estimated_weight;
    private String resource_url;
    private String uri;
    private String date_changed;
    private String thumb;
    private List<String> series;
    private String status;
    private List<DiscogsVideo> videos;
    private String country;
    private String released;
    private String released_formatted;
    private String notes;
    private DiscogsCommunity community;
    private List<DiscogsLabel> labels;
    private List<DiscogsLabel> companies;
    private List<DiscogsArtist> extraartists;
    private List<DiscogsFormat> formats;
    private List<DiscogsIdentifier> identifiers;
    private long master_id;
    private String master_url;
    
    public DiscogsRelease()
    {}

    public long getId()
    {
	return this.id;
    }

    protected String getID()
    {
	return getId() + "";
    }

    public long getMasterId()
    {
	return this.master_id;
    }

    public String getMasterUrl()
    {
	return this.master_url;
    }

    public List<String> getStyles()
    {
	return this.styles;
    }

    public List<String> getGenres()
    {
	return this.genres;
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

    public short getFormatQuantity()
    {
	return this.format_quantity;
    }

    public String getTitle()
    {
	return this.title;
    }

    public String getDateAdded()
    {
	return this.date_added;
    }

    public short getEstimatedWeight()
    {
	return this.estimated_weight;
    }

    public String getResourceUrl()
    {
	return this.resource_url;
    }

    public String getUri()
    {
	return this.uri;
    }

    public String getDateChanged()
    {
	return this.date_changed;
    }

    public String getThumb()
    {
	return this.thumb;
    }

    public List<String> getSeries()
    {
	return this.series;
    }

    public short getYear()
    {
	return this.year;
    }

    public List<DiscogsVideo> getVideos()
    {
	return this.videos;
    }

    public String getStatus()
    {
	return this.status;
    }

    public String getCountry()
    {
	return this.country;
    }

    public String getReleased()
    {
	return this.released;
    }

    public String getReleasedFormatted()
    {
	return this.released_formatted;
    }

    public String getDataQuality()
    {
	return this.data_quality;
    }
    
    public String getNotes()
    {
	return this.notes;
    }

    public DiscogsCommunity getCommunity()
    {
	return this.community;
    }

    public List<DiscogsLabel> getLabels()
    {
	return this.labels;
    }

    public List<DiscogsLabel> getCompanies()
    {
	return this.companies;
    }

    public List<DiscogsArtist> getExtraArtists()
    {
	return this.extraartists;
    }

    public List<DiscogsFormat> getFormats()
    {
	return this.formats;
    }

    public List<DiscogsIdentifier> getIdentifiers()
    {
	return this.identifiers;
    }

    public void setId(long id)
    {
	this.id = id;
    }

    public void setMasterId(long master_id)
    {
	this.master_id = master_id;
    }

    public void setMasterUrl(String master_url)
    {
	this.master_url = master_url;
    }

    public void setStyles(List<String> styles)
    {
	this.styles = styles;
    }

    public void setGenres(List<String> genres)
    {
	this.genres = genres;
    }

    public void setImages(List<DiscogsImage> images)
    {
	this.images = images;
    }

    public void setTracklist(List<DiscogsTrack> tracklist)
    {
	this.tracklist = tracklist;
    }

    public void setFormatQuantity(short format_quantity)
    {
	this.format_quantity = format_quantity;
    }

    public void setTitle(String title)
    {
	this.title = title;
    }

    public void setDateAdded(String date_added)
    {
	this.date_added = date_added;
    }

    public void setEstimatedWeight(short estimated_weight)
    {
	this.estimated_weight = estimated_weight;
    }

    public void setResourceUrl(String resource_url)
    {
	this.resource_url = resource_url;
    }

    public void setUri(String uri)
    {
	this.uri = uri;
    }

    public void setDateChanged(String date_changed)
    {
	this.date_changed = date_changed;
    }

    public void setThumb(String thumb)
    {
	this.thumb = thumb;
    }

    public void setSeries(List<String> series)
    {
	this.series = series;
    }
    
    public void setStatus(String status)
    {
	this.status = status;
    }

    public void setArtists(List<DiscogsArtist> artists)
    {
	this.artists = artists;
    }

    public void setVideos(List<DiscogsVideo> videos)
    {
	this.videos = videos;
    }

    public void setYear(short year)
    {
	this.year = year;
    }

    public void setCountry(String country)
    {
	this.country = country;
    }

    public void setReleased(String released)
    {
	this.released = released;
    }

    public void setReleasedFormatted(String released_foramatted)
    {
	this.released_formatted = released_formatted;
    }

    public void setCommunity(DiscogsCommunity community)
    {
	this.community = community;
    }
    
    public void setNotes(String notes)
    {
	this.notes = notes;
    }
    
    public void setLabels(List<DiscogsLabel> labels)
    {
	this.labels = labels;
    }

    public void setCompanies(List<DiscogsLabel> companies)
    {
	this.companies = companies;
    }

    public void setExtraArtists(List<DiscogsArtist> extraartists)
    {
	this.extraartists = extraartists;
    }

    public void setFormats(List<DiscogsFormat> formats)
    {
	this.formats = formats;
    }

    public void setIdentifiers(List<DiscogsIdentifier> identifiers)
    {
	this.identifiers = identifiers;
    }

    public void setDataQuality(String data_quality)
    {
	this.data_quality = data_quality;
    }

    public String toString()
    {
	StringBuilder builder = new StringBuilder("############Discogs Release############");
	builder.append("Id: ").append(getId()).append("\n")
	    .append("Title: ").append(getTitle()).append("\n")
	    .append("Master id: ").append(getMasterId()).append("\n")
	    .append("Master url: ").append(getMasterUrl()).append("\n")
	    .append("ResourceUrl: ").append(getResourceUrl()).append("\n")
	    .append("Uri: ").append(getUri()).append("\n")
	    .append("Status: ").append(getStatus()).append("\n")
	    .append("DataQuality: ").append(getDataQuality()).append("\n")
	    .append("Series: ").append(StringUtils.join(getSeries(),',')).append("\n")
	    .append("Country: ").append(getCountry()).append("\n")
	    .append("Year: ").append(getYear()).append("\n")
	    .append("Released: ").append(getReleased()).append("\n")
	    .append("ReleasedFormatted: ").append(getReleasedFormatted()).append("\n")
	    .append("Date added: ").append(getDateAdded()).append("\n")
	    .append("Date Changed: ").append(getDateChanged()).append("\n")
	    .append("Estimated Weight: ").append(getEstimatedWeight()).append("\n")
	    .append("Notes: ").append(getNotes()).append("\n")
	    .append("Community: \n").append(getCommunity()).append("\n")
	    .append("Styles: ").append(StringUtils.join(getStyles(),',')).append("\n")
	    .append("Genres: ").append(StringUtils.join(getGenres(),',')).append("\n")
	    .append("Labels: \n").append(StringUtils.join(getLabels(),"\n")).append("\n")
	    .append("Companies: \n").append(StringUtils.join(getCompanies(), "\n")).append("\n")
	    .append("ExtraArtists: \n").append(StringUtils.join(getExtraArtists(), "\n")).append("\n")
	    .append("Identifiers: \n").append(StringUtils.join(getIdentifiers(), "\n")).append("\n")
	    .append("Format Quantity: ").append(getFormatQuantity()).append("\n")
	    .append("Formats: \n").append(StringUtils.join(getFormats(), "\n")).append("\n")
	    .append("Artists: \n").append(StringUtils.join(getArtists(), "\n")).append("\n")
	    .append("Images: \n").append(StringUtils.join(getImages(), "\n")).append("\n")
	    .append("Thumb: \n").append(getThumb()).append("\n")
	    .append("Tracklist: \n").append(StringUtils.join(getTracklist(), "\n")).append("\n")
	    .append("#############################");
	
	return builder.toString();
    }    

    public class DiscogsFormat
    {
	private List<String> descriptions;
	private String name;
	private short qty;
	
	public DiscogsFormat()
	{}

	public List<String> getDescriptions()
	{
	    return this.descriptions;
	}

	public String getName()
	{
	    return this.name;
	}

	public short getQty()
	{
	    return this.qty;
	}

	public void setDescriptions(List<String> descriptions)
	{
	    this.descriptions = descriptions;
	}

	public void setName(String name)
	{
	    this.name = name;
	}
	
	public void setQty(short qty)
	{
	    this.qty = qty;
	}

	public String toString()
	{
	    StringBuilder builder = new StringBuilder(getName());
	    builder.append(", ").append(StringUtils.join(getDescriptions(), ','))
		.append(", ").append(getQty());

	    return builder.toString();
	}
    }

    public class DiscogsCommunity
    {
	private int have;
	private int want;
	private DiscogsUser submitter;
	private List<DiscogsUser> contributors;
	private String status;
	private DiscogsRating rating;
	private String data_quality;

	public DiscogsCommunity()
	{}

	public String getDataQuality()
	{
	    return this.data_quality;
	}

	public String getStatus()
	{
	    return this.status;
	}

	public int getHave()
	{
	    return this.have;
	}

	public int getWant()
	{
	    return this.want;
	}

	public DiscogsUser getSubmitter()
	{
	    return this.submitter;
	}

	public List<DiscogsUser> getContributors()
	{
	    return this.contributors;
	}

	public DiscogsRating getRating()
	{
	    return this.rating;
	}

	public void setDataQuality(String data_quality)
	{
	    this.data_quality = data_quality;
	}

	public void setStatus(String status)
	{
	    this.status = status;
	}

	public void setHave(int have)
	{
	    this.have = have;
	}

	public void setWant(int want)
	{
	    this.want = want;
	}

	public void setRating(DiscogsRating rating)
	{
	    this.rating = rating;
	}

	public void setSubmitter(DiscogsUser submitter)
	{
	    this.submitter = submitter;
	}

	public void setContributors(List<DiscogsUser> contributors)
	{
	    this.contributors = contributors;
	}

	public String toString()
	{
	    StringBuilder builder = new StringBuilder("Have :");
	    builder.append(getHave()).append("\n")
		.append("Want: ").append(getWant()).append("\n")
		.append("Rating: ").append(getRating()).append("\n")
		.append("Status: ").append(getStatus()).append("\n")
		.append("Contributors: ").append(StringUtils.join(getContributors(), "\n"))
		.append("Submitter: ").append(getSubmitter()).append("\n")
		.append("Data Quality: ").append(getDataQuality());
	    
	    return builder.toString();
	}
    }
    
    public class DiscogsRating
    {
	private int count;
	private double average;

	public DiscogsRating()
	{}

	public int getCount()
	{
	    return this.count;
	}

	public double getAverage()
	{
	    return this.average;
	}

	public void setCount(int count)
	{
	    this.count = count;
	}

	public void setAverage(double average)
	{
	    this.average = average;
	}

	public String toString()
	{
	    StringBuilder builder = new StringBuilder("Count: ");
	    return builder.append(getCount()).append("Average: ").append(getAverage()).toString();
	}
    }

    public class DiscogsIdentifier
    {
	private String type;
	private String description;
	private String value;

	public DiscogsIdentifier()
	{}

	public String getType()
	{
	    return this.type;
	}
	
	public String getDescription()
	{
	    return this.description;
	}

	public String getValue()
	{
	    return this.value;
	}

	public void setType(String type)
	{
	    this.type = type;
	}
	
	public void setDescription(String description)
	{
	    this.description = description;
	}

	public void setValue(String value)
	{
	    this.value = value;
	}

	public String toString()
	{
	    StringBuilder builder = new StringBuilder("Type: ");
	    builder.append(getType()).append("\n")
		.append("Description: ").append(getDescription()).append("\n")
		.append("Value: ").append(getValue());
	    
	    return builder.toString();
	}
    }
}
