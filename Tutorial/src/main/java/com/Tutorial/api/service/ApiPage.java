package com.Tutorial.api.service;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import java.util.Properties;

public class ApiPage {
	private static String url="https://jsonplaceholder.typicode.com/";
	private Properties properties;
	
	public ApiPage(Properties properties) {
		this.properties = properties;	
	}

	public void getRandomID() {
		RestAssured.baseURI = url; 
		
		RequestSpecification httpRequest = RestAssured.given(); 
		
		Response res = httpRequest.get("users/");

		ResponseBody body = res.body();

		String rbdy = body.asString();
		
		System.out.println(rbdy);


	}
}
