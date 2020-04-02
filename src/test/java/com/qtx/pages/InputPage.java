package com.qtx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InputPage extends SuperPageObject{
	
	@FindBy(css="input[type='number']")
	private WebElement inputTextBox;

	public InputPage(WebDriver driverInstance, String baseUrl) {
		
		super(driverInstance, baseUrl);
		
	}

	public InputPage navigate() {
		
		String url = "/inputs";
		Navigate(url);
		
		return this;
		
	}

	public InputPage setInputValue(int number) {
		
		inputTextBox.sendKeys(String.valueOf(number));
		
		return this;
		
	}

	public int getInputValue() {
		
		String value = inputTextBox.getAttribute("value");
		
		return Integer.parseInt((String) value);
		
	}
	
}
