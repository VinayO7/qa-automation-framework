package core.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import core.reports.ExtentManager;
import core.reports.ExtentTestManager;
import core.utils.ScreenshotUtil;
import ui.drivers.DriverFactory;

public class TestListener implements ITestListener{
	
	@Override
	public void onStart(ITestContext context) {
		ExtentManager.getInstance();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTestManager.setTest(ExtentManager.getInstance().createTest(result.getMethod().getMethodName()));
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		String screenshotPath = ScreenshotUtil.captureScreenshot(DriverFactory.getDriver(), result.getMethod().getMethodName());
		
		ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable());
		
		ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);
		
		ExtentTestManager.getTest().log(Status.INFO, "URL: "+ DriverFactory.getDriver().getCurrentUrl());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		ExtentManager.getInstance().flush();
		ExtentTestManager.unload();
	}
}
