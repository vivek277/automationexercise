package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class ProductDetailsPage extends BasePage{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-default cart']")
	private WebElement addtocartbtn;
	
	@FindBy(xpath="//p[normalize-space()='Your product has been added to cart.'][1]")
	private WebElement message;
	
	@FindBy(xpath="//u[normalize-space()='View Cart']")
	private WebElement viewcartbtn;
	
	public void addToCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(addtocartbtn)).click();
	}
	public String isProductAddedToCartMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(message));
		return message.getText();
	}
	
	public void clickViewCart() {
		viewcartbtn.click();
	}

}
