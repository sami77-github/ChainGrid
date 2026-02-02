package com.tekpyramid.chaingrid.product_inventory;

import java.io.IOException;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekpyramid.chaingrid.generic_baseclass.ManufacturerBaseClass;
import com.tekpyramid.chaingrid.generic_utility.ChainGrid_Properties_Utility;
import com.tekpyramid.chaingrid.generic_utility.ChainGrid_WebDriver_Utility;
import com.tekpyramid.chaingrid.object_repository.ManageStockPage;
import com.tekpyramid.chaingrid.object_repository.ManufacturerHomePage;

public class ManufacturerVerifyAddStockTest extends ManufacturerBaseClass {

	@Test(groups = "smoke")
	public void verifyAddStock() throws InterruptedException, IOException {
		ManufacturerHomePage mhp = new ManufacturerHomePage(driver);
		ChainGrid_Properties_Utility pu = new ChainGrid_Properties_Utility();
		String ten = pu.getDataFromChainGridProperties("stock_1");
		mhp.getManageStocktLink().click();
		ManageStockPage msp = new ManageStockPage(driver);
		msp.getFillStockViaName("Pizza Sauce").clear();
		msp.getFillStockViaName("Pizza Sauce").sendKeys(ten);
		WebElement updateStockBtn = msp.getUpdateStockBtn();
		ChainGrid_WebDriver_Utility wu = new ChainGrid_WebDriver_Utility();
		wu.explicitWaitElementToBeClickabe(driver, updateStockBtn);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", updateStockBtn);
		js.executeScript("arguments[0].click();", updateStockBtn);

		wu.explicitWaitAlert(driver);
		driver.switchTo().alert().accept();
		int intTen = Integer.parseInt(ten);
		String attributeValue = msp.getPizzaSouceQuantityfield().getDomAttribute("value");
		int intValue = Integer.parseInt(attributeValue);
		Assert.assertEquals(intValue, intTen);
		System.out.println(attributeValue+" stock is getting successfully Added & Verified");

		
		WebElement quantityField = msp.getVerifyProductStock("Gold");
		String value = quantityField.getDomAttribute("value");
		int value1 = Integer.parseInt(value);
		Assert.assertEquals(value1, 0);
		System.out.println(value+" is Verified");
	}
}
