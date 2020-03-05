package com.qtx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class SuperPageObject {

	protected WebDriver driver;
	protected String bassUrl;
	
	protected SuperPageObject(WebDriver driverInstance, String baseUrl) {
		
		driver = driverInstance;
		PageFactory.initElements(driver, this);
		bassUrl = baseUrl;
		
	}
	
	protected void Navigate(String url) {
			
		driver.get(bassUrl + url);
		
	}
	

}
