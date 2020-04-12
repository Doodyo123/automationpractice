package com.qtx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class notificationMessagePage extends SuperPageObject{

	private WebElement notificationMessage;
	private WebElement clickHereButton;
	private boolean isMessageSuccess;
	private String notification;


	public notificationMessagePage(WebDriver driverInstance, String baseUrl) {

		super(driverInstance, baseUrl);

	}

	public notificationMessagePage openNotificationMessagePage() {

		String url = "/notification_message_rendered";
		Navigate(url);
		return this;

	}

	public notificationMessagePage clickClickHereButton() {

		clickHereButton.click();
		return this;

	}

	public String getNotificationMessage() {

		return notification;

	}

	public boolean checkMessage() {
		
		notificationMessage = driver.
				findElement
				(By.cssSelector("div[class='large-12 columns']")).
				findElement(By.tagName("div"));

		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(notificationMessage));
		
		
		notification = notificationMessage.getText();

		if(notification.contains("Action successful")) {

			notification = notification.substring(0, notification.length()-1);

			notification = notification.trim();

			isMessageSuccess = true;

		} else {
			
			isMessageSuccess = false;

		}
		return isMessageSuccess;

	}

	public notificationMessagePage getClickHereButton() {

		clickHereButton = driver.findElement
				(By.cssSelector("div[class='example']")).
				findElement(By.tagName("p")).
				findElement(By.tagName("a"));
		return this;

	}


}
