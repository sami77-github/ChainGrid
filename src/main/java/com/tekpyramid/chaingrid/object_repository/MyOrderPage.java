package com.tekpyramid.chaingrid.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MyOrderPage {
	WebDriver driver;

	public MyOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "cmbFilter")
	private WebElement searchOrderByDD;
		
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement searchBtn;
	
	@FindBy(id = "//option[text()=' Id ']")
	private WebElement searchOrderById;
	
	@FindBy(id = "//option[text()=' Date ']")
	private WebElement searchOrderByDate;
	
	@FindBy(id = "//option[text()=' Status ']")
	private WebElement searchOrderByStatus;
	
	@FindBy(xpath = "//table[@class='table_displayData']//td[1]")
	private WebElement orderIdDataToVerify;
	
	public WebElement getOrderIdDataToVerify() {
		return orderIdDataToVerify;
	}

	@FindBy(id = "txtId")
	private WebElement enterIdField;
	
	@FindBy(xpath = "//table[@class='table_displayData']/tbody/tr[last()]/td[1]")
	private WebElement newOrderId;
	
	public WebElement getNewOrderId() {
		return newOrderId;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchOrderByDD() {
		return searchOrderByDD;
	}

	public WebElement getSearchOrderById() {
		return searchOrderById;
	}

	public WebElement getSearchOrderByDate() {
		return searchOrderByDate;
	}

	public WebElement getSearchOrderByStatus() {
		return searchOrderByStatus;
	}
	
	public void verifyOrderPlaceTest() {
		Select sel = new Select(searchOrderByDD);
		sel.selectByContainsVisibleText(" Id ");
		String enterID = getNewOrderId().getText();
		getEnterIdField().sendKeys(enterID);
		getSearchBtn().click();
		String actArderId = getOrderIdDataToVerify().getText();
		int orderId1 = Integer.parseInt(actArderId);
		Assert.assertEquals(Integer.parseInt(enterID), orderId1);
		System.out.println(orderId1+" is Verified");
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getEnterIdField() {
		return enterIdField;
	}
}
