package edu.uci.x46010.team.b.app.middle;

import java.util.ArrayList;


/**
 * The MenuOptionList object is the collection of menu options
 * @author Russell Reed
 *
 */
public class MenuOptionsList 
{
	/**
	 * Holds all of the menu options for the specified menu.
	 */
	protected ArrayList<MenuOptions> menuOptionList;
	/**
	 * Default constructor
	 */
	public MenuOptionsList()
	{
		this.menuOptionList = new ArrayList<MenuOptions>();
	}
	
	/**
	 * add the new menu item to the menu item list
	 * @param MenuOptions, the menu item object to add to the list
	 */
	public void add(MenuOptions menuItem) {
		menuOptionList.add(menuItem);
	}

	public void listMenu() {
		for (MenuOptions menuItem : menuOptionList) {
			System.out.println(menuItem.getMenuSequence() + ") " + menuItem.getMenuOptionName());			 
		}
	}
}
