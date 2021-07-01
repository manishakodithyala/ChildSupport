package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnrollmentRequestsPage {
	
	public WebDriver driver;
	By newIcon = By.cssSelector("a[title='New']");
	By requestReceivedChannel = By.xpath("//input[@name='Request Received Channel']/ancestor::div[2]");
	By receiveChannelOptions = By.cssSelector("div[class*='customReceivedChannel'] > lightning-combobox > div > lightning-base-combobox > div > div[role='listbox'] > lightning-base-combobox-item");
	By enrollRequestPageSaveBtn = By.xpath("//button[text()='Save']");
	
	public EnrollmentRequestsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getNewIcon() {
		return driver.findElement(newIcon);
	}
	
	public void selectRequestReceivedChannel() {
		driver.findElement(requestReceivedChannel).click();
//		driver.findElement(requestReceivedChannel).sendKeys("Mail");
		List<WebElement> options = driver.findElements(By.cssSelector("div > lightning-base-combobox-item"));
		System.out.println("Channel options size = " + options.size());
//		
//		WebElement mail = driver.findElement(By.cssSelector("lightning-base-combobox-item[data-value='Mail']"));
//		JavascriptExecutor js = (JavascriptExecutor)driver;
////		List<WebElement> options2 = js.executeScript("arguments[0].click();", driver.findElements(receiveChannelOptions));
//		js.executeScript("arguments[0].click();", mail);
		for(WebElement option : options) {
			if(option.getAttribute("data-value").equals("Phone")) {
				System.out.println(option.getAttribute("data-value"));
				option.click();
				break;
			}
		}
	}
	
	public WebElement enrollRequestSaveBtn() {
		return driver.findElement(enrollRequestPageSaveBtn);
	}

}
