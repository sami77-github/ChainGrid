import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;


public class DataDrivenTesting_2Test {

	@Test
	public void  maventest() throws IOException, ParseException{
		
		String Browser = System.getProperty("browser");
		String Url = System.getProperty("url");
		String Username = System.getProperty("username");
		String Password = System.getProperty("password");
		
		// this data will be printed in CMD not here
		System.out.println(Browser);
		System.out.println(Url);
		System.out.println(Username);
		System.out.println(Password);
		System.out.println("hello this is sami shaikh");
		
		// JSON
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("c:/Desktop/Data.json"));
		JSONObject map = (JSONObject)obj;
		
		String Browser1 = map.get("browser").toString();
		String Url1 = map.get("url").toString();
		String Username1 = map.get("username").toString();
		String password1 = map.get("password").toString();
		
		System.out.println(Browser1);
		System.out.println(Url1);
		System.out.println(Username1);
		System.out.println(password1);		
	}
	
	// Read data from XML
	@Parameters({"browser","url","username","password"})
	@Test
	public void readXmlData(String browser,String url,String username, String password) {
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
	}
	
	@Test
	public void sampleTest(XmlTest test) {
		String Browser = test.getParameter("browser");
		String Url = test.getParameter("url");
		String Username = test.getParameter("username");
		String Password = test.getParameter("password");
	}
}
