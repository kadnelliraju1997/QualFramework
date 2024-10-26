package com.scm.qual.objectrepository.manufacturerhomepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.scm.qual.webdriverutility.WebDriverUtility;

public class InvoiceSummaryPage {

	@FindBy(xpath = "//h1[normalize-space()='Invoice Summary']")
	private WebElement invoiceSummaryHeaderMsg;
	
	@FindBy(xpath = "//select[@name='distributor']")
	private WebElement selectDidtributoDd;

	@FindBy(xpath = "//input[@value='Generate Invoice']")
	private WebElement generateInvoiceBtn;
	
	public InvoiceSummaryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getInvoiceSummaryHeaderMsg() {
		return invoiceSummaryHeaderMsg;
	}
	
	public WebElement getSelectDidtributoDd() {
		return selectDidtributoDd;
	}

	public WebElement getGenerateInvoiceBtn() {
		return generateInvoiceBtn;
	}

	public void verifyInvoiceHeaderMsgAndGenerateInvoice(String expInvoiceHeaderMsg,WebDriverUtility wLib,String distributorName,WebDriver driver) {
		String expInvSumHeaderMag = getInvoiceSummaryHeaderMsg().getText().trim();
		Assert.assertEquals(expInvSumHeaderMag, expInvoiceHeaderMsg);
		wLib.scrollToElementJS(driver, getSelectDidtributoDd());
		wLib.selectByVisibleText(getSelectDidtributoDd(), distributorName);
		getGenerateInvoiceBtn().click();
		driver.navigate().back();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
