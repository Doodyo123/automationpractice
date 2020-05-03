package framework;

public class DriverManagerFactory {
	
	public static DriverManager getManager(String  browserType) {
	
		if(browserType.equals(BrowserTypes.Chrome)) {
			return new ChromeDriverManager();
		}
		if(browserType.equals(BrowserTypes.Firefox)) {
			System.out.println("firefox driver initiating");
			return new FirefoxDriverManager();
		}
		if(browserType.equals(BrowserTypes.Edge)) {
			return new MSEdgeDriverManager();
		}
			
		throw new RuntimeException(browserType + " is not a supported browser.");
	}
}
