package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import base.BasePage;



public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Signup / Login")
	private WebElement signuplink;
	
	
	public void clickSignuplink() { 
		signuplink.click();
	}

}
