package com.tekpyramid.chaingrid.product_inventory;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekpyramid.chaingrid.generic_baseclass.AdminBaseClass;
import com.tekpyramid.chaingrid.object_repository.AdminHomePage;
import com.tekpyramid.chaingrid.object_repository.ViewProductPage;

public class AdminUpdatesProductTest extends AdminBaseClass {

	@Test(groups = "regression")
	public void updateStockTest() throws InterruptedException {
		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getProductsPageLink().click();
		ViewProductPage vpp = new ViewProductPage(driver);
		Actions action = new Actions(driver);
		action.scrollToElement(vpp.getGoldProduct());
		action.scrollByAmount(0, 500);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement updateImg = vpp.getUpdateProductImg("Metal");
		js.executeScript("arguments[0].scrollIntoView(true);", updateImg);
	    js.executeScript("arguments[0].click();", updateImg);
		updateImg.click();
		String KG = vpp.getSelectByVisible_KG().getText();
		String Add_On_Item = vpp.getSelectByVisible_Add_On_Item().getText();
		vpp.updateProduct("Gold", "1000",KG,Add_On_Item);
		boolean flag = false;
		//driver.navigate().refresh();
		List<WebElement> productNames = vpp.getAllProductNames1();
		String productText = "";
		for (WebElement product : productNames) {
			productText = product.getText();
			if(productText.contains("Gold")) {
				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag);
		System.out.println(productText+" is Verified");
	}
}
