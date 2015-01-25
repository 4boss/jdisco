package org.phbs.discogs.exceptions;

public class DiscogsUnauthorizedException extends DiscogsApiException
{
    public DiscogsUnauthorizedException(String message, Exception e)
    {
	super(message,e);
    }

    public DiscogsUnauthorizedException(String message)
    {
	super(message);
    }
}
