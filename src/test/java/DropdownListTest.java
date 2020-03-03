import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropdownListTest {

	private WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = getWebDriver();
	}

	private WebDriver getWebDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		String url = "http://the-internet.herokuapp.com/dropdown";
		driver.get(url);
		return driver;
	}

	// As a user
	// I want to select option 2 from a dropdown list
	// So that some option is selected
	@Test
	public void canSelectFromDrowdown() {
		
		WebElement dropDown = driver.findElement(By.id("dropdown"));
		WebElement secondOption = driver.findElement(By.linkText("Option 2"));
		
		dropDown.click();
		secondOption.click();
		
		String actualElement = "Option 2";
		Assert.assertEquals(secondOption.getText(), actualElement, "Failed to click Option 2!");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
