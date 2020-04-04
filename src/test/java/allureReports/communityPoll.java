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

/**
 * @author Femi
 * @version 01.
 * @category Community Poll
 */

public class communityPoll {

	WebDriver driver;

	@BeforeClass
	public void setupinstance() {
		BaseClass bs = new BaseClass();
		driver = bs.initialize_driver();

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

	@Test
	public void Unregisteredusercannotvoteforcommunity() throws InterruptedException {
		driver.navigate().to("https://demo.nopcommerce.com/");
		driver.manage().deleteAllCookies();

		// to perform scroll to the Community Poll section
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2300)");

		driver.findElement(By.xpath("//*[@id=\"pollanswers-2\"]")).click();
		driver.findElement(By.xpath("//input[@id='vote-poll-1']")).click();
		System.out.println("Only registered users can vote.");

		// script to scroll up to the top page
		JavascriptExecutor up = (JavascriptExecutor) driver;
		up.executeScript("scroll(0, -250);");

		// click on Log in at the top page
		driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();

		Thread.sleep(700);
		WebElement email = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		email.sendKeys("femgee2009@gmail.com");

		Thread.sleep(700);
		WebElement pass = driver.findElement(By.id("Password"));
		pass.sendKeys("Lakintec");

		driver.findElement(By.cssSelector(
				"div.master-wrapper-page:nth-child(6) div.master-wrapper-content div.master-column-wrapper div.center-1 div.page.login-page div.page-body div.customer-blocks div.returning-wrapper.fieldset form:nth-child(1) div.buttons:nth-child(3) > input.button-1.login-button"))
				.click();
	}

}
