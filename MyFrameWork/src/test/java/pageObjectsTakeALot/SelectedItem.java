package pageObjectsTakeALot;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class SelectedItem extends BasePage{
	
	public String getTitleText() {
		String text1 = getElementText(By.cssSelector(".title-content-list a"));
		return text1;
		
	}

}
