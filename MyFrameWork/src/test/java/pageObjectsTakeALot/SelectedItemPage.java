package pageObjectsTakeALot;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class SelectedItemPage extends BasePage{	
	
	public String getTextOfBrandLink() {
		String text1 = getElementText(By.cssSelector(".title-content-list a"));
		return text1;
	}
	
	//negative test == expected is not == actual
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
		clickElement(By.cssSelector("div:nth-of-type(2) > .button.has-tooltip.image-fallback.size.variant-selector-module_button-selector_1-w9B.variant-selector-module_image-button_1gV7u"));
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
	
	public int getUnitPrice() {
		String unitPriceString = getElementText(By.cssSelector("[data-ref='buybox-price-main']"));
		String unitPriceRstripped = unitPriceString.substring(2);
		String unitPrice = unitPriceRstripped.replaceAll(",",  "");
		int unitPriceInt = Integer.parseInt(unitPrice); //convert string to int
		return unitPriceInt;
	}
	
}
