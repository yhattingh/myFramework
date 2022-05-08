package testCasesDatePicker;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import frameWorkClasses.BasePage;
import pageObjectsDatePickerProject.DatePickerBasePage;
import pageObjectsDatePickerProject.DateTimePickerPage;

public class testsDatePicker {
	
	DatePickerBasePage datePickerBasePage = new DatePickerBasePage();
	DateTimePickerPage dateTimePickerPage = new DateTimePickerPage();
	
	//initialise variables
	String desiredDateTimeAM = "10/13/2012 10:30 AM";
	String desiredDateTimePM = "10/13/2012 10:30 PM";
	
	@BeforeTest
	public void setUp() {
		datePickerBasePage.clickCookiesButton();
	}
	
//	@AfterTest
//	public void cleanUp() {
//		dateTimePickerPage.cleanUp();
//	}
	
	@Test
	public void datePickerTest() throws InterruptedException{
		dateTimePickerPage.selectDateFromDatePicker(desiredDateTimeAM);
	}
	
	@Test
	public void enterDateTimeTest() {
		dateTimePickerPage.enterDateTime(desiredDateTimePM);
	}


}
