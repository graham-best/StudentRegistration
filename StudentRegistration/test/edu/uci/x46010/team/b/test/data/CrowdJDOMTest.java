package edu.uci.x46010.team.b.test.data;

import edu.uci.x46010.team.b.app.data.CrowdJDOM;
import edu.uci.x46010.team.b.app.middle.Crowd;
import junit.framework.TestCase;

public class CrowdJDOMTest extends TestCase 
{
	/**
	 * Test that a XML file can be read and be used to build a crowd object.
	 */
	public Crowd testReadXMLFile()
	{
		Crowd testCrowd = null;
		
		try
		{
			CrowdJDOM crowdJDOM = new CrowdJDOM();

			testCrowd = crowdJDOM.readXMLFile("data\\crowd.xml");
			assertEquals(6, testCrowd.size());
			
			System.out.println(testCrowd.toString());
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return testCrowd;
	}

	public void testWriteXMLFile()
	{
		Crowd testCrowd = null;
		
		try
		{
			testCrowd = testReadXMLFile();
			
			CrowdJDOM crowdJDOM = new CrowdJDOM();
			crowdJDOM.writeXMLFile("crowd.xml", testCrowd);
		
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Test that a XML file can be read and be used to build a crowd object. When finished, use the 
	 * crowd object to sort people based on last name.
	 */
	public void testSortLastName()
	{
		try
		{
			System.out.println("Unsorted list");
			Crowd testCrowd = testReadXMLFile();
			
			testCrowd.sortByLastName();
			System.out.println("List sorted by last name.");
			System.out.println(testCrowd.toString());			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}	

	/**
	 * Test that a XML file can be read and be used to build a crowd object. When finished, use the 
	 * crowd object to sort people based on first name.
	 */	
	public void testSortFirstName()
	{
		try
		{
			System.out.println("Unsorted list");
			Crowd testCrowd = testReadXMLFile();
			
			testCrowd.sortByFirstName();
			System.out.println("List sorted by first name.");
			System.out.println(testCrowd.toString());			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Use the Jaxen library to count all of the people matching the last name of 'Doe' in a XML file.
	 */		
	public void testCountLastName()
	{
		CrowdJDOM crowdJDOM = new CrowdJDOM();
		try 
		{
			String matchingLastName = "Doe";
			int matchingLastNames = crowdJDOM.countLastName("data\\crowd.xml", matchingLastName);
			assertEquals(2, matchingLastNames);
			
			System.out.println(matchingLastNames + " last names matching '" + matchingLastName + "' found.");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Count all of the people matching the last name of 'Doe' in a XML file without the Jaxen library.
	 */	
	public void testCountLastNameWithoutJaxen()
	{
		CrowdJDOM crowdJDOM = new CrowdJDOM();
		try 
		{
			String matchingLastName = "Doe";
			int matchingLastNames = crowdJDOM.countLastNameWithoutJaxen("data\\crowd.xml", matchingLastName);
			assertEquals(2, matchingLastNames);
			
			System.out.println(matchingLastNames + " last names matching '" + matchingLastName + "' found.");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
	}	
	
	/**
	 * Use the Jaxen library to change all of the people matching the last name of 'Doe' to 'Smith' in a XML file.
	 */
	public void testChangeLastName()
	{
		CrowdJDOM crowdJDOM = new CrowdJDOM();
		try 
		{
			crowdJDOM.changeLastName("crowd.xml", "Doe", "Smith");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Change all of the people matching the last name of 'Doe' to 'Smith' in a XML file without the Jaxen
	 * library.
	 */
	public void testChangeLastNameWithoutJaxen()
	{
		CrowdJDOM crowdJDOM = new CrowdJDOM();
		try 
		{
			crowdJDOM.changeLastNameWithoutJaxen("data\\crowd.xml", "Doe", "Smith");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
