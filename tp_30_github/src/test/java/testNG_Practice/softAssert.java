package testNG_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssert {

	
	@Test
	public void softAssertTest() {
		SoftAssert sa = new SoftAssert();
		System.out.println("---execute1---");
		System.out.println("---execute2---");
		sa.assertEquals("hii", "hello");
	//	sa.assertNotEquals("hii", "hello");
		System.out.println("---execute3---");
		sa.assertAll();
}
	@Test
	public void softAssertTest1() {
		
	   int a=10;
		SoftAssert sa = new SoftAssert();
		System.out.println("---execute1---");
		System.out.println("---execute2---");
	//	sa.assertNull(sa);
		sa.assertNotNull(sa);
		System.out.println("---execute3---");
		sa.assertAll();
}
}
