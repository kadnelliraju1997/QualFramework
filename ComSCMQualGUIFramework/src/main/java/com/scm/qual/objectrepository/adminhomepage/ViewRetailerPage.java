package com.scm.qual.objectrepository.adminhomepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
/**
 * @author RAJU
 */
public class ViewRetailerPage {

	@FindBy(xpath = "//h1[text()='View Retailer']")
	private WebElement viewRetailerHeader;

	public ViewRetailerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getViewRetailerHeader() {
		return viewRetailerHeader;
	}
	
	public void verifyRetailerHeader(String expHeader) {
		String actHeader = getViewRetailerHeader().getText().trim();
		Assert.assertEquals(actHeader, expHeader);
	}

}
