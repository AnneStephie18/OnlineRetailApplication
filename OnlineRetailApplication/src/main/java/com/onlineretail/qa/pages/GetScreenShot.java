	package com.onlineretail.qa.pages;
	
	import java.io.File;
	import java.io.IOException;
	
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	
	import com.onlineretail.qa.constants.Constants;
	import com.onlineretail.qa.logreports.LogReports;
	
	public class GetScreenShot  {
		 LogReports log=new LogReports();
		
		public  String getScreenshot(WebDriver driver)
		{
		TakesScreenshot ts =(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=Constants.PROJECT_BASE_PATH+"/Screenshots"+"/Screenshot"+System.currentTimeMillis()+".png";
		File destination=new File(path);
		try
		{
	
		FileUtils.copyFile(src, destination);
		log.info("capture success");
		}
		catch(IOException e)
		{
		log.info("capture failed"+e.getMessage());
	
		}
		return path;
		}
	}
