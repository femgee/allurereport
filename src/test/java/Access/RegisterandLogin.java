package Access;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class RegisterandLogin {

	WebDriver driver;

	@BeforeClass
	public void setupinstance() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fregister%3FreturnUrl%3D%252F");
		driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
	}

	@Test
	public void registrationTest() {
		// select gender option
		WebElement gender = driver.findElement(By.id("gender-male"));
		gender.click();

		// enter first name
		WebElement first = driver.findElement(By.id("FirstName"));
		first.sendKeys("Testerg");

		// enter second name
		WebElement second = driver.findElement(By.id("LastName"));
		second.sendKeys("Testino1234");

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
