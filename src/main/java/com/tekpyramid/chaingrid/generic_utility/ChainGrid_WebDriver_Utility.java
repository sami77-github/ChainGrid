package com.tekpyramid.chaingrid.generic_utility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChainGrid_WebDriver_Utility {

	/*
	 * Implicit Wait
	 */
	WebDriver driver;

	public void implicitWait(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	/*
	 * Explicit Wait
	 */
	public WebElement explicitWaitvisibilityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public WebElement explicitWaitElementToBeClickabe(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
	}
	
	public WebElement explicitWaitAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return (WebElement) wait.until(ExpectedConditions.alertIsPresent());
	}

	/*
	 * Switch the driver control to perticular window by Title
	 */
	public void switchDriverControlByTitle(WebDriver driver, String expTitle) {
		Set<String> ids = driver.getWindowHandles();
		for (String id : ids) {
			String actTitle = driver.switchTo().window(id).getTitle().toString();
			if (actTitle.contains(expTitle)) {
				System.out.println("driver control transfered");
				break;
			}
		}
	}

	

	/*
	 * Switch the driver control to perticular window by Url
	 */
	public void switchDriverControlByUrl(WebDriver driver, String expUrl) {
		Set<String> ids = driver.getWindowHandles();
		for (String id : ids) {
			String actUrl = driver.switchTo().window(id).getCurrentUrl().toString();
			if (actUrl.contains(expUrl)) {
				System.out.println("driver control transfered");
				break;
			}
		}
	}
}


