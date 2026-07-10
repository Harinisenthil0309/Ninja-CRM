package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class qspyiframes
{
public static void main(String[]args)
{
	WebDriver driver=new ChromeDriver();
	driver.get("https://demoapps.qspiders.com/ui/frames/multiple?sublist=2");
	driver.manage().window().maximize();
	WebElement ele=driver.findElement(By.xpath(""));
	driver.switchTo().frame(ele);
	driver.findElement(By.id("email")).sendKeys("Harini@12345");
	driver.findElement(By.id("password")).sendKeys("Inirah");
	driver.findElement(By.id("confirm-password")).sendKeys("Inirah");
	driver.findElement(By.id("submitButton")).click();
	driver.close();
	
	
	
	
}
}
