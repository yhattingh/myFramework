package testCasesTakeALot;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import frameWorkClasses.BasePage;
import pageObjectsTakeALot.BasePageTakeALot;
import pageObjectsTakeALot.CartPage;
import pageObjectsTakeALot.CheckOutPage;
import pageObjectsTakeALot.DealsPage;
import pageObjectsTakeALot.LandingPage;
import pageObjectsTakeALot.LoginPage;
import pageObjectsTakeALot.ResultsPage;
import pageObjectsTakeALot.SelectedItemPage;

import org.testng.asserts.SoftAssert;

public class Tests {
	
	//instantiate the page objects
	LandingPage landingPage = new LandingPage();
	CartPage cartPage = new CartPage();
	LoginPage loginPage = new LoginPage();
	ResultsPage resultsPage = new ResultsPage();
	DealsPage dealsPage = new DealsPage();
	CheckOutPage checkOutPage = new CheckOutPage();
	BasePageTakeALot basePageTakeAlot = new BasePageTakeALot();
	SelectedItemPage selectedItem = new SelectedItemPage();
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeTest
	public void setUp() {
		basePageTakeAlot.clickCookiesButton();
		//basePageTakeAlot.quizPopUp();
	}
	
//	@AfterTest
//	public void quitBrowser() {
//		BasePage.driver.quit();
//	}
//	
//	@AfterMethod
//	public void closeChildWindow() {
//		selectedItem.closeChildBrowserTab();
//	}

	/*1
	 * GIVEN the shopper is on the landing page
	 * WHEN the shopper clicks on the Cart button
	 * THEN check that the shopper is on the cart page
	 * AND check that Cart is empty is displayed
	 */
	
	/*2a
	 * GIVEN the shopper is on the landing page
	 * WHEN he enters "DKNY" as the search string 
	 * WHEN clicks the search button
	 * THEN "DKNY" is displayed as the first item in the grid
	 * WHEN going to the home page
	 */
	
	/*2b
	 * GIVEN the shopper is on the landing page
	 * WHEN he enters "hills" as the search string 
	 * WHEN clicks the search button
	 * THEN "hilss" is displayed as the first item in the grid
	 * WHEN going to the home page
	 */
	
	/* 3
	 * GIVEN the shopper selected an item
	 * WHEN the shopper adds the item to the cart
	 * THEN item is added to the cart
	 */
	
	/* 4
	 * demo - Antoinette
	 * LandingPage.checkLandingPageNavigation();  
	 * LandingPage.selectItem("DailyDeals");
	 * DealsPage.checkURL("Takealot/deals");
	 * DealsPage.checkFirstItem("PhillipsAirFryer")
	 */
	//GIVEN_shopperIsOnTheLandingPage_WHEN_shopperClicksOnDailyDeals_THEN_checkURL_AND_checkFirstItem

	
	
	//1
	@Test
	public void GIVEN_shopperIsOnTheLandingPage_WHEN_shopperClicksCartButton_THEN_ChecksThatShopperIsOnCartPage_THEN_CheckThatCartIsEmpty() {
		
	}	
	
	//2a
	@Test
	public void GIVEN_shopperIsOnTheLandingPage_WHEN_shopperEntersDKNYasTheSearchString_AND_shopperClicksTheSearchButton_THEN_DKNYDisplayedAsTheFirstItem() {
		
		//Declare variables
		String searchedText = "DKNY";
		String actualText; // to have all declared variables in one place but we cannot have actualText = selectedItem.getTextOfTitleElement(); here 
							// because it then expects we already have this variable which we only get in line 104
		String expectedResult = searchedText;
				
		basePageTakeAlot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.enterTextInSearchBar(searchedText);
		landingPage.clickSearchButton();
		resultsPage.clickFirstItem();
		resultsPage.switchToNewTab();
		//System.out.println(selectedItem.getTextOfBrandLink());
		actualText = selectedItem.getTextOfBrandLink();
		System.out.println("Actual Result:" + " " + actualText);
		//Reporter.log("Expected Text: " + searchedText + " and " + "Actual Text: " + actualText);
		Reporter.log("Expected Result : " + expectedResult);
		Reporter.log("Actual Result : " + actualText);
		Assert.assertEquals(actualText, expectedResult);
		resultsPage.closeChildBrowserTab();
	}
	
	//2b
	@Test
	public void GIVEN_shopperIsOnTheLandingPage_WHEN_shopperEntersHillsasTheSearchString_AND_shopperClicksTheSearchButton_THEN_HillsIsDisplayedAsTheSecondItem() {
		
		//Declare variables
		String searchedText = "Hills";
		String actualText; 
		String expectedResult = searchedText;
				
		basePageTakeAlot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.enterTextInSearchBar(searchedText);
		landingPage.clickSearchButton();
		resultsPage.clickSecondItem();
		resultsPage.switchToNewTab();
		actualText = selectedItem.getTextOfBrandLink();
		System.out.println("Actual Result:" + " " + actualText);
		Reporter.log("Expected Result : " + expectedResult);
		Reporter.log("Actual Result : " + actualText);
		Assert.assertEquals(actualText, expectedResult);
		resultsPage.closeChildBrowserTab();
	}
	
	//2c
	@Test
	public void GIVEN_shopperIsOnTheLandingPage_WHEN_shopperEntersGeniusAsTheSearchString_AND_shopperClicksTheSearchButton_THEN_GeniusIsDisplayedAsTheThirdItem() {
		
		//Declare variables
		String searchedText = "Genius";
		String actualText; 
		String expectedResult = searchedText;
				
		basePageTakeAlot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.enterTextInSearchBar(searchedText);
		landingPage.clickSearchButton();
		resultsPage.clickThirdItem();
		resultsPage.switchToNewTab();
		actualText = selectedItem.getTextOfBrandLink();
		System.out.println("Actual Result:" + " " + actualText);
		Reporter.log("Expected Result : " + expectedResult);
		Reporter.log("Actual Text : " + actualText);
		assertTrue(actualText.contains(expectedResult));
		resultsPage.closeChildBrowserTab();

	}
	
	//2d
	@Test
	public void GIVEN_shopperIsOnTheLandingPage_WHEN_shopperEntersBootAsTheSearchString_AND_shopperClicksTheSearchButton_THEN_BootIsDisplayedAsTheThirdItem() {
		
		//Declare variables
		String searchedProductInput = "Boot";
		String searchedBrand = "TTP";
		
		String actualTextOfProductTitle; 
		String expectedProductResult = searchedProductInput;
		
		String actualTextOfBrandLink;
		String expectedTextOfBrandLink = searchedBrand;
				
		basePageTakeAlot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.enterTextInSearchBar(searchedProductInput);
		landingPage.clickSearchButton();
		resultsPage.clickThirdItem();
		resultsPage.switchToNewTab();
		actualTextOfProductTitle = selectedItem.getTextOfProductTitle();
		System.out.println("Actual PRODUCT contains the word " + " " + expectedProductResult + " " + "and the product text is" + " " + actualTextOfProductTitle);
		actualTextOfBrandLink = selectedItem.getTextOfBrandLink();
		System.out.println("Actual BRAND = " + actualTextOfBrandLink);
		Reporter.log("Expected Product Title Result : " + expectedProductResult);
		Reporter.log("Actual Product Title Result : " + actualTextOfProductTitle);
		Reporter.log("Expected Brand Link  Result : " + expectedTextOfBrandLink);
		Reporter.log("Actual Brand Link Result : " + actualTextOfBrandLink);
		Assert.assertTrue(actualTextOfProductTitle.contains(expectedProductResult));
		Assert.assertEquals(actualTextOfBrandLink, expectedTextOfBrandLink);
		softAssert.assertEquals(actualTextOfBrandLink, "who knows");
		Reporter.log("Actual Result for softAssert " + actualTextOfBrandLink + " ; " + "printed result for softAssert: " + expectedProductResult);
		//softAssert.assertAll();
        resultsPage.closeChildBrowserTab();
	}

	//2e
	@Test
	public void GIVEN_shopperIsOnTheLandingPage_WHEN_shopperEntersHillsAsTheSearchString_AND_shopperClicksTheSearchButton_THEN_HillsIsDisplayedAsTheThirdItem() {
		
		//Declare variables
		String searchedProductInput = "Puppy";
		String searchedBrand = "Hills";
		
		String actualTextOfProductTitle; 
		String expectedProductResult = searchedProductInput;
		
		String actualTextOfBrandLink;
		String expectedTextOfBrandLink = searchedBrand;
				
		basePageTakeAlot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.enterTextInSearchBar(searchedBrand);
		landingPage.clickSearchButton();
		resultsPage.clickThirdItem();
		resultsPage.switchToNewTab();
		actualTextOfProductTitle = selectedItem.getTextOfProductTitle();
		System.out.println("Actual PRODUCT contains the word " + " " + expectedProductResult + " " + "and the product text is" + " " + actualTextOfProductTitle);
		actualTextOfBrandLink = selectedItem.getTextOfBrandLink();
		System.out.println("Actual BRAND = " + actualTextOfBrandLink);
		Reporter.log("Expected Product Title Result : " + expectedProductResult);
		Reporter.log("Actual Product Title Result : " + actualTextOfProductTitle);
		Reporter.log("Expected Brand Link  Result : " + expectedTextOfBrandLink);
		Reporter.log("Actual Brand Link Result : " + actualTextOfBrandLink);
		Assert.assertTrue(actualTextOfProductTitle.contains(expectedProductResult));
		Assert.assertEquals(actualTextOfBrandLink, expectedTextOfBrandLink);
		resultsPage.closeChildBrowserTab();
	}

	
	//2f - ADD TO CART
	@Test
	public void TESTGIVEN_shopperIsOnTheLandingPage_WHEN_shopperEntersBootAsTheSearchString_AND_shopperClicksTheSearchButton_THEN_shopperAddsItemToCart() throws InterruptedException {
		
		//Declare variables
		String searchedProductInput = "TTP Women's Lace-Up Combat Boot XB1601 with Patent Finish";
		String searchedBrand = "TTP";
		
		String actualTextOfProductTitle; 
		String expectedProductResult = searchedProductInput;
		
		String actualTextOfBrandLink;
		String expectedTextOfBrandLink = searchedBrand;
		
		String actualItemCount;
		String expectedItemCount = "(1 item)";
		
			
		basePageTakeAlot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.enterTextInSearchBar(searchedProductInput);
		landingPage.clickSearchButton();
		resultsPage.clickFirstItem();
		resultsPage.switchToNewTab();
		
		actualTextOfProductTitle = selectedItem.getTextOfProductTitle();
		System.out.println("Actual PRODUCT contains the word " + " " + expectedProductResult + " " + "and the product text is" + " " + actualTextOfProductTitle);
		
		actualTextOfBrandLink = selectedItem.getTextOfBrandLink();
		System.out.println("Actual BRAND = " + actualTextOfBrandLink);
		
		Reporter.log("Expected Product Title Result : " + expectedProductResult);
		Reporter.log("Actual Product Title Result : " + actualTextOfProductTitle);
		Reporter.log("Expected Brand Link  Result : " + expectedTextOfBrandLink);
		Reporter.log("Actual Brand Link Result : " + actualTextOfBrandLink);
		
		Assert.assertTrue(actualTextOfProductTitle.contains(expectedProductResult));
		Assert.assertEquals(actualTextOfBrandLink, expectedTextOfBrandLink);
		
		selectedItem.selectColour();
		selectedItem.selectClickShoeSize();
		Assert.assertTrue(selectedItem.addToCartButtonIsAvailable());
		
		selectedItem.clickAddToCartLink();
		selectedItem.clickGoToCartButton();
		
		//my method
		actualItemCount = cartPage.checkCartCount();
		
		Reporter.log("Expected count is: " + " " + expectedItemCount);
		Reporter.log("Actual item count is: " + " " + actualItemCount);
		Assert.assertEquals(actualItemCount, expectedItemCount); 
		
		//Louise method
		Assert.assertEquals(cartPage.checkCartItemCount("(1 item)"), true);
				
	}
	
	//2G - verify the unit price
	@Test
	public void GIVEN_shopperIsOnTheLandingPage_WHEN_shopperEntersBootAsTheSearchString_AND_shopperSelectsAnItem_THEN_shopperChecksUnitPrice_AND_addItemToCart() throws InterruptedException {
		
		//Declare variables
		String searchedProductInput = "TTP Women's Lace-Up Combat Boot XB1601 with Patent Finish";
		
		
		basePageTakeAlot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.enterTextInSearchBar(searchedProductInput);
		landingPage.clickSearchButton();
		resultsPage.clickFirstItem();
		resultsPage.switchToNewTab();
		
		
		selectedItem.selectColour();
		selectedItem.selectClickShoeSize();
		Assert.assertTrue(selectedItem.addToCartButtonIsAvailable());
		
		int unitPrice = selectedItem.getUnitPrice();
		System.out.println("Unit Price is R " + unitPrice);
		Reporter.log("The unit price is R" + unitPrice);
		
		selectedItem.clickAddToCartLink();
		selectedItem.clickGoToCartButton();
		
		Assert.assertEquals(cartPage.checkCartItemCount("(1 item)"), true); // "(1 item)" = checkCount on checkCartItemCount method
		cartPage.selectQuantity("2");
		Assert.assertEquals(cartPage.checkCartItemCount("(2 item)"), true);
		cartPage.selectQuantity("3");
		//cartPage.closeChildBrowserTab();
		
	}
	
	//2G - verify the unit price and strip out the comma in the price and empty cart
	@Test
	public void GIVEN_shopperIsOnTheLandingPage_WHEN_shopperEntersEcoFlowRIVERPro_AsTheSearchString_AND_shopperSelectsAnItem_THEN_shopperChecksUnitPrice_AND_addItemToCart() throws InterruptedException {
		
		//Declare variables
		String searchedProductInput = "EcoFlow RIVER Pro";
		
		
		basePageTakeAlot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.enterTextInSearchBar(searchedProductInput);
		landingPage.clickSearchButton();
		resultsPage.clickFirstItem();
		resultsPage.switchToNewTab();
		
		int unitPrice = selectedItem.getUnitPrice();
		System.out.println("Unit Price is R " + unitPrice);
		Reporter.log("The unit price is R" + unitPrice);
		
		selectedItem.clickAddToCartLink();
		selectedItem.clickGoToCartButton();
		
		Assert.assertEquals(cartPage.checkCartItemCount("(1 item)"), true); // "(1 item)" = checkCount on checkCartItemCount method
		cartPage.selectQuantity("2"); //selects from a dropdown
		Assert.assertEquals(cartPage.checkCartItemCount("(2 items)"), true);
		cartPage.selectQuantity("1");
		Assert.assertEquals(cartPage.checkCartItemCount("(1 item)"), true);
		//cartPage.closeChildBrowserTab();
		cartPage.removeFromCart();
		Assert.assertEquals(cartPage.checkEmptyCart(), true);
		Assert.assertEquals(cartPage.checkEmptyCartWithIsDisplayed(), true);
		BasePage.driver.quit();
	}
	
	//2H - verify cart is empty
	@Test
	public void GIVEN_shopperIsOnTheLandingPage_WHEN_shopperHoversOverTrollie_THEN_displayItemCount() throws InterruptedException{
		
		basePageTakeAlot.navigateToHomePage();
		System.out.println("Item count is: " + landingPage.cartSummary());
		Reporter.log("Item count is: " + landingPage.cartSummary());
		Assert.assertEquals(landingPage.cartSummary2("0"), true);
		
		BasePage.driver.quit();
	}
}
	
	
