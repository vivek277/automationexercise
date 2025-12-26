package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	public static ExtentReports extent;
	
	public static ExtentReports getExtentReport() {
		if(extent==null) {
			
			ExtentSparkReporter spark= new ExtentSparkReporter("extent-reports/ExtentReporter.html");
			spark.config().setReportName("Automation Test Report");
			spark.config().setDocumentTitle("Test Automation Report");
			
			extent = new ExtentReports();
			extent.attachReporter(spark);
			
			extent.setSystemInfo("Tester","Vivek Barnwal");
			extent.setSystemInfo("Framework","Selenium + TestNG");
			extent.setSystemInfo("OS",System.getProperty("os.name"));
			
		}
		return extent;
	}

}
