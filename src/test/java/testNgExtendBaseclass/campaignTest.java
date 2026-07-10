package testNgExtendBaseclass;

import org.testng.annotations.Test;

import com.comcast.crm.generalutilities.ExcelUtility;
import com.comcast.crm.generalutilities.baseClass;
import com.comcast.crm.objectrepository.CreateCampaignPage;

public class campaignTest extends baseClass
{
	 public ExcelUtility elib=new ExcelUtility();
		@Test
		public void createCampaign() throws Throwable {
			

			// Read data From excel

			String cmpName = elib.toReadDataFromExcel("Sheet1", 1, 0);
			String TargetSize = elib.toReadDataFromExcel("Sheet1", 1, 1);

		   // creating obj for campaignpage

			CreateCampaignPage cp = new CreateCampaignPage(driver);

			cp.getCreatecampaign().click();
			cp.cmpMandatory(cmpName, TargetSize);
			Thread.sleep(2000);
			cp.getClickendbtn().click();
 
		
	}
}

