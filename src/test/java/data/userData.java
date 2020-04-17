package data;

import java.util.Date;

public class userData {
	
	private String firstName;
	private String lastName;
	private String gender;
	private String yearsOfExperience;
	private Date date;
	private String profession;
	private String automationTool;
	private String continent;
	private String seleniumCommands;
	
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setFirstName(String fName) {
		this.firstName = fName;
	}
	
	public void setLastName(String lName) {
		this.lastName = lName;
	}
	
	public void setGender(String sex) {
		this.gender = sex;
	}

	public String getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getAutomationTool() {
		return automationTool;
	}

	public void setAutomationTool(String automationTool) {
		this.automationTool = automationTool;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getSeleniumCommands() {
		return seleniumCommands;
	}

	public void setSeleniumCommands(String seleniumCommands) {
		this.seleniumCommands = seleniumCommands;
	}

}
