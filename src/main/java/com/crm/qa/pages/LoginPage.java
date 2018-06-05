package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.testBase;

public class LoginPage extends testBase{
	//WebDriver driver;

	@FindBy(xpath="//input[@type = 'text']")
	WebElement username;
	
	@FindBy(xpath="//input[@name = 'password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type = 'submit']")
	WebElement loginbtn;
	
	
	public LoginPage() {
		System.out.println("m inside login method");		
		PageFactory.initElements(driver, this);
	}
	
	public  HomePage logintoCRM(String uname,String passwd) throws Exception {
		username.sendKeys(uname);
		Thread.sleep(10000);
		password.sendKeys(passwd);
		System.out.println("paswd is "+passwd);
		Thread.sleep(10000);		
		loginbtn.click();
		return new HomePage();
	}
	
	
}
