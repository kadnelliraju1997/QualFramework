package com.scm.qual.objectrepository.ratailerpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.qual.webdriverutility.WebDriverUtility;

import junit.framework.Assert;

public class MyOrdersPage {

	@FindBy(xpath = "//h1[text()='My Orders']")
	private WebElement myOrdersHeaderMessage;

	@FindBy(xpath = "//tbody/tr[20]/td[4]")
	private WebElement myOrderStatus;
	
	@FindBy(xpath = "//select[@id='cmbFilter']")
	private WebElement searchByDd;
	
	@FindBy(xpath = "//select[@id='cmbStatus']")
	private WebElement selectOptionDd;
	
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchBtn;

	public MyOrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getMyOrdersHeaderMessage() {
		return myOrdersHeaderMessage;
	}

	public WebElement getMyOrderStatus() {
		return myOrderStatus;
	}

	public WebElement getSearchByDd() {
		return searchByDd;
	}

	public WebElement getSelectOptionDd() {
		return selectOptionDd;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public void verifyMyOrdersHeaderMessage(String expected) {
		String actHeader = getMyOrdersHeaderMessage().getText().trim();
		Assert.assertEquals(actHeader, expected);
	}
	
	public void verifyMyOrdersStatus(String expectedStatus) {
		String actStatus = getMyOrderStatus().getText().trim();
		Assert.assertEquals(actStatus, expectedStatus);
	}


	public void verifyOrderInMyOrders(WebDriverUtility wLib,String searchByText,WebDriver driver,String orderId,String expStatus) {
		wLib.selectByVisibleText(getSearchByDd(), searchByText);
		wLib.selectByVisibleText(getSelectOptionDd(), expStatus);
		getSearchBtn().click();
		String actStatus = driver.findElement(By.xpath("//td[text()=' "+orderId+" ']/following-sibling::td[contains(text(),'"+expStatus+"')]")).getText().trim();
		Assert.assertEquals(actStatus, expStatus);
		WebElement detailsLink = driver.findElement(By.xpath("//td[text()=' "+orderId+" ']/following-sibling::td/a[contains(text(),'Details')]"));
		wLib.clickOnElementVaiJS(driver, detailsLink);
	}
	public void verifyOrderDetailsInMyOrders(RetailerHomePage rhp,WebDriverUtility wLib,String searchByText,WebDriver driver,String orderId,String expStatus) {
		rhp.getMyOrdersMajorTab().click();
		wLib.selectByVisibleText(getSearchByDd(), searchByText);
		wLib.selectByVisibleText(getSelectOptionDd(), expStatus);
		getSearchBtn().click();
		String actStatus = driver.findElement(By.xpath("//td[text()=' "+orderId+" ']/following-sibling::td[contains(text(),'"+expStatus+"')]")).getText().trim();
		Assert.assertEquals(actStatus, expStatus);
		WebElement detailsLink = driver.findElement(By.xpath("//td[text()=' "+orderId+" ']/following-sibling::td/a[contains(text(),'Details')]"));
		wLib.clickOnElementVaiJS(driver, detailsLink);
	}
	
}
