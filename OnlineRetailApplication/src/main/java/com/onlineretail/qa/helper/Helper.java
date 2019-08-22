package com.onlineretail.qa.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.onlineretail.qa.constants.Constants;
/**
 * This class is used to load properties file and explicit wait
 * @author Anne.Sivakumar
 *
 */
public class Helper {
	public String PagePath;
	private static Helper helper;
	private Properties prop;
	
	
	//wait up to 10 seconds and check the element is visible/not 
	public boolean explixitWait(WebDriver driver, String xpath) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Constants.WEB_DRIVER_WAIT);
		
		try 
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getValue(xpath))));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(getValue(xpath))));
		} 
		catch (TimeoutException e) 
		{
			return false;
		}
		return true;
	}
	
	//load property file
	public Helper() {
		List<String> propsFiles = Arrays.asList(Constants.PROJECT_CONFIGURATION_PATH,Constants.PROJECT_SEARCHTSHIRT_PRODUCT_PATH,Constants.PROJECT_SELECTMAXI_PRODUCT_PATH);

		prop = new Properties();

		for (String filePath : propsFiles) {
		try {
		prop.load(new FileInputStream(new File(filePath)));
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		}
		}
		}
		
	//singleton class
		 public static Helper getInstance()
		 { 
		 if(helper == null)
			 helper = new Helper();
		 return helper;
		 }

//read value of xpath
		public String getValue(String key) {
			return prop.getProperty(key);
		}

}
