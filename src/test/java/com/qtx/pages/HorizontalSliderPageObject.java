package com.qtx.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.qtx.functions.*;

public class HorizontalSliderPageObject extends SuperPageObject {
	
	@FindBy(css="input[type='range']")
	private WebElement horizontalSlider;
	@FindBy(css="div[class='sliderContainer']")
	private WebElement sliderContainer;
	
	Functions function = new Functions();

	public HorizontalSliderPageObject(WebDriver driverInstance, String url) {
		
		super(driverInstance, url);
		
	}

	public HorizontalSliderPageObject openHorizontalSliderPage() {

		String url = "/horizontal_slider";
		Navigate(url);
		
		return this;
		
	}

	public HorizontalSliderPageObject setHorizontalSliderToMax() {
		
		Dimension size = function.getDimensionOfElement(horizontalSlider);
		
		int width = function.getWidthOfElement(size);
		
		Actions builder = new Actions(driver);
		
		builder.clickAndHold(horizontalSlider).moveByOffset(width, 0).release().build().perform();
		
		return this;
		
	}

	public float getSliderValue() {
		
		return Float.valueOf(sliderContainer.getText().trim()).floatValue();
		
	}
	
	public float getSliderMaxValue	() {
		
		return Float.valueOf(horizontalSlider.getAttribute("max").trim()).floatValue();
		
	}
	

}
