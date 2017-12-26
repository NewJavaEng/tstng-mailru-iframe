package by.http.tstng.tstng_study;

import org.testng.annotations.Test;

import by.http.tstng.tstng_study_steps.Steps;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class MailRuTest {
	
	private Steps steps;
	private final String LOGIN = "user15-95";
	private final String PASSWORD = "unibel";
	private final String TO = "hanna.ivankina@gmail.com";
	private final String SUBJECT = "Hanna Ivankina link to Git-Hub";
	private final String EMAILBODY = "Hello!" + "\n" + "I am sending you my link to Git-Hub:" + "\n" + 
			"https://github.com/NewJavaEng";
	
	
    @BeforeMethod
    public void setUp() {
    	steps = new Steps();
		steps.initBrowser();
    }
  
  
    @Test
    public void sendEmail() {
    	steps.sendEmail(LOGIN, PASSWORD, TO, SUBJECT, EMAILBODY);
    }

    @AfterMethod
    public void stopBrowser() {
    	steps.closeDriver();
    }


}
