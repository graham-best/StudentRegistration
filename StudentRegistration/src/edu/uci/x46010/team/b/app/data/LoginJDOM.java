package edu.uci.x46010.team.b.app.data;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import edu.uci.x46010.team.b.app.middle.Login;
import edu.uci.x46010.team.b.app.middle.LoginList;


public class LoginJDOM 
{
	/**
	 * Read in a XML file and return back the login ID/password pairs
	 * @param xmlFileName The name of the catalog file.
	 * @return The LoginList object.
	 * @throws Exception
	 */
	public LoginList readXMLFile (String xmlFileName) throws Exception
	{
		LoginList loginList = null;

		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(xmlFileName);
		
		try
		{
			// Build a JDOM Document from the XML file. If building the document is successful, then the
			// information will be available in a tree like structure.
			Document document = (Document) builder.build(xmlFile);
			
			// Get the root of the tree. For the crowd XML file, this should be <catalog>.
			Element loginsNode = document.getRootElement();
			
			// Get a list of all of the <course> elements under the <catalog>.
			@SuppressWarnings("unchecked")
			List<Element> elementList = loginsNode.getChildren(LoginTags.LOGIN_TAG);
			
			// Create a Catalog object as we've been successful parsing the XML elements.
			loginList = new LoginList();
			
			// Go through each of the <login> elements found.
			for (int index = 0; index < elementList.size(); index++)
			{
				// Get the next <login> in the XML file.
				Element loginNode = elementList.get(index);
				
				// Create a new login
				Login newLogin = new Login();
				
				// Copy the login ID
				newLogin.setLoginID(loginNode.getChildText(LoginTags.LOGIN_ID_TAG));
				
				// Copy the password
				newLogin.setPassword(loginNode.getChildText(LoginTags.PASSWORD_TAG));
				
				
				// Add the new person to the crowd.
				loginList.add(newLogin);
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
		
		return loginList;
	}
	
	/**
	 * Write the Login List object to an XML file.
	 * @param xmlFileName
	 * @param loginList a LoginList which contains all logins
	 * @throws Exception
	 */
	public void writeXMLFile (String xmlFileName, LoginList loginList) throws Exception
	{
		// TODO: Create function to write the XML file for the Catalog object.
	
	}
}
