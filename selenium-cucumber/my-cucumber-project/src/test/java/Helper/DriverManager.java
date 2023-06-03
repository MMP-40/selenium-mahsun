package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

	private static WebDriver driver;
	
	//public DriverManager() {
	//	getDriver();
	//}
	
	public WebDriver getDriver() {
		if(driver == null) {
			setChromeDriver();
		}
		return driver;
	}
	
	public static void setChromeDriver() {
		killDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mpinar\\Desktop\\chromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}
	
	public static void setFirefoxDriver() {
		killDriver();
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\mpinar\\Desktop\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
