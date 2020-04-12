package com.qtx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class typoPageObject extends SuperPageObject{
	
	private WebElement text;

	public typoPageObject(WebDriver driverInstance, String baseUrl) {
		
		super(driverInstance, baseUrl);

	}

	public typoPageObject openTypePage() {

		String url = "/typos";
		Navigate(url);
		return this;
		
	}

	public typoPageObject getText() {

		text = driver.findElement(By.id("content")).findElements(By.tagName("div")).get(0).findElements(By.tagName("p")).get(1);
		System.out.println(text.getText());
		
		return this;
	}

	public String findTypo() {

		while(text.getText().contains("won,t")==false) {
			this.openTypePage();
			this.getText();
		}
		return text.getText();
	}

}
