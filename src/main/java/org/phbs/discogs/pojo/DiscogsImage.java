package org.phbs.discogs.pojo;

public class DiscogsImage extends DiscogsEntity
{
    private String type;
    private int width;
    private int height;
    private String uri;
    private String uri150;
    private String resource_url;
    private byte[] image;
    public DiscogsImage() {}
    
    protected String getID()
    {
	return getUri();
    }
    
    public String getType()
    {
	return this.type;
    }

    public int getWidth()
    {
	return this.width;
    }

    public int getHeight()
    {
	return this.height;
    }
    
    public String getUri()
    {
	return this.uri;
    }
    
    public String getUri150()
    {
	return this.uri150;
    }
    
    public String getResourceUrl()
    {
	return this.resource_url;
    }

    public byte[] getImage()
    {
	return this.image;
    }

    public void setType(String type)
    {
	this.type = type;
    }

    public void setWidth(int width)
    {
	this.width = width;
    }

    public void setHeight(int height)
    {
	this.height = height;
    }
    
    public void setUri(String uri)
    {
	this.uri = uri;
    }
    
    public void setUri150(String uri150)
    {
	this.uri150 = uri150;
    }
    
    public void setResourceUrl(String resource_url)
    {
	this.resource_url = resource_url;
    }

    public void setImage(byte[] image)
    {
	this.image = image;
    }
    
    public String toString()
    {
	StringBuilder builder = new StringBuilder(" ##############Discogs Image##############\n");
	builder.append(" Type: ").append(getType()).append("\n")
	    .append(" Width: ").append(getWidth()).append("\n")
	    .append(" Height: ").append(getHeight()).append("\n")
	    .append(" Uri: ").append(getUri()).append("\n")
	    .append(" Uri150: ").append(getUri150()).append("\n")
	    .append(" ResourceUrl: ").append(getResourceUrl()).append("\n")
	    .append(" Is image loaded? - ").append((getImage() != null && getImage().length > 0) ? "Yes\n" : "No\n")
	    .append("########################");
	return builder.toString();
    }
}
