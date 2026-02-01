package com.tekpyramid.chaingrid.login;

import org.testng.annotations.Test;

import com.tekpyramid.chaingrid.generic_baseclass.AdminBaseClass;
import com.tekpyramid.chaingrid.object_repository.AdminHomePage;
import com.tekpyramid.chaingrid.object_repository.AdminOrdersPage;

public class SearchByStatusTest extends AdminBaseClass {

	@Test(groups = "smoke test")
	public void searchByStatusTest() {
		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getOrdersPageLink().click();
		AdminOrdersPage aop = new AdminOrdersPage(driver);
		aop.getSearchOrderByStatus("Completed");
	}
}