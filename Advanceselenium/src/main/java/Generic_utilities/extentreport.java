package Generic_utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class extentreport implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		
		test = report.createTest(result.getName());
		 
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,result.getName());
		test.log(Status.PASS, result.getThrowable());
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,result.getName());
		test.log(Status.FAIL, result.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.SKIP,result.getName());
		test.log(Status.SKIP, result.getThrowable());
	}
	
	
	@Override
	public void onStart(ITestContext context) {
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentreport/file");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Vtiger");
		spark.config().setReportName("Priya");
		
	    report=new ExtentReports();
	    report.attachReporter(spark);
	    report.setSystemInfo("Os version", "Window11");
	    report.setSystemInfo("Executed By", "Priya");
	    report.setSystemInfo("Reviewed By", "Joel D");
	    
	    
	
	}
	
	
	@Override
	public void onFinish(ITestContext context) {
		
		report.flush();
		
	}
	
	
	
	

}
