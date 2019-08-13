package crm.qa.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.testbase.TestBase;

public class AllAccountPage extends TestBase{

	@FindBy(xpath="//a[@title=\"Columns\"]")
	WebElement cl;
	@FindBy(xpath="//table/thead/tr[2]/td//input[@name=\"Accounts[name]\"]")
	WebElement name;
	
//	@FindBy(name="accountsgridcolumns[]")
//	WebElement checkboxes;
	
	public AllAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickoncolums() {
		cl.click();
	}
	
	public void selectcheckbox() {
		List<WebElement> oCkeckBox=driver.findElements(By.name("accountsgridcolumns[]"));
		int isize=oCkeckBox.size();
		System.out.println(isize);
		boolean bvalue;
		for(int i=0;i<isize;i++) {
			
			String svalues=((WebElement) oCkeckBox.get(i)).getAttribute("value");
			if(svalues.equalsIgnoreCase("address")) {
				
//				bvalue=oCkeckBox.get(i).isEnabled();
//				if(bvalue=true) {
//					break;
//				}else {
//					oCkeckBox.get(i).click();
//				}
				oCkeckBox.get(i).click();
			}
				if(svalues.equalsIgnoreCase("city")) {
//					//boolean bvalue=false;
//					bvalue=oCkeckBox.get(i).isSelected();
//					if(bvalue=true) {
//						break;
//					}else {
//						oCkeckBox.get(i).click();
//					}
				oCkeckBox.get(i).click();
//					
//			
		}
				if(svalues.equalsIgnoreCase("country")) {
//					bvalue=oCkeckBox.get(i).isSelected();
//					if(bvalue=true) {
//						break;
//					}else {
//						oCkeckBox.get(6).click();
//					}
					oCkeckBox.get(i).click();
					break;	
			}
//				
					
	}
		
	}
	public void addData(String nm) {
		

		name.sendKeys(nm);
//		type.sendKeys(ty);
//		revenue.sendKeys(rvn);
//		phone.sendKeys(ph);
//		Lastupdate.sendKeys(lastupd);
//		addcity.sendKeys(cy);
//		addcity.sendKeys(cntry);
	}
	

}
