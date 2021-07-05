package pageObjects;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import resources.base;

public class EnrollmentRequestsPage {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	By newIcon = By.cssSelector("a[title='New']");
	By requestReceivedChannel = By.xpath("//input[@name='Request Received Channel']/ancestor::div[2]");
	By divBox = By.xpath("//input[@name='Request Received Channel']/ancestor::div[2]//div[2]");
	By receiveChannelOptions = By.cssSelector("//input[@name='Request Received Channel']/ancestor::div[2]//div[2]// lightning-base-combobox-item");
	By requestResponseType = By.xpath("//input[@name='Request Response Type']/ancestor::div[2]");
	By isRequestorCustodialParty = By.xpath("//input[@name='Is the Requestor the Custodial Party?']/ancestor::div[2]");
	By requestorMemberType = By.xpath("//input[@name='Member Type']/ancestor::div[2]");
	By requestorFirstName = By.xpath("//label[text()='Requestor’s First Name']/following-sibling::div//input");
	By requestorLastName = By.xpath("//label[text()='Requestor’s Last Name']/following-sibling::div//input");
	By preferredMethodOfCommunication = By.xpath("//input[@name='Preferred Method of Communication']/ancestor::div[2]");
	By phoneNumberType = By.xpath("//input[@name='Phone Number Type']/ancestor::div[2]");
	By phoneNumber = By.xpath("//label[text()='Applicant Contact Phone Number']/following-sibling::div//input");
	By addressType = By.xpath("//input[@name='Type__c']/ancestor::div[2]");
	By address = By.xpath("//input[@name='ADDR_LINE1__c']");
	By city = By.xpath("//input[@name='ADDR_CITY__c']");
	By state = By.xpath("//input[@name='State__c']/ancestor::div[2]");
	By zip = By.xpath("//input[@name='ADDR_ZIP4__c']");
	By arrowToMoveDocsToChosen = By.xpath("//button[@title='Move selection to Chosen']");
	By assignsToBox = By.xpath("//input[@placeholder='Search People...']");
	By personNameInSearchResults = By.xpath("//input[@placeholder='Search People...']/ancestor::div[1]/following-sibling::div[1]//ul//li//lightning-base-combobox-item");
	By enrollRequestPageSaveBtn = By.xpath("//button[text()='Save']");
	By proceedToCaseIntake = By.xpath("//button[text()='Proceed to Case Intake']");
	By alertPopup = By.cssSelector("div.toastContainer.slds-notify_container.slds-is-relative");
	public EnrollmentRequestsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getNewIcon() {
		return driver.findElement(newIcon);
	}
	
	public void selectRequestReceivedChannel(String reqReceivedChannelName) throws InterruptedException {
		driver.findElement(requestReceivedChannel).click();
		Thread.sleep(5000);
		List<WebElement> options = driver.findElements(By.xpath("//input[@name='Request Received Channel']/ancestor::div[2]//div[2]// lightning-base-combobox-item"));
		System.out.println("Channel options size = " + options.size());
		for(WebElement option : options) {
			if(option.getAttribute("data-value").equals(reqReceivedChannelName)) {
				System.out.println(option.getAttribute("data-value"));
				option.click();
				break;
			}
		}
	}
	
	public void selectRequestorDetails(String responseType, String isCustodialParty, String memberType, String firstName, String lastName) throws InterruptedException {
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//span[text()='Requestor Information']")));
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		driver.findElement(requestResponseType).click();
		Thread.sleep(3000);
		List<WebElement> responseOptions = driver.findElements(By.xpath("//input[@name='Request Response Type']/ancestor::div[2]//div[2]// lightning-base-combobox-item"));
		for(WebElement option : responseOptions) {
			if(option.getAttribute("data-value").equals(responseType)) {
				option.click();
				log.info("Selected Request Response Type as : " +responseType);
				break;
			}
		}
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", isRequestorCustodialParty);
		driver.findElement(isRequestorCustodialParty).click();
		Thread.sleep(3000);
		List<WebElement> custodialPartyOptions = driver.findElements(By.xpath("//input[@name='Is the Requestor the Custodial Party?']/ancestor::div[2]//div[2]// lightning-base-combobox-item"));
		for(WebElement option : custodialPartyOptions) {
			if(option.getAttribute("data-value").equals(isCustodialParty)) {
				option.click();
				log.info("Selected Custodial Party as : " +isCustodialParty);
				break;
			}
		}
		driver.findElement(requestorMemberType).click();
		Thread.sleep(3000);
		List<WebElement> memberTypeOptions = driver.findElements(By.xpath("//input[@name='Member Type']/ancestor::div[2]//div[2]// lightning-base-combobox-item"));
		for(WebElement option : memberTypeOptions) {
			if(option.getAttribute("data-value").equals(memberType)) {
				option.click();
				log.info("Selected Member Party as : " +memberType);
				break;
			}
		}
		driver.findElement(requestorFirstName).sendKeys(firstName);
		driver.findElement(requestorLastName).sendKeys(lastName);
		
	}
	
	public void selectRequestorAddressDetails(String addrType, String addr, String cityName, String stateName, String zipCode) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)");
		driver.findElement(addressType).click();
		Thread.sleep(3000);
		List<WebElement> addressOptions = driver.findElements(By.xpath("//input[@name='Type__c']/ancestor::div[2]//div[2]// lightning-base-combobox-item"));
		for(WebElement option : addressOptions) {
			if(option.getAttribute("data-value").equals(addrType)) {
				option.click();
				log.info("Selected Address type as : " +addrType);
				break;
			}
		}
		driver.findElement(address).sendKeys(addr);
		driver.findElement(city).sendKeys(cityName);
		driver.findElement(state).click();
		Thread.sleep(3000);
		List<WebElement> stateOptions = driver.findElements(By.xpath("//input[@name='State__c']/ancestor::div[2]//div[2]// lightning-base-combobox-item"));
		for(WebElement option : stateOptions) {
			if(option.getAttribute("data-value").equals(stateName)) {
				option.click();
				log.info("Selected State as : " +stateName);
				break;
			}
		}
		driver.findElement(zip).sendKeys(zipCode);
		
		
	}
	
	public void selectContactDetails(String methodOfCommunication, String phoneNoType, String phoneNum) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400)");
		driver.findElement(preferredMethodOfCommunication).click();
		Thread.sleep(3000);
		List<WebElement> communicationMethodOptions = driver.findElements(By.xpath("//input[@name='Preferred Method of Communication']/ancestor::div[2]//div[2]// lightning-base-combobox-item"));
		for(WebElement option : communicationMethodOptions) {
			if(option.getAttribute("data-value").equals(methodOfCommunication)) {
				option.click();
				log.info("Selected preferred method of communication as : " +methodOfCommunication);
				break;
			}
		}
		driver.findElement(phoneNumberType).click();
		Thread.sleep(3000);
		List<WebElement> phoneNumTypeOptions = driver.findElements(By.xpath("//input[@name='Phone Number Type']/ancestor::div[2]//div[2]// lightning-base-combobox-item"));
		for(WebElement option : phoneNumTypeOptions) {
			if(option.getAttribute("data-value").equals(phoneNoType)) {
				option.click();
				log.info("Selected phone number type as : " +phoneNoType);
				break;
			}
		}
		driver.findElement(phoneNumber).sendKeys(phoneNum);
		
	}
	
	public void selectRequestResponseDocs(String docs) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400)");
		String[] givenDocs = docs.split(",");
		List<WebElement> availableDocs = driver.findElements(By.xpath("//span[text()='Available']/ancestor::div[1]//div[@class='slds-dueling-list__options']//ul//li//div"));
		int count = 0;
		for(WebElement doc : availableDocs) {
			if(Arrays.asList(givenDocs).contains(doc.getAttribute("data-value").trim())) {
				doc.click();
				driver.findElement(arrowToMoveDocsToChosen).click();
				count += 1;
				if(count == givenDocs.length) {
					break;
				}
			}
		}
		log.info("Added all specified request response documents");
		
	}
	
	public void assignRequestTo(String personName) throws InterruptedException {
		driver.findElement(assignsToBox).sendKeys(personName);
		Thread.sleep(2000);
		driver.findElement(personNameInSearchResults).click();
		log.info("Request Assigned to " + personName + " successfully");
	}
	
	
	public WebElement enrollRequestSaveBtn() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)");
		return driver.findElement(enrollRequestPageSaveBtn);
	}
	
	public WebElement proceedToIntakeBtn() throws InterruptedException {
		Assert.assertTrue(driver.findElement(alertPopup).isDisplayed());
		Thread.sleep(2000);
		return driver.findElement(proceedToCaseIntake);
	}
}
