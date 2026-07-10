package practiceTestng;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import com.comcast.crm.generalutilities.ExcelUtility;
import com.comcast.crm.generalutilities.JavaUtility;
import com.comcast.crm.generalutilities.PropertiesUtility;
import com.comcast.crm.generalutilities.WebDriverUtility;
import com.comcast.crm.objectrepository.CreateCampaignPage;
import com.comcast.crm.objectrepository.LogInPage;
import com.comcast.crm.objectrepository.Logout;

public class campaignTestng 
{
	@Test(priority=1)
	public void createCampaign() throws Throwable {
		
		// Creating Object for all the utility

		PropertiesUtility plib = new PropertiesUtility();
		ExcelUtility elib = new ExcelUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		// Read data from properutility

		String Browser = plib.ToReadDataFromProp("browser");
		String Url = plib.ToReadDataFromProp("url");
		String username = plib.ToReadDataFromProp("un");
		String password = plib.ToReadDataFromProp("pw");

		// Read data From excel

		String cmpName = elib.toReadDataFromExcel("Sheet1", 1, 0);
		String TargetSize = elib.toReadDataFromExcel("Sheet1", 1, 1);

		// To lauch Browser

		WebDriver driver = null;
		if (Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (Browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		} else {
			driver = new FirefoxDriver();
		}

		wlib.toMaximize(driver);
		wlib.waitForPageToLoad(driver);

		driver.get(Url);
		
		// creating obj for loginpage
		LogInPage lp = new LogInPage(driver);
		lp.loginApp(username, password);

		// creating obj for campaignpage

		CreateCampaignPage cp = new CreateCampaignPage(driver);

		cp.getCreatecampaign().click();
		cp.cmpMandatory(cmpName, TargetSize);
		Thread.sleep(2000);
		cp.getClickendbtn().click();

		// Creating obj for logout
		Logout log = new Logout(driver);
		log.tologout();
	}
	
@Test(groups="smoke")
	public void createCampaignStatus() throws Throwable
	{
	        // Creating Object for all the utility

			PropertiesUtility plib = new PropertiesUtility();
			ExcelUtility elib = new ExcelUtility();
			JavaUtility jlib = new JavaUtility();
			WebDriverUtility wlib = new WebDriverUtility();

			// Read data from properutility

			String Browser = plib.ToReadDataFromProp("browser");
			String Url = plib.ToReadDataFromProp("url");
			String username = plib.ToReadDataFromProp("un");
			String password = plib.ToReadDataFromProp("pw");

			// Read data From excel

			String campaignName = elib.toReadDataFromExcel("Sheet1", 1, 0);
			String campaignTargetSize = elib.toReadDataFromExcel("Sheet1", 1, 1);
			String campaignstatus =elib.toReadDataFromExcel("Sheet1", 1, 2);

			// To lauch Browser

			WebDriver driver = null;
			if (Browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else if (Browser.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
				Map<String, Object> prefs = new HashMap<>();
				prefs.put("profile.password_manager_leak_detection", false);
				options.setExperimentalOption("prefs", prefs);
				driver = new ChromeDriver(options);
			} else {
				driver = new FirefoxDriver();
			}

			wlib.toMaximize(driver);
			wlib.waitForPageToLoad(driver);

			driver.get(Url);
			
			// creating obj for loginpage
			
			LogInPage lp = new LogInPage(driver);
			lp.loginApp(username, password);

			// creating obj for campaignpage

			CreateCampaignPage cp = new CreateCampaignPage(driver);

			cp.getCreatecampaign().click();
			cp.cmpStatus(campaignName, campaignTargetSize,campaignstatus);
			Thread.sleep(2000);
			cp.getClickendbtn().click();

			// Creating obj for logout
			Logout log = new Logout(driver);
			log.tologout();
		}

@Test(groups="smoke")
public void reateCampaignExpectedDate() throws Throwable
{
	// Creating Object for all the utility

				PropertiesUtility plib = new PropertiesUtility();
				ExcelUtility elib = new ExcelUtility();
				JavaUtility jlib = new JavaUtility();
				WebDriverUtility wlib = new WebDriverUtility();

				// Read data from properutility

				String Browser = plib.ToReadDataFromProp("browser");
				String Url = plib.ToReadDataFromProp("url");
				String username = plib.ToReadDataFromProp("un");
				String password = plib.ToReadDataFromProp("pw");

				// Read data From excel

				String campaignName = elib.toReadDataFromExcel("Sheet1", 1, 0);
				String campaignTargetSize = elib.toReadDataFromExcel("Sheet1", 1, 1);
				String campaignstatus =elib.toReadDataFromExcel("Sheet1", 1, 2);
				
				//read data from java
				
				String campaigndate=jlib.toGetRequiredDate(20);

				// To lauch Browser

				WebDriver driver = null;
				if (Browser.equalsIgnoreCase("edge")) {
					driver = new EdgeDriver();
				} else if (Browser.equalsIgnoreCase("chrome")) {
					ChromeOptions options = new ChromeOptions();
					Map<String, Object> prefs = new HashMap<>();
					prefs.put("profile.password_manager_leak_detection", false);
					options.setExperimentalOption("prefs", prefs);
					driver = new ChromeDriver(options);
				} else {
					driver = new FirefoxDriver();
				}

				wlib.toMaximize(driver);
				wlib.waitForPageToLoad(driver);

				driver.get(Url);
				
				// creating obj for loginpage
				
				LogInPage lp = new LogInPage(driver);
				lp.loginApp(username, password);

				// creating obj for campaignpage

				CreateCampaignPage cp = new CreateCampaignPage(driver);

				cp.getCreatecampaign().click();
				cp.cmpExpectedDate(campaignName, campaignTargetSize,campaignstatus,campaigndate);
				Thread.sleep(2000);
				cp.getClickendbtn().click();

				// Creating obj for logout
				Logout log = new Logout(driver);
				log.tologout();
			}
}
	


