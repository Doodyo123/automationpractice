
package com.qtx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qtx.functions.Functions;

public class HomePageObject extends SuperPageObject{
	
	@FindBy(css="ul[id='home-page-tabs']")
	private WebElement buttonGroup;
	
	private WebElement buttonOne;
	private WebElement buttonTwo;

	Functions function = new Functions();

	public WebElement getWebElement(WebElement element, String tagName, int index) {

		return function.getGroupOfElementsByTagName(element, tagName).get(index);

	}
	
	public HomePageObject getButtonOne() {
		buttonOne = getWebElement(buttonGroup, "li", 0);
		buttonOne.click();
		return this;
	}
	
	public HomePageObject getButtonTwo() {
		buttonTwo = getWebElement(buttonGroup, "li", 1);
		buttonTwo.click();
		return this;
	}

	public HomePageObject(WebDriver webDriverInstance, String domainNameInstance) {
		super(webDriverInstance, domainNameInstance);
	}

	public HomePageObject openHomePage() {
		String url = "";
		Navigate(url);
		return this;
	}
	
	public boolean isButtonSelected() {
		boolean checker = false;
		String status = buttonTwo.getAttribute("class");
		System.out.println(status);
		if(status.equals(status)) {
			checker = true;
		}else {
			checker = false;
		}
		return checker;
	}



}
