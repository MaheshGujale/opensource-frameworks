package resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;


@ApplicationPath("/app")
@Path("rule")
public class RuleTester extends Application{
	
	private Map<String, String> keyValueMap = new HashMap<String, String>();
	private JSONObject jSonObj= new JSONObject();
	
	@POST
	@Produces("application/json")
	@Path("preprocessing")
	public JSONObject preProcessing(String req) throws IOException{
		String inputStr = req;
		String[] keyValueArr = new String[2];
		if(inputStr !=null && !inputStr.equals("")){
			Scanner s = new Scanner(req);
			String line = "";
			while(s.hasNextLine()){
				line = s.nextLine();
				keyValueArr = line.split("=");
				jSonObj.put(keyValueArr[0], keyValueArr[1]);
			}
		}
		return jSonObj;
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("postprocessing")
	public String postProcessing(){
		return "";
	}

	/*private String getJSonData(Map<String, String> kvMap){
		String returnStr = "{\n";
		for (Map.Entry<String, String> entry : kvMap.entrySet())
		{
		    returnStr = returnStr + entry.getKey() + ":" + entry.getValue() + "\n";
		}
		returnStr = returnStr + "}";
		System.out.println(returnStr);
		return returnStr;
	}*/
	
}
