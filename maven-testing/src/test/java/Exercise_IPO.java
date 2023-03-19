import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import helper.DriverManager;
import pageObject.AdminPage;
import pageObject.LoginPageIPO;
import pageObject.MenuPage;
import pageObject.StatsPage;
import pageObject.WelcomePage;

public class Exercise_IPO {

	private static MenuPage menu = new MenuPage();
	private static LoginPageIPO loginPage = new LoginPageIPO();
	private static AdminPage adminPage = new AdminPage();
	private static StatsPage stats = new StatsPage();
	private static WelcomePage welcome = new WelcomePage();

	@BeforeSuite
	public static void setupTest() {
		PageFactory.initElements(DriverManager.getDriver(), menu);
		PageFactory.initElements(DriverManager.getDriver(), welcome);
		DriverManager.getDriver().get("https://satrngselcypr.z16.web.core.windows.net/#");
	}
	
	@Test
	public void logInWithCorrectUsernameAndPassword( ) {
		loginPage.setLanguageTo("French").logInWith("admin", "superduper"); //.getWelcomeMessage();
		//Assert.assertTrue(welcome.isWelcomeMessageShown(), "Welcome message is not displayed");
	}

	@AfterSuite
	public static void closeDriverTest() {
		DriverManager.getDriver().close();
	}

	@BeforeMethod
	public void logOutTest() {
		menu.clickLogout();
	}

}
