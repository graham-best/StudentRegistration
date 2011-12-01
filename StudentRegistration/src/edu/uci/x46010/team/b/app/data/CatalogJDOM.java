package edu.uci.x46010.team.b.app.data;

import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import edu.uci.x46010.team.b.app.helper.CalendarUtils;
import edu.uci.x46010.team.b.app.helper.SimpleTime;
import edu.uci.x46010.team.b.app.middle.Catalog;
import edu.uci.x46010.team.b.app.middle.Course;

public class CatalogJDOM 
{
	/**
	 * Read in a XML file and return back the Catalog object.
	 * @param xmlFileName The name of the catalog file.
	 * @return The Catalog object.
	 * @throws Exception
	 */
	public Catalog readXMLFile (String xmlFileName) throws Exception
	{
		Catalog catalog = null;

		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(xmlFileName);
		
		try
		{
			// Build a JDOM Document from the XML file. If building the document is successful, then the
			// information will be available in a tree like structure.
			Document document = (Document) builder.build(xmlFile);
			
			// Get the root of the tree. For the crowd XML file, this should be <catalog>.
			Element catalogNode = document.getRootElement();
			
			// Get a list of all of the <course> elements under the <catalog>.
			@SuppressWarnings("unchecked")
			List<Element> elementList = catalogNode.getChildren(CatalogTags.COURSE_TAG);
			
			// Create a Catalog object as we've been successful parsing the XML elements.
			catalog = new Catalog();
			
			// Go through each of the <course> elements found.
			for (int index = 0; index < elementList.size(); index++)
			{
				// Get the next <course> in the XML file.
				Element courseNode = elementList.get(index);
				
				// Create a new person.
				Course newCourse = new Course(); 
				
				// Copy the course name.
				newCourse.setName(courseNode.getChildText(CatalogTags.NAME_TAG));
				
				// Copy the course number.
				newCourse.setNumber(courseNode.getChildText(CatalogTags.NUMBER_TAG));
				
				// Copy the course description.
				newCourse.setDescription(courseNode.getChildText(CatalogTags.DESCRIPTION_TAG));
				
				// Copy the course units.
				newCourse.setUnits(Float.parseFloat(courseNode.getChildText(CatalogTags.UNITS_TAG)));
				
				// Get the starting date
				GregorianCalendar startDate;
				startDate=CalendarUtils.createGregorianCalendar(courseNode.getChildText(CatalogTags.START_DATE_YEAR_TAG),
						                                        courseNode.getChildText(CatalogTags.START_DATE_MONTH_TAG),
						                                        courseNode.getChildText(CatalogTags.START_DATE_DAY_TAG));
				
				// Copy the starting date
				newCourse.setStartDate(startDate);
				
				// Get the ending date
				GregorianCalendar endDate;
				endDate=CalendarUtils.createGregorianCalendar(courseNode.getChildText(CatalogTags.END_DATE_YEAR_TAG),
						                                      courseNode.getChildText(CatalogTags.END_DATE_MONTH_TAG),
						                                      courseNode.getChildText(CatalogTags.END_DATE_DAY_TAG));
				
				// Copy the ending date
				newCourse.setEndDate(endDate);
				
				// Copy the day of the week.
				newCourse.setDayOfWeek(CalendarUtils.convertToDayOfWeekValue(CatalogTags.DAY_OF_WEEK_TAG));
				
				// Get the starting time
				SimpleTime startTime;
				startTime = new SimpleTime(courseNode.getChildText(CatalogTags.START_TIME_HOUR_TAG),
						                   courseNode.getChildText(CatalogTags.START_TIME_MINUTE_TAG),
						                   courseNode.getChildText(CatalogTags.START_TIME_AM_PM_TAG));
				
				// Copy the starting time
				newCourse.setStartTime(startTime);
				
				// Get the ending time
				SimpleTime endTime;
				endTime = new SimpleTime(courseNode.getChildText(CatalogTags.END_TIME_HOUR_TAG),
						                 courseNode.getChildText(CatalogTags.END_TIME_MINUTE_TAG),
						                 courseNode.getChildText(CatalogTags.END_TIME_AM_PM_TAG));
				
				// Copy the starting time
				newCourse.setEndTime(endTime);
				
				// Copy the maximum enrollment
				newCourse.setMaximumEnrollment(Integer.parseInt(courseNode.getChildText(CatalogTags.MAXIMUM_ENROLLMENT_TAG)));
				
				// Add the new person to the crowd.
				catalog.add(newCourse);
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
		
		return catalog;
	}
	
	/**
	 * Write the Catalog object to an XML file.
	 * @param xmlFileName
	 * @param catalog
	 * @throws Exception
	 */
	public void writeXMLFile (String xmlFileName, Catalog catalog) throws Exception
	{
		// TODO: Create function to write the XML file for the Catalog object.
	
	}
}
