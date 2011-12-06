package edu.uci.x46010.team.b.app.userInterface;


import edu.uci.x46010.team.b.app.middle.LoginList;
import java.util.Scanner;


/**
 * This class can be used to display the login screen and return the login ID of the valid user
 * @author Dan
 *
 */
public final class UserLoginUI 
{

	/**
	 * default constructor
	 */
	public UserLoginUI() {
		
	}

	/**
	 * This function displays the login prompt and returns the login ID of a user that logs in successfully
	 * @param loginList the list of valid logins
	 * @return the login ID of the student that logs in successfully.  null if unsucessful
	 */
	public static String getValidLoginID(LoginList loginList) {
		
		while( true )
		{
			Scanner inputScanner = new Scanner(System.in);
			inputScanner.useDelimiter("\n");
			System.out.println("Student Registration System\n");
			System.out.print("Enter Login ID: ");
			String loginID = inputScanner.next();
			
			loginID = loginID.substring(0,loginID.length()-1);
			System.out.print("Enter Password: ");
			String password = inputScanner.next();
			password = password.substring(0,password.length()-1);
			if (loginList.findLogin(loginID, password))
				return loginID;
			
			System.out.println("Login ID = '" + loginID + "', password = '" + password + "'");
			
			System.out.println("Login ID or password is not valid");
		}
	}
		
}
