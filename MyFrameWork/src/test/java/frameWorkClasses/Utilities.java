package frameWorkClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

	public class Utilities extends BasePage{
	// This class is used for creating and moving files -- anything on Selenium related

	// Method to create screenshots
		public void takeSnapShot(String fileWithPath) throws IOException {
			
			// Convert web driver object to TakeScreenshot
			TakesScreenshot scrShot = ((TakesScreenshot)driver);
			
			// call getScreenshot as a method to create an image file
			File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
			
			// move the image file to the new destination
			File destFile = new File(".\\target\\" +"surefire-reports-"+ getAppConfigProperties("build.timestamp") + "//images//" + fileWithPath);
			
			// copy file
			FileUtils.copyFile(scrFile, destFile);
			
			// update the pdf report with the screenshot
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() +
					"'height='200' width='200'/> </a>");
		}

	// Method to create an empty output file

// Method to get the property values from the app.properties file for screenshots
	public String getAppConfigProperties(String propertyName) { // propertyName will be the browser that we are passing
																	// in
		// Properties set
		Properties p = new Properties();
		InputStream is = null;
		try {
			is = new FileInputStream(".\\target\\app.properties"); // the config file name that we want to open ; the
																	// .\\ means the directory where we are now
		} catch (FileNotFoundException e) { // if file does not exist, then we get a catch on the error
			e.printStackTrace();
		}
		try {
			p.load(is); // load the properties object, and pass in is (InputStream) which is the file
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p.getProperty(propertyName); // the property values are returned
	}

	// Method to return the time now for screenshots
	public String timeReturn() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmmss");
		return dtf.format(now);
	}
}
