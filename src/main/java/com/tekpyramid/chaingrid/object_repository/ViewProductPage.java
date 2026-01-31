package com.tekpyramid.chaingrid.object_repository;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewProductPage {

	WebDriver driver;
	public ViewProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//table[@class='table_displayData']//td[3]")
	private List<WebElement> allProductNames;

	public WebElement getProductCheckBoxViaProductName(String productName) {
		WebElement checkBox = driver.findElement(By.xpath("//td[text()=' " + productName + " ']/parent::tr//input"));
		return checkBox;
	}

	public WebElement getEditProductImgViaProductName(String productName) {
		WebElement checkBox = driver.findElement(By.xpath("// td[text()=' "+productName+" ']/parent::tr//a"));
		return checkBox;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public List<WebElement> getAllProductNames() {
		return allProductNames;
	}
}
