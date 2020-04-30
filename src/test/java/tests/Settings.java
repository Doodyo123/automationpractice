package tests;

import java.util.concurrent.TimeUnit;

// reflects parameter name/values in settings.xml
public class Settings {
	public static final TimeUnit timeoutTimeUnit = TimeUnit.MILLISECONDS;
	public static final String browserType = "browser-type";
	public static final String implicitWaitMilliseconds = "implicit-wait-milliseconds";
	public static final String pageLoadTimeoutMilliseconds = "page-load-timeout-milliseconds";
	public static final String baseUrl = "base-url";
	public static final String databaseConnectionString = "database-connection-string";
}
