package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class iframes 
{
public static void main(String[]args)
{
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.selenium.dev/selenium/web/iframes.html");
	driver.manage().window().maximize();
	driver.findElement(By.id("email")).sendKeys("Harini");
	driver.findElement(By.id("age")).sendKeys("12");
	driver.findElement(By.id("submitButton")).click();
	
	
	
	
}
}
