package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BasePage;
import pages.StandardPage;

public class TestPractice extends BasePage{
	
	private static WebDriver driver;
	StandardPage standard = new StandardPage(driver);
	String user;

	@Given("^I open the Home page in the browser$")
	public void i_open_the_Home_page_in_the_browser() throws Throwable {
		System.out.println("Starting test practice demo");
		startBrowserDefined("chrome");
	}

	@Given("^click on Login button$")
	public void click_on_Login_button() throws Throwable {
	   standard.clickOnLoginButton();
	}

	@When("^I enter the username \"([^\"]*)\" and the password \"([^\"]*)\"$")
	public void i_enter_the_username_and_the_password(String username, String password) throws Throwable {
	    user=username;
		standard.setUsernameField(username);
	    standard.setPasswordField(password);
	}
	
	@When("^I enter the ([^\"]*) and the ([^\"]*)$")
	public void i_enter_the_username_and_the_password_outline(String username, String password) throws Throwable {
	    user=username;
		standard.setUsernameField(username);
	    standard.setPasswordField(password);
	}

	@When("^click on login submit button$")
	public void click_on_login_submit_button() throws Throwable {
	    standard.clickOnSubmitButton();
	}

	@Then("^I verify the user is able to login$")
	public void i_verify_the_user_is_able_to_login() throws Throwable {
	    if(standard.getCurrentMemberName().equals(user)) {
	    	System.out.println("The user has successfully logged in");
	    }
	    else {
	    	closeDriver();
	    	System.out.println("The user has not logged in correctly");
	    	Assert.fail("The user has not logged in correctly");
	    }
	    closeDriver();
	}
	
}

