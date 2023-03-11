

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {	
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
	
	public void login (String username, String password){
		fldUsername.clear();
		fldUsername.sendKeys(username);
		fldPassword.sendKeys(password);
		btnLogin.click();
	}
	
	public void setLanguage(String language){
		Select selectLanguage = new Select(dropdownLanguage);
		selectLanguage.selectByVisibleText(language);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getErrorMessage() {
		return errorMessage.getText();		
	}
}
