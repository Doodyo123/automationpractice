package framework;

import java.net.URL;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager{

	protected void createDriver() {
		
		URL url = ClassLoader.getSystemResource("geckodriver.exe");
		
		System.setProperty("webdriver.gecko.driver", url.getFile());
		
		driver = new FirefoxDriver();
	}
}
