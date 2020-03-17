package Access;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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

		driver.findElement(By.id("gender-male")).click();// selected gender as male
		driver.findElement(By.id("FirstName")).sendKeys("Testerg"); // entered firstname script
		driver.findElement(By.id("LastName")).sendKeys("Testino1234"); // entered lastname script
		Select day = new Select(driver.findElement(By.name("DateOfBirthDay")));
		day.selectByValue("6"); // selected day of birth
		Select month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		month.selectByVisibleText("June"); // selected month of biryh
		Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));
		year.selectByValue("1978"); // selected year of birth
		driver.findElement(By.id("Email")).sendKeys("femgee2009@gmail.com"); // entered year of birth

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
