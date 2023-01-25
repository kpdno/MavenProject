package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class SwagLabApp {
	
	WebDriver driver;
	
	@Given("Login page is open")
	public void login_page_is_open() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
	}

	@When("User inserts valid credentials and clicks login")
	public void user_inserts_valid_credentials_and_clicks_login() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
	}

	@Then("User logs in and home page should open")
	public void user_logs_in_and_home_page_should_open() {
//		Assert.assertTrue(driver.findElement(By.id("add-to-cart-sauce-labs-backpack")));
	}

}
