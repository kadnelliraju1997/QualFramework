package com.scm.qual.objectrepository.adminhomepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCategoryPage {

	@FindBy(xpath = "//input[@value='+ Add Category']")
	private WebElement addCategoryBtn;

	public ViewCategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddCategoryBtn() {
		return addCategoryBtn;
	}

}
