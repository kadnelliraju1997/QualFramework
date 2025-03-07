package com.scm.qual.admintest;

import org.testng.annotations.Test;

import com.scm.qual.basetest.BaseClass;
import com.scm.qual.objectrepository.adminhomepage.AddCategoryPage;
import com.scm.qual.objectrepository.adminhomepage.AddProductPage;
import com.scm.qual.objectrepository.adminhomepage.AddUnitPage;
import com.scm.qual.objectrepository.adminhomepage.AdminHomePage;
import com.scm.qual.objectrepository.adminhomepage.EditProductPage;
import com.scm.qual.objectrepository.adminhomepage.ViewCategoryPage;
import com.scm.qual.objectrepository.adminhomepage.ViewUnitsPage;
import com.scm.qual.objectrepository.loginpage.LoginPage;

/**
 * @author RAJU
 */
public class AddProductTest extends BaseClass {

	@Test
	public void addProductTest() {
		LoginPage lp = new LoginPage(driver);
		AdminHomePage ahp = new AdminHomePage(driver);
		ViewUnitsPage vup = new ViewUnitsPage(driver);
		AddUnitPage aup = new AddUnitPage(driver);
		ViewCategoryPage vcp = new ViewCategoryPage(driver);
		AddCategoryPage acp = new AddCategoryPage(driver);
		AddProductPage app = new AddProductPage(driver);
		EditProductPage epp = new EditProductPage(driver);

		String admin_usn = fLib.getDataFromPropetyFile("admin_usn");
		String admin_pwd = fLib.getDataFromPropetyFile("admin_pwd");
		String adminType = eLib.getDataFromExcelSheet("Qual", 1, 2);
		String unitName = eLib.getDataFromExcelSheet("Qual", 14, 5);
		String uniDetails = eLib.getDataFromExcelSheet("Qual", 14, 6);
		String categoryName = eLib.getDataFromExcelSheet("Qual", 14, 7);
		String categoryDetails = eLib.getDataFromExcelSheet("Qual", 14, 8);
		String productName = eLib.getDataFromExcelSheet("Qual", 14, 3);
		String productPrice = eLib.getDataFromExcelSheet("Qual", 14, 4);
		String updatePrice = eLib.getDataFromExcelSheet("Qual", 15, 4);
		String productNo = eLib.getDataFromExcelSheet("Qual", 14, 9);

		lp.loginToApp(admin_usn, admin_pwd, adminType);
		aup.addUnit(ahp, driver, wLib, vup, unitName, uniDetails);
		acp.addCategory(ahp, driver, wLib, vcp, categoryName, categoryDetails);
		app.addProduct(ahp, productName, productPrice, wLib, driver, unitName, categoryName);
		epp.editProduct(ahp, productNo, wLib, driver, updatePrice, productName);
		ahp.logoutFromApp();

	}
}
