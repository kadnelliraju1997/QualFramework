package com.scm.qual.listenerutility;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.scm.qual.basetest.BaseClass;
import com.scm.qual.ipathconstants.IPathConstants;
import com.scm.qual.webdriverutility.JavaUtility;
import com.scm.qual.webdriverutility.UtilityObjectClass;
import com.scm.qual.webdriverutility.WebDriverUtility;

public class ListenerImpUtility extends BaseClass implements IPathConstants,ITestListener, ISuiteListener {

	WebDriverUtility wLib = new WebDriverUtility();
	JavaUtility jLib = new JavaUtility();
	ExtentSparkReporter spark;
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("ReportConfiguration");
		spark = new ExtentSparkReporter(advanceReportPath + jLib.date() + ".html");
		spark.config().setDocumentTitle("ComSCMQualGUIFramework");
		spark.config().setReportName("QualResult");
		spark.config().setTheme(Theme.STANDARD);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Os", "Window 11");
		report.setSystemInfo("Browser", "Chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		System.out.println("ReportBackUp");

	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		System.out.println("=====>" + testName + "<==Start==");
		test = report.createTest(testName);
		UtilityObjectClass.setTest(test);
		test.log(Status.INFO, testName);
		test.log(Status.INFO, testName+" <Started>");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		System.out.println("=====>" + testName + "<==Completed==");
		test.log(Status.PASS, testName+" <Completed>");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		String path = wLib.getScreenShot(sessionDriver, testName);
		test.addScreenCaptureFromBase64String(path,testName);
		test.log(Status.FAIL, testName);
		System.out.println("=====>" + testName + "<==Failed==");
		test.log(Status.FAIL, testName+"<Failed>");
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		String testName = result.getMethod().getMethodName();
		test.log(Status.SKIP, testName);
		System.out.println("=====>" + testName + "<==Skipped==");
		test.log(Status.SKIP, "<Skipped>");
	}



}
