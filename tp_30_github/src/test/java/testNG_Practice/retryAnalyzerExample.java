package testNG_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import GEneric_Utils.baseClass;

public class retryAnalyzerExample extends baseClass {

	@Test
	public void sample_m1() {
		System.out.println("--execute 1--");
		
	}
	
	@Test(retryAnalyzer = GEneric_Utils.retryAnalyzer.class)
	
	public void sample_m2() {
		System.out.println("--execute 2---");
		Assert.fail();
	}
	
}
