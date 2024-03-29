package edu.uci.x46010.team.b.app.userInterface;

import java.util.Scanner;
import edu.uci.x46010.team.b.app.middle.MenuOptionsList;
import edu.uci.x46010.team.b.app.middle.Person;

public class MainMenuUI 
{
	public static void DisplayMainMenu() {
	}

	// Display Main Menu
	public static void mainMenu(Person p, MenuOptionsList mainMenuList) {
		
		while( true )
		{
			System.out.println();
			System.out.println("Student Name: " + p.getFullName());
			System.out.println("Student ID:   " + p.getSSN());
			System.out.println();
			mainMenuList.listMenu();
			System.out.print("\nEnter selection: ");
			Scanner inputScanner = new Scanner(System.in);
			int opt = inputScanner.nextInt();
			System.out.println("selection = " + opt);
			
			switch (opt) {
			case 1: //view all courses
				break;
			case 2: //view enrolled courses
				break;
			case 3: //add course
				break;
			case 4: //drop course
				break;
			case 5: //logout
				return;
			default:
				System.out.println("Invalid selection!");
				break;
			}
			//..........
		} //end of while-loop
	}
		
}
