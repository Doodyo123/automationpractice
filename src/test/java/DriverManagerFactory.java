
public class DriverManagerFactory {
	
	public static DriverManager getManager(DriverType type) {
	
		switch (type) {
		case CHROME:
			return new ChromeDriverManager();
		default: System.out.println("Invalid Type passed to DriverManagerFactory");
		}
		return null;
	}
}
