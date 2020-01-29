package utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

public class genericFunctions {
	public static String generateStringFromResource(String path) throws IOException {

	    return new String(Files.readAllBytes(Paths.get(path)));

	}
	
	public static JSONObject convertStringToJSON(String body) {
		
		JSONObject data = (JSONObject)JSONValue.parse(body);
		return data;
		
	}

}
