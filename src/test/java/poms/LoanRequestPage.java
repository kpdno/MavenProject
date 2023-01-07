package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoanRequestPage {
	
	private WebDriver driver;
	
	By pageTitle = By.cssSelector("h1.title");
	By amountBox = By.id("amount");
	By downpaymentBox = By.id("downPayment");
	By applyBtn = By.cssSelector("input[value='Apply Now']");
	
	public LoanRequestPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public String getPageTitle() {
		return driver.findElement(pageTitle).getText();
		
	}
	
	public void insertAmount(double amount) {
		String amountStr = Double.toString(amount);
		driver.findElement(amountBox).sendKeys(amountStr);
	}
	
	public void insertDownpayment(double amount) {
		String amountStr = Double.toString(amount);
		driver.findElement(downpaymentBox).sendKeys(amountStr);
	}
	
	public void clickApply() {
		driver.findElement(applyBtn).click();	
	}
	
}
