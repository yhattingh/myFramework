package pageObjectsTakeALot;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class SelectedItemPage extends BasePage{
	
	public String getTextOfTitleElement() {
		String text1 = getElementText(By.cssSelector(".title-content-list a"));
		return text1;
		
	}	
}
