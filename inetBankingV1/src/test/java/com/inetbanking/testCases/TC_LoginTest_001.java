package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void loginTest() 
	{

		driver.get(baseUrl);
		
		com.inetbanking.pageObjects.LoginPage lp=new LoginPage(driver);
	
		lp.setUserName(username);
		lp.setPassword(password);
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
			
		{
			Assert.assertTrue(true);
			
		}
		else
		{
			/* captureScreen(driver, "loginTest"); */
			Assert.assertTrue(false);
	
		}
		
	}
	
}