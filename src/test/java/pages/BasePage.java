package pages;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {

	private static WebDriver driver;

	
	
	/**
     * This is a method for get the browser name sent it through command line
     *
     // @param String
     *            browserName
     **/
    private String getBrowser(String browserName) {
        //DesiredCapabilities browser;
        String browser;
        browserName = browserName.toLowerCase();

        switch (browserName) {
            case "chrome":
                browser = "Chrome";
                break;
            case "ie":
                browser = "IE";
                break;
            default:
                browser = "Firefox";
                break;
        }
        return browser;
    }

    
    /**
     * This is a method for start the browser through command line
     **/
    public void startBrowser() {
    	String browserName = System.getProperty("browser") != null ? System.getProperty("browser"): "";
        String browser = getBrowser(browserName);
        System.out.println("Testing in Browser: " + browser);
        if (browser == "Firefox"){

            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        }
        else if (browser == "Chrome"){

            System.setProperty("webdriver.chrome.driver", "$Path/chromedriver");
            driver = new ChromeDriver();
            driver.get("http://www.google.com");
            driver.manage().window().maximize();

        }
        else if (browser == "IE") {

            System.setProperty("webdriver.ie.driver", "$Path\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();

        }
    }
    
    
    /**
     * This is a method for start the browser defining the browser name
     // @param String
     *            browserName
     **/
    public void startBrowserDefined(String browserName) {
    	String browser = browserName.toLowerCase();
        System.out.println("Testing in Browser: " + browser);
        if (browser == "firefox"){

            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        }
        else if (browser == "chrome"){

            System.setProperty("webdriver.chrome.driver", "$Path/chromedriver");
            driver = new ChromeDriver();
            System.out.println("Go to http://www.google.com");
            driver.get("http://www.google.com");
            driver.manage().window().maximize();

        }
        else if (browser == "ie") {

            System.setProperty("webdriver.ie.driver", "$Path\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();

        }
    }
    
    
    /**
     * This is a method for close the browser driver
     **/
    public void closeDriver() {
        driver.quit();
    }

    
    /**
     * This is a method for make a pause of 5'
     **/
    public void waitDriver() throws InterruptedException {
        Thread.sleep(5000);
    }

    
    /**
     * This is a method for navigate the browser to a defined page
     // @param String
     *            url
     **/
    public void navigate(String url) {
        driver.navigate().to(url);
    }
    
    
    /**
     * This is a method for click an element
     // @param By
     *            locator
     **/
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    
    /**
     * This is a method for send a text to Element
     *
     // @param By
     *            locator
     // @param String
     *            textToSend
     **/
    public void sendKeys(By locator, String textToSend) {
        driver.findElement(locator).sendKeys(textToSend);
    }
    
    
    /**
     * This is a method that obtain the Text of an element
     *
     // @param By
     *            locator
     **/
    public String getTextValue(By locator) {
        return driver.findElement(locator).getText();
    }
    
    
    /**
     * This is a method that obtain the attribute value of an element
     *
     // @param By
     *            locator
     // @param String
     *            value
     **/
    public String getAttributeValue(By locator, String value) {
        return driver.findElement(locator).getAttribute(value);
    }

    /**
     * This is a method that clear the Text value of an element
     *
     // @param By
     *            locator
     **/
    public void clearTextValue(By locator) {
        driver.findElement(locator).clear();
    }

    
    /**
     * This is a method that wait for the presence of an element
     *
     // @param By
     *            locator
     **/
    public void handlingWaitsToElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }


    /**
     * This is a method that wait for a component to not be on the page
     *
     // @param By
     *            locator
     **/
    public void handlingWaitsToRemoveElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    
    /**
     * This is a method that move the mouse to an element
     *
     // @param By
     *            element
     **/
    public void movePointerTo(By element) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(element));
        action.perform();
    }

    
    /**
     * This is a method that scroll down the browser
     **/
    public void scrollDown() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
    }
    
    
    /**
     * This is a method that scroll up the browser
     **/
    public void scrollUp() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1000)");
    }
    
    
    /**
     * This is a method that change the work frame 
     // @param String
     *            frame
     **/
    public void changeFrame(String frame) {
    	driver.switchTo().frame(driver.findElement(By.xpath(frame)));
    }
    
    
    /**
     * This is a method that change the work frame to the default one
     **/
    public void changeFrameToDefault() {
    	driver.switchTo().defaultContent();
    }
    
    
    /**
     * This is a method that select a drop down and return the index option 
     // @param String
     *            frame
     **/
    public void selectRandomOption(By element , String option) {
    	
    	Select select = new Select(driver.findElement(element));
    	int r = new Random().nextInt(select.getOptions().size()-0)+0;
		
		if (option == "random")
			select.selectByIndex(r);
		else
		{
			handlingWaitsToElement(element);
	        select.selectByValue(option);
		}
    }
}
