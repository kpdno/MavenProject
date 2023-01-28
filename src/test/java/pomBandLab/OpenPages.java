package pomBandLab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenPages {

	private WebDriver driver;

	// The list of locators using By object
	private By HomeBandLabPage = By.cssSelector("a[analytics-label = 'Sign Up'][ui-sref = 'signUp']:nth-of-type(1)");
	private By LoginPage = By.cssSelector("label[for= 'username']");
	private By HomePageIn = By.cssSelector("ng-pluralize-html[count = 'vm.user.counters.followers']:nth-of-type(1)");
	private By NewProject = By.cssSelector("h1[class = 'revision-page-player-title-h1 text-truncate']");
	private By MusicPlay = By.tagName("span");

	public OpenPages(WebDriver driver) {
		this.driver = driver;
	}

	// Actions
	public String getBandLabHomePage() throws InterruptedException {
		Thread.sleep(2000);
		return driver.findElement(HomeBandLabPage).getText();
	}

	public String getLoginPage() {
		return driver.findElement(LoginPage).getText();
	}

	public String getHomePageIn() {
		return driver.findElement(HomePageIn).getText();
	}

	public String getNewProject() {
		return driver.findElement(NewProject).getText();
	}

	public WebElement getMusicPlay() {
		return driver.findElement(MusicPlay);
	}
}
