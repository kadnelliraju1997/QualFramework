package com.scm.qual.objectrepository.manufacturerhomepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.qual.webdriverutility.WebDriverUtility;
/**
 * @author RAJU
 */
public class OrdersPage {

	@FindBy(xpath = "//a[@href='confirm_order.php?id=30']")
	private WebElement confirmLink;

	@FindBy(xpath = "//a[text()='+ Invoice']")
	private WebElement invoiceLink;

	public OrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);// a[text()='+ Invoice']
	}

	public WebElement getConfirmLink() {
		return confirmLink;
	}

	public WebElement getInvoiceLink() {
		return invoiceLink;
	}

	/**
	 * @author RAJU
	 * @param mhp
	 * @param driver
	 * @param wLib
	 */
	public void confirmOrder(ManufacturerHomePage mhp, WebDriver driver, WebDriverUtility wLib) {
		mhp.getOrdersMajorTab().click();
		wLib.clickOnElementVaiJS(driver, getConfirmLink());
		driver.navigate().back();

		wLib.waitForContainsUrl(driver, "http://49.249.28.218:8081/AppServer/Supply_Chain_Management");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	/**
	 * @author RAJU
	 * @param mhp
	 * @param op
	 * @param driver
	 * @param wLib
	 */

	public void confirmOrderAndGenerateInvoice(ManufacturerHomePage mhp,OrdersPage op, WebDriver driver, WebDriverUtility wLib) {
		mhp.getOrdersMajorTab().click();
		wLib.clickOnElementVaiJS(driver, getConfirmLink());
		
		wLib.waitForContainsUrl(driver, "http://49.249.28.218:8081/AppServer/Supply_Chain_Management");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().back();
		wLib.scrollToElementJS(driver, getConfirmLink());
		wLib.clickOnElementVaiJS(driver, getInvoiceLink());

	}
}
