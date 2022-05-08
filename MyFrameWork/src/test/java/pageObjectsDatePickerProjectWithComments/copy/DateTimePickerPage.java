package pageObjectsDatePickerProjectWithComments.copy;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import frameWorkClasses.BasePage;

public class DateTimePickerPage extends BasePage {

	public void selectDateFromDatePicker(String desiredDateTime) throws InterruptedException {

		// example desiredDateTime "5/3/2022 3:40 PM" === this date (desiredDateTime)
		// will be split below based on a space
		// 5/3/2022 3:40 PM == index0 = 5/3/2022 ; index1 = 3:40; index2 = PM
		// date will be split index0 = 5 MM ; index1 = 3 dd; index2 = 2022 yyyy
		// the month index starts at 0 so Jan is 0 and Feb is 1 to be used as the
		// selectDateFromDatePicker parameter

		// Split the desiredDateTime to get only the Date part
		String date_MM_dd_yyyy[] = (desiredDateTime.split(" ")[0].split("/")); // we split the entire desiredDateTime at
																				// each space (" ")
																				// and the []=array for index0 split at
																				// / and will be 5,3,2022

		// split time
		// String date_MM_dd_yyyy[] = (desiredDateTime.split("")[1].split(":"));
		// //[]=array will be 4,40

		// navigate to datepicker url which comes from config

		// click on the date button
		clickElement(By.cssSelector("button:nth-of-type(2) > .k-button-icon.k-i-calendar.k-icon"));

		// find the right arrow element for for future dates
		WebElement rightArrow = driver.findElement(By.cssSelector(".k-i-arrow-60-right.k-icon"));

		// find the middle button to click the month year
		WebElement middleButton = driver.findElement(By.cssSelector(".k-header.k-hstack > a:nth-of-type(2)"));

		// find the left arrow element for for past dates
		WebElement leftArrow = driver.findElement(By.cssSelector(".k-button-icon.k-i-arrow-60-left.k-icon"));

		// for the date part
		// click middle
		middleButton.click();
		Thread.sleep(40);

		// figure out if the year is in the past present or future
		// get the year difference between current year and the desired year
		int yearDiff = Integer.parseInt(date_MM_dd_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR); // is the
																											// desired
																											// year =
																											// current
																											// year
		// we are using the split desiredDateTime created above
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		System.out.println("current year is : " + " " + currentYear);
		System.out.println(yearDiff);

		// select the desired year
		if (yearDiff != 0) {
			// if the difference is not 0, then move to the next year
			if (yearDiff > 0) {
				for (int i = 0; i < yearDiff; i++) {
					System.out.println("Year diff 1:" + " " + i);
					rightArrow.click();

				}
			}
			// if you have to move to the previous year
			else if (yearDiff < 0) {
				for (int i = 0; i < (yearDiff * (-1)); i++) {
					System.out.println("Year diff 2:" + " " + i);
					leftArrow.click();
				}
			}
		}

		// Get all months from the calendar and place them in a list
		List<WebElement> list_AllMonths = driver
				.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td"));

		// extract the string month and converting into an int
		int desiredMonth = Integer.parseInt(date_MM_dd_yyyy[0]);
		System.out.println("Desired Month:" + " " + desiredMonth);
		// select the desired month
		list_AllMonths.get(desiredMonth - 1).click(); // -1 because month index starts at 0 for Jan

		// get a list of all the days in the selected month
		List<WebElement> list_AllDays = driver.findElements(By.xpath(
				"//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class, 'k-other-month'))]"));

		// extract the string day and converting into an int
		int desiredDay = Integer.parseInt(date_MM_dd_yyyy[1]);
		System.out.println("Desired Day:" + " " + desiredDay);

		// select the desired day
		list_AllDays.get(desiredDay - 1).click();

		//// time part
		// click the time button
		clickElement(By.cssSelector(".k-i-clock"));

		// get a list of all the time
		// ol = ordered list ; ul = unordered list e.g. ul#datetimepicker_timeview >
		// li:nth-of-type(1)
		// li = list items
		Thread.sleep(200);
		List<WebElement> list_AllTimes = driver.findElements(By.xpath("//ul//li[@role='option']"));

		// extract the desired time
		// 10/13/2012 3:40 PM index0 = 10/13/2012; index1 = 3:40 ; index2 = PM
		// desiredDateTime = desiredDateTime.split(" ")[1] + " " +
		// desiredDateTime.split(" ")[2];
		desiredDateTime = desiredDateTime.substring(desiredDateTime.indexOf(" ") + 1);
		System.out.println("Desired time is:" + " " + desiredDateTime);
		Thread.sleep(200);

		// select the desired time
		// for loop syntax
		// for (statement 1; statement 2; statement 3) {
		// statement 1 is executed on time
		// statement 2 condition for executing the code block
		// statement 3 is executing every time after the code block

		// for each loop:
		// for each loop which is used exclusively for looping through elements in an
		// array
		// for (type variableName: arrayName == type = WebElement; variableName =
		// webElement; arrayName = list_AllTimes
		for (WebElement webElement : list_AllTimes) {
			// System.out.println("Print the webElement list:" + webElement.getText());
			if (webElement.getText().equalsIgnoreCase(desiredDateTime)) {
				System.out.println("Selected time: " + webElement.getText());
				System.out.println("Desired time: " + desiredDateTime);
				webElement.click();
			} else {
				System.out.println("Invalid time selected");
			}
		}

	}
}
