package com.training.pom;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UserPortalPOM {
/*
 * driver
 * finding elements
 *  
 */
	WebDriver driver;
	@FindBy(linkText= "Edit profile" )
	private WebElement editProfile;
	
	@FindBy(linkText="Course catalog")
	private WebElement coursecatalog;
	
	@FindBy(xpath="//a[contains(text(),'My courses')]")
	private WebElement mycoursemenu;
	
	@FindBy(xpath="//a[contains(text(),'cour8022')]")
	private WebElement coursename;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']//img[@class='img-circle']")
	private WebElement usericon;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']")
	private WebElement drpdownMenu;
	
	@FindBy(xpath="//a[@id='logout_button']")
	private WebElement logoutBtn;
	
	public UserPortalPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickEditProfilelink() {
		this.editProfile.click(); 
	}
	public void clickCourseCatalogBtn() {
		this.coursecatalog.click();
	}
	
	public void clickUsericon() {
		this.usericon.click();
		
	}
	
	public void clicklogoutBtn() {
		this.logoutBtn.click();
	}
	
	public void clickMyCoursemenu() {
		this.mycoursemenu.click();
	}
	
	public void clickCourseName() {
		this.coursename.click();
	}
	
	public void courseDetails() {
		
	}
	
	
	public int listmenuItemsCount() {
		
		List<WebElement> listitems = drpdownMenu.findElements(By.tagName("a"));
		ListIterator lit=listitems.listIterator();
		String linkname="";
		int count=0;
		for(WebElement ele:listitems)
		{
			linkname=ele.getAttribute("title");
			switch(linkname)
				{
				case "Inbox" :
					System.out.println("Linkname: "+ linkname);
					++count;
					break;
				case "My certificates" :
					System.out.println("Linkname: "+ linkname);
					++count;
					break;
				case "Logout" :
					System.out.println("Linkname: "+ linkname);
					++count;
					break;
					
				}
			 	
			}
			System.out.println("#of links found: "+count);
			return count;	
		}
		
}
