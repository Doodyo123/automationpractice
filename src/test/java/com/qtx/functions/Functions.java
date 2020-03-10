package com.qtx.functions;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class Functions {
	
	public Dimension getDimensionOfElement(WebElement element) {
		
		return element.getSize();
		
	}
	
	public int getHeightOfElement(Dimension size) {
		
		return size.height;
		
	}
	
	public int getWidthOfElement(Dimension size) {
		
		return size.width;
		
	}
	

}
