package tests;

import org.testng.annotations.Test;
import base.BaseTest;
import pages.HomePage;

public class HomeTest extends BaseTest{

	@Test
	public void openSignupPage() {
		log.info("******Clicking on signupbutton******");
		HomePage hp = new HomePage(driver);
		hp.clickSignuplink();
	}
}


