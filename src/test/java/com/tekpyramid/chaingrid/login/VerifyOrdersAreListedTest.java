package com.tekpyramid.chaingrid.login;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekpyramid.chaingrid.generic_baseclass.AdminBaseClass;
import com.tekpyramid.chaingrid.object_repository.AdminHomePage;
import com.tekpyramid.chaingrid.object_repository.AdminOrdersPage;

public class VerifyOrdersAreListedTest extends AdminBaseClass {

	@Test(groups = "regression")
	public void verifyOrders() {
		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getOrdersPageLink().click();
		AdminOrdersPage aop = new AdminOrdersPage(driver);
		List<WebElement> allOrderIds = aop.getAllOrderIds();
		boolean flag = false;
		for (WebElement orderid : allOrderIds) {
			String text = orderid.getText();
			if(text!=null) {
				flag = true;
				System.out.println(text+" are present");
			}
		}
		Assert.assertTrue(flag);
		System.out.println("orders are present");
	}
}
