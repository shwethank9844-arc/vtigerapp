package GEneric_Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementedClass implements ITestListener,ISuiteListener  {
   
	
	ExtentReports report;
	ExtentTest test;
	//holding the address thread ms  driver sdriver(static--not create object only call the variAable   hold ist windowid)
	//public static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	public static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();//FRESH EXECUTION
	
	
	@Override
	public void onStart(ISuite suite) {
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReport\\report"+new javaUtiles().sysdate()+".html");
	     htmlreport.config().setDocumentTitle("tekpyramid");
	     htmlreport.config().setTheme(Theme.DARK);
	     htmlreport.config().setReportName("vtigerApplication");
	     
	     report = new ExtentReports();
	     report.attachReporter(htmlreport);
	     report.setSystemInfo("base_browser", "chrome");
	     report.setSystemInfo("base_platform", "windows");
	     report.setSystemInfo("base_url", "http://localhost:8888");
	     report.setSystemInfo("ReporterName", "shwetha");
	}

	
	
	@Override
	public void onTestStart(ITestResult result) {
		  String methodName = result.getMethod().getMethodName();
		  test=report.createTest(methodName);
		  extentTest.set(test);
		  extentTest.get().log(Status.INFO, methodName+"execution starts");//print 
		     
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		extentTest.get().log(Status.PASS, methodName+"execution pass");//<b>TS-1</B>---BOLD TEXT format
		                                                                //<i>TS-2<I/>ITALIC TEXT FORMAT
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
	try {		
		String methodName=result.getMethod().getMethodName();
		String filepath=methodName+new javaUtiles().sysdate();
		
	
	//	TakesScreenshot ts=(TakesScreenshot) baseClass.sdriver;
		TakesScreenshot ts=(TakesScreenshot) baseClass.wdriver.get();
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dtn = new File(".\\screenshot\\"+filepath+".png");
		FileUtils.copyFile(src, dtn);
		
		String path=dtn.getAbsolutePath();
		extentTest.get().addScreenCaptureFromPath(path);	
		extentTest.get().log(Status.FAIL, result.getThrowable());
		
		extentTest.get().log(Status.FAIL, methodName+"failed");
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	
	}

	
	
	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		extentTest.get().log(Status.SKIP, methodName+"skipped");
		
	}

	@Override
	public void onStart(ITestContext context) {
//		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReport\\report"+new javaUtiles().sysdate()+".html");
//	     htmlreport.config().setDocumentTitle("tekpyramid");
//	     htmlreport.config().setTheme(Theme.DARK);
//	     htmlreport.config().setReportName("vtigerApplication");
//	     
//	     report = new ExtentReports();
//	     report.attachReporter(htmlreport);
//	     report.setSystemInfo("base_browser", "chrome");
//	     report.setSystemInfo("base_platform", "windows");
//	     report.setSystemInfo("base_url", "http://localhost:8888");
//	     report.setSystemInfo("ReporterName", "shwetha");	
//		
		
	}
	@Override
	public void onFinish(ITestContext context) {
		
		
	}

	

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	
	
	
}
