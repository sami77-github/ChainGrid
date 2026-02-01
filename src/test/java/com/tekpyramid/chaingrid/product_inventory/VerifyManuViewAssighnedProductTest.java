package com.tekpyramid.chaingrid.product_inventory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekpyramid.chaingrid.generic_baseclass.ManufacturerBaseClass;
import com.tekpyramid.chaingrid.object_repository.ManufacturerHomePage;
import com.tekpyramid.chaingrid.object_repository.ViewProductPage;

public class VerifyManuViewAssighnedProductTest extends ManufacturerBaseClass {

	@Test(groups = "smoke test")
	public void manufacturerVerifyAssignedProduct() {
		ManufacturerHomePage mhp = new ManufacturerHomePage(driver);
		mhp.getViewProductLink().click();
		ViewProductPage vpp = new ViewProductPage(driver);
		List<WebElement> productNames = vpp.getAllProductNames();
		boolean flag = false;
		String product = "";
		for (WebElement webElement : productNames) {
			product = webElement.getText();
			if(product.contains("Gold")) {
				flag = true;
			}
		}
		Assert.assertTrue(flag);
		System.out.println(product+" is Verified");
	}
}
