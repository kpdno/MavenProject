package pomBandLab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// The list of locators using By object
	private By usernameBox = By.id("username");
	private By passwordBox = By.id("password");
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Actions
	public void insertUserName(String username) {
		driver.findElement(usernameBox).sendKeys(username);
	}

	public void insertUserPassword(String password) {
		driver.findElement(passwordBox).sendKeys(password);
	}

	
	
	

}
