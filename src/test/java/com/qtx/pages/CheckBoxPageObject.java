package com.qtx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxPageObject extends SuperPageObject{
	
	@FindBy(xpath="//*[@id=\"checkboxes\"]/input[1]")
	private WebElement checkBoxOne;
	
	@FindBy(xpath="//*[@id=\"checkboxes\"]/input[2]")
	private WebElement checkBoxTwo;
	
	public CheckBoxPageObject(WebDriver driverInstance, String url) {
		
		super(driverInstance, url);
		
	}

	public CheckBoxPageObject openCheckBoxPage() {
		String url = "/checkboxes";
		Navigate(url);
		return this;
	}
	
	public CheckBoxPageObject selectCheckBoxOne(String value) {
		checkBoxOne.click();
		return this;
	}
	
	public CheckBoxPageObject unselectCheckBoxTwo(String value) {
		checkBoxTwo.click();
		return this;
	}
	
	public boolean isCheckBoxClicked() {
		return checkBoxOne.isSelected();
	}
	
	

}
