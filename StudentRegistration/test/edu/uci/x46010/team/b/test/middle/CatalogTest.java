package edu.uci.x46010.team.b.test.middle;

import edu.uci.x46010.team.b.app.middle.Catalog;
import edu.uci.x46010.team.b.app.middle.Course;
import junit.framework.TestCase;

public class CatalogTest extends TestCase 
{
	/**
	 * Test that a Course object can be added to a Catalog object
	 */
	public Catalog testAdd()
	{
		Catalog testCatalog = new Catalog();
		
		// Try adding a course to the catalog.
		Course testCourse = new Course();
		int numberOfCourses = 5;
		
		for (int count=0; count<numberOfCourses; count++)
		{
			testCatalog.add(testCourse);
		}
		assertEquals(numberOfCourses, testCatalog.size());
		
		return testCatalog;
	}

	/**
	 * Test that a Catalog object can be cleared.
	 */
	public void testClear()
	{
		Catalog testCatalog = testAdd();
		testCatalog.clear();
		
		assertEquals(0, testCatalog.size());
	}
}
