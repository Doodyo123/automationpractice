package com.qtx.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class contextMenuPage extends SuperPageObject{
	
	@FindBy(id="hot-spot")
	private WebElement box;
	private Alert alert;

	public contextMenuPage(WebDriver driverInstance, String baseUrl) {
		
		super(driverInstance, baseUrl);
		
	}

	public contextMenuPage openContextMenuPage() {
		String url = "/context_menu";
		Navigate(url);
		return this;
	}

	public contextMenuPage rightClickBox() {
		Actions builder = new Actions(driver);
		
		builder.contextClick(box).build().perform();
		return this;
	}

	public contextMenuPage switchToJSAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			alert = driver.switchTo().alert();
		} catch (Exception e) {
			System.out.println(e);
		}
		return this;
	}

	public String getAlertText() {
				
		return alert.getText();
	
	}

}
