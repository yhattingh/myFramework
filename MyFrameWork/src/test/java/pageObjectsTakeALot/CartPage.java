package pageObjectsTakeALot;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;

import frameWorkClasses.BasePage;

public class CartPage extends BasePage{
	
	//check that cart is empty - isCartEmpty boolean
	public boolean checkEmptyCart() {
		String itemElement = "img[alt='Empty shopping cart']";
		if (driver.findElements(By.cssSelector(itemElement)).size() != 0) {
			System.out.println("Element exists");
			Reporter.log("Element exists : " + itemElement);
			Reporter.log("Text is " + getElementText(By.cssSelector(itemElement)));
			return true;
		} else {
			System.out.println("Element does not exist");
			Reporter.log("Element does not exist " + itemElement);
			Reporter.log("Text is " + getElementText(By.cssSelector(itemElement)));
			return false;
		}
	}
	
	//another way to check empty cart
	public boolean checkEmptyCartWithIsDisplayed() {
		String itemElement = "img[alt='Empty shopping cart']";
		Boolean display = elementExists(By.cssSelector(itemElement));
		Reporter.log("Element exists: " + itemElement);
		return display;
	}
	
	
	// check Cart count - my method
	public String checkCartCount() {
		String text1 = getElementText(By.cssSelector(".cart-summary-module_cart-summary-item-count_3jkNC > span"));
		return text1;
	}

	// check Cart count - Louise method
	public boolean checkCartItemCount(String checkCount) throws InterruptedException {
		String itemElement = ".cart-summary-module_cart-summary-item-count_3jkNC > span";
		System.out.println("itemElement " + getElementText(By.cssSelector(itemElement)));
		System.out.println("checkCount " + checkCount);
		//note:  Assert.assertEquals(cartPage.checkCartItemCount("(1 item)"), true) ::: checkCount == (1 item) passed in

		if (getElementText(By.cssSelector(itemElement)).contains(checkCount))

		{
			Reporter.log("Count is Correct " + checkCount);
			Reporter.log("Text is " + getElementText(By.cssSelector(itemElement)));
			return true;
		}
		Reporter.log("Count is Incorrect " + checkCount);
		Reporter.log("Text is " + getElementText(By.cssSelector(itemElement)));
		return false;
	}
			
	public void selectQuantity(String quant)throws InterruptedException {
		selectDropdown(By.id("cart-item_undefined"),quant);
	}
	
	//remove items from cart
	public void removeFromCart() {
		clickElement(By.cssSelector(".button.clear.remove-item"));
	}
	
	//checkout items
	
	//paymentOption
}

