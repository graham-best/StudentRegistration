package edu.uci.x46010.team.b.app;

import edu.uci.x46010.team.b.app.data.*;
import edu.uci.x46010.team.b.app.middle.*;
import edu.uci.x46010.team.b.app.userInterface.*;




public class StudentRegistration 
{
	public static void main(String[] args) {
		
		// read the course catalog from the XML file
		CatalogJDOM catalogJDOM = new CatalogJDOM();
		Catalog catalog = null;
		
		try {
			catalog = catalogJDOM.readXMLFile("C:\\Users\\Dan\\Documents\\Java\\Workspace\\StudentRegistration\\StudentRegistration\\data\\catalog.xml");
		} catch (Exception e) {
			
			e.printStackTrace();

		}

		if (catalog == null) {
			System.out.println("Could not read course list, exiting program");
			return;
		}

		int numCourses = catalog.size();
		int index;
		
		for (index = 0;  index < numCourses;  ++index) {
			Course course = catalog.getCourse(index);
			System.out.println("course = " + course.getName());
			
		}
		

		
		// read the people (students) from the XML file
		CrowdJDOM crowdJDOM = new CrowdJDOM();
		Crowd crowd = null;
		
		try {
			crowd = crowdJDOM.readXMLFile("C:\\Users\\Dan\\Documents\\Java\\Workspace\\StudentRegistration\\StudentRegistration\\data\\crowd.xml");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		if (crowd == null) {
			System.out.println("Could not read list of people, exiting program");
			return;
		}
		
		// read the logins from the XML file
		LoginJDOM loginJDOM = new LoginJDOM();
		LoginList loginList = null;
		
		try {
			loginList = loginJDOM.readXMLFile("C:\\Users\\Dan\\Documents\\Java\\Workspace\\StudentRegistration\\StudentRegistration\\data\\logins.xml");
		} catch (Exception e) {			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (loginList == null) {
			System.out.println("Could not read list of log in IDs and passwords, exiting program");
			return;			
		}
		
		// TODO:  read in the Enrollment collection
		
		
		// first log in the student
		String loginID = UserLoginUI.getValidLoginID(loginList);
		
		// get the person associated with this list
		// for now loginID == Social Security Number
		Person person = crowd.findPersonWithSSN(loginID);
		
		if (person == null) {
			System.out.println("Could not locate a person with SSN = '" + loginID + "'");
			return;
		}
		
		System.out.println("Student " + person.getFullName() + " logged in");
		
			
	}
	
	
	
}
