package demo;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.comcast.crm.generalutilities.PropertiesUtility;
import com.comcast.crm.generalutilities.WebDriverUtility;
import com.comcast.crm.objectrepository.LogInPage;
import com.comcast.crm.objectrepository.Logout;

public class baseClassDemo 
{
	
	 public WebDriver driver;
	 public PropertiesUtility plib= new PropertiesUtility();
	 public WebDriverUtility wlib = new WebDriverUtility();
	 
	 @BeforeSuite
	 public void beforeSuite() {
	  System.out.println("Connecting to DataBase");
	 }
	 
	 @BeforeTest
	 public void beforeTest() {
	  System.out.println("Pre Conditions");
	 }
	 
	 @BeforeClass
	 public void beforeClass() throws Throwable
	 {
	  String BROWSER = plib.ToReadDataFromProp("browser");
	  if (BROWSER.equals("edge")) {
	   driver = new EdgeDriver();
	  } else if (BROWSER.equals("chrome")) {
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
	  System.out.println("Browser Launched");
	 }
	 
	 @BeforeMethod
	 public void beforeMethod() throws Throwable {
	  String URL = plib.ToReadDataFromProp("url");
	  String UN = plib.ToReadDataFromProp("un");
	  String PW = plib.ToReadDataFromProp("pw");
	  driver.get(URL);
	  
	  LogInPage lp = new LogInPage(driver);
	  lp.loginApp(UN, PW);
	  System.out.println("Login Done");
	  
	 }
	 
	 @AfterMethod
	 public void afterMethod() throws Throwable{
	  Logout lgout =new Logout(driver);
	  lgout.getLgoutbtn();
	 }
	 
	 @AfterClass
	 public void afterClass() {
	  driver.quit();
	  System.out.println("Closing Browser");
	 }
	 
	 @AfterTest
	 public void afterTest() {
	  Reporter.log("Post Conditions", true);
	 }

	 @AfterSuite
	 public void afterSuite() {
	  Reporter.log("Disconnect DB", true);
	 }
	 

	}


