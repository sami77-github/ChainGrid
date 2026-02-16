package com.tekpyramid.chaingrid.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUnitPage {

	WebDriver driver;
	public AddUnitPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "unitName")
	private WebElement unitNamefield;
	
	@FindBy(id = "unitDetails")
	private WebElement unitNameDetailsBox;
	
	@FindBy(xpath = "//input[@value='Add Unit']")
	private WebElement addUnitBtn;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUnitNamefield() {
		return unitNamefield;
	}

	public WebElement getUnitNameDetailsBox() {
		return unitNameDetailsBox;
	}

	public WebElement getAddUnitBtn() {
		return addUnitBtn;
	}
	
}
