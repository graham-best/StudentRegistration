package edu.uci.x46010.team.b.app;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarUtils 
{
	/**
	 * Get the Java Gregorian Calendar value based on the matching month string. 
	 * @param month The month of the calendar. Only the first three letters are compared.
	 * @return The Java value of the Gregorian Calendar.
	 */
	public static int convertToMonthValue(String month)
	{
		// Get the first three letters of the month.
		String shortMonth;
		shortMonth = month.toLowerCase().substring(0, 3);
	
		// Could use a switch case statement here, but the String version isn't compatible with Android...
			 if (shortMonth.equals("jan")) 	return Calendar.JANUARY;
		else if (shortMonth.equals("feb")) 	return Calendar.FEBRUARY;
		else if (shortMonth.equals("mar"))	return Calendar.MARCH;
		else if (shortMonth.equals("apr"))	return Calendar.APRIL;
		else if (shortMonth.equals("may"))	return Calendar.MAY;
		else if (shortMonth.equals("jun")) 	return Calendar.JUNE;
		else if (shortMonth.equals("jul"))	return Calendar.JULY;
		else if (shortMonth.equals("aug"))	return Calendar.AUGUST;
		else if (shortMonth.equals("sep"))	return Calendar.SEPTEMBER;
		else if (shortMonth.equals("oct"))	return Calendar.OCTOBER;
		else if (shortMonth.equals("nov"))	return Calendar.NOVEMBER;
		else if (shortMonth.equals("dec"))	return Calendar.DECEMBER;
		else								return Calendar.UNDECIMBER;
	}

	/** Get the day of the week from a string to a Calendar value
	 * @param dayOfWeek The day of the week in a string format.
	 * @return The Calendar value
	 */
	public static int convertToDayOfWeekValue(String dayOfWeek)
	{
		// Some days have a single letter abbreviation, some have two. Start with trying to find two day
		// abbreviations. 
		// Get the first two letters of the week.
		String shortDayOfWeek;
		if (dayOfWeek.length() > 1)
		{
			shortDayOfWeek = dayOfWeek.toLowerCase().substring(0, 2);
		
			     if (shortDayOfWeek.equals("th"))	return Calendar.THURSDAY;
			else if (shortDayOfWeek.equals("sa"))	return Calendar.SATURDAY;
			else if (shortDayOfWeek.equals("su"))	return Calendar.SUNDAY;
		}
		
		// Now try the single letter of week.
		shortDayOfWeek = dayOfWeek.toLowerCase().substring(0, 1);
		     
		     if (shortDayOfWeek.equals("m"))	return Calendar.MONDAY;
		else if (shortDayOfWeek.equals("t"))	return Calendar.TUESDAY;
		else if (shortDayOfWeek.equals("w"))	return Calendar.WEDNESDAY;
		else if (shortDayOfWeek.equals("f"))	return Calendar.FRIDAY;
		else									return -1;
	
	}

    /**
     * Get the year from a calendar to a string.
     * @param calendar The Calendar to convert.
     * @return The formatted year.
     */
    public static String convertToYearString(GregorianCalendar calendar)
    {
		return Integer.toString(calendar.get(Calendar.YEAR));
    }

    /**
     * Get the month from a calendar to a string.
     * @param calendar The Calendar to convert.
     * @return The formatted month.
     */
    public static String convertToMonthString(GregorianCalendar calendar)
    {
		// SimpleDateFormat should work here, but it throws an exception. I'm not sure why...
		// It's probably because SimpleDateFormat is expecting a Date object rather than a 
		// GregorianCalendar object.

    	// Get the value for the month.
    	int monthValue = calendar.get(Calendar.MONTH);
    	
		switch(monthValue)
		{
			case Calendar.JANUARY: 		return "January";
			case Calendar.FEBRUARY: 	return "February";
			case Calendar.MARCH:		return "March";
			case Calendar.APRIL:		return "April";
			case Calendar.MAY:			return "May";
			case Calendar.JUNE:			return "June";
			case Calendar.JULY:			return "July";
			case Calendar.AUGUST:		return "August";
			case Calendar.SEPTEMBER:	return "September";
			case Calendar.OCTOBER:		return "October";
			case Calendar.NOVEMBER:		return "November";
			case Calendar.DECEMBER:		return "December";
			default:					return "Invalid Month";
		}
    }
    
    /**
     * Get the day of the month from a calendar to a string.
     * @param calendar The Calendar to convert.
     * @return The formatted day of the month.
     */
    public static String convertToDayOfMonthString(GregorianCalendar calendar)
    {
    	return Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
    }	
	
	/**
	 * Get the date from a calendar to a string.
	 * @param calendar The Calendar to convert.
	 * @return The formatted date
	 */
	public static String convertToDateString(GregorianCalendar calendar)
	{
		return convertToMonthString(calendar) + " " + convertToDayOfMonthString(calendar) + ", " + convertToYearString(calendar);
	}
	
	/**
	 * Get the day of the week from a calendar to a string.
	 * @param dayOfWeek The Calendar.DAY_OF_WEEK
	 * @return The formatted day of the week
	 */
	public static String convertToDayOfWeekString(int dayOfWeek)
	{
		SimpleDateFormat dayOfWeekFormat = new SimpleDateFormat("EEEE");
		return dayOfWeekFormat.format(dayOfWeek); 
	}
	
	/**
	 * Get the time of day from a calendar to a string.
	 * @param calendar The Calendar to convert.
	 * @return The formatted time
	 */
    public static String convertToTimeString(Calendar calendar)
    {
    	SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm aaa");
    	return timeFormat.format(calendar);
    }

    /**
     * Create a Gregorian Calendar with a year, month string, and a day of month.
     * @param year The year of the Calendar
     * @param monthString The month string of the Calendar
     * @param dayOfMonth The day of the month of the Calendar
     * @return The new Gregorian Calendar
     */
    public static GregorianCalendar createGregorianCalendar(int year, String monthString, int dayOfMonth)
    {
    	GregorianCalendar calendar = new GregorianCalendar(year, CalendarUtils.convertToMonthValue(monthString), dayOfMonth);
    	return calendar;
    }
    
    /**
     * Create a Gregorian Calendar with a year, month string, and a day of month.
     * @param year The year of the Calendar
     * @param monthString The month string of the Calendar
     * @param dayOfMonth The day of the month of the Calendar
     * @return The new Gregorian Calendar
     */
    public static GregorianCalendar createGregorianCalendar(String yearString, String monthString, String dayOfMonthString)
    {
    	return createGregorianCalendar(Integer.parseInt(yearString), monthString, Integer.parseInt(dayOfMonthString));
    }    
}
