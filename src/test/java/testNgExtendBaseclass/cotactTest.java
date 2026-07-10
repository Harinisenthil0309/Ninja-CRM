package testNgExtendBaseclass;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.testng.annotations.Test;

import com.comcast.crm.generalutilities.ExcelUtility;
import com.comcast.crm.generalutilities.JavaUtility;
import com.comcast.crm.generalutilities.baseClass;
import com.comcast.crm.objectrepository.CreateContactsPage;

public class cotactTest extends baseClass
{
	
	@Test
	public void createContactPage() throws Throwable
	{
	
		
	JavaUtility jlib=new JavaUtility();
	ExcelUtility elib=new ExcelUtility();
			    
			    // TO read data from ExcelUtility
			    
			    long longNum=jlib.togetTenDigitRandomNumber();
			    
			    String orgName = elib.toReadDataFromExcel("Sheet3", 1, 0);
				String title = elib.toReadDataFromExcel("Sheet3", 1, 1);
				String contactNum = elib.toReadDataFromExcel("Sheet3", 1, 2);
				
				String  MobNo1= elib.toReadDataFromExcel("Sheet3", 1, 3) +longNum;
			    
			  
	// to create object for contact page
			    CreateContactsPage ccp=new CreateContactsPage(driver);
			    ccp.getContact().click();
			    ccp.getCreatecontact().click();
			    ccp.contactPage(orgName, title, contactNum,MobNo1);
			    
			     
			    ccp.getCmpAddbtn().click();
			    
			    Thread.sleep(1000);
			     
			     String WID=driver.getWindowHandle();
			        wlib.switchToChildWindow(driver);
				    ccp.getSelect().click();
			    	wlib.switchToParentWindow(driver, WID);
			    	ccp.getCreatbtnend().click();		    	
	
	}
	

}

