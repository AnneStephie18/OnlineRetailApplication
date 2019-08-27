package com.onlineretail.qa.utils;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;




//This method is to set the File path and to open the Excel file, Pass Excel Path as Arguments to this method

public static void setExcelFile(String Path) throws Exception {

		try {

			// Open the Excel file

		FileInputStream ExcelFile = new FileInputStream(Path);

		// Access the required test data sheet

		ExcelWBook = new XSSFWorkbook(ExcelFile);

		

		} catch (Exception e){

			throw (e);

		}

}

//This method is to read the test data from the Excel cell, in this we are passing parameters as SheetName, Row number and Column number

public static String getCellData(String SheetName,int RowNum, int ColNum) throws Exception{

		try{
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

			}catch (Exception e){

			return"";

			}
}
@SuppressWarnings("deprecation")
public static String getCellData1(String sheetName, String colName, int rowNum)
{
	
     XSSFRow row = null;
     XSSFCell cell = null;
    try
    {
        int col_Num = -1;
        ExcelWSheet = ExcelWBook.getSheet(sheetName);
        row = ExcelWSheet.getRow(0);
        for(int i = 0; i < row.getLastCellNum(); i++)
        {
            if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                col_Num = i;
        }

        row = ExcelWSheet.getRow(rowNum - 1);
        cell = row.getCell(col_Num);

        if(cell.getCellTypeEnum() == CellType.STRING)
            return cell.getStringCellValue();
        else if(cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA)
        {
            String cellValue = String.valueOf(cell.getNumericCellValue());
            if(HSSFDateUtil.isCellDateFormatted(cell))
            {
                DateFormat df = new SimpleDateFormat("dd/MM/yy");
                Date date = cell.getDateCellValue();
                cellValue = df.format(date);
            }
            return cellValue;
        }else if(cell.getCellTypeEnum() == CellType.BLANK)
            return "";
        else
            return String.valueOf(cell.getBooleanCellValue());
    }
    catch(Exception e)
    {
        e.printStackTrace();
        return "row "+rowNum+" or column "+colName +" does not exist  in Excel";
    }
}


}
