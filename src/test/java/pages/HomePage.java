package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
	
	private final WebDriver driver;
	By homeTabButton = By.cssSelector("#ctl00_TopMenuRepeater_ctl00_MenuLink");
	
	public HomePage(WebDriver driver) {
        this.driver = driver;
    }
	
	public void clickOnHomeTabButton(){
		handlingWaitsToElement(homeTabButton);
		click(homeTabButton);
		System.out.println("Clicking on Homte Tab button");
		
	}
	
	public String getHomeBrowserTitle(){
		return getTitle();
	}
}
