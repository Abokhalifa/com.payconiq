package endPoints;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class getGist extends baseEndPoint {
	private static final String basePath = "/gists";

	public getGist () {
		response = doGetRequest(basePath);
	}
	
	
	public Response getAllGists() {
		return response;
	}
	
	@Test(priority = 1, enabled = true)
	public Response getSpecificGistByID(String gistID) {
		return response;
	}

	@Test(priority = 1, enabled = true)
	public void testResponseCode() {
		int code = response.getStatusCode();
		Assert.assertEquals(code, 200);
	}

	//@Test(groups={"getGist.testResponseSize"},priority = 1, enabled = true)
	public int getCountOfPrivateGists() {
		List<Object> jsonResponse = response.jsonPath().getList("");
		gistCount = jsonResponse.size();
		System.out.println("There are "+gistCount+" public gists in your repo.");
		return gistCount;
	}


}





























