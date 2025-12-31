package base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class BaseTest {
	
	public WebDriver driver;
	public Logger log;
	public Properties prop;
	
	@BeforeMethod
	public void setup() {
		log = LogManager.getLogger(this.getClass());
		
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
			prop.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		log.info("Launching Browser");
		
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		log.info("Navigating to URL");
		driver.get(prop.getProperty("url"));	
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		log.info("Closing Browser");
		if(driver!=null) {
		driver.quit();
		driver=null;
		}
	}
}
