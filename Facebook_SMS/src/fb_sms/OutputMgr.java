package fb_sms;

import org.json.JSONException;

import com.twilio.sdk.TwilioRestException;

public class OutputMgr {
	public OutputMgr(){
		
	}
	public void outputAll() throws JSONException, TwilioRestException{
	//post to fb page
	FacebookMgr fb = new FacebookMgr();
	fb.post2FbPage();
	
	//send SMS
	SMSMgr sms = new SMSMgr();
	sms.sendSMS();
	}
	
	/*public static void main(String[] args) throws JSONException, TwilioRestException{
		OutputMgr output = new OutputMgr();
		output.outputAll();
	}*/
}