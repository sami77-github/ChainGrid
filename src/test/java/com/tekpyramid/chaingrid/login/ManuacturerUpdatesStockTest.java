package com.tekpyramid.chaingrid.login;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekpyramid.chaingrid.generic_baseclass.ManufacturerBaseClass;
import com.tekpyramid.chaingrid.generic_utility.ChainGrid_WebDriver_Utility;
import com.tekpyramid.chaingrid.object_repository.ManageStockPage;
import com.tekpyramid.chaingrid.object_repository.ManufacturerHomePage;
import com.tekpyramid.chaingrid.object_repository.ViewProductPage;

public class ManuacturerUpdatesStockTest extends ManufacturerBaseClass {

	@Test(groups = "regression")
	public void updateStockTest() {
		ManufacturerHomePage mhp = new ManufacturerHomePage(driver);
		mhp.getManageStocktLink().click();
		ManageStockPage msp = new ManageStockPage(driver);
		WebElement dessertQuantityField = msp.getFillStockViaName("MaxicoBurger");
		dessertQuantityField.clear();
		dessertQuantityField.sendKeys("444");
	 	WebElement updateStockBtn = msp.getUpdateStockBtn();
	 	JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", updateStockBtn);
	    ChainGrid_WebDriver_Utility wu = new ChainGrid_WebDriver_Utility();
	    wu.explicitWaitAlert(driver);
		driver.switchTo().alert().accept();
		msp.getProductLink().click();
		ViewProductPage vpp = new ViewProductPage(driver);
		WebElement verifyQuantity = vpp.getProductQuantityViaName("MaxicoBurger");
		String Stock = verifyQuantity.getText();
		Assert.assertTrue(Stock.contains("444"));
		System.out.println(Stock+ " is Verified");
	}
}
