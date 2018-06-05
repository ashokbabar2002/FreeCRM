package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.testBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testUtil.ReadTestData;

public class LoginCRMtest extends testBase{
	
	LoginPage login ;
	HomePage homepage;
	
	public LoginCRMtest() {
		super();
		System.out.println("m in constructor");
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
	public void login() {
		System.out.println("m in befor method");
		initalization();
		login = new LoginPage();		
	}
	
	@DataProvider 
	public Object[][] getdata() throws IOException {
	Object	data[][] = ReadTestData.readExcel("C:\\Users\\SHREE\\eclipse-workspace\\FreeCRM\\src\\main\\java\\com\\crm\\qa\\testdata", "logindata.xls", "Sheet1");
	System.out.println("data in sheet "+data);
	return data ; 
	}

	@Test(dataProvider="getdata")
	public void logintest(String Usernam,String Passwd) throws Exception {	
		homepage = login.logintoCRM(Usernam, Passwd);
		
		//homepage = login.logintoCRM(p.getProperty("username"),p.getProperty("password"));
		//System.out.println("username is "+p.getProperty("username"));		
	}

}
