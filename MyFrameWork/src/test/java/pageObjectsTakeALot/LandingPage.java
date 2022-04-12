package pageObjectsTakeALot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import frameWorkClasses.BasePage;

public class LandingPage extends BasePage{
	
	//these are re-usable methods on the landing page
	
	/* demo - Antoinette
	 * LandingPage.checkLandingPageNavigation();  
	 * LandingPage.selectItem("DailyDeals");
	 * DealsPage.checkURL("Takealot/deals");
	 * DealsPage.checkFirstItem("PhillipsAirFryer")
	 */
	
	public boolean checkLandingPageNavigation() {
		return false;
		
	}
	
	public void selectItem(String selectItem) {
		
	}
	
	
	/* 1
	 * GIVEN the shopper is on the landing page == LandingPage.checkLandingPageNavigation()
	 * WHEN the shopper clicks on the Cart button == LandingPage.clickCartButton()
	 * THEN check that the shopper is on the cart page == CartPage.checkCartPageNavigation()
	 * AND check that Cart is empty is displayed == CartPage.displayEmptyCart("Your shopping cart is empty")
	 */
	
	public void clickCartButton() {
		
	}
	
	
	
	/* 2
	 * GIVEN the shopper is on the landing page == LandingPage.checkLandingPageNavigation()
	 * WHEN he enters "DKNY" as the search string == LandingPage.enterTextInSearchBar("DKNY")
	 * AND clicks the search button == LandingPage.clickSearchButton()
	 * THEN "DKNY" is displayed as the first item in the grid == ResultsPage.checkItemName
	 * WHEN going to the home page
	 * 
	 */
	
	public void enterTextInSearchBar(String enterTextInSearchBar) {
		enterText(By.name("search"), enterTextInSearchBar);
		
	}
	
	public void clickSearchButton() {
		clickElement(By.cssSelector("button[type='submit']"));
		
	}
	
	public void clickSearchBar() {
		clickElement(By.name("search"));
	}
	
//	public String checkElementTextOfFirstItem() {
//		String text1 = getElementText(By.cssSelector("div:nth-of-type(2) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV.sponsored"));
//		return text1;
//	}
	
}
