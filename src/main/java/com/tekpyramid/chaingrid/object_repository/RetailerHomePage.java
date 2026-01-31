package com.tekpyramid.chaingrid.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailerHomePage {

	WebDriver driver;
	public RetailerHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//section[contains(text(),'Welcome retailer')]")
	private WebElement retailerWelcomeMsg;
	
	@FindBy(linkText = "New Order")
	private WebElement newOrderLink;
	
	public WebElement getNewOrderLink() {
		return newOrderLink;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getRetailerWelcomeMsg() {
		return retailerWelcomeMsg;
	}
	
	
}
