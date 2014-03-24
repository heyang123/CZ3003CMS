package fb_sms;
import org.json.JSONException;
import org.json.JSONObject;


public class IncidentInfo{
	
	public IncidentInfo() {

	}
	// this method is used to generate a JSON object for testing purpose
	/*public JSONObject jsonGenerator() throws JSONException{
		JSONObject obj = new JSONObject();
		obj.put("type", "haze");
		obj.put("location", "JurongEast");
		obj.put("details", "PM2.5 is 200");
		//System.out.print(obj);
		return obj;
	}*/
	
	//these three methods below need to check with Database
	public String getIncidentType(JSONObject jsonObj) throws JSONException{
		String type = jsonObj.getString("type");
		return type;
		
	}
	
	public String getIncidentLocation(JSONObject jsonObj) throws JSONException{
		String location = jsonObj.getString("location");
		return location;
	}
	
	public String getIncidentDetails(JSONObject jsonObj) throws JSONException{
		String details = jsonObj.getString("details");
		return details;
	}
	


	/*public static void main(String[] args) throws JSONException{
		IncidentInfo testObj = new IncidentInfo();
		JSONObject a = testObj.jsonGenerator();
		System.out.println(testObj.getIncidentType(a));
		System.out.println(testObj.getIncidentLocation(a));
		System.out.println(testObj.getIncidentDetails(a));
		
	}*/

}