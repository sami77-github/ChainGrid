package com.tekpyramid.chaingrid.generic_baseclass;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tekpyramid.chaingrid.generic_utility.ChainGrid_Properties_Utility;
import com.tekpyramid.chaingrid.object_repository.AdminHomePage;
import com.tekpyramid.chaingrid.object_repository.Login_Page;

public class AdminBaseClass extends SuperBaseClass {

	
	@BeforeMethod(alwaysRun=true)
	public void loginAsAdmin() throws IOException {
		Login_Page lp = new Login_Page(driver);
		lp.adminLogin();
	}
	
	@AfterMethod(alwaysRun=true)
	public void logoutAsAdmin() throws IOException {
		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getLogOutBtn().click();
	}
}
