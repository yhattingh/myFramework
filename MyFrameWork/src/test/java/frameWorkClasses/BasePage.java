package frameWorkClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	// Declare the Webdriver
	public static WebDriver driver;

	// Constructor
	// Check if driver was started, if not then start the driver
	// Set browser URL

	public BasePage() {
		if (driver == null) {
			// Set Parameter values === in the config file it is referred to properties and values
//			String browser = "chrome";	
//			String URL = "https://www.takealot.com/";
//			String pdriverDir = "C:\\Selenium\\";
			
			// When using the config properties file: Set Parameter values === in the config file it is referred to properties and values
			String browser = getDataConfigProperties("browser");
			String URL = getDataConfigProperties("URL");
			String URL2 = getDataConfigProperties("URL2");

		
			//String pdriverDir = getDataConfigProperties("pdriverDir");

//			 String pdriverDirFireFox = getDataConfigProperties("driverdirFirefox");
//			 String pdriverDirEdge = getDataConfigProperties("driverdirEdge");

			// check if parameter passed as "Chrome"
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup(); // auto-update chrome web driver
				// Set path to chromedriver.exe
				//System.setProperty("webdriver.chrome.driver", pdriverDir + "chromedriver.exe");
				// create an instance of Chrome
				driver = new ChromeDriver();
				driver.get(URL2);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				//System.setProperty("webdriver.gecko.driver", pdriverDir + "geckodriver.exe");
				driver = new FirefoxDriver();
				driver.get(URL2);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				//System.setProperty("webdriver.edge.driver", pdriverDir + "msedgedriver.exe");
				driver = new EdgeDriver();
				driver.get(URL2);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
		}
	}

	// Create a method to read the config file
	public String getDataConfigProperties(String propertyName) { // propertyName will be the browser that we are passing in
		// Properties set
		Properties p = new Properties();
		InputStream is = null;
		try {
			//is = new FileInputStream("config.properties"); // the config file name that we want to open
			is = new FileInputStream("configDatePicker.properties"); 
		} catch (FileNotFoundException e) { // if file does not exist, then we get a catch on the error
			e.printStackTrace();
		}
		try {
			p.load(is); // load the properties object, and pass in is (InputStream) which is the file
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p.getProperty(propertyName); // the property values are returned
	}

	// Method: Cleanup e.g. Close driver
	public void cleanUp() {
		driver.quit();
	}

	// Method: Clear text from field
	public void clearText(By pLocator) {
		waitforClick(30, pLocator);
		driver.findElement(pLocator).clear();
	}

	// Method: Click on an Element
	public void clickElement(By pLocator) {
		waitforClick(100, pLocator);
		getElement(pLocator).click();
	}

	// close browsers
	public void closeChildBrowserTab() {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowID = it.next();
		String childWindowID = it.next();
		driver.switchTo().window(childWindowID);
		driver.close();
		driver.switchTo().window(parentWindowID);
	}

	public void closeParentBrowserTab() {
		Set<String> handles = driver.getWindowHandles(); // selenium will check how many windows are currently open,
															// this will store the ID for both parent and child window
		Iterator<String> it = handles.iterator(); // using the it object you can access the ID
		String parentWindowID = it.next();
		String childWindowID = it.next();
		driver.switchTo().window(parentWindowID).close(); // close window
	}

	// Method: Check that Element exists
	public boolean elementExists(By pLocator) {
		boolean display = getElement(pLocator).isDisplayed();
		return display;
	}

	// Method: Enter text in field
	public void enterText(By pLocator, String enterText) {
		waitforClick(30, pLocator);
		driver.findElement(pLocator).sendKeys(enterText);
	}

	// Method: Get text on Element
	public String getElementText(By pLocator) {
		String elementText = getElement(pLocator).getText();
		return elementText;
	}

	// Method: get text on element using innerHTML (not used for now)
	public String getInnerHTML(By pLocator) {
		String elementText = getElement(pLocator).getAttribute("innerHTML");
		System.out.println(elementText);
		return elementText;
	}

	// Method: Get Element
	public WebElement getElement(By pLocator) {
		waitforClick(30, pLocator);
		return driver.findElement(pLocator);
	}

	// Method: Get title
	public String getTitle() {
		String getTitle = driver.getTitle();
		return getTitle;
	}

	// Method: Get current URL
	public String getURL() {
		String getCurrentURL = driver.getCurrentUrl();
		return getCurrentURL;
	}

	// Method: Select from drop-down
	public void selectDropdown(By pLocator, String pValue) {
		waitForElement(20, pLocator);
		// create an instance of the dropdown object
		Select selectDropDown = new Select(getElement(pLocator)); // type = Select
		selectDropDown.selectByVisibleText(pValue); // we are selecting from visible text
	}

	// Switch window / tab
	public void switchToNewTab() {
		Set<String> handles = driver.getWindowHandles(); // selenium will check how many windows are currently open,
															// this will store the ID for both parent and child window
		Iterator<String> it = handles.iterator(); // using the it object you can access the ID
		String parentWindowID = it.next();
		String childWindowID = it.next();
		driver.switchTo().window(childWindowID); // switch to new window by passing the ID of the child window
	}

	public void switchToParent() {
		Set<String> handles = driver.getWindowHandles(); // selenium will check how many windows are currently open,
		// this will store the ID for both parent and child window
		Iterator<String> it = handles.iterator(); // using the it object you can access the ID
		String parentWindowID = it.next();
		String childWindowID = it.next();
		driver.switchTo().window(parentWindowID); // switch to new parent
	}

	// Wait Methods: Wait for Element, Wait for Click
	// ...Wait for Element
	public void waitForElement(int elementWait, By pLocator) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(pLocator));
	}

	// ...Wait for Click
	public void waitforClick(int elementWait, By pLocator) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.elementToBeClickable(pLocator));
	}

	// ...Wait for URL
	public void waitForUrl(int elementWait, String pLocator) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.urlContains(pLocator));
	}
}