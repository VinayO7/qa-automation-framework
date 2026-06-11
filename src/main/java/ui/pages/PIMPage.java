package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.utils.WaitUtil;

public class PIMPage extends BasePage{
	public PIMPage(WebDriver driver){
		super(driver);
		
		WaitUtil.waitForVisibility(driver, By.xpath("//button[normalize-space()='Add']"), 30); 
	}
	
	private By addButton = By.xpath("//button[normalize-space()='Add']"); 
	
	public AddEmployeePage addEmployee() {
		click(addButton);
		WaitUtil.waitForVisibility(driver, By.xpath("//input[@name='firstName']"), 30);
		return new AddEmployeePage(driver);
	}
}
