package ui.base;

import ui.drivers.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	@BeforeMethod
	public void setup() {
		DriverFactory.initializeDriver();
		System.out.println("Driver Initialization Begin!");
	}
	
	@AfterMethod
	public void tearDown() {
		if(DriverFactory.getDriver()!=null){
		    DriverFactory.getDriver().quit();
		}
		System.out.println("Driver Tear Down!");
	}
}
