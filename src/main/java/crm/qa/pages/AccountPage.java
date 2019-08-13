package crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import crm.testbase.TestBase;

public class AccountPage extends TestBase{
	@FindBy(xpath="//a[@href=\"/projects/x2crm/index.php/accounts/create\"]")
	WebElement createAcc;
	
	
	
	public CreateAccountPage clickonCreateAccount() {
		createAcc.click();
		return new CreateAccountPage();
	}
}
