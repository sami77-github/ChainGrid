package com.tekpyramid.chaingrid.login;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekpyramid.chaingrid.object_repository.Login_Page;

public class InvalidAdminLoginTest {

	@Test(groups = "smoke")
	public void verifyInvalidAdminloginTest() throws IOException {
	/*
	 * verify the error message by entering invalid credentials
	 */
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		FileInputStream fis = new FileInputStream("./TestData/InvalidData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String Url = prop.getProperty("url");
		String Username = prop.getProperty("username");
		String Password = prop.getProperty("password");
		
		driver.get(Url);
		Login_Page lp = new Login_Page(driver);
		lp.getUsernameTextField().sendKeys(Username);
		lp.getPasswordTextField().sendKeys(Password);
		Select sel = new Select(lp.getLoginDropdown());
		sel.selectByVisibleText("Admin");
		lp.getLoginButton().click();
		WebElement error = lp.getAdminLoginErrorMsg();
		Assert.assertTrue(error.getText().contains("Password is incorrect."));
		System.out.println("* Username or Password is incorrect.");
		driver.quit();
		
	}
}
