package org.phbs.discogs.pojo;

import org.apache.commons.lang.StringUtils;

public class DiscogsRelease extends DiscogsMasterRelease
{
    private String status;
    private int master_id;
    private String master_url;
    private String country;
    private String released;
    private String released_formatted;
    private String notes;
    private DiscogsCommunity community;
    private DiscogsUser submitter;
    private DiscogsUser[] contributors;
    private DiscogsLabel[] labels;
    private DiscogsLabel[] companies;
    private DiscogsArtist[] extraartists;
    private DiscogsFormat[] formats;
    private DiscogsIdentifier[] identifiers;
    
    public DiscogsRelease()
    {}

    public String getStatus()
    {
	return this.status;
    }

    public int getMasterId()
    {
	return this.master_id;
    }

    public String getMasterUrl()
    {
	return this.master_url;
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
    
    public String getNotes()
    {
	return this.notes;
    }

    public DiscogsCommunity getCommunity()
    {
	return this.community;
    }

    public DiscogsUser getSubmitter()
    {
	return this.submitter;
    }

    public DiscogsUser[] getContributors()
    {
	return this.contributors;
    }

    public DiscogsLabel[] getLabels()
    {
	return this.labels;
    }

    public DiscogsLabel[] getCompanies()
    {
	return this.companies;
    }

    public DiscogsArtist[] getExtraArtists()
    {
	return this.extraartists;
    }

    public DiscogsFormat[] getFormats()
    {
	return this.formats;
    }

    public DiscogsIdentifier[] getIdentifiers()
    {
	return this.identifiers;
    }
    
    public void setStatus(String status)
    {
	this.status = status;
    }

    public void setMasterId(int master_id)
    {
	this.master_id = master_id;
    }

    public void setMasterUrl(String master_url)
    {
	this.master_url = master_url;
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

    public void setSubmitter(DiscogsUser submitter)
    {
	this.submitter = submitter;
    }

    public void setContributors(DiscogsUser[] contributors)
    {
	this.contributors = contributors;
    }
    
    public void setLabels(DiscogsLabel[] labels)
    {
	this.labels = labels;
    }

    public void setCompanies(DiscogsLabel[] companies)
    {
	this.companies = companies;
    }

    public void setExtraArtists(DiscogsArtist[] extraartists)
    {
	this.extraartists = extraartists;
    }

    public void setFormats(DiscogsFormat[] formats)
    {
	this.formats = formats;
    }

    public void setIdentifiers(DiscogsIdentifier[] identifiers)
    {
	this.identifiers = identifiers;
    }

    public String toString()
    {
	StringBuilder builder = new StringBuilder("############Discogs Release############");
	builder.append("Id: ").append(getId()).append("\n")
	    .append("Title: ").append(getTitle()).append("\n")
	    .append("ResourceUrl: ").append(getResourceUrl()).append("\n")
	    .append("Uri: ").append(getUri()).append("\n")
	    .append("Status: ").append(getStatus()).append("\n")
	    .append("DataQuality: ").append(getDataQuality()).append("\n")
	    .append("MasterId: ").append(getMasterId()).append("\n")
	    .append("Country: ").append(getCountry()).append("\n")
	    .append("Year: ").append(getYear()).append("\n")
	    .append("Released: ").append(getReleased()).append("\n")
	    .append("ReleasedFormatted: ").append(getReleasedFormatted()).append("\n")
	    .append("Notes: ").append(getNotes()).append("\n")
	    .append("Community: \n").append(getCommunity()).append("\n")
	    .append("Submitter: ").append(getSubmitter()).append("\n")
	    .append("Contributors: \n").append(StringUtils.join(getContributors(), "\n")).append("\n")
	    .append("Styles: ").append(StringUtils.join(getStyles(),',')).append("\n")
	    .append("Genres: ").append(StringUtils.join(getGenres(),',')).append("\n")
	    .append("Labels: \n").append(StringUtils.join(getLabels(),"\n")).append("\n")
	    .append("Companies: \n").append(StringUtils.join(getCompanies(), "\n")).append("\n")
	    .append("ExtraArtists: \n").append(StringUtils.join(getExtraArtists(), "\n")).append("\n")
	    .append("Identifiers: \n").append(StringUtils.join(getIdentifiers(), "\n")).append("\n")
	    .append("Formats: \n").append(StringUtils.join(getFormats(), "\n")).append("\n")
	    .append("Artists: \n").append(StringUtils.join(getArtists(), "\n")).append("\n")
	    .append("Images: \n").append(StringUtils.join(getImages(), "\n")).append("\n")
	    .append("Tracklist: \n").append(StringUtils.join(getTracklist(), "\n")).append("\n")
	    .append("#############################");
	
	return builder.toString();
    }    

    public class DiscogsFormat
    {
	private String[] descriptions;
	private String name;
	private short qty;
	
	public DiscogsFormat()
	{}

	public String[] getDescriptions()
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

	public void setDescriptions(String[] descriptions)
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
	private DiscogsRating rating;

	public DiscogsCommunity()
	{}

	public int getHave()
	{
	    return this.have;
	}

	public int getWant()
	{
	    return this.want;
	}

	public DiscogsRating getRating()
	{
	    return this.rating;
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

	public String toString()
	{
	    StringBuilder builder = new StringBuilder("Have :");
	    builder.append(getHave()).append("\n")
		.append("Want: ").append(getWant()).append("\n")
		.append("Rating: ").append(getRating());
	    
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