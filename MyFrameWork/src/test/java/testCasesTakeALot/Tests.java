package testCasesTakeALot;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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

import org.testng.asserts.SoftAssert;

public class Tests {

	// instantiate the page objects
	LandingPage landingPage = new LandingPage();
	CartPage cartPage = new CartPage();
	LoginPage loginPage = new LoginPage();
	ResultsPage resultsPage = new ResultsPage();
	DealsPage dealsPage = new DealsPage();
	CheckOutPage checkOutPage = new CheckOutPage();
	BasePageTakeALot basePageTakeAlot = new BasePageTakeALot();
	SelectedItemPage selectedItemPage = new SelectedItemPage();
	SoftAssert softAssert = new SoftAssert();
	ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel();
	ReadExcel readExcel = new ReadExcel();
	WriteDataToFile writeDataToFile = new WriteDataToFile();

	@BeforeTest
	public void setUp() {
		basePageTakeAlot.clickCookiesButton();
		// basePageTakeAlot.quizPopUp();
	}

	@AfterTest
	public void cleanUp() throws InterruptedException {
		selectedItemPage.cleanUp();
	}

//	@AfterMethod
//	public void closeChildWindow() {
//		selectedItemPage.closeChildBrowserTab();
//	}

	@Test
	public void checkPDF() throws Exception {
		// variable to store where the pdf is (can also be setup in the
		// config.properties file)
		String pdfURL = "file:///C:/autoProgram/myFramework/MyFrameWork/target/ISO Standards.pdf";
		// check number of the pages in the pdf

		// declare a variable for the expected number of pages
		int expectedNoPages = 11; // no need to assert here, this will be tested

		// read the contents of the pdf
		String pdfContent = landingPage.readPDFContent(pdfURL, expectedNoPages);
		// assert that the pdf contains certain text
		Assert.assertTrue(pdfContent.contains("engineering"));
	}

	// 1
	@Test
	public void GIVEN_shopperIsOnTheLandingPage_WHEN_shopperClicksCartButton_THEN_ChecksThatShopperIsOnCartPage_THEN_CheckThatCartIsEmpty() {

	}

	// 2a
	@Test
	public void GIVEN_shopperIsOnTheLandingPage_WHEN_shopperEntersDKNYasTheSearchString_AND_shopperClicksTheSearchButton_THEN_DKNYDisplayedAsTheFirstItem() {

		// Declare variables
		String searchedText = "DKNY Original";
		String actualText; // to have all declared variables in one place but we cannot have actualText =
							// selectedItem.getTextOfTitleElement(); here
							// because it then expects we already have this variable which we only get in
							// line 104
		String expectedResult = "DKNY";

		// basePageTakeAlot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.clearSearchBarText();
		landingPage.enterTextInSearchBar(searchedText);
		landingPage.clickSearchButton();
		resultsPage.clickSecondItem();
		resultsPage.switchToNewTab();
		actualText = selectedItemPage.getTextOfBrandLink();
		System.out.println("Actual Result:" + " " + actualText);
		Reporter.log("Expected Result : " + expectedResult);
		Reporter.log("Actual Result : " + actualText);
		Assert.assertEquals(actualText, expectedResult);
		resultsPage.closeChildBrowserTab();
	}

	// 2b
	@Test
	public void GIVEN_shopperIsOnTheLandingPage_WHEN_shopperEntersHillsasTheSearchString_AND_shopperClicksTheSearchButton_THEN_HillsIsDisplayedAsTheSecondItem()
			throws InterruptedException {

		// Declare variables
		String searchedText = "Hills";
		String actualText;
		String expectedResult = searchedText;

		// basePageTakeAlot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.clearSearchBarText();
		landingPage.enterTextInSearchBar(searchedText);
		landingPage.clickSearchButton();
		resultsPage.clickSecondItem();
		resultsPage.switchToNewTab();
		actualText = selectedItemPage.getTextOfBrandLink();
		System.out.println("Actual Result:" + " " + actualText);
		Reporter.log("Expected Result : " + expectedResult);
		Reporter.log("Actual Result : " + actualText);
		Assert.assertEquals(actualText, expectedResult);
		resultsPage.closeChildBrowserTab();
	}

	// 2c
	@Test
	public void GIVEN_shopperIsOnTheLandingPage_WHEN_shopperEntersGeniusAsTheSearchString_AND_shopperClicksTheSearchButton_THEN_GeniusIsDisplayedAsTheThirdItem() {

		// Declare variables
		String searchedText = "Genius";
		String actualText;
		String expectedResult = searchedText;

//		basePageTakeAlot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.clearSearchBarText();
		landingPage.enterTextInSearchBar(searchedText);
		landingPage.clickSearchButton();
		resultsPage.clickThirdItem();
		resultsPage.switchToNewTab();
		actualText = selectedItemPage.getTextOfBrandLink();
		System.out.println("Actual Result:" + " " + actualText);
		Reporter.log("Expected Result : " + expectedResult);
		Reporter.log("Actual Text : " + actualText);
		assertTrue(actualText.contains(expectedResult));
		resultsPage.closeChildBrowserTab();

	}

	// 2d
	@Test
	public void GIVEN_shopperIsOnTheLandingPage_WHEN_shopperEntersBootAsTheSearchString_AND_shopperClicksTheSearchButton_THEN_BootIsDisplayedAsTheThirdItem()
			throws InterruptedException {

		// Declare variables
		String searchedProductInput = "TTP";
		String searchedBrand = "TTP";

		String actualTextOfProductTitle;
		String actualTextOfBrandLink;

		landingPage.clickSearchBar();
		landingPage.clearSearchBarText();
		landingPage.enterTextInSearchBar(searchedProductInput);
		landingPage.clickSearchButton();
		resultsPage.clickFourthItem();
		resultsPage.switchToNewTab();
		actualTextOfProductTitle = selectedItemPage.getTextOfProductTitle();
		System.out.println("Actual PRODUCT contains the word " + " " + searchedProductInput + " "
				+ "and the product text is" + " " + actualTextOfProductTitle);
		actualTextOfBrandLink = selectedItemPage.getTextOfBrandLink();
		System.out.println("Actual BRAND = " + actualTextOfBrandLink);
		Reporter.log("Expected Product Title Result : " + searchedProductInput);
		Reporter.log("Actual Product Title Result : " + actualTextOfProductTitle);
		Reporter.log("Expected Brand Link  Result : " + searchedBrand);
		Reporter.log("Actual Brand Link Result : " + actualTextOfBrandLink);
		Assert.assertTrue(actualTextOfProductTitle.contains(searchedProductInput));
		Assert.assertEquals(actualTextOfBrandLink, searchedBrand);
		softAssert.assertEquals(actualTextOfBrandLink, "who knows");
		Reporter.log("Actual Result for softAssert " + actualTextOfBrandLink + " ; " + "printed result for softAssert: "
				+ searchedProductInput);
		// softAssert.assertAll();
		resultsPage.closeChildBrowserTab();
	}

	// 2e
	@Test
	public void GIVEN_shopperIsOnTheLandingPage_WHEN_shopperEntersHillsAsTheSearchString_AND_shopperClicksTheSearchButton_THEN_HillsIsDisplayedAsTheThirdItem() {

		// Declare variables
		String searchedProductInput = "Hills";
		String searchedBrand = "Hills";

		String actualTextOfProductTitle;
		String expectedProductResult = searchedProductInput;

		String actualTextOfBrandLink;
		String expectedTextOfBrandLink = searchedBrand;

		landingPage.clickSearchBar();
		landingPage.clearSearchBarText();
		landingPage.enterTextInSearchBar(searchedBrand);
		landingPage.clickSearchButton();
		resultsPage.clickThirdItem();
		resultsPage.switchToNewTab();
		actualTextOfProductTitle = selectedItemPage.getTextOfProductTitle();
		System.out.println("Actual PRODUCT contains the word " + " " + expectedProductResult + " "
				+ "and the product text is" + " " + actualTextOfProductTitle);
		actualTextOfBrandLink = selectedItemPage.getTextOfBrandLink();
		System.out.println("Actual BRAND = " + actualTextOfBrandLink);
		Reporter.log("Expected Product Title Result : " + expectedProductResult);
		Reporter.log("Actual Product Title Result : " + actualTextOfProductTitle);
		Reporter.log("Expected Brand Link  Result : " + expectedTextOfBrandLink);
		Reporter.log("Actual Brand Link Result : " + actualTextOfBrandLink);
		Assert.assertTrue(actualTextOfProductTitle.contains(expectedProductResult));
		Assert.assertEquals(actualTextOfBrandLink, expectedTextOfBrandLink);
		resultsPage.closeChildBrowserTab();
	}

	// 2f - ADD TO CART
	@Test
	public void TESTGIVEN_shopperIsOnTheLandingPage_WHEN_shopperEntersBootAsTheSearchString_AND_shopperClicksTheSearchButton_THEN_shopperAddsItemToCart()
			throws InterruptedException {

		// Declare variables
		String searchedProductInput = "EcoFlow RIVER Pro";
		String searchedBrand = "EcoFlow";

		String actualTextOfProductTitle;
		String expectedProductResult = searchedBrand;

		String actualTextOfBrandLink;
		String expectedTextOfBrandLink = searchedBrand;

		String actualItemCount;
		String expectedItemCount = "(1 item)";

		landingPage.clickSearchBar();
		landingPage.clearSearchBarText();
		landingPage.enterTextInSearchBar(searchedProductInput);
		landingPage.clickSearchButton();
		resultsPage.clickSecondItem();
		resultsPage.switchToNewTab();

		actualTextOfProductTitle = selectedItemPage.getTextOfProductTitle();
		System.out.println("Actual PRODUCT contains the word " + " " + expectedProductResult + " "
				+ "and the product text is" + " " + actualTextOfProductTitle);

		actualTextOfBrandLink = selectedItemPage.getTextOfBrandLink();
		System.out.println("Actual BRAND = " + actualTextOfBrandLink);

		Reporter.log("Expected Product Title Result : " + expectedProductResult);
		Reporter.log("Actual Product Title Result : " + actualTextOfProductTitle);
		Reporter.log("Expected Brand Link  Result : " + expectedTextOfBrandLink);
		Reporter.log("Actual Brand Link Result : " + actualTextOfBrandLink);

		Assert.assertTrue(actualTextOfProductTitle.contains(searchedBrand));
		Assert.assertEquals(actualTextOfBrandLink, expectedTextOfBrandLink);

		selectedItemPage.clickAddToCartLink();
		selectedItemPage.clickGoToCartButton();

		// my method
		actualItemCount = cartPage.checkCartCount();

		Reporter.log("Expected count is: " + " " + expectedItemCount);
		Reporter.log("Actual item count is: " + " " + actualItemCount);
		Assert.assertEquals(actualItemCount, expectedItemCount);

		// Louise method
		Assert.assertEquals(cartPage.checkCartItemCount("(1 item)"), true);
		cartPage.selectQuantity("2");
		Assert.assertEquals(cartPage.checkCartItemCount("(2 items)"), true);

		resultsPage.closeChildBrowserTab();
	}

	// 2G - verify the unit price
//	@Test
//	public void GIVEN_shopperIsOnTheLandingPage_WHEN_shopperEntersBootAsTheSearchString_AND_shopperSelectsAnItem_THEN_shopperChecksUnitPrice_AND_addItemToCart()
//			throws InterruptedException {
//
//		// Declare variables
//		String searchedProductInput = "TTP Women's Lace-Up Combat Boot XB1601 with Patent Finish";

//		basePageTakeAlot.navigateToHomePage();
//		landingPage.clickSearchBar();
//		landingPage.enterTextInSearchBar(searchedProductInput);
//		landingPage.clickSearchButton();
//		resultsPage.clickFirstItem();
//		resultsPage.switchToNewTab();
//
//		selectedItemPage.selectColour();
//		selectedItemPage.selectClickShoeSize();
//		Assert.assertTrue(selectedItemPage.addToCartButtonIsAvailable());

//		int unitPrice = selectedItemPage.getUnitPrice();
//		System.out.println("Unit Price is R " + unitPrice);
//		Reporter.log("The unit price is R" + unitPrice);
//
//		selectedItemPage.clickAddToCartLink();
//		selectedItemPage.clickGoToCartButton();
//
//		Assert.assertEquals(cartPage.checkCartItemCount("(1 item)"), true); // "(1 item)" = checkCount on
//																			// checkCartItemCount method
//		cartPage.selectQuantity("2");
//		Assert.assertEquals(cartPage.checkCartItemCount("(2 items)"), true);
//		cartPage.closeChildBrowserTab();
//
//	}

	// 2G - verify the unit price and strip out the comma in the price and empty
	// cart
	@Test
	public void GIVEN_shopperIsOnTheLandingPage_WHEN_shopperEntersEcoFlowRIVERPro_AsTheSearchString_AND_shopperSelectsAnItem_THEN_shopperChecksUnitPrice_AND_addItemToCart()
			throws InterruptedException {

		// Declare variables
		String searchedProductInput = "EcoFlow RIVER Pro";

//		basePageTakeAlot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.clearSearchBarText();
		landingPage.enterTextInSearchBar(searchedProductInput);
		landingPage.clickSearchButton();
		resultsPage.clickSecondItem();
		resultsPage.switchToNewTab();

		int unitPrice = selectedItemPage.getUnitPrice();
		System.out.println("Unit Price is R " + unitPrice);
		Reporter.log("The unit price is R" + unitPrice);

		selectedItemPage.clickAddToCartLink();
		selectedItemPage.clickGoToCartButton();

		Assert.assertEquals(cartPage.checkCartItemCount("(1 item)"), true); // "(1 item)" = checkCount on
																			// checkCartItemCount method
		cartPage.selectQuantity("3"); // selects from a dropdown
		Assert.assertEquals(cartPage.checkCartItemCount("(3 items)"), true);
		cartPage.selectQuantity("1"); // selects from a dropdown
		Assert.assertEquals(cartPage.checkCartItemCount("(1 item)"), true);
		cartPage.removeFromCart();
		Assert.assertEquals(cartPage.checkEmptyCart(), true);
		Assert.assertEquals(cartPage.checkEmptyCartWithIsDisplayed(), true);
		Reporter.log("Removed from cart? " + cartPage.checkEmptyCart());
		resultsPage.closeChildBrowserTab();
	}

	// 2H - verify cart is empty
	@Test
	public void GIVEN_shopperIsOnTheLandingPage_WHEN_shopperHoversOverTrollie_THEN_displayItemCount()
			throws InterruptedException {
		// declare variables
		String expectedResult = "0";

//		basePageTakeAlot.navigateToHomePage();
		System.out.println("Item count is: " + landingPage.cartSummary());
		Reporter.log("Item count is: " + landingPage.cartSummary());
		// Assert.assertEquals(landingPage.cartSummary2("0"), true); //enter expected
		// number
		Assert.assertEquals(landingPage.cartSummary2(expectedResult), true); // use variable declared

	}

	// 2I - read from Excel
	@Test(dataProvider = "TakeALot", dataProviderClass = ReadDataFromExcel.class)
	public void GIVEN_shopperOnLandingPage_WHEN_productSelectedFromExcel_THEN_addsToCart(String searchInput, String qty)
			throws InterruptedException {
		System.out.println("What am I reading from excel?" + " " + searchInput + " " + qty);

		// Declare variables
		String searchedProductInput = searchInput;

		writeDataToFile.writingToFile(searchedProductInput, qty);

		landingPage.clickSearchBar();
		landingPage.clearSearchBarText();
		landingPage.enterTextInSearchBar(searchedProductInput);
		landingPage.clickSearchButton();
		resultsPage.clickSecondItem();
		resultsPage.switchToNewTab();

		selectedItemPage.clickAddToCartLink();
		selectedItemPage.clickGoToCartButton();

		Assert.assertEquals(cartPage.checkCartItemCount("(1 item)"), true);
		cartPage.selectQuantity(qty);
		Assert.assertEquals(cartPage.checkCartItemCount(qty), true);
		System.out.println("This is what I expect: " + qty);
		Reporter.log("This is what I expect: " + qty);
		cartPage.removeFromCart();
		Assert.assertTrue(cartPage.checkEmptyCart());
		cartPage.closeChildBrowserTab();
	}

	@Test(dataProvider = "Brand and Quantity", dataProviderClass = ReadDataFromExcel.class)
	public void shouldReadFromAndWriteToFile(String searchInput, String qty) throws InterruptedException {
		System.out.println("What am I reading from excel?" + " " + searchInput + " " + qty);

		// Declare variables
		String searchedProductInput = searchInput;

		writeDataToFile.writingToFile(searchedProductInput, qty);

//		basePageTakeAlot.navigateToHomePage();
		landingPage.clickSearchBar();
		landingPage.clearSearchBarText();
		landingPage.enterTextInSearchBar(searchedProductInput);
		landingPage.clickSearchButton();
		resultsPage.clickSecondItem();
		resultsPage.switchToNewTab();

		selectedItemPage.clickAddToCartLink();
		selectedItemPage.clickGoToCartButton();

		Assert.assertEquals(cartPage.checkCartItemCount("(1 item)"), true);
		cartPage.selectQuantity(qty);
		Assert.assertEquals(cartPage.checkCartItemCount(qty), true);
		System.out.println("This is what I expect: " + qty);
		Reporter.log("This is what I expect: " + qty);
		cartPage.removeFromCart();
		Assert.assertTrue(cartPage.checkEmptyCart());
		cartPage.closeChildBrowserTab();
	}

//	@Test(dataProvider = "TakeALot", dataProviderClass = ReadDataFromExcel.class)
//	public void GIVEN_shopperOnLandingPage_WHEN_productSelectedFromExcel_THEN_addsToWishList(String searchInput, String qty)
//			throws InterruptedException {
//		System.out.println(searchInput + " " + qty);
//
//		// Declare variables
//		String searchedProductInput = searchInput;
//		String selectQuantity = qty;
//
//		basePageTakeAlot.navigateToHomePage();
//		landingPage.clickSearchBar();
//		landingPage.enterTextInSearchBar(searchedProductInput);
//		landingPage.clickSearchButton();
//		resultsPage.clickSecondItem();
//		resultsPage.switchToNewTab();
//
//		selectedItem.clickAddToCartLink();
//		selectedItem.clickGoToCartButton();
//
//		Assert.assertEquals(cartPage.checkCartItemCount("(1 item)"), true);
//		cartPage.selectQuantity(selectQuantity);
//		Assert.assertEquals(cartPage.checkCartItemCount("(3 items)"), true);
//		cartPage.removeFromCart();
//		Assert.assertTrue(cartPage.checkEmptyCart());
//		cartPage.closeChildBrowserTab();
//
//	}

}
