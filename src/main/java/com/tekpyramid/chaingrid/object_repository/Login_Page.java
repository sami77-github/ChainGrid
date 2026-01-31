package com.tekpyramid.chaingrid.object_repository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tekpyramid.chaingrid.generic_utility.ChainGrid_Properties_Utility;

public class Login_Page {

	WebDriver driver;

	public Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()=' * Username or Password is incorrect. ']")
	private WebElement adminLoginErrorMsg;
	

	public WebElement getAdminLoginErrorMsg() {
		return adminLoginErrorMsg;
	}

	public WebElement getRetailerFromDD() {
		return retailerFromDD;
	}

	@FindBy(id = "login:username")
	private WebElement usernameTextField;
	
	@FindBy(id = "login:password")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(id = "login:type")
	private WebElement loginDropdown;
	
	@FindBy(xpath = "//option[text()='Admin']")
	private WebElement adminFromDD;
	
	@FindBy(xpath = "//option[text()='Manufacturer']")
	private WebElement manufFromDD;
	
	@FindBy(xpath = "//option[text()='Retailer']")
	private WebElement retailerFromDD;
	
	public WebElement getRetailerfromDD() {
		return retailerFromDD;
	}

	public WebElement getLoginDropdown() {
		return loginDropdown;
	}

	public WebElement getAdminFromDD() {
		return adminFromDD;
	}
	
	public WebElement getManufFromDD() {
		return manufFromDD;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	/*
	 * Method to login as Admin
	 */
	public void adminLogin() throws IOException {
		ChainGrid_Properties_Utility pu = new ChainGrid_Properties_Utility();
		String adminUsername = pu.getDataFromChainGridProperties("adminUn");
		String adminPassword = pu.getDataFromChainGridProperties("adminPw");
		getUsernameTextField().sendKeys(adminUsername);
		getPasswordTextField().sendKeys(adminPassword);
		Select sel = new Select(getLoginDropdown());
		sel.selectByVisibleText("Admin");
		getLoginButton().click();
	}
	
	/*
	 * Method to login as Manufacturer
	 */
	public void manufacturerLogin() throws IOException {
		ChainGrid_Properties_Utility pu = new ChainGrid_Properties_Utility();
		String manufacturerUsername = pu.getDataFromChainGridProperties("manufacturerUn");
		String manufacturerPassword = pu.getDataFromChainGridProperties("manufacturerPw");
		getUsernameTextField().sendKeys(manufacturerUsername);
		getPasswordTextField().sendKeys(manufacturerPassword);
		Select sel1 = new Select(getLoginDropdown());
		sel1.selectByVisibleText("Manufacturer");
		getLoginButton().click();
	}

	/*
	 * Method to login as Retailer
	 */
	public void retailerLogin() throws IOException {
		ChainGrid_Properties_Utility pu = new ChainGrid_Properties_Utility();
		String retailerUsername = pu.getDataFromChainGridProperties("retailerUn");
		String retailerPassword = pu.getDataFromChainGridProperties("retailerPw");
		getUsernameTextField().sendKeys(retailerUsername);
		getPasswordTextField().sendKeys(retailerPassword);
		Select sel2 = new Select(getLoginDropdown());
		sel2.selectByVisibleText("Retailer");
		getLoginButton().click();
	}
	
	
	

}
