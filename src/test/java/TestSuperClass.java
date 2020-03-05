import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qtx.driver.DriverManagerFactory;
import com.qtx.driver.DriverType;

public abstract class TestSuperClass {

	protected WebDriver driver;
	
	protected String baseUrl;

	@BeforeTest
	public void beforeTest() {
		driver = DriverManagerFactory.getManager(DriverType.CHROME).getDriver();
		baseUrl = "http://the-internet.herokuapp.com";
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
