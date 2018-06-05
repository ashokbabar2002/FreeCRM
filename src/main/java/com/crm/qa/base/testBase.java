package com.crm.qa.base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class testBase {	
	public static WebDriver driver;
	public static String url;	
	public static Properties p;
   // driver = new FirefoxDriver();
	 
    public testBase()  {
		  FileReader reader = null;
		try {
			reader = new FileReader("C:\\Users\\SHREE\\eclipse-workspace\\FreeCRM\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	      
		   p=new Properties();  
		  try {
			p.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 // url = p.getProperty(url);
		  System.out.println(p.getProperty("url"));		
	 }
	 
	 public void initalization() {	
	  System.setProperty("webdriver.gecko.driver", "C:/Users/SHREE/Downloads/geckodriver.exe");
	   DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	   capabilities.setCapability("marionette",true);
	   driver= new FirefoxDriver(capabilities);
	   ///driver = new FirefoxDriver();
	   driver.get(p.getProperty("url")); 
	 }
}
