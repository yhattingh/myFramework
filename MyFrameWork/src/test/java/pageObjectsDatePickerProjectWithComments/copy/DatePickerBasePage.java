package pageObjectsDatePickerProjectWithComments.copy;

import frameWorkClasses.BasePage;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DatePickerBasePage extends BasePage{
	
	BasePage basePage = new BasePage();
	
	public void clickCookiesButton() {
		clickElement(By.cssSelector("button#onetrust-accept-btn-handler"));
	}
	
}
