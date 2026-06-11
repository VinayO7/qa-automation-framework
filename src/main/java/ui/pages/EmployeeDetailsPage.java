package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.utils.WaitUtil;

public class EmployeeDetailsPage extends BasePage{
	
	public EmployeeDetailsPage(WebDriver driver) {
		super(driver);
		WaitUtil.waitForInvisibility(driver,loader);
	}
	
	private By driverLicenseNumber = By.xpath("//label[contains(.,'Driver')]/ancestor::div[contains(@class,'oxd-input-group')]//input[contains(@class,'oxd-input')]");
	private By licenseExpiryDate = By.xpath("//label[contains(normalize-space(),'License Expiry Date')]/ancestor::div[contains(@class,'oxd-input-group')]//input");
	private By nationality = By.xpath("//label[text()='Nationality']/ancestor::div[contains(@class,'oxd-input-group')]//div[@class='oxd-select-text-input']");
	private By maritalStatus = By.xpath("//label[text()='Marital Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[@class='oxd-select-text-input']");
	private By dateOfBirth = By.xpath("//label[contains(normalize-space(),'Date of Birth')]/ancestor::div[contains(@class,'oxd-input-group')]//input");
	private By genderMale = By.xpath("//label[normalize-space()='Male']/span");
	private By saveButton = By.xpath("(//button[@type='submit' and normalize-space()='Save'])[1]");
	private By loader = By.cssSelector(".oxd-form-loader");
	private By successToast = By.xpath("//p[contains(@class,'toast-title') and text()='Success']");
	
	public EmployeeDetailsPage updatePersonalDetails( String licenseNumber, String licenseExpDate, String dob, String nationality1, String maritalStatus1) {
		WaitUtil.waitForInvisibility(driver, loader);
		clearText(driverLicenseNumber);
		System.out.println("1.license text cleared.");
		WebElement licence = driver.findElement(driverLicenseNumber);

		licence.clear();
		licence.sendKeys(licenseNumber);

		System.out.println(
		    "Value = " + licence.getAttribute("value"));
		
		System.out.println("2.licence number added!");
		typeDate(licenseExpiryDate, licenseExpDate);
		System.out.println("3.license date added.");
		WaitUtil.waitForVisibility(driver, nationality);
		
		
		click(nationality);
		System.out.println("4. nationality clicked");
		By nationalityOption = By.xpath("//*[normalize-space()='"+nationality1+"']");
		WaitUtil.waitForVisibility(driver, nationalityOption);
		driver.findElement(nationalityOption).click();
		System.out.println("5.nationality added.");
		
		
		WaitUtil.waitForVisibility(driver, maritalStatus);
		click(maritalStatus);
		System.out.println("6.marital status clicked.");
		By maritalStatusOption = By.xpath("//*[normalize-space()='"+maritalStatus1+"']");
		WaitUtil.waitForVisibility(driver, maritalStatusOption);
		driver.findElement(maritalStatusOption).click();
		System.out.println("7. marital status added.");
		clearText(dateOfBirth);
		typeDate(dateOfBirth, dob);
		System.out.println("8.dob added.");
		click(genderMale);
		System.out.println("9.gender added.");
		click(saveButton);
		System.out.println("10.personal details saved.");
		WaitUtil.waitForInvisibility(driver, loader);
		return this;
	}
	
	public boolean isSuccessToastDisplayed() {

	    return isDisplayed(successToast);
	}
}
