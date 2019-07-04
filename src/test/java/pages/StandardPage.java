package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StandardPage extends BasePage{
	
	private final WebDriver driver;
	By homeTabButton = By.cssSelector("#ctl00_TopMenuRepeater_ctl00_MenuLink span");
	By postAnAdTabButton = By.cssSelector("#ctl00_TopMenuRepeater_ctl01_MenuLink span");
	By myAdsProfileTabButton = By.cssSelector("#ctl00_TopMenuRepeater_ctl02_MenuLink span");
	
	By loginButton = By.cssSelector("#ctl00_LoginView_LoginLink");
	By usernameField = By.cssSelector("#ctl00_Main_LoginConrol_UserName");
	By passwordField = By.cssSelector("#ctl00_Main_LoginConrol_Password");
	By loginSubmitButton = By.cssSelector("#ctl00_Main_LoginConrol_LoginButton");
	
	By loginMemberName = By.cssSelector("#ctl00_LoginView_MemberName");
	
	
	public StandardPage(WebDriver driver){
		this.driver=driver;		
	}
	
	public void clickOnLoginButton() {
		handlingWaitsToElement(loginButton);
		click(loginButton);
		System.out.println("Clicking login button");
	}
	
	public void setUsernameField(String username) {
		handlingWaitsToElement(usernameField);
		clearTextValue(usernameField);
		sendKeys(usernameField, username);
		System.out.println("Entering the username value");
	}
	
	public void setPasswordField(String password) {
		handlingWaitsToElement(passwordField);
		clearTextValue(passwordField);
		sendKeys(passwordField, password);
		System.out.println("Entering the password value");
	}

	public void clickOnSubmitButton() {
		handlingWaitsToElement(loginSubmitButton);
		click(loginSubmitButton);
		System.out.println("Clicking login submit button");
	}
	
	public String getCurrentMemberName() {
		handlingWaitsToElement(loginMemberName);
		return getTextValue(loginMemberName);
	}
}
