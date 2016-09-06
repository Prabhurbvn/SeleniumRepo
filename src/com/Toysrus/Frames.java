package com.Toysrus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Frames 
{
	WebDriver driver;
	String Url="http://www.toysrus.com";
	@BeforeClass
	public void setup()
	{
		ProfilesIni myprofile=new ProfilesIni();
		FirefoxProfile allprofile=myprofile.getProfile("default");
		allprofile.setAcceptUntrustedCertificates(true);
		driver=new FirefoxDriver(allprofile);
		driver.get(Url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void iframes()
	{
		int noframe=driver.findElements(By.tagName("iframes")).size();
		System.out.println("The Number of iframe is :"+noframe);
		
	}
	
	@AfterClass
	public void tearDown()
	{
		if(driver!=null);
		driver.close();
	}


}
