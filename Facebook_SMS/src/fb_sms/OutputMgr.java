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
	
	public void outputSMS(JSONObject jsonobj, String[] hpNumberArray) throws TwilioRestException, JSONException{
		for (int i = 0; i < hpNumberArray.length; i++) {
	         System.out.println(hpNumberArray[i] + " ");
	         SMSMgr.sendSMS(jsonobj,hpNumberArray[i]);
	      }
		
	}
	
	/*public static void main(String[] args) throws JSONException, TwilioRestException{
		OutputMgr output = new OutputMgr();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("type", "haze");
		jsonObj.put("location", "JurongEast");
		jsonObj.put("details", "PM2.5 is 200");
		
		String[] hpNumberArray = {"+6591093433","+6583599419"};
		output.outputSMS(jsonObj, hpNumberArray);
	}*/
	/*
	public static void main(String[] args) throws JSONException, TwilioRestException{
	OutputMgr output = new OutputMgr();

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
	*/
}