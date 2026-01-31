package com.tekpyramid.chaingrid.object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderItemsPage {

	WebDriver driver;

	public OrderItemsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "btnSubmit")
	private WebElement postOrderBtn;
	
	@FindBy(id = "txtFinalAmount")
	private WebElement finalAmountBtn;
	
	@FindBy(id = "My Orders")
	private WebElement myOrdersLink;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getPostOrderBtn() {
		return postOrderBtn;
	}

	public WebElement getFinalAmountBtn() {
		return finalAmountBtn;
	}

	public WebElement getMyOrdersLink() {
		return myOrdersLink;
	}

	public WebElement getEnterQuantityFiledByName(String productName) {
		WebElement prodQuantityField = driver.findElement(By.xpath("//td[normalize-space()='" + productName + "']/parent::tr//input[@type='text']"));
		return prodQuantityField;
	}
}
