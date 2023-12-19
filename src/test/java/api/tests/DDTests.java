package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	
	@Test(priority=1, dataProvider="data", dataProviderClass=DataProviders.class )
	public void testPostuser(String userID, String userName, String fname, String lname, String useremail, String pwd, String phone) {
		
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirtsname(fname);
		userPayload.setLastname(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phone);
		
		Response res = UserEndPoints.createUser(userPayload);
		res.statusLine();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority=2, dataProvider="userNames", dataProviderClass=DataProviders.class )
	public void testDeleteUserByName(String userName) {
		
		Response res = UserEndPoints.deleteUser(userName);
		res.statusLine();
		Assert.assertEquals(res.getStatusCode(), 200);
	}

}
