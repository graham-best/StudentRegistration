package edu.uci.x46010.team.b.app.middle;

import java.util.ArrayList;

/**
 * A StudentBody is a collection of Student objects.
 */
public class StudentBody 
{
	/**
	 * Use an ArrayList to keep track of the crowd.
	 */
	protected ArrayList<Student> studentList;
	
	/**
	 * Default Constructor
	 */
	public StudentBody()
	{
		this.studentList = new ArrayList<Student>();
	}
	
	/**
	 * Add a new Student to the StudentBody
	 * @param newStudent
	 * @return true (as specified by Collection.add(E))
	 */
	public boolean add(Student newStudent)
	{
		return this.studentList.add(newStudent);
	}

	/**
	 * Remove all students from the collection.
	 */
	public void clear()
	{
		this.studentList.clear();
	}
	
	/**
	 * Return the size of the student body.
	 * @return The integer representing the number of students.
	 */
	public int size()
	{
		return this.studentList.size();
	}
	
	/**
	 * Get the list of students.
	 * @return The list of students.
	 */
	public ArrayList<Student> getStudentList()
	{
		return studentList;
	}	
}
