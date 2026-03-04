package com.tekpyramid.chaingrid.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InterviewManuHomePage {

	WebDriver driver;
	public InterviewManuHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//section[contains(text(),'Welcome manufacturer')]")
	private WebElement manuWelcomeMsg;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getManuWelcomeMsg() {
		return manuWelcomeMsg;
	}
}
