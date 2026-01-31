package com.tekpyramid.chaingrid.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {

	WebDriver driver;
	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Add Products")
	private WebElement addProductLink;
	
	@FindBy(linkText = "Add Retailers")
	private WebElement addRetailersLink;
	
	@FindBy(linkText = "Add Manufacturer")
	private WebElement addManufacturerLink;
	
	@FindBy(linkText = "Add Distributor")
	private WebElement addDistributorLink;
	
	@FindBy(linkText = "Manage Unit")
	private WebElement ManageUnitLink;
	
	@FindBy(linkText = "Manage Category")
	private WebElement ManageCategoryLink;
	
	@FindBy(linkText = "Manage Area")
	private WebElement ManageAreaLink;
	
	@FindBy(linkText = "Change Password")
	private WebElement ChangePasswordLink;
	
	@FindBy(linkText = "Home")
	private WebElement HomePageLink;
	
	@FindBy(linkText = "Retailers")
	private WebElement RetailersPageLink;
	
	@FindBy(linkText = "Manufacturers")
	private WebElement ManufacturersPageLink;
	
	@FindBy(linkText = "Distributors")
	private WebElement DistributorsPageLink;
	
	@FindBy(linkText = "Products")
	private WebElement ProductsPageLink;
	
	@FindBy(linkText = "Orders")
	private WebElement OrdersPageLink;
	
	@FindBy(linkText = "Invoice")
	private WebElement InvoicePageLink;
	
	@FindBy(xpath = "//h1[text()='Welcome Admin']")
	private WebElement adminWelcomeMsg;
	
	public WebElement getAdminWelcomeMsg() {
		return adminWelcomeMsg;
	}

	public WebElement getInvoicePageLink() {
		return InvoicePageLink;
	}

	public void setInvoicePageLink(WebElement invoicePageLink) {
		InvoicePageLink = invoicePageLink;
	}

	public WebElement getAddProductLink() {
		return addProductLink;
	}

	public WebElement getAddRetailersLink() {
		return addRetailersLink;
	}

	public WebElement getAddManufacturerLink() {
		return addManufacturerLink;
	}

	public WebElement getAddDistributorLink() {
		return addDistributorLink;
	}

	public WebElement getManageUnitLink() {
		return ManageUnitLink;
	}

	public WebElement getManageCategoryLink() {
		return ManageCategoryLink;
	}

	public WebElement getManageAreaLink() {
		return ManageAreaLink;
	}

	public WebElement getChangePasswordLink() {
		return ChangePasswordLink;
	}

	public WebElement getHomePageLink() {
		return HomePageLink;
	}

	public WebElement getRetailersPageLink() {
		return RetailersPageLink;
	}

	public WebElement getManufacturersPageLink() {
		return ManufacturersPageLink;
	}

	public WebElement getDistributorsPageLink() {
		return DistributorsPageLink;
	}

	public WebElement getProductsPageLink() {
		return ProductsPageLink;
	}

	public WebElement getOrdersPageLink() {
		return OrdersPageLink;
	}

	@FindBy(xpath = "//input[@type='button']")
	private WebElement logOutBtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}
	
	/*
	 * logout from admin method
	 */
	public void logoutFromAdmin() {
		getLogOutBtn().click();
	}
	
	
	
}
