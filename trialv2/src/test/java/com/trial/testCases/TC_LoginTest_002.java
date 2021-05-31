package com.trial.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.trial.pageObjects.LoginPage;
import com.trial.utilities.XLUtils;

public class TC_LoginTest_002 extends BaseClass
{
	
	@Test(dataProvider="LoginData")
	public void LoginDDT(String user,String pwd) throws InterruptedException 
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("username provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();

		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");

		}
		else
		{
			Assert.assertTrue(true);
			logger.info("login successfull");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close the log out alert
			driver.switchTo().defaultContent();
			
		}
		
		
		
	}
	
	public boolean isAlertPresent() //user defined method created to check alert present or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/trial/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int cocount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String [rownum][cocount];
		
		for(int i=1;i<=rownum; i++)
		{
			for(int j=0;j<cocount; j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);// 1 0
			}
		}
		return logindata;
	}
	
}
