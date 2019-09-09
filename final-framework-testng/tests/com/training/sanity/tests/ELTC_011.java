package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.UserPortalPOM;
import com.training.pom.ProfilePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class ELTC_011 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private UserPortalPOM userportalPOM;
	private ProfilePOM profilePOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		
		loginPOM = new LoginPOM(driver); 
		userportalPOM = new UserPortalPOM(driver);
		profilePOM = new ProfilePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	//@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void changePwdTest() throws InterruptedException {
		loginPOM.sendUserName("rajaravi");
		loginPOM.sendPassword("Password1");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("AfterLogin");
		
		userportalPOM.clickEditProfilelink();
		Thread.sleep(8000);
		profilePOM.enterPassword("Password1");
		profilePOM.enterconfPassword("Password1");
		profilePOM.clickSaveSettingsBtn();
		String savePwdConfirmText = profilePOM.confirmPwdUpd();
		Thread.sleep(10000);
		String ExpectedMsg= "Your new profile has been saved";
		
		Assert.assertEquals(savePwdConfirmText, ExpectedMsg, "Password Update is not successful");  
		
		 
		 
	}
}
