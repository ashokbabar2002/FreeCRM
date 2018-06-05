package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.testBase;

public class HomePage extends testBase{
      
	@FindBy(xpath="//td[contains(text(),'User:Naveen K')]")
	WebElement usernamelabel;

}
