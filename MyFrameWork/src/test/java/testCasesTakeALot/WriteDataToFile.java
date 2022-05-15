package testCasesTakeALot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import frameWorkClasses.ReadExcel;
import frameWorkClasses.Utilities;

public class WriteDataToFile {

	// instantiate the utilities class object
	Utilities utilities = new Utilities();
	ReadExcel rExcel = new ReadExcel();

	String outputDirectory = utilities.getDataConfigProperties("outputDir"); // outputDir is the property in the config
																				// file
	String outputFile = outputDirectory + "output14.txt"; // this file will be saved in the dir above

	@BeforeTest
	public void setup() {
		utilities.resetOutPutFile(outputFile);
	}

	// This reads from the excel file specified in the ReadDataFromExcel class and
	// writes to the txt file
	@Test(dataProvider = "Brand and Quantity", dataProviderClass = ReadDataFromExcel.class)
	public void writingToFile(String brand, String quantity) {

		boolean bool = true;

		String result;
		if (bool) {
			result = "This is the correct result";
		} else {
			result = "This is the incorrect result";
		}

		String content = brand + "," + quantity + "," + result;

		try {
			/*
			 * NB: if an error on File.write, then make sure you have imported import
			 * java.nio.file.Files; path = the path to the file bytes = the byte array with
			 * the bytes to write options = options to specifying how the file is opened
			 * Files.write(null, null, null)
			 */
			Files.write(Paths.get(outputFile), (content + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("the error is " + e.getMessage());
		}

	}

}
