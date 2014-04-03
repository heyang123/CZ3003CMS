package fb_sms;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class IncidentInfoTest {

	@Test
	public void test() throws JSONException {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("type", "haze");
		jsonObj.put("location", "JurongEast");
		jsonObj.put("details", "PM2.5 is 200");
		jsonObj.put("cds_location", "30 Boon Lay Way");
		
		IncidentInfo testObj = new IncidentInfo();
		String a = testObj.getIncidentType(jsonObj);
		String b = testObj.getIncidentLocation(jsonObj);
		String c = testObj.getIncidentDetails(jsonObj);
		String d = testObj.getCdsLocation(jsonObj);
		
		if (a == null){
			fail("Wrong with getIncidentType()");
			}
		
		if(b == null){
			fail("Wrong with getIncidentLocation()");
		}
		
		if (c == null){
			fail("Wrong with getIncidentDetails()");
		}
		
		if (d == null){
			fail("Wrong with getCdsLocation()");
		}
		
	}

}
