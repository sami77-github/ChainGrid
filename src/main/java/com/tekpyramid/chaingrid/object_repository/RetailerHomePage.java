package com.tekpyramid.chaingrid.object_repository;

import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(id = "txtFinalAmount")
	private WebElement totalPrice;
	
	@FindBy(xpath = "//input[@value='Post Order']")
	private WebElement postOrderBtn;
	
	public WebElement getPriceViaProductName(String productName) {
		WebElement price = driver.findElement(By.xpath("//td[normalize-space()='"+productName+"']/parent::tr/td[position()=6]"));
		return price;
	}
	
	public WebElement getPostOrderBtn() {
		return postOrderBtn;
	}

	public void setPostOrderBtn(WebElement postOrderBtn) {
		this.postOrderBtn = postOrderBtn;
	}

	public WebElement getTotalPrice() {
		return totalPrice;
	}

	public WebElement getNewOrderLink() {
		return newOrderLink;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getRetailerWelcomeMsg() {
		return retailerWelcomeMsg;
	}
	
	public WebElement getQuantityFieldViaPName(String productName) {
		WebElement quantityField = driver.findElement(By.xpath("//td[normalize-space()='"+productName+"']/parent::tr//input"));
		return quantityField;
	}
	
	public List<WebElement> getAllPriceFields() {
		List<WebElement> list= driver.findElements(By.xpath("//table[@class='table_mainWrapper']//div"));
		return list;
	}
	
}
