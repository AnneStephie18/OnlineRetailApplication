package com.onlineretail.qa.testscripts;
/**
 * This class is used to search and select a product, Select color, size and quantity and then add the product to cart, Verity the total is correct, remove item from cart 
 */
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.onlineretail.qa.pages.SearchedProduct;
import com.onlineretail.qa.testbase.Base;

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
	@Test
	public void searchProduct()
	{
		searchproductobject.searchItem(driver);
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
