package com.qtx.pages;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class dragAndDropPageObject extends SuperPageObject{

	@FindBy(css="div[id='column-a']")
	private WebElement boxA;
	@FindBy(css="div[id='column-b']")
	private WebElement boxB;

	private int sourceBX;
	private int sourceBY;

	public dragAndDropPageObject(WebDriver driverInstance, String baseUrl) {

		super(driverInstance, baseUrl);

	}

	public dragAndDropPageObject openDragAndDropPage() {

		String url = "/drag_and_drop";
		Navigate(url);
		return this;

	}

	public dragAndDropPageObject swapBoxAWithBoxB() {

		Actions builder = new Actions(driver);
		
		builder.dragAndDrop(boxA, boxB).build().perform();
		builder.dragAndDropBy(boxA, sourceBX, sourceBY).build().perform();
		builder.dragAndDropBy(boxA, sourceBX, 0).build().perform();
		builder.clickAndHold(boxA).moveByOffset(sourceBX, sourceBY).build().perform();
		builder.clickAndHold(boxA).moveByOffset(sourceBX, 0).build().perform();
		
		return this;
	}

	public String getFirstColumnAText() {

		return boxA.getText();

	}

	public Point getElementCoordinates(WebElement element) {

		return element.getLocation();

	}

	public dragAndDropPageObject getLocationOfBoxB() {

		sourceBX = boxB.getLocation().x;
		sourceBY = boxB.getLocation().y;
		return this;
	}


}
