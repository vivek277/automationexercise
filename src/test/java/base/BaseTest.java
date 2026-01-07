package base;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;




public class BaseTest {
	
	public WebDriver driver;
	public Logger log;
	public Properties prop;
	
	@BeforeMethod(groups = {"smoke","regression","sanity"})
	@Parameters({"os","browser"})
	
	public void setup(String os, String br) throws MalformedURLException {
		log = LogManager.getLogger(this.getClass());
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
			prop.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		log.info("Launching Browser");
		
		String  executionEnv = prop.getProperty("execution_env");
		System.out.println("EXECUTION_ENV = [" +executionEnv + "]");
		
		if("remote".equalsIgnoreCase(executionEnv)) 
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows")) 
			{
				capabilities.setPlatform(Platform.WIN10);
			}
			else
			{
				System.out.println("No matching os found");
			}
			switch(br.toLowerCase())
			{
			case "chrome" : 
				capabilities.setBrowserName("chrome"); 
				break;
				
			case "edge" : 
				capabilities.setBrowserName("MicrosoftEdge"); 
				break;
			case "firefox" : 
				capabilities.setBrowserName("firefox"); 
				break;
			default : throw new RuntimeException("Invalid browser name: " + br);
			}
			
			driver = new RemoteWebDriver(new URL("http://172.20.10.3:4444"), capabilities);
		}
		
		else if("local".equalsIgnoreCase(executionEnv)) 
		{
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
		}
		
		
		log.info("Navigating to URL");
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		log.info("Closing Browser");
		if(driver!=null) {
		driver.quit();
		}
	}
}
