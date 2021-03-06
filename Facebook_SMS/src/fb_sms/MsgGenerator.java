package fb_sms;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.*;

public class MsgGenerator {
	public MsgGenerator(){
		
	}
	
	public String generateMsg(JSONObject jsonObj) throws JSONException{
		IncidentInfo incidentInfoObj = new IncidentInfo();
		//JSONObject jsonObj = incidentInfoObj.jsonGenerator();
		String a = incidentInfoObj.getIncidentType(jsonObj);
		String b = incidentInfoObj.getIncidentLocation(jsonObj);
		String c = incidentInfoObj.getIncidentDetails(jsonObj);
		String d = incidentInfoObj.getCdsLocation(jsonObj);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HH:mm:ss").format(Calendar.getInstance().getTime());
		String msgContent = "Message from CMS:\n"+ "Incident Type: "+a+"\nIncident Location: "+b+"\nIncident Details: "+c+"\n\nLocation of Civil Defence Shelters:\n"+d+"\n\nUpdated at "+ timeStamp ; 
	
		return msgContent;
	}
	
	/*public static void main(String[] args) throws JSONException{
		MsgGenerator testObj = new MsgGenerator();
		System.out.println(testObj.generateMsg());
	}*/
}