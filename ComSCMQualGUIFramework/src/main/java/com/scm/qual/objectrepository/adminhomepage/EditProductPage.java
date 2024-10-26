package com.scm.qual.objectrepository.adminhomepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.qual.webdriverutility.WebDriverUtility;

import junit.framework.Assert;

public class EditProductPage {

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

	@FindBy(xpath = "//input[@value='Update Product']")
	private WebElement updateProductBtn;

	public EditProductPage(WebDriver driver) {
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

	public WebElement getUpdateProductBtn() {
		return updateProductBtn;
	}

	public WebElement getProductPriceTf() {
		return productPriceTf;
	}

	public void editProduct(AdminHomePage ahp, String productNo, WebDriverUtility wLib, WebDriver driver,
			String updatePrice, String productName) {
		wLib.waitForVisibility(driver, ahp.getProductsMajorTab());
		ahp.getProductsMajorTab().click();
		WebElement editProduct = driver.findElement(By.xpath("//a[@href='edit_product.php?id=" + productNo + "']"));
		wLib.clickOnElementVaiJS(driver, editProduct);
		getProductPriceTf().sendKeys(updatePrice);
		getEnableRadioBtn().click();
		getUpdateProductBtn().click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wLib.alertAccept(driver);
		ahp.getProductsMajorTab().click();
		String actProductName = driver
				.findElement(By.xpath(
						"//td[text()=' " + productNo + " ']/following-sibling::td[text()=' " + productName + " ']"))
				.getText().trim();
		Assert.assertEquals(actProductName, productName);
	}

}
