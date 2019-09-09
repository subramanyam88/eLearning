package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseDescPOM {
	
	@FindBy(xpath="//li[contains(text(),'Description')]")
	private WebElement courseDesc;
	
	public WebDriver driver;
	public CourseDescPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean iscourseDescdisplayed() {
		
		return this.courseDesc.isDisplayed();
		
	}
	
	}
