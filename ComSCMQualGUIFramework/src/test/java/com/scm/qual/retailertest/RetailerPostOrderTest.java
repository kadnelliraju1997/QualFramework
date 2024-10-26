package com.scm.qual.retailertest;

import org.testng.annotations.Test;

import com.scm.qual.basetest.BaseClass;
import com.scm.qual.objectrepository.adminhomepage.ViewRetailerPage;
import com.scm.qual.objectrepository.loginpage.LoginPage;
import com.scm.qual.objectrepository.ratailerpage.MyOrdersPage;
import com.scm.qual.objectrepository.ratailerpage.OrderItemsPage;
import com.scm.qual.objectrepository.ratailerpage.RetailerHomePage;

public class RetailerPostOrderTest extends BaseClass {
	
	@Test
	public void ratailerPostOrder() {
		LoginPage lp=new LoginPage(driver);
		ViewRetailerPage rp = new ViewRetailerPage(driver);
		RetailerHomePage rhp=new RetailerHomePage(driver);
		OrderItemsPage oip=new OrderItemsPage(driver);
		MyOrdersPage mop=new MyOrdersPage(driver);
		String retailer_usn = fLib.getDataFromPropetyFile("retailer_usn");
		String retailer_pwd = fLib.getDataFromPropetyFile("retailer_usn");
		String retailerType = eLib.getDataFromExcelSheet("Qual", 4, 2);
		String quentity = eLib.getDataFromExcelSheet("Qual", 4, 4);
		String expPage = eLib.getDataFromExcelSheet("Qual", 4, 3);
		
		lp.loginToApp(retailer_usn, retailer_pwd, retailerType);
		oip.newOrder(rhp, oip, quentity, driver, wLib);
		mop.verifyMyOrdersHeaderMessage(expPage);
		rhp.logoutFromApp();
		
	}

}
