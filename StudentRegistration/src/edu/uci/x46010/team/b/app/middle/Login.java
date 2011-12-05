package edu.uci.x46010.team.b.app.middle;

/**
 * The Login class is an association of a login ID with a password
 * @author Dan Masters
 *
 */
public class Login
{
	
	/**
	 * The login ID for the student
	 */
	protected String loginID;
	
	/**
	 * The password for the login ID
	 */
	protected String password;
	
	/**
	
	/**
	 * Default constructor
	 */
	public Login()
	{
		this.loginID = "unknown";
		this.password = "unknown";
	}
	
	/**
	 * The Login constructor with initialization
	 * @param firstName First name of the person.
	 * @param lastName Last name of the person.
	 * @param gender Gender of the person.
	 * @param SSN Social security number of the person.
	 * @param birthCalendar Birthday of the person.
	 */
	public Login (String loginID,String password)
	{
		this.loginID = loginID;
		this.password = password;
	}

	/**
	 * Get the login ID
	 * @return The person's login ID
	 */
	public String getLoginID() 
	{
		return this.loginID;
	}

	/**
	 * Set the login ID
	 * @param loginID the login ID of the account
	 */
	public void setLoginID(String loginID) 
	{
		this.loginID = loginID;
	}
	
	/**
	 * Get the password of the login
	 * @return The password of the login
	 */
	public String getPassword() 
	{
		return this.password;
	}

	/**
	 * Set the last name of the person
	 * @param password The password of the login
	 */
	public void setPassword(String password) 
	{
		this.password = password;
	}
}

