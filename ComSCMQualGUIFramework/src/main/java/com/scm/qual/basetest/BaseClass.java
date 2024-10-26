package com.scm.qual.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.scm.qual.databaseutility.DataBaseUtility;
import com.scm.qual.fileutility.ExcelUtility;
import com.scm.qual.fileutility.FileUtility;
import com.scm.qual.webdriverutility.UtilityObjectClass;
import com.scm.qual.webdriverutility.WebDriverUtility;

public class BaseClass {
	public WebDriver driver;
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public DataBaseUtility dLib = new DataBaseUtility();
    public static WebDriver sessionDriver=null;
	@BeforeSuite
	public void connectToDb() {
		System.out.println("====>connect to db<====");
//		dLib.connectToDatabase();
	}

	@BeforeClass
	public void launchBrower() {
		System.out.println("====>launchBrower<====");
		String Browser = fLib.getDataFromPropetyFile("browser");
		String url = fLib.getDataFromPropetyFile("url");
		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("fire")) {
			driver = new FirefoxDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new InternetExplorerDriver();
		}
		wLib.maximize(driver);
		wLib.get(driver, url);
		sessionDriver=driver;
		UtilityObjectClass.setDriver(driver);
		
	}

	@AfterClass
	public void closeBrowser() {

		wLib.quitBrowser(driver);
		System.out.println("====>closeBrowser<====");
	}

	@AfterSuite
	public void closeDb() {
//		dLib.closeDatabase();
		System.out.println("====>closeDb<====");
	}

}
