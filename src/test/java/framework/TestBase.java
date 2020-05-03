package framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import tests.Settings;

public abstract class TestBase {
	protected WebDriver driver;
	protected String baseUrl;
	protected DriverManager driverManager;
	private ConfigurationManager configurationManager;

	protected TestBase() {
		this.configurationManager = ConfigurationManager
				.getInstance()
				.getConfiguration();
	}
	
	protected TestBase(String baseUrl) {
		this();
		this.configurationManager.SetIfValueNotNull(Settings.baseUrl, baseUrl);
	}

	@Parameters({
		Settings.baseUrl,
		Settings.browserType, 
		Settings.databaseConnectionString, 
		Settings.implicitWaitMilliseconds, 
		Settings.pageLoadTimeoutMilliseconds
	})
	
	@BeforeTest
	public void readSettings(
			@Optional String baseUrl,
			@Optional String browserType, 
			@Optional String databaseConnectionString, 
			@Optional String implicitWaitMilliseconds, 
			@Optional String pageLoadTimeoutMilliseconds) {
		
		configurationManager.SetIfValueNotNull(Settings.baseUrl, baseUrl)
							.SetIfValueNotNull(Settings.browserType, browserType)
							.SetIfValueNotNull(Settings.databaseConnectionString, databaseConnectionString)
							.SetIfValueNotNull(Settings.implicitWaitMilliseconds, implicitWaitMilliseconds)
							.SetIfValueNotNull(Settings.pageLoadTimeoutMilliseconds, pageLoadTimeoutMilliseconds);	
	}

	@BeforeMethod
	public void setup() {
		this.driverManager = DriverManagerFactory.getManager(configurationManager.getValueAsString(Settings.browserType));
		this.driver = driverManager.getDriver();	
		
		this.driver.manage().timeouts().implicitlyWait(configurationManager.getValueAsLong(Settings.implicitWaitMilliseconds), Settings.timeoutTimeUnit);
		this.driver.manage().timeouts().pageLoadTimeout(configurationManager.getValueAsLong(Settings.pageLoadTimeoutMilliseconds), Settings.timeoutTimeUnit);
		this.baseUrl = configurationManager.getValueAsString(Settings.baseUrl);
	}

	@AfterMethod
	public void tearDown() {
		driverManager.quitDriver();
	}
}
