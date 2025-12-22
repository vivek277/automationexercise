package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static void takeScreenshot(WebDriver driver, String screenshotName) {
			String timestamp = new SimpleDateFormat("yyyMMdd_HHmmss").format(new Date());
			String path= System.getProperty("user.dir") + "/screenshots/" + screenshotName+ "_" + timestamp + ".png";
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File tar = new File(path);
			src.renameTo(tar);
			return;
		}
}
