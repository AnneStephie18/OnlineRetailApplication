package com.onlineretail.qa.testbase;


import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.onlineretail.qa.constants.Constants;
import com.onlineretail.qa.helper.Helper;
import com.onlineretail.qa.logreports.LogReports;
import com.onlineretail.qa.pages.GetScreenShot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
    //helps to generate the logs in test report.
	public ExtentTest test;
	public ITestResult result;
	GetScreenShot getscreenShot=new GetScreenShot();
    /**
     * creation of chrome ,firefox, internet explorer driver 
     */
	public void openBrowser() 
	{ 
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports("extent.html");
		//extent.attachReporter(htmlReporter);
		test = extent.startTest("verifyHomePageTitle", "Checking the Title");
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
		test.log(LogStatus.INFO, "Chrome Browser Launched Successfully");
		driver.get(helperobject.getValue("url"));
		driver.manage().window().maximize();
		test.log(LogStatus.INFO,"Navigated to URL");
		
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
	}

   //close the driver
	public void quitBrowser()  {
    	driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
    	extent.flush();
		driver.quit();
	}

	@AfterMethod
	public void getResult(ITestResult result)
	{

	if(result.getStatus()==ITestResult.SUCCESS)
	{

	getscreenShot.getScreenshot(driver);

	}
	}

}
