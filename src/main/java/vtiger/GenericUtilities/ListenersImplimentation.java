package vtiger.GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplimentation implements ITestListener{
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		
		String methodname = result.getMethod().getMethodName();
		System.out.println("---------Test script execution started--------");
		
		//create a test in extent report
		test=report.createTest(methodname);
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodname = result.getMethod().getMethodName();
		//System.out.println(methodname+"------PASS--------");
		test.log(Status.PASS, methodname+"------PASS--------");
	}

	public void onTestFailure(ITestResult result) {
		
		WebDriverUtility w=new WebDriverUtility();
		JavaUtility j=new JavaUtility();
		
		String methodname = result.getMethod().getMethodName();
		String screenshotName=methodname+j.getSystemDate();
		
		//System.out.println(result.getThrowable());
		//System.out.println(methodname+"-----FAIL----------");
		test.log(Status.FAIL,methodname+"-----FAIL----------" );
		test.log(Status.INFO, result.getThrowable());
		
		try {
			String path = w.captureScreenShot(BaseClass.sdriver, screenshotName);
			
			//attach the screenShot into the report
			test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
		System.out.println(result.getThrowable());
		String methodname = result.getMethod().getMethodName();
		//System.out.println(methodname+"--------SKIP-------");
		test.log(Status.FAIL,methodname+"-----SKIP----------" );
		test.log(Status.INFO, result.getThrowable());
		
	}

	

	public void onStart(ITestContext context) {
		
		System.out.println("----suite execution started------");
		
		//Configure the extent Reports
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\ExtentReports..Report-"+new JavaUtility().getSystemDate()+".html");
		htmlreport.config().setDocumentTitle("Vtiger Execution Report");
		htmlreport.config().setReportName("Automation Execution Report");
		htmlreport.config().setTheme(Theme.DARK);
		
		ExtentReports report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base URL", "https://localhost:8888");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter Name", "Revathi");
		
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("----suite execution finished------");
		
		//generate the report after execution
		report.flush();
		
	}

}
