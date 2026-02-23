package DemoTests;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.tekpyramid.chaingrid.generic_baseclass.AdminBaseClass;
import com.tekpyramid.chaingrid.generic_baseclass.ManufacturerBaseClass;
import com.tekpyramid.chaingrid.generic_baseclass.RetailerBaseClass;
import com.tekpyramid.chaingrid.generic_utility.ChainGrid_Database_Utility;
import com.tekpyramid.chaingrid.generic_utility.ChainGrid_Excel_Utility;
import com.tekpyramid.chaingrid.generic_utility.ChainGrid_Java_Utility;
import com.tekpyramid.chaingrid.generic_utility.ChainGrid_Properties_Utility;
import com.tekpyramid.chaingrid.generic_utility.ChainGrid_WebDriver_Utility;

public class Test extends RetailerBaseClass {

//	public static void main(String[] args) throws IOException, SQLException {
//		// TODO Auto-generated method stub
//
//		ChainGrid_Properties_Utility pu = new ChainGrid_Properties_Utility();
//		String Browser = pu.getDataFromChainGridProperties("browser");
//		System.out.println(Browser);

		// ChainGrid_Excel_Utility eu = new ChainGrid_Excel_Utility();
		// String data = eu.readDataFromChainGridExcel(1, 1);
		// System.out.println(data);
		// String data1 = eu.printWholeDataOfSingleColoumn(1);
		// String data2= eu.printMultipleDataOfTwoColoumns(1,2);
		// System.out.println(data2);

//		ChainGrid_Java_Utility java = new ChainGrid_Java_Utility();
//		int num = java.generateRandomNum();
//		System.out.println(num);
//		String date = java.generateDate();
//		System.out.println(date);
//		String simpleData = java.generateSimpleDate();
//		System.out.println(simpleData);

	//	ChainGrid_Database_Utility du = new ChainGrid_Database_Utility();
//		ArrayList<String> ls = new ArrayList<>();
//
		// du.connectToDB();
//		ResultSet result = du.executeSelectQuery("select * from project");
//		if (result != null) {
//			while (result.next()) {
//				ls.add(result.getString(1) + " " + result.getString(2) + " " + result.getString(3) + " "
//						+ result.getString(4) + " " + result.getString(5) + " " + result.getString(6));
//				
//			}
//		} else {
//                 System.out.println("ResultSet is null. DB connection/query failed.");
//		}
//		System.out.println(ls);
		
		//du.checkExpDataInDB("select * from project", 1, "NH_PROJ_001");
		
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		ChainGrid_WebDriver_Utility wu = new ChainGrid_WebDriver_Utility();
//		wu.implicitWait(driver);
//		driver.get("https://www.flipkart.com/");
//		driver.findElement(By.name("q")).sendKeys("iphone"+Keys.ENTER);
//		driver.findElement(By.xpath("//div[text()='Apple iPhone 16 (Black, 128 GB)']")).click();
//		wu.switchDriverControlByTitle(driver, "iPhone 16");
		
		
	//}

   @org.testng.annotations.Test
   public void test() {
	   System.out.println("Yes Man you can do it");
	   Assert.assertEquals("sami", "Sami");
   }
}
