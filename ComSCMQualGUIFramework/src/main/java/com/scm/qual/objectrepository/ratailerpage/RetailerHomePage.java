package com.scm.qual.objectrepository.ratailerpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailerHomePage {
	@FindBy(xpath = "//a[text()='New Order']")
	private WebElement newOrderBtn;

	@FindBy(xpath = "//a[text()='My Orders']")
	private WebElement myOrdersMajorTab;
	
	@FindBy(xpath = "//a[text()='My Invoices']")
	private WebElement myInvoicesMajorTab;

	@FindBy(xpath = "//input[@value='Log out']")
	private WebElement logoutBtn;

	public RetailerHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getNewOrderBtn() {
		return newOrderBtn;
	}

	public WebElement getMyOrdersMajorTab() {
		return myOrdersMajorTab;
	}

	public WebElement getMyInvoicesMajorTab() {
		return myInvoicesMajorTab;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public void logoutFromApp() {
		getLogoutBtn().click();
	}

}
