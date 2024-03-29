package edu.uci.x46010.team.b.app.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.xpath.XPath;

import edu.uci.x46010.team.b.app.helper.CalendarUtils;
import edu.uci.x46010.team.b.app.middle.Crowd;
import edu.uci.x46010.team.b.app.middle.Person;
import edu.uci.x46010.team.b.app.middle.Person.Gender;

public class CrowdJDOM 
{
	/**
	 * Read in a XML file and return a Crowd object.
	 * Heavily modified from the following website:
	 * http://www.mkyong.com/java/how-to-read-xml-file-in-java-jdom-example/
	 * @param xmlFileName The name of the XML file to parse.
	 * @return The Crowd object.
	 * @throws Exception
	 */
	public Crowd readXMLFile (String xmlFileName) throws Exception
	{
		Crowd crowd = null;
		
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(xmlFileName);
		
		try
		{
			// Build a JDOM Document from the XML file. If building the document is successful, then the
			// information will be available in a tree like structure.
			Document document = (Document) builder.build(xmlFile);
			
			// Get the root of the tree. For the crowd XML file, this should be <crowd>.
			Element crowdNode = document.getRootElement();
			
			// Get a list of all of the <person> elements under the <crowd>.
			@SuppressWarnings("unchecked")
			List<Element> elementList = crowdNode.getChildren(CrowdTags.PERSON_TAG);
			
			// Create a Crowd object as we've been successful parsing the XML elements.
			crowd = new Crowd();
			
			// Go through each of the <person> elements found.
			for (int index = 0; index < elementList.size(); index++)
			{
				// Get the next <person> in the XML file.
				Element personNode = elementList.get(index);
				
				// Create a new person.
				Person newPerson = new Person();
				
				// Copy the person's first name.
				newPerson.setFirstName(personNode.getChildText(CrowdTags.FIRST_NAME_TAG));
				
				// Copy the person's last name.
				newPerson.setLastName(personNode.getChildText(CrowdTags.LAST_NAME_TAG));				
				
				// Copy the person's gender.
				newPerson.setGender(Gender.convertStringToGender(personNode.getChildText(CrowdTags.GENDER_TAG)));
				
				// Copy the person's Social Security Number.
				newPerson.setSSN(personNode.getChildText(CrowdTags.SOCIAL_SECURITY_NUMBER_TAG));
				
				// Get the person's birth date.
				GregorianCalendar birthDate;
				birthDate=CalendarUtils.createGregorianCalendar(personNode.getChildText(CrowdTags.BIRTH_YEAR_TAG),
						                                        personNode.getChildText(CrowdTags.BIRTH_MONTH_TAG),
						                                        personNode.getChildText(CrowdTags.BIRTH_DAY_TAG));
				
				// Copy the person's birth date.
				newPerson.setBirthDate(birthDate);
				
				// Add the new person to the crowd.
				crowd.add(newPerson);
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
		
		return crowd;
	}

	/**
	 * Write a XML file with a Crowd object.
	 * Heavily modified from the following website:
	 * http://www.mkyong.com/java/how-to-create-xml-file-in-java-jdom-parser/
	 * @param xmlFileName The name of the XML file to write.
	 * @param crowd
	 * @throws Exception
	 */
	public void writeXMLFile (String xmlFileName, Crowd crowd) throws Exception
	{
		try
		{
			// Create the root node of the Document tree.
			Element crowdNode = new Element(CrowdTags.CROWD_TAG);
	
			// Build a JDOM Document from the XML file. Make the crowd the root element.
			Document document = new Document (crowdNode);
			
			// Go through the each person in the crowd.
			for (Person person : crowd.getPersonList())
			{
				// Get the calendar for the birth date.
				GregorianCalendar birthDate = person.getBirthDate();
				
				// Copy the information from the Person object to the <person> element.
				Element personNode = new Element(CrowdTags.PERSON_TAG);
				personNode.addContent(new Element(CrowdTags.FIRST_NAME_TAG).setText(person.getFirstName()));
				personNode.addContent(new Element(CrowdTags.LAST_NAME_TAG).setText(person.getLastName()));
				personNode.addContent(new Element(CrowdTags.GENDER_TAG).setText(Gender.convertGenderToString(person.getGender())));
				personNode.addContent(new Element(CrowdTags.SOCIAL_SECURITY_NUMBER_TAG).setText(person.getSSN()));
				personNode.addContent(new Element(CrowdTags.BIRTH_YEAR_TAG).setText(CalendarUtils.convertToYearString(birthDate)));
				personNode.addContent(new Element(CrowdTags.BIRTH_MONTH_TAG).setText(CalendarUtils.convertToMonthString(birthDate)));
				personNode.addContent(new Element(CrowdTags.BIRTH_DAY_TAG).setText(CalendarUtils.convertToDayOfMonthString(birthDate)));
			
				// Add the <person> information to the document tree.
				document.getRootElement().addContent(personNode);
			}
			
			// Create a class to write the XML data.
			XMLOutputter xmlOutput = new XMLOutputter();
			
			// Magic!
			xmlOutput.setFormat(Format.getPrettyFormat());
			
			// Write the XML file.
			xmlOutput.output(document, new FileWriter(xmlFileName));
		}
		catch (IOException io)
		{
			throw new IOException(io.getMessage());
		}
	}
	
	/**
	 * Use the Jaxen library to count the number of <person> elements that have a matching last name.
	 * @param xmlFileName The XML file to search for.
	 * @param matchingLastName The last name to count.
	 * @return The number of <person> elements that match the last name.
	 * @throws Exception
	 */
	// TODO: Use this function as a basis to see how many students are enrolled in a course.
	public int countLastName(String xmlFileName, String matchingLastName) throws Exception
	{
		int count = 0;
		
		try
		{
			SAXBuilder builder = new SAXBuilder();
			Document document = (Document) builder.build(xmlFileName);
			
			// Create a query for the XML document to find all of the <person> elements matching the last name.
			XPath xpath = XPath.newInstance("/crowd/person[last_name='" + matchingLastName + "']"); 
			
			// Get the list of <person> elements matching the query.
			@SuppressWarnings("unchecked")
			List<Element> elementList = xpath.selectNodes(document);
			
			// Remember the number of <person> elements.
			count = elementList.size();
		}
		catch (IOException io)
		{
			throw new IOException(io.getMessage());
		}
		catch (JDOMException jdomex)
		{
			throw new JDOMException(jdomex.getMessage());
		}

		return count;
	}
	
	/**
	 * Count the number of <person> elements that have a matching last name without the Jaxen library.
	 * @param xmlFileName The XML file to search for.
	 * @param matchingLastName The last name to count.
	 * @return The number of <person> elements that match the last name.
	 * @throws Exception
	 */
	public int countLastNameWithoutJaxen(String xmlFileName, String matchingLastName) throws Exception
	{
		int count = 0;
		Crowd crowd = null;
		
		try
		{
			// Read the XML file.
			crowd = readXMLFile(xmlFileName);
			
			// Go through each of the person objects.
			ArrayList<Person> personList = crowd.getPersonList();
			
			for (Person person : personList)
			{
				if (person.getLastName().equals(matchingLastName)) count++;
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

		return count;
	}
	
	
	public void changeLastName(String xmlFileName, 
			                   String matchingLastName, 
			                   String changeToLastName) throws Exception
	{
		try
		{
			SAXBuilder builder = new SAXBuilder();
			Document document = (Document) builder.build(xmlFileName);
			
			// Create a query for the XML document to find all of the <person> elements matching the last name.
			XPath xpath = XPath.newInstance("/crowd/person[last_name='" + matchingLastName + "']/last_name"); 
			
			// Get the list of <person> elements matching the query.
			@SuppressWarnings("unchecked")
			List<Element> elementList = xpath.selectNodes(document);

			Iterator<Element> iter=elementList.iterator();
			while(iter.hasNext()) 
			{
			    //Element element = (Element) iter.next();
			    //element.setText(changeToLastName);
			}
			
			// Create a class to write the XML data.
			XMLOutputter xmlOutput = new XMLOutputter();
			
			// Magic!
			xmlOutput.setFormat(Format.getPrettyFormat());
			
			// Write the XML file.
			xmlOutput.output(document, new FileWriter(xmlFileName));
		}
		catch (IOException io)
		{
			throw new IOException(io.getMessage());
		}
		catch (JDOMException jdomex)
		{
			throw new JDOMException(jdomex.getMessage());
		}
	}
}
