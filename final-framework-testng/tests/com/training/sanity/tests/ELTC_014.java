package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CourseDescPOM;
import com.training.pom.CourseDetailsPOM;
import com.training.pom.CoursesPOM;
import com.training.pom.LoginPOM;
import com.training.pom.UserPortalPOM;
import com.training.pom.ProfilePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_014 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private UserPortalPOM userportalPOM;
	private ProfilePOM profilePOM;
	private CoursesPOM  coursePOM;
	private CourseDetailsPOM courseDetailsPOM;
	private CourseDescPOM courseDescPOM;
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
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		loginPOM = new LoginPOM(driver); 
		userportalPOM = new UserPortalPOM(driver);
		coursePOM = new CoursesPOM(driver);
		courseDetailsPOM = new CourseDetailsPOM(driver);
		courseDescPOM = new CourseDescPOM(driver); 
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
	public void courseDetailsTest() throws InterruptedException {
		loginPOM.sendUserName("rajaravi");
		loginPOM.sendPassword("Password1");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("AfterLogin");
		
		userportalPOM.clickMyCoursemenu();
		userportalPOM.clickCourseName();
		courseDetailsPOM.iscourseTitledisplayed();
		courseDetailsPOM.clickCourseDescLink();
		Thread.sleep(10000);
		Assert.assertTrue(courseDescPOM.iscourseDescdisplayed());
		
			

		
	}
}
