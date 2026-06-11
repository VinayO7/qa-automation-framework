package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.models.Employee;
import core.utils.JsonUtil;
import ui.base.AuthenticatedBaseTest;
import ui.pages.AddEmployeePage;
import ui.pages.EmployeeDetailsPage;
import ui.pages.PIMPage;

public class EmployeePersonalDetailsTest extends AuthenticatedBaseTest{

	
	Employee employee = JsonUtil.readJson("src/test/resources/testdata/employee.json", Employee.class);
	@Test
	public void addDetails() {
		PIMPage openPim = dashBoard.openPim();
		AddEmployeePage addEmp = openPim.addEmployee();
		EmployeeDetailsPage employeeDetails = addEmp.addEmployee("Vinay", "Pramod", "Nalavade", "0707");
		System.out.println("Emp Details Added!");
		employeeDetails.updatePersonalDetails(employee.getLicenseNumber(), employee.getLicenseExpiryDate(), employee.getdateOfBirth(), employee.getNationality(), employee.getMaritalStatus());
		Assert.assertTrue(employeeDetails.isSuccessToastDisplayed(), "Success toast not displayed");
	}
}
