package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	private By usernameTextBox = By.name("username");
	private By passwordTextBox = By.name("password");
	private By loginButton = By.cssSelector("button[type='submit']");
	private By loginText = By.xpath("//h5[text()='Login']");
	
	public void enterUsername(String username) {
		type(usernameTextBox, username);
	}
	
	public void enterPassword(String password) {
		type(passwordTextBox, password);
	}
	
	public void clickLogin() {
		click(loginButton);
	}
	
	public boolean isLoginpageDisplayed() {
		return isDisplayed(loginText);
	}
	
	public DashboardPage login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();	
		DashboardPage dashBoard = new DashboardPage(driver);
		return dashBoard;
	}
}
