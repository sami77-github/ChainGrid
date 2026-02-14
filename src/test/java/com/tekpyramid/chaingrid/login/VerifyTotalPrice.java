package com.tekpyramid.chaingrid.login;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekpyramid.chaingrid.generic_baseclass.RetailerBaseClass;
import com.tekpyramid.chaingrid.object_repository.RetailerHomePage;

public class VerifyTotalPrice extends RetailerBaseClass {

	@Test
	public void verifyTotalPriceTest() throws InterruptedException {
		RetailerHomePage rhp = new RetailerHomePage(driver);
		rhp.getNewOrderLink().click();
		
		WebElement enterPlatinumQuantity = rhp.getQuantityFieldViaPName("Butter Puff");
		enterPlatinumQuantity.clear();
		enterPlatinumQuantity.sendKeys("10");
		
		WebElement enterGoldQuantity = rhp.getQuantityFieldViaPName("Corn Puff");
		enterGoldQuantity.clear();
		enterGoldQuantity.sendKeys("10");
		
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 2000).perform();
		
		List<WebElement> listOfAllpriceFields = rhp.getAllPriceFields();
		
		double total = 0;
		for (WebElement price : listOfAllpriceFields) {
			String priceText = price.getText().trim();
			if(priceText.isEmpty()) {
				continue;
			}
			double Price = Double.parseDouble(priceText);
			total = total+=Price;
		}
		Thread.sleep(2000);
		WebElement ActualTotalPrice = rhp.getTotalPrice();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(driver -> {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    String value = (String) js.executeScript(
		        "return arguments[0].value;", ActualTotalPrice);
		    return value != null && !value.trim().isEmpty();
		});

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String ActTotalPrice = js.executeScript(
		    "return arguments[0].value;", ActualTotalPrice
		).toString();
        Double ActTotalPrice1 = Double.parseDouble(ActTotalPrice);
        System.out.println(ActTotalPrice1);
        System.out.println(total);
        Assert.assertEquals(ActTotalPrice1, total);
	}
}
