package endPoints;

import io.restassured.response.Response;

public class deleteGist extends baseEndPoint {
	

	
	private static final String basePath = "/gists";
	
	public Response deleteExistingGist(String gistID) {
		
		response = doDeleteRequest(basePath, gistID);
		return response;
	}
	



}
