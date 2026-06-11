package core.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
	private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	
	public static ExtentTest getTest() {
		return test.get();
	}
	
	public static void setTest(ExtentTest extentTest) {
		test.set(extentTest);
	}
	
	public static void unload() {
		test.remove();
	}
}
