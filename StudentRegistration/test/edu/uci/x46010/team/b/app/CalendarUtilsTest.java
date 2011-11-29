package edu.uci.x46010.team.b.app;

import java.util.Calendar;
import java.util.GregorianCalendar;

import edu.uci.x46010.team.b.app.CalendarUtils;

import junit.framework.TestCase;

public class CalendarUtilsTest extends TestCase 
{
	/**
	 * Test that the strings given to the getGregorianMonthValue utility function are translated 
	 * correctly.
	 */
	public void testGregorianMonthValue()
	{
		// Test full month strings
		assertEquals(Calendar.JANUARY,   CalendarUtils.convertToMonthValue("January"));
		assertEquals(Calendar.FEBRUARY,  CalendarUtils.convertToMonthValue("February"));
		assertEquals(Calendar.MARCH,     CalendarUtils.convertToMonthValue("March"));
		assertEquals(Calendar.APRIL,     CalendarUtils.convertToMonthValue("April"));
		assertEquals(Calendar.MAY,       CalendarUtils.convertToMonthValue("May"));
		assertEquals(Calendar.JUNE,      CalendarUtils.convertToMonthValue("June"));
		assertEquals(Calendar.JULY,      CalendarUtils.convertToMonthValue("July"));
		assertEquals(Calendar.AUGUST,    CalendarUtils.convertToMonthValue("August"));
		assertEquals(Calendar.SEPTEMBER, CalendarUtils.convertToMonthValue("September"));
		assertEquals(Calendar.OCTOBER,   CalendarUtils.convertToMonthValue("Octomber"));
		assertEquals(Calendar.NOVEMBER,  CalendarUtils.convertToMonthValue("November"));
		assertEquals(Calendar.DECEMBER,  CalendarUtils.convertToMonthValue("December"));
		
		// Test three letter month strings
		assertEquals(Calendar.JANUARY,   CalendarUtils.convertToMonthValue("JAN"));
		assertEquals(Calendar.FEBRUARY,  CalendarUtils.convertToMonthValue("FEB"));
		assertEquals(Calendar.MARCH,     CalendarUtils.convertToMonthValue("MAR"));
		assertEquals(Calendar.APRIL,     CalendarUtils.convertToMonthValue("APR"));
		assertEquals(Calendar.MAY,       CalendarUtils.convertToMonthValue("MAY"));
		assertEquals(Calendar.JUNE,      CalendarUtils.convertToMonthValue("JUN"));
		assertEquals(Calendar.JULY,      CalendarUtils.convertToMonthValue("JUL"));
		assertEquals(Calendar.AUGUST,    CalendarUtils.convertToMonthValue("AUG"));
		assertEquals(Calendar.SEPTEMBER, CalendarUtils.convertToMonthValue("SEP"));
		assertEquals(Calendar.OCTOBER,   CalendarUtils.convertToMonthValue("OCT"));
		assertEquals(Calendar.NOVEMBER,  CalendarUtils.convertToMonthValue("NOV"));
		assertEquals(Calendar.DECEMBER,  CalendarUtils.convertToMonthValue("DEC"));
	}

	/**
	 * Test that the strings given to the getDayOfWeekValue utility function are translated 
	 * correctly.
	 */
	public void testDayOfWeekValue()
	{
		// Test the full day of week strings
		assertEquals(Calendar.MONDAY,    CalendarUtils.convertToDayOfWeekValue("Monday"));
		assertEquals(Calendar.TUESDAY,   CalendarUtils.convertToDayOfWeekValue("Tuesday"));
		assertEquals(Calendar.WEDNESDAY, CalendarUtils.convertToDayOfWeekValue("Wednesday"));
		assertEquals(Calendar.THURSDAY,  CalendarUtils.convertToDayOfWeekValue("Thursday"));
		assertEquals(Calendar.FRIDAY,    CalendarUtils.convertToDayOfWeekValue("Friday"));
		assertEquals(Calendar.SATURDAY,  CalendarUtils.convertToDayOfWeekValue("Saturday"));		
		assertEquals(Calendar.SUNDAY,    CalendarUtils.convertToDayOfWeekValue("Sunday"));		

		// Test the two letter day of week strings
		assertEquals(Calendar.MONDAY,    CalendarUtils.convertToDayOfWeekValue("M"));
		assertEquals(Calendar.TUESDAY,   CalendarUtils.convertToDayOfWeekValue("T"));
		assertEquals(Calendar.WEDNESDAY, CalendarUtils.convertToDayOfWeekValue("W"));
		assertEquals(Calendar.THURSDAY,  CalendarUtils.convertToDayOfWeekValue("TH"));
		assertEquals(Calendar.FRIDAY,    CalendarUtils.convertToDayOfWeekValue("F"));
		assertEquals(Calendar.SATURDAY,  CalendarUtils.convertToDayOfWeekValue("SA"));		
		assertEquals(Calendar.SUNDAY,    CalendarUtils.convertToDayOfWeekValue("SU"));		
	}

	/**
	 * Test that the Calendar can be converted into a year string.
	 */
	public String testGetYearString()
	{
		GregorianCalendar talkLikeAPirateDay = new GregorianCalendar();
		talkLikeAPirateDay.set(1995, Calendar.SEPTEMBER, 19);
		
		String yearString = CalendarUtils.convertToYearString(talkLikeAPirateDay);
		assertEquals("1995", yearString);
		
		return yearString;
	}
	
	/**
	 * Test that the Calendar can be converted into a month string.
	 */
	public String testGetGregorianMonthString()
	{
		GregorianCalendar talkLikeAPirateDay = new GregorianCalendar();
		talkLikeAPirateDay.set(1995, Calendar.SEPTEMBER, 19);
		
		String monthString = CalendarUtils.convertToMonthString(talkLikeAPirateDay);
		assertEquals("September", monthString);
		
		return monthString;
	}

	/**
	 * Test that the Calendar can be converted into a day of the month string.
	 */
	public String testGetDayOfMonthString()
	{
		GregorianCalendar talkLikeAPirateDay = new GregorianCalendar();
		talkLikeAPirateDay.set(1995, Calendar.SEPTEMBER, 19);
		
		String dayOfMonthString = CalendarUtils.convertToDayOfMonthString(talkLikeAPirateDay);
		assertEquals("19", dayOfMonthString);
		
		return dayOfMonthString;
	}	
}
