package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.EnrollmentRequestsPage;
import pageObjects.HomePage;
import pageObjects.loginPage;
import resources.base;

@SuppressWarnings("deprecation")
public class loginPageSteps extends base {
	

	@Given("^Initialized the browser with chrome$")
	public void initialized_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = initializeDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String url) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(url);
	}

	@When("^User enter \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
	public void user_enter_and_and_logs_in(String userName, String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		loginPage l = new loginPage(driver);
		l.getUsername().sendKeys(userName);
		l.getPassword().sendKeys(password);
		l.getLoginBtn().click();
	}

	@Then("^User should be able to successfully login$")
	public void user_should_be_able_to_successfully_login() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//		WebDriverWait w = new WebDriverWait(driver, 500000); 
//		w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div.desktop.container> div.viewport > section > div.none.navexStandardManager > div.slds-no-print.oneAppNavContainer")));
		Thread.sleep(30000);
		loginPage l = new loginPage(driver);
	    Assert.assertEquals("User is not in home page", "Home | Salesforce", l.homePageTitle());
	}
	
	@Then("^Close browser$")
	public void closeBrowser() {
		driver.close();
	}
	
	@Given("^User clicks on (.*) tab$")
	public void clickOnEnrollmentRequestsTab(String tabName) throws InterruptedException {
		HomePage h = new HomePage(driver);
		h.clickOnGivenNavBarDropDown(tabName);
	}
	
	@Given("^User selects New Enrollment Request option$")
	public void clickOnNewEnrollmentRequest()
	{
		EnrollmentRequestsPage er = new EnrollmentRequestsPage(driver);
		er.getNewIcon().click();
	}
	
	@When("^User enters all the mandatory fields$")
	public void enterAllRequiredFields() {
		EnrollmentRequestsPage er = new EnrollmentRequestsPage(driver);
		er.selectRequestReceivedChannel();
	}
	
	@When("^Clicks on Save button$")
	public void clickOnSaveBtn()
	{
		
	}
	
	@Then("^New Enrollment Request should be created successfully$")
	public void isEnrollmentReqCreated() {
		
	}

}
