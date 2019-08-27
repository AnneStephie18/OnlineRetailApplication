package com.onlineretail.qa.testscripts;

/**
 * This class is used to search and select a product, Select color, size and quantity and then add the product to cart, Verity the total is correct, remove item from cart 
 */
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.onlineretail.qa.pages.SearchedProduct;
import com.onlineretail.qa.testbase.Base;
import com.onlineretail.qa.utils.JiraPolicy;
import com.relevantcodes.extentreports.LogStatus;

public class AutomateSearchedProduct extends Base{
	SearchedProduct searchproductobject=new SearchedProduct();
	/**
	 * open the browser 
	 */
	@BeforeTest
	public void preSetup()
	{
		openBrowser();
	}
	//control transfer to searchItem method
	@ JiraPolicy(logTicketReady = true)
	@Test(retryAnalyzer = com.onlineretail.qa.pages.RetryAnalyzer.class)
	public void searchProduct()
	{
		test = report.startTest("verifySearchedProductTitle", "Checking the functionality");
		searchproductobject.searchItem(driver);
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
