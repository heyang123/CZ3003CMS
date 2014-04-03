package fb_sms;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;


public class FacebookMgrTest {

	@Test
	public void test() throws JSONException {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("type", "haze");
		jsonObj.put("location", "JurongEast");
		jsonObj.put("details", "PM2.5 is 200");
		jsonObj.put("cds_location", "15 Nanyang Link");
		
		String a = FacebookMgr.post2FbPage(jsonObj);
		if (a==null){
			fail("Not post to facebook successfully");
		}
		
	}

}
