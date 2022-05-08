package testCasesTakeALot;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import frameWorkClasses.BasePage;
import frameWorkClasses.ReadExcel;
import pageObjectsTakeALot.BasePageTakeALot;
import pageObjectsTakeALot.CartPage;
import pageObjectsTakeALot.CheckOutPage;
import pageObjectsTakeALot.DealsPage;
import pageObjectsTakeALot.LandingPage;
import pageObjectsTakeALot.LoginPage;
import pageObjectsTakeALot.ResultsPage;
import pageObjectsTakeALot.SelectedItemPage;

public class SingleTestForTestNGTesting {
	
	// instantiate the page objects
	LandingPage landingPage = new LandingPage();
	CartPage cartPage = new CartPage();
	LoginPage loginPage = new LoginPage();
	ResultsPage resultsPage = new ResultsPage();
	DealsPage dealsPage = new DealsPage();
	CheckOutPage checkOutPage = new CheckOutPage();
	BasePageTakeALot basePageTakeAlot = new BasePageTakeALot();
	SelectedItemPage selectedItem = new SelectedItemPage();
	SoftAssert softAssert = new SoftAssert();
	ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel();
	ReadExcel readExcel = new ReadExcel();
	
	@BeforeTest
	public void setUp() {
		basePageTakeAlot.clickCookiesButton();
		// basePageTakeAlot.quizPopUp();
	}

	@AfterTest
	public void cleanUp() throws InterruptedException {
		selectedItem.cleanUp();
	}
	
	@Test(dataProvider = "TakeALot", dataProviderClass = ReadDataFromExcel.class)
	public void GIVEN_shopperOnLandingPage_WHEN_productSelectedFromExcel_THEN_addsToCart(String searchInput, String qty)
			throws InterruptedException {
		System.out.println("Small test");
		System.out.println("What am I reading from excel?" + " " + searchInput + " " + qty);

		// Declare variables
		String searchedProductInput = searchInput;
		

		//basePageTakeAlot.navigateToHomePage();
		
		landingPage.clickSearchBar();
		landingPage.enterTextInSearchBar(searchedProductInput);
		landingPage.clickSearchButton();
		resultsPage.clickSecondItem();
		resultsPage.switchToNewTab();

		selectedItem.clickAddToCartLink();
		selectedItem.clickGoToCartButton();

		Assert.assertEquals(cartPage.checkCartItemCount("(1 item)"), true);
		cartPage.selectQuantity(qty);
		Assert.assertEquals(cartPage.checkCartItemCount(qty), true);
		System.out.println("This is what I expect: " + qty);
		Reporter.log("This is what I expect: " + qty);
		cartPage.removeFromCart();
		Assert.assertTrue(cartPage.checkEmptyCart());
//		cartPage.closeChildBrowserTab();

	}

}
