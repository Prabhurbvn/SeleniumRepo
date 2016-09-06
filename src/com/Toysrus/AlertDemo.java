package com.Toysrus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertDemo<driver> 
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
	public void Alertverify()
	{
	
		String actual_msg=driver.switchTo().alert().getText();
		System.out.println("The actual_message is:" + actual_msg);
		driver.switchTo().alert().accept();
		
		String excepted_msg="We'd welcome your feedback!";
		Assert.assertEquals(actual_msg, excepted_msg);
	}
	
	@AfterClass
	public void tearDown()
	{
		if(driver!=null);
		driver.close();
	}

}
