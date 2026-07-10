package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage 
{

	WebDriver driver;
	public CreateProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}


	//to click product

	@FindBy(xpath="//a[.='Products']")
	private WebElement clickprod;
	public WebElement getClickprod() {
		return clickprod;
	}
	



	//to  Add  product
	@FindBy(xpath="//span[.='Add Product']")
	private WebElement Addproduct;
	public WebElement getAddproduct() {
		return Addproduct;
	}

	// to get product name tf
	@FindBy(name="productName")
	private WebElement prodName;
	public WebElement getProdName() {
		return prodName;
	}

	// to select category dropdown

	@FindBy(name="productCategory")
	private WebElement category;
	public WebElement getCategory() {
		return category;
	}

	// to select the quantity

	@FindBy(name="quantity")
	private WebElement Quantity;
	public WebElement getQuantity() {
		return Quantity;
	}

	// to select vendorid

	@FindBy(name="vendorId")
	private WebElement venId;
	public WebElement getVenId() {
		return venId;
	}

	// to click an add button

	@FindBy(xpath="//button[@type='submit']")
	private WebElement addbtn;
	public WebElement getAddbtn()
	{
		return addbtn;
	}
	
	public void productpage(String ProductName , String Category , String quantity,String vendorsId , String message)
	{
		prodName.sendKeys(ProductName);
		category.sendKeys(Category);
		Quantity.sendKeys(quantity);
		venId.sendKeys(vendorsId);
		
		
	}



}
