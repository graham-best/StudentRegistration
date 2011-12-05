package edu.uci.x46010.team.b.app.middle;


import java.util.ArrayList;


/**
 * EnrollmentCollection stores all of enrollments by a student for a course.
 */
public class EnrollmentCollection 
{
	
	/**
	 * the list of student / course pairs
	 */
	protected ArrayList<Enrollment> enrollment;

	/**
	 * looks through all enrollment and sees if the combination of student and course is already there
	 * @param courseNumber the course ID of the course to look for
	 * @param studentID the person ID of the student to look for
	 * @return the enrollment object that holds the association
	 */
	private Enrollment findEnrollment(String courseNumber,String studentID) {
		for (Enrollment enroll : enrollment) {
			if (enroll.getStudentID().equals(studentID) && enroll.getCourseNumber().equals(courseNumber))
				return enroll; // return the Enrollment object that matches
		}
		
		// we get here if the combination of student and course IDs is not found
		return null;
	}

	/**
	 * add a student to the course
	 * @param courseNumber the ID of the course to which the student is added
	 * @param studentID the ID of the student (person ID) to add to the course
	 */
	public void add(String courseNumber,String studentID) {
		if (findEnrollment(courseNumber,studentID) == null) {
			enrollment.add(new Enrollment(courseNumber,studentID));
			return;
		}
		
		// TODO: should we throw an exception if the student / course combination already exists?
	}

	
	/**
	 * drop a student from a course
	 * @param courseNumber the ID of the course from which the student is dropped
	 * @param studentID the ID of the student (person ID) to drop from the course
	 */
	public void drop(String courseNumber,String studentID) {
		
		// find the enrollment if it exists
		Enrollment enrollmentToDrop = findEnrollment(courseNumber,studentID);
		
		if (enrollmentToDrop == null) {
			// TODO:  should we throw an exception if the enrollment isn't found?
			return;
		}
		
		enrollment.remove(enrollmentToDrop);
	}
	
	/**
	 * Default constructor
	 */
	public EnrollmentCollection() {
		
		// create an empty list with no enrollment
		enrollment = new ArrayList<Enrollment>();
	}
	
	
}
