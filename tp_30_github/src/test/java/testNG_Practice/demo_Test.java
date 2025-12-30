package testNG_Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demo_Test  extends listenerMethods{

	
	
	@BeforeMethod
	public void bm() {
		System.out.println("--before method--");
	}
	@BeforeClass
	public void bc() {
		System.out.println("--before class--");
	}
	@BeforeSuite
	public void bs() {
		System.out.println("--before suite--");
	}
	@BeforeTest
	public void bt() {
		System.out.println("--before test--");
	}
	@BeforeMethod
	public void bm2() {
		System.out.println("--before method 2--");
	}
	@Test
	public void test() {
		System.out.println("--print--");
	}
	
	@AfterMethod
	public void am() {
		System.out.println("--after method--");
	}
	@AfterClass
	public void ac() {
		System.out.println("--after class--");
	}
	@Test
	public void test2() {
		System.out.println("--print-2--");
	}
	@AfterSuite
	public void as() {
		System.out.println("--after suite--");
	}
	@AfterTest
	public void at() {
		System.out.println("--after test--");
	}
	@AfterSuite
	public void as2() {
		System.out.println("--after suite- 2--");
	}
	
}
