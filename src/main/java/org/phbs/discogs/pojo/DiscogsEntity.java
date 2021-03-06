package org.phbs.discogs.pojo;

import org.apache.commons.lang.StringUtils;

public abstract class DiscogsEntity
{

    protected abstract String getID();
    
    public boolean equals(Object object)
    {
	if(object == null) return false;

	if(this == object) return true;

	if(object.getClass().equals(getClass()))
	{
	    DiscogsEntity thatObject = (DiscogsEntity)object;
	    
	    return StringUtils.equals(thatObject.getID(), this.getID());
	}

	return false;
    }

    public int hashCode()
    {
	StringBuilder hashSequence = new StringBuilder(getClass().getName());
	hashSequence.append(getID());
	return hashSequence.toString().hashCode();
    }

    public String toString()
    {
	StringBuilder builder = new StringBuilder("Type: ");
	builder.append(getClass().getName()).append(" id: ").append(getID());

	return builder.toString();
    }
}
