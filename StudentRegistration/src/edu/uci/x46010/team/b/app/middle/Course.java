package edu.uci.x46010.team.b.app.middle;

import java.util.Calendar;
import java.util.GregorianCalendar;

import edu.uci.x46010.team.b.app.helper.CalendarUtils;

public class Course 
{
	private String number;
	private String name;
	private String description;
	private float units;
	
	private GregorianCalendar startDate;
	private GregorianCalendar endDate;
	private int dayOfWeek;
	private Calendar startTime;
	private Calendar endTime;
	private int maximumEnrollment;
	
	/**
	 * Default constructor
	 */
	public Course()
	{
		this.number = "Unknown";
		this.name = "Unknown";
		this.description = "Unknown";
		this.units = 0.0f;
		
		// Get the current date as the start and end date.
		this.startDate = new GregorianCalendar();
		this.endDate = new GregorianCalendar();
		
		this.dayOfWeek = -1;
		this.startTime = new GregorianCalendar();
		this.endTime = new GregorianCalendar();
	}

	/** 
	 * Get the course number.
	 * @return The course number
	 */
	public String getNumber() 
	{
		return number;
	}

	/** 
	 * Set the course number.
	 * @param number The course number to set.
	 */
	public void setNumber(String number) 
	{
		this.number = number;
	}

	/** 
	 * Get the course name.
	 * @return the name
	 */
	public String getName() 
	{
		return name;
	}

	/** 
	 * Set the course name.
	 * @param name The course name to set.
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/** 
	 * Get the course description.
	 * @return The description of the course.
	 */
	public String getDescription() 
	{
		return description;
	}

	/** 
	 * Set the course description.
	 * @param description The course description to set.
	 */
	public void setDescription(String description) 
	{
		this.description = description;
	}

	/** 
	 * Get the number of units.
	 * @return The units for the course.
	 */
	public float getUnits() 
	{
		return units;
	}

	/** 
	 * Set the number of units.
	 * @param units The units to set for the course.
	 */
	public void setUnits(float units) 
	{
		this.units = units;
	}

	/** 
	 * Get the starting Calendar date of the course.
	 * @return The starting date of the course.
	 */
	public GregorianCalendar getStartDate() 
	{
		return startDate;
	}

	/** 
	 * Set the starting Calendar date of the course.
	 * @param startDate The starting date of the course.
	 */
	public void setStartDate(GregorianCalendar startDate) 
	{
		this.startDate = startDate;
	}

	/** 
	 * Set the starting year of the course
	 * @param startDateYear The starting year of the course.
	 */
	public void setStartDateYear(int startDateYear)
	{
		this.startDate.set(Calendar.YEAR, startDateYear);
	}

	/** 
	 * Set the starting month of the course.
	 * @param startDateMonth The starting month of the course.
	 */	
	public void setStartDateMonth(String startDateMonth)
	{
		this.startDate.set(Calendar.MONTH, CalendarUtils.convertToMonthValue(startDateMonth));
	}
	
	/**
	 * Set the starting day of the month for the course.
	 * @param startDateDayOfMonth The starting day of the month for the course.
	 */
	public void setStartDateDayOfMonth(int startDateDayOfMonth)
	{
		this.startDate.set(Calendar.DAY_OF_MONTH, startDateDayOfMonth);
	}
	
	/** 
	 * Get the ending date of the course.
	 * @return The ending date of the course.
	 */
	public Calendar getEndDate() 
	{
		return endDate;
	}

	/** 
	 * Set the ending date of the course.
	 * @param endDate The ending date to set for the course.
	 */
	public void setEndDate(GregorianCalendar endDate) 
	{
		this.endDate = endDate;
	}

	/** 
	 * Set the ending year of the course
	 * @param endDateYear The ending year of the course.
	 */
	public void setEndDateYear(int endDateYear)
	{
		this.endDate.set(Calendar.YEAR, endDateYear);
	}

	/** 
	 * Set the ending month of the course.
	 * @param endDateMonth The ending year of the course.
	 */	
	public void setEndDateMonth(String endDateMonth)
	{
		this.endDate.set(Calendar.MONTH, CalendarUtils.convertToMonthValue(endDateMonth));
	}
	
	/**
	 * Set the ending day of the month for the course.
	 * @param endDateDayOfMonth The ending day of the month for the course.
	 */
	public void setEndDateDayOfMonth(int endDateDayOfMonth)
	{
		this.endDate.set(Calendar.DAY_OF_MONTH, endDateDayOfMonth);
	}

	/** 
	 * Get the day of the week when the course is taught.
	 * @return The day of the week when the course is taught.
	 */
	public int getDayOfWeek() 
	{
		return dayOfWeek;
	}

	/** 
	 * Set the day of the week when the course is taught.
	 * @param dayOfWeek The day of the week when the course is taught.
	 */
	public void setDayOfWeek(int dayOfWeek) 
	{
		this.dayOfWeek = dayOfWeek;
	}

	/** 
	 * Set the day of the week when the course is taught.
	 * @param dayOfWeek The day of the week when the course is taught.
	 */
	public void setDayOfWeek(String dayOfWeek) 
	{
		this.dayOfWeek = CalendarUtils.convertToDayOfWeekValue(dayOfWeek);
	}	
	
	/** 
	 * Get the start time of when the class is taught.
	 * @return The start time of when the class is taught.
	 */
	public Calendar getStartTime() 
	{
		return startTime;
	}

	/** 
	 * Set the start time of when the class is taught.
	 * @param startTime Set the start time of when the class is taught.
	 */
	public void setStartTime(GregorianCalendar startTime)
	{
		this.startTime = startTime;
	}

	public void setStartTimeHour(int hour)
	{
		
	}
	
	/** 
	 * Get the ending time of when the class is taught.
	 * @return The ending time of when the class is taught.
	 */
	public Calendar getEndTime() 
	{
		return endTime;
	}

	/** 
	 * Set the ending time of when the class is taught.
	 * @param endTime The ending time of when the class is taught.
	 */
	public void setEndTime(GregorianCalendar endTime) 
	{
		this.endTime = endTime;
	}

	/** 
	 * Get the maximum number of students allowed in the class.
	 * @return The maximum number of students allowed in the class.
	 */
	public int getMaximumEnrollment() 
	{
		return maximumEnrollment;
	}

	/** 
	 * Set the maximum number of students allowed in the class.
	 * @param maximumEnrollment Set the maximum number of students allowed in the class.
	 */
	public void setMaximumEnrollment(int maximumEnrollment) 
	{
		this.maximumEnrollment = maximumEnrollment;
	}
	
	public String toString()
	{
        String courseString;
        courseString = this.number + " " + this.name + " Starting Date: ";
        courseString += CalendarUtils.convertToDateString(this.startDate);
        courseString += " Ending Date: " + CalendarUtils.convertToDateString(this.endDate) + " Classes on: ";
        courseString += CalendarUtils.convertToDayOfWeekString(this.dayOfWeek) + " "; 
        courseString += CalendarUtils.convertToTimeString(this.startTime) + " - ";
        courseString += CalendarUtils.convertToTimeString(this.endTime) + " Units: " + this.units;
        
        return courseString;
	}
}
