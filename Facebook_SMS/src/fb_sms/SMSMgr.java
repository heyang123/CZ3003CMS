package fb_sms;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Sms;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

public class SMSMgr{
	public SMSMgr(){
		
	}
	// Find your Account Sid and Token at twilio.com/user/account
	public static final String ACCOUNT_SID = "AC6aad2973b48fd1d5ba8d51d01799d892";
	public static final String AUTH_TOKEN = "182711ac35c7c199a8081be2e6b83b2e";
	
	//check with PM if need return value. return value can be Sid.(means send successfully)
	public void sendSMS() throws TwilioRestException, JSONException{
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
		// Build a filter for the SmsList
		Map<String, String> params = new HashMap<String, String>();
		//get message content from MsgGenerator.generateMsg()
		MsgGenerator msgObj = new MsgGenerator();
		String msgBody = msgObj.generateMsg();
		params.put("Body", msgBody);
		params.put("To", "+6591093433"); //need to get PMO phone number from Database
		params.put("From", "+18127624919");
		SmsFactory messageFactory = client.getAccount().getSmsFactory();
		Sms message = messageFactory.create(params);
		System.out.println(message.getSid());
	}
	
	/*public static void main(String[] args) throws TwilioRestException, JSONException{
		SMSMgr testObj = new SMSMgr();
		testObj.SendSMS();
	}*/
	
}