package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage extends BasePage{
	public PIMPage(WebDriver driver){
		super(driver);
	}
	
	private By addButton = By.xpath("//button[text()=' Add ']"); 
	
	public AddEmployeePage addEmployee() {
		click(addButton);
		return new AddEmployeePage(driver);
	}
}
