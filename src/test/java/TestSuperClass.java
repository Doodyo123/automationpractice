import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class TestSuperClass {

	protected WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = DriverManagerFactory.getManager(DriverType.CHROME).getDriver();

		String url = "http://the-internet.herokuapp.com";
		driver.get(url);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
