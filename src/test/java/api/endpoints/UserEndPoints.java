package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	public static Response createUser(User payload){
		
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.postUrl);
		
		return res;
	}
	
	public static Response readUser(String userName){
		
		Response res = given()
			.pathParam("username", userName)
		.when()
			.get(Routes.getUrl);
		
		return res;
	}
	
	public static Response updateUser(String username, User payload){
		
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", username)
			.body(payload)
		.when()
			.put(Routes.updateUrl);
		
		return res;
	}
	
	public static Response deleteUser(String userName){
		
		Response res = given()
			.pathParam("username", userName)
		.when()
			.get(Routes.deleteUrl);
		
		return res;
	}

}
