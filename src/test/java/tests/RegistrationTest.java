package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountCreatedPage;
import pages.AccountInformationPage;
import pages.HomePage;
import pages.RegistrationPage;
import utils.ExcelReader;
import utils.ScreenshotUtil;
import utils.TestData;

public class RegistrationTest extends BaseTest {
	
	@Test
	public void Register() {
		
		log.info("******Starting RegistrationTest******");
		
		Object[][] data = ExcelReader.readExcelData();
		
		log.info("******SignupData******");
		String name = data[0][0].toString();
		String email = data[0][1].toString();
		
        email = email.replace("@", System.currentTimeMillis() + "@");
		
		log.info("******AccountInfoData******");
		String password=data[0][2].toString();
		String day=data[0][3].toString();
		String month=data[0][4].toString();
		String year=data[0][5].toString();
		String fn=data[0][6].toString();
		String ln=data[0][7].toString();
		String add=data[0][8].toString();
		String st=data[0][9].toString();
		String ct=data[0][10].toString();
		String zip=data[0][11].toString();
		String mob=data[0][12].toString();
		
		TestData.email=email;
		TestData.password=password;
		
		
		
		HomePage hp = new HomePage(driver);
		log.info("******ClickingOnSignUpButton******");
		hp.clickSignuplink();
		
		
		RegistrationPage rp = new RegistrationPage(driver);
		log.info("******EnteredName******");
		rp.enterName(name);
		
		log.info("******EnteredEmail******");
		rp.enterEmail(email);
		
		log.info("******clickedon signupbutton******");
		rp.clicksignupbtn();
		
		
		AccountInformationPage aip = new AccountInformationPage(driver);
		
		
		log.info("******EnterePassword******");
		aip.enterpassword(password);
		
		log.info("******EntereFirstName,LastName,Address,State,City,ZIP,MobileNumber******");
		aip.enteraddress(fn, ln, add, st, ct, zip, mob);
		
		log.info("******selectDOB******");
		aip.selectDOB(day, month, year);
		
		log.info("******ClickingOnCreateAccountButton******");
		aip.createaccount();
		
		
		AccountCreatedPage acp = new AccountCreatedPage(driver);
		 log.info("******ValidationOfMessage******");
		 String actualText = acp.getMessageText();
		 String ExpectedText = "Congratulations! Your new account has been successfully created!";
		 Assert.assertEquals(actualText.trim(), ExpectedText,"Account created success message");
		 
		 ScreenshotUtil.takeScreenshot(driver,"AccountCreatedSuccess");
		 
		 log.info("******ClickingOnContinueButton******");
		 acp.clickContinue();
	}
	
}
