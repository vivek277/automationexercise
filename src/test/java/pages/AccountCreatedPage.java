package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class AccountCreatedPage extends BasePage{
	
	public AccountCreatedPage(WebDriver driver) {
		super(driver);		
	}
	
	@FindBy(xpath = "//p[contains(text(),'Congratulations! Your new account has been successfully created!')]")
	private WebElement message;
	
	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement continuebtn;
	
	public boolean isAccountCreatedMessageVisible() {
		return message.isDisplayed();
	}
	
	public String getMessageText() {
		return message.getText();
	}
	public void clickContinue() {
		continuebtn.click();
	}
}
