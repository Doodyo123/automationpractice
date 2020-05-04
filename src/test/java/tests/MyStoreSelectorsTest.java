package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MyStoreSelectorsTest extends MyStoreTestBase{

	// Write an xpath for the shop now button in the slider
	// The slider can be identified by the image 'sample-1'
	// return only 1 element in your result. The xpath must be valid!
	@Test
	public void CanGetShopNowButtonUsingXPath() {

		WebElement shopNowButton;

		driver.get(baseUrl);

		//finds unique element//navigates to parent element// locates button element
		shopNowButton = driver.findElement(By
				.xpath("//a[@href='http://www.prestashop.com/?utm_source=v16_homeslider'][@title='sample-1']"
						+ "/parent::li"
						+ "//div"
						+ "//button"));

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(shopNowButton));

		shopNowButton.click();

	}

	// Write an xpath to get the eye icon for Product 4. 
	// Return only 1 element in your result
	// The xpath must be valid
	@Test 
	public void CanGetProduct4UsingXPath() {

		WebElement eyeIconButton;

		Dimension targetSize = new Dimension(600, 600);

		driver.get(baseUrl + "?id_category=8&controller=category");
		driver.manage().window().setSize(targetSize);

		//finds unique element// navigates to parent element// locates eye icon
		eyeIconButton = driver.findElement(By
				.xpath("//a[@class='product_img_link'][@href='http://automationpractice.com/index.php?id_product=4&controller=product']"
						+ "/parent::div[@class='product-image-container']"
						+ "//div[@class='quick-view-wrapper-mobile']"
						+ "//a[@class='quick-view-mobile']"));
		if(eyeIconButton.isDisplayed()==false) {
			driver.manage().window().setSize(targetSize);
		}
		eyeIconButton.click();

	}

	//Write a CSS selector that returns all <ul> elements 
	//with the class "layered_filter_ul"
	@Test
	public void CanGetULElementsByCSS() {
		List<WebElement>  listOfUlElements;
		driver.get(baseUrl + "?id_category=8&controller=category");
		listOfUlElements = driver.findElements(By.cssSelector("ul[class='layered_filter_ul']"));

		System.out.println(listOfUlElements.size());
	}

	//Write a xpath statement that returns the parent DIV
	//With id = 'block_top_menu'
	@Test
	public void CanGetParentDivWithXpath() {

		WebElement parentDiv;
		driver.get(baseUrl + "?id_category=8&controller=category");

		parentDiv = driver.findElement(By.xpath("/parent::div[@id='black_top_menu']"));

		System.out.println(parentDiv.isDisplayed());
	}

	//Write an xpath that returns the element 
	//with class = 'subcategory-name' and text='tops'
	@Test
	public void CanGetElementWithXpath() {
		WebElement element;
		driver.get(baseUrl + "?id_category=3&controller=category");

		element = driver.findElement(By.xpath("//*[@class='subcategory-name'][@text='tops']"));
		element.click();
	}

	//Write an xpath that returns the element <h5>
	//which has a child element with class = 'subcategory-name'
	@Test
	public void CanGetH5ElementWithXpath() {
		WebElement h5Element;
		driver.get(baseUrl + "?id_category=3&controller=category");

		h5Element = driver.findElement(By.xpath("//*[@class='subcategory-name']"
				+ "/parent::h5"));

	}

	//Write a css selector that returns all <div> elements
	// that do not have class of 'clearfix'
	@Test
	public void CanGetAllDivWithException() {
		List<WebElement> listOfDivs;
		driver.get(baseUrl + "?id_category=3&controller=category");

		listOfDivs = driver.findElements(By.cssSelector("div[class='clearfix' i]"));
		System.out.println(listOfDivs.size());
	}

	//Write an css that returns all div elements
	//with class of 'accordion'
	@Test
	public void CanGetDivElementWithCSS() {
		List<WebElement> divElement;
		driver.get(baseUrl + "?id_category=3&controller=category");

		divElement = driver.findElements(By.cssSelector("div[class='accordion']"));
		System.out.println(divElement.size());

	}
	
	//Write an xpath that returns a span
	//with text equals to ">"
	@Test
	public void canGetSpanElementWithXpath() {
		WebElement spanElement;
		driver.get(baseUrl + "?id_category=3&controller=category");
		
		spanElement = driver.findElement(By.xpath("//span[.='>']"));
		System.out.println(spanElement.getText());
	}
	
	//Write an xpath that returns all div elements
	//with null/empty text
	@Test
	public void canGetDivElementWithXpath() {
		List<WebElement> divElements;
		driver.get(baseUrl + "?id_category=3&controller=category");
		
		divElements = driver.findElements(By.xpath("//div[.='' or .= null]"));
		System.out.println(divElements.size());
	}
}
