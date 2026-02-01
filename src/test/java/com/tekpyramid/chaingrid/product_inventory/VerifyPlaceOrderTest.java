package com.tekpyramid.chaingrid.product_inventory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tekpyramid.chaingrid.generic_baseclass.RetailerBaseClass;
import com.tekpyramid.chaingrid.object_repository.MyOrderPage;
import com.tekpyramid.chaingrid.object_repository.OrderItemsPage;
import com.tekpyramid.chaingrid.object_repository.RetailerHomePage;

public class VerifyPlaceOrderTest extends RetailerBaseClass {

	@Test(groups = "smoke test")
	public void verifyRetailerPlaceOrder() {
		MyOrderPage mo = new MyOrderPage(driver);
		RetailerHomePage rhp = new RetailerHomePage(driver);
		OrderItemsPage oip = new OrderItemsPage(driver);
		rhp.getNewOrderLink().click();
		WebElement quantitytextField = oip.getEnterQuantityFiledByName("Butter Puff");
		quantitytextField.sendKeys("10");
		WebElement postOrderBtn = oip.getPostOrderBtn();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", postOrderBtn);

		postOrderBtn.click();

		mo.verifyOrderPlaceTest();
	}
}
