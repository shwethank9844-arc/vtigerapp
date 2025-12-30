package testNG_Practice;

import org.testng.annotations.Test;

import GEneric_Utils.baseClass;

public class sampleTest2 extends baseClass {
    @Test(groups="smoke")
    public void sample_d1() {
   	 System.out.println("----sample-----");
    }
}
