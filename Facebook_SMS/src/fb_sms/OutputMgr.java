package fb_sms;

import org.json.JSONException;
import org.json.JSONObject;

import com.twilio.sdk.TwilioRestException;

public class OutputMgr {
	public OutputMgr(){
		
	}
	public void outputAll(JSONObject jsonObj) throws JSONException, TwilioRestException{
	//post to fb page
	//FacebookMgr fb = new FacebookMgr();
	FacebookMgr.post2FbPage(jsonObj);
	
	//send SMS
	//SMSMgr sms = new SMSMgr();
	SMSMgr.sendSMS(jsonObj);
	}
	
	/*public static void main(String[] args) throws JSONException, TwilioRestException{
		OutputMgr output = new OutputMgr();
		output.outputAll();
	}*/
}