package com.onlineretail.qa.pages;

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
	public void searchItem(WebDriver driver)
	{
		try {
			productitem4maxiexpectedtitle=ExcelUtils.getCellData("sheet1", 3, 0);
			productitem5maxiexpectedtitle=ExcelUtils.getCellData("sheet1", 4, 0);
			grandtotalformaxiexpected=ExcelUtils.getCellData("sheet1", 2, 4);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickSearch(driver, "sendkeyvalue1");
		//commonutilityobject.click(driver, "search_button");
		//commonutilityobject.sendKeys(driver, "search_box", "sendkeyvalue1");
		commonutilityobject.click(driver, "product_item4_maxi");
		selectproductobject.verifyTitle(driver, productitem4maxiexpectedtitle);
		addToCart(driver, "dropdownmenu_color_value2", "dropdownmenu_size_value4", "dropdownmenu_quantity_value1");
		commonutilityobject.navigateTo(driver);
		clickSearch(driver, "sendkeyvalue1");
		commonutilityobject.click(driver, "product_item5_maxi");
		selectproductobject.verifyTitle(driver, productitem5maxiexpectedtitle);
		selectproductobject.addToCart(driver, "dropdownmenu_color_value1", "dropdownmenu_size_value5", "dropdownmenu_quantity_value2");
		commonutilityobject.navigateTo(driver);
		commonutilityobject.click(driver, "carticon");
		selectproductobject.viewCart(driver,grandtotalformaxiexpected);
		commonutilityobject.click(driver, "remove_item");
		commonutilityobject.navigateTo(driver);
	}
	public void addToCart(WebDriver driver,String dropdowncolorvalue,String dropdownsizevalue,String dropdownquantityvalue)
	{
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
