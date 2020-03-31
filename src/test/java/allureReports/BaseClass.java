package allureReports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.edge.EdgeDriver;//
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	public WebDriver initialize_driver() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		 //driver.manage().window().setSize(new Dimension(375, 667);//
		// driver.manage().window().setSize(new Dimension(1084, 768));//
		tdriver.set(driver);
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}

}
