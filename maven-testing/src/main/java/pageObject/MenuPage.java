package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MenuPage {
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-nav\"]/ul/li[6]/a")
	private WebElement btnAdmin;
	
	@FindBy(how = How.XPATH, using = "notexisting")
	private WebElement btnNotExist;
	
	@FindBy(how = How.ID, using = "logout")
	private WebElement btnLogout;
	
	@FindBy(how = How.ID, using = "crudConnection")
	private WebElement btnNew;
	
	public void clickLogout(){
		System.out.println("Op de logout button klikken");
		btnLogout.click();
	}
	
	public void clickAdmin(){
		btnAdmin.click();
	}
	
	public void clickNew(){
			System.out.println("Op de new button klikken");
			btnNew.click();
	}
	
	public void clickNotExist(){
		btnNotExist.click();
}
}
