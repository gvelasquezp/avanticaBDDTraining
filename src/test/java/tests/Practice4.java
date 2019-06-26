package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BasePage;
import pages.HomePage;

public class Practice4 extends BasePage{
	
	private static WebDriver driver;
	HomePage home = new HomePage(driver);
	String homeTitle;
	
	@Given("^I open the Home page in the browser$")
	public void i_open_the_Home_page_in_the_browser(){
	    
		System.out.println("Stage 4 Demo test");
		startBrowserDefined("chrome");
		
	}

	@When("^I click on Home tab in nav bar$")
	public void i_click_on_Home_tab_in_nav_bar(){
	    
		homeTitle = home.getHomeBrowserTitle();	
		System.out.println("Home page title : "+homeTitle);
		home.clickOnHomeTabButton();
		
	}

	@Then("^I validate the Home page is displayed$")
	public void i_validate_the_Home_page_is_displayed(){
		
		if (home.getHomeBrowserTitle().contentEquals(homeTitle)) {
			System.out.println("Home Page is displayed correctly after click Home tab on navigation menu");
		} else {
			System.out.println("Home Page title after click Home tab on navigation menu is "+homeTitle);
			Assert.fail("Home Page is displayed correctly after click Home tab on navigation menu");
		}
		closeDriver();
	}
	
}
