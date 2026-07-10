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

public class ProductNinza {
	public static void main(String[] args) throws Throwable {
		
		PropertiesUtility plib = new PropertiesUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		
		// to read a propertiesutilty
		String Browser = plib.ToReadDataFromProp("browser");
		String URL = plib.ToReadDataFromProp("url");
		String UN = plib.ToReadDataFromProp("un");
		String PW = plib.ToReadDataFromProp("pw");
		
		int ranNum = jlib.getRandomNumber();

		// to read ExcelUtility
		String prodName = elib.toReadDataFromExcel("Sheet2", 1, 0)+ranNum;
		String prodCat = elib.toReadDataFromExcel("Sheet2", 1, 1);
		String quant = elib.toReadDataFromExcel("Sheet2", 1, 2);
		String vendors = elib.toReadDataFromExcel("Sheet2", 1, 3);

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

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(UN);
		driver.findElement(By.id("inputPassword")).sendKeys(PW);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//span[.='Add Product']")).click();

		driver.findElement(By.name("productName")).sendKeys(prodName);
		driver.findElement(By.name("productCategory")).sendKeys(prodCat);
		driver.findElement(By.name("quantity")).sendKeys(quant);
		driver.findElement(By.name("vendorId")).sendKeys(vendors);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}
}
