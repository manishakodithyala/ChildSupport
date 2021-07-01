package Automation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.loginPage;
import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void setUp() throws IOException {
		driver = initializeDriver();
		log.info("driver initialized successfully");
		driver.get(prop.getProperty("url"));
		log.info("Application opened");
	}
	
	@Test
	public void basePage() throws IOException {
		
		loginPage l = new loginPage(driver);
		l.getUsername().sendKeys("komanisha@deloitte.com.usist");
		l.getPassword().sendKeys("M@ni$h@08");
		l.getLoginBtn().click();
		log.info("Entered login credentials and clicked on login button");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
