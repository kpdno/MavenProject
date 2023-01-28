package lesson22;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class ExplicitWait {

	String url = "https://demo.applitools.com/";
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Implicit wait waits for certain time before throwing "No Such Element
		// Exception"
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	// @Given
	public void alertTest() {

		driver.get(url);

		driver.findElement(By.id("alert")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());

		driver.switchTo().alert().accept();

	}

	// @Test
	public void textChange() {

		driver.get(url);

		driver.findElement(By.id("populate-text")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.textToBe(By.id("h2"), "Selenium Webdriver"));

		String text = driver.findElement(By.id("h2")).getText();

		System.out.println(text);
	}

	// @Test
	public void enabledButton() {

		driver.get(url);

		driver.findElement(By.id("display-other-button")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("hidden")));

		driver.findElement(By.id("hidden")).click();
	}

	// @Test
	public void elementSelected() {

		driver.get(url);

		driver.findElement(By.id("checkbox")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeSelected(By.id("ch")));

		Assert.assertTrue(driver.findElement(By.id("ch")).isSelected());
	}

}