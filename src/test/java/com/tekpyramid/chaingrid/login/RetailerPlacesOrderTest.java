package com.tekpyramid.chaingrid.login;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tekpyramid.chaingrid.generic_baseclass.RetailerBaseClass;
import com.tekpyramid.chaingrid.object_repository.InterviewManuHomePage;
import com.tekpyramid.chaingrid.object_repository.OrderItemsPage;
import com.tekpyramid.chaingrid.object_repository.RetailerHomePage;

public class RetailerPlacesOrderTest extends RetailerBaseClass {

	@Test(groups = "smoke")
	public void retailersOrderTest() {
		RetailerHomePage rhp = new RetailerHomePage(driver);
		rhp.getNewOrderLink().click();
		OrderItemsPage oip = new OrderItemsPage(driver);
		oip.getEnterQuantityFiledByName("Corn Puff").sendKeys("5");
		oip.getEnterQuantityFiledByName("Pizza Sauce").sendKeys("5");
		WebElement postOrderBtn = oip.getPostOrderBtn();
		
		InterviewManuHomePage imhp = new InterviewManuHomePage(driver);
		WebElement welcomeManu = imhp.getManuWelcomeMsg();
		System.out.println(welcomeManu.toString());
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", postOrderBtn);
		js.executeScript("arguments[0].click();", postOrderBtn);
		
	}
}
