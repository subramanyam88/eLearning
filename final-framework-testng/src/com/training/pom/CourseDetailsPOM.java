package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseDetailsPOM {
	
	@FindBy(xpath="//a[contains(text(),'cour8022')]")
	private WebElement courseTitle;
	
	@FindBy(xpath = "//a[@id='istooldesc_2438']")
	private WebElement courseDesclink;
	
	public WebDriver driver;
	public CourseDetailsPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean iscourseTitledisplayed() {
		System.out.println("Course Title: "+courseTitle.getText());
		return this.courseTitle.isDisplayed();
		
	}
	
	public void clickCourseDescLink() {
		this.courseDesclink.click();
	}
}
