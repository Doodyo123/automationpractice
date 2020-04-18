import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qtx.driver.DriverManagerFactory;
import com.qtx.driver.DriverType;

public abstract class TestSuperClass {

	protected WebDriver driver;
	
	protected String theInternetUrl;
	protected String automationPracticeUrl;
	protected String demoqaFormsUrl;

	@BeforeTest
	public void beforeTest() {
		driver = DriverManagerFactory.getManager(DriverType.CHROME).getDriver();
		theInternetUrl = "http://the-internet.herokuapp.com";
		automationPracticeUrl = "http://automationpractice.com/index.php";
		demoqaFormsUrl = "https://demoqa.com/automation-practice-form/";
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
