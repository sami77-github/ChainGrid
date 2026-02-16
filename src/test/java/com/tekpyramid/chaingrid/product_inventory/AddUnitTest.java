package com.tekpyramid.chaingrid.product_inventory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekpyramid.chaingrid.generic_baseclass.AdminBaseClass;
import com.tekpyramid.chaingrid.object_repository.AddUnitPage;
import com.tekpyramid.chaingrid.object_repository.AdminHomePage;
import com.tekpyramid.chaingrid.object_repository.ViewUnitPage;

public class AddUnitTest extends AdminBaseClass {

	@Test
	public void addUnitTest() {
		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getManageUnitLink().click();
		ViewUnitPage vup = new ViewUnitPage(driver);
		vup.getAddUnitBtn().click();
		AddUnitPage aup = new AddUnitPage(driver);
		aup.getUnitNamefield().sendKeys("dollar");
		aup.getUnitNameDetailsBox().sendKeys("1 dollar = 90 rupees");
		aup.getAddUnitBtn().click();
		driver.switchTo().alert().accept();
		ahp.getManageUnitLink().click();
		List<WebElement> allUnits = vup.getUnitNames();
		boolean flag = false;
		String unitText = "";
		for (WebElement unit : allUnits) {
			unitText = unit.getText();
			if (unitText.contains("dollar")) {
				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag);
		System.out.println(unitText+" is verified");
	}

}
