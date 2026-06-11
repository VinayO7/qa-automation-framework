package core.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.config.ConfigReader;


public class WaitUtil {
	
	private static final int DEFAULT_TIMEOUT = ConfigReader.getTimeout();
	
	public static void waitForVisibility(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void waitForVisibility(WebDriver driver, By locator, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void waitForInvisibility(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public static void waitForInvisibility(WebDriver driver, By locator, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public static void waitForClickability(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
		
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void waitForPresence(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public static void waitForTextToBePresent(WebDriver driver, By locator, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}
	
	public static void waitForUrlContains(WebDriver driver, String urlPart) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
		
		wait.until(ExpectedConditions.urlContains(urlPart));
	}

}
