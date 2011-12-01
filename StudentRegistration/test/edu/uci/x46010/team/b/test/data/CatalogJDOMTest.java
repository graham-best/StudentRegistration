package edu.uci.x46010.team.b.test.data;

import junit.framework.TestCase;
import edu.uci.x46010.team.b.app.data.CatalogJDOM;
import edu.uci.x46010.team.b.app.middle.Catalog;

public class CatalogJDOMTest extends TestCase 
{
	public Catalog testReadXMLFile() 
	{
		Catalog testCatalog = null;
		
		try
		{
			CatalogJDOM catalogJDOM = new CatalogJDOM();

			testCatalog = catalogJDOM.readXMLFile("data\\catalog.xml");
			assertEquals(7, testCatalog.size());
			
			// Print out all of the course information to check if it was read.
			System.out.println(testCatalog.toString());
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return testCatalog;
	}
	
	public void testWriteXMLFile()
	{
		// TODO: Create function to test writing a Catalog object to an XML file.
	}
}
