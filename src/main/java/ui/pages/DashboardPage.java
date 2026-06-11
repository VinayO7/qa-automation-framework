package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.utils.WaitUtil;

public class DashboardPage extends BasePage{
	private By dashBoardHeader = By.xpath("//h6[text()='Dashboard']");
	private By profileDropdown = By.xpath("//span[@class='oxd-userdropdown-tab']");
	private By logoutLink = By.xpath("//a[text()='Logout'] ");
	private By pimMenu = By.xpath("//span[text()='PIM']");
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isDashboardDisplayed() {
		WaitUtil.waitForVisibility(driver, dashBoardHeader, 20);
		return isDisplayed(dashBoardHeader);
	}
	
	public void clickProfileDropdown() {
		click(profileDropdown);
	}
	
	public LoginPage clickLogout() {
		clickProfileDropdown();
		click(logoutLink);
		return new LoginPage(driver);
	}
	
	public PIMPage openPim() {
		click(pimMenu);
		return new PIMPage(driver);
	}
}
