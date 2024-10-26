package com.scm.qual.objectrepository.ratailerpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.scm.qual.basetest.BaseClass;
import com.scm.qual.webdriverutility.WebDriverUtility;

public class RetailerMyInvoicePage extends BaseClass {
	@FindBy(xpath = "//a[text()='My Invoices']")
	private WebElement myInvoicesMajorTab;
	
	@FindBy(xpath = "//select[@id='cmbFilter']")
	private WebElement searchByDd;
	
	@FindBy(xpath = "//input[@id='txtOrderId']")
	private WebElement searchTf;
	
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//span[@class='error_message']")
	private WebElement errorMessage;

	public RetailerMyInvoicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getMyInvoicesMajorTab() {
		return myInvoicesMajorTab;
	}

	public WebElement getSearchByDd() {
		return searchByDd;
	}

	public WebElement getSearchTf() {
		return searchTf;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
	public WebElement getErrorMessage() {
		return errorMessage;
	}

	public void searchInvoiceAndVerifyErrorMessage(RetailerHomePage rhp,OrderItemsPage oip,WebDriverUtility wLib,WebDriver driver,String quentity,String text,String id,String expErrorMsg) {
		rhp.getNewOrderBtn().click();
		oip.getPinappleCakeQtyTf().sendKeys(quentity);
		wLib.clickOnElementVaiJS(driver,oip.getPostOrderBtn());
		getMyInvoicesMajorTab().click();
		wLib.selectByVisibleText(getSearchByDd(), text);
		getSearchTf().sendKeys(id);
		getSearchBtn().click();
		String actErrorMSg = getErrorMessage().getText().trim();
		Assert.assertEquals(actErrorMSg,expErrorMsg);
	}
	public void verifyOrderInvoice(WebDriverUtility wLib,String searchByOrderId,String id,String expErrorMsg) {
	getMyInvoicesMajorTab().click();
	wLib.selectByVisibleText(getSearchByDd(), searchByOrderId);
	getSearchTf().sendKeys(id);
	getSearchBtn().click();
	String actErrorMSg = getErrorMessage().getText().trim();
	Assert.assertEquals(actErrorMSg,expErrorMsg);
	} 
	
}
