import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredTest {



	// Get single user
	// Verifies the email address for employee id 2 is 'janet.weaver@reqres.in'
	@Test
	public void verifyUserEmail() {

		//specify base URI
		RestAssured.baseURI = "https://reqres.in/api";

		//Request object
		RequestSpecification httpRequest = RestAssured.given();

		//Response object
		Response response = httpRequest.request(Method.GET, "/users/2");

		//Assert
		response.then().assertThat().content("data.email", equalTo("janet.weaver@reqres.in"));

	}

	// Post login
	// verify the token return value
	@Test
	public void verifyTokenReturnValue() {

		//specify base URI
		RestAssured.baseURI = "https://reqres.in/api";

		//Request object
		RequestSpecification httpRequest = RestAssured.given();

		//Response object
		Response response = httpRequest.request(Method.POST, "/register;password=pistol?email=eve.holt@reqres.in");

		//Assert

	}


	// Delete
	// verify the response code of 204
	@Test
	public void verifyDeleteResponseCode() {

		//specify base URI
		RestAssured.baseURI = "https://reqres.in/api";

		//Request object
		RequestSpecification httpRequest = RestAssured.given();

		//Response object
		Response response = httpRequest.request(Method.DELETE, "/users/2");

		//Assert
		response.then().assertThat().statusCode(204);
	}

	// Patch
	// update Morpheus to Morpheus2
	@Test
	public void canUpdateAndVerify() {

		//specify base URI
		RestAssured.baseURI = "https://reqres.in/api";

		//Request object
		RequestSpecification httpRequest = RestAssured.given();

		//Response object
		Response response = httpRequest.request(Method.PATCH, "/users/2{name}", "morpheus2");

		//Get time stamp
		String timeStamp = response.jsonPath().getString("updatedAt");

		//Assert that the time stamp is not null
		Assert.assertNotNull(timeStamp);
	}

	// Put
	// update Morpheus to Morpheus2 and ensure that timestamp is updated
	@Test
	public void ensureTimeStampUpdate() {

		//specify base URI
		RestAssured.baseURI = "https://reqres.in/api";

		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		RequestSpecification secondHttpRequest = RestAssured.given();
		
		//GetCurrent TimeStamp
		Response response = httpRequest.request(Method.PUT, "/users/2{name}", "morpheus");
		String oldTimeStamp = response.jsonPath().getString("updatedAt");

		//Response object
		Response newResponse = secondHttpRequest.request(Method.PUT, "/users/2{name}", "morpheus2");

		//Get time stamp
		String updatedTimeStamp = newResponse.jsonPath().getString("updatedAt");

		//Assert that the time stamp is not null
		Assert.assertNotEquals(updatedTimeStamp, oldTimeStamp);;
	}
}
