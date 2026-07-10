package DDT;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.comcast.crm.generalutilities.PropertiesUtility;

public class ToReadDataFromExcel 
{
public static void main(String[]args) throws Throwable
{
	
	FileInputStream fis1=new FileInputStream("C:\\Users\\murug\\Documents\\Ninja.xlsx");
	Workbook wrkbk=WorkbookFactory.create(fis1);
	String cmpName=wrkbk.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
	String TargetSize=wrkbk.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
	String cmpstatus=wrkbk.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
	
	System.out.println(cmpName);
	System.out.println(TargetSize);
	System.out.println(cmpstatus);
	
	
	
	wrkbk.close();
}
}
