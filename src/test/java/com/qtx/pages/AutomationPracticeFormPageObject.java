package com.qtx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeFormPageObject extends SuperPageObject{

	@FindBy(css="input[name='firstname'][type='text']")
	private WebElement firstNameTextBox;
	@FindBy(css="input[name='lastname'][type='text']")
	private WebElement lastNameTextBox;
	
	public AutomationPracticeFormPageObject(WebDriver driver, String demoqaFormsUrl) {

		super(driver, demoqaFormsUrl);
		
	}

	public AutomationPracticeFormPageObject openAutomationWebPage() {

		String url = "";
		Navigate(url);
		return this;
		
	}

	public AutomationPracticeFormPageObject inputFirstName(String string) {

		firstNameTextBox.sendKeys(string);
		return this;
		
	}

	public AutomationPracticeFormPageObject inputLastName(String lastName) {

		return this;
		
	}

}
