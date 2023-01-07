package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import poms.AccountsOverviewPage;
import poms.AccountsOverviewPage2;
import poms.BankLoginPage;
import poms.LoanRequestPage;

public class BankLogin {

	WebDriver driver = null;
	
//	String url = "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC";
//	String username = "kungfu";
//	String password = "panda";
//	double loanAmount = 3500;
//	double downpayment = 1000;

	BankLoginPage bankLoginPage;
	AccountsOverviewPage AccountsOverviewPage;
	AccountsOverviewPage2 AccountsOverviewPage2;
	LoanRequestPage loanRequestPage;
	Properties prop = null;

	@BeforeMethod
	public void setup() {
		
		prop = new Properties();
		
		
		try {
			FileInputStream fis = new FileInputStream("src\\main\\java\\resources\\application.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\webdrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
	
		driver.manage().window().maximize();

//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		bankLoginPage = new BankLoginPage(driver);
		AccountsOverviewPage = new AccountsOverviewPage(driver);
		AccountsOverviewPage2 = new AccountsOverviewPage2(driver);
		loanRequestPage = new LoanRequestPage(driver);
	}

	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	
	@Test
	public void login() {

		driver.get(prop.getProperty("url"));

//		driver.findElement(By.name("username")).sendKeys(username);		
//		driver.findElement(By.name("password")).sendKeys(password);
//		driver.findElement(By.cssSelector("input[value='Log In']")).click();

		bankLoginPage.insertUserName(prop.getProperty("username"));
		bankLoginPage.insertUserPassword(prop.getProperty("password"));
		bankLoginPage.clickLogin();

		String homePageTitle = AccountsOverviewPage.getText();
		Assert.assertEquals(homePageTitle, "Accounts Overview");

	}

	@Test
	public void applyForLoan() {

		driver.get(prop.getProperty("url"));

//		driver.findElement(By.name("username")).sendKeys(username);	
//		driver.findElement(By.name("password")).sendKeys(password);
//		driver.findElement(By.cssSelector("input[value='Log In']")).click();

//		driver.findElement(By.xpath("//a[text()='Request Loan']")).click();

		bankLoginPage.insertUserName(prop.getProperty("username"));
		bankLoginPage.insertUserPassword(prop.getProperty("password"));
		bankLoginPage.clickLogin();

		String homePageTitle = AccountsOverviewPage.getText();
		Assert.assertEquals(homePageTitle, "Accounts Overview");

		AccountsOverviewPage.openRequestLoanPage();

		String loanPageTitle = loanRequestPage.getPageTitle();
		Assert.assertEquals(loanPageTitle, "Apply for a Loan");

//		driver.findElement(By.id("amount")).sendKeys("15000");
//		driver.findElement(By.id("downPayment")).sendKeys("3000");
//		driver.findElement(By.cssSelector("input[value='Apply Now']")).click();
		
		loanRequestPage.insertAmount(Double.parseDouble(prop.getProperty("loanAmount")));
		loanRequestPage.insertDownpayment(Double.parseDouble(prop.getProperty("downpayment")));
		loanRequestPage.clickApply();
	}
	
	@Test
	public void applyForLoanPageFactory() {

		driver.get(prop.getProperty("url"));

		bankLoginPage.insertUserName(prop.getProperty("username"));
		bankLoginPage.insertUserPassword(prop.getProperty("password"));
		bankLoginPage.clickLogin();

		String homePageTitle = AccountsOverviewPage2.getText();
		Assert.assertEquals(homePageTitle, "Accounts Overview");

		AccountsOverviewPage2.openRequestLoanPage();

		String loanPageTitle = loanRequestPage.getPageTitle();
		Assert.assertEquals(loanPageTitle, "Apply for a Loan");
	
		loanRequestPage.insertAmount(Double.parseDouble(prop.getProperty("loanAmount")));
		loanRequestPage.insertDownpayment(Double.parseDouble(prop.getProperty("downpayment")));
		loanRequestPage.clickApply();
	}


}
