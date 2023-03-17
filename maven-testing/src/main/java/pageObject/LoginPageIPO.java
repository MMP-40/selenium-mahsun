package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	public LoginPageIPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isShown() {
		return driver.getTitle().equals("Connection Manager");
	}
	
	public LoginPageIPO switchToFrench() {
		Select selectLanguage = new Select(dropdownLanguage);
		selectLanguage.selectByVisibleText("French");
		return this;
	}
	
	public void login (String username, String password){
		fldUsername.clear();
		fldUsername.sendKeys(username);
		fldPassword.sendKeys(password);
		btnLogin.click();
	}
	
//	public LoggedIn logIn(String username, String password) {
//		fldUsername.clear();
//		fldUsername.sendKeys(username);
//		fldPassword.sendKeys(password);
//		btnLogin.click()
//		return new LoggedIn(driver);
//	}
	
	public String getErrorMessage() {
		return errorMessage.getText();		
	}
}

class LoggedIn {
//	@FindBy(how = How.ID, using = "username")
//	private WebElement fldUsername;
//	
//	@FindBy(how = How.ID, using = "password")
//	private WebElement fldPassword;
//	
//	@FindBy(how = How.CLASS_NAME, using = "content")
//	private WebElement btnLogin;
//	
//	private WebDriver driver;
//	
//	public LoggedIn(WebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//	}
//	
//	public LoggedIn loggingIn() {
//		fldUsername.clear();
//		fldUsername.sendKeys();
//		fldPassword.sendKeys();
//		btnLogin.click();
//		return this;
//	}
//	
//	public void login (String username, String password){
//		fldUsername.clear();
//		fldUsername.sendKeys(username);
//		fldPassword.sendKeys(password);
//		btnLogin.click();
//	}
	
}
