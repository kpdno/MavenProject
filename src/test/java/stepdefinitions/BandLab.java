package stepdefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pomBandLab.ClickPages;
import pomBandLab.LoginPage;
import pomBandLab.OpenPages;

public class BandLab {

	WebDriver driver;

	LoginPage LoginPage;
	ClickPages ClickPages;
	OpenPages OpenPages;
	Properties prop;

	@Given("^Initilize diver$")
	public void initilize_diver() {

		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream("src\\test\\java\\resources\\BandLabApp.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String browser = prop.getProperty("browser");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\webdrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		LoginPage = new LoginPage(driver);
		ClickPages = new ClickPages(driver);
		OpenPages = new OpenPages(driver);

	}

	@And("^Maximize the browser$")
	public void maximize_the_browser() {
		driver.manage().window().maximize();
	}

	@And("^Initilize url$")
	public void initilize_url() {
		driver.get(prop.getProperty("url"));
//		driver.get("https://www.bandlab.com/");
	}

	@And("^Set wait duration$")
	public void set_wait_duration() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	@Given("^BandLab page is open$")
	public void bandlab_page_is_open() throws InterruptedException {
		String HomeBandLab = OpenPages.getBandLabHomePage();
		Assert.assertEquals(HomeBandLab, "Зарегистрироваться", "BandLab Page should open");
	}

	@When("^User clicks the login button$")
	public void user_clicks_the_login_button() {
		ClickPages.clickHomeLoginButton();
	}

	@And("^Login Page is open$")
	public void login_page_is_open() {
		String loginPageTitle = OpenPages.getLoginPage();
		Assert.assertEquals(loginPageTitle, "Имя пользователя или email", "Login page is open");
	}

	@When("^User inserts valid credentials$")
	public void user_inserts_valid_credentials() {
		LoginPage.insertUserName(prop.getProperty("username"));
		LoginPage.insertUserPassword(prop.getProperty("password"));
	}

	@And("^clicks login$")
	public void clicks_login() {
		ClickPages.clickLogin();
	}

	@Then("^Home page should open$")
	public void home_page_should_open() {
		String homePageTitle = OpenPages.getHomePageIn();
		Assert.assertEquals(homePageTitle, "Подписчиков", "Home page should open");
	}

	@Then("^User opens New Project$")
	public void user_opens_new_project() {
		ClickPages.clickNewProject();
	}

	@And("^New Project should open$")
	public void new_project_should_open() {
		String newProjectPage = OpenPages.getNewProject();
		Assert.assertEquals(newProjectPage, "New Project", "New Project Page should open");
	}

	@Then("^User click play button$")
	public void user_click_play_button() {
		ClickPages.clickPlayButton();
	}

	@And("^The music should play$")
	public void the_music_should_play() {
		WebElement audio = OpenPages.getMusicPlay();
		Assert.assertNotEquals(audio.getAttribute("currentTime"), "0");
	}

	@Given("^Check BandLab page is open$")
	public void check_bandlab_page_is_open() throws InterruptedException {
		Thread.sleep(5000);
		String BandLabPageOpen = driver
				.findElement(By.cssSelector("a[analytics-label = 'Sign Up'][ui-sref = 'signUp']:nth-of-type(1)"))
				.getText();
		Assert.assertEquals(BandLabPageOpen, "Зарегистрироваться", "BandLab Page should open");
	}

	@When("^User clicks login button$")
	public void user_clicks_login_button() {
		driver.findElement(By.cssSelector("a[analytics-label = 'Log In'][ui-sref = 'login']")).click();
	}

	@And("^LogIn Page is opens$")
	public void login_page_is_opens() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String loginPageTitle = driver.findElement(By.cssSelector("label[for= 'username']")).getText();
		Assert.assertEquals(loginPageTitle, "Имя пользователя или email", "Login page is open");
	}

	@When("^User inserts valid (.+) and (.+)$")
	public void user_inserts_valid_and(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@And("^The User Clicks login$")
	public void the_user_clicks_login() {
		driver.findElement(By.cssSelector(".button-dark.button-height-40.button-rounded.button-padding-fill")).click();
	}

	@Then("^The User Opens Library$")
	public void the_user_opens_library() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Библиотека'][1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()=' New Project '][1]")).click();
	}

	@Then("^The User click play button$")
	public void the_user_click_play_button() {
		driver.findElement(By.cssSelector(".player-button-64")).click();
	}

	@And("^Music should play$")
	public void music_should_play() {
		WebElement audio = driver.findElement(By.tagName("span"));
		Assert.assertNotEquals(audio.getAttribute("currentTime"), "0");
	}

}
