package com.tekpyramid.chaingrid.login;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekpyramid.chaingrid.generic_baseclass.BaseClass_NegativeTests;
import com.tekpyramid.chaingrid.generic_baseclass.SuperBaseClass;
import com.tekpyramid.chaingrid.generic_utility.ChainGrid_Properties_Utility;
import com.tekpyramid.chaingrid.object_repository.Login_Page;

public class InvalidLoginsTest extends BaseClass_NegativeTests {

	@Test(groups = "regression")
	public void invalidAdminLoginTest() throws IOException {
		ChainGrid_Properties_Utility pu = new ChainGrid_Properties_Utility();
		String wrongPwd = pu.getDataFromChainGridProperties("wrongpw");
		Login_Page lp = new Login_Page(driver);
		lp.getUsernameTextField().sendKeys("admin");
		lp.getPasswordTextField().sendKeys(wrongPwd);
		WebElement loginDD = lp.getLoginDropdown();
		Select sel = new Select(loginDD);
		sel.selectByVisibleText(lp.getAdminFromDD().getText());
		lp.getLoginButton().click();
		WebElement errorMsg = lp.getAdminLoginErrorMsg();
		Assert.assertTrue(errorMsg.isDisplayed());
		System.out.println(errorMsg.getText());

	}

	@Test
	public void invalidManufacturerLoginTest() throws IOException {
		ChainGrid_Properties_Utility pu = new ChainGrid_Properties_Utility();
		String wrongPwd = pu.getDataFromChainGridProperties("wrongpw");
		Login_Page lp = new Login_Page(driver);
		lp.getUsernameTextField().sendKeys("manufacturer");
		lp.getPasswordTextField().sendKeys(wrongPwd);
		WebElement loginDD = lp.getLoginDropdown();
		Select sel = new Select(loginDD);
		sel.selectByVisibleText(lp.getManufFromDD().getText());
		lp.getLoginButton().click();
		WebElement errorMsg = lp.getAdminLoginErrorMsg();
		Assert.assertTrue(errorMsg.isDisplayed());
		System.out.println(errorMsg.getText());

	}

	@Test
	public void invalidRetailerLoginTest() throws IOException {
		ChainGrid_Properties_Utility pu = new ChainGrid_Properties_Utility();
		String wrongPwd = pu.getDataFromChainGridProperties("wrongpw");
		Login_Page lp = new Login_Page(driver);
		lp.getUsernameTextField().sendKeys("retailer");
		lp.getPasswordTextField().sendKeys(wrongPwd);
		WebElement loginDD = lp.getLoginDropdown();
		Select sel = new Select(loginDD);
		sel.selectByVisibleText(lp.getRetailerfromDD().getText());
		lp.getLoginButton().click();
		WebElement errorMsg = lp.getAdminLoginErrorMsg();
		Assert.assertTrue(errorMsg.isDisplayed());
		System.out.println(errorMsg.getText());
	}
}
