package testNG_Practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import GEneric_Utils.baseClass;

@Listeners(GEneric_Utils.ListenerImplementedClass.class)
public class listenerEXample extends baseClass {
    
	
	@Test
	public void sample_m1() {
		System.out.println("--execute 1--");
		Assert.fail();
	}
	
	@Test
	
	public void sample_m2() {
		System.out.println("--execute 2---");
		
	}
}
