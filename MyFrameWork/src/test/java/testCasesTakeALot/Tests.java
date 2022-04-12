package testCasesTakeALot;

import javax.naming.directory.SearchResult;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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

public class Tests {
	
	//instantiate the page objects
	LandingPage landingPage = new LandingPage();
	CartPage cartPage = new CartPage();
	LoginPage loginPage = new LoginPage();
	ResultsPage resultsPage = new ResultsPage();
	DealsPage dealsPage = new DealsPage();
	CheckOutPage checkOutPage = new CheckOutPage();
	BasePageTakeALot basePageTakeAlot = new BasePageTakeALot();
	
	@BeforeTest
	public void setUp() {
		basePageTakeAlot.clickCookiesButton();
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
	public void GIVEN_shopperIsOnTheLandingPage_WHEN_shopperEntersDKNYasTheSearchString_AND_shopperClicksTheSearchButton_THEN_DKNYBeDelicious50mlIsDisplayedAsTheFirstItem() {
		basePageTakeAlot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.enterTextInSearchBar("DKNY");
		landingPage.clickSearchButton();
		resultsPage.clickFirstItem();

	}
	
	//2b
	@Test
	public void GIVEN_shopperIsOnTheLandingPage_WHEN_shopperEntersHillsasTheSearchString_AND_shopperClicksTheSearchButton_THEN_HillsIsDisplayedAsTheSecondItem() {
		basePageTakeAlot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.enterTextInSearchBar("Hills");
		landingPage.clickSearchButton();
		resultsPage.clickSecondItem();

	}
	
	//2c
	@Test
	public void GIVEN_shopperIsOnTheLandingPage_WHEN_shopperEntersHillsasTheSearchString_AND_shopperClicksTheSearchButton_THEN_HillsIsDisplayedAsTheThirdItem() {
		basePageTakeAlot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.enterTextInSearchBar("Hills");
		landingPage.clickSearchButton();
		resultsPage.clickThirdItem();

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
