package pageObjectsTakeALot;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class SelectedItemPage extends BasePage{	
	
	public String getTextOfBrandLink() {
		String text1 = getElementText(By.cssSelector(".title-content-list a"));
		return text1;
	}
	
	//negative test == expected is not == actual
//	public String getTextOfBrandLink() {
//	String text1 = getElementText(By.cssSelector("h1"));
//	return text1;
//	}
	
	public String getTextOfProductTitle() {
		String text2 = getElementText(By.cssSelector("h1"));
		return text2;
	}
}