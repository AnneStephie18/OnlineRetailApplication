package com.onlineretail.qa.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.onlineretail.qa.helper.Helper;
import com.onlineretail.qa.logreports.LogReports;
import com.onlineretail.qa.testbase.Base;
/**
 * This class is used to perform operations such as click, mouse over, get title, verify assert, navigate to, count read more button, count hyper link present 
 * @author Anne.Sivakumar
 *
 */
public class CommonUtilityMethods  {
	LogReports log=new LogReports();
	Base base = new Base();
	Helper helperobject=Helper.getInstance();
	
	//return the title of the page
	public String getTitle(WebDriver driver,String xpath)
	{
		  return driver.findElement(By.xpath(helperobject.getValue(xpath))).getText();
	}
	
	//verify with the actual and expected title is same
	public void verifyAssertTitle(String actual,String expected)
	{
		Assert.assertEquals(actual,helperobject.getValue(expected),"passed");
		log.info("Actual Title of the page:"+actual);
		log.info("ExpectedTitle of the page:"+helperobject.getValue(expected));
	}
	   
 //perform click operation by passing xpath as parameter
public void click(WebDriver driver,String clickxpath)
	{    helperobject.explixitWait(driver,clickxpath);
		 driver.findElement(By.xpath(helperobject.getValue(clickxpath))).click();	
		 
	}
	
//navigate to the previous page
	public void navigateTo(WebDriver driver)
	{
		driver.navigate().to(helperobject.getValue("url"));;
	}
	//select option from dropdown list
	public void selectDropdownMenu(WebDriver driver,String xpath,String optionvalue)
	{
		Select dropdownmenu = new Select(driver.findElement(By.id(helperobject.getValue(xpath))));
		dropdownmenu.selectByVisibleText(helperobject.getValue(optionvalue));
		log.info("selected option: "+helperobject.getValue(optionvalue));
	}
	//perform keyboard function
	public void sendKeys(WebDriver driver,String xpath,String key)
	{
		driver.findElement(By.xpath(helperobject.getValue(xpath))).sendKeys(helperobject.getValue(key));
		driver.findElement(By.xpath(helperobject.getValue(xpath))).sendKeys(Keys.ENTER);
	}
	// find total sum of cost
	public void totalPrice(WebDriver driver,String xpath)
	{
	List<WebElement> totalcost= driver.findElements(By.xpath(helperobject.getValue(xpath)));
	double sumprice=0;
	for(WebElement price:totalcost)
	{
		String total = price.getText().replace("₹", "");
		log.info(total);
		sumprice= sumprice+Double.parseDouble(total);
	}
	log.info("total price: "+sumprice);
	}
}
