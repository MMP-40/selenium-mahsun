package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WelcomePage {
	
	//@FindBy(how = How.XPATH, using = "//*[@id=\"welcome\"]/p[1]/text()")
	@FindBy(how = How.XPATH, using = "//*[@id=\"welcome\"]/h1")
	private WebElement welcomeMessage;
	
	//String wlcmText = welcomeMessage.inn
	
	public String getWelcomeMessage()
	{
		return welcomeMessage.getText();
	}
}
