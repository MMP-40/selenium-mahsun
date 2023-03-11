

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdminPage {
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"admin\"]/table[2]/tbody/tr[2]/td[1]/label")
	private WebElement btnResetUsers;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"admin\"]/table[2]/tbody/tr[3]/td[1]/label")
	private WebElement btnPopulate;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"admin\"]/table[2]/tbody/tr[1]/td[1]/label")
	private WebElement btnResetConnection;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"new_username\"]")
	private WebElement inputUsername;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"new_password\"]")
	private WebElement inputPassword;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"admin\"]/table[1]/tbody/tr[3]/td[2]/span")
	private WebElement btnCreateUser;

	public void resetUsers() {
		btnResetUsers.click();
	}
	
	public void createUser (String username, String password){
		inputUsername.sendKeys(username);
		inputPassword.sendKeys(password);
		btnCreateUser.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void populateFortTesting() {
		btnPopulate.click();
	}
	
	public void resetConnections() {
		btnResetConnection.click();
	}
}
