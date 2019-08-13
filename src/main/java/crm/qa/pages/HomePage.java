package crm.qa.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import crm.testbase.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//li//a[contains(@href,'accounts')]")
	WebElement Acc;
	
	@FindBy(xpath="//a[@href=\"/projects/x2crm/index.php/marketing/index\"]")
	WebElement Marketing;
	
	
//	public static void findChild() {
//		List<WebElement> ArrObj=driver.findElements(By.xpath("//li//a[contains(@href,'accounts')]"));
//		System.out.println("size of element"+ArrObj.size());
//	}
//	

	public HomePage() {
		PageFactory.initElements(driver, this);
		}


public AccountPage clickonAccount() {
	Acc.click();
	return new AccountPage();
	
	}
public String verifyHomePageTitle() {
	return driver.getTitle();
}
public MarketingPage clickonMarketing() {
	Marketing.click();
	return new MarketingPage();
}
}
