package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	public WebDriver driver;
	
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void clickOnGivenNavBarDropDown(String navBarName) throws InterruptedException  {
		Thread.sleep(5000);
//		WebElement searchBox = driver.findElement(By.cssSelector("input.uiInput.uiInputTextForAutocomplete"));
//		searchBox.sendKeys("Testing");
		WebElement enrollmentRequests = driver.findElement(By.xpath("//a[@title='Enrollment Requests']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", enrollmentRequests);

		
//		List<WebElement> navBarIcons = driver.findElements(By.cssSelector("one-app-nav-bar > nav > div > one-app-nav-bar-item-root"));
//		System.out.println("Nav Bar Icons Size = " +navBarIcons.size() );
//		for(WebElement menu : navBarIcons) {
//			WebElement tabName = menu.findElement(By.tagName("a"));
//			WebElement dropDownIcon = menu.findElement(By.cssSelector("one-app-nav-bar-item-dropdown > div one-app-nav-bar-menu-button > a"));
//			System.out.println(tabName.getAttribute("title"));
//			if(tabName.getAttribute("title").equals(navBarName)) {
//				dropDownIcon.click();
//				break;
//			}
//		}
	}
}
