package tests;

import org.testng.annotations.Test;
import base.BaseTest;
import pages.HomePage;
import utils.RetryAnalyzer;

public class HomeTest extends BaseTest{

	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void openSignupPage() {
		log.info("******Clicking on signupbutton******");
		HomePage hp = new HomePage(driver);
		hp.clickSignuplink();
	}
}


