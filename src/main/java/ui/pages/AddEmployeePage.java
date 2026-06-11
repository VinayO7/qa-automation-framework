package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.utils.WaitUtil;

public class AddEmployeePage extends BasePage{
	
	public AddEmployeePage(WebDriver driver) {
		super(driver);
	}
	
	private By firstName = By.xpath("//input[@name='firstName']");
	private By middleName = By.xpath("//input[@name='middleName']");
	private By lastName = By.xpath("//input[@name='lastName']");
	private By empId = By.xpath("//label[text()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input");
	private By saveButton = By.xpath("//button[text()=' Save ']");
	private By successMsg = By.xpath("//p[text()='Success']");
	
	public void enterFullName(String fName,String sName,String lName) {
		WaitUtil.waitForVisibility(driver, firstName);
		type(firstName, fName);
		type(middleName, sName);
		type(lastName, lName);
	}
	public void enterEmployeeId(String id) {
		WaitUtil.waitForVisibility(driver, empId);
		clearText(empId).type(empId, id);
	}
	
	public boolean isSuccessMsgDisplayed() {
		return isDisplayed(successMsg);
	}
	
	public EmployeeDetailsPage addEmployee(String fName, String sName, String lName, String employeeId) {
        enterFullName(fName, sName, lName);
        enterEmployeeId(employeeId);
        return clickSave();
    }
	
	public EmployeeDetailsPage clickSave() {
	    WaitUtil.waitForInvisibility(driver, By.cssSelector(".oxd-form-loader"), 30);
	    click(saveButton);
	    WaitUtil.waitForInvisibility(driver, By.cssSelector(".oxd-form-loader"), 30);
	    return new EmployeeDetailsPage(driver);
	}
}
