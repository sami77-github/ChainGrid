package com.tekpyramid.chaingrid.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturerHomePage {

	WebDriver driver;
	public ManufacturerHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//section[contains(text(),'Welcome manufacturer')]")
	private WebElement manuWelcomeMsg;
	
	@FindBy(linkText = "Products")
	private WebElement viewProductLink;
	
	@FindBy(linkText = "Manage Stock")
	private WebElement manageStocktLink;
	
	public WebElement getManageStocktLink() {
		return manageStocktLink;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getManuWelcomeMsg() {
		return manuWelcomeMsg;
	}

	public WebElement getViewProductLink() {
		return viewProductLink;
	}

	public WebElement getManWelcomeMsg() {
		return manuWelcomeMsg;
	}
	
	
}
