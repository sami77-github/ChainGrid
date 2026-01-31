package com.tekpyramid.chaingrid.product_inventory;

import org.testng.annotations.Test;

import com.tekpyramid.chaingrid.generic_baseclass.AdminBaseClass;
import com.tekpyramid.chaingrid.object_repository.AdminHomePage;
import com.tekpyramid.chaingrid.object_repository.AdminOrdersPage;

public class SearchOrdersTest extends AdminBaseClass {

	@Test
	public void searchOrdersByTest() {
		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getOrdersPageLink().click();
		AdminOrdersPage aop = new AdminOrdersPage(driver);
		aop.searchOrdersById("18");
	}
}
