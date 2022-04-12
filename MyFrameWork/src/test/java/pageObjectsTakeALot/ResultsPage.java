package pageObjectsTakeALot;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class ResultsPage extends BasePage{
	
	/* 2
	 * GIVEN the shopper is on the landing page == LandingPage.checkLandingPageNavigation()
	 * WHEN he enters "DKNY" as the search string == LandingPage.searchForItem("DKNY")
	 * WHEN clicks the search button == LandingPage.clickSearchButton()
	 * THEN "DKNY" is displayed as the first item in the grid == ResultsPage.checkItemName
	 * 
	 */
	
//	public void clickFirstItem() {
//		clickElement(By.cssSelector("div:nth-of-type(2) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV.sponsored"));
//	}
	
	public void clickFirstItem() {
		clickElement(By.cssSelector("div:nth-of-type(2) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV"));
	}
	
	public void clickSecondItem() {
		clickElement(By.cssSelector("div:nth-of-type(3) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV"));
	}
	
	public void clickThirdItem() {
		clickElement(By.cssSelector("div:nth-of-type(4) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV"));
	}
	
	public boolean checkItemName(String checkItemName) {
		return false;
	}
	
	public String verifyText() {
		String text5 = getElementText(By.cssSelector("h1"));
		return text5;
		
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
