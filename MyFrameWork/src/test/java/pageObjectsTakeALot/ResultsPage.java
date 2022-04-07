package pageObjectsTakeALot;

import frameWorkClasses.BasePage;

public class ResultsPage extends BasePage{
	
	/* 2
	 * GIVEN the shopper is on the landing page == LandingPage.checkLandingPageNavigation()
	 * WHEN he enters "DKNY" as the search string == LandingPage.searchForItem("DKNY")
	 * WHEN clicks the search button == LandingPage.clickSearchButton()
	 * THEN "DKNY" is displayed as the first item in the grid == ResultsPage.checkItemName
	 * 
	 */
	
	public boolean checkItemName(String checkItemName) {
		return false;
	}
	
	/* 3
	 * GIVEN the shopper selected an item  == ResultsPage.checkItemName
	 * WHEN the shopper adds the item to the cart == ResultsPage.clickAddToCartButton
	 * WHEN the shopper goes to the cart == ResultsPage.clickCartButton
	 * THEN item is added to the cart == CartPage.itemDisplayedInCart
	 */
	
	public void clickAddToCartButton() {
		
	}
	
	public void clickCartButton() {
		
	}

}
