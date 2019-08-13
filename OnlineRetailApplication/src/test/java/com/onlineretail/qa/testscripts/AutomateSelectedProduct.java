package com.onlineretail.qa.testscripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.onlineretail.qa.pages.SelectedProduct;
import com.onlineretail.qa.testbase.Base;

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
		selectproductobject.selectItem(driver);
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
