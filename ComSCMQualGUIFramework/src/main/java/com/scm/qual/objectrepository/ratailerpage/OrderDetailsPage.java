package com.scm.qual.objectrepository.ratailerpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
/**
 * @author RAJU
 */
public class OrderDetailsPage {

	@FindBy(xpath = "//h1[text()='Order Details']")
	private WebElement orderDetailsHeaderMsg;

	public OrderDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrderDetailsHeaderMsg() {
		return orderDetailsHeaderMsg;
	}
	/**
	 * @author RAJU
	 * @param expHeaderMag
	 */
	public void verifyOrderDetails(String expHeaderMag) {
		String actHeaderMag = getOrderDetailsHeaderMsg().getText().trim();
		Assert.assertEquals(actHeaderMag, expHeaderMag);
	}
	
}
