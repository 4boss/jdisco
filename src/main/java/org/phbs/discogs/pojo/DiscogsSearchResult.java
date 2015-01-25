package org.phbs.discogs.pojo;
public class DiscogsSearchResult<T extends DiscogsEntity>
{
    
    private SearchPagination pagination;
    private T [] results;

    public DiscogsSearchResult()
    {}

    public SearchPagination getPagination()
    {
	return this.pagination;
    }

    public T [] getResults()
    {
	return this.results;
    }

    public void setPagination(SearchPagination pagination)
    {
	this.pagination = pagination;
    }

    public void setResults(T [] results)
    {
	this.results = results;
    }
    
    class SearchURL
    {
	private String last;
	private String next;

	public SearchURL()
	{}

	public String getLast()
	{
	    return this.last;
	}

	public String getNext()
	{
	    return this.next;
	}

	public void setNext(String next)
	{
	    this.next = next;
	}

	public void setLast(String last)
	{
	    this.last = last;
	}
    }

    class SearchPagination
    {
	private int per_page;
	private long pages;
	private long items;
	private SearchURL urls;

	public SearchPagination()
	{}

	public int getPerPage()
	{
	    return this.per_page;
	}

	public long getPages()
	{
	    return this.pages;
	}

	public long getItems()
	{
	    return this.items;
	}

	public SearchURL getUrls()
	{
	    return this.urls;
	}

	public void setPerPage(int per_page)
	{
	    this.per_page = per_page;
	}

	public void setPages(long pages)
	{
	    this.pages = pages;
	}

	public void setItems(long items)
	{
	    this.items = items;
	}

	public void setUrls(SearchURL urls)
	{
	    this.urls = urls;
	}
    }
}
