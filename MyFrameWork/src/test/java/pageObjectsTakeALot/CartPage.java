package pageObjectsTakeALot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import frameWorkClasses.BasePage;

public class CartPage extends BasePage{
	
	//check that cart is empty - isCartEmpty boolean
	public boolean checkEmptyCart() {
		String itemElement = "img[alt='Empty shopping cart']";
		if (driver.findElements(By.cssSelector(itemElement)).size() != 0) {
			System.out.println("Element exists");
			Reporter.log("Element exists : " + getElementText(By.cssSelector(itemElement)));
			Reporter.log("Text is " + getElementText(By.cssSelector(itemElement)));
			return true;
		} else {
			System.out.println("Element does not exist");
			Reporter.log("Element does not exist " + getElementText(By.cssSelector(itemElement)));
			Reporter.log("Text is " + getElementText(By.cssSelector(itemElement)));
			return false;
		}
	}
	
	//another way to check empty cart
	public boolean checkEmptyCartWithIsDisplayed() {
		String itemElement = "img[alt='Empty shopping cart']";
		Boolean display = elementExists(By.cssSelector(itemElement));
//		Reporter.log("Element exists: " + itemElement);
		Reporter.log("Element exists and then use display: " + display);
		return display;
	}
	
	
	// check Cart count - my method
	public String checkCartCount() {
		String text1 = getElementText(By.cssSelector(".cart-summary-module_cart-summary-item-count_3jkNC > span"));
		return text1;
	}

	// check Cart count - Louise method
	public boolean checkCartItemCount(String checkCount) throws InterruptedException {
		Thread.sleep(2000);
		String itemElement = ".cart-summary-module_cart-summary-item-count_3jkNC > span";
		
		System.out.println("checkCount : " + checkCount);
		System.out.println("itemElement :" + (getElementText(By.cssSelector(itemElement))));
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
	
	
//  see if I can establish which selected item's count should be displayed	
//	//check element text to establish which checkCartItemCount
//	public String getItemText(String getItemText) {
//		String itemText = getElementText(By.cssSelector(".badge-button-module_badge-button_3TXVp"));
//		return getItemText;
//		
//	}
	
	//checkout items
	
	//paymentOption
}

