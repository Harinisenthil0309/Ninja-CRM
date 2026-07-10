package objectRepository;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generalutilities.ExcelUtility;
import com.comcast.crm.generalutilities.JavaUtility;
import com.comcast.crm.generalutilities.PropertiesUtility;
import com.comcast.crm.generalutilities.WebDriverUtility;
import com.comcast.crm.objectrepository.CreateContactsPage;
import com.comcast.crm.objectrepository.LogInPage;

public class NinzaContactPage
{
	public static void main(String[] args) throws Throwable
	{
	PropertiesUtility plib = new PropertiesUtility();
	ExcelUtility elib = new ExcelUtility();
	JavaUtility jlib = new JavaUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	
	// To read data from PropertyUtility
	
			String Browser=plib.ToReadDataFromProp("browser");
			String URL=plib.ToReadDataFromProp("url");
	        String UN=plib.ToReadDataFromProp("un");
		    String PW=plib.ToReadDataFromProp("pw");
		    
		    // TO read data from ExcelUtility
		    
		    long longNum=jlib.togetTenDigitRandomNumber();
		    
		    String orgName = elib.toReadDataFromExcel("Sheet3", 1, 0);
			String title = elib.toReadDataFromExcel("Sheet3", 1, 1);
			String contactNum = elib.toReadDataFromExcel("Sheet3", 1, 2);
			
			String  MobNo1= elib.toReadDataFromExcel("Sheet3", 1, 3) +longNum;
		    
			
			    WebDriver driver=null;
		    if(Browser.equalsIgnoreCase("edge")) {
		    	driver=new EdgeDriver();
		    }else if(Browser.equalsIgnoreCase("chrome"))
		    {
		    	ChromeOptions options=new ChromeOptions();
			    Map<String,Object> prefs=new HashMap<>();
			    prefs.put("profile.password_manager_leak_detection",false);
			    options.setExperimentalOption("prefs",prefs);
			    driver=new ChromeDriver(options);
		    }
		    	 else {
		    	driver=new FirefoxDriver();
		    	 }
		    
		    wlib.toMaximize(driver);
		    wlib.waitForPageToLoad(driver);
		    driver.get(URL);
		    
		 // creating obj for loginpage
		    
		    LogInPage lp=new LogInPage(driver);
		    lp.loginApp(UN,PW);
		  
		 // to create object for contact page
		    CreateContactsPage ccp=new CreateContactsPage(driver);
		    ccp.getContact().click();
		    ccp.getCreatecontact().click();
		     ccp.contactPage(orgName, title, contactNum,MobNo1);
		     Thread.sleep(1000);
		     ccp.getCmpAddbtn().click();
		     Thread.sleep(1000);
		     
		     String WID=driver.getWindowHandle();
		     Thread.sleep(1000);
		     
			wlib.switchToChildWindow(driver);
			  Thread.sleep(1000);
			ccp.getSelect().click();
			  Thread.sleep(1000);
			  
			wlib.switchToParentWindow(driver, WID);
			driver.quit();
		 
		    
}
}
