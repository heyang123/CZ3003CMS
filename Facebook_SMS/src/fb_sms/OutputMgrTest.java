package fb_sms;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import com.twilio.sdk.TwilioRestException;

public class OutputMgrTest {

	@Test
	public void test() throws JSONException, TwilioRestException {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("type", "haze");
		jsonObj.put("location", "JurongEast");
		jsonObj.put("details", "PM2.5 is 200");
		
		OutputMgr testobj = new OutputMgr();
		testobj.outputAll(jsonObj);
		
		fail("Not yet implemented");
	}

}
