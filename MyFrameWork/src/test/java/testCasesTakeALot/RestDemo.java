package testCasesTakeALot;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

/*
* Rest assured is java library for testing Restful Web services.
* It can be used to test XML & JSON based web services.
* It supports GET, POST, PUT, PATCH, DELETE, OPTIONS and HEAD requests and
* can be used to validate and verify the response of these requests.
* Syntax: The syntax of Rest Assured.io is the most beautiful part, as it is
* very Gherkin syntax like and understandable.
*
* Given(). param("x", "y"). header("z", "w"). when(). Method(). Then().
* statusCode(XXX). body("x, ”y", equalTo("z"));
*
* Given() ‘Given’ keyword, lets you set a background, here, you pass the
* request headers, query and path param, body, cookies. This is optional if
* these items are not needed in the request
* When() ‘when’ keyword marks the
* premise or actions of your scenario. For example, ‘when’ you get/post/put something, do
* something else. Method() Substitute this with any of the CRUD
* operations(get/post/put/delete)
* Then() Your assert or what you expect and matcher conditions go here 
*
* Methods HTTP methods (GET, PUT, POST, PATCH and DELETE) and these methods can
* be mapped to CRUD operations. GET retrieves the resource at a specified URI.
* PUT updates a resource at a specified URI. Also be used to create a new
* resource at a specified URI. Replaces the entire product entity. PATCH
* support partial updates. POST creates a new resource. DELETE deletes a
* resource at a specified URI.
*/

public class RestDemo {

	@BeforeTest
	public void setUp() {
		// specify the base url to the RESTFUL web service
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/";
	}

	@Test
	public void getResponseExampleAndLoggingWithBaseURI() {
		given().
		when().
		log().all().  // it will print whatever happens after preparing the request but not yet sent to the server
			get("Books"). //the last word (end point) that I deleted from the base URL https://demoqa.com/BookStore/v1/Books
							// and will be appended to the base URI
		then()
			.log().all() // this print/log everything after receiving response from the server
		;
	}
	
	@Test
	public void getResponseExampleAndLoggingWithoutBaseURI() {
		given().
		when().
		log().all().  // it will print whatever happens after preparing the request but not yet sent to the server
			get("https://demoqa.com/BookStore/v1/Books").
		then()
			.log().all() // this print/log everything after receiving response from the server
		;
	}
	
	@Test
	public void testISBNofFirstBook() {
		given().
		when().
		log().all().  // it will print whatever happens after preparing the request but not yet sent to the server
			get("Books").
		then()
		.statusCode(200).
		body("books[0].isbn",equalTo("9781449325862")) //the isbn number of the first book in the array [0] is correct
			.log().all() // this print/log everything after receiving response from the server
		;
	}
	
	@Test
	public void testThePublisherOfTheFourthBook() {
		given().
		when().
		log().all().  // it will print whatever happens after preparing the request but not yet sent to the server
			get("Books").
		then()
		.statusCode(200).
		body("books[3].publisher",equalTo("O'Reilly Media")) //the isbn number of the first book in the array [0] is correct
			.log().all() // this print/log everything after receiving response from the server
		;
	}
	
	@Test
	public void testPageNumbersInt() {
		given().
		when().
			get("Books").
		then()
		.statusCode(200).
		body("books[2].pages",equalTo(238)) 
		;
	}
	
	@Test
	public void testUsingTwoAssertions() {
		given().
		when().
			get("Books").
		then()
		.statusCode(200).
		and().
			body("books[2].pages",equalTo(238)).
		and().
			body("books[3].publisher",equalTo("O'Reilly Media"))
		;
	}
	
	@Test
	public void testSubTitleHasItems() {
		given().
		when().
			get("Books").
		then()
		.statusCode(200).
		body("books.subTitle",hasItems("Harnessing the Power of the Web")) //hasItems is an iterable:  Implementing this interface 
														//allows an object to be the target of the "for-each loop" statement.
		;
	}
	
	@Test
	public void testTitleContains() {
		given().
		when().
			get("Books").
		then()
		.statusCode(200).
		body("books[2].subTitle",containsString("Harnessing"))
		.log().all()
		;
	}
	
	@Test
	public void testCreatingVariable() {  // USE THIS TO GET INFORMATION BACK E.G. A USER'S SESSION ID
		String isbn = 
		given().
		when().
			get("Books").
		then().
		extract().path("books[0].isbn")
		;
		System.out.println("ISBN = " + " " + isbn);
	}
	
	@Test
	public void testExtractAListOfItems() { // print the list of ISBNs
		List<String> isbn = 
		given().
		when().
			get("Books").
		then().
		extract().path("books.isbn")
		;
		System.out.println("LIST OF AVAILABLE ISBNs = " + " " + isbn); //this prints one list of isbns
		
		// Iterate over the list and print individual book item
		for(String anItem : isbn)  // isbn = list collection specified in line 161: List<String> isbn = 
		{
			System.out.println("ISBN iteration: " + " " + anItem); // this prints each isbn separately
			System.out.println("This is the whole collection printed as many times as there are items: " + " " + isbn);
		}
	}
}

