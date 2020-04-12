package com.qtx.pages;

import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class exitIntentPage extends SuperPageObject{
	
	@FindBy(css="div[class='modal-title']")
	private WebElement modalWindow;
	@FindBy(css="div[id='flash-messages'][class='large-12 columns']")
	private WebElement topBorder;

	public exitIntentPage(WebDriver driverInstance, String baseUrl) {

		super(driverInstance, baseUrl);

	}

	public exitIntentPage openExitIntentPage() {

		String url = "/exit_intent";
		Navigate(url);
		return this;

	}

	public exitIntentPage moveMouseOutOfPane() {

		Actions builder = new Actions(driver);
		try {
			Robot robot = new Robot();
			robot.mouseMove(driver.manage().window().getSize().width/2, driver.manage().window().getSize().height/2);

			while(modalWindow.isDisplayed()== false) {

				robot.mouseMove(0, -1);
				
			}

		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		return this;

	}

	public String getModelWindowText() {

		return modalWindow.getText();

	}

}
