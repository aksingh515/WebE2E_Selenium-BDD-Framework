package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pomPages.LoginPage;
import pomPages.ThankYouPage;
import utils.BaseTest;
import utils.DriverFactory;
import utils.TestContextSetup;

public class SucessOrderMsgTest extends BaseTest {
	
	LoginPage loginPage;
	ThankYouPage thankYouPage;
	TestContextSetup testContextSetup;
	
	public SucessOrderMsgTest(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		this.loginPage = testContextSetup.pageObjectManager.getLoginPage();
		this.thankYouPage = testContextSetup.pageObjectManager.getThankYouPage();
	}
	
	@Then("user verifies the successful message and logs out the application.")
	public void user_verifies_the_successful_message_and_logs_out_the_application() {
		thankYouPage.getSucessMessage();
		System.out.println(DriverFactory.getDriver().getTitle());
	}

	@Then("user verifies the login error message")
	public void user_verifies_the_login_error_message() {

	    String actualMessage = loginPage.getErrorMessage();

	    Assert.assertEquals(
	        actualMessage,
	        "Epic sadface: Username and password do not match any user in this service"
	    );
	}

	

}
