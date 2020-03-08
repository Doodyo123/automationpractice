package com.qtx.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HorizontalSliderPageObject extends SuperPageObject {
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div/input")
	private WebElement horizontalSlider;

	public HorizontalSliderPageObject(WebDriver driverInstance, String url) {
		
		super(driverInstance, url);
		
	}

	public HorizontalSliderPageObject openHorizontalSliderPage() {

		String url = "/horizontal_slider";
		Navigate(url);
		return this;
		
	}

	public HorizontalSliderPageObject setHorizontalSliderToMax() {
		
		Actions builder = new Actions(driver);
		builder.clickAndHold(horizontalSlider).moveByOffset(90, 0).release().build().perform();
		return this;
		
	}

	public String getSliderValue() {
		
		return horizontalSlider.getAttribute("value");
		
	}
	
	

}
