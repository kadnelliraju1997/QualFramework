package com.scm.qual.objectrepository.adminhomepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author RAJU
 */
public class ViewUnitsPage {

	@FindBy(xpath = "//input[@value='+ Add Unit']")
	private WebElement addUnitBtn;

	public ViewUnitsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddUnitBtn() {
		return addUnitBtn;
	}

	

	
}
