package com.scm.qual.manufacturerrtest;

import org.testng.annotations.Test;

import com.scm.qual.basetest.BaseClass;
import com.scm.qual.objectrepository.loginpage.LoginPage;
import com.scm.qual.objectrepository.manufacturerhomepage.ManufacturerHomePage;
import com.scm.qual.objectrepository.manufacturerhomepage.OrdersPage;
import com.scm.qual.objectrepository.ratailerpage.MyOrdersPage;
import com.scm.qual.objectrepository.ratailerpage.RetailerHomePage;
/**
 * @author RAJU
 */
public class ManufacturerComfirmOrderTest extends BaseClass {

	@Test
	public void ComfirmOrderTest() throws Throwable {
		LoginPage lp = new LoginPage(driver);
		ManufacturerHomePage mhp = new ManufacturerHomePage(driver);
		OrdersPage op = new OrdersPage(driver);
		RetailerHomePage rhp = new RetailerHomePage(driver);
		MyOrdersPage mop = new MyOrdersPage(driver);

		String manufacturerUsn = fLib.getDataFromPropetyFile("manufacturer_usn");
		String manufacturerPwd = fLib.getDataFromPropetyFile("manufacturer_usn");
		String manufacturerType = eLib.getDataFromExcelSheet("Qual", 7, 2);
		String retailer_usn = fLib.getDataFromPropetyFile("retailer_usn");
		String retailer_pwd = fLib.getDataFromPropetyFile("retailer_usn");
		String retailerType = eLib.getDataFromExcelSheet("Qual", 4, 2);
		String status = eLib.getDataFromExcelSheet("Qual", 7, 6);
		
		lp.loginToApp(manufacturerUsn, manufacturerPwd, manufacturerType);
		op.confirmOrder(mhp, driver, wLib);
		mhp.logoutFromApp();
		Thread.sleep(2000);
		lp.loginToApp(retailer_usn, retailer_pwd, retailerType);
		rhp.getMyOrdersMajorTab().click();
		mop.verifyMyOrdersStatus(status);
		rhp.logoutFromApp();

	}

}
