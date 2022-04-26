package pageObjectsTakeALot;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class SelectedItemPage extends BasePage {

	public String getTextOfBrandLink() {
		String text1 = getElementText(By.cssSelector(".title-content-list a"));
		return text1;
	}

	// negative test == expected is not == actual
//	public String getTextOfBrandLink() {
//	String text1 = getElementText(By.cssSelector("h1"));
//	return text1;
//	}

	public String getTextOfProductTitle() {
		String text2 = getElementText(By.cssSelector("h1"));
		return text2;
	}

	public void selectColour() {
		clickElement(By.cssSelector("div[role='button']  div[role='button'] > img[alt='White']"));
	}

	public void selectClickShoeSize() {
		clickElement(By.cssSelector(
				"div:nth-of-type(5) > .button.has-tooltip.image-fallback.size.variant-selector-module_button-selector_1-w9B.variant-selector-module_image-button_1gV7u"));
	}

	public boolean addToCartButtonIsAvailable() {
		waitForElement(10, By.cssSelector((".buybox-actions-module_add-to-cart-cell_3fXyS [href]")));
		return true;
	}

	public void clickAddToCartButton() {
		clickElement(By.cssSelector(".buybox-actions-module_add-to-cart-cell_3fXyS [href]"));
	}

	public void clickAddToCartLink() {
		clickElement(By.linkText("Add to Cart"));
	}

	public void clickGoToCartButton() {
		clickElement(By.cssSelector(".content-wrapper .checkout-now"));
	}

//	public int getUnitPrice() { //this option also works, but the method below is better
//		String unitPriceString = getElementText(By.cssSelector("[data-ref='buybox-price-main']"));
//		String unitPriceRstripped = unitPriceString.substring(2); // start at char 2 and ignore 0 and 1
//		String unitPrice = unitPriceRstripped.replaceAll(",",  ""); // remove comma , and spaces
//		int unitPriceInt = Integer.parseInt(unitPrice); //convert string to int
//		return unitPriceInt;
//	}

	public int getUnitPrice() { // use either ^0-9 or \\D
		String unitPriceString = getElementText(By.cssSelector("[data-ref='buybox-price-main']"));
		// String unitPrice = unitPriceString.replaceAll("[^0-9]", ""); //regex:  removes everything except 0-9
		// / remove everything except the numbers 0-9
		String unitPrice = unitPriceString.replaceAll("\\D", ""); //regex:  removes everything except numbers
		int unitPriceInt = Integer.parseInt(unitPrice); // convert string to int 
		return unitPriceInt;
	} //***************************1:14 == 02:42:35 create properties file
}
