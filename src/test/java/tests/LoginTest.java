package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.TestData;

public class LoginTest extends BaseTest{
	@Test
	public void login() {
		log.info("******Clicking on signup/loginbutton******");
		HomePage hp = new HomePage(driver);
		hp.clickSignuplink();
		
		
         
		
		log.info("******LoginData******");
		LoginPage lp = new LoginPage(driver);
		lp.logindata(TestData.email, TestData.password);
		lp.login();
	}

}
