package com.tekpyramid.chaingrid.login;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekpyramid.chaingrid.generic_baseclass.ManufacturerBaseClass;
import com.tekpyramid.chaingrid.object_repository.ManufacturerHomePage;

public class VerifyManufacturerLoginTest extends ManufacturerBaseClass {

	@Test(groups = "smoke test")
	public void verifyManufacturerLogin() {
		ManufacturerHomePage mhp = new ManufacturerHomePage(driver);
		WebElement welcome = mhp.getManWelcomeMsg();
		Assert.assertTrue(welcome.getText().contains("Welcome manufacturer"));
	}
}
