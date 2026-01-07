package tests;


import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.RetryAnalyzer;

public class LoginTest extends BaseTest{
	@Test(retryAnalyzer=RetryAnalyzer.class , groups= {"smoke","regression","sanity"})
	public void login() {
		log.info("******Clicking on signup/loginbutton******");
		HomePage hp = new HomePage(driver);
		hp.clickSignuplink();
		
		
		log.info("******LoginData******");
		LoginPage lp = new LoginPage(driver);
		lp.logindata(prop.getProperty("email"),prop.getProperty("password"));
		lp.login();
	}

}
