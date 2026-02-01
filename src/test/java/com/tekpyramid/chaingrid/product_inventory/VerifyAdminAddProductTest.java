package com.tekpyramid.chaingrid.product_inventory;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekpyramid.chaingrid.generic_baseclass.AdminBaseClass;
import com.tekpyramid.chaingrid.object_repository.AddProductPage;
import com.tekpyramid.chaingrid.object_repository.AdminHomePage;
import com.tekpyramid.chaingrid.object_repository.ViewProductPage;

public class VerifyAdminAddProductTest extends AdminBaseClass {

	@Test(groups = "smoke")
	public void verifyAdminAddsNewProduct() throws EncryptedDocumentException, IOException {
		boolean flag = false;
		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getAddProductLink().click();
		AddProductPage app = new AddProductPage(driver);

		/*
		 * While Entering the Dropdown values select it from from DOM by inspecting it
		 */
		app.addProduct("Gold", 14500.0, "KG", "Fast Food", "24 carate");
		ahp.getProductsPageLink().click();
		String text = "";
		ViewProductPage vp = new ViewProductPage(driver);
		List<WebElement> allProductNames = vp.getAllProductNames();
		for (WebElement webElement : allProductNames) {
			text = webElement.getText();
			if (text.contains("Gold")) {
				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag);
		System.out.println(text + " is verified");
	}

}
