/**
 * 
 */
package allureReports;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

/**
 * @author Femi
 * @version 001
 * 
 *
 */
public class Contact {

	WebDriver driver;

	@BeforeClass
	public void setupinstance() {
		BaseClass bs = new BaseClass();
		driver = bs.initialize_driver();
		driver.get("https://demo.nopcommerce.com");
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 2)
	@Description("Verify that user can send enquiry by clicking Contact Us on the Sitemap")
	@Epic("Epic004")
	@Feature("Feature: Contact Us")
	@Story("Story: Contact Us")
	@Step("Verify that user can send enquiry")
	@Severity(SeverityLevel.NORMAL)
	public void verifycontactus() {

		// script to scroll down to Contact Us section
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,2400)");
		WebElement Contact = driver.findElement(By.xpath("//a[contains(text(),'Contact us')]"));
		Contact.click();

		// enter contact name details
		WebElement name = driver.findElement(By.id("FullName"));
		name.sendKeys("Tester123");

		// enter email address
		WebElement email = driver.findElement(By.id("Email"));
		email.sendKeys("femgee2009@gmail.com");

		// enter enquiry details
		WebElement enq = driver.findElement(By.id("Enquiry"));
		enq.sendKeys("We are carrying out testing on this platform, please do not be alarmed");

		driver.findElement(By.name("send-email")).click();

	}
}
