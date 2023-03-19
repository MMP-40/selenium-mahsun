package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.DriverManager;

public class LoginPageIPO {	
	
	@FindBy(how = How.ID, using = "username")
	private WebElement fldUsername;
	
	@FindBy(how = How.ID, using = "password")
	private WebElement fldPassword;
	
	@FindBy(how = How.CLASS_NAME, using = "content")
	private WebElement btnLogin;
	
	@FindBy(how = How.NAME, using = "language")
	private WebElement dropdownLanguage;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"errors\"]/p")
	private WebElement errorMessage;
	
	private WebDriver driver;
	
	public LoginPageIPO() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public boolean isShown() {
		if (driver.getTitle().equals("Connection Manager")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public WelcomePage logInWith (String userName, String passWord) {
	    System.out.println("Logging in with: " + userName + "/" + passWord);
	    System.out.println("Clearing username");
		fldUsername.clear();
	    System.out.println("Filling in username");
		fldUsername.sendKeys(userName);
	    System.out.println("Clearing password");
		fldPassword.clear();
	    System.out.println("Filling in password");
		fldPassword.sendKeys(passWord);
	    System.out.println("Clicking buttong");
		btnLogin.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new WelcomePage();
	}
	
	public WelcomePage loginWithAdmin () {
		logInWith("admin", "superduper");
		return new WelcomePage();
	}
	
	public LoginPageIPO setLanguageTo(String language) {
		System.out.println("Setting the language to: " + language);
		Select selectLanguage = new Select(dropdownLanguage);
		selectLanguage.selectByVisibleText(language);
		return this;
	}
	
	public boolean isErrorShown() {
		return errorMessage.isDisplayed();
	}
	
	public String getErrorMessage() {
		return errorMessage.getText();
	}
}
