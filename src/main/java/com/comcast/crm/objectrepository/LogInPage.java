package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage 
{
	WebDriver driver;
	
	public LogInPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="username")
	private WebElement UN;

	public WebElement getUN() {
		return UN;
	}
	
	@FindBy(id="inputPassword")
	private WebElement Pwd;

	public WebElement getPwd() {
		return Pwd;
	}
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement btn;

	public WebElement getBtn() {
		return btn;
	}
	
	public void loginApp(String un,String pwd)
	{
		UN.sendKeys(un);
		Pwd.sendKeys(pwd);
		btn.click();
	}
	
	
	
	
}
