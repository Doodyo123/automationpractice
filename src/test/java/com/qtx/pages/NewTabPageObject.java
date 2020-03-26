package com.qtx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewTabPageObject extends SuperPageObject{

	public NewTabPageObject(WebDriver driverInstance, String baseUrl) {
		
		super(driverInstance, baseUrl);
		
	}

	public String getText() {
		
		return driver.findElement(By.cssSelector("div[class='example']")).getText();
		
	}

	public void closeTab() {
		
		driver.close();
		
	}

	public NewTabPageObject setDriver() {

		driver.get("http://the-internet.herokuapp.com/windows/new");
		return this;
		
	}

}
