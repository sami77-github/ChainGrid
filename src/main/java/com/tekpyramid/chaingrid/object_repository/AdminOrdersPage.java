package com.tekpyramid.chaingrid.object_repository;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AdminOrdersPage {

	WebDriver driver;

	public AdminOrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//table[@class='table_displayData']//tr/td[1]")
	private List<WebElement> orderIds;
	
	@FindBy(id = "cmbFilter")
	private WebElement searchByDropdown1;
	
	@FindBy(xpath = "//option[text()=' Id ']")
	private WebElement selectById;
	
	@FindBy(xpath = "//option[text()=' Retailer ']")
	private WebElement selectByRetailer;
	
	@FindBy(xpath = "//option[text()=' Date ']")
	private WebElement selectByDate;
	
	@FindBy(xpath = "//table[@class='table_displayData']/tbody/tr/td[1]")
	private WebElement verifyOrderId;
	
	public WebElement getVerifyOrderId() {
		return verifyOrderId;
	}

	@FindBy(xpath = "//option[text()=' Status ']")
	private WebElement selectByStatus;
	
	@FindBy(xpath = "//option[text()=' Approval ']")
	private WebElement selectByApproval;
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getEnterIdField() {
		return enterIdField;
	}

	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@id='txtId']")
	private WebElement enterIdField;

	public WebElement getSearchByDropdown1() {
		return searchByDropdown1;
	}

	public WebElement getSelectById() {
		return selectById;
	}

	public WebElement getSelectByRetailer() {
		return selectByRetailer;
	}

	public WebElement getSelectByDate() {
		return selectByDate;
	}

	public WebElement getSelectByStatus() {
		return selectByStatus;
	}

	public WebElement getSelectByApproval() {
		return selectByApproval;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public List<WebElement> getOrderIds() {
		return orderIds;
	}
	
	public void searchOrdersById(String enterId) {
		Select sel = new Select(getSearchByDropdown1());
		sel.selectByVisibleText(selectById.getText());
		getEnterIdField().sendKeys(enterId);
		getSearchBtn().click();
		String orderId = getVerifyOrderId().getText();
		int intOrderId = Integer.parseInt(orderId);
		int intEnterId = Integer.parseInt(enterId);
		Assert.assertEquals(intEnterId, intOrderId);
		System.out.println(intOrderId+" is Verified");
	}
	
}
