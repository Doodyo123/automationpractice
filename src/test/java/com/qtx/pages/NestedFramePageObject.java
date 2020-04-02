package com.qtx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramePageObject extends FramePageObject{	

	public NestedFramePageObject(WebDriver driverInstance, String baseUrl) {
		
		super(driverInstance, baseUrl);
	}
	
	public NestedFramePageObject getFrame(String name) {
		
		driver.switchTo().frame(name);
		
		return this;
		
	}
	
	public NestedFramePageObject getParentFrame(String name) {
		
		getFrame(name);
		
		return this;
		
	}
	
	public NestedFramePageObject getDefault() {
		
		driver.switchTo().defaultContent();
		
		return this;
		
	}

	public String getLeftFrameText() {
		
		getParentFrame("frame-top");
		getFrame("frame-left");
		
		return driver.findElement(By.tagName("body")).getText();
		
	}
	
	public String getMiddleFrameText() {
		
		getParentFrame("frame-top");
		getFrame("frame-middle");
		
		return driver.findElement(By.tagName("body")).getText();
		
	}
	
	public String getRightFrameText() {
		
		getParentFrame("frame-top");
		getFrame("frame-right");
		
		return driver.findElement(By.tagName("body")).getText();
		
	}
	
	public String getBottomFrameText() {
		
		getFrame("frame-bottom");
		
		return driver.findElement(By.tagName("body")).getText();
		
	}

}
