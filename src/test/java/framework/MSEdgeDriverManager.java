package framework;

import java.net.URL;

import org.openqa.selenium.edge.EdgeDriver;

public class MSEdgeDriverManager extends DriverManager {

	protected void createDriver() {

		URL url = ClassLoader.getSystemResource("msedgedriver.exe");
		System.setProperty("webdriver.edge.driver", url.getFile());
		
		driver = new EdgeDriver();

	}

}
