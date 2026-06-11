package core.models;

public class Employee {
	
	private String licenseNumber;
    private String licenseExpiryDate;
    private String dateOfBirth;
    private String nationality;
    private String maritalStatus;
    
    public Employee() {
    	
    }
    
    public String getLicenseNumber() {
    	return licenseNumber;
    }
    public void setLicenseNumber(String licenseNumber) {
    	this.licenseNumber = licenseNumber;
    }
    
    public String getLicenseExpiryDate() {
    	return licenseExpiryDate;
    }
    public void setLicenseExpiryDate(String licenseExpiryDate) {
    	this.licenseExpiryDate = licenseExpiryDate;
    }
    
    public String getdateOfBirth() {
    	return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
    	this.dateOfBirth = dateOfBirth;
    }
    
    public String getNationality() {
    	return nationality;
    }
    public void setNationality(String nationality) {
    	this.nationality = nationality;
    }
    
    public String getMaritalStatus() {
    	return maritalStatus;
    }
    public void setMaritalStatus(String maritalStatus) {
    	this.maritalStatus = maritalStatus;
    }
}
