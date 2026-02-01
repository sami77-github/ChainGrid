package com.tekpyramid.chaingrid.product_inventory;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekpyramid.chaingrid.generic_baseclass.ManufacturerBaseClass;
import com.tekpyramid.chaingrid.generic_utility.ChainGrid_WebDriver_Utility;
import com.tekpyramid.chaingrid.object_repository.ManageStockPage;
import com.tekpyramid.chaingrid.object_repository.ManufacturerHomePage;

public class ManufacturerVerifyAddStockTest extends ManufacturerBaseClass {

	@Test(groups = "smoke test")
	public void verifyAddStock() throws InterruptedException {
		ManufacturerHomePage mhp = new ManufacturerHomePage(driver);
		mhp.getManageStocktLink().click();
		ManageStockPage msp = new ManageStockPage(driver);
		msp.getFillStockViaName("Mass Gainer").clear();
		msp.getFillStockViaName("Mass Gainer").sendKeys("1000");
		WebElement updateStockBtn = msp.getUpdateStockBtn();
		ChainGrid_WebDriver_Utility wu = new ChainGrid_WebDriver_Utility();
		wu.explicitWaitElementToBeClickabe(driver, updateStockBtn);
		updateStockBtn.click();
		driver.switchTo().alert().accept();
		System.out.println("Done");
		
		WebElement quantityField = msp.getVerifyProductStock("Gold");
		String value = quantityField.getDomAttribute("value");
		int value1 = Integer.parseInt(value);
		Assert.assertEquals(value1, 10);
		System.out.println(value+" is Verified");
	}
}
