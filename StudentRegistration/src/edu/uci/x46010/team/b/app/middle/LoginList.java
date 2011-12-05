package edu.uci.x46010.team.b.app.middle;

import java.util.ArrayList;


/**
 * The LoginList object is the collection of all login IDs and password pairs
 * @author Dan Masters
 *
 */
public class LoginList 
{
	/**
	 * this holds all of the unique login ID / password names
	 */
	protected ArrayList<Login> loginList;
	
	

	/**
	 * search through the log ins and return the Login with the specified ID
	 * @param loginID
	 * @return
	 */
	private Login findLogin(String loginID) {
		for (Login login : loginList) {
			if (login.loginID.equals(loginID))
				return login;
		}
		
		return null;
	}
	
	/**
	 * Default constructor
	 */
	public LoginList()
	{
		this.loginList = new ArrayList<Login>();
	}
	
	/**
	 * add the new log in to the list of login names
	 * @param login the login object to add to the list
	 */
	public void add(Login login) {
		Login existingLogin = findLogin(login.getLoginID());
		
		if (existingLogin == null) {
			loginList.add(login);
			return;
		}
		
		// TODO:  should we throw an exception if the login already exists?
	}
	
	public void remove(String loginID) {
		Login existingLogin = findLogin(loginID);
		if (existingLogin == null) {
			// TODO:  should we throw an exception here?
			return;
		}
		
		loginList.remove(existingLogin);	
	}
	
	/**
	 * Find a valid login where the ID and password match what is in the list
	 * @param loginID the login ID to look for (case insensitive)
	 * @param password the password to look for (case sensitive)
	 * @return true if the login is valid, false if the login is not valid
	 */
	public boolean findLogin(String loginID, String password) {
		for (Login login : loginList) {
			if (login.getLoginID().equalsIgnoreCase(loginID) && login.getPassword().equals(password))
				return true;
		}
		
		// if we get here, we didn't find the login name
		return false;
	}

}
