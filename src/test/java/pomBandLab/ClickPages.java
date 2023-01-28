package pomBandLab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickPages {
	
	private WebDriver driver;
	
	// The list of locators using By object
//	private By loginBtn = By.cssSelector("input[value='Log In']");
	private By loginBtn = By.xpath("//button[text()='Войти']");
	private By HomeLoginButton = By.cssSelector("a[analytics-label = 'Log In'][ui-sref = 'login']");
	private By NewProject = By.cssSelector(".project-tile-title-name[title = 'New Project']");
	private By PlayButton = By.cssSelector(".player-button-64");
	
	
	//Actions 
	public ClickPages(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}
	
	public void clickHomeLoginButton() {
		driver.findElement(HomeLoginButton).click();
	}
	
	public void clickNewProject() {
		driver.findElement(NewProject).click();
	}
	
	public void clickPlayButton() {
		driver.findElement(PlayButton).click();
	}

}
