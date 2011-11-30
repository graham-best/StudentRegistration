package edu.uci.x46010.team.b.app.middle;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Teacher extends Person 
{
	/**
	 * Default members
	 */
	protected String room;
	protected ArrayList<String> courseList;	
	
	/**
	 * Default constructor
	 */
	public Teacher() 
	{
		super();
		room = "Unknown";
		this.courseList = new ArrayList<String>();
	}

	/**
	 * Provide for constructor with the Java Calendar.
	 * @param firstName First name of the teacher
	 * @param lastName Last name of the teacher
	 * @param gender Gender of the teacher
	 * @param SSN Social Security Number of the teacher
	 * @param birthCalendar Birthday of the teacher 
	 * @param room Room of the teacher
	 */

	public Teacher(String firstName, 
			       String lastName, 
			       Gender gender,
			       String SSN, 
			       GregorianCalendar birthCalendar,
			       String room) 
	{
		super(firstName, lastName, gender, SSN, birthCalendar);
		this.room = room;
		this.courseList = new ArrayList<String>();
	}

	/**
	 * @return the room
	 */
	public String getRoom() 
	{
		return room;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(String room) 
	{
		this.room = room;
	}

	public void addCourse(String course)
	{
		this.courseList.add(course);
	}
	
	public void clearCourseList()
	{
		this.courseList.clear();
	}
	
	public int getCourseListSize()
	{
		return this.courseList.size();
	}
}	
