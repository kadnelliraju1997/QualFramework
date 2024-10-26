package com.scm.qual.objectrepository.adminhomepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.qual.webdriverutility.WebDriverUtility;

public class AddCategoryPage {

	
	@FindBy(xpath = "//input[@id='categoryName']")
	private WebElement categoryNameTf;

	@FindBy(xpath = "//textarea[@id='categoryDetails']")
	private WebElement categoryDetailsTf;
	
	@FindBy(xpath = "//input[@value='Add Category']")
	private WebElement AddCategoryBtn;
	
	public AddCategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCategoryNameTf() {
		return categoryNameTf;
	}

	public WebElement getCategoryDetailsTf() {
		return categoryDetailsTf;
	}

	public WebElement getAddCategoryBtn() {
		return AddCategoryBtn;
	}
	
	public void addCategory(AdminHomePage ahp,WebDriver driver,WebDriverUtility wLib,ViewCategoryPage vcp,String categoryName,String categoryDetails) {
		wLib.waitForVisibility(driver,ahp.getManageCategoryBtn());
		ahp.getManageCategoryBtn().click();
		wLib.clickOnElementVaiJS(driver, vcp.getAddCategoryBtn());
		getCategoryNameTf().sendKeys(categoryName);
		getCategoryDetailsTf().sendKeys(categoryDetails);
		getAddCategoryBtn().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		wLib.alertAccept(driver);
	}
}
