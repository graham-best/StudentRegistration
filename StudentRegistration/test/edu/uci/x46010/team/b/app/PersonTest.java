package edu.uci.x46010.team.b.app;

import java.util.Calendar;
import java.util.GregorianCalendar;

import edu.uci.x46010.team.b.app.Person;
import edu.uci.x46010.team.b.app.Person.Gender;

import junit.framework.TestCase;

public class PersonTest extends TestCase 
{
	/**
	 * Test the Person constructors
	 */
	public void testConstructor() 
	{
		// Test the default constructor
		Person p1 = new Person();
		assertEquals("unknown", p1.getFirstName());
		assertEquals("unknown", p1.getLastName());
		assertEquals(Gender.UNKNOWN, p1.getGender());
		assertEquals("unknown", p1.getSSN());

		// Test the assignment constructor
		GregorianCalendar testCalendar = new GregorianCalendar();
		testCalendar.set(1985, Calendar.MAY, 15);
		
		Person p2 = new Person("Jane", "Doe", Gender.FEMALE, "123-45-678", testCalendar);
		assertEquals("Jane", p2.getFirstName());
		assertEquals("Doe", p2.getLastName());
		assertEquals(Gender.FEMALE, p2.getGender());
		assertEquals("123-45-678", p2.getSSN());
		assertEquals(testCalendar, p2.getBirthDate());	
	}

	/**
	 * Test that a Person object can get and set a first name.
	 */
	public void testFirstName()
	{
		Person p3 = new Person();
		p3.setFirstName("John");
		assertEquals("John", p3.getFirstName());
	}

	/**
	 * Test that a Person object can get and set a last name.
	 */
	public void testLastName()
	{
		Person p4 = new Person();
		p4.setLastName("Le");
		assertEquals("Le", p4.getLastName());		
	}

	/**
	 * Test that a Person object can combine a first and last name.
	 */
	public void testFullName()
	{
		Person p1 = new Person();
		p1.setFirstName("John");
		p1.setLastName("Le");
		assertEquals("John Le", p1.getFullName());
	}

	/**
	 * Test that a Person object can get and set a Social Security Number.
	 */
	public void testSSN()
	{
		Person p1 = new Person();
		p1.setSSN("876-54-321");
		assertEquals("876-54-321", p1.getSSN());		
	}
	
	/**
	 * Test that a Person object can compute the age.
	 */
	public void testAge()
	{
		GregorianCalendar testCalendar = new GregorianCalendar();
		testCalendar.set(1971, Calendar.FEBRUARY, 26);
		
		Person p1 = new Person();
		p1.setBirthDate(testCalendar);
		assertEquals(40, p1.getAge());		

		testCalendar.set(1971, Calendar.DECEMBER, 26);

		p1.setBirthDate(testCalendar);
		assertEquals(39, p1.getAge());
	}
	
	/**
	 * Test that a Person object can talk.
	 */
	public void testTalk()
	{
		Person p1 = new Person();
		assertEquals("Blah, blah, blah...", p1.talk());
	}
	
	/**
	 * Test that a Person object can output its data fields.
	 */
	public void testtoString()
	{
		GregorianCalendar testCalendar = new GregorianCalendar();
		testCalendar.set(1985, Calendar.MAY, 15);
		
		Person p1 = new Person("Jane", "Doe", Gender.FEMALE, "123-45-678", testCalendar);
		assertEquals("Jane Doe Gender: Female SSN: 123-45-678 Age: 26", p1.toString());
	}
}
