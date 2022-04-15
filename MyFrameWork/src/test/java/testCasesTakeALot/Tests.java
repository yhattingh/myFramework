package testCasesTakeALot;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import frameWorkClasses.BasePage;
import pageObjectsTakeALot.BasePageTakeALot;
import pageObjectsTakeALot.CartPage;
import pageObjectsTakeALot.CheckOutPage;
import pageObjectsTakeALot.DealsPage;
import pageObjectsTakeALot.LandingPage;
import pageObjectsTakeALot.LoginPage;
import pageObjectsTakeALot.ResultsPage;
import pageObjectsTakeALot.SelectedItemPage;

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
	 
	
	@BeforeTest
	public void setUp() {
		basePageTakeAlot.clickCookiesButton();
	}
	
	@AfterTest
	public void quitBrowser() {
		BasePage.driver.quit();
	}

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
		resultsPage.SwitchToNewTab();
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
		resultsPage.SwitchToNewTab();
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
		resultsPage.SwitchToNewTab();
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
		resultsPage.SwitchToNewTab();
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
		resultsPage.SwitchToNewTab();
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

	//3
	@Test
	public void GIVEN_shopperSelectedItem_WHEN_shopperAddsItemToCart_AND_shopperNavigatesToCart_THEN_checkThatItemIsAddedToCart() {
		
	}
	
	//Antoinette
	@Test
	
	public void GIVEN_shopperIsOnTheLandingPage_WHEN_shopperClicksOnDailyDeals_THEN_checkURL_AND_checkFirstItem() {
			
	}
}
