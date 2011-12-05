package edu.uci.x46010.team.b.app.middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;

/**
 * A Crowd is a collection of people
 */
public class Crowd 
{
	/**
	 * Use an ArrayList to keep track of the crowd.
	 */
	protected ArrayList<Person> personList;
	
	/**
	 * Default constructor
	 */
	public Crowd()
	{
		this.personList = new ArrayList<Person>();
	}
	
	/**
	 * Add a person to the crowd.
	 * @param newPerson The person to add to the crowd.
	 * @return true (as specified by Collection.add(E))
	 */
	public boolean add(Person newPerson)
	{
		return this.personList.add(newPerson);
	}
	
	/**
	 * Remove all people from the crowd.
	 */
	public void clear()
	{
		this.personList.clear();
	}

	/**
	 * Return the size of the crowd.
	 * @return The integer representing the number of people in the crowd.
	 */
	public int size()
	{
		return this.personList.size();
	}
	
	/**
	 * Get the list of persons.
	 * @return The list of persons.
	 */
	public ArrayList<Person> getPersonList()
	{
		return personList;
	}
	
	/**
	 * Find the oldest person in the crowd.
	 * @return The object representing the oldest person.
	 */
	public Person getOldestPerson()
	{
		// If the personList is empty, return null.
		if (this.personList.isEmpty())
		{
			return null;
		}
		
		// Keep track of the oldest person.
		Person oldestPerson = personList.get(0);
		
		// Create an iterator to go through the personList and find the oldestPerson.
	    Iterator<Person> personItr = this.personList.iterator();
	    while (personItr.hasNext())
	    {
	    	// Get the person that the iterator is set at.
	    	Person currentPerson = (Person) personItr.next();
	    	
	    	// Check to see if the person in the list is older than the oldest person found.
	    	if (currentPerson.getAge() > oldestPerson.getAge())
	    	{
	    		// Remember the current person.
	    		oldestPerson = currentPerson;
	    	}
	    }
		return oldestPerson;
	}

	/**
	 * Sort the crowd by last name.
	 */
	public void sortByLastName()
	{
		Collections.sort(this.personList, Person.LastNameComparator);
	}
	
	/**
	 * Sort the crowd by first name.
	 */
	public void sortByFirstName()
	{
		Collections.sort(this.personList, Person.FirstNameComparator);
	}
	
	/**
	 * Create a string with all of the people in the crowd.
	 */
	public String toString()
	{
		String output = "";
		
		for (Person person : personList)
		{
			output += person.toString() + "\r";
		}
		
		return output;
	}
	
	/**
	 * Get the last name of all of the people in the crowd.
	 * @return The last names of the people from the crown seperated with a space.
	 */
	private String getAllLastNames()
	{
		String output = "";
		
		for (Person person : personList)
		{
			output = output + person.getLastName() + " ";
		}
		
		return output;
	}
	
	/**
	 * Count the number of people whose last name matches the parameter.
	 * @param lastName The last name to find.
	 * @return The number of people with the matching last name.
	 */
	public int countMatchingLastName(String lastName)
	{
		return StringUtils.countMatches(this.getAllLastNames(), lastName);
	}
	
	
	/**
	 * Find the person with the specified Social Security Number
	 * @param SSN
	 * @return the person with the SSN.  null if not found
	 */
	public Person findPersonWithSSN(String SSN) {
		
		for (Person person : personList) {
			if (person.getSSN().equals(SSN))
				return person;
		}
		
		// if we get here, the SSN was not found in the list of people
		return null;
		
	}
}
