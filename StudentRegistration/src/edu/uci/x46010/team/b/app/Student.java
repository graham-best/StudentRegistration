package edu.uci.x46010.team.b.app;

import java.util.GregorianCalendar;

public class Student extends Person 
{
	/**
	 * Data members
	 */
	protected String college;
	protected String dorm;
	
	/**
	 * Default Constructor
	 */
	public Student()
	{
		super();
		this.college = "Unknown";
		this.dorm = "Unknown";
	}

	/**
	 * Provide for constructor with the Java Calendar.
	 * @param firstName First name of the student
	 * @param lastName Last name of the student
	 * @param gender Gender of the student
	 * @param SSN Social security of the student
	 * @param birthCalendar Birthday of the student. 
	 * @param college College of the student
	 * @param dorm Dorm of the student
	 */
	public Student (String firstName, 
			        String lastName, 
			        Gender gender, 
			        String SSN, 
			        GregorianCalendar birthCalendar,
			        String college,
			        String dorm)
	{
		super(firstName, lastName, gender, SSN, birthCalendar);
		this.college = college;
		this.dorm = dorm;
	}

	/**
	 * Get the college of the student
	 * @return The college of the student
	 */
	public String getCollege() 
	{
		return college;
	}

	/**
	 * Set the college of the student
	 * @param college the college to set
	 */
	public void setCollege(String college) 
	{
		this.college = college;
	}

	/**
	 * Get the dorm of the student
	 * @return The dorm of the student 
	 */
	public String getDorm()
	{
		return dorm;
	}

	/**
	 * Set the dorm of the student
	 * @param dorm The dorm to set
	 */
	public void setDorm(String dorm) 
	{
		this.dorm = dorm;
	}
	
}
