package com.scm.qual.retailertest;

import org.testng.annotations.Test;

import com.scm.qual.basetest.BaseClass;
import com.scm.qual.objectrepository.adminhomepage.ViewRetailerPage;
import com.scm.qual.objectrepository.loginpage.LoginPage;
import com.scm.qual.objectrepository.ratailerpage.MyOrdersPage;
import com.scm.qual.objectrepository.ratailerpage.OrderItemsPage;
import com.scm.qual.objectrepository.ratailerpage.RetailerHomePage;
import com.scm.qual.objectrepository.ratailerpage.RetailerMyInvoicePage;
/**
 * @author RAJU
 */
public class MyInvoicesRetailerTest extends BaseClass {

	@Test
	public void ratailerPostOrder() {
		LoginPage lp = new LoginPage(driver);
		ViewRetailerPage rp = new ViewRetailerPage(driver);
		RetailerHomePage rhp = new RetailerHomePage(driver);
		OrderItemsPage oip = new OrderItemsPage(driver);
		MyOrdersPage mop = new MyOrdersPage(driver);
		RetailerMyInvoicePage rmip = new RetailerMyInvoicePage(driver);
		String retailerUsn = fLib.getDataFromPropetyFile("retailer_usn");
		String retailerPwd = fLib.getDataFromPropetyFile("retailer_usn");
		String retailerType = eLib.getDataFromExcelSheet("Qual", 4, 2);
		String quentity = eLib.getDataFromExcelSheet("Qual", 4, 4);
		String text = eLib.getDataFromExcelSheet("Qual", 11, 5);
		String id = eLib.getDataFromExcelSheet("Qual", 11, 6);
		String expErrorMessage = eLib.getDataFromExcelSheet("Qual", 10, 3);

		lp.loginToApp(retailerUsn, retailerPwd, retailerType);
		rmip.searchInvoiceAndVerifyErrorMessage(rhp, oip, wLib, driver, quentity, text, id, expErrorMessage);

	}

}
