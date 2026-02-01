package com.tekpyramid.chaingrid.generic_baseclass;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tekpyramid.chaingrid.object_repository.AdminHomePage;
import com.tekpyramid.chaingrid.object_repository.Login_Page;

public class RetailerBaseClass extends SuperBaseClass{

	
	@BeforeMethod(alwaysRun=true)
	public void loginAsRetailer() throws IOException {
		Login_Page lp = new Login_Page(driver);
		lp.retailerLogin();
	}
	
	@AfterMethod(alwaysRun=true)
	public void logoutAsRetailer() throws IOException {
		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.logoutFromAdmin();
	}
}
