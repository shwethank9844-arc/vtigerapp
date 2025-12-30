package testNG_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class assertsTest {

	@Test
	public void hardAssertTest() {
		
		System.out.println("---execute1---");
		System.out.println("---execute2---");
//		Assert.assertEquals("hii", "hello");
		Assert.assertNotEquals("hii", "hello");
		System.out.println("---execute3---");
		
		
	}
	
	@Test
	public void hardAssertTest2() {
		  int a=20;
		System.out.println("---execute1---");
		System.out.println("---execute2---");
	//	Assert.assertNull(a);
		Assert.assertNotNull(a);
		System.out.println("---execute3---");
		
}
}
