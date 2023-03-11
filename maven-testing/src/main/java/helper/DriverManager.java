package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class DriverManager {
	
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		if (driver == null) {
			setChromeDriver();
			//setFireFoxDriver();
			//setEdgeDriver();
		}
		return driver;
	}
	
	public static void setChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mpinar\\Desktop\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void setFireFoxDriver() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\mpinar\\Desktop\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	public static void setEdgeDriver() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\mpinar\\Desktop\\edgedriver\\msedgedriver.exe");
		driver = new EdgeDriver();
	}
	
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
		//driver.quit();
	}
	
	
}
