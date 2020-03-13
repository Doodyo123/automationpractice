//create one for each web page

package com.qtx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropDownPageObject extends SuperPageObject{
	
	@FindBy(id="dropdown")
	private WebElement dropDown;
	
	
	
	
	public DropDownPageObject(WebDriver driverInstance, String url) {
		
		super(driverInstance, url);
		
	}
	
	public DropDownPageObject openDropdownPage() {
		String url = "/dropdown";
		Navigate(url);
		return this;
	}
	
	public DropDownPageObject setDropDownList(String value) {

		getDropDown().selectByVisibleText(value);
		return this;
		
	}
	
	public String getDropDownListTextValue() {
		
		return getDropDown().getFirstSelectedOption().getText();
		
	}
	
	//maps one UI control, the drop down and the second option.
	public Select getDropDown() {
		Select customerDropDownList = new Select(dropDown);
		return customerDropDownList;
	}

	
	
	
}
