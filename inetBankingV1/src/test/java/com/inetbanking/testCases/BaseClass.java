package com.inetbanking.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public String baseUrl="http://demo.guru99.com/v4/index.php";
	public String username="mngr330428";
	public String password="tasyvuh";
	public static WebDriver driver;

	@BeforeClass
	public void setup(String br)
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver=new ChromeDriver();
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
