import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import helper.DriverManager;
import pageObject.AdminPage;
import pageObject.LoginPage;
import pageObject.MenuPage;
import pageObject.StatsPage;
import pageObject.WelcomePage;

public class Testng_Exercise12 {

	private static MenuPage menu = new MenuPage();
	private static LoginPage login = new LoginPage();
	private static AdminPage adminPage = new AdminPage();
	private static StatsPage stats = new StatsPage();
	private static WelcomePage welcome = new WelcomePage();
	
	 @BeforeSuite
	 public static void setupTest() {
		 PageFactory.initElements(DriverManager.getDriver(), menu);
		 PageFactory.initElements(DriverManager.getDriver(), login);
		 PageFactory.initElements(DriverManager.getDriver(), adminPage);
		 PageFactory.initElements(DriverManager.getDriver(), stats);
		 PageFactory.initElements(DriverManager.getDriver(), welcome);
		 DriverManager.getDriver().get("https://satrngselcypr.z16.web.core.windows.net/#");
	 }
	
//	@Parameters({
//		"admin","superduper"
//		})
//	@Test
//	public void LoginWithCorrectUsernameCorrectPasswordTest(String username, String password) {
//		login.login(username, password);
//		Assert.assertTrue("Welcome message is not displayed", welcome.getWelcomeMessage().contains("Welcome"));
//		//Assert.assertFalse("Welcome message is not displayed", welcome.getWelcomeMessage().contains("Welcome"));
//	}
	
	@Test
	public void LoginWithCorrectUsernameCorrectPasswordTest() {
		login.login("admin", "superduper");
		//Assert.assertTrue("Welcome message is not displayed", welcome.getWelcomeMessage().contains("Welcome"));
		//Assert.assertFalse("Welcome message is not displayed", welcome.getWelcomeMessage().contains("Welcome"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(welcome.getWelcomeMessage().contains("Welcome"), "Welcome message is not displayed");
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
