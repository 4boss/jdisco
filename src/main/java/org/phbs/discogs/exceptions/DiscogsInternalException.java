package org.phbs.discogs.exceptions;

public class DiscogsInternalException extends DiscogsApiException
{
    public DiscogsInternalException(String message, Exception e)
    {
	super(message,e);
    }

    public DiscogsInternalException(String message)
    {
	super(message);
    }
}
