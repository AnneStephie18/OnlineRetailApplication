package com.onlineretail.qa.utils;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.onlineretail.qa.constants.Constants;

public class DataProviderClass {
 
	 // This method takes data as input parameters. The attribute dataprovider is mapped to "getData"
	 @Test (dataProvider="getData")
	    // Number of columns should match the number of input parameters
	 public void loginTest(String ProductName, String ProductColor, String ProductSize,String ProductQuantity) throws Exception{
		
	 System.out.println("Product Name is "+ ProductName);
	 System.out.println("Product Color is "+ ProductColor);
	 System.out.println("Product Size is "+ ProductSize);
	 System.out.println("Product Quantity is "+ ProductQuantity);
	
	 }
	 
	 //If the name is not supplied, the data provider’s name automatically defaults to the method’s name. 
	 //A data provider returns an array of objects.
	 @DataProvider(name="getData")
	 public Object[][] getData() throws Exception{
	 //Object [][] data = new Object [rowCount][colCount];
	 Object [][] data = new Object [1][4];
	 ExcelUtils.setExcelFile(Constants.PROJECT_BASE_PATH+"/resources/testdata/TestData.xlsx", "Sheet1");
	 
	 
	 
	 data [0][0] = ExcelUtils.getCellData(1, 0);
	 data [0][1] = ExcelUtils.getCellData(1, 1);
	 data [0][2] = ExcelUtils.getCellData(1, 2);
	 data [0][3] = ExcelUtils.getCellData(1, 3);
	 
	 
	// data[1][0] = ExcelUtils.getCellData(2, 0);
	// data[1][1] = ExcelUtils.getCellData(2, 1);
	 
	 return data;
	 
	 }
	 public List sample() throws Exception
	 {
		 String p=ExcelUtils.getCellData(1, 0);
		 List<String> str=new ArrayList<String>();
		 str.add(p);
		 for(String s:str)
		 {
			 System.out.println(s);
		 }
		return str;
		 
	 }
}
