package crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crm.qa.pages.HomePage;
import crm.qa.pages.LoginPage;
import crm.testbase.TestBase;

public class LoginPageTest extends TestBase{
LoginPage loginpage;
HomePage homepage;

LoginPageTest(){
	super();
}
@BeforeMethod
public void setup() {
	initialization();
	 loginpage=new LoginPage();
	 homepage = new HomePage();
}
@Test(priority=1)
public void logocheckTest() {
	boolean logopresent=loginpage.logocheck();
	Assert.assertTrue(logopresent);
	log.info("-------------logochecking------------");
}
@Test(priority=2)
public void loginTitleTest() {
	String title=loginpage.loginTitle();
	Assert.assertEquals(title, "X2CRM - Login");
	System.out.println(title);
	//log.info("-----------verify page title-------------");
}
@Test(priority=3)
public void invalidecredentialTest() {
	String em=loginpage.invalidecredientials("ad", "ps");
	System.out.println(em);
	log.info("--------------errormessage--------------");
}
@Test(priority=4)
public void blankuncredentialTest() {
	String em2=loginpage.blenkuncredentials("", "pass");
	log.info("---------erroemessage------"+em2);
}
@Test(priority=5)
public void blankpscredentialsTest() {
	String em3=loginpage.blankpasscredentials("admin", "");
	System.out.println(em3);
}
@Test(priority=6)
public void logincredientialsTest() {
	loginpage.logincredientials(prop.getProperty("username"), prop.getProperty("Pass"));
	log.info("-----------checking for loging-----------------");
}
//@Test(priority=7)
//public void logincredientialsTest1() {
//	homepage.findChild();
//}

@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}


