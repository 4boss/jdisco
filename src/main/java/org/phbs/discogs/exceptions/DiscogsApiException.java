package org.phbs.discogs.exceptions;

public class DiscogsApiException extends Exception
{
    public DiscogsApiException(String message, Exception e)
    {
	super(message, e);
    }

    public DiscogsApiException(String message)
    {
	super(message);
    }
}
