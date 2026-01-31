package com.tekpyramid.chaingrid.object_repository;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tekpyramid.chaingrid.generic_utility.ChainGrid_WebDriver_Utility;

public class AddProductPage {

	WebDriver driver;
	public AddProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "product:name")
	private WebElement productNameField;
	
	@FindBy(id = "product:price")
	private WebElement productpriceField;
	
	@FindBy(id = "product:unit")
	private WebElement unitDropdown;
	
	@FindBy(id = "product:category")
	private WebElement categoryDropdown;
	
	@FindBy(xpath = "//input[@value='1']")
	private WebElement enableRadioBtn;
	
	@FindBy(xpath = "//input[@value='2']")
	private WebElement disableRadioBtn;
	
	@FindBy(id = "product:description")
	private WebElement descBox;
	
	@FindBy(xpath = "//input[@value='Add Product']")
	private WebElement addProductBtn;
	
	@FindBy(id = "Products")
	private WebElement viewProductLink;
	
	@FindBy(xpath = "//input[@value='Log out']")
	private WebElement logoutBtn;
	
	@FindBy(xpath = "//option[text()=' KG ']")
	private WebElement selectByVisibleTextUnitDD_KG;
	
	@FindBy(xpath = "//option[text()=' PCS ']")
	private WebElement selectByVisibleTextUnitDD_PCS;
	
	@FindBy(xpath = "//option[text()=' LTR ']")
	private WebElement selectByVisibleTextUnitDD_LTR;
	
	@FindBy(xpath = "//option[text()=' No ']")
	private WebElement selectByVisibleTextUnitDD_No;
	
	@FindBy(xpath = "//option[text()=' Fast Food ']")
	private WebElement selectByVisibleTextCategory_FastFood;
	
	@FindBy(xpath = "//option[text()=' Bread Buns ']")
	private WebElement selectByVisibleTextCategoryDD_BreadBuns;
	
	@FindBy(xpath = "//option[text()=' Counter Cakes ']")
	private WebElement selectByVisibleTextCategoryDD_CounterCakes;
	
	@FindBy(xpath = "//option[text()=' Deserts ']")
	private WebElement selectByVisibleTextCategoryDD_Deserts;
	
	@FindBy(xpath = "//option[text()=' Pastry Rs - 55 ']")
	private WebElement selectByVisibleTextCategoryDD_PastryRs_55;
	
	@FindBy(xpath = "//option[text()=' Pastry Rs - 60 ']")
	private WebElement selectByVisibleTextCategoryDD_PastryRs_60;
	
	@FindBy(xpath = "//option[text()=' Pastry Rs - 65 ']")
	private WebElement selectByVisibleTextCategoryDD_PastryRs_65;
	
	@FindBy(xpath = "//option[text()=' Pastry Rs - 70 ']")
	private WebElement selectByVisibleTextCategoryDD_PastryRs_70;
	
	@FindBy(xpath = "//option[text()=' Add On Items ']")
	private WebElement selectByVisibleTextCategoryDD_AddOnItems;
	
	@FindBy(xpath = "//option[text()=' Cakes ']")
	private WebElement selectByVisibleTextCategoryDD_Cakes;
	
	@FindBy(xpath = "//option[text()=' Cheese Cake ']")
	private WebElement selectByVisibleTextCategoryDD_CheeseCake;
	
	public WebElement getSelectByVisibleTextUnitDD_KG() {
		return selectByVisibleTextUnitDD_KG;
	}

	public WebElement getSelectByVisibleTextUnitDD_PCS() {
		return selectByVisibleTextUnitDD_PCS;
	}

	public WebElement getSelectByVisibleTextUnitDD_LTR() {
		return selectByVisibleTextUnitDD_LTR;
	}

	public WebElement getSelectByVisibleTextUnitDD_No() {
		return selectByVisibleTextUnitDD_No;
	}

	public WebElement getSelectByVisibleTextCategory_FastFood() {
		return selectByVisibleTextCategory_FastFood;
	}

	public WebElement getSelectByVisibleTextCategoryDD_BreadBuns() {
		return selectByVisibleTextCategoryDD_BreadBuns;
	}

	public WebElement getSelectByVisibleTextCategoryDD_CounterCakes() {
		return selectByVisibleTextCategoryDD_CounterCakes;
	}

	public WebElement getSelectByVisibleTextCategoryDD_Deserts() {
		return selectByVisibleTextCategoryDD_Deserts;
	}

	public WebElement getSelectByVisibleTextCategoryDD_PastryRs_55() {
		return selectByVisibleTextCategoryDD_PastryRs_55;
	}

	public WebElement getSelectByVisibleTextCategoryDD_PastryRs_60() {
		return selectByVisibleTextCategoryDD_PastryRs_60;
	}

	public WebElement getSelectByVisibleTextCategoryDD_PastryRs_65() {
		return selectByVisibleTextCategoryDD_PastryRs_65;
	}

	public WebElement getSelectByVisibleTextCategoryDD_PastryRs_70() {
		return selectByVisibleTextCategoryDD_PastryRs_70;
	}

	public WebElement getSelectByVisibleTextCategoryDD_AddOnItems() {
		return selectByVisibleTextCategoryDD_AddOnItems;
	}

	public WebElement getSelectByVisibleTextCategoryDD_Cakes() {
		return selectByVisibleTextCategoryDD_Cakes;
	}

	public WebElement getSelectByVisibleTextCategoryDD_CheeseCake() {
		return selectByVisibleTextCategoryDD_CheeseCake;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProductNameField() {
		return productNameField;
	}

	public WebElement getProductpriceField() {
		return productpriceField;
	}

	public WebElement getUnitDropdown() {
		return unitDropdown;
	}

	public WebElement getCategoryDropdown() {
		return categoryDropdown;
	}

	public WebElement getEnableRadioBtn() {
		return enableRadioBtn;
	}

	public WebElement getDisableRadioBtn() {
		return disableRadioBtn;
	}

	public WebElement getDescBox() {
		return descBox;
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}

	public WebElement getViewProductLink() {
		return viewProductLink;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	public void addProduct(String productName, double price, String unit, String category, String descBox) throws EncryptedDocumentException, IOException {
		getProductNameField().sendKeys(productName);
		getProductpriceField().sendKeys(String.valueOf(price));
		Select sel = new Select(getUnitDropdown());
		sel.selectByVisibleText(unit);
		
		Select sel1 = new Select(categoryDropdown);
		sel1.selectByVisibleText(category);
		
		getEnableRadioBtn().click();
		getDescBox().sendKeys(descBox);
		getAddProductBtn().click();
		ChainGrid_WebDriver_Utility wu = new ChainGrid_WebDriver_Utility();
		wu.explicitWaitAlert(driver);
		driver.switchTo().alert().accept();
	}
	
}
