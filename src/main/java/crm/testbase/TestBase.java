package crm.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import crm.qa.listeners.WebEventListener;
import crm.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log;
	public static WebEventListener eventListener;
	public static EventFiringWebDriver edriver;
	public TestBase() {
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream("C:\\Users\\Public\\CRMx2crm\\src\\main\\java\\crm\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public static void initialization() {
		log=Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Pavan\\Downloads\\chromedriver.exe");
			 driver=new ChromeDriver();
		}
			 else if(browsername.equals("Firefox")) {
				 System.setProperty("webdriver.gecko.driver","C:\\Users\\Pavan\\Downloads\\gecko\\geckodriver.exe");
				 driver=new FirefoxDriver();
}
		edriver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
		edriver.register(eventListener);
		driver=edriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOuts, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
}
