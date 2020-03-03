import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {

	private WebDriver driver;

	@Test
	public void f() {
		System.out.println("Hello World!");
	}
	
	@Test
	public void launchChromeDriver() {

		Assert.assertEquals(driver.getTitle(), "Google", "An incorrect page was loaded.");
		
	}
	
	@Test
	public void canClickLuckyButton() {
		
		WebElement luckyButton  =  driver.findElement(By.id("gbqfbb"));
		luckyButton.click();
				
	}
	
	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		String url = "http://google.com";

		driver.get(url);

	}

	@AfterTest
	public void afterTest() {
		
		driver.quit();
		
	}

}
