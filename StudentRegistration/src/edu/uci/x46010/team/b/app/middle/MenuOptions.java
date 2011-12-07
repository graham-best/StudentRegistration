package edu.uci.x46010.team.b.app.middle;

/**
 * The MenuOptions class defines the menu options displayed for the user.
 * @author Russell Reed
 *
 */
public class MenuOptions
{
	protected String menuOptionSequence=null;
	protected String menuOptionName=null;

	public MenuOptions() {
	}

	public void setMenuSequence(String sequenceNumber) {
		menuOptionSequence = sequenceNumber;
	}

	public void setMenuOptionName(String optionName) {
		menuOptionName = optionName;
	}

	public String getMenuSequence() {
		return menuOptionSequence;
	}

	public String getMenuOptionName() {
		return menuOptionName;
	}
}