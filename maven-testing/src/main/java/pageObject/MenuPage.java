package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * this is about the menu options on top of the page
 * @author mpinar
 *
 */
public class MenuPage {
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-nav\"]/ul/li[6]/a")
	private WebElement btnAdmin;
	
	@FindBy(how = How.XPATH, using = "notexisting")
	private WebElement btnNotExist;
	
	@FindBy(how = How.ID, using = "logout")
	private WebElement btnLogout;
	
	@FindBy(how = How.ID, using = "crudConnection")
	private WebElement btnNew;
	
	@FindBy(how = How.LINK_TEXT, using = "Stats")
	private WebElement btnStats;
	
	/**
	 * clicks on the logout button
	 */
	public void clickLogout(){
		System.out.println("Op de logout button klikken");
		btnLogout.click();
	}
	
	/**
	 * clicks on the admin button
	 */
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
	/**
	 * Clicks on the stats button
	 */
	public void stats() {
		System.out.println("click on Stats button");
		btnStats.click();
	}
}
