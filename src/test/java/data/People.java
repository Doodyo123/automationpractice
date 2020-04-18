package data;

import java.util.Date;

public class People {

	public static userData getJohnInfo() {
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
		
		return info;
	}

}
