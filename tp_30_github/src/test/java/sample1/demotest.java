package sample1;

import org.testng.annotations.Test;

import GEneric_Utils.baseClass;

public class demotest extends baseClass {
	@Test(groups="regression")
	public void test() {
		System.out.println("--demotest1--");
	}
	@Test(groups="smoke")
	public void test2() {
		System.out.println("--demotest2--");
	}


}

