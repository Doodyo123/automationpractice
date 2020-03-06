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
	
	public CheckBoxPageObject selectCheckBox(String value) {
		if(value == "checkbox 1") {
			checkBoxOne.click();
		}
		else if (value == "checkbox 2") {
			checkBoxTwo.click();
		} 
		return this;
	}
	
	public boolean isCheckBoxClicked(String textValue) {
		
		if(textValue == "checkbox 1") {
			return checkBoxOne.isSelected();
		}
		else if (textValue == "checkbox 2") {
			return checkBoxTwo.isSelected();
		} else {
			return false;
		}
		
	}
	
	
	
	

}
