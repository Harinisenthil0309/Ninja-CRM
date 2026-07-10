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
import com.comcast.crm.objectrepository.CreateProductPage;
import com.comcast.crm.objectrepository.LogInPage;
import com.comcast.crm.objectrepository.Logout;

public class productTestng
{
@Test(groups="smoke")
public void createProductPage() throws Throwable
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

			// to read ExcelUtility

			int ranNum = jlib.getRandomNumber();

			String prodName = elib.toReadDataFromExcel("Sheet2", 1, 0) + ranNum;
			String prodCat = elib.toReadDataFromExcel("Sheet2", 1, 1);
			String quant = elib.toReadDataFromExcel("Sheet2", 1, 2);
			String vendorsID = elib.toReadDataFromExcel("Sheet2", 1, 3);
			String msg = elib.toReadDataFromExcel("Sheet2", 1, 4);

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
			// maximize

			wlib.toMaximize(driver);
			wlib.waitForPageToLoad(driver);

			driver.get(Url);

			// creating obj for loginpage
			LogInPage lp = new LogInPage(driver);

			lp.loginApp(username, password);

			// to create obj for productpage
			CreateProductPage cpp = new CreateProductPage(driver);

			cpp.getClickprod().click();
			cpp.getAddproduct().click();
			cpp.getProdName().sendKeys(prodName);
			cpp.getCategory().sendKeys(prodCat);
			cpp.getQuantity().sendKeys(quant);
			cpp.getVenId().sendKeys(vendorsID);
			cpp.getAddbtn().click();
			

			// To create obj for logout
			
			Logout log = new Logout(driver);
			log.tologout();
			driver.quit();
		}
}

