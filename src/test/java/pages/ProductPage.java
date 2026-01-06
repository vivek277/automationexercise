package pages;




import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


import base.BasePage;

public class ProductPage extends BasePage {
	
	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@href='#Men']")
	private WebElement Men;
	
	@FindBy(xpath ="//a[@href='/category_products/3']")
	private WebElement Tshirts;
	
	
	@FindBy(xpath="(//h2[contains(text(),'Rs. 1299')]/ancestor::div[contains(@class,'product-image-wrapper')]//a)[3]")
	private WebElement productcard;
	
	public void MenClick() {
		Men.click();
	}
	
	public void TshirtsClick() {
		Tshirts.click();
	}
	
	public void Productcheck() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});",productcard);
		
		try {
			Thread.sleep(800);
		}catch (InterruptedException e) {
			e.printStackTrace();	
		}
		js.executeScript("arguments[0].click();", productcard);
		//Actions action = new Actions(driver);
		//action.moveToElement(productcard).click().perform();
		//productchk.click();
	}

}
