package com.tekpyramid.chaingrid.generic_baseclass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlTest;
import com.tekpyramid.chaingrid.generic_utility.ChainGrid_Properties_Utility;

public class SuperBaseClass
{
	public WebDriver driver=null;
	public static String browser=null;
	ChainGrid_Properties_Utility pu = new ChainGrid_Properties_Utility();
	
	@BeforeSuite (alwaysRun=true)
	public void beforeSuitConfigMethod()
	{
		System.out.println("suit level configuration start");
		System.out.println("database connected");
	}

	@BeforeClass(alwaysRun=true)
	public void beforeClassConfigMethod(XmlTest test) throws IOException
	{
		System.out.println("class level configuration start");
		
		//getting browser either from cmd(jenkins) or suite file or properties file...
		browser=System.getProperty("browser");
		if(browser==null)
		{
			browser=test.getParameter("browser");
			if(browser==null)
			{
				browser=pu.getDataFromChainGridProperties("browser");
			}
		}
		if(browser.equalsIgnoreCase("chrome")){
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")){
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("safari")){
			driver=new SafariDriver();
		}
		UtilityClassObject.setDriver(driver);
		driver=UtilityClassObject.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//getting url either from cmd(jenkins) or suite file or properties file...
		String url=System.getProperty("url");
		if(url==null)
		{
			url=test.getParameter("url");
			if(url==null)
			{
				url=pu.getDataFromChainGridProperties("url");
			}
		}
		driver.get(url);
		System.out.println("browser launched and application opened");
	}
	
	@AfterClass(alwaysRun=true)
	public void afterClassConfigMethod()
	{
		//driver.manage().window().minimize();
		driver.quit();
		UtilityClassObject.removerDriver(); //to remove all the local driver instances from thread local...
		System.out.println("browser closed...");
	}
	@AfterSuite(alwaysRun=true)
	public void afterSuiteConfigMethod()
	{
		System.out.println("databse connection closed...");
	}
}
