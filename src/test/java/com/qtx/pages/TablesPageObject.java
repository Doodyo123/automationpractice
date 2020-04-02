package com.qtx.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TablesPageObject extends SuperPageObject{
	
	@FindBy(id="table1")
	private WebElement exampleOneTable;
	private WebElement tableBody;
	
	private List<WebElement> rows;
	private List<WebElement> column;
	
	private String records;
	
	public TablesPageObject(WebDriver driverInstance, String baseUrl) {
		
		super(driverInstance, baseUrl);
		
	}

	public TablesPageObject openTablesPage() {
		
		String url = "/tables";
		Navigate(url);
		
		return this;
		
	}
	
	public String getAmountDue() {
		
		tableBody = exampleOneTable.findElement(By.tagName("tbody"));
		rows = tableBody.findElements(By.tagName("tr"));
		
		for(int rnum= 0; rnum<rows.size(); rnum++) {
			
			column = rows.get(rnum).findElements(By.tagName("td"));
			
			for(int cnum=0; cnum<column.size(); cnum++) {
				
				if(column.get(0).getText().equals("Doe")) {
					
					records = column.get(3).getText();
					break;
					
				}
			}
		}
		
		return records;
				
	}
}
