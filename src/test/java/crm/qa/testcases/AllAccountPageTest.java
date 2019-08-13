package crm.qa.testcases;

import org.openqa.selenium.Alert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import crm.qa.pages.AccountPage;
import crm.qa.pages.AllAccountPage;
import crm.qa.pages.HomePage;
import crm.qa.pages.LoginPage;
import crm.qa.util.TestUtil;
import crm.testbase.TestBase;

public class AllAccountPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	AccountPage accountpage;
	AllAccountPage allaccountpage;

	public AllAccountPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		accountpage = new AccountPage();
		allaccountpage = new AllAccountPage();
		homepage = loginpage.logincredientials(prop.getProperty("username"), prop.getProperty("Pass"));
		homepage.clickonAccount();

		allaccountpage.clickoncolums();
		Thread.sleep(2000);
		allaccountpage.selectcheckbox();
		Thread.sleep(5000);

	}

//@Test
//public void selectCheckboxesTest() {
//	allaccountpage.selectcheckbox();
//}
	@DataProvider
	public Object[][] addData1() {
		Object data[][] = TestUtil.GetData("Sheet1");
		return data;
	}

	@Test(dataProvider="addData1")
	public void addDataTest(String name) {
		allaccountpage.addData(name);
	}
	

//@AfterMethod
//public void teardown() {
//	driver.quit();
//}
}
