package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlaceLocationPojoClass;
import pojo.AddPlaceRequestPojoClass;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Util;

import static org.junit.Assert.*;

public class stepDefination extends Util {

	ResponseSpecification response;
	RequestSpecification requestinfo;
	Response responseInfo;
	static String placeid;
	
	TestDataBuild data = new TestDataBuild();

	@Given("Add Place Payload {string}	{string}	{string}")
	public void add_Place_Payload(String name, String language, String address) throws IOException {

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		requestinfo = given().spec(requestSpecification()).body(data.addPlacePayload(name, language, address));

	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_post_http_request(String resource, String method) {

		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI);

		// Response common details
		response = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if (method.equalsIgnoreCase("POST")) {
			responseInfo = requestinfo.when().post(resourceAPI.getResources()).then().spec(response).extract()
					.response();
		} else if (method.equalsIgnoreCase("GET")) {
			responseInfo = requestinfo.when().get(resourceAPI.getResources()).then().spec(response).extract()
					.response();
		} else if (method.equalsIgnoreCase("DELTE")) {
			responseInfo = requestinfo.when().delete(resourceAPI.getResources()).then().spec(response).extract()
					.response();
		}
	}

	@Then("the API should return a status code {int}")
	public void the_API_should_return_a_status_code(int statusCode) {
		assertEquals(responseInfo.getStatusCode(), statusCode);
	}

	@Then("{string} is response body is {string}")
	public void is_response_body_is(String key, String expectedValue) {
		assertEquals(getJsonPath(responseInfo, key), expectedValue);
	}
	
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedValue, String resources) throws IOException {
		placeid = getJsonPath(responseInfo, "place_id");
		System.out.println(placeid);
		requestinfo = given().spec(requestSpecification()).queryParam("place_id", placeid);
		user_calls_with_post_http_request(resources, "GET");
		String actualvalue = getJsonPath(responseInfo,"name");
		assertEquals(actualvalue, expectedValue);
	}

	@Given("Delete Place Payload")
	public void delete_Place_Payload() throws IOException {
		requestinfo = given().spec(requestSpecification()).body(data.deletePlacePayload(placeid));
	}
}
