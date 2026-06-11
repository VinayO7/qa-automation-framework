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
		WaitUtil.waitForVisibility(driver, locator);
		WebElement element = find(locator);
		element.clear();
		element.sendKeys(String.valueOf(text));
		return this;
	}
	
	protected BasePage click(By locator) {
		WaitUtil.waitForClickability(driver, locator);
		find(locator).click();
		return this;
	}
	
	protected boolean isDisplayed(By locator) {
		try {
			WaitUtil.waitForVisibility(driver, locator);
			return find(locator).isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}
	
	protected BasePage clearText(By locator) {
		WaitUtil.waitForVisibility(driver, locator);
		find(locator).clear();
		return this;
	}
	
	protected String getText(By locator) {
	    WaitUtil.waitForVisibility(driver, locator);
	    return find(locator).getText();
	}
	
	protected void waitForLoader() {
	    WaitUtil.waitForInvisibility(driver, By.cssSelector(".oxd-form-loader"));
	}
}
