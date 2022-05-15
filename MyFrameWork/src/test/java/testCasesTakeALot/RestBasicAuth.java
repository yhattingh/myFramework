package testCasesTakeALot;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class RestBasicAuth {
	
	@BeforeTest
	public void setUp() {
		// specify the base url to the RESTFUL web service
		RestAssured.baseURI = "https://postman-echo.com/basic-auth";
	}
	
	@Test
	public void AuthenticationBasics() {
		given()
			.auth().basic("postman","password").
		then()
			.statusCode(200)
			.header("sessionid",equalTo(null)).log().all()
		;
	}

}
