package testCasesDatePicker;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import frameWorkClasses.BasePage;
import pageObjectsDatePickerProject.DatePickerBasePage;
import pageObjectsDatePickerProject.DateTimePickerPage;

public class testsDatePicker {
	
	DatePickerBasePage datePickerBasePage = new DatePickerBasePage();
	DateTimePickerPage dateTimePickerPage = new DateTimePickerPage();
	
	@BeforeTest
	public void setUp() {
		datePickerBasePage.clickCookiesButton();
	}
	
//	@AfterTest
//	public void cleanUp() {
//		dateTimePickerPage.cleanUp();
//	}
	
	@Test
	public void datePickerTest1() throws InterruptedException{
		dateTimePickerPage.selectDateFromDatePicker("10/13/2012 3:30 PM"); 
	
	}

}
