package edu.uci.x46010.team.b.app.data;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import edu.uci.x46010.team.b.app.middle.MenuOptionsList;
import edu.uci.x46010.team.b.app.middle.MenuOptions;

public class MenuOptionJDOM 
{
	/**
	 * Read in a XML file and return back the menu options maintained in the file.
	 * @param xmlFileName The name of the menu file.
	 * @return The MenuOptionList object.
	 * @throws Exception
	 */
	public MenuOptionsList readXMLFile (String xmlFileName) throws Exception
	{
		MenuOptionsList menuOptionList = null;
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(xmlFileName);
	
		try
		{
			// Build a JDOM Document from the XML file. If building the document is successful, then the
			// information will be available in a tree like structure.
			Document document = (Document) builder.build(xmlFile);
			
			// Get the root of the tree. For the crowd XML file, this should be <menuEntries>.
			Element menuNode = document.getRootElement();

			// Get a list of all of the <menuEntries> elements under the <menuItemEntry>.
			@SuppressWarnings("unchecked")
			List<Element> menuElementList = menuNode.getChildren(MenuOptionTags.MENU_ITEM_ENTRY_TAG);

			// Create a menuOptionList object as we've been successful parsing the XML elements.
			menuOptionList = new MenuOptionsList();

			// Go through each of the menu item elements found.
			for (int index = 0; index < menuElementList.size(); index++)
			{
				// Get the next menu item in the XML file.
				Element nextMenuNode = menuElementList.get(index);
				
				// Create a new menu item
				MenuOptions newMenu = new MenuOptions();
				
				// Copy the menu item sequence number
				newMenu.setMenuSequence(nextMenuNode.getChildText(MenuOptionTags.MENU_SEQUENCE_TAG));
				
				// Copy the menu item name
				newMenu.setMenuOptionName(nextMenuNode.getChildText(MenuOptionTags.MENU_OPTION_NAME_TAG));

				// Add the new menu option to the list of items.
				menuOptionList.add(newMenu);
			}
		}
		catch (IOException io)
		{
			throw new IOException(io.getMessage());
		}
		catch (JDOMException jdomex)
		{
			throw new JDOMException(jdomex.getMessage());
		}		
		
		return menuOptionList;
	}
}
