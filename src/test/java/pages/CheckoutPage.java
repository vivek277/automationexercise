package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[contains(normalize-space(),'Proceed To Checkout')]")
	private WebElement proceedtocheckout;
	
	@FindBy(xpath = "//tr[@id='product-28']//td[@class='cart_price']")
	private WebElement cartpriceverification;
	
	@FindBy(xpath = "//tr[@id='product-28']//td[@class='cart_quantity']")
	private WebElement cartquantityverification;
	
	@FindBy(xpath = "//tr[@id='product-28']//td[@class='cart_total']")
	private WebElement carttotalverification;
	
	@FindBy(xpath = "//textarea[@name='message']")
	private WebElement commentbox;
	
	@FindBy(xpath="//a[contains(normalize-space(),'Place Order')]")
	private WebElement placeorderbutton;
	
	
	public void proceedcheckout() {
		proceedtocheckout.click();
	}
	
	public int cartpriceverify() {
		String price = cartpriceverification.getText();
		price = price.replaceAll("[^0-9]", "");
		return Integer.parseInt(price);
	}
	 public int cartquantityverify() {
		 return Integer.parseInt(cartquantityverification.getText());
	 }
	 
	 public int carttotalverify() {
		 String total = carttotalverification.getText();
		 total = total.replaceAll("[^0-9]", "");
		 return Integer.parseInt(total);
	 }
	 
	 public void comment() {
		 commentbox.sendKeys("Please bring safely");
	 }
	 
	public void placeorder() {
		placeorderbutton.click();
	}

}
