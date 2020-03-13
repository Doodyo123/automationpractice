package com.qtx.functions;

import java.util.List;

import org.openqa.selenium.By;
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
	
	//Returns an element from a group of elements
	public List<WebElement> getGroupOfElementsByTagName(WebElement element, String tagName){
		
		return element.findElements(By.tagName(tagName));
		
	}

}
