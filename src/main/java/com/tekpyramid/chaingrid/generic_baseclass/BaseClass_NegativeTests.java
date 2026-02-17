package com.tekpyramid.chaingrid.generic_baseclass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass_NegativeTests extends SuperBaseClass {

	@BeforeMethod
	public void setup() {
	    driver.navigate().refresh();
	    try {
	        driver.switchTo().alert().dismiss();
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}

	@AfterMethod
	public void tearDown() {
	    driver.manage().deleteAllCookies();
	}

}
