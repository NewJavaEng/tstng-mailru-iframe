package by.http.tstng.tstng_study_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickComposeButtonPage extends AbstractPage {

	private final String BASE_URL = "https://e.mail.ru/messages/inbox/";

	@FindBy(xpath = "//a[@data-name='compose']")
	private WebElement buttonCompose;

	public ClickComposeButtonPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void composeEmail() {
		buttonCompose.click();
	}

	@Override
	public void openPage() {

		driver.navigate().to(BASE_URL);

	}

}
