package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.en.*;

public class BandLab {

	String username = "master_73_97@bk.ru";
	String password = "admin12345";

	WebDriver driver;

	@Given("^Initilize diver$")
	public void initilize_diver() {
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");

	}

	@And("^Disable notifications$")
	public void disable_notifications() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
	}

	@And("^Maximize the browser$")
	public void maximize_the_browser() {
		driver.manage().window().maximize();
	}

	@And("^Initilize url$")
	public void initilize_url() {
		driver.get("https://www.bandlab.com/");
	}

	@And("^Set wait duration$")
	public void set_wait_duration() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	@Given("^BandLab page is open$")
	public void bandlab_page_is_open() {

		String BandLabPageOpen = driver
				.findElement(By.cssSelector("a[analytics-label = 'Sign Up'][ui-sref = 'signUp']:nth-of-type(1)"))
				.getText();
		Assert.assertEquals(BandLabPageOpen, "Зарегистрироваться", "BandLab Page should open");
//		System.out.println(BandLabPageOpen);

	}

	@When("^User clicks the login button$")
	public void user_clicks_the_login_button() {
		driver.findElement(By.cssSelector("a[analytics-label = 'Log In'][ui-sref = 'login']")).click();
	}

	@When("^User inserts valid credentials$")
	public void user_inserts_valid_credentials() {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);

	}

	@Then("^home page should open$")
	public void home_page_should_open() {
		String homePageTitle = driver
				.findElement(By.cssSelector("ng-pluralize-html[count = 'vm.user.counters.followers']:nth-of-type(1)"))
				.getText();
		Assert.assertEquals(homePageTitle, "Подписчиков", "Home page should open");

	}

	@And("^Login Page is open$")
	public void login_page_is_open() {
		String loginPageTitle = driver.findElement(By.cssSelector("label[for= 'username']")).getText();
		Assert.assertEquals(loginPageTitle, "Имя пользователя или email", "Login page is open");

	}

	@And("^clicks login$")
	public void clicks_login() {
		driver.findElement(By.cssSelector(".button-dark.button-height-40.button-rounded.button-padding-fill")).click();

	}

	@Then("^User opens New Project$")
	public void user_opens_new_project() {
		driver.findElement(By.cssSelector(".project-tile-title-name[title = 'New Project']")).click();

	}

	@And("^New Project should open$")
	public void new_project_should_open() {
		String newProjectPage = driver
				.findElement(By.cssSelector("h1[class = 'revision-page-player-title-h1 text-truncate']")).getText();
		Assert.assertEquals(newProjectPage, "New Project", "New Project Page should open");

	}

	@Then("^User click play button$")
	public void user_click_play_button() {
		driver.findElement(By.cssSelector(".player-button-64")).click();
	}

	@And("^The music should play$")
	public void the_music_should_play() {

		WebElement audio = driver.findElement(By.tagName("span"));
		Assert.assertNotEquals(audio.getAttribute("currentTime"), "0");

	}

//	
//	@Given("^BandLab page is open for \"([^\"]*)\"$")
//    public void bandlab_page_is_open_for_something(String strArg1){
//		String BandLabPageOpen = driver
//				.findElement(By.cssSelector("a[analytics-label = 'Sign Up'][ui-sref = 'signUp']:nth-of-type(1)"))
//				.getText();
//		Assert.assertEquals(BandLabPageOpen, "Зарегистрироваться", "BandLab Page should open");
//    }
//
//    @When("^User clicks login button$")
//    public void user_clicks_login_button(){
//    	driver.findElement(By.cssSelector("a[analytics-label = 'Log In'][ui-sref = 'login']")).click();
//    }
//
//    @When("^User inserts valid (.+) and (.+)$")
//    public void user_inserts_valid_and(String username, String password){
//    	driver.findElement(By.id("username")).sendKeys(username);
//		driver.findElement(By.id("password")).sendKeys(password);
//    }
//
//    @Then("^The Home page should open$")
//    public void the_home_page_should_open(){
//    	String homePageTitle = driver
//				.findElement(By.cssSelector("ng-pluralize-html[count = 'vm.user.counters.followers']:nth-of-type(1)"))
//				.getText();
//		Assert.assertEquals(homePageTitle, "Подписчиков", "Home page should open");
//    }
//
//    @Then("^The User Opens New Project$")
//    public void the_user_opens_new_project(){
//    	driver.findElement(By.cssSelector(".project-tile-title-name[title = 'New Project']")).click();
//    }
//
//    @Then("^The User click play button$")
//    public void the_user_click_play_button(){
//        
//    }
//
//    @And("^LogIn Page is opens$")
//    public void login_page_is_opens(){
//        
//    }
//
//    @And("^The User Clicks login$")
//    public void the_user_clicks_login(){
//        
//    }
//
//    @And("^The New Project should open$")
//        
//    }
//
//    @And("^Music should play$")
//    public void music_should_play(){
//        
//    }

}
