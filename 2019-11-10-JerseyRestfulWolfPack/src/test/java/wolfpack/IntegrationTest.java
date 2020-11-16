package wolfpack;

import org.junit.Assert;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class IntegrationTest {

	private final String serverBaseAddress = "wolfpack/";
	
	@Test
	public void createWolf() {
		RestAssured.port = 8080;
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.defaultParser = Parser.JSON;
		RestAssured.baseURI = "http://localhost";
		
		
		// http://localhost:8080/wolfpack/createWolf/{name}/{gender}/{birthdate}/{location}
		
		System.out.println("Start createWolf");
		
		    // test variables
			Response response = given().basePath(serverBaseAddress).put("createWolf/Kate/female/04:04:1986/@61.42,43.210");
			
			if (response.getStatusCode() == 200) {
					
				Assert.assertEquals( response.body().jsonPath().getString("name"), "Kate");
				Assert.assertEquals( response.body().jsonPath().getString("gender"), "female");
				Assert.assertEquals( response.body().jsonPath().getString("birthdate"), "04:04:1986");
				Assert.assertEquals( response.body().jsonPath().getString("location"), "[latitude:43.21, longitude:61.42]");
				
			} else {
				
				System.out.println("createWolf doesn't work");
				Assert.assertEquals(response.getStatusCode(), 404);
				
			}
			
			response = given().basePath(serverBaseAddress).put("createWolf/John/male/04:04:2000/@61.42,50.210");
			
			if (response.getStatusCode() == 200) {
					
				Assert.assertEquals( response.body().jsonPath().getString("name"), "John");
				Assert.assertEquals( response.body().jsonPath().getString("gender"), "male");
				Assert.assertEquals( response.body().jsonPath().getString("birthdate"), "04:04:2000");
				Assert.assertEquals( response.body().jsonPath().getString("location"), "[latitude:50.21, longitude:61.42]");
				
			} else {
				
				System.out.println("createWolf doesn't work");
				Assert.assertEquals(response.getStatusCode(), 404);
				
			}	
			
			
	}
	
	
	@Test
	public void createPack() {
		RestAssured.port = 8080;
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.defaultParser = Parser.JSON;
		RestAssured.baseURI = "http://localhost";
		
		
		// http://localhost:8080/wolfpack/createPack/{name}
		
		System.out.println("Start createPack");
		
		
			Response response = given().basePath(serverBaseAddress).put("createPack/alfa");
			
			if (response.getStatusCode() == 200) {
					
					Assert.assertEquals( response.body().jsonPath().getString("name"), "alfa");
					
			} else {
				
				System.out.println("createPack doesn't work");
				Assert.assertEquals(response.getStatusCode(), 404);
				
			}		
	}
	
	
	@Test
	public void getWolfByName() {
		RestAssured.port = 8080;
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.defaultParser = Parser.JSON;
		RestAssured.baseURI = "http://localhost";
		
		
		// http://localhost:8080/wolfpack/getWolfByName/{name}
		
		System.out.println("Start getWolfByName");
		
		    Response responsePut = given().basePath(serverBaseAddress).put("createWolf/Bill/male/05:02:1999/@61.42,50.210");
		    if (responsePut.getStatusCode() == 200) {
		    
		    	Response response = given().basePath(serverBaseAddress).get("getWolfByName/Bill");
				
				if (response.getStatusCode() == 200) {
						
					Assert.assertEquals( response.body().jsonPath().getString("name"), "Bill");
					Assert.assertEquals( response.body().jsonPath().getString("gender"), "male");
					Assert.assertEquals( response.body().jsonPath().getString("birthdate"), "05:02:1999");
					Assert.assertEquals( response.body().jsonPath().getString("location"), "[latitude:50.21, longitude:61.42]");
					
						
				} else {
					
					System.out.println("getWolfByName doesn't work");
					Assert.assertEquals(response.getStatusCode(), 404);
					
				}		
				
		    }else{
				Assert.assertEquals(responsePut.getStatusCode(), 404);
		    }
		    
	}
	
	
	@Test
	public void getPackByName() {
		RestAssured.port = 8080;
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.defaultParser = Parser.JSON;
		RestAssured.baseURI = "http://localhost";
		
		
		// http://localhost:8080/wolfpack/getWolfByName/{name}
		
		System.out.println("Start getPackByName");
		
		Response responsePut = given().basePath(serverBaseAddress).put("createPack/beta");
	    if (responsePut.getStatusCode() == 200) {
	    	
	    	Response response = given().basePath(serverBaseAddress).get("getPackByName/beta");
			
			if (response.getStatusCode() == 200) {
					
				Assert.assertEquals( response.body().jsonPath().getString("name"), "beta");
				
			} else {
				
				System.out.println("getPackByName doesn't work");
				Assert.assertEquals(response.getStatusCode(), 404);
				
			}
			
	    }else{
	    	Assert.assertEquals(responsePut.getStatusCode(), 404);
	    }
				
	}

}
