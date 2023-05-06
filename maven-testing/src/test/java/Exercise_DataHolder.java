import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import dataholders.Connection;
import helper.DriverManager;


public class Exercise_DataHolder extends AbstractTest {
	@BeforeSuite
	public static void setupTest(){
		driver.get("https://satrngselcypr.z16.web.core.windows.net/");
	}
	
	@BeforeMethod
	public void logout(){
		menuPage.clickLogout();	
		loginPage.login("admin", "superduper");
		menuPage.clickNew();
	}
	
	
	
	@Test
	public void createSuccessfullConnenction(){
		Connection c = new Connection("Mahsun","Pinar","M","CTG","Testing","Junior",
				"mahsun.pinar@ctg.com","1234567890","Selenium");
		
		newConnectionPage.createConnection(c);
		Assert.assertTrue(newConnectionPage.isSuccessMessageShown(), "The connection is not created");
	}
}
