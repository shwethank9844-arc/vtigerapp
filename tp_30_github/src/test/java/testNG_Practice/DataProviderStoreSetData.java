package testNG_Practice;

import org.testng.annotations.Test;

public class DataProviderStoreSetData {

	@Test(dataProviderClass = storeSetOfDate.class,dataProvider = "stre_products")
	public void getData(String pName,int price) {
		System.out.println(pName+"---->"+price);
	}
	@Test(dataProviderClass = storeSetOfDate.class,dataProvider = "credencial")
	public void getDatas(String username,String password) {
		System.out.println(username+"---->"+password);
	}
	@Test(dataProviderClass = storeSetOfDate.class,dataProvider = "excelData")
	public void getExcelData(String trainers,String teaching) {
		System.out.println(trainers+"----->"+teaching);
	}
	
	
}
