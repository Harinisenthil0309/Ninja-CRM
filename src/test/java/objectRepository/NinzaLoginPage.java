package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generalutilities.PropertiesUtility;
import com.comcast.crm.generalutilities.WebDriverUtility;
import com.comcast.crm.objectrepository.LogInPage;


public class NinzaLoginPage

{
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		LogInPage log = new LogInPage(driver); 
		WebDriverUtility wlib = new WebDriverUtility();
		PropertiesUtility plip = new PropertiesUtility();
		
		String username = plip.ToReadDataFromProp("un");
		String password = plip.ToReadDataFromProp("pw");

		wlib.toMaximize(driver); // Maximizing the Browser
		wlib.waitForPageToLoad(driver); // Implicit Wait

		driver.get("http://49.249.28.218:8098/");

		log.loginApp(username, password);

	}
}
