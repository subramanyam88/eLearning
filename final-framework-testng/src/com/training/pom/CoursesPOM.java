package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoursesPOM {
	
	@FindBy(name="search_term")
	private WebElement searchbox;
	
	@FindBy(xpath="//div[@class='input-group']//button[1]")
	private WebElement searchBtn;
	
	@FindBy(xpath="//strong[contains(text(),'Search results for: selenium')]")
	private WebElement searchresultstext;
	
	@FindBy(xpath = "//a[@title='Subscribe']")
	private WebElement subscribeBtn;
	
	public WebDriver driver;
	public CoursesPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterSearchTerm(String value) {
		this.searchbox.clear();
		this.searchbox.sendKeys(value);
	}
	
	public void clickSearchBtn() {
		this.searchBtn.click();
	}

	public void clickSubscribeBtn() {
		this.subscribeBtn.click();
	}
}
