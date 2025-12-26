package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;

public class TestListeners implements ITestListener{
	
	ExtentReports extent = ExtentManager.getExtentReport();
	ExtentTest Test;
	private static Logger log = LogManager.getLogger(TestListeners.class);
	
	@Override
	public void onStart(ITestContext context) {
		log.info("====TEST EXECUTION STARTED====");
	}
	
	@Override
	public void onTestStart(ITestResult Result) {
		log.info("TEST STARTED:" + Result.getName());
		Test=extent.createTest(Result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult Result) {
		log.info("TEST Pass:" + Result.getName());
		Test.pass("Test Passed");
	}
	
	@Override
	public void onTestFailure(ITestResult Result) {
		log.error("TEST Fail:" + Result.getName());
		log.error("TEST Fail Reason:" + Result.getThrowable());
		Test.fail(Result.getThrowable());
		
		Object testClass = Result.getInstance();
		BaseTest base = (BaseTest) testClass;
		String path = ScreenshotUtil.takeScreenshot(base.driver, Result.getName());
		Test.addScreenCaptureFromPath(path);
		
	}
	
	@Override
	public void onTestSkipped(ITestResult Result) {
		log.info("TEST Skip:" + Result.getName());
		Test.skip("Test Skipped");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		log.info("====TEST EXECUTION FINISH====");
		extent.flush();
	}
}
