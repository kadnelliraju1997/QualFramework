package com.scm.qual.objectrepository.ratailerpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.qual.webdriverutility.WebDriverUtility;

public class OrderItemsPage {
	@FindBy(xpath = "//input[@id='22']")
	private WebElement pinappleCakeQtyTf;

	@FindBy(xpath = "//input[@id='btnSubmit']")
	private WebElement postOrderBtn;

	public OrderItemsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getPinappleCakeQtyTf() {
		return pinappleCakeQtyTf;
	}

	public WebElement getPostOrderBtn() {
		return postOrderBtn;
	}
	public void newOrder(RetailerHomePage rhp,OrderItemsPage oip,String quentity,WebDriver driver,WebDriverUtility wLib) {
		rhp.getNewOrderBtn().click();
		getPinappleCakeQtyTf().sendKeys(quentity);
		wLib.clickOnElementVaiJS(driver, getPostOrderBtn());
	}

}
