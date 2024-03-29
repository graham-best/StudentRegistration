package edu.uci.x46010.team.b.test.middle;

import edu.uci.x46010.team.b.app.helper.CalendarUtils;
import edu.uci.x46010.team.b.app.middle.Crowd;
import edu.uci.x46010.team.b.app.middle.Person;
import edu.uci.x46010.team.b.app.middle.Person.Gender;

import junit.framework.TestCase;

public class CrowdTest extends TestCase 
{
	/**
	 * Test that People objects can be added to a Crowd object.
	 */
	public Crowd testAdd()
	{
		Crowd testCrowd = new Crowd();
		
		// Try to add a person to the crowd.
		Person testPerson = new Person();
		int numberOfPeople = 5;

		for (int count=0; count<numberOfPeople; count++)
		{
			testCrowd.add(testPerson);
		}
		assertEquals(numberOfPeople, testCrowd.size());
		
		return testCrowd;		
	}
	
	/**
	 * Test that a Crowd object can be cleared without pepper spray.
	 */
	public void testClear()
	{
		Crowd testCrowd = testAdd();
		testCrowd.clear();
		assertEquals(0, testCrowd.size());
	}
	
	/**
	 * Test that a Crowd object can find the oldest person.
	 */
	public void testGetOldestPerson()
	{
		Crowd testCrowd = new Crowd();
		
		// Create a list of five people and add the to the crowd.
		Person p1 = new Person("David", "Agnew", Gender.MALE, "111-11-1111", 
				CalendarUtils.createGregorianCalendar(1981, "July", 19));
		testCrowd.add(p1);
		assertEquals(1, testCrowd.size());		
		
		Person p2 = new Person("Ann", "Other", Gender.FEMALE, "222-22-2222", 
				CalendarUtils.createGregorianCalendar(1965, "March", 7));		
		testCrowd.add(p2);
		assertEquals(2, testCrowd.size());		
		
		Person p3 = new Person("Israel", "Israeli", Gender.MALE, "333-33-3333", 
				CalendarUtils.createGregorianCalendar(1976, "December", 13));
		testCrowd.add(p3);
		assertEquals(3, testCrowd.size());		
		
		Person p4 = new Person("Poster", "Boy", Gender.MALE, "444-44-4444", 
				CalendarUtils.createGregorianCalendar(2002, "October", 18));
		testCrowd.add(p4);
		assertEquals(4, testCrowd.size());		
		
		Person p5 = new Person("The", "Stig", Gender.FEMALE, "555-55-5555", 
				CalendarUtils.createGregorianCalendar(1988, "June", 3));		
		testCrowd.add(p5);
		assertEquals(5, testCrowd.size());		
		
		System.out.println(testCrowd.toString());

		// Find the oldest person.
		Person oldestPerson;
		oldestPerson = testCrowd.getOldestPerson();
		
		System.out.println("The size of the crowd is " + testCrowd.size() + " people.");
		
		System.out.println("The oldest person is " + oldestPerson.getFullName()+ " at " +oldestPerson.getAge() + " years old.");	

	}
}
