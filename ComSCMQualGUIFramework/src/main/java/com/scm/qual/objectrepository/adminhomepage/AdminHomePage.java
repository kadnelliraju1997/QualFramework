package com.scm.qual.objectrepository.adminhomepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author RAJU
 */
public class AdminHomePage {

	@FindBy(xpath = "//a[text()='Home']")
	private WebElement homeMajorTab;

	@FindBy(xpath = "//a[text()='Retailers']")
	private WebElement retailersMajorTab;
	
	@FindBy(xpath = "//a[text()='Manufacturers']")
	private WebElement manufacturersMajoTab;
	
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
	
	@FindBy(xpath = "//a[text()='Add Retailers']")
	private WebElement addRetailersBtn;
	
	@FindBy(xpath = "//a[text()='Add Manufacturer']")
	private WebElement addManufacturerBtn;
	
	@FindBy(xpath = "//a[text()='Add Distributor']")
	private WebElement addDistributorBtn;
	
	@FindBy(xpath = "//a[text()='Manage Unit']")
	private WebElement manageUnitBtn;
	
	@FindBy(xpath = "//a[text()='Manage Category']")
	private WebElement manageCategoryBtn;
	
	@FindBy(xpath = "//a[text()='Manage Area']")
	private WebElement manageAreaBtn;

	@FindBy(xpath = "//input[@value='Log out']")
	private WebElement logoutBtn;

	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this); 
	}

	public WebElement getHomeMajorTab() {
		return homeMajorTab;
	}
	public WebElement getRetailersMajorTab() {
		return retailersMajorTab;
	}

	public WebElement getManufacturersMajoTab() {
		return manufacturersMajoTab;
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

	public WebElement getAddRetailersBtn() {
		return addRetailersBtn;
	}

	public WebElement getAddManufacturerBtn() {
		return addManufacturerBtn;
	}

	public WebElement getAddDistributorBtn() {
		return addDistributorBtn;
	}

	public WebElement getManageUnitBtn() {
		return manageUnitBtn;
	}

	public WebElement getManageCategoryBtn() {
		return manageCategoryBtn;
	}

	public WebElement getManageAreaBtn() {
		return manageAreaBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public void logoutFromApp() {
		getLogoutBtn().click();
	}
}
