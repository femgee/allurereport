package allureReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

public class AddProductsToCartandCheckout {

	WebDriver driver;

	@BeforeClass
	public void setupinstance() {

		BaseClass bs = new BaseClass();
		driver = bs.initialize_driver();
		driver.get("https://demo.nopcommerce.com/notebooks");
	}
	
	//
	@AfterTest
	public void teardown() {
		driver.quit();
	}//

	@Test(priority = 3)
	@Description("Verify that user can add product into cart")
	@Epic("Epic003")
	@Feature("Feature3: Add product")
	@Story("Story: Add to cart")
	@Step("Verify Add to cart")
	@Severity(SeverityLevel.CRITICAL)

	public void addProducttocart() throws InterruptedException {

		WebElement prod = driver.findElement(By.linkText("Apple MacBook Pro 13-inch"));
		prod.click(); // navigating to MacBook Pro main details page

		WebElement qty = driver.findElement(By.xpath("//*[@id=\"addtocart_4_EnteredQuantity\"]"));
		qty.sendKeys("1"); // add quality of products

		WebElement CartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-4\"]"));
		CartButton.click(); // Add to cart

		WebElement menu = driver
				.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[4]/a/span[1]"));
		new Actions(driver).moveToElement(menu).perform();
		Thread.sleep(3000);

		WebElement btn = driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p/a"));
		btn.click();

		WebElement gift = driver.findElement(By.xpath("//*[@id=\"checkout_attribute_1\"]"));
		gift.sendKeys("Yes");

		// Estimate shipping cost//
		new Select(driver.findElement(By.id("CountryId"))).selectByValue("1");
		Thread.sleep(3000);
		new Select(driver.findElement(By.xpath("//*[@id=\"StateProvinceId\"]"))).selectByValue("40");

		WebElement zip = driver.findElement(By.id("ZipPostalCode"));
		zip.sendKeys("3004");

		WebElement button = driver.findElement(By.xpath("//*[@id=\"estimate-shipping-button\"]"));
		button.click();
		System.out.println("Estimate Shipping should be displayed underneath this section");

		// click the checkout button
		driver.findElement(By.xpath("//*[@id=\"termsofservice\"]")).click();
		driver.findElement(By.id("checkout")).click();
	}

}
