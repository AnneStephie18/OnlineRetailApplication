package com.onlineretail.qa.pages;
import org.openqa.selenium.JavascriptExecutor;
/**
 * This class is used to Select a product, Select color, size and quantity and then add the product to cart,Verity the total is correct 
 */
import org.openqa.selenium.WebDriver;

import com.onlineretail.qa.helper.Helper;
import com.onlineretail.qa.logreports.LogReports;
import com.onlineretail.qa.utils.CommonUtilityMethods;
import com.onlineretail.qa.utils.ExcelUtils;

public class SelectedProduct {
	CommonUtilityMethods commonutilityobject=new CommonUtilityMethods();
	Helper helperobject=Helper.getInstance();
	LogReports log=new LogReports();
	public String productpagetitle,cartexpectedtitle;
	String productitem3tshirtexpectedtitle,productitem1tshirtexpectedtitle,grandtotalfortshirtexpected;
	String productcolor1,productsize1,productcolor2,productsize2;
	public void selectItem(WebDriver driver)
	{
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		 
		try {
			productitem3tshirtexpectedtitle=ExcelUtils.getCellData1("sheet1", "product name", 2);
			productitem1tshirtexpectedtitle=ExcelUtils.getCellData1("sheet1", "product name", 3);
			grandtotalfortshirtexpected=ExcelUtils.getCellData1("sheet1", "product total", 2);
			productcolor1=ExcelUtils.getCellData1("sheet1", "product color", 2);
			productsize1=ExcelUtils.getCellData1("sheet1", "product size", 2);
			productcolor2=ExcelUtils.getCellData1("sheet1", "product color", 3);
			productsize2=ExcelUtils.getCellData1("sheet1", "product size", 3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scroll.executeScript("window.scrollBy(0,500)");
		commonutilityobject.click(driver, "product_item3_tshirt");
		verifyTitle(driver, productitem3tshirtexpectedtitle);
		addToCart(driver,productcolor1 ,productsize1 , helperobject.getValue("dropdownmenu_quantity_value1"));
		commonutilityobject.navigateTo(driver);//viewCart(driver);
		scroll.executeScript("window.scrollBy(0,500)");
		commonutilityobject.click(driver, "product_item1_tshirt");
		verifyTitle(driver, productitem1tshirtexpectedtitle);
		addToCart(driver,productcolor2 ,productsize2, helperobject.getValue("dropdownmenu_quantity_value2"));
		commonutilityobject.navigateTo(driver);//viewCart(driver);
		commonutilityobject.click(driver, "carticon");
		viewCart(driver,grandtotalfortshirtexpected);
		commonutilityobject.navigateTo(driver);
	}
	public void verifyTitle(WebDriver driver, String expectedtitle)
	{
		productpagetitle=commonutilityobject.getTitle(driver, "actual_page_title");
		commonutilityobject.verifyAssertTitle(productpagetitle, expectedtitle);
	}
	public void addToCart(WebDriver driver,String dropdowncolorvalue,String dropdownsizevalue,String dropdownquantityvalue)
	{
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		 scroll.executeScript("window.scrollBy(0,500)");
		commonutilityobject.selectDropdownMenu(driver, "dropdownmenu_color", dropdowncolorvalue);
		commonutilityobject.selectDropdownMenu(driver, "dropdownmenu_size", dropdownsizevalue);
		
		if(dropdownquantityvalue.equals(1))
		{
			commonutilityobject.click(driver, "quantityicon_plus");
		}
		else
		{
			commonutilityobject.click(driver, "quantityicon_minus");
		}
		commonutilityobject.click(driver, "addtocart_button");
	}
	public void viewCart(WebDriver driver,String expected)
	{
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		try {
			cartexpectedtitle=ExcelUtils.getCellData("sheet1", 5, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    verifyTitle(driver,cartexpectedtitle);
	    scroll.executeScript("window.scrollBy(0,500)");
	    String productItem1Price=commonutilityobject.getTitle(driver, "product1_price");
	    String productItem2Price=commonutilityobject.getTitle(driver, "product2_price");
	    log.info("Name of the product1:"+commonutilityobject.getTitle(driver, "product1_name"));
	    String Item1Price=productItem1Price.replace("₹","0");
	    log.info("Price of the product1:"+Item1Price);
	    log.info("Name of the product2:"+commonutilityobject.getTitle(driver, "product2_name"));
	    String Item2Price=productItem2Price.replace("₹","0");
	    log.info("Price of the product2:"+Item2Price);
	    commonutilityobject.totalPrice(driver, "total_price","grand_total",expected);
	    
	}
	
}
