package com.tekpyramid.chaingrid.object_repository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekpyramid.chaingrid.generic_baseclass.RetailerBaseClass;

public class CreateOrderTest extends RetailerBaseClass {

	@Test
	public void createOrder() {
		RetailerHomePage rhp = new RetailerHomePage(driver);
		rhp.getNewOrderLink().click();
		WebElement enterQuantity = rhp.getQuantityFieldViaPName("Butter Puff");
		enterQuantity.sendKeys("10");
		rhp.getQuantityFieldViaPName("Corn Puff").sendKeys("10");
		rhp.getQuantityFieldViaPName("Pizza Sauce").sendKeys("100");
		String BPuffPrice = rhp.getPriceViaProductName("Butter Puff").getText();
		String CPuffPrice = rhp.getPriceViaProductName("Corn Puff").getText();
		String PizzaSPrice = rhp.getPriceViaProductName("Pizza Sauce").getText();

		Assert.assertTrue(BPuffPrice.contains("1000"));
		Assert.assertTrue(CPuffPrice.contains("200"));
		Assert.assertTrue(PizzaSPrice.contains("12000"));

		System.out.println(BPuffPrice + " is verified");
		System.out.println(CPuffPrice + " is verified");
		System.out.println(PizzaSPrice + " is verified");

		Actions action = new Actions(driver);
		action.scrollByAmount(0, 2000);
		WebElement postOrderBtn = rhp.getPostOrderBtn();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", postOrderBtn);
	}
}
