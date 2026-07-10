package com.comcast.crm.generalutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
public String toReadDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable, Throwable
{
	FileInputStream fis=new FileInputStream("C:\\Users\\murug\\Documents\\Ninja.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	String data=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	wb.close();
	return data;
	
}
public int togetRowCount(String sheetName) throws Throwable
{
	FileInputStream fis=new FileInputStream("");
	Workbook wb=WorkbookFactory.create(fis);
	int rowCount=wb.getSheet(sheetName).getLastRowNum();
	wb.close();
	return rowCount;
		
}
}
