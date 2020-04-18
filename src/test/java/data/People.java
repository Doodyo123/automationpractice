package data;

import java.util.ArrayList;
import java.util.Date;

public class People {

	public static userData getJohnInfo() {
		ArrayList<String> continents = new ArrayList<String>();
		continents.add("Africa");
		continents.add("Australia");
		
		
		Date date = new Date();

		userData info = new userData ();
		info.setFirstName("John");
		info.setLastName("Doe");
		info.setGender("Male");
		info.setYearsOfExperience("1");
		info.setDate(date);
		info.setProfession("Manual Tester");
		info.setAutomationTool("Selenium Webdriver");
		info.setContinent("Africa");
		info.setSeleniumCommands("Wait Commands");
		info.setContinentList(continents);
		
		return info;
	}

}
