package genericUtility;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generalutilities.ExcelUtility;
import com.comcast.crm.generalutilities.JavaUtility;
import com.comcast.crm.generalutilities.PropertiesUtility;

public class CampaignNinza
{
	public static void main(String[]args) throws Throwable
	{
		
		
		//Read from properties
		
		PropertiesUtility plib=new PropertiesUtility();
		String Browser=plib.ToReadDataFromProp("browser");
		String URL=plib.ToReadDataFromProp("url");
		String UN=plib.ToReadDataFromProp("un");
		String PW=plib.ToReadDataFromProp("pw");
		
		//read data from excel

		ExcelUtility elib=new ExcelUtility();
		String cmpName =elib.toReadDataFromExcel("Sheet1", 1, 0);
		String TargetSize =elib.toReadDataFromExcel("Sheet1", 1, 1);
		String cmpstatus =elib.toReadDataFromExcel("Sheet1", 1, 2);
		
		//read data from java
		JavaUtility jlib=new JavaUtility();
		String date=jlib.toGetRequiredDate(20);
		
			
		
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
		    
		    driver.manage().window().maximize(); 
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		    
		    driver.get(URL);
		    driver.findElement(By.id("username")).sendKeys(UN);
		    driver.findElement(By.id("inputPassword")).sendKeys(PW);
		    driver.findElement(By.xpath("//button[@type='submit']")).click();
		    
		    driver.findElement(By.xpath("//span[.='Create Campaign']")).click();
		     
		    driver.findElement(By.xpath("//input[@name='campaignName']")).sendKeys(cmpName);
		    driver.findElement(By.xpath("//input[@name='targetSize']")).sendKeys(TargetSize);
		    driver.findElement(By.xpath("//input[@name='campaignStatus']")).sendKeys(cmpstatus);
		   driver.findElement(By.xpath("//input[@name='expectedCloseDate']")).sendKeys(date );
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//button[.='Create Campaign']")).click(); 
		    driver.quit();
		    
		    
	}
}
