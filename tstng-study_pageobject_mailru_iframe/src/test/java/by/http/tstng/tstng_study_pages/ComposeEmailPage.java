package by.http.tstng.tstng_study_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComposeEmailPage extends AbstractPage {

	private final String BASE_URL = " ";

	@FindBy(xpath = "//textarea[2]")
	private WebElement textareaTo;

	@FindBy(id = "tinymce")
	private WebElement bodyEmailContent;

	@FindBy(xpath = "//input[@name=\"Subject\"]")
	private WebElement inputSubjet;

	@FindBy(xpath = "//div[@id='b-toolbar__right']/descendant::span[text()='Отправить']")
	private WebElement buttonSend;

	@FindBy(xpath = "//*[@id=\"toolkit-151352026008142composeEditor_ifr\"]")
	private WebElement iframeTextContent;

	public ComposeEmailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void writeAndSendEmail(String to, String subject, String emailContent) {
		textareaTo.sendKeys(to);
		inputSubjet.sendKeys(subject);

		// http://internetka.in.ua/selenium-driver-iframe/
		// set correct parameter for frame()
		driver.switchTo().frame(4);
		WebElement body = driver.findElement(By.tagName("body"));
		body.sendKeys(emailContent);
		driver.switchTo().defaultContent();

		buttonSend.click();
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

}