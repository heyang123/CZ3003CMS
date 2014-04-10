package fb_sms;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.twilio.sdk.TwilioRestException;

public class OutputMgr {
	public OutputMgr(){
		
	}
	/*
	public void outputAll(JSONObject jsonObj) throws JSONException, TwilioRestException{
	//post to fb page
	//FacebookMgr fb = new FacebookMgr();
	FacebookMgr.post2FbPage(jsonObj);
	
	//send SMS
	//SMSMgr sms = new SMSMgr();
	//SMSMgr.sendSMS(jsonObj);
	}*/
	
	public void outputFB(JSONArray jsonArr, String JasperReportsUrl) throws JSONException{
		//post to Fb page based on JSON object
		for(int i=0; i< jsonArr.length(); i++)
			FacebookMgr.post2FbPage(jsonArr.getJSONObject(i));
		
		//post JasperReports url to Fb page 
		FacebookMgr.post2FbPageJasperReports(JasperReportsUrl);
	}
	
	public void outputSMS(JSONArray jsonArr, String[] hpNumberArray) throws TwilioRestException, JSONException{
		for(int i=0; i< jsonArr.length(); i++){
			for (int j = 0; j < hpNumberArray.length; j++) {
	         //System.out.println(hpNumberArray[i] + " ");
	         SMSMgr.sendSMS(jsonArr.getJSONObject(i),hpNumberArray[j]);
	      }
		}
		
	}
	
}