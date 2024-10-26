package com.scm.qual.admintest;

import org.testng.annotations.Test;

import com.scm.qual.basetest.BaseClass;
import com.scm.qual.objectrepository.adminhomepage.AdminHomePage;
import com.scm.qual.objectrepository.adminhomepage.ViewRetailerPage;
import com.scm.qual.objectrepository.loginpage.LoginPage;

public class RetailersTest extends BaseClass {
	@Test
	public void verifyRetailerTest() throws Throwable {
		LoginPage lp = new LoginPage(driver);
		AdminHomePage hp = new AdminHomePage(driver);
		ViewRetailerPage rp = new ViewRetailerPage(driver);

		String admin_usn = fLib.getDataFromPropetyFile("admin_usn");
		String admin_pwd = fLib.getDataFromPropetyFile("admin_pwd");
		String adminType = eLib.getDataFromExcelSheet("Qual", 1, 2);
		String expPage = eLib.getDataFromExcelSheet("Qual", 1, 3);

		lp.loginToApp(admin_usn, admin_pwd, adminType);
		hp.getRetailersMajorTab().click();
		rp.verifyRetailerHeader(expPage);
		hp.logoutFromApp();

	}

}
