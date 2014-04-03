package fb_sms;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import com.twilio.sdk.TwilioRestException;

public class SMSMgrTest {

	@Test
	public void test() throws TwilioRestException, JSONException {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("type", "haze");
		jsonObj.put("location", "JurongEast");
		jsonObj.put("details", "PM2.5 is 200");
		jsonObj.put("cds_location", "15 Nanyang Link");
		String hpNumber = "+6591093433";
		String a = SMSMgr.sendSMS(jsonObj, hpNumber);
		
		if (a == null){
			fail("Not send SMS successfullly");
		}
	}

}
