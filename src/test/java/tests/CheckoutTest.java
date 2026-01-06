package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CheckoutPage;
import pages.HeaderPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductPage;
import utils.RetryAnalyzer;

public class CheckoutTest extends BaseTest {
	
	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void checkout(){
		
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
		
		ProductDetailsPage pdp = new ProductDetailsPage(driver);
		log.info("******Clicking on Add To Cart button******");
		pdp.addToCart();
		log.info("******Clicking on View Cart button******");
		pdp.clickViewCart();
		
		
		CheckoutPage cp = new CheckoutPage(driver);
		log.info("******Clicking on Proceed to Checkout******");
		cp.proceedcheckout();
		log.info("******Verify cart price******");
		cp.cartpriceverify();
		log.info("******Verify cart quantity******");
		cp.cartquantityverify();
		log.info("******Verify cart total price******");
		cp.carttotalverify();
		log.info("******providing comment******");
		cp.comment();
		log.info("******Clicking on Place Order button******");
		cp.placeorder();

     }
}