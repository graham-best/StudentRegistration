package edu.uci.x46010.team.b.app.middle;

import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Person implements Comparable<Object>
{
	/**
	 * Used to keep track of the person's gender.
	 */
	public enum Gender
	{
		MALE,
		FEMALE,
		UNKNOWN;
	
		/**
		 * Convert the gender of the person from an enum to a string.
		 * @return The gender of the person in string format.
		 */
		public static String convertGenderToString(Gender gender)
		{
			if (gender == Gender.MALE)
			{
				return "Male";
			}
			else if (gender == Gender.FEMALE)
			{
				return "Female";
			}

			return "Unknown";
		}		
	
		/**
		 * Convert the gender of the person from a string to an enum.
		 * @param genderString
		 * @return
		 */
		public static Gender convertStringToGender(String genderString)
		{
			// Get the first letter of the gender.
			String shortGenderString;
			shortGenderString = genderString.toLowerCase().substring(0, 1);
		
			if (shortGenderString.equals("m"))
			{
				return Gender.MALE;
			}
			else if (shortGenderString.equals("f"))
			{
				return Gender.FEMALE;

			}

			return Gender.UNKNOWN;
		}
	}
	
	/**
	 * The first name of the person.
	 */
	protected String firstName;
	
	/**
	 * The last name of the person.
	 */
	protected String lastName;
	
	/**
	 * The gender of the person. Can be male, female or unknown.
	 */
	protected Gender gender;
	
	/**
	 * The Social Security Number of the person. This really should be encrypted, but it would take  
	 * more time than I have for this assignment.
	 */
	protected String SSN;

	/**
	 * The Java GregorianCalendar representing the person's birthday.
	 * Using the Java data type 'GregorianCalendar' instead of 'Date'.
	 * The reason I've found is that GregorianCalendar is preferred as the Date type may not be localized for
	 * various geographical regions. We'll be assuming that the GregorainCalendar is used in this class.
	 */
	protected GregorianCalendar birthDate;	
	
	/**
	 * Default constructor
	 */
	public Person()
	{
		this.firstName = "unknown";
		this.lastName = "unknown";
		this.gender = Gender.UNKNOWN;
		this.SSN = "unknown";
		
		// Get the current date as the birth date.
		this.birthDate = new GregorianCalendar();
	}
	
	/**
	 * The Person constructor with the Java Calendar.
	 * @param firstName First name of the person.
	 * @param lastName Last name of the person.
	 * @param gender Gender of the person.
	 * @param SSN Social security number of the person.
	 * @param birthCalendar Birthday of the person.
	 */
	public Person (String firstName, 
			       String lastName, 
			       Gender gender, 
			       String SSN, 
			       GregorianCalendar birthCalendar)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.SSN = SSN;
		this.birthDate = birthCalendar;
	}

	/**
	 * Get the first name of the person
	 * @return The person's first name.
	 */
	public String getFirstName() 
	{
		return firstName;
	}

	/**
	 * Set the first name of the person
	 * @param firstName The first name of the person
	 */
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	/**
	 * Get the last name of the person
	 * @return The last name of the person.
	 */
	public String getLastName() 
	{
		return lastName;
	}

	/**
	 * Set the last name of the person
	 * @param lastName The last name of the person.
	 */
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	/**
	 * Get the first and last name of the person
	 * @return The first and last name of the person
	 */
	public String getFullName()
	{
		return this.firstName + " " + this.lastName;
	}
	
	/**
	 * Get the gender of the person
	 * @return The gender of the person
	 */
	public Gender getGender() 
	{
		return gender;
	}

	/**
	 * Set the gender of the person
	 * @param gender The gender of the person
	 */
	public void setGender(Gender gender) 
	{
		this.gender = gender;
	}

	/**
	 * Get the Social Security Number of the person in the form of a string
	 * @return The Social Security Number of the person
	 */
	public String getSSN() 
	{
		return SSN;
	}

	/**
	 * Set the Social Security Number of the person in the form of a string
	 * @return The Social Security Number of the person
	 */
	public void setSSN(String SSN) 
	{
		this.SSN = SSN;
	}

	/**
	 * Get the Java GregorianCalendar representing the person's birthday.
	 * @return The Java GregorianCalendar representing the person's birthday.
	 */
	public GregorianCalendar getBirthDate() 
	{
		return birthDate;
	}
	
	/**
	 * Set the Java GregorianCalendar representing the person's birthday.
	 * @param birthCalendar The Java Calendar representing the person's birthday.
	 */
	public void setBirthDate(GregorianCalendar birthDate) 
	{
		this.birthDate = birthDate;
	}
	
	/**
	 * Get the age of the person in years.
	 * I decided to figure out how to compute the age of the person rather than just pass an integer back and
	 * forth. Curse my engineer personality. This function isn't completely accurate, as it should do some
	 * checking to see if the date exists. But I guess the point of this exercise is to learn something, and
	 * I decided to challenge myself to see if I could figure this out.
	 * The basic function was taken from here and improved:
	 * http://sanjaal.com/java/404/java-date-time-calendar/calculating-age-in-java-from-birth-date/
	 * @return The age of the person.
	 */
	public int getAge()
	{
		// Get the current date.
		GregorianCalendar nowCalendar = new GregorianCalendar();
		
		// Get a rough idea of the age based on the year. 
		// Assume that the person was in the same time zone where the program are running. Otherwise you would 
		// have to set the time zone from where the person was born, and the time zone of the running 
		// process. We don't really need that much detail.
		// Also assume that the Calendar object for the person's birthday is valid. Need to add exception
		// handling...
		int age = nowCalendar.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
		
		// Figure out if the person has had their birthday this year or not.
		// Determine if the month the person was born is later this year.
		boolean isBirthMonthLater = birthDate.get(Calendar.MONTH) >= nowCalendar.get(Calendar.MONTH);
		
		// It may also be that this month is the month that the person was born, but it's later this month.
		boolean isBirthdayLaterThisMonth = birthDate.get(Calendar.MONTH) == nowCalendar.get(Calendar.MONTH)
				&& birthDate.get(Calendar.DAY_OF_MONTH) > nowCalendar.get(Calendar.DAY_OF_MONTH);
				
		// If either of the above checks are true, the the person hasn't had their birthday this year.
		if (isBirthMonthLater || isBirthdayLaterThisMonth)
		{
			age = age - 1;
		}
		
		return age;
	}
	
	/**
	 * Talk
	 * @return Random talk
	 */
	public String talk()
	{
		return "Blah, blah, blah...";
	}
	
	/**
	 * Information about the person in a string.
	 */
	public String toString()
	{
		String output;
		output = getFullName() + " Gender: ";
		output += Gender.convertGenderToString(this.gender);
		output += " SSN: " + this.SSN + " Age: " + this.getAge();
		return output;
	}

	@Override
	/**
	 * Compare the age of two people.
	 */
	public int compareTo(Object anotherPerson) throws ClassCastException 
	{
	    if (!(anotherPerson instanceof Person))
	    {
	        throw new ClassCastException("A Person object expected.");
	    }
	    
	    int anotherPersonAge = ((Person) anotherPerson).getAge();  
	    return this.getAge() - anotherPersonAge;   
	}	

	/**
	 * Compare the last name of two people.
	 */
	public static Comparator<Person> LastNameComparator = new Comparator<Person>() 
	{
		public int compare(Person person, Person anotherPerson) 
		{
			String lastName1 = person.getLastName().toUpperCase();
		    String firstName1 = person.getFirstName().toUpperCase();
		    String lastName2 = anotherPerson.getLastName().toUpperCase();
		    String firstName2 = anotherPerson.getFirstName().toUpperCase();

		    if (!(lastName1.equals(lastName2)))
		        return lastName1.compareTo(lastName2);
		    else
		        return firstName1.compareTo(firstName2);
		}
	};
	
	/**
	 * Compare the first name of two people.
	 */
	public static Comparator<Person> FirstNameComparator = new Comparator<Person>() 
	{
		public int compare(Person person, Person anotherPerson) 
		{
			String lastName1 = person.getLastName().toUpperCase();
			String firstName1 = person.getFirstName().toUpperCase();
			String lastName2 = anotherPerson.getLastName().toUpperCase();
			String firstName2 = anotherPerson.getFirstName().toUpperCase();

			if (!(firstName1.equals(firstName2)))
				return firstName1.compareTo(firstName2);
			else
				return lastName1.compareTo(lastName2);
	    }
	};
}

