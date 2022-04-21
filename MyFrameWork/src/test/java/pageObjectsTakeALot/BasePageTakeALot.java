package pageObjectsTakeALot;

import org.openqa.selenium.By;
import frameWorkClasses.BasePage;

public class BasePageTakeALot extends BasePage {
	
	//Method:  Go to home page
	
	public void navigateToHomePage() {
		driver.get("https://www.takealot.com");
		waitForUrl(30, "takealot");
	}

	//WET code == the selector is repeated and a variable is used in DRY code below to prevent wet code
//	public void clickCookiesButton() {
//		if(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".button.cookies-banner-module_dismiss-button_24Z98")) != null)
//			clickElement(By.cssSelector(".button.cookies-banner-module_dismiss-button_24Z98"));
//		}
	
	//DRY code == do not repeat yourself
	
	//try - catch block used when element is not always there, but should not fail a test e.g. the quiz block
	public void clickCookiesButton() {
		try {
			clickElement(By.cssSelector(".button.cookies-banner-module_dismiss-button_24Z98")); } 
		catch (Exception e) {
			System.out.println("cookie not there");
			//e.printStackTrace();
		}
	}

	public void quizPopUp() {
		String nextButton = "_hj-3HqTJ__styles__surveyActionButton";
		try {
		clickElement(By.className("_hj-2fsWS__styles__closeEndedOptionText"));
		clickElement(By.className(nextButton));
		clickElement(By.className(nextButton));
		clickElement(By.className("_hj-3Y4y-__styles__closeButton")); }
		catch(Exception e) {
			System.out.println("survey not displayed");
			//e.printStackTrace();
		}
	}
	
}
