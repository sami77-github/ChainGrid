package sample_test;
import org.testng.annotations.Test;

public class Demo2_Test {

	@Test(priority = 4)
	public void test_4() {
		System.out.println("test_4 executed");
	}
	
	@Test(priority = 5)
	public void test_5() {
		System.out.println("test_5 executed");
	}
	
	@Test(priority = 6)
	public void test_6() {
		System.out.println("test_6 executed");
	}
}
