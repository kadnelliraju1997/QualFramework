package com.scm.qual.webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityObjectClass {

	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static ExtentTest getTest(ExtentTest test) {
		return test;
	}

	public static void setTest(ExtentTest actTest) {
		test.set(actTest);
	}

	public static WebDriver getDriver(WebDriver driver) {
		return driver;
	}

	public static void setDriver(WebDriver actDriver) {
		driver.set(actDriver);
	}

}
