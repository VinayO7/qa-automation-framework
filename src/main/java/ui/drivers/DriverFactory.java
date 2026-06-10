package ui.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setDriver (WebDriver driver) {
		DriverFactory.driver = driver;
	}
	
	public static void initializeDriver() {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Driver called for Initialization");
	}
}
