package crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crm.qa.pages.HomePage;
import crm.qa.pages.LoginPage;
import crm.testbase.TestBase;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
public HomePageTest() {
	super();
}
@BeforeMethod
public void setup() {
	initialization();
	loginpage=new LoginPage();
	homepage=new HomePage();
	homepage=loginpage.logincredientials(prop.getProperty("username"), prop.getProperty("Pass"));
}
@Test(priority=1)
public void verifyHomePageTitleTest() {
	String title=homepage.verifyHomePageTitle();
	Assert.assertEquals(title, "X2CRM1 - VeiwProfile");
	System.out.println(title);
}

@Test(priority=2)
public void clickonAccountTest() {
	homepage.clickonAccount();
	log.info("-----------Click on Accounts link-------------");
}
@Test(priority=3)
public void clickonMarketingTest() {
	homepage.clickonMarketing();
	log.info("-----------Click on Markrting link-------------");
}
@AfterMethod
public void teardown() {
	driver.quit();
}

}
