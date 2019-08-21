package com.onlineretail.qa.testscripts;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.onlineretail.qa.pages.SelectedProduct;
import com.onlineretail.qa.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(com.onlineretail.qa.pages.ListenerTest.class)	

public class AutomateSelectedProduct extends Base{
	SelectedProduct selectproductobject=new SelectedProduct();
	/**
	 * open the browser 
	 */
	@BeforeTest
	public void preSetup()
	{
		openBrowser();
		
	}
	//control transfer to selectItem method
	@Test
	public void selectProduct()
	{
		test = extent.startTest("verifySelectedProductTitle", "Checking the functionality");
		selectproductobject.selectItem(driver);
		test.log(LogStatus.PASS,"Item added to the cart");
		
	}
	/**
	 * quit the browser 
	 */
	@AfterTest
	public void tearDown()
	{
		quitBrowser();
	}
}
