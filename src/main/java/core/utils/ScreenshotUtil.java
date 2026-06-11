package core.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.nio.file.Files;

public class ScreenshotUtil {
	
	public static String captureScreenshot(WebDriver driver, String testName) {
		String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		
		new File("screenshots").mkdirs();
		
		String filePath = "screenshots/" + testName + "_" + timeStamp + ".png";
		
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			Files.copy(source.toPath(), new File(filePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
		catch (IOException e){
			e.printStackTrace();
		}
		return filePath;
	}
}
