package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankLoginPage {

	private WebDriver driver;
	
	//The list of locators using By object
	private By usernameBox = By.name("username");
	private By passwordBox = By.name("password");
	private By loginBtn = By.cssSelector("input[value='Log In']");
	
	public BankLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Actions 
	public void insertUserName(String username){
		driver.findElement(usernameBox).sendKeys(username);
	}
	
	public void insertUserPassword(String password) {
		driver.findElement(passwordBox).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}
}
