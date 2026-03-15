package sample_test;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class Demo4_test {

	@Test
	public void test_9(XmlTest test) {
		String Browser = System.getProperty("browser");
		if(Browser==null) {
			Browser = test.getParameter("browser");
		}
		
		String Environment = System.getProperty("environment");
		if(Environment==null) {
			Environment = test.getParameter("environment");
		}
		
		String Username = System.getProperty("username");
		if(Username==null) {
			Username = test.getParameter("username");
		}
		
		String Password = System.getProperty("password");
		if(Password==null) {
			Password = test.getParameter("password");
		}
		
		String Id = System.getProperty("id");
		if(Id==null) {
			Id = test.getParameter("id");
		}
		
		String ottoman = System.getProperty("ottoman");
		if(ottoman==null) {
			ottoman = test.getParameter("ottoman");	
		}
		
		System.out.println(Browser+" from Demo4");
		System.out.println(Environment+" from Demo4");
		System.out.println(Username+" from Demo4");
		System.out.println(Password+" from Demo4");
		System.out.println(Id+" from Demo4");
		System.out.println(ottoman+" from Demo4");
	}
}
