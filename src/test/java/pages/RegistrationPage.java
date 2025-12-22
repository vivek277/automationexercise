package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import base.BasePage;


public class RegistrationPage extends BasePage {
	
	
	public RegistrationPage(WebDriver driver) {
		super(driver);	
	}
	
	@FindBy(name="name")
	private WebElement nameField;
	
	@FindBy(xpath=("//input[@data-qa='signup-email']"))
	private WebElement emailField;
	
	@FindBy(xpath=("//button[@data-qa='signup-button']"))
	private WebElement signbtn;

	
	public void enterName(String name) {
		nameField.sendKeys(name);	
	}
	public void enterEmail(String email) {
	    emailField.sendKeys(email);
	}
	public void clicksignupbtn() {
		signbtn.click();
	}
	
}
