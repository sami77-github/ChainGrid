package com.tekpyramid.chaingrid.object_repository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageStockPage {

	WebDriver driver;

	public ManageStockPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "btnSubmit")
	private WebElement updateStockBtn;
	
	@FindBy(xpath = "//input[@name='txtQuantity[11]']")
	private WebElement pizzaSouceQuantityfield;

	public WebElement getPizzaSouceQuantityfield() {
		return pizzaSouceQuantityfield;
	}

	@FindBy(xpath = "//input[@value='Log out']")
	private WebElement logoutBtn;
	
	@FindBy(xpath = "//table[@class=\"table_displayData\"]//input")
	private List<WebElement> stockQuantityFields;

	public List<WebElement> getStockQuantityFields() {
		return stockQuantityFields;
	}
	
	public WebElement getVerifyProductStock(String productName) {
		WebElement quantityField = driver.findElement(By.xpath("//td[normalize-space()='"+productName+"']/parent::tr//input[@type='text']"));
		return quantityField;
	}

	public WebElement getFillStockViaName(String productName) {
		WebElement quantity = driver.findElement(By.xpath("//td[normalize-space(text())='"+productName+"']/following-sibling::td//input[@type='text']"));
		return quantity;		
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUpdateStockBtn() {
		return updateStockBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
}
