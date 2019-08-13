package com.onlineretail.qa.pages;

import org.openqa.selenium.WebDriver;

import com.onlineretail.qa.helper.Helper;
import com.onlineretail.qa.logreports.LogReports;
import com.onlineretail.qa.utils.CommonUtilityMethods;

public class SearchedProduct {
	CommonUtilityMethods commonutilityobject=new CommonUtilityMethods();
	Helper helperobject=Helper.getInstance();
	LogReports log=new LogReports();
	SelectedProduct selectproductobject=new SelectedProduct();
	public void searchItem(WebDriver driver)
	{
		clickSearch(driver, "sendkeyvalue1");
		//commonutilityobject.click(driver, "search_button");
		//commonutilityobject.sendKeys(driver, "search_box", "sendkeyvalue1");
		commonutilityobject.click(driver, "product_item4_maxi");
		selectproductobject.verifyTitle(driver, "product_item4_maxi_expectedtitle");
		addToCart(driver, "dropdownmenu_color_value2", "dropdownmenu_size_value4", "dropdownmenu_quantity_value1");
		commonutilityobject.navigateTo(driver);
		clickSearch(driver, "sendkeyvalue1");
		commonutilityobject.click(driver, "product_item5_maxi");
		selectproductobject.verifyTitle(driver, "product_item5_maxi_expectedtitle");
		selectproductobject.addToCart(driver, "dropdownmenu_color_value1", "dropdownmenu_size_value5", "dropdownmenu_quantity_value2");
		commonutilityobject.navigateTo(driver);
		commonutilityobject.click(driver, "carticon");
		selectproductobject.viewCart(driver);
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
