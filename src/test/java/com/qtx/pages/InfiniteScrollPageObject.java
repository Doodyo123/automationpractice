package com.qtx.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InfiniteScrollPageObject extends SuperPageObject{

	@FindBy(css="div[class='scroll large-8 columns large-centered']")
	private WebElement groupedText;

	private WebElement firstText;
	private String dynamicText;

	public InfiniteScrollPageObject(WebDriver driverInstance, String baseUrl) {

		super(driverInstance, baseUrl);

	}

	public InfiniteScrollPageObject openInfiniteScrollPage() {

		String url = "/infinite_scroll";
		Navigate(url);
		return this;

	}

	public InfiniteScrollPageObject scrollDown() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		return this;

	}

	public InfiniteScrollPageObject getFirstDynamicParagraph() {
		
		firstText = getWebElement(groupedText, "div", 0);
		dynamicText = firstText.getText();
		return this;

	}
	

	//Returns an element from a group of elements
	public List<WebElement> getGroupOfElementsByTagName(WebElement element, String tagName){

		return element.findElements(By.tagName(tagName));

	}

	public WebElement getWebElement(WebElement element, String tagName, int index) {

		return getGroupOfElementsByTagName(element, tagName).get(index);

	}

	public boolean printDynamicText() {
		
		boolean print;

		if(dynamicText!=null) {
			System.out.println(dynamicText);
			print = true;
		} else {
			print = false;
		}
		return print;
		
	}


}
