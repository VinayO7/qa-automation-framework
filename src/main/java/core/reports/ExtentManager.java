package core.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	public static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		if(extent == null) {
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
			
			sparkReporter.config().setReportName("Hybrid Automation Framework Report");
			
			sparkReporter.config().setDocumentTitle("Automation Execution Report");
			
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Framework", "Selenium Hybrid Framework");
			extent.setSystemInfo("Test Engineer", "Vinay Nalavade");
			extent.setSystemInfo("environment", "QA");			
		}
		return extent;
	}
}
