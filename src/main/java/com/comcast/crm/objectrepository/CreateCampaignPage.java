package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage 
{
   WebDriver driver;
public CreateCampaignPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

// to click campaign

@FindBy(xpath="//a[.='Campaigns']")
private WebElement cmp;
public WebElement getCmp()
{
	return cmp;
}

// to create campaign
@FindBy(xpath="//span[.='Create Campaign']")
private WebElement createcampaign;
public WebElement getCreatecampaign() {
	return createcampaign;
}

// campaign Name

@FindBy(name="campaignName")
private WebElement cmpName;
public WebElement getCmpName() {
	return cmpName;
}


//  campaign Status
@FindBy(name="campaignStatus")
private WebElement cmpStatus;
public WebElement getCmpStatus() {
	return cmpStatus;
}

//Target Size
@FindBy(name="targetSize")
private WebElement targetSize;

public WebElement getTargetSize() {
	return targetSize;
}

// Expected Close Date

@FindBy(name="expectedCloseDate")
private WebElement date;
public WebElement getDate() {
	return date;
}


// To submit CampaignDetails

@FindBy(xpath="//button[@type='submit']")
private WebElement clickendbtn;
public WebElement getClickendbtn()
{
	return clickendbtn;
}

public void cmpMandatory(String CampaignName,String TargetSize)
{
	cmpName.sendKeys(CampaignName);
	targetSize.clear();
	targetSize.sendKeys(TargetSize);
}

public void cmpStatus(String CampaignName,String TargetSize,String CampaignStatus)
{
	cmpName.sendKeys(CampaignName);
	targetSize.clear();
	targetSize.sendKeys(TargetSize);
	cmpStatus.sendKeys(CampaignStatus);
}


public void cmpExpectedDate(String CampaignName,String TargetSize,String CampaignStatus,String ExpectedDate)
{
cmpName.sendKeys(CampaignName);
targetSize.clear();
targetSize.sendKeys(TargetSize);
cmpStatus.sendKeys(CampaignStatus);
date.sendKeys(ExpectedDate);

}

}


