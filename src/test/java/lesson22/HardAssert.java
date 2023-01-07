package lesson22;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssert {

	String url = "https://courses.letskodeit.com/practice";
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver2.exe");
		driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(-1800, 100));
		driver.manage().window().maximize();

//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	// @Test
	public void test1() throws InterruptedException {

		driver.get(url);

		driver.findElement(By.id("bmwcheck")).click();

		// Hard Assert (Assert class)
		Assert.assertEquals(10, 10, "Comparing 5 and 10 "); // fail here
		Assert.assertNotEquals("abc", "abcd", "Comparing abc values");
		Assert.assertTrue(5 > 4, "5 is greater than 65");
		Assert.assertFalse(5 > 65);
		Assert.assertFalse(driver.findElement(By.id("bmwcheck")).isSelected(), "Is BMW checkbox selected");

	}

	@Test
	public void test2() throws InterruptedException {

		driver.get(url);

		driver.findElement(By.id("bmwcheck")).click();

		// Soft Assert (SoftAssert class)
		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals(5, 10, "Comparing 5 and 10 "); // fail here
		softAssert.assertNotEquals("abc", "abc", "Comparing abc values");
		Assert.assertTrue(5 > 45, "5 is greater than 65");
		softAssert.assertFalse(5 > 65);
		softAssert.assertFalse(driver.findElement(By.id("bmwcheck")).isSelected(), "Is BMW checkbox selected");

		softAssert.assertAll();
	}

}