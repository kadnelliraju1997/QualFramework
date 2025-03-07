package com.scm.qual.objectrepository.adminhomepage;
/**
 * @author RAJU
 **/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.qual.webdriverutility.WebDriverUtility;

public class AddProductPage {

	@FindBy(xpath = "//input[@id='product:name']")
	private WebElement productNameTf;

	@FindBy(xpath = "//input[@id='product:price']")
	private WebElement productPriceTf;

	@FindBy(xpath = "//select[@id='product:unit']")
	private WebElement unitTypeDd;

	@FindBy(xpath = "//select[@id='product:category']")
	private WebElement categoryTypeDd;

	@FindBy(xpath = "//input[@value='1']")
	private WebElement enableRadioBtn;

	@FindBy(xpath = "//input[@value='Add Product']")
	private WebElement addProductBtn;

	public AddProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductNameTf() {
		return productNameTf;
	}

	public WebElement getUnitTypeDd() {
		return unitTypeDd;
	}

	public WebElement getCategoryTypeDd() {
		return categoryTypeDd;
	}

	public WebElement getEnableRadioBtn() {
		return enableRadioBtn;
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}

	public WebElement getProductPriceTf() {
		return productPriceTf;
	}
	/**
	 * 
	 * @param ahp
	 * @param productName
	 * @param productPrice
	 * @param wLib
	 * @param driver
	 * @param unitName
	 * @param categoryName
	 */

	public void addProduct(AdminHomePage ahp,String productName,String productPrice ,WebDriverUtility wLib,WebDriver driver,String unitName,String categoryName) {
		ahp.getAddProductsBtn().click();
		getProductNameTf().sendKeys(productName);
		getProductPriceTf().sendKeys(productPrice);
		wLib.selectByVisibleText(getUnitTypeDd(), unitName);
		wLib.selectByVisibleText(getCategoryTypeDd(), categoryName);
		getEnableRadioBtn().click();
		getAddProductBtn().click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wLib.alertAccept(driver);
	}
}
