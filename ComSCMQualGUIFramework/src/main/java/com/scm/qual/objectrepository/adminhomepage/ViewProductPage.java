package com.scm.qual.objectrepository.adminhomepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewProductPage {

	@FindBy(xpath = "")
	private WebElement addUnitBtn;

	public ViewProductPage(WebDriver driver) {//td[text()=' 25 ']/following-sibling::td[text()=' BlackForestCake ']
		PageFactory.initElements(driver, this);
	}

}
