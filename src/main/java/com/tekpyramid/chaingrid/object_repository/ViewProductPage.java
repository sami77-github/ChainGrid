package com.tekpyramid.chaingrid.object_repository;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tekpyramid.chaingrid.generic_utility.ChainGrid_WebDriver_Utility;

public class ViewProductPage {

	WebDriver driver;
	public ViewProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "product:name")
	private WebElement productNameField;
	
	@FindBy(id = "product:price")
	private WebElement productPriceField;
	
	@FindBy(id = "product:unit")
	private WebElement unitDropDown;
	
	@FindBy(id = "product:category")
	private WebElement categoryDropDown;
	
	@FindBy(id = "product:description")
	private WebElement descriptionBox;
	
	@FindBy(xpath = "//input[@value='Update Product']")
	private WebElement updateProductBtn;

	public WebElement getProductNameField() {
		return productNameField;
	}

	public WebElement getProductPriceField() {
		return productPriceField;
	}

	public WebElement getUnitDropDown() {
		return unitDropDown;
	}

	public WebElement getCategoryDropDown() {
		return categoryDropDown;
	}

	public WebElement getDescriptionBox() {
		return descriptionBox;
	}

	public WebElement getUpdateProductBtn() {
		return updateProductBtn;
	}

	public WebElement getEnableRadioBtn() {
		return EnableRadioBtn;
	}

	public WebElement getDisableRadioBtn() {
		return DisableRadioBtn;
	}

	@FindBy(xpath = "//input[@type='radio' and @value = '1']")
	private WebElement EnableRadioBtn;
	
	@FindBy(xpath = "//input[@type='radio' and @value = '2']")
	private WebElement DisableRadioBtn;
	
    public WebElement getGoldProduct() {
		return GoldProduct;
	}

	@FindBy(xpath = "(//td[text()=' Gold '])[1]")
	private WebElement GoldProduct;

	@FindBy(xpath = "//table[@class='table_displayData']//td[3]")
	private List<WebElement> allProductNames;
	
	@FindBy(xpath = "//option[normalize-space()='KG']")
	private WebElement selectByVisible_KG;
	
	@FindBy(xpath = "//option[normalize-space()='Add On Item']")
	private WebElement selectByVisible_Add_On_Item;
	
	@FindBy(xpath = "//table[@class='table_displayData']//td[position()=3]")
	private List<WebElement> allProductNames1;
	
	public List<WebElement> getAllProductNames1() {
		return allProductNames1;
	}

	public WebElement getSelectByVisible_KG() {
		return selectByVisible_KG;
	}

	public WebElement getSelectByVisible_Add_On_Item() {
		return selectByVisible_Add_On_Item;
	}

	public WebElement getUpdateProductImg(String productName) {
		return driver.findElement(By.xpath("(//td[text()=' "+productName+" '])[1]/parent::tr//a/img"));
	}

	public WebElement getProductCheckBoxViaProductName(String productName) {
		WebElement checkBox = driver.findElement(By.xpath("//td[text()=' " + productName + " ']/parent::tr//input"));
		return checkBox;
	}

	public WebElement getEditProductImgViaProductName(String productName) {
		WebElement checkBox = driver.findElement(By.xpath("// td[text()=' "+productName+" ']/parent::tr//a"));
		return checkBox;
	}
	
	public WebElement getProductQuantityViaName(String productName) {
		WebElement productQuantity = driver.findElement(By.xpath("//td[normalize-space() = '"+productName+"']/parent::tr//td[position()=7]"));
		return productQuantity;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public List<WebElement> getAllProductNames() {
		return allProductNames;
	}
	
	public void updateProduct(String productName, String productPrice, String unit, String category) throws InterruptedException {
		getProductNameField().clear();
		getProductNameField().sendKeys(productName);
		getProductPriceField().clear();
		getProductPriceField().sendKeys(productPrice);
		Select sel = new Select(getUnitDropDown());
		sel.selectByVisibleText(unit);
		Select sel1 = new Select(getCategoryDropDown());
		sel1.selectByVisibleText(category);
		getEnableRadioBtn().click();
		getDescriptionBox().sendKeys("Test");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", getUpdateProductBtn());
	    js.executeScript("arguments[0].click();", getUpdateProductBtn());
	    ChainGrid_WebDriver_Utility wu = new ChainGrid_WebDriver_Utility();
	    wu.explicitWaitAlert(driver);
	    //Thread.sleep(1000);
		driver.switchTo().alert().accept();
	}
}
