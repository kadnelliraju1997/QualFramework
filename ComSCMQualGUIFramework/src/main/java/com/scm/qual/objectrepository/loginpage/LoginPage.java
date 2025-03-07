package com.scm.qual.objectrepository.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.qual.webdriverutility.WebDriverUtility;
/**
 * @author RAJU
 */
public class LoginPage {
	
	WebDriverUtility wLib = new WebDriverUtility();

	@FindBy(id = "login:username")
	private WebElement userNameTf;

	@FindBy(id = "login:password")
	private WebElement passWordTf;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginBtn;

	@FindBy(id = "login:type")
	private WebElement loginTypeDd;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameTf() {
		return userNameTf;
	}

	public WebElement getPassWordTf() {
		return passWordTf;
	}

	public WebElement getLoginTypeDd() {
		return loginTypeDd;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	/**
	 * 
	 * @param userName
	 * @param passWord
	 * @param text
	 */
	public void loginToApp(String userName,String passWord,String text) {
		getUserNameTf().sendKeys(userName);
		getPassWordTf().sendKeys(passWord);
		wLib.selectByVisibleText(getLoginTypeDd(), text);
		getLoginBtn().click();

	}
	

}
