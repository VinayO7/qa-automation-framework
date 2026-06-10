package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.utils.WaitUtil;

public class BasePage {
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	protected WebElement find(By locator){
	    return driver.findElement(locator);
	}
	
	protected BasePage type(By locator, Object text) {
		WaitUtil.waitForVisibility(driver, locator, 10);
		find(locator).sendKeys(String.valueOf(text));
		return this;
	}
	
	protected BasePage click(By locator) {
		WaitUtil.waitForVisibility(driver, locator, 10);
		find(locator).click();
		return this;
	}
	
	protected boolean isDisplayed(By locator) {
		try {
			WaitUtil.waitForVisibility(driver, locator, 10);
			return find(locator).isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}
	
	protected BasePage clearText(By locator) {
		WaitUtil.waitForVisibility(driver, locator, 10);
		find(locator).clear();
		return this;
	}
}
