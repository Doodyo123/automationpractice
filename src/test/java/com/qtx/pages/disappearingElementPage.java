package com.qtx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class disappearingElementPage extends SuperPageObject{
	
	@FindBy(css="a[href='/gallery/']")
	private WebElement galleryButton;

	public disappearingElementPage(WebDriver driverInstance, String baseUrl) {
		
		super(driverInstance, baseUrl);
		
	}

	public disappearingElementPage opendisappearingElementPage() {

		String url = "/disappearing_elements";
		Navigate(url);
		return this;
	}

	public boolean refreshPageUntilButtonIsClickable() {
		
		boolean isButtonClickable;
		WebDriverWait wait = new WebDriverWait(driver, 1);
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(galleryButton));
			if (galleryButton.isDisplayed()) {
				isButtonClickable = true;
			} else {
				isButtonClickable = false;
			}
		} catch (Exception e) {
			driver.get(driver.getCurrentUrl());
			return refreshPageUntilButtonIsClickable();
		}
		return isButtonClickable;
	}

}
