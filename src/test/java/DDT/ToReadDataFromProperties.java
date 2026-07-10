package DDT;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generalutilities.PropertiesUtility;


public class ToReadDataFromProperties 
{
public static void main(String[]args) throws Throwable
{

	FileInputStream fis=new FileInputStream("C:\\Users\\murug\\ninja.properties.txt");
	Properties pro=new Properties();
	pro.load(fis);
	
	String Browser=pro.getProperty("browser");
	String URL=pro.getProperty("url");
	String UN=pro.getProperty("un");
    String PW=pro.getProperty("pw");
    
    WebDriver driver=null;
    if(Browser.equalsIgnoreCase("chrome"))
    	driver=new ChromeDriver();
    else if(Browser.equalsIgnoreCase("edge"))
    	driver=new EdgeDriver();
    else if(Browser.equalsIgnoreCase("firefox"))
    	driver=new FirefoxDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    
    driver.get(URL);
    driver.findElement(By.id("username")).sendKeys(UN);
    driver.findElement(By.id("inputPassword")).sendKeys(PW);
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(4000);
    driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
    Thread.sleep(2000);
   
    driver.quit();
    
    
  

}
}
