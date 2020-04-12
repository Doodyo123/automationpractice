package com.qtx.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class floatingMenuPage extends SuperPageObject{
	
	private List <String> urlList;

	public floatingMenuPage(WebDriver driverInstance, String baseUrl) {

		super(driverInstance, baseUrl);

	}

	public floatingMenuPage openFloatingMenuPage() {

		String url = "/floating_menu";
		Navigate(url);
		return this;

	}

	public floatingMenuPage getUrl() {

		String CurrentUrl = driver.getCurrentUrl();

		String trimmedUrl = CurrentUrl.replace("http://the-internet.herokuapp.com/floating_menu", "");
		
		if(urlList == null) {
			urlList = new ArrayList<String>();
			urlList.add(trimmedUrl);
		} else {
			urlList.add(trimmedUrl);
		}
		
		return this;

	}

	public List<String> getUrlList() {
			
		return urlList;
		
	}

	public floatingMenuPage clickButton(String name) {
		String cssSelector = "a[href='" + name + "']";
		driver.findElement(By.cssSelector(cssSelector)).click();
		return this;
		
	}







}
