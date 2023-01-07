package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsOverviewPage2 {

	@SuppressWarnings("unused")
	private WebDriver driver;
	
//	private By pageTitle = By.cssSelector("h1.title");
//	private By requestLoanLink = By.xpath("//a[text()='Request Loan']");
	
	@FindBy(css = "h1.title")
	private WebElement pageTitle;
	
	@FindBy(xpath = "//a[text()='Request Loan']")
	private WebElement requestLoanLink;
	
	public AccountsOverviewPage2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getText() {
//		return driver.findElement(pageTitle).getText();
		return pageTitle.getText();
	}
	
	public void openRequestLoanPage() {
//		driver.findElement(requestLoanLink).click();
		requestLoanLink.click();
	}
}
