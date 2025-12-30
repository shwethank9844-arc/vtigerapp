package testNG_Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class sample_Test {
     @Test
	public void m1() {
		System.out.println("--execute--");
	}
     @BeforeSuite
     public  void bs() {
    	 System.out.println("sample before suite");
     }
     @BeforeMethod
     public  void bm() {
    	 System.out.println("sample before method");
     }
     @BeforeClass
     public  void bc() {
    	 System.out.println("sample before class");
     }
     @Test
      public void m2() {
    	 System.out.println("--execute 2--");
     }
     @AfterClass
     public  void ac() {
    	 System.out.println("sample after class");
     }
     @AfterSuite
     public  void as() {
    	 System.out.println("sample after suite");
     }
     @AfterMethod
     public  void am() {
    	 System.out.println("sample after method");
     }
	
}
