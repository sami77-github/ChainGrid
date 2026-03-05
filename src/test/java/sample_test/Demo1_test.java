package sample_test;

import org.testng.annotations.Test;

public class Demo1_test {

	@Test(priority = 1)
	public void test_1() {
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
