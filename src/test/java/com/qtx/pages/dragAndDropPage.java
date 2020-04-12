package com.qtx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class dragAndDropPage extends SuperPageObject{

	@FindBy(css="div[id='column-a']")
	private WebElement boxA;
	@FindBy(css="div[id='column-b']")
	private WebElement boxB;

	public dragAndDropPage(WebDriver driverInstance, String baseUrl) {

		super(driverInstance, baseUrl);

	}

	public dragAndDropPage openDragAndDropPage() {

		String url = "/drag_and_drop";
		Navigate(url);
		return this;

	}

	public dragAndDropPage swapBoxAWithBoxB() {

		do {

			int xOffset = getXOffSet();
			int yOffset = getYOffSet();
			Actions builder = new Actions(driver);
			System.out.println(xOffset);
			System.out.println(yOffset);
			builder.dragAndDropBy(boxA, xOffset, yOffset).build().perform();
		}while(boxA.getText()!="B");

		return this;
	}

	private int getYOffSet() {

		int sourceBY = getElementCoordinates(boxB).y;
		int sourceAY = getElementCoordinates(boxA).y;

		return sourceBY - sourceAY;
	}

	private int getXOffSet() {

		int sourceBX = getElementCoordinates(boxB).x;
		int sourceAX = getElementCoordinates(boxA).x;

		return sourceBX - sourceAX;
	}

	public String getFirstColumnAText() {

		return boxA.getText();

	}

	public Point getElementCoordinates(WebElement element) {

		return element.getLocation();

	}


}
