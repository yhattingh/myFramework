package testCasesTakeALot;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameWorkClasses.ReadExcel;
import pageObjectsTakeALot.BasePageTakeALot;

import frameWorkClasses.BasePage;

public class ReadDataFromExcel {
	
BasePageTakeALot basePageTakeAlot = new BasePageTakeALot();

@BeforeTest
public void setUp() {
	basePageTakeAlot.clickCookiesButton();
	//basePageTakeAlot.quizPopUp();
}
	
	//instantiate the class
	ReadExcel readExcel = new ReadExcel();
	
	@Test(dataProvider="Brand and Quantity")
	public void BrandQuantity(String brand, String quantity) {
		System.out.println(brand + " " + quantity);
		int quantityInt = Integer.parseInt(quantity);
		System.out.println("transformed to int " + quantityInt);
	}
	
	
	@Test(dataProvider="Brand and Quantity")
	public void BrandQuantityString(String brand, String quantity) {
		System.out.println("Brand and quantity read from the Excel sheet: " + " " + brand + " " + quantity);
	}
	
	@DataProvider(name = "Brand and Quantity")
	public Object [][] getDataFromExcel(){
		String excelDirectory = readExcel.getDataConfigProperties("excelDataDir");
		Object[][] errObj = readExcel.getExcelData(excelDirectory + "BrandAndQuantity.xlsx","Sheet1");
		return errObj;
	}
	
	@Test(dataProvider="TakeALot")
	public void searchItem(String searchInput, String qty) {
		System.out.println("searchItem and quantity read from the Excel sheet: " + " " + searchInput + " " + qty);
	}
	
	
	@DataProvider(name = "TakeALot")
	public Object [][] getDataFromExcelTakeALot(){
		String excelDirectory = readExcel.getDataConfigProperties("excelDataDir");
		Object[][] errObj = readExcel.getExcelData(excelDirectory + "TakeALot.xlsx","Sheet1");
		return errObj;
	}
}
