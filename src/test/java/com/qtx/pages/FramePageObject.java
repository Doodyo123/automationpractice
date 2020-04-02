package com.qtx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePageObject extends SuperPageObject{
	
	@FindBy(css="a[href='/nested_frames']")
	private WebElement nestedFrameButton;

	public FramePageObject(WebDriver driverInstance, String baseUrl) {
		
		super(driverInstance, baseUrl);
		
	}

	public FramePageObject openFramePage() {
		
		String url = "/frames";
		Navigate(url);
		return this;
		
	}

	public String[] getFrameText() {
		
		String listOfText[] = new String[4];
		nestedFrameButton.click();
		NestedFramePageObject nestedFramePage = new NestedFramePageObject(driver,super.bassUrl);

		listOfText[0] = nestedFramePage.getLeftFrameText();
		nestedFramePage.getDefault();
		listOfText[1] = nestedFramePage.getMiddleFrameText();
		nestedFramePage.getDefault();
		listOfText[2] = nestedFramePage.getRightFrameText();
		nestedFramePage.getDefault();
		listOfText[3] = nestedFramePage.getBottomFrameText();
		System.out.println(listOfText[1]);
		
		return listOfText;
		
	}

}
