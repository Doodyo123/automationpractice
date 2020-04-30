package framework;

public class DriverManagerFactory {
	
	public static DriverManager getManager(String  browserType) {
	
		if(browserType.equals(BrowserTypes.Chrome)) {
			return new ChromeDriverManager();
		}
			
		throw new RuntimeException(browserType + " is not a supported browser.");
	}
}
