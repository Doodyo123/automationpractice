package com.qtx.pages;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DownloadPageObject extends SuperPageObject{
	
	@FindBy(css="a[href='download/text.txt']")
	private WebElement textButton;

	public DownloadPageObject(WebDriver driverInstance, String baseUrl) {
		
		super(driverInstance, baseUrl);
		
	}

	public DownloadPageObject openDownloadPage() {

		String url = "/download";
		Navigate(url);
		return this;
		
	}

	public DownloadPageObject selectTextFile() {
		
		textButton.click();
		return this;
		
	}
	
	public String getTextFileText() {
		String content = null;
		
		try {
			content = new String(Files.readAllBytes(Paths.get("C:\\Users\\Deric\\Downloads\\text.txt")));
		} catch (IOException e) {
			try {
				Thread.sleep(2000);
				return getTextFileText();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		
		return content;
	}

}
