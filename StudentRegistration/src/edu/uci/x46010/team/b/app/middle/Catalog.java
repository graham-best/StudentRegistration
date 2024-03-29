package edu.uci.x46010.team.b.app.middle;

import java.util.ArrayList;

/**
 * A Catalog is more than one course
 */
public class Catalog 
{
	/**
	 * Use an ArrayList to keep track of the courses.
	 */
	protected ArrayList<Course> courseList;
	
	/**
	 * Default constructor
	 */
	public Catalog()
	{
		this.courseList = new ArrayList<Course>();
	}
	
	/**
	 * Add a course to the catalog
	 * @param newCourse The course to add
	 * @return true (as specified by Collection.add(E))
	 */
	public boolean add(Course newCourse)
	{
		return this.courseList.add(newCourse);
	}
	
	/**
	 * Remove all courses from the catalog.
	 */
	public void clear()
	{
		this.courseList.clear();
	}
	
	/**
	 * Return the number of courses in the catalog.
	 * @return The integer representing the number of courses in the catalog.
	 */
	public int size()
	{
		return this.courseList.size();
	}

	/**
	 * Create a string with all of the courses in the catalog.
	 */
	public String toString()
	{
		String output = "";
		
		for (Course course : courseList)
		{
			output = output + course.toString() + "\r";
		}
		
		return output;
	}
	
	
	/**
	 * retrieves the course at the specified index
	 * @param index must be 0 to size() - 1
	 * @return the Course object within the collecction
	 */
	public Course getCourse(int index) {
		if (index < 0 || index >= size())
			return null;
		
		return courseList.get(index);
		
	}

}
