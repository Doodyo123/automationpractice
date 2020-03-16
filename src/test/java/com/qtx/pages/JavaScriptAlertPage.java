package com.qtx.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class JavaScriptAlertPage extends SuperPageObject{
	
	@FindBy(css="button[onclick='jsAlert()']")	
	private WebElement jSAlertButton;
	@FindBy(css="button[onclick='jsConfirm()']")
	private WebElement jSConfirmButton;
	@FindBy(css="button[onclick='jsPrompt()']")
	private WebElement jSPromptButton;
	@FindBy(id="result")
	private WebElement resultText;
	
	public JavaScriptAlertPage(WebDriver driverInstance, String baseUrl) {
	
		super(driverInstance, baseUrl);
	
	}
	
	
	public JavaScriptAlertPage clickJSAlertButton() {
		
		jSAlertButton.click();
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert=driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
			
		} catch (Exception e) {
			
		}
		return this;
		
	}
	
	public JavaScriptAlertPage clickJSConfirmButton() {
		
		jSConfirmButton.click();
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert=driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
			
		} catch (Exception e) {
			
		}
		return this;
	}
	
	public JavaScriptAlertPage clickJSPromptButton(String text) {
		jSPromptButton.click();
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert=driver.switchTo().alert();
			alert.sendKeys(text);
			alert.accept();
			System.out.println(alert.getText());
			
		} catch (Exception e) {
			
		}
		return this;
	}
	

	public JavaScriptAlertPage openJavaScriptAlertsPage() {
		String url = "/javascript_alerts";
		Navigate(url);
		return this;
	}
	
	public String getResultText() {
		return resultText.getText();
	}

}
