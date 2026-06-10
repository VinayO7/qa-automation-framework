package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.utils.WaitUtil;

public class EmployeeDetailsPage extends BasePage{
	
	public EmployeeDetailsPage(WebDriver driver) {
		super(driver);
		WaitUtil.waitForInvisibility(driver,By.cssSelector(".oxd-form-loader"),10);
	}
	
//	private By nickName = By.xpath("//label[text()='Nickname']/ancestor::div[contains(@class,'oxd-input-group')]//input");
	private By driverLicenseNumber = By.xpath("//label[contains(text(),\"Driver's License Number\")]/ancestor::div[contains(@class,'oxd-input-group')]//input");
	private By licenseExpiryDate = By.xpath("//input[contains(@placeholder, 'yyyy-dd-mm')]");
	private By nationality = By.xpath("//label[text()='Nationality']/ancestor::div[contains(@class,'oxd-input-group')]//div[@class='oxd-select-text-input']");
	private By maritalStatus = By.xpath("//label[text()='Marital Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[@class='oxd-select-text-input']");
	private By dateOfBirth = By.xpath("(//input[contains(@placeholder, 'yyyy-dd-mm')])[2]");
	private By genderMale = By.xpath("//input[contains(@value,'1')]");
//	private By smokerCheckBox = By.xpath("(//input[contains(@type,'checkbox')])[1]");
	private By saveButton = By.xpath("(//button[@type='submit' and normalize-space()='Save'])[1]");
	private By loader = By.cssSelector(".oxd-form-loader");
	
	public void updatePersonalDetails( String licenseNumber, String licenseExpDate, String dob, String nationality1, String maritalStatus1) {
		WaitUtil.waitForInvisibility(driver, loader, 10);
//		type(nickName,name);
		type(driverLicenseNumber,licenseNumber);
		System.out.println("licence number added!");
		type(licenseExpiryDate, licenseExpDate);
		click(nationality);
		WaitUtil.waitForVisibility(driver, nationality, 10);
		driver.findElement(By.xpath("//*[normalize-space()='"+nationality1+"']")).click();
		click(maritalStatus);
		WaitUtil.waitForVisibility(driver, maritalStatus, 10);
		driver.findElement(By.xpath("//*[normalize-space()='"+maritalStatus1+"']")).click();
		clearText(dateOfBirth).type(dateOfBirth, dob);
		click(genderMale);
		click(saveButton);
	}
}
