package com.qtx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject extends SuperPageObject{
	
	@FindBy(id="username")
	private WebElement userNameTextBox;
	@FindBy(id="password")
	private WebElement passwordTextBox;
	@FindBy(tagName="button")
	private WebElement submitBox;
	
	public LoginPageObject(WebDriver driverInstance, String url) {
		
		super(driverInstance, url);
		
	}
	
	public LoginPageObject OpenLoginPage() {
		
		String url = "/login";
		Navigate(url);
		return this;
		
	}

	public SecurePageObject login(String userName, String password) {

		userNameTextBox.sendKeys(userName);
		passwordTextBox.sendKeys(password);
		submitBox.click();
		return new SecurePageObject(driver, bassUrl);
		
	}
	
	

}
