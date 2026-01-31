package com.tekpyramid.chaingrid.login;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekpyramid.chaingrid.generic_baseclass.RetailerBaseClass;
import com.tekpyramid.chaingrid.object_repository.RetailerHomePage;

public class VerifyRetailerLoginTest extends RetailerBaseClass{

	@Test(groups = "smoke test")
	public void verifyLoginTest() {
		RetailerHomePage rhp = new RetailerHomePage(driver);
		WebElement welcomeMsg = rhp.getRetailerWelcomeMsg();
		Assert.assertTrue(welcomeMsg.getText().contains("Welcome retailer"));
	}
}
