package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HeaderPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import utils.RetryAnalyzer;

public class ProductTest extends BaseTest{
     
	@Test(retryAnalyzer=RetryAnalyzer.class , groups= {"sanity","regression"})
	public void Product() {
		
		log.info("******Clicking on signupbutton******");
		HomePage hp = new HomePage(driver);
		hp.clickSignuplink();
		
		
		log.info("******LoginData******");
		LoginPage logg = new LoginPage(driver);
		logg.logindata(prop.getProperty("email"),prop.getProperty("password"));
		logg.login();
		
		
		log.info("******Clicking on Products******");
		HeaderPage headerpage = new HeaderPage(driver);
		headerpage.ProductClick();
		
		log.info("******Clicking on Category******");
		ProductPage pg = new ProductPage(driver);
		pg.MenClick();
		pg.TshirtsClick();
		
		log.info("******Clicking on Specific product******");
		pg.Productcheck();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("product_details"));
		
		String currenturl = driver.getCurrentUrl();
		System.out.println("Current URL:" + currenturl);
		Assert.assertTrue(currenturl.contains("product_details"),"product details not open");
		System.out.println("product opened successfully");
	}
	
}
