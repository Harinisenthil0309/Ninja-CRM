package genericUtility;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generalutilities.ExcelUtility;
import com.comcast.crm.generalutilities.JavaUtility;
import com.comcast.crm.generalutilities.PropertiesUtility;
import com.comcast.crm.generalutilities.WebDriverUtility;

public class ContactNinza  
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
		//	String  MobNo1= elib.toReadDataFromExcel("Sheet3", 1, 3) +longNum;
		    
			
			
			
		    
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
			
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//span[.='Create Contact']")).click();
			
			driver.findElement(By.name("organizationName")).sendKeys(orgName);
			driver.findElement(By.name("title")).sendKeys(title);
			driver.findElement(By.name("contactName")).sendKeys(contactNum);
			driver.findElement(By.name("mobile")).sendKeys(longNum + "");
			driver.findElement(By.xpath("//*[name()='svg' and @data-icon='plus']")).click();
			
			String WID=driver.getWindowHandle();
			wlib.switchToChildWindow(driver);
			WebElement we=driver.findElement(By.xpath("//button[@class='select-btn']"));
			we.click();
			wlib.switchToParentWindow(driver, WID);
			
			driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
			Thread.sleep(2000);
			
					
			
		
			//driver.quit();
			
	
			
			
			

			
}
}
