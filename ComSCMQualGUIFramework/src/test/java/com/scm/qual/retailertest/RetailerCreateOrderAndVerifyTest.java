package com.scm.qual.retailertest;

import org.testng.annotations.Test;

import com.scm.qual.basetest.BaseClass;
import com.scm.qual.objectrepository.loginpage.LoginPage;
import com.scm.qual.objectrepository.ratailerpage.MyOrdersPage;
import com.scm.qual.objectrepository.ratailerpage.OrderDetailsPage;
import com.scm.qual.objectrepository.ratailerpage.OrderItemsPage;
import com.scm.qual.objectrepository.ratailerpage.RetailerHomePage;
/**
 * @author RAJU
 */
public class RetailerCreateOrderAndVerifyTest extends BaseClass {
	
	@Test
	public void createOrderAndVerify() {
		LoginPage lp=new LoginPage(driver);
		RetailerHomePage rhp=new RetailerHomePage(driver);
		OrderItemsPage oip=new OrderItemsPage(driver);
		MyOrdersPage mop=new MyOrdersPage(driver);
		OrderDetailsPage odp=new OrderDetailsPage(driver);
		
		String retailer_usn = fLib.getDataFromPropetyFile("retailer_usn");
		String retailer_pwd = fLib.getDataFromPropetyFile("retailer_usn");
		String retailerType = eLib.getDataFromExcelSheet("Qual", 17, 2);
		String quentity = eLib.getDataFromExcelSheet("Qual", 17, 4);
		String searchByText = eLib.getDataFromExcelSheet("Qual", 17,5);
		String expStatus = eLib.getDataFromExcelSheet("Qual", 17, 6);
		String orderId = eLib.getDataFromExcelSheet("Qual", 17, 3);
		String expHeaderMag = eLib.getDataFromExcelSheet("Qual", 17, 7);
	
		lp.loginToApp(retailer_usn, retailer_pwd, retailerType);
		oip.newOrder(rhp, oip, quentity, driver, wLib);
		mop.verifyOrderInMyOrders(wLib, searchByText, driver, orderId, expStatus);
		odp.verifyOrderDetails(expHeaderMag);
		rhp.logoutFromApp();
	}
	
}
