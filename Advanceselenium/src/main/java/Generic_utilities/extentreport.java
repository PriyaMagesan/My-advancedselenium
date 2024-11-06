package Generic_utilities;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.*;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class extentreport implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		
		test = report.createTest(result.getName());
		 
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		test.log(Status.PASS,result.getName());
		test.log(Status.PASS, result.getThrowable()); //when we add assertion, we could know the exception caused by any mistakes
			
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,result.getName());
		test.log(Status.FAIL, result.getThrowable());
		
		TakesScreenshot ts=(TakesScreenshot)Base_class.Sdriver;
		
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.SKIP,result.getName());
		test.log(Status.SKIP, result.getThrowable());
	}
	
	
	@Override
	public void onStart(ITestContext context) {
		
		//look wise of the report
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentreport/file");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Vtiger");
		spark.config().setReportName("Priya");
		
		//system configuration
	    report=new ExtentReports();
	    report.attachReporter(spark);
	    report.setSystemInfo("Os version", "Window11");
	    report.setSystemInfo("Executed By", "Priya");
	    report.setSystemInfo("Reviewed By", "Joel D");
	    report.setUsingNaturalConf(true);
	       
	
	}
	
	
	@Override
	public void onFinish(ITestContext context) {
		
		//Flush method ---->it will erase the previous data on the report and create a new report
		report.flush();
		
	}
	
	
	
	

}
