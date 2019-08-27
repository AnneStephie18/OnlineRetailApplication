package com.onlineretail.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.onlineretail.qa.helper.Helper;
import com.onlineretail.qa.logreports.LogReports;
import com.onlineretail.qa.utils.CommonUtilityMethods;
import com.onlineretail.qa.utils.ExcelUtils;
public class SearchedProduct {
	CommonUtilityMethods commonutilityobject=new CommonUtilityMethods();
	Helper helperobject=Helper.getInstance();
	LogReports log=new LogReports();
	SelectedProduct selectproductobject=new SelectedProduct();
	String productitem4maxiexpectedtitle,productitem5maxiexpectedtitle,grandtotalformaxiexpected;
	String productcolor1,productsize1,productcolor2,productsize2;
	
	
	public void searchItem(WebDriver driver)
	{
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		 
		try {
			
			productitem4maxiexpectedtitle=ExcelUtils.getCellData1("sheet1", "product name", 4);
			productitem5maxiexpectedtitle=ExcelUtils.getCellData1("sheet1","product name", 5);
			grandtotalformaxiexpected=ExcelUtils.getCellData1("sheet1", "product total", 3);
			productcolor1=ExcelUtils.getCellData1("sheet1", "product color", 4);
			productsize1=ExcelUtils.getCellData1("sheet1", "product size", 4);
			productcolor2=ExcelUtils.getCellData1("sheet1", "product color", 5);
			productsize2=ExcelUtils.getCellData1("sheet1", "product size", 5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickSearch(driver, "sendkeyvalue1");
		scroll.executeScript("window.scrollBy(0,500)");
		commonutilityobject.click(driver, "product_item4_maxi");
		selectproductobject.verifyTitle(driver, productitem4maxiexpectedtitle);
		addToCart(driver,productcolor1 ,productsize1 , "dropdownmenu_quantity_value1");
		commonutilityobject.navigateTo(driver);
		clickSearch(driver, "sendkeyvalue1");
		scroll.executeScript("window.scrollBy(0,500)");
		commonutilityobject.click(driver, "product_item5_maxi");
		selectproductobject.verifyTitle(driver, productitem5maxiexpectedtitle);
		selectproductobject.addToCart(driver,productcolor2 ,productsize2 , "dropdownmenu_quantity_value2");
		commonutilityobject.navigateTo(driver);
		commonutilityobject.click(driver, "carticon");
		selectproductobject.viewCart(driver,grandtotalformaxiexpected);
		commonutilityobject.click(driver, "remove_item");
		commonutilityobject.navigateTo(driver);
	}
	public void addToCart(WebDriver driver,String dropdowncolorvalue,String dropdownsizevalue,String dropdownquantityvalue)
	{
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		 scroll.executeScript("window.scrollBy(0,500)");
		commonutilityobject.selectDropdownMenu(driver, "dropdownmenu_maxi_color", dropdowncolorvalue);
		commonutilityobject.selectDropdownMenu(driver, "dropdownmenu_maxi_size", dropdownsizevalue);
		
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
	public void clickSearch(WebDriver driver,String keyvalue)
	{
		commonutilityobject.click(driver, "search_button");
		commonutilityobject.sendKeys(driver, "search_box", keyvalue);
	}
}
