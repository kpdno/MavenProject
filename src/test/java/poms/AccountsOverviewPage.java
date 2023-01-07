package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsOverviewPage {

	private WebDriver driver;
	
	private By pageTitle = By.cssSelector("h1.title");
	private By requestLoanLink = By.xpath("//a[text()='Request Loan']");
	
	public AccountsOverviewPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getText() {
		return driver.findElement(pageTitle).getText();
	}
	
	public void openRequestLoanPage() {
		driver.findElement(requestLoanLink).click();
	}
}
