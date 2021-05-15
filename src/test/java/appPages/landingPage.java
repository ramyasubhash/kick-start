package appPages;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import starterProject.starterProject.baseTest;

public class landingPage extends baseTest {

	public landingPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "login")

	WebElement getLogin;

	/*
	 * public static void login () throws Exception {
	 * PerformActionOnElement("getLogin", "Click", "" ); }
	 */

	@Test public void run() throws Exception 
	{
		getLogin.click();
	}
	
}
