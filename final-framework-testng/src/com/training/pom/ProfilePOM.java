package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePOM {

	@FindBy(id="password1")
	private WebElement password;
	
	@FindBy(id="profile_password2")
	private WebElement confirmPwd;
	
	@FindBy(id="profile_apply_change")
	private WebElement saveSettingsBtn;
	
	@FindBy(xpath="//div[@class='alert alert-info']")
	private WebElement savePwdConfirmText;
	
	private WebDriver driver;
	
	public ProfilePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	public void enterPassword(String pwdval)
	{
		this.password.clear();
		this.password.sendKeys(pwdval);
	}
	public void enterconfPassword(String pwdval)
	{
		this.confirmPwd.clear();
		this.confirmPwd.sendKeys(pwdval);
	}
	
	public void clickSaveSettingsBtn() {
		this.saveSettingsBtn.click();
	}
	public String confirmPwdUpd() {
	
		return savePwdConfirmText.getText();
	}
	
}
