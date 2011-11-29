package edu.uci.x46010.team.b.app;

import java.util.Calendar;
import java.util.GregorianCalendar;

import edu.uci.x46010.team.b.app.Course;

import junit.framework.TestCase;

public class CourseTest extends TestCase 
{
	/**
	 *  Test that a Course object can get and set a course number.
	 */
	public void testNumber()
	{
		Course testCourse = new Course();
		String testString = "X1234";
		testCourse.setNumber(testString);
		assertEquals(testString, testCourse.getNumber());
	}

	/**
	 *  Test that a Course object can get and set a course name.
	 */
	public void testName()
	{
		Course testCourse = new Course();
		String testString = "Intro to course testing";
		testCourse.setName(testString);
		assertEquals(testString, testCourse.getName());
	}
	
	/**
	 *  Test that a Course object can get and set a course description.
	 */
	public void testDescription()
	{
		Course testCourse = new Course();
		String testString = "This is a test course description.";
		testCourse.setDescription(testString);
		assertEquals(testString, testCourse.getDescription());
	}

	/**
	 *  Test that a Course object can get and set a unit number.
	 */
	public void testUnits()
	{
		Course testCourse = new Course();
		float testUnits = 3.33f;
		testCourse.setUnits(testUnits);
		assertEquals(testUnits, testCourse.getUnits());
	}
	
	/**
	 * Test that a Course object can get and set a start date.
	 */
	public void testStartDate()
	{
		Course testCourse = new Course();
		int startDateYear = 2012;
		int startDateMonth = Calendar.FEBRUARY;
		int startDateDayOfMonth = 12;
	
		GregorianCalendar testCalendar = new GregorianCalendar();
		testCalendar.set(startDateYear, startDateMonth, startDateDayOfMonth);
		
		testCourse.setStartDate(testCalendar);
		assertEquals(testCalendar, testCourse.getStartDate());
	
		testCourse.setStartDateYear(startDateYear);
		testCourse.setStartDateMonth("February");
		testCourse.setStartDateDayOfMonth(startDateDayOfMonth);
		assertEquals(testCalendar, testCourse.getStartDate());
	}
	
	/**
	 * Test that a Course object can get and set a start date.
	 */
	public void testEndDate()
	{
		Course testCourse = new Course();
		int endDateYear = 2012;
		int endDateMonth = Calendar.MARCH;
		int endDateDayOfMonth = 11;
	
		GregorianCalendar testCalendar = new GregorianCalendar();
		testCalendar.set(endDateYear, endDateMonth, endDateDayOfMonth);
		
		testCourse.setEndDate(testCalendar);
		assertEquals(testCalendar, testCourse.getEndDate());
	
		testCourse.setEndDateYear(endDateYear);
		testCourse.setEndDateMonth("March");
		testCourse.setEndDateDayOfMonth(endDateDayOfMonth);
		assertEquals(testCalendar, testCourse.getEndDate());
	}	
	
	/**
	 *  Test that a Course object can get and set the day of the week.
	 */
	public void testDayOfWeek()
	{
		Course testCourse = new Course();
		int dayOfWeek = Calendar.MONDAY;
		testCourse.setDayOfWeek(dayOfWeek);
		assertEquals(dayOfWeek, testCourse.getDayOfWeek());
	
		testCourse.setDayOfWeek("Tuesday");
		assertEquals(Calendar.TUESDAY, testCourse.getDayOfWeek());		
	}
	
	/**
	 *  Test that a Course object can get and set the maximum number of students enrolled in the course.
	 */
	public void testMaximumEnrollment()
	{
		Course testCourse = new Course();
		int testMax = 25;
		testCourse.setMaximumEnrollment(testMax);
		assertEquals(testMax, testCourse.getMaximumEnrollment());
	}	
}
