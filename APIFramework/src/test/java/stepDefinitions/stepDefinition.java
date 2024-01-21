package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;


import static org.junit.Assert.*;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.TestDataBuild;

public class stepDefinition {
	RequestSpecification req;
	RequestSpecification res;
	ResponseSpecification resspec;
	Response resp;
	TestDataBuild data=new TestDataBuild();
	

	@Given("Add place payload")
	public void add_place_payload() {
	    // Write code here that turns the phrase above into concrete actions
		RestAssured.baseURI="https://rahulshettyacademy.com";
	    
	    RequestSpecification req = (RequestSpecification) new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
	    .addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		
	    ResponseSpecification resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	    
		RequestSpecification res = given().spec(req)
		.body(data.addPlacePayload());
		
	}
	@When("user calls {string} with post http request")
	public void user_calls_with_post_http_request(String string) {
	    // Write code here that turns the phrase above into concrete actions
		
		 Response resp = res.when().post("/maps/api/place/add/json")
		.then().spec(resspec).extract().response();
	}
	@Then("the api call is got success with status code {int}")
	public void the_api_call_is_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    
		assertEquals(resp.getStatusCode(),200);
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyvalue, String Expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions
		String response = resp.asString();
		JsonPath js=new JsonPath(response);
		assertEquals(js.get(keyvalue).toString(),Expectedvalue);
	}

	

/*	@Given("add place payload")
	public void add_place_payload() {
	    
	    System.out.println("hello");
	}
	@When("user calls {string} with post http request")
	public void user_calls_with_post_http_request(String string) {
		System.out.println("hello");
	}
	@Then("the api call is got success with status code {int}")
	public void the_api_call_is_got_success_with_status_code(Integer int1) {
		System.out.println("hello");
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String string, String string2) {
		System.out.println("hello");
	}*/



}
