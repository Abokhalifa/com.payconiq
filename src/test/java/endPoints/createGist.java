package endPoints;

import java.io.IOException;

import net.minidev.json.JSONObject;
import utility.genericFunctions;


public class createGist extends baseEndPoint {

	private static final String basePath = "/gists";
	private String gistBody;
	private String gistID;
	private boolean publicOption;
	private String gistDescription; 

	public createGist() throws IOException
	{
		gistBody = genericFunctions.generateStringFromResource("src\\test\\resources\\gistPayload.json");
		response = doPostRequest(basePath,gistBody);
	}

	
	public String extractGistDescriptionFromResponse() {
		
		String responseBody = endPoints.baseEndPoint.response.asString().toString();
		JSONObject data = utility.genericFunctions.convertStringToJSON(responseBody);
		gistDescription = (String)data.get("description");
		return gistDescription;
	}

	
	public String extractGistIDFromResponse() {
		String responseBody = endPoints.baseEndPoint.response.asString().toString();
		JSONObject data = utility.genericFunctions.convertStringToJSON(responseBody);
		gistID = (String)data.get("id");
		System.out.println(gistID);
		return gistID;
	}

	
	public boolean extractGistPublicOptionFromResponse() {
		String responseBody = endPoints.baseEndPoint.response.asString().toString();
		JSONObject data = utility.genericFunctions.convertStringToJSON(responseBody);
		publicOption = (Boolean) data.get("public");
		System.out.println(publicOption);
		return publicOption;
	}

	


}







































