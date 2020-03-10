package com.qtx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qtx.functions.Functions;

public class CheckBoxPageObject extends SuperPageObject{
	
	Functions function = new Functions();

	public CheckBoxPageObject(WebDriver driverInstance, String url) {

		super(driverInstance, url);

	}

	@FindBy(css="form[id='checkboxes']")
	private WebElement mappedElement;


	private WebElement checkBoxOne;

	private WebElement checkBoxTwo;



	public CheckBoxPageObject openCheckBoxPage() {

		String url = "/checkboxes";
		Navigate(url);
		return this;

	}
	
	public WebElement getWebElement(WebElement element, String tagName, int index) {
		
		return function.getGroupOfElementsByTagName(element, tagName).get(index);
		
	}

	public CheckBoxPageObject selectCheckBoxOne() {
		
		checkBoxOne = getWebElement(mappedElement, "input", 0);
		checkBoxOne.click();
		return this;

	}

	public CheckBoxPageObject selectCheckBoxTwo() {

		checkBoxTwo = getWebElement(mappedElement, "input", 1);
		checkBoxTwo.click();
		return this;

	}

	public boolean isCheckBoxOneSelected() {

		return checkBoxOne.isSelected();

	}

	public boolean isCheckBoxTwoSelected() {

		return checkBoxTwo.isSelected();

	}

}
