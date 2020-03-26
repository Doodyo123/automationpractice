package com.qtx.pages;

import org.openqa.selenium.WebDriver;

public class UserThreePage extends HoverPageObject{

	public UserThreePage(WebDriver driverInstance, String baseUrl) {
		
		super(driverInstance, baseUrl);
		
	}
	
	public String getPageUrl() {
		
		return driver.getCurrentUrl();
	
	}

}
