package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 */
public class Logout 
{
WebDriver driver;
	
	public Logout(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	// To click on close button
	
	@FindBy(xpath="//button[@aria-label=\"close\"]")
	private WebElement closebtn;
	public WebElement getClosebtn() {
		return closebtn;
	}
	
	//To click on logo

	@FindBy(xpath="//*[name()='svg' and @data-icon='user']")
	private WebElement ProfileLogo;
	public WebElement getProfileLogo() {
		return ProfileLogo;
	}

	// to click on logout button

	@FindBy(xpath="//div[@class='dropdown-item logout']")
	private WebElement Lgoutbtn;
	public WebElement getLgoutbtn() {
		return Lgoutbtn;
	}
	
	public void tologout()
	{
	 getClosebtn().click();
	 getProfileLogo().click();
	 getLgoutbtn().click();
		
	}
	
}
