package com.scm.qual.objectrepository.adminhomepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.qual.webdriverutility.WebDriverUtility;

public class AddUnitPage {

	@FindBy(xpath = "//input[@id='unitName']")
	private WebElement unitNameTf;

	@FindBy(xpath = "//textarea[@id='unitDetails']")
	private WebElement unitDetailsTf;

	@FindBy(xpath = "//input[@value='Add Unit']")
	private WebElement addUnitBtn;

	public AddUnitPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUnitNameTf() {
		return unitNameTf;
	}

	public WebElement getUnitDetailsTf() {
		return unitDetailsTf;
	}

	public WebElement getAddUnitBtn() {
		return addUnitBtn;
	}

	public void addUnit(AdminHomePage ahp, WebDriver driver, WebDriverUtility wLib, ViewUnitsPage vup, String unitName,
			String uniDetails) {
		ahp.getManageUnitBtn().click();
		wLib.clickOnElementVaiJS(driver, vup.getAddUnitBtn());
		getUnitNameTf().sendKeys(unitName);
		getUnitDetailsTf().sendKeys(uniDetails);
		wLib.waitForVisibility(driver, getAddUnitBtn());
		getAddUnitBtn().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wLib.alertAccept(driver);
		
	}
}
