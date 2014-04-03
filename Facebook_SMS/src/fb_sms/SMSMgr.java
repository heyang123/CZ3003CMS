package fb_sms;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Sms;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONException;

public class SMSMgr{
	public SMSMgr() throws IOException{
		
	}
	// Find your Account Sid and Token at twilio.com/user/account
	
	public static String ACCOUNT_SID = null;
	public static String AUTH_TOKEN = null;
	
	static {
		try {
			Utility.getConfigs();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ACCOUNT_SID = Utility.sms_account_sid;
		AUTH_TOKEN = Utility.sms_auth_token;
	}
	
	//check with PM if need return value. return value can be Sid.(means send successfully)
	public static String sendSMS(JSONObject jsonObj, String hpNumber) throws TwilioRestException, JSONException{
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
		// Build a filter for the SmsList
		Map<String, String> params = new HashMap<String, String>();
		//get message content from MsgGenerator.generateMsg()
		MsgGenerator msgObj = new MsgGenerator();
		String msgBody = msgObj.generateMsg(jsonObj);
		params.put("Body", msgBody);
		params.put("To", hpNumber); //need to get PMO phone number from config.ini
		params.put("From", "+18127624919");
		SmsFactory messageFactory = client.getAccount().getSmsFactory();
		Sms message = messageFactory.create(params);
		System.out.println(message.getSid());
		return message.getSid();
	}
	
	/*public static void main(String[] args) throws TwilioRestException, JSONException{
		SMSMgr testObj = new SMSMgr();
		testObj.SendSMS();
	}*/
	
}