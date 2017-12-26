package by.http.tstng.tstng_study_steps;

import org.openqa.selenium.WebDriver;

import by.http.tstng.tstng_study_driver.DriverSingleton;
import by.http.tstng.tstng_study_pages.ClickComposeButtonPage;
import by.http.tstng.tstng_study_pages.MainPage;
import by.http.tstng.tstng_study_pages.ComposeEmailPage;

public class Steps {

	private WebDriver driver;

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void sendEmail(String username, String password, String to, String subject,
			String emailContent) {

		MainPage loginMailRu = new MainPage(driver);
		loginMailRu.openPage();
		loginMailRu.login(username, password);

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ClickComposeButtonPage buttonCompose = new ClickComposeButtonPage(driver);
		buttonCompose.composeEmail();

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ComposeEmailPage writeEmailPage = new ComposeEmailPage(driver);
		writeEmailPage.writeAndSendEmail(to, subject, emailContent);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
