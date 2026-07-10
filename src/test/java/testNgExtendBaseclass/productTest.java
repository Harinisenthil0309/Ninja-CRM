package testNgExtendBaseclass;

import org.testng.annotations.Test;

import com.comcast.crm.generalutilities.ExcelUtility;
import com.comcast.crm.generalutilities.JavaUtility;
import com.comcast.crm.generalutilities.baseClass;
import com.comcast.crm.objectrepository.CreateProductPage;

public class productTest extends baseClass
{
	@Test
	public void createProductPage() throws Throwable
	{
		
				ExcelUtility elib = new ExcelUtility();
				JavaUtility jlib = new JavaUtility();

				// to read ExcelUtility

				int ranNum = jlib.getRandomNumber();

				String prodName = elib.toReadDataFromExcel("Sheet2", 1, 0) + ranNum;
				String prodCat = elib.toReadDataFromExcel("Sheet2", 1, 1);
				String quant = elib.toReadDataFromExcel("Sheet2", 1, 2);
				String vendorsID = elib.toReadDataFromExcel("Sheet2", 1, 3);
				String msg = elib.toReadDataFromExcel("Sheet2", 1, 4);

				// to create obj for productpage
				CreateProductPage cpp = new CreateProductPage(driver);

				cpp.getClickprod().click();
				cpp.getAddproduct().click();
				cpp.getProdName().sendKeys(prodName);
				cpp.getCategory().sendKeys(prodCat);
				cpp.getQuantity().sendKeys(quant);
				cpp.getVenId().sendKeys(vendorsID);
				cpp.getAddbtn().click();
	}
	}

