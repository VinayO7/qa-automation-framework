package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.config.ConfigReader;
import ui.base.BaseTest;
import ui.drivers.DriverFactory;
import ui.pages.DashboardPage;
import ui.pages.LoginPage;

public class LaunchTest extends BaseTest{
	
	@Test
	public void launchApplication() {
		System.out.println("Test Running!");
		System.out.println(ConfigReader.getProperty("browser"));
		DriverFactory.getDriver().get(ConfigReader.getProperty("base.url"));
	}
	
	@Test
	public void login() {
		LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
		System.out.println(ConfigReader.getProperty("browser"));
		DriverFactory.getDriver().get(ConfigReader.getProperty("base.url"));
		
		Assert.assertTrue(loginPage.isLoginpageDisplayed(),"Login Page is not Displayed!");
		DashboardPage dashBoard = loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		Assert.assertTrue(dashBoard.isDashboardDisplayed(), "DashBoard is not Displayed");
		
		LoginPage loginPageAfterLogout = dashBoard.clickLogout();
		Assert.assertTrue(loginPageAfterLogout.isLoginpageDisplayed(), "Login page not displayed after Logout!");
	
	}
}
