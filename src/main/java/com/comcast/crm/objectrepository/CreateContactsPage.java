package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactsPage 
{
	WebDriver driver;
	public CreateContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	// to click contact

@FindBy(linkText = "Contacts")
	private WebElement contact;
    public WebElement getContact() {
		return contact;
	}

	// to create contact
    
@FindBy(xpath="//span[.='Create Contact']")
	private WebElement createcontact;
	public WebElement getCreatecontact() {
		return createcontact;
	}
	
	//organization
	
@FindBy(name="organizationName")
private WebElement orgName;
public WebElement getOrgName() {
	return orgName;
}

	// Title
@FindBy(name="title")
private WebElement tit;
public WebElement getTit() {
	return tit;
}

    // contact name
@FindBy(name="contactName")
private WebElement conName;
public WebElement getConName() {
	return conName;
}

//mobile number
@FindBy(name="mobile")
private WebElement mbNo;
  public WebElement getMbNo() {
	return mbNo;
}

//to click campaign add button
@FindBy(xpath="//*[name()='svg' and @data-icon='plus']")
private WebElement cmpAddbtn;
public WebElement getCmpAddbtn() {
	return cmpAddbtn;
}

    // to select the campaign in childtab
@FindBy(xpath="//button[@class='select-btn']")
private WebElement select;
public WebElement getSelect() {
	return select;
}

     // to click on end Create button
@FindBy(xpath="//button[@type=\"submit\"]")
private WebElement creatbtnend;
public WebElement getCreatbtnend() {
	return creatbtnend;
}


 public void contactPage(String organizationName,String Title ,String ContactName , String Mobileno)
 {
	 orgName.sendKeys(organizationName);
	 tit.sendKeys(Title);
	 conName.sendKeys(ContactName);
	 mbNo.sendKeys(Mobileno);
	
	 
}










}

