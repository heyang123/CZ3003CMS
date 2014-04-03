package fb_sms;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import com.twilio.sdk.TwilioRestException;

public class OutputMgrTest {

	@Test
	public void test() throws JSONException, TwilioRestException {
		OutputMgr output = new OutputMgr();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("type", "haze");
		jsonObj.put("location", "JurongEast");
		jsonObj.put("details", "PM2.5 is 200");
		
		String[] hpNumberArray = {"+6591093433","+6583599419"};
		output.outputSMS(jsonObj, hpNumberArray);
		JSONObject jsonObj0 = new JSONObject();
		jsonObj0.put("type", "haze");
		jsonObj0.put("location", "JurongEast");
		jsonObj0.put("details", "PM2.5 is 200");
		
		JSONObject jsonObj1 = new JSONObject();
		jsonObj1.put("type", "haze");
		jsonObj1.put("location", "NTU");
		jsonObj1.put("details", "PM2.5 is 200");
		
		JSONArray jsonArr = new JSONArray();
		jsonArr.put(0,jsonObj0);
		jsonArr.put(1,jsonObj1);
		
		String url = "http://www.packtpub.com/sites/default/files/SampleChapter-JasperReports.pdf";
		output.outputFB(jsonArr, url);
		System.out.println(jsonArr);
		}
		//fail("Not yet implemented");

}
