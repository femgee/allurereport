package allureReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class Test1 extends BaseClass {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		BaseClass bs= new BaseClass();
		driver = bs.initialize_driver();
		driver.get("https://demo.nopcommerce.com/");
		
	}

	@Test(priority = 1, description = "Verify logo presence on Home Page")
	@Description("Verify logo precense on Home Page ------- ")
	@Epic("Epic001")
	@Feature("Feature1: Login")
	@Story("Story: Login")
	@Step("Verify Login")
	@Severity(SeverityLevel.BLOCKER)
	public void logoPresence() {

		boolean disstatus = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]")).isDisplayed();
		Assert.assertEquals(disstatus, true);
	}

	@Test(priority = 2, description = "verify login feature works")
	@Description("Verify Login")
	@Epic("Epic001")
	@Feature("Feature2: Login")
	@Story("Story: Valid Login")
	@Step("Verify Login ")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest() {

		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("femgee2009@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Tester123");
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/input"))
				.click();

		Assert.assertEquals(driver.getTitle(), "nopCommerce demore store");

	}

	@Test(priority = 3, description = "Verify that user can register")
	@Description("Verify registration")
	@Epic("Epic001")
	@Feature("Feature3: Verify Registration")
	@Story("Story: Verify Login")
	@Step("Registration")
	@Severity(SeverityLevel.CRITICAL)
	public void registrationTest() {
		throw new SkipException("Skipping this test");
	}

	@AfterClass
	public void teardown() {
		driver.quit();

	}

}
