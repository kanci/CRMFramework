package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//input[@name='email']")
	WebElement username;
	
	@FindBy(name="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginBtn;
	
	//"//button[contains(text(),'Sign Up')], wrong xpath
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//span[text()='Log In']/..")
	WebElement crmLogo;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public String validateLoginPageURL(){
		return driver.getCurrentUrl();
	}
	
	public void validateCRMImage(){
	
		crmLogo.click();
		//crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		    	
		return new HomePage();
	}
	
}
