package com.tekpyramid.chaingrid.object_repository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewUnitPage {
	
	WebDriver driver;
	public ViewUnitPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@value='+ Add Unit']")
	private WebElement addUnitBtn;
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteUnitBtn;
	
	@FindBy(xpath = "//table[@class='table_displayData']//td[position()=3]")
	private List<WebElement> unitNames;
	
	public List<WebElement> getUnitNames() {
		return unitNames;
	}

	public WebElement getCheckBoxViaUnit(String enterUnit) {
		WebElement checkBox = driver.findElement(By.xpath("//td[normalize-space()='"+enterUnit+"']/parent::tr/td[position()=1]"));
		return checkBox;	
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAddUnitBtn() {
		return addUnitBtn;
	}

	public WebElement getDeleteUnitBtn() {
		return deleteUnitBtn;
	}
}
