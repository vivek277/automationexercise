package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class BaseTest {
	
	public WebDriver driver;
	public Logger log;
	
	@BeforeMethod
	public void setup() {
		log = LogManager.getLogger(this.getClass());
		log.info("Launching Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		log.info("Navigating to URL");
		driver.get("https://automationexercise.com/");	
	}

	@AfterMethod
	public void tearDown() {
		log.info("Closing Browser");
		if(driver!=null) {
		driver.quit();
		}
	}
}
