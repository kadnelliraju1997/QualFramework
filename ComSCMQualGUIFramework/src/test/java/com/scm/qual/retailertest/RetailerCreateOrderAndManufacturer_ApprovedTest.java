package com.scm.qual.retailertest;

import org.testng.annotations.Test;

import com.scm.qual.basetest.BaseClass;
import com.scm.qual.objectrepository.loginpage.LoginPage;
import com.scm.qual.objectrepository.manufacturerhomepage.InvoiceSummaryPage;
import com.scm.qual.objectrepository.manufacturerhomepage.ManufacturerHomePage;
import com.scm.qual.objectrepository.manufacturerhomepage.OrdersPage;
import com.scm.qual.objectrepository.ratailerpage.MyOrdersPage;
import com.scm.qual.objectrepository.ratailerpage.OrderDetailsPage;
import com.scm.qual.objectrepository.ratailerpage.OrderItemsPage;
import com.scm.qual.objectrepository.ratailerpage.RetailerHomePage;
import com.scm.qual.objectrepository.ratailerpage.RetailerMyInvoicePage;

public class RetailerCreateOrderAndManufacturer_ApprovedTest extends BaseClass {
@Test
public void CreateOrderAndApproveOrderTest() throws Throwable {
	LoginPage lp=new LoginPage(driver);
	RetailerHomePage rhp=new RetailerHomePage(driver);
	OrderItemsPage oip=new OrderItemsPage(driver);
	MyOrdersPage mop=new MyOrdersPage(driver);
	OrderDetailsPage odp=new OrderDetailsPage(driver);
	ManufacturerHomePage mhp = new ManufacturerHomePage(driver);
	OrdersPage op = new OrdersPage(driver);
	InvoiceSummaryPage isp=new InvoiceSummaryPage(driver);
	RetailerMyInvoicePage rip=new RetailerMyInvoicePage(driver);
	
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
	
	String manufacturerUsn = fLib.getDataFromPropetyFile("manufacturer_usn");
	String manufacturerPwd = fLib.getDataFromPropetyFile("manufacturer_usn");
	String manufacturerType = eLib.getDataFromExcelSheet("Qual", 7, 2);
	String status = eLib.getDataFromExcelSheet("Qual", 7, 6);
	String distributorName = eLib.getDataFromExcelSheet("Qual", 19, 8);
	String expOrderDetails = eLib.getDataFromExcelSheet("Qual", 19, 7);
	String expInvSumHeaderMag = eLib.getDataFromExcelSheet("Qual", 19, 9);
	String id = eLib.getDataFromExcelSheet("Qual", 19, 11);
	String searchByOrderId = eLib.getDataFromExcelSheet("Qual", 19, 12);
	String expErrorMsg=eLib.getDataFromExcelSheet("Qual", 19, 13);
	Thread.sleep(2000);
	lp.loginToApp(manufacturerUsn, manufacturerPwd, manufacturerType);
	op.confirmOrderAndGenerateInvoice(mhp, op, driver, wLib);
	Thread.sleep(3000);
	isp.verifyInvoiceHeaderMsgAndGenerateInvoice(expInvSumHeaderMag, wLib, distributorName, driver);
	mhp.logoutFromApp();
	
	lp.loginToApp(retailer_usn, retailer_pwd, retailerType);
	mop.verifyOrderDetailsInMyOrders(rhp, wLib, searchByText, driver, orderId, expStatus);
	odp.verifyOrderDetails(expHeaderMag);
	rip.verifyOrderInvoice(wLib, searchByOrderId, id, expErrorMsg);
	
	

	
}
}
