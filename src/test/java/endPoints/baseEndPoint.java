package endPoints;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class baseEndPoint {
	
	public static final String token = "f7736f512bc0afc553beac056cd94232c4d1a2e4"; //Please set this token with a valid token
	public static int gistCount = 0;
	public static Response response;
	public static String body="";
	public static RequestSpecification httpRequest;
	public static String gistID="";
	
	
	public baseEndPoint(){
		RestAssured.baseURI = "https://api.github.com";
		httpRequest = RestAssured.given();	
		
	}
	
	public Response doGetRequest(String endpoint) {
		httpRequest.headers("Content-Type","application/json","Authorization","Bearer " + token);
		response = httpRequest.request(Method.GET,endpoint);
		return response;
				
	}
	
	public Response doPostRequest(String endpoint,String body) {
		httpRequest.headers("Content-Type","application/json","Authorization","Bearer " + token);
		httpRequest.body(body);
		Response response = httpRequest.request(Method.POST,endpoint);
		
		return response;
				
	}
	
	public Response doDeleteRequest(String endpoint,String ID) {
		httpRequest.headers("Content-Type","application/json","Authorization","Bearer " + token);
		Response response = httpRequest.request(Method.DELETE,endpoint+"/"+ID);
		return response;
						
	}

	

}


































