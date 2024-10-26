package com.scm.qual.webdriverutility;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.scm.qual.basetest.BaseClass;
import com.scm.qual.ipathconstants.IPathConstants;

public class WebDriverUtility implements IPathConstants{

	public void get(WebDriver driver, String url) {
		driver.get(url);
	}
	public void closeBrowser(WebDriver driver) {
		driver.close();
	}
	public void quitBrowser(WebDriver driver) {
		driver.quit();
	}
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void minimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	public void findElementXpath(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath));
	}

	public void findElementId(WebDriver driver, String id) {
		driver.findElement(By.id(id));
	}

	public void findElementName(WebDriver driver, String name) {
		driver.findElement(By.name(name));
	}

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void pageLoadWait(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}

	public void waitForVisibility(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForContainsUrl(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlContains(url));
	}

	public void waitForContainsTitle(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains(title));
	}

	public void newWindow(WebDriver driver) {
		driver.switchTo().newWindow(WindowType.WINDOW);
	}

	public void newTab(WebDriver driver) {
		driver.switchTo().newWindow(WindowType.TAB);
	}

	public void switchToTabOnUrl(WebDriver driver, String parcialUrl) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			String url = driver.getCurrentUrl();
			if (url.contains(parcialUrl)) {
				break;
			}
		}
	}

	public void switchToTabOnTitle(WebDriver driver, String parcialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			String title = driver.getTitle();
			if (title.contains(parcialTitle)) {
				break;
			}
		}
	}
	public String getScreenShot(WebDriver driver,String testName) {
		JavaUtility jLib=new JavaUtility();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst= new File(screenshotPath+testName+"_"+jLib.date()+".png");
		String path=ts.getScreenshotAs(OutputType.BASE64);
		try {
			FileHandler.copy(src, dst);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return path;
	}

	public void scrollToElementJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void clickOnElementVaiJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void handleCookiesViaJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.cookies='cookies-accepted=true';");
	}

	public void switchToFrameByName(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}

	public void switchToFrameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToParentFrameByIndex(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	public void switchToMainFrameByIndex(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void alertSendkeys(WebDriver driver, String key) {
		driver.switchTo().alert().sendKeys(key);
	}

	public void handleNotification() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable -notifications");
	}

	public void moveToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element);
	}

	public void doubleClickOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element);
	}

	public void clickAndHold(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.clickAndHold(element);
	}

	public void contextClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element);
	}

	public void scrollByAmount(WebDriver driver, int amount, int amount1) {
		Actions action = new Actions(driver);
		action.scrollByAmount(amount, amount1);
	}

	public void scrollByAmount(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.scrollToElement(element);
	}

	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dst) {
		Actions action = new Actions(driver);
		action.dragAndDrop(src, dst);
	}

	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	public void deselectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	public void deselectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	public void deselectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	public void getOptions(WebElement element) {
		Select select = new Select(element);
		select.getOptions();
	}
}
