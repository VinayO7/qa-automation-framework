package ui.tests;

import org.testng.annotations.Test;

import ui.base.AuthenticatedBaseTest;
import ui.pages.AddEmployeePage;
import ui.pages.EmployeeDetailsPage;
import ui.pages.PIMPage;

public class EmployeePersonalDetailsTest extends AuthenticatedBaseTest{

	@Test
	public void addDetails() {
		PIMPage openPim = dashBoard.openPim();
		AddEmployeePage addEmp = openPim.addEmployee();
		EmployeeDetailsPage employeeDetails = addEmp.addEmployee("Vinay", "Pramod", "Nalavade", "0707");
		System.out.println("Emp Details Added!");
		employeeDetails.updatePersonalDetails("123456789", "06-01-2032", "08-24-2024", "Indian", "Single");
		
	}
}
