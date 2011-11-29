package edu.uci.x46010.team.b.app;

import java.util.Calendar;
import java.util.GregorianCalendar;

import edu.uci.x46010.team.b.app.Teacher;
import edu.uci.x46010.team.b.app.Person.Gender;

import junit.framework.TestCase;

public class TeacherTest extends TestCase 
{
	/**
	 * Test that a Teacher object can get and set a room.
	 */
	public void testRoom()
	{
		Teacher teacher = new Teacher();
		teacher.setRoom("Room ABC");
		assertEquals("Room ABC", teacher.getRoom());
	}

	/**
	 * Test that a Teacher object can add a number of courses.
	 */
	public void testCourseList()
	{
		GregorianCalendar testCalendar = new GregorianCalendar();
		testCalendar.set(1985, Calendar.MAY, 15);
		
		Teacher teacher = new Teacher("Jane", "Doe", Gender.FEMALE, "123-45-678", testCalendar, "Room XYZ");
		
		teacher.addCourse("Course 1");
		teacher.addCourse("Course 2");
		teacher.addCourse("Course 3");
		teacher.addCourse("Course 4");
		
		assertEquals(4, teacher.getCourseListSize());
	}
}
