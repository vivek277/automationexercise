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
import pages.ProductDetailsPage;
import pages.ProductPage;
import utils.RetryAnalyzer;

public class ProductDetailsTest extends BaseTest{

	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void ProductDetails(){
		
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
		
		log.info("******Confimation of Product Added******");
		
		String actualText = pdp.isProductAddedToCartMessage();
		String expectedText = "Your product has been added to cart.";
		Assert.assertEquals(actualText.trim(), expectedText, "Product added to cart successfully");
		
		log.info("******Clicking on view cart button******");
		pdp.clickViewCart();
		
		
		
	}
	
	
}
