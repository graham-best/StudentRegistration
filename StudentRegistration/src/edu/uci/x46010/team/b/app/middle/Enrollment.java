package edu.uci.x46010.team.b.app.middle;

/**
 * An enrollment is an association between a single student and a single course.
 * See data diagram
 */
public class Enrollment 
{
	/**
	 * Data members
	 */
	
	/**
	 * The course number
	 */
	protected String courseNumber;
	
	/*
	 * The enrolled student's ID  
	 */
	protected String personID;
	
	/*
	 * set the course number for this enrollment
	 * @param courseNumber the course identifier for the course
	 */
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	
	/**
	 * get the course number for this enrollment
	 * @return the course number
	 */
	public String getCourseNumber() {
		return this.courseNumber;
	}
	
	/**
	 * set the student ID for the student that is enrolled in the course
	 * @param studentID
	 */
	public void setStudentID(String studentID) {
		this.personID = studentID;
	}
	
	/**
	 * get the student ID for the student enrolled in the course
	 * @return the ID for the student (person) enrolled in the course
	 */
	public String getStudentID() {
		return this.personID;
	}
	
	/**
	 * default constructor for the Enrollment
	 */
	public Enrollment() {
		this.courseNumber = "";
		this.personID = "";
	}
	

	/**
	 * constructor with initialized course and student information
	 * @param courseNumber
	 * @param studentID
	 */
	public Enrollment(String courseNumber,String studentID) {
		this.courseNumber = courseNumber;
		this.personID = studentID;
	}
	
	
	
}
