package pages;

import java.time.Duration;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;




public class AccountInformationPage extends BasePage{
	
	
	public AccountInformationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//label[@for='id_gender1']")
	private WebElement mrRadio;
	
	@FindBy(id="password")
	private WebElement Password;
	
	@FindBy(id="days")
	private WebElement days;
	
	@FindBy(id="months")
	private WebElement months;
	
	@FindBy(id="years")
	private WebElement years;
	
	@FindBy(id="first_name")
	private WebElement firstname;
	
	@FindBy(id="last_name")
	private WebElement lastname;
	
	@FindBy(id="address1")
	private WebElement address1;
	
	@FindBy(id="state")
	private WebElement state;
	
	@FindBy(id="city")
	private WebElement city;
	
	@FindBy(id="zipcode")
	private WebElement zipcode;
	
	@FindBy(id="mobile_number")
	private WebElement mobilenumber;
	
	@FindBy(xpath="//button[normalize-space()='Create Account']")
	private WebElement createaccountbtn;
	
	public void selectMrTitle() {
		mrRadio.click();
	}
	
	public void enterpassword(String password) {
		Password.sendKeys(password);
	}
	public void selectDOB(String day, String month, String year) {
		Select dayselect = new Select(days);
		dayselect.selectByVisibleText(day.trim());
		
		Select monthselect = new Select(months);
		monthselect.selectByVisibleText(month.trim());
		
		Select yearselect = new Select(years);
		yearselect.selectByVisibleText(year.trim());	
	}
	
	public void enteraddress(String fn, String ln, String add, String st, String ct, String zip, String mob) {
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		address1.sendKeys(add);
		state.sendKeys(st);
		city.sendKeys(ct);
		zipcode.sendKeys(zip);
		mobilenumber.sendKeys(mob);
	}
	
	public void createaccount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",createaccountbtn);
		
		wait.until(ExpectedConditions.elementToBeClickable(createaccountbtn));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",createaccountbtn);
	}
	
}
