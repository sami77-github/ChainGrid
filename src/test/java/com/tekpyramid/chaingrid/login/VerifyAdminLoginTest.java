package com.tekpyramid.chaingrid.login;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tekpyramid.chaingrid.generic_baseclass.AdminBaseClass;
import com.tekpyramid.chaingrid.object_repository.AdminHomePage;

public class VerifyAdminLoginTest extends AdminBaseClass {

	@Test(groups = "smoke test")
	public void verifyAdminLogin() {
		AdminHomePage ahp = new AdminHomePage(driver);
		WebElement welcomeMsg = ahp.getAdminWelcomeMsg();
		Assert.assertTrue(welcomeMsg.isDisplayed());
	}
}
