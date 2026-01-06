package base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;




public class BaseTest {
	
	public WebDriver driver;
	public Logger log;
	public Properties prop;
	
	@Parameters({"os","browser"})
	@BeforeClass
	public void setup(String os, String br) {
		log = LogManager.getLogger(this.getClass());
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
			prop.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		log.info("Launching Browser");
		
		switch(br.toLowerCase())
		{
		case "chrome" : 
			System.setProperty("webdriver.chrome.driver","C:\\Users\\WebDriver\\chromedriver.exe");
			driver = new ChromeDriver(); 
			break;
		case "edge" : 
			System.setProperty("webdriver.edge.driver","C:\\Users\\WebDriver\\msedgedriver.exe");
			driver = new EdgeDriver(); 
			break;
		case "firefox" : 
			System.setProperty("webdriver.gecko.driver","C:\\Users\\WebDriver\\geckodriver.exe");
			driver = new FirefoxDriver(); 
			break;
		default : throw new RuntimeException("Invalid browser name: " + br);
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		log.info("Navigating to URL");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		log.info("Closing Browser");
		if(driver!=null) {
		driver.quit();
		}
	}
}
