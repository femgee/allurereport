package allureReports;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class localTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void instance() {
		BaseClass bs = new BaseClass();
		driver = bs.initialize_driver();
	}
	
	//@AfterTest
	public void teardown() {
		driver.quit();
	}//

	@Test
	public void test1() {
		
		driver.get("http://www.hrjconsulting.eu/");
	}
}
