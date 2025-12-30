package testNG_Practice;

import org.testng.annotations.Test;

public class sampleTest {   //run based on ASCII value
	
//    @Test(priority=-1)           
//     public void sample_m4() {
//    	 System.out.println("----create-----");//------>1
//     }
//     @Test(priority = 0)//default  value is zero ASCII only
//     public void sample_m2() {
//    	 System.out.println("---edit---");//----->2  ASCII
//     }
//     @Test
//     public void sample_m3() {
//    	 System.out.println("----delete-----");//------>3 ASCII
//     }
	
	
	@Test(invocationCount = 2)//it will used to print multiple time
     public void sample_m4() {
    	 System.out.println("----create-----");
     }
     @Test(dependsOnMethods = "sample_m4()")//execute last
     public void sample_m2() {
    	 
    	 int a=10/0;//===exception not print
    	 System.out.println("---edit---");
     }
        @Test
     public void sample_m3() {
    	 System.out.println("----delete-----");
     }
     @Test(dependsOnMethods = "sample_m3()",priority = -1)
     public void sample_m1() {
    	 System.out.println("-------test-----");
     }
     
     
	
}
