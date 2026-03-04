import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.xml.XmlTest;

import com.mysql.jdbc.Driver;

public class SampleScript {

	public static void main(String[] args) throws IOException, ParseException, SQLException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://49.249.28.218:8081/AppServer/Supply_Chain_Management/manufacturer/index.php");

		driver.findElement(By.id("login:username")).sendKeys("manufacturer");
		driver.findElement(By.id("login:password")).sendKeys("manufacturer123");

		WebElement dropDown = driver.findElement(By.id("login:type"));
		Select sel = new Select(dropDown);
		sel.selectByVisibleText("Manufacturer");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		/*
		 * FileInputStream fis = new FileInputStream(""); Properties prop = new
		 * Properties(); prop.load(fis); String Browser = prop.getProperty("browser");
		 * String Url = prop.getProperty("url");
		 */

		/*
		 * FileInputStream fis = new FileInputStream(""); Workbook wb =
		 * WorkbookFactory.create(fis); String data =
		 * wb.getSheet("Sheet1").getRow(0).getCell(0).toString();
		 */

		// mvn -Dtest=className test -Dbrowser=chrome -Durl=http -Dusername=admin
		// -Dpassword=admin123

		// String Browser = System.getProperty("browser");
		// String Url = System.getProperty("url");

		/*
		 * <parameter name="browser" value="chrome"/> <parameter name="url"
		 * value="http"/>
		 * 
		 * public void sampleTest(XmlTest test1) { String Browser =
		 * test1.getParameter("browser").toString(); }
		 */

		/*
		 * JSONParser parser = new JSONParser(); Object obj = parser.parse(new
		 * FileReader("")); JSONObject map = (JSONObject)obj; Object Browser =
		 * map.get("browser");
		 */
		
		/*
		 * Driver driver1 = new Driver();
		DriverManager.registerDriver(driver1);
		Connection conn = DriverManager.getConnection(null, null, null);
	    Statement state = conn.createStatement();
	    ResultSet result = state.executeQuery("select Query");
	    
	    while(result.next()) {
	    	
	    }
		 */
		
		
		
		

	}
}
