package allureReports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class Test1 {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	}

	@Test(priority = 1, description = "Verify logo presence on Home Page")
	@Description("Verify logo precense on Home Page ------- ")
	@Epic("Epic001")
	@Feature("Feature1: Verify the Logo")
	@Story("Story: logoPresence")
	@Step("Verify logo Presence")
	@Severity(SeverityLevel.MINOR)
	public void logoPresence() {

		boolean disstatus = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]")).isDisplayed();
		Assert.assertEquals(disstatus, true);
	}

	@Description("Verify")
	@Epic("Epic002")
	@Feature("Feature1: Verify the")
	@Story("Story: ")
	@Step("Verify ")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 2, description = "Verify")
	public void loginTest() {

		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("femgee2009@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Tester123");
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/input"))
				.click();

		Assert.assertEquals(driver.getTitle(), "nopCommerce demore store");

	}

	@Description("Verify")
	@Epic("Epic002")
	@Feature("Feature1: Verify the")
	@Story("Story: ")
	@Step("Verify ")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1)
	public void registrationTest() {

		throw new SkipException("Skipping this test");
	}

	@AfterClass
	public void teardown() {
		driver.quit();

	}

}
