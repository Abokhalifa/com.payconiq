package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import endPoints.baseEndPoint;
import endPoints.createGist;
import endPoints.deleteGist;
import endPoints.getGist;
import endPoints.searchGist;
import net.minidev.json.JSONObject;




public class functionalTests {

	getGist getGistEndPoint;
	createGist createGistEndPoint;
	searchGist searchGistEndPoint;
	deleteGist deleteGistEndPoint;
	baseEndPoint baseEndPoint;

	public functionalTests() throws IOException {
		
	}

	@Test(priority = 0, enabled = false)
	public void getTheCountOfAllGists()  {
		getGistEndPoint = new getGist();
		getGistEndPoint.getCountOfPrivateGists();	
		System.out.println(endPoints.baseEndPoint.gistCount);
	}
	
	@Test(priority = 1, enabled = false)
	public void createdNewGistAndValidateGistCount() throws IOException {
		getGistEndPoint = new getGist();
		int privateGistCountBefore = getGistEndPoint.getCountOfPrivateGists();	
		createGistEndPoint = new createGist();
		getGistEndPoint = new getGist();
		int privateGistCountAfter = getGistEndPoint.getCountOfPrivateGists();	
		assertEquals(privateGistCountAfter,privateGistCountBefore+1);
	}
	
	@Test(priority = 1, enabled = true)
	public void createGistThenDeleteIt() throws IOException {
		createGistEndPoint = new createGist();
		String gistIDToDelete = createGistEndPoint.extractGistIDFromResponse();
		deleteGistEndPoint = new deleteGist();
		int deleteStatusCode = deleteGistEndPoint.deleteExistingGist(gistIDToDelete).getStatusCode();
		Assert.assertEquals(deleteStatusCode,204);
	}
	
	@Test(priority = 1, enabled = true)
	public void createGistAndValidateDescriptionField() throws IOException {
		createGistEndPoint = new createGist();
		String gistDescriptionActual = createGistEndPoint.extractGistDescriptionFromResponse();//Actual value from response
		//Getting the description field from the request json file
		String requestBody = utility.genericFunctions.generateStringFromResource("src\\test\\resources\\gistPayload.json");
		JSONObject data = utility.genericFunctions.convertStringToJSON(requestBody);
		String gistDescriptionExpected = (String)data.get("description");
		Assert.assertEquals(gistDescriptionActual,gistDescriptionExpected);
	}
	
	@Test(priority = 1, enabled = true)
	public void createGistAndValidatePublicField() throws IOException {
		createGistEndPoint = new createGist();
		//Getting actual value from response
		String gistPublicOptionActual = String.valueOf(createGistEndPoint.extractGistPublicOptionFromResponse());
		System.out.println(gistPublicOptionActual);
		//Getting the public field from the request json file
		String requestBody = utility.genericFunctions.generateStringFromResource("src\\test\\resources\\gistPayload.json");
		JSONObject data = utility.genericFunctions.convertStringToJSON(requestBody);
		String gistPublicOptionExpected =String.valueOf(data.get("public"));
		Assert.assertEquals(gistPublicOptionActual,gistPublicOptionExpected);
	}

	@Test(priority = 1, enabled = true)
	public void makeSurePublicGistsAppearInPublicSearch() throws IOException {
		createGistEndPoint = new createGist();
		String gistID = createGistEndPoint.extractGistIDFromResponse();
		System.out.println(gistID);
		
		getGistEndPoint = new getGist();
		String response = getGistEndPoint.getAllGists().asString().toString();
		
		System.out.println(response);
		Assert.assertTrue(response.contains(gistID));
	}
	

	
}






































