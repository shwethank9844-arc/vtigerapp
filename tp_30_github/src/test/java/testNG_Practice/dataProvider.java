package testNG_Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {

	@Test(dataProvider = "storeData")
	
	public void getData(String COMPANY,String LOCATION) {
		System.out.println("company:"+COMPANY+"  "+"location:"+LOCATION);
	}
	
	@DataProvider
	public Object[][] storeData() {
		Object[][] obj = new Object[3][2];
		obj[0][0]="testyantra";
		obj[0][1]="katriguppe";
		
		obj[1][0]="qspider";
		obj[1][1]="rajajinagar";
		
		obj[2][0]="pyspider";
		obj[2][1]="jp nagar";
		
		return obj;
		
	}
}
