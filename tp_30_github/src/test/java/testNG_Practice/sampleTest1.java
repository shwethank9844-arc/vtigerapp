package testNG_Practice;

import org.testng.annotations.Test;

import GEneric_Utils.baseClass;

public class sampleTest1 extends baseClass {
	
	  @Test(groups="smoke")
		public void m1() {
			System.out.println("--sampletest1--");
		}
	@Test
    public void m2() {
  	 System.out.println("--sampletest2--");
   }
	
}
