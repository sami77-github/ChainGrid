package sample_test;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class Demo1_test {

	@Test(priority = 1)
	public void test_1(XmlTest test) {
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
		
		System.out.println(Browser);
		System.out.println(Environment);
		System.out.println(Username);
		System.out.println(Password);
		System.out.println(Id);
		System.out.println(ottoman);
		
		System.out.println("test_1 executed");
	}
	
	@Test(priority = 2)
	public void test_2() {
		System.out.println("test_2 executed");
	}
	
	@Test(priority = 3)
	public void test_3() {
		System.out.println("test_3 executed");
	}
}
