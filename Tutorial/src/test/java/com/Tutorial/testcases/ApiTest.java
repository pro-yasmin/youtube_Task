package com.Tutorial.testcases;

import org.testng.annotations.Test;

import com.Tutorial.api.service.ApiPage;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ApiTest {
	public ApiTest(){
		super();
		// TODO Auto-generated constructor stub
	      }

	//ApiPage apiPageObj= new ApiPage(driver);
	private static String url="https://jsonplaceholder.typicode.com/";
	
	@Test
	public void getRandomID() {
		RestAssured.baseURI = url; 
		
		RequestSpecification httpRequest = RestAssured.given(); 
		
		Response res = httpRequest.get("users/");

		ResponseBody body = res.body();

		String rbdy = body.asString();
		
		System.out.println(rbdy);

		JsonPath jpath = new JsonPath(rbdy);

		String id = jpath.getString("id");
		
		System.out.println(id);


	}
}
