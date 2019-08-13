package com.onlineretail.qa.testbase;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.onlineretail.qa.constants.Constants;
import com.onlineretail.qa.helper.Helper;
import com.onlineretail.qa.logreports.LogReports;
/**
 * This class is used for creation of driver(Chrome,Firefox,Internt Explorer) and close the driver 
 * @author Anne.Sivakumar
 *
 */
public class Base {
	public WebDriver driver;
	public Properties properties;
	LogReports log=new LogReports();
	Helper helperobject = Helper.getInstance();
	
    
    /**
     * creation of chrome ,firefox, internet explorer driver 
     */
	public void openBrowser() 
	{ 
		if (helperobject.getValue("browser").equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",Constants.PROJECT_CHROMEPATH);
			this.driver  = new ChromeDriver();
			log.info(""+driver);
		} 
		else if (helperobject.getValue("browser").equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",Constants.PROJECT_FIREFOXPATH);
			driver = new FirefoxDriver();
			log.info(""+driver);
		}

		else if (helperobject.getValue("browser").equalsIgnoreCase("internetexplorer")) 
		{
			System.setProperty("webdriver.ie.driver",Constants.PROJECT_INTERNETEXPLORERPATH);
			driver = new InternetExplorerDriver();
			log.info(""+driver);
		}
		driver.get(helperobject.getValue("url"));
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LODE_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
	}

   //close the driver
	public void quitBrowser()  {
    	driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.quit();
	}

}
