package edu.uci.x46010.team.b.app.helper;

import java.util.Calendar;

/**
 * This is a storage class for time. Java had a storage class for time at one point, but then deprecated 
 * it. This object is simpler than the deprecated version.
 */
public class SimpleTime 
{
	/**
	 * Data members
	 */
	private int hour;
	private int minute;
	private int amPm;
	
	/**
	 * Default constructor.
	 */
	public SimpleTime()
	{
		// A time that isn't set doesn't make sense.
		hour = -1;
		minute = -1;
		amPm = -1;
	}
	
	/**
	 * Assignment constructor with integers
	 * @param hour The hour of the time
	 * @param minute The minute of the time
	 * @param am_pm The Calendar.AM_PM value of the time
	 */
	public SimpleTime(int hour, int minute, int am_pm)
	{
		this.hour = hour;
		this.minute = minute;
		this.amPm = am_pm;
	}

	/**
	 * Assignment constructor with strings.
	 * @param hourString The hour in a string format.
	 * @param minuteString The minute in a string format.
	 * @param amPmString The am/pm value in a string format. 
	 */
	public SimpleTime (String hourString, String minuteString, String amPmString)
	{
		this.hour = Integer.parseInt(hourString);
		this.minute = Integer.parseInt(minuteString);
		this.amPm = this.convertAmPmToValue(amPmString);
	}
	
	/**
	 * Get the hour of the time
	 * @return The hour
	 */
	public int getHour() 
	{
		return hour;
	}

	/**
	 * Set the hour of the time
	 * @param hour The hour to set
	 */
	public void setHour(int hour) 
	{
		this.hour = hour;
	}

	/**
	 * Set the hour of the time
	 * @param hourString The hour to set in a String format.
	 */
	public void setHour(String hourString)
	{
		this.hour = Integer.parseInt(hourString);
	}
	
	/**
	 * Get the minute of the time
	 * @return The minute
	 */
	public int getMinute() 
	{
		return minute;
	}

	/**
	 * Set the minute of the time
	 * @param minute The minute to set
	 */
	public void setMinute(int minute) 
	{
		this.minute = minute;
	}

	/**
	 * Set the minute of the time
	 * @param minuteString The minute to set in a String format.
	 */
	public void setMinute(String minuteString)
	{
		this.minute = Integer.parseInt(minuteString);
	}
	
	/**
	 * Get the am or pm time setting
	 * @return The am or pm time setting
	 */
	public int getAmPm() 
	{
		return amPm;
	}

	/**
	 * Set the am or pm time setting
	 * @param amPm The am or pm to time setting
	 */
	public void setAmPm(int amPm) 
	{
		this.amPm = amPm;
	}

	/**
	 * Set the am or pm time setting 
	 * @param amPmString The am or pm to time setting in a String
	 */
	public void setAmPm(String amPmString)
	{
		this.amPm = convertAmPmToValue(amPmString);
	}
	
	/**
	 * Convert the String into a Calendar.AM_PM value. 
	 * @param amPmString "am" or "pm"
	 * @return
	 */
	public int convertAmPmToValue(String amPmString)
	{
		// Get the first letter of the am/pm flag.
		String shortAmPm;
		shortAmPm = amPmString.toLowerCase().substring(0, 1);
		
		     if (shortAmPm.equals("a")) return Calendar.AM;
		else if (shortAmPm.equals("p")) return Calendar.PM;
		else return -1;
	}	

	/**
	 * Convert the Calendar.AM_PM value into a String.
	 * @param amPm The Calendar.AM_PM value.
	 * @return
	 */
	public String convertAmPmToString(int amPm)
	{
		     if (amPm == Calendar.AM) return "am";
		else if (amPm == Calendar.PM) return "pm";
		else return "unknown";
	}	
		
	/**
	 * Information about the time in a string.
	 */
	public String toString()
	{
		return hour + ":" + String.format("%02d", minute) + " " + convertAmPmToString(amPm);
	}
	
	/**
	 * Copy the SimpleTime object to a Calendar
	 * @param copyCalendar The Calendar to copy the SimpleTime object to.
	 * @return The Calendar with the SimpleTime object added
	 */
	public Calendar copyTimeToCalendar(Calendar copyCalendar)
	{
		copyCalendar.set(Calendar.HOUR, hour);
		copyCalendar.set(Calendar.MINUTE, minute);
		copyCalendar.set(Calendar.AM_PM, amPm);
		
		return copyCalendar;
	}
}
