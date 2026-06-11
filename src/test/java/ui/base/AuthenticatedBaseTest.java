package ui.base;

import org.testng.Assert;
import org.testng.annotations.*;

import core.config.ConfigReader;
import ui.drivers.DriverFactory;
import ui.pages.DashboardPage;
import ui.pages.LoginPage;

public class AuthenticatedBaseTest extends BaseTest{
	
	protected DashboardPage dashBoard;
	@BeforeMethod
	public void login() {
		LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
		System.out.println(ConfigReader.getProperty("browser"));
		DriverFactory.getDriver().get(ConfigReader.getProperty("base.url"));
		
		Assert.assertTrue(loginPage.isLoginpageDisplayed(),"Login Page is not Displayed!");
		dashBoard = loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
		
		Assert.assertTrue(dashBoard.isDashboardDisplayed(), "DashBoard is not Displayed");
	}
	
	@AfterMethod
	public void logout() {
		LoginPage loginPageAfterLogout = dashBoard.clickLogout();
		Assert.assertTrue(loginPageAfterLogout.isLoginpageDisplayed(), "Login page not displayed after Logout!");
	}
	
}
