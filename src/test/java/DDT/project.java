package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class project
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
    
    FileInputStream fis1=new FileInputStream("C:\\Users\\murug\\Documents\\Ninja.xlsx");
	Workbook wrkbk=WorkbookFactory.create(fis1);
	String cmpName=wrkbk.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
	String TargetSize=wrkbk.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
	String cmpstatus=wrkbk.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
	String date=wrkbk.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
    
	 WebDriver driver=null;
	    if(Browser.equalsIgnoreCase("chrome"))
	    	driver=new ChromeDriver();
	    else if(Browser.equalsIgnoreCase("edge"))
	    	driver=new EdgeDriver();
	    
	    else if(Browser.equalsIgnoreCase("firefox"))
	    	driver=new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    
	    driver.get(URL);
	    driver.findElement(By.id("username")).sendKeys(UN);
	    driver.findElement(By.id("inputPassword")).sendKeys(PW);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
	    
	    driver.findElement(By.xpath("//input[@name='campaignName']")).sendKeys(cmpName);
	    driver.findElement(By.xpath("//input[@name='targetSize']")).sendKeys(TargetSize);
	    driver.findElement(By.xpath("//input[@name='campaignStatus']")).sendKeys(cmpstatus);
	    driver.findElement(By.xpath("//input[@name='expectedCloseDate']")).sendKeys(date );
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
	    
}
}
