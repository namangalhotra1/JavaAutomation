package com.trial.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.trial.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException
	{
		
		
		
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
				
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else
		{
			/* captureScreen(driver, "loginTest"); */
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
		
	}

}
