package com.tekpyramid.chaingrid.object_repository;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.tekpyramid.chaingrid.generic_utility.ChainGrid_WebDriver_Utility;

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
	
	@FindBy(id = "cmbStatus")
	private WebElement searchOrderBy2_DD;
	
	@FindBy(xpath = "//option[normalize-space()='SRKJ (Sarkhej)'][1]")
	private WebElement searchByVisible_SRKJ;
	
	@FindBy(xpath = "//option[text()='VSTR (Vastrapur)'][1]")
	private WebElement searchByVisible_VSTR;
	
	@FindBy(xpath = "//option[text()='MNGR (Maninagar)'][1]")
	private WebElement searchByVisible_MNGR;
	
	@FindBy(xpath = "//option[text()='NRANIP (New Ranip)'][1]")
	private WebElement searchByVisible_NRANIP;
	
	@FindBy(xpath = "//option[text()='VJLP (Vejalpur)'][1]")
	private WebElement searchByVisible_VJLP;
	
	@FindBy(xpath = "//table[@class='table_displayData']/tbody/tr/td[2]")
	private List<WebElement> verifyOrdersField;
	
	@FindBy(xpath = "//option[normalize-space()='Pending']")
	private WebElement searchByStatus_pending;
	
	@FindBy(xpath = "//option[normalize-space()='Completed']")
	private WebElement searchByStatus_completed;
	
	@FindBy(xpath = "//table[@class='table_displayData']/tbody/tr/td[position()=5]")
	private List<WebElement> verifyOrderStatus;
	

	public List<WebElement> getVerifyOrderStatus() {
		return verifyOrderStatus;
	}

	public WebElement getSearchByStatus_pending() {
		return searchByStatus_pending;
	}

	public WebElement getSearchByStatus_completed() {
		return searchByStatus_completed;
	}

	public WebElement getSearchOrderBy2_DD() {
		return searchOrderBy2_DD;
	}

	public WebElement getSearchByVisible_SRKJ() {
		return searchByVisible_SRKJ;
	}

	public WebElement getSearchByVisible_VSTR() {
		return searchByVisible_VSTR;
	}

	public WebElement getSearchByVisible_MNGR() {
		return searchByVisible_MNGR;
	}

	public WebElement getSearchByVisible_NRANIP() {
		return searchByVisible_NRANIP;
	}

	public WebElement getSearchByVisible_VJLP() {
		return searchByVisible_VJLP;
	}

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
	
	public List<WebElement> getVerifyOrdersField() {
		return verifyOrdersField;
	}
	
	public void searchOrdersByIdTest(String enterId) {
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
	
	public void searchOrderByretailerTest(String selectRetailer) {
		Select sel = new Select(getSearchByDropdown1());
		sel.selectByVisibleText(selectByRetailer.getText());
		ChainGrid_WebDriver_Utility wu = new ChainGrid_WebDriver_Utility();
		wu.explicitWaitvisibilityOfElement(driver, searchOrderBy2_DD);
		Select sel2 = new Select(searchOrderBy2_DD);
		sel2.selectByVisibleText(selectRetailer);
		getSearchBtn().click();
		List<WebElement> orderfield = getVerifyOrdersField();
		boolean flag = false;
		String optionsText = "";
		for (WebElement option : orderfield) {
			optionsText = option.getText();
			if(selectRetailer.contains(optionsText)) {
				flag = true;
			}
		}
		Assert.assertTrue(flag);
		System.out.println(optionsText+" is verified");
	}

	public void getSearchOrderByStatus(String status) {
		Select sel = new Select(getSearchByDropdown1());
		sel.selectByVisibleText(selectByStatus.getText());
		ChainGrid_WebDriver_Utility wu = new ChainGrid_WebDriver_Utility();
		wu.explicitWaitvisibilityOfElement(driver, searchOrderBy2_DD);
		Select sel2 = new Select(searchOrderBy2_DD);
		sel2.selectByVisibleText(status);
		getSearchBtn().click();
		List<WebElement> orderStatus = getVerifyOrderStatus();
		boolean flag = false;
		String actOrderstatus = status;
		for (WebElement status1 : orderStatus) {
			String orderStatusText = status1.getText();
			if(orderStatusText.contains(actOrderstatus)) {
				flag = true;
			}
		}
		Assert.assertTrue(flag);
		System.out.println(actOrderstatus+" is verified");
	}
}
