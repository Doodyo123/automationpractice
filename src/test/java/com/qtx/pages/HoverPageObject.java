package com.qtx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HoverPageObject extends SuperPageObject{
	
	@FindBy(css="a[href='/users/3']")
	private WebElement figureThreeButton;
	@FindBy(xpath="//*[@id=\"content\"]/div/div[3]")
	private WebElement figureThree;
	
	public HoverPageObject(WebDriver driverInstance, String baseUrl) {
		
		super(driverInstance, baseUrl);
		
	}

	public HoverPageObject openHoverPage() {
		
		String url = "/hovers";
		Navigate(url);
		
		return this;
		
	}
	
	public HoverPageObject hoverToFigureThree() {
		
		Actions builder = new Actions(driver);
		builder.moveToElement(figureThree).build().perform();
		
		return this;
		
	}

	public String selectProfileThree() {
		
		figureThreeButton.click();
		UserThreePage userThreePage =  new UserThreePage
				(driver, "http://the-internet.herokuapp.com/users/3");
		
		return userThreePage.getPageUrl();
		
	}

}
