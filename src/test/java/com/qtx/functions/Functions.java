package com.qtx.functions;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

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
	
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();
		System.out.println(dir);
		System.out.println(dirContents);
		
		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {
				dirContents[i].delete();
				return true;
			}
		}
		return false;
	}
	
}
