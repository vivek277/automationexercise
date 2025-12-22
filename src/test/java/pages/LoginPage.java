package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class LoginPage extends BasePage{

	 
	 public LoginPage(WebDriver driver) {
		 super(driver);
	 }
	 
	 @FindBy(xpath= "//input[@data-qa='login-email']")
	 private WebElement loginemail;
	 
	 @FindBy(xpath="//input[@data-qa='login-password']")
	 private WebElement loginpassword;
	 
	 @FindBy(xpath="//button[@data-qa='login-button']")
	 private WebElement loginclick;
	 
	 public void logindata(String email, String password) {
		 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(loginemail));
		 loginemail.sendKeys(email);
		 loginpassword.sendKeys(password);
	 }
	 
	 public void login() {
		 loginclick.click();
	 }
}
