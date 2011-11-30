package edu.uci.x46010.team.b.test.middle;

import edu.uci.x46010.team.b.app.middle.Student;
import junit.framework.TestCase;

public class StudentTest extends TestCase 
{
	/**
	 * Test that a Student object can get and set a college.
	 */
	public void testCollege()
	{
		Student student = new Student();
		student.setCollege("UCI");
		assertEquals("UCI", student.getCollege());		
	}

	/**
	 * Test that a Student object can get and set a dorm.
	 */
	public void testDorm()
	{
		Student student = new Student();
		student.setDorm("XYZ");
		assertEquals("XYZ", student.getDorm());		
		
	}
}
