package com.qtx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPageObject extends SuperPageObject{
	
	@FindBy(css="a[href='/windows/new']")
	WebElement clickHereButton;
	
	private String text;
	private String mainWindow;

	public WindowsPageObject(WebDriver driverInstance, String baseUrl) {
		
		super(driverInstance, baseUrl);
		
	}

	public WindowsPageObject openWindowsPageObject() {

		String url = "/windows";
		Navigate(url);
		return this;
		
	}

	public WindowsPageObject clickButtonToOpenNewTab() {
		
		mainWindow = driver.getWindowHandle();
		clickHereButton.click();
		return this;
		
	}

	public WindowsPageObject grabTextFromNewTab() {
		
		NewTabPageObject newTab = new NewTabPageObject
				(driver, "http://the-internet.herokuapp.com/windows/new");
		
		newTab.setDriver();
		
		text = newTab.getText();
		driver.switchTo().window(mainWindow);
		return this;		
		
	}

	public String getText() {

		return text;
		
	}

}
