package com.qtx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeFormPageObject extends SuperPageObject{

	@FindBy(css="input[name='firstname'][type='text']")
	private WebElement firstNameTextBox;
	@FindBy(css="input[id='lastname'][type='text']")
	private WebElement lastNameTextBox;
	@FindBy(css="input[id='sex-0'][name='sex']")
	private WebElement genderMale;
	@FindBy(css="input[id='sex-1'][name='sex']")
	private WebElement genderFemale;
	@FindBy(xpath="//*[@id=\"exp-0\"]//parent::div")
	private WebElement experienceSelection;
	@FindBy(css="input[id='datepicker']")
	private WebElement dateTextBox;
	@FindBy(xpath="//*[@id=\"profession-0\"]//parent::div")
	private WebElement professionCheckBoxGroup;
	@FindBy(xpath="//*[@id=\"tool-0\"]//parent::div")
	private WebElement automationToolCheckBoxGroup;
	@FindBy(css="select[id='continents']")
	private WebElement continentSelect;
	@FindBy(css="Select[id='continentsmultiple']")
	private WebElement continentMultipleSelect;
	@FindBy(css="Select[id='selenium_commands']")
	private WebElement seleniumCommandsSelect;
	
	public AutomationPracticeFormPageObject(WebDriver driver, String demoqaFormsUrl) {

		super(driver, demoqaFormsUrl);
		
	}

	public AutomationPracticeFormPageObject openAutomationWebPage() {

		String url = "";
		Navigate(url);
		return this;
		
	}

	public AutomationPracticeFormPageObject inputFirstName(String firstName) {

		firstNameTextBox.sendKeys(firstName);
		return this;
		
	}

	public AutomationPracticeFormPageObject inputLastName(String lastName) {

		lastNameTextBox.sendKeys(lastName);
		return this;
		
	}

	public boolean isFirstNameAndLastNameFilled() {

		boolean isFilled = false;
				
		if (!firstNameTextBox.getAttribute("value").isEmpty()) {
			if (!lastNameTextBox.getAttribute("value").isEmpty()) {
				isFilled = true;
			}
		}
		return isFilled;
	}

	public AutomationPracticeFormPageObject selectGender(String gender) {

		if(gender.equals("Male")) {
			genderMale.click();
		} else if (gender.equals("Female")) {
			genderFemale.click();
		}
		
		return this;
		
	}

	public AutomationPracticeFormPageObject selectYearsOfExperience(String yearsOfExperience) {
		
		try {
			experienceSelection.findElement(By.cssSelector("input[value='"+ yearsOfExperience+"']")).click();
		} catch (Exception e) {
			System.out.println("That option does not exist or " + e);
		}
		return this;
		
	}

	public AutomationPracticeFormPageObject inputDate(String date) {

		dateTextBox.sendKeys(date);
		return this;
		
	}

	public AutomationPracticeFormPageObject selectProfession(String profession) {

		try {
			professionCheckBoxGroup.findElement(By.cssSelector("input[value='"+profession+"']")).click();
		} catch(Exception e){
			System.out.println("That option does not exist or " + e);			
		}
		
		return this;
		
	}

	public AutomationPracticeFormPageObject selectAutomationTool(String automationTool) {

		try {
			automationToolCheckBoxGroup.findElement(By.cssSelector("input[value='"+automationTool+"']")).click();
		} catch(Exception e) {
			System.out.println("That option does not exist or " + e);
		}
		
		return this;
		
	}

	public AutomationPracticeFormPageObject selectContinent(String continent) {

		try {
			continentSelect.findElement(By.linkText(continent)).click();			
		} catch (Exception e) {
			System.out.println("There is no match for " + continent);
		}
		return this;
		
	}

	public AutomationPracticeFormPageObject selectMultipleContinents(String continent) {

		try {
			continentMultipleSelect.findElement(By.linkText(continent)).click();
		} catch (Exception e) {
			System.out.println("There is no match for " + continent);
		}
		return this;
		
	}

	public AutomationPracticeFormPageObject selectSeleniumCommand(String seleniumCommands) {

		try {
			seleniumCommandsSelect.findElement(By.linkText(seleniumCommands)).click();
		} catch (Exception e) {
			System.out.println("There is no match for " + seleniumCommands);
		}
		return this;
		
	}

}
