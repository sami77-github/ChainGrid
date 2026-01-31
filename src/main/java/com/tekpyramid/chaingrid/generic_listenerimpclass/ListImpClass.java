package com.tekpyramid.chaingrid.generic_listenerimpclass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tekpyramid.chaingrid.generic_baseclass.SuperBaseClass;
import com.tekpyramid.chaingrid.generic_baseclass.UtilityClassObject;
import com.tekpyramid.chaingrid.generic_utility.ChainGrid_Java_Utility;

public class ListImpClass implements ITestListener,ISuiteListener {
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		ChainGrid_Java_Utility ju = new ChainGrid_Java_Utility();
		String time = ju.generateDate();
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvancedReport/Report_"+time+".html");
	      spark.config().setDocumentTitle("ChainGridReport");
	      spark.config().setReportName("Extent Report");
	      spark.config().setTheme(Theme.DARK);
	      report = new ExtentReports();
	      report.attachReporter(spark);
	      report.setSystemInfo("Browser", SuperBaseClass.browser);
	      report.setSystemInfo("OS", "Windows 11");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		test.log(Status.INFO, methodName+"Test Execution  Started");
		UtilityClassObject.setTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.PASS, name+"Test Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String thisMethod = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot)UtilityClassObject.getDriver();
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);
		ChainGrid_Java_Utility ju = new ChainGrid_Java_Utility();
		String time = ju.generateDate();
		test.addScreenCaptureFromBase64String(screenshot, "Screenshot_"+time);
		test.log(Status.FAIL, thisMethod+" Failed");	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	    String thisMethod = result.getMethod().getMethodName();
	    test.log(Status.SKIP, thisMethod+" Skipped");
	}
}
