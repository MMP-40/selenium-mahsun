package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WelcomePage {
	
	//@FindBy(how = How.XPATH, using = "//*[@id=\"welcome\"]/p[1]/text()")
	//@FindBy(how = How.XPATH, using = "//*[@id=\"welcome\"]/h1")
	@FindBy(how = How.ID, using = "welcome")
	private WebElement welcomeMessage;
	
	public String getWelcomeMessage() {
		System.out.println("Getting the welcome message");
		return welcomeMessage.getText();
	}
	
	public boolean isWelcomeMessageShown() {
		System.out.println("Returning if Welcome Message is shown");
		return welcomeMessage.isDisplayed();
	}
//	
//	public String getWelcomeMessage()
//	{
//		return welcomeMessage.getText();
//	}
}
