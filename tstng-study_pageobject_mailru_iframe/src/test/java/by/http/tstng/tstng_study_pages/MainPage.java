package by.http.tstng.tstng_study_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

	private final String BASE_URL = "https://mail.ru/";

	@FindBy(id = "mailbox:login")
	private WebElement inputLogin;

	@FindBy(id = "mailbox:password")
	private WebElement inputPassword;

	@FindBy(xpath = "//input[@value='Войти']")
	private WebElement buttonSubmit;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void login(String username, String password) {
		inputLogin.sendKeys(username);
		inputPassword.sendKeys(password);

		buttonSubmit.click();
	}

	@Override
	public void openPage() {

		driver.navigate().to(BASE_URL);

	}

}