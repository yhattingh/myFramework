package pageObjectsDatePickerProject;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import frameWorkClasses.BasePage;

public class DateTimePickerPage extends BasePage {
	
	public void enterDateTime(String desiredDateTime) {
		String dateTimeSelector = "input#datetimepicker";
		clearText(By.cssSelector(dateTimeSelector));
		enterText(By.cssSelector(dateTimeSelector), desiredDateTime);
	}

	public void selectDateFromDatePicker(String desiredDateTime) throws InterruptedException {

		// Split the desiredDateTime to get only the Date part
		String date_MM_dd_yyyy[] = (desiredDateTime.split(" ")[0].split("/"));
		// click on the date button
		clickElement(By.cssSelector("button:nth-of-type(2) > .k-button-icon.k-i-calendar.k-icon"));

		// find the date picker elements
		WebElement rightArrow = driver.findElement(By.cssSelector(".k-i-arrow-60-right.k-icon"));
		WebElement middleButton = driver.findElement(By.cssSelector(".k-header.k-hstack > a:nth-of-type(2)"));
		WebElement leftArrow = driver.findElement(By.cssSelector(".k-button-icon.k-i-arrow-60-left.k-icon"));

		// click middle
		middleButton.click();
		Thread.sleep(40);

		// get the year difference between current year and the desired year
		int yearDiff = Integer.parseInt(date_MM_dd_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);

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

		// ------------------TIME PART------------------
		// click the time button
		clickElement(By.cssSelector(".k-i-clock"));

		// get a list of all the time options
		Thread.sleep(200);
		List<WebElement> list_AllTimes = driver.findElements(By.xpath("//ul//li[@role='option']"));

		// extract the desired time
		desiredDateTime = desiredDateTime.substring(desiredDateTime.indexOf(" ") + 1);
		System.out.println("Desired time is:" + " " + desiredDateTime);
		Thread.sleep(200);

		// select the desired time with a for loop

		for (WebElement webElement : list_AllTimes) {
			// System.out.println("Print the webElement list:" + webElement.getText());
			if (webElement.getText().equalsIgnoreCase(desiredDateTime)) {
				System.out.println("Selected time @: " + webElement.getText());
				System.out.println("Desired time @: " + desiredDateTime);
				webElement.click();
			} 
			
			else if (desiredDateTime != webElement.getText()){
				System.out.println("ERROR: Select from the following webElement list:" + webElement.getText());
			} 
			else {
				System.out.println("Invalid time selected again..");
			}
		}
	}
}