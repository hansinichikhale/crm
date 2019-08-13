package crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.testbase.TestBase;

public class LoginPage extends TestBase {
	@FindBy(id="login-form-logo")
	@CacheLookup
	WebElement x2crmLogo;
		
		@FindBy(id="LoginForm_username")
		WebElement uname;
		
		
		@FindBy(id="LoginForm_password")
		WebElement passlogin;
		
		@FindBy(id="signin-button")
		WebElement signinButton;
		@FindBy(xpath="//div[contains(@class,\"errorMessage\")]")
		WebElement emsg;
		
		public LoginPage() {
			PageFactory.initElements(driver, this);
			}
		public boolean logocheck() {
			return x2crmLogo.isDisplayed();
		}
		public String loginTitle() {
			return driver.getTitle();
		}
		public String invalidecredientials(String un1,String ps1) {
			uname.sendKeys(un1);
			passlogin.sendKeys(ps1);
			signinButton.click();
			return emsg.getText();
		}
		public String blankcredentials(String un2,String ps2) {
			uname.sendKeys(un2);
			passlogin.sendKeys(ps2);
			signinButton.click();
			return emsg.getText();
		}
		public String blankpasscredentials(String un3, String ps3) {
			uname.sendKeys(un3);
			passlogin.sendKeys(ps3);
			signinButton.click();
			return emsg.getText();
		}
		public String blenkuncredentials(String un4,String ps4) {
			uname.sendKeys(un4);
			passlogin.sendKeys(ps4);
			signinButton.click();
			return emsg.getText();
		}
		public HomePage logincredientials(String un, String ps) {
			uname.sendKeys(un);
			passlogin.sendKeys(ps);
			signinButton.click();
			return new HomePage();
		}
}
