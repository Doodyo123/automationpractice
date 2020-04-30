package com.qtx.pages;

import java.util.List;

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

	private WebElement profession;
	private WebElement automationTool;
	private WebElement experience;
	private WebElement continentMultiple;
	private WebElement seleniumCommand;
	private WebElement continent;

	private List<WebElement> continents;
	private List<WebElement> seleniumCommands;

	private boolean isContinentMultipleSelected;
	private boolean isSeleniumCommandSelected;
	private boolean isContinentSelected;

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
			this.experience = experienceSelection.findElement(By.cssSelector("input[value='"+ yearsOfExperience+"']"));
			this.experience.click();
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
			this.profession = professionCheckBoxGroup.findElement(By.cssSelector("input[value='"+profession+"']"));
			this.profession.click();
		} catch(Exception e){
			System.out.println("That option does not exist or " + e);			
		}

		return this;

	}

	public AutomationPracticeFormPageObject selectAutomationTool(String automationTool) {

		try {
			this.automationTool = automationToolCheckBoxGroup.findElement(By.cssSelector("input[value='"+automationTool+"']"));
			this.automationTool.click();
		} catch(Exception e) {
			System.out.println("That option does not exist or " + e);
		}

		return this;

	}

	public AutomationPracticeFormPageObject selectContinent(String continent) {

		String continentName;
		try {
			this.continentSelect.click();
			this.continents = continentSelect.findElements(By.tagName("option"));
			for(WebElement tempContinent : continents) {
				continentName = tempContinent.getText();
				if(continentName.equals(continent)) {
					this.continent = tempContinent;
					this.continent.click();
					this.isContinentMultipleSelected = true;
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("There is no match for " + continent);
		}
		return this;

	}

	public AutomationPracticeFormPageObject selectMultipleContinents(List<String> list) {

		String continentName;
		try {
			continents = continentMultipleSelect.findElements(By.tagName("option"));
			for(WebElement tempContinent : continents) {
				continentName = tempContinent.getText();
				for(String item : list) {
					if(continentName.equals(item)) {
						this.continentMultiple = tempContinent;
						this.continentMultiple.click();
						this.isSeleniumCommandSelected = true;
					}
				}

			}

		} catch (Exception e) {
			System.out.println("There is no match for " + list);
		}
		return this;

	}

	public AutomationPracticeFormPageObject selectSeleniumCommand(String seleniumCommands) {

		String seleniumCommandText;
		try {
			this.seleniumCommands = seleniumCommandsSelect.findElements(By.tagName("option"));
			for(WebElement tempSeleniumCommand : this.seleniumCommands) {
				seleniumCommandText = tempSeleniumCommand.getText();
				if(seleniumCommandText.equals(seleniumCommands)) {
					this.seleniumCommand = tempSeleniumCommand;
					this.seleniumCommand.click();
					this.isContinentSelected = true;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("There is no match for " + seleniumCommands);
		}
		return this;

	}

	public boolean areFieldsCompleted() {
		boolean complete = false;
		if(!firstNameTextBox.getAttribute("value").isEmpty()) {
			if(!lastNameTextBox.getAttribute("value").isEmpty()) {
				if( this.profession.isSelected()) {
					if(this.automationTool.isSelected()) {
						if(this.isContinentSelected) {
							if(this.isContinentMultipleSelected) {
								if(this.isSeleniumCommandSelected) {
									if(this.experience.isSelected()) {
										complete = true;
									}
								}
							}
						}
					}
				}
			}
		}else {
			complete = false;
		}
		return complete;
	}
}
