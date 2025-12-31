package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class HeaderPage extends BasePage {

	public HeaderPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[@href='/products']")
	private WebElement products;
	
	public void ProductClick() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(products));
		products.click();
	}
}
