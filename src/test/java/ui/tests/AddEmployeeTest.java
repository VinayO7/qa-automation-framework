package ui.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ui.base.AuthenticatedBaseTest;
import ui.pages.AddEmployeePage;
import ui.pages.PIMPage;

public class AddEmployeeTest extends AuthenticatedBaseTest{
	@Test
	public void addEmp() {
		PIMPage pimPage = dashBoard.openPim();
		AddEmployeePage addEmpPage = pimPage.addEmployee();
		addEmpPage.addEmployee("Vinay", "Pramod", "Nalavade", "0707");
		Assert.assertTrue(addEmpPage.isSuccessMsgDisplayed(), "Employee not Added!");
	}
}
