package com.scm.qual.objectrepository.manufacturerhomepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author RAJU
 */
public class ManufacturerHomePage {

	@FindBy(xpath = "//a[text()='Home']")
	private WebElement homeMajorTab;

	@FindBy(xpath = "//a[text()='Retailers']")
	private WebElement retailersMajorTab;
	
	@FindBy(xpath = "//a[text()='Distributors']")
	private WebElement distributorsMajorTab;
	
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productsMajorTab;
	
	@FindBy(xpath = "//a[text()='Orders']")
	private WebElement ordersMajorTab;
	
	@FindBy(xpath = "//a[text()='Invoice']")
	private WebElement invoiceMajorTab;
	
	@FindBy(xpath = "//a[text()='Add Products']")
	private WebElement addProductsBtn;
	
	@FindBy(xpath = "//a[text()='Manage Unit']")
	private WebElement manageUnitBtn;
	
	@FindBy(xpath = "//a[text()='Manage Category']")
	private WebElement manageCategoryBtn;
	
	@FindBy(xpath = "//a[text()='Manage Stock']")
	private WebElement manageStockBtn;

	@FindBy(xpath = "//input[@value='Log out']")
	private WebElement logoutBtn;

	public ManufacturerHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this); 
	}

	public WebElement getHomeMajorTab() {
		return homeMajorTab;
	}
	public WebElement getRetailersMajorTab() {
		return retailersMajorTab;
	}
	
	public WebElement getDistributorsMajorTab() {
		return distributorsMajorTab;
	}

	public WebElement getProductsMajorTab() {
		return productsMajorTab;
	}

	public WebElement getOrdersMajorTab() {
		return ordersMajorTab;
	}

	public WebElement getInvoiceMajorTab() {
		return invoiceMajorTab;
	}

	public WebElement getAddProductsBtn() {
		return addProductsBtn;
	}

	public WebElement getManageUnitBtn() {
		return manageUnitBtn;
	}

	public WebElement getManageCategoryBtn() {
		return manageCategoryBtn;
	}

	public WebElement getManageStockBtn() {
		return manageStockBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	/**
	 * @author RAJU
	 */
	
	public void logoutFromApp() {
		getLogoutBtn().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
