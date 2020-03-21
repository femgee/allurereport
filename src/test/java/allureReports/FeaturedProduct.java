/**
 * 
 */
package allureReports;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Femi
 *
 */
public class FeaturedProduct {

	WebDriver driver;

	@BeforeClass
	public void setupinstance() {
		BaseClass bs = new BaseClass();
		driver = bs.initialize_driver();
		driver.get("https://demo.nopcommerce.com");

	}

	/*
	 * @AfterTest public void teardown() { driver.quit(); }
	 */

	@Test
	public void NavigateToFeaturedProduct() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]"));
		// script to scroll down to Featured Product section
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1200)");

		WebElement HTCOne = driver.findElement(By.xpath(
				"/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/input[1]"));
		HTCOne.click();
		Thread.sleep(3000);
		//script to scroll up 
		JavascriptExecutor up = (JavascriptExecutor)driver;
		up.executeScript("scroll(0, -250);");
		
		driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/span")).click();
		WebElement cartbutton = driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]"));
		new Actions(driver).moveToElement(cartbutton).perform();
	}
}
