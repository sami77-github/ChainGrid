package com.tekpyramid.chaingrid.product_inventory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekpyramid.chaingrid.generic_baseclass.AdminBaseClass;
import com.tekpyramid.chaingrid.object_repository.AdminHomePage;
import com.tekpyramid.chaingrid.object_repository.AdminOrdersPage;

public class AdminVerifiesOrdersTest extends AdminBaseClass {

	@Test(groups = "smoke test")
	public void verifyAdminViewsOrders() {
		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getOrdersPageLink().click();
		AdminOrdersPage aop = new AdminOrdersPage(driver);
		List<WebElement> orderIds = aop.getOrderIds();
		boolean flag = true;
		for (WebElement id : orderIds) {
			String text = id.getTagName();
			if (text.equals(null) | text.isEmpty()) {
				flag = false;
				System.out.println(text + " is not verified");
			}
		}
		Assert.assertTrue(flag);
		System.out.println("Yes Admin Verifies Orders");
	}
}
