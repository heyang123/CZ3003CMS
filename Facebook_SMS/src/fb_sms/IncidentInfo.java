package fb_sms;
import org.json.JSONException;
import org.json.JSONObject;


public class IncidentInfo{
	
	public IncidentInfo() {

	}
	
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
	// cds refers Civil Defense Shelter
	public String getCdsLocation(JSONObject jsonObj) throws JSONException{
		String cds_location = jsonObj.getString("cds_location");
		return cds_location;
	}

}