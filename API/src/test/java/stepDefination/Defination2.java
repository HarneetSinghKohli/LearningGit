package stepDefination;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.assertion.*;
import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.BeforeClass;

import pojo.Login;
import resources.APIResources;
import resources.TestData;
import resources.Utils;


public class Defination2 extends Utils{

	Login L=new Login();
	TestData T=new TestData();
	RequestSpecification req;
	Response resp;
	

	@Given("body with {string} {string} {string} {string}")
	public void body_with_and(String userName, String password,String scope,String Status) throws IOException {
		 req=given().spec(requestSpecification(userName,password)). 	//Definations2 becomes child class
				 body(T.credentialsPayload(userName,password,scope,Status));										// which implements all the methods
	}												// of Utils class without creating any object			

	@When("when user calls {string} with {string} request")
	public void when_user_calls_with_request(String resource,String requestType) {
		APIResources resourceAPI=APIResources.valueOf(resource);
		if(requestType.equalsIgnoreCase("GET")) 
			resp=req.when().get(resourceAPI.returnResource()).then().extract().response();
		else if(requestType.equalsIgnoreCase("POST")) 
			resp=req.when().post(resourceAPI.returnResource()).then().extract().response();
		
	}
	@Then("API call got success with status code {int}")
	public void api_call_got_success_with_status_code(Integer int1) {
		Assert.assertEquals(Integer.valueOf(resp.getStatusCode()),Integer.valueOf(int1));
	}

	@Then("{string} in response message is {string}")
	public void in_response_message_is(String keyValue, String ExpectedValue) {
	JsonPath js=new JsonPath(resp.asString());
	System.out.println(js.get(keyValue));
	System.out.println(ExpectedValue);
	Assert.assertEquals(js.get(keyValue),ExpectedValue);
	}

}
