package GEneric_Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryAnalyzer implements IRetryAnalyzer {

	int intialCount=0;
	int retryLimit=4;
	

	@Override
	public boolean retry(ITestResult result) {
		if(intialCount<retryLimit) {
			intialCount++;
			return true;
		}
		
		return false;
	}
	
}

