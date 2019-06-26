package tests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.BasePage;
import pages.HomePage;

public class Practice2 extends BasePage{
	
	private static WebDriver driver;
	HomePage home = new HomePage(driver);
	
	@BeforeTest
	public void beforeTest() {
		
		startBrowserDefined("chrome");
		
	}
	
	public void demoStage2BDD(){
		
		System.out.println("Stage 2 Demo test");
		
		System.out.println("Starting Test Case #2");
		
		String homeTitle = home.getHomeBrowserTitle();	
		System.out.println("Home page title : "+homeTitle);
		home.clickOnHomeTabButton();
		
		if (home.getHomeBrowserTitle().contentEquals(homeTitle)) {
			System.out.println("Home Page is displayed correctly after click Home tab on navigation menu");
		} else {
			System.out.println("Home Page title after click Home tab on navigation menu is "+homeTitle);
			Assert.fail("Home Page is displayed correctly after click Home tab on navigation menu");
		}
		
	}
	
	@AfterTest
	public void afterTest() {
		
		closeDriver();
		
	}
	
	
	

}
