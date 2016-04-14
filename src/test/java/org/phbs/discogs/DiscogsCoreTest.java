package org.phbs.discogs;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Ignore;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.phbs.discogs.pojo.*;

import com.google.gson.Gson;

import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Array;

import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * Core Functionality tests
 */
public class DiscogsCoreTest {

    private static DiscogsReadOnlyService serv = null;
    /*private static DiscogsArtist testArtist = null;
    private static DiscogsLabel testLabel = null;
    private static DiscogsRelease testRelease = null;
    private static DiscogsMasterRelease testMaster= null;
    private static DiscogsUser testUser = null;*/

    private static final long ARTIST_ID = 1;
    private static final long LABEL_ID = 1;
    private static final long RELEASE_ID = 1;
    private static final long MASTER_ID = 257;
    private static final String USER_NAME = "1";

    @Test
    public void testGetArtist() {
	try {
	    DiscogsArtist artist = serv.getArtist(ARTIST_ID);
	    assertNotNull(artist);
	    
	} catch(Exception e) {
	    fail("Exception: " + e);
	}
    }

    @Test
    public void testGetLabel() {
	try {
	    DiscogsLabel label = serv.getLabel(LABEL_ID);
	    assertNotNull(label);
	} catch(Exception e) {
	    fail("Exception: " + e);
	}
    }

    @Test
    public void testGetRelease() {
        try {
	    DiscogsRelease release = serv.getRelease(RELEASE_ID);
	    assertNotNull(release);
	} catch(Exception e) {
	    fail("Exception: " + e);
	}
    }

    @Test
    public void testGetMasterRelease() {
	try {
	    DiscogsMasterRelease master = serv.getMaster(MASTER_ID);
	    assertNotNull(master);
	} catch(Exception e) {
	    fail("Exception: " + e);
	}
    }
    
    @Test
    public void testGetUser() {
	try {
	    DiscogsUser user = serv.getUser(USER_NAME);
	    assertNotNull(user);
	} catch(Exception e) {
	    fail("Exception: " + e);
	}
    }
 
   @BeforeClass
    public static void testInit() {

	    serv = new DiscogsReadOnlyService();
	    /*
	    // http://api.discogs.com/artists/1
	    testArtist = getTestEntity("artist1.json", DiscogsArtist.class);
	    // http://api.discogs.com/labels/1
	    testLabel = getTestEntity("label1.json", DiscogsLabel.class);
	    // http://api.discogs.com/releases/1
	    testRelease = getTestEntity("release1.json", DiscogsRelease.class);
	    // http://api.discogs.com/masters/257
	    testMaster= getTestEntity("master257.json", DiscogsMasterRelease.class);
	    // http://api.discogs.com/users/1
	    testUser = getTestEntity("user1.json", DiscogsUser.class);*/

    }

    private static <T extends DiscogsEntity>T getTestEntity(String fileName, Class<T> type) 
	throws InstantiationException, IllegalAccessException, IOException
    {
	T entity = type.newInstance();
	Gson gson = new Gson();
	try(Reader freader = 
	    new BufferedReader(new InputStreamReader(DiscogsCoreTest.class.getResourceAsStream(fileName))))
	{
	    entity = gson.fromJson(freader ,type);
	}
	
	return entity;
    }
    
    private String compareFields(DiscogsEntity test, DiscogsEntity example)
	throws  IllegalAccessException, InvocationTargetException
    {
	
	if(test == null || example == null)
	    return "Null value";
	
	StringBuilder builder = null;

	if(!test.getClass().equals(example.getClass()))
	{
	    builder = new StringBuilder("Uncomparable types: ");
	    builder.append(test.getClass().getName())
		   .append(" and ")
		   .append(example.getClass().getName());

	    return builder.toString();
	}

	Class type = example.getClass();
	Method[] methods = type.getDeclaredMethods();
	
	for(int i = 0; i < methods.length; i++)
	{
	    Method method = methods[i];
	    Class returnType = method.getReturnType();

	    if(method.getName().startsWith("get") 
	           && Modifier.isPublic(method.getModifiers()))
	    {
		Object testResult = method.invoke(test, null);
		Object exampleResult = method.invoke(example, null);

		if(exampleResult == null)
		    continue;
		
		String exampleResultStr = "";
		String testResultStr = "";

		if(List.class.isAssignableFrom(returnType)) 
		{
		    List exampleResultList = (List) exampleResult;
		    List testResultList = (List) testResult;

		    if(exampleResultList.size() != testResultList.size())
		    {
			exampleResultStr = "example size: " + exampleResultList.size();
			testResultStr = "test size: " + testResultList.size();
		    }
		    else
		    {
			//TODO: check list elements
		    }
		}
		else
		{
		    exampleResultStr = exampleResult + "";
		    testResultStr = testResult + "";
		}

		if(exampleResultStr.equals(testResultStr))
		    continue;

		if(builder == null)
	        {
		    builder = new StringBuilder("Please check fields for ");
		    builder.append(type.getName()).append(" :\n");
		}

		builder.append(method.getName().substring(3)).append(" ,");	
	    }
	}
	
	return builder != null ? builder.toString() : null;
    }
}
