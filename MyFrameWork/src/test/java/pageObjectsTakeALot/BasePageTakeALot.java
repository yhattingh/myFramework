package pageObjectsTakeALot;

import frameWorkClasses.BasePage;

public class BasePageTakeALot extends BasePage {
	
	//Method:  Go to home page
	
	public void navigateToHomePage() {
		driver.get("https://www.takealot.com");
		waitForUrl(30, "takealot");
	}
	
	

}
