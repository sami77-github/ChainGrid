package DemoTests;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.mysql.cj.jdbc.Driver;


public class DataDrivenTesting_2Test {

//	@Test
//	public void  maventest() throws IOException, ParseException{
	
	/* 1.For for the selected classes
	 * mvn -Dtest=className1,className2 test -Dbrowser=chrome -Durl=https://www.amazon.com 
	 * -Dusername=admin -Dpassword=admin123.
	 * 
	 * For All the classes
	 * mvn test -Dbrowser=chrome -Durl=https://www.amazon.com 
	 * -Dusername=admin -Dpassword=admin123.
	 * 
	 * 
	 */
//		
//		String Browser = System.getProperty("browser");
//		String Url = System.getProperty("url");
//		String Username = System.getProperty("username");
//		String Password = System.getProperty("password");
//		
//		// this data will be printed in CMD not here
//		System.out.println(Browser);
//		System.out.println(Url);
//		System.out.println(Username);
//		System.out.println(Password);
//		System.out.println("hello this is sami shaikh");
//		
//		// JSON
//		JSONParser parser = new JSONParser();
//		Object obj = parser.parse(new FileReader("c:/Desktop/Data.json"));
//		JSONObject map = (JSONObject)obj;
//		
//		String Browser1 = map.get("browser").toString();
//		String Url1 = map.get("url").toString();
//		String Username1 = map.get("username").toString();
//		String password1 = map.get("password").toString();
//		
//		System.out.println(Browser1);
//		System.out.println(Url1);
//		System.out.println(Username1);
//		System.out.println(password1);		
//	}
//	
//	// Read data from XML
//	@Parameters({"browser","url","username","password"})
//	@Test
//	public void readXmlData(String browser,String url,String username, String password) {
//		System.out.println(browser);
//		System.out.println(url);
//		System.out.println(username);
//		System.out.println(password);
//	}
	
	@Test
	public void testing(XmlTest test) {
		String takeBrowser = test.getParameter("browser");
		String takeUrl = test.getParameter("url");
		String takeUsername = test.getParameter("username");
		String takePassword = test.getParameter("password");
		
		System.out.println(takeBrowser);
		System.out.println(takeUrl);
		System.out.println(takeUsername);
		System.out.println(takePassword);
	}
	
	@Test
	public void JDBC() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm", "root@%", "root");
		Statement state = conn.createStatement();
		ResultSet result = state.executeQuery("select * from project");
		 while(result.next()) {
    		 System.out.print(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getString(6));
		 }
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr = new Object[3][2];
		objArr[0][0] = "sami";
		objArr[0][1] = "shaikh";
		
		objArr[1][0] = "samiuddin";
		objArr[1][1] = "Shaikh";
		
		objArr[2][0] = "Qspiders";
		objArr[2][1] = "tekpyramid";
		
		return objArr;
	}
	
	@Test(dataProvider = "getData")
	public void test3(String name, String sirname) {
		System.out.println(name+" "+sirname);
	}
	
}
