package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;

public class TestListeners implements ITestListener{
	
	private static Logger log = LogManager.getLogger(TestListeners.class);
	
	@Override
	public void onStart(ITestContext context) {
		log.info("====TEST EXECUTION STARTED====");
	}
	
	@Override
	public void onTestStart(ITestResult Result) {
		log.info("TEST STARTED:" + Result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult Result) {
		log.info("TEST Pass:" + Result.getName());
	}
	
	@Override
	public void onTestFailure(ITestResult Result) {
		log.error("TEST Fail:" + Result.getName());
		log.error("TEST Fail Reason:" + Result.getThrowable());
		
		Object testClass = Result.getInstance();
		if(testClass instanceof BaseTest) {
			ScreenshotUtil.takeScreenshot(((BaseTest) testClass).driver, Result.getName());
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult Result) {
		log.info("TEST Skip:" + Result.getName());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		log.info("====TEST EXECUTIONFinish====");
	}
}
