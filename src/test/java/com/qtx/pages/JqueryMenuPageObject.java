package com.qtx.pages;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qtx.functions.Functions;

public class JqueryMenuPageObject extends SuperPageObject{

	@FindBy(id="menu")
	private WebElement dropDownMenu;
	private WebElement enabledMenuButton;
	private WebElement downloadsMenuButton;
	private WebElement excelMenuButton;

	Functions function = new Functions();
	private FileReader file;

	public WebElement getWebElement(WebElement element, String tagName, int index) {

		return function.getGroupOfElementsByTagName(element, tagName).get(index);

	}

	public JqueryMenuPageObject(WebDriver driverInstance, String baseUrl) {

		super(driverInstance, baseUrl);

	}

	public JqueryMenuPageObject clickItemByMenuPath(String[] strings) {

		enabledMenuButton = getMenuButton(strings, 0);
		enabledMenuButton.click();

		downloadsMenuButton = getMenuButton(strings, 1);
		downloadsMenuButton.click();

		excelMenuButton = getMenuButton(strings, 2);
		excelMenuButton.click();

		return this;

	}

	public WebElement getMenuButton(String [] strings, int index) {


		return dropDownMenu.findElement(By.linkText(strings[index]));

	}

	public JqueryMenuPageObject openMenuPage() {
		String url = "/jqueryui/menu#";
		Navigate(url);
		return this;
	}

	public boolean getDownloadedFile(String fileName) {
		
		try {
			
			file = new FileReader(fileName);
			
			if(file!=null) {
				
				System.out.println("File found!");
				return true;
				
			}
			
		}
		catch (FileNotFoundException e){
			
			System.out.println("file not found!");
			
			try {
				
				Thread.sleep(2000);
				return getDownloadedFile(fileName);	
				
			} catch (InterruptedException e1) {

				e1.printStackTrace();
				
			}
		}

		return false;
		
	}
}
